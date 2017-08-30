package com.cy.test;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 下载文件的serverlet
 */
public class DownloadServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext context = this.getServletContext();
		String fileName = request.getParameter("name");
		String mimeType = context.getMimeType(fileName);

		response.setContentType(mimeType);
		System.out.println("name=" + fileName + ",type=" + mimeType);
		response.setHeader("content-disposition", "attachment;filename=" + fileName);
		InputStream is = context.getResourceAsStream("/download/" + fileName);
		ServletOutputStream os = response.getOutputStream();
		int len = -1;
		byte[] b = new byte[1024];
		while ((len = is.read(b)) != -1) {
			os.write(b, 0, len);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
