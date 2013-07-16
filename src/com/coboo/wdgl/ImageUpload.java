package com.coboo.wdgl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.coboo.base.Bean_BaseInfo;
import com.common.Common;
import com.common.HibernateDBManager;



public class ImageUpload extends HttpServlet {
	
	/**
     * 处理 HTTP GET 和 POST 请求.
     * @param request servlet request
     * @param response servlet response
     */

    private String uploadPath = "d:\\imageUpload\\";

    private int maxPostSize = 99 * 1024 * 1024;

    public ImageUpload() {
        super();
    }

    public void destroy() {
        super.destroy();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String osname = System.getProperty("os.name").toString(); 
		String filename = "";
		String realPath = Bean_BaseInfo.coboodir;
		System.out.println("ImageUpload:"+realPath);
		
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		if(osname.toLowerCase().startsWith("windows")){
			System.out.println("<Windows>" + request.getContentLength()+ ":");
			uploadPath = realPath + "\\imageUpload\\";
		}else{
		    realPath = realPath.substring(0,realPath.lastIndexOf("/"));
			System.out.println("<Linux>" + request.getContentLength() + ":");
			uploadPath = realPath + "/imageUpload/";
		}
		CreateFileDir.CreateDir(uploadPath);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(4096);
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(maxPostSize);
		
		//Date mydate = new Date();
		
		try {
		    List fileItems = upload.parseRequest(request);
		    Iterator iter = fileItems.iterator();
		    while (iter.hasNext()) {
		        FileItem item = (FileItem) iter.next();
		        if (!item.isFormField()) {
		        	filename = item.getName();
		        	//filename = String.valueOf(mydate.getTime()) + filename.substring(filename.indexOf("."));
		        	System.out.println(filename);
		            try {
		                item.write(new File(uploadPath + filename));
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
		        }
		    }
		    
		} catch (FileUploadException e) {
		    e.printStackTrace();
		    System.out.println(e.getMessage() + "����");
		    db.commit();
		    db.close();
		}
		db.commit();
		db.close();
	}
    /**
     * 以GET方式传输参数.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * 以POST方式传输参数.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * 返回servlet的描述信息.
     */
    public String getServletInfo() {
        return "Short description";
    }
}
