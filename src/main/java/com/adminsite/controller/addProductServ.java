package com.adminsite.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.adminsite.dao.ProductDao;
import com.adminsite.entity.ProductEntity;

/**
 * Servlet implementation class addProductServ
 */
@WebServlet("/addProductServ")
public class addProductServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductDao dao = new ProductDao();
    private static final int MAX_MEMORY_SIZE = 1024 * 1024 * 2;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024;
    private String img, name;
    private int price, category_id;
    private int count = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addProductServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//				Upload image to product folder
//				Check that we have a file upload request
		        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		        if (!isMultipart) {
		            return;
		        }

		        // Create a factory for disk-based file items
		        DiskFileItemFactory factory = new DiskFileItemFactory();

		        // Sets the size threshold beyond which files are written directly to
		        // disk.
		        factory.setSizeThreshold(MAX_MEMORY_SIZE);

		        // Sets the directory used to temporarily store files that are larger
		        // than the configured size threshold. We use temporary directory for
		        // java
		        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		        // constructs the folder where uploaded file will be stored
		        String uploadFolder = "D:/Studying/2016/SE/Project/WatchShop/WebContent/images";

		        // Create a new file upload handler
		        ServletFileUpload upload = new ServletFileUpload(factory);

		        // Set overall request size constraint
		        upload.setSizeMax(MAX_REQUEST_SIZE);
		        try {
		            // Parse the request
		        	//ProductEntity p = new ProductEntity();
		            List items = upload.parseRequest(request);
		            Iterator iter = items.iterator();
//		            while(iter.hasNext()){
//		            	count++;
//		            }
		            //response.getWriter().write(count);
		            
		            while (iter.hasNext()) {
		                FileItem item = (FileItem) iter.next();
		               

		                if (!item.isFormField()) {
		                    String fileName = new File(item.getName()).getName();
		                    String filePath = uploadFolder + File.separator + fileName;
		                    File uploadedFile = new File(filePath);
		                    //response.getWriter().write(filePath);  
		                    // saves the file to upload directory
		                   // p.setImage(fileName);
		                    img = fileName;
		                    item.write(uploadedFile);
		                    
		                }else{
		                	String fieldName = item.getFieldName();
		              	  	String value = item.getString();
		                	if(fieldName.equals("productName")){
		                		//p.setName(value);
		                		name = value;
		                		
		                	}else if(fieldName.equals("productCate")){
		                		//p.setCategoryID(Integer.parseInt(value));
		                		category_id = Integer.parseInt(value);
		                	}else if(fieldName.equals("productPrice")){
		                		//p.setPrice(Integer.parseInt(value));
		                		price = Integer.parseInt(value);
		                	}
		                }
		                count ++;
		            }
		            // displays done.jsp page after upload finished
		            if(count < 4){
		            	response.sendRedirect(request.getContextPath() + "/ProductServ");
		            }else{
		            	dao.AddProduct(new ProductEntity(name,category_id,price,img));
			           //dao.AddProduct(p.getName(), p.getCategoryID(), p.getPrice(), p.getImage());
			           //request.getRequestDispatcher("ProductServ").forward(request, response);
			           response.sendRedirect(request.getContextPath() + "/ProductServ");
		            }
		           

		        } catch (FileUploadException ex) {
		            throw new ServletException(ex);
		        } catch (Exception ex) {
		            throw new ServletException(ex);
		        }
		
		
		
		
		
	}

}
