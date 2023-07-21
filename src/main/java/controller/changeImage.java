package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import database.KhachHangDAO;
import model.KhachHang;


/**
 * Servlet implementation class changeImage
 */
@WebServlet("/changeImage")
public class changeImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("123");
		Object obj = request.getSession().getAttribute("khachHang");
		KhachHang khachHang = null;
		if (obj != null)
			khachHang = (KhachHang) obj;
		try {
			String forder = getServletContext().getRealPath("avatar");
			
			File file;
			int maxSize =5000*1024; //kích cỡ ảnh
			int maxMemSize = 5000*1024;// 
			
			String  contentType = request.getContentType();
			if(contentType.indexOf(contentType)>0) {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				
				//quy định dung lượng tối đa của 1 file
				factory.setSizeThreshold(maxMemSize);
				
				//tạo file
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setSizeMax(maxMemSize);
				
				List<FileItem> files = upload.parseRequest(request);
				
				System.out.println(forder);
				
				for(FileItem fileItem: files) {
					if(!fileItem.isFormField()) {// kiểm tra xem có phải 1 file hay không
						String fileName = System.currentTimeMillis()+ fileItem.getName();
						String path = forder+"\\" +fileName;
						file = new File(path);
						
						fileItem.write(file);
						
						khachHang.setDuongDanAnh(fileName);
						KhachHangDAO khachHangDAO = new KhachHangDAO();
						khachHangDAO.updateImage(khachHang);
						khachHang = khachHangDAO.selectByID(khachHang);
					}else {
						String name =fileItem.getFieldName();
						String value = fileItem.getString();
						System.out.println(name+" : "+ value);
					}
					
				}
			
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
