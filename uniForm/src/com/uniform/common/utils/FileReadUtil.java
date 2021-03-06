package com.uniform.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileReadUtil {
	
//	private static final String PATH = "C:/Users/rlawl_000/Desktop/projectU/workspace/uniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniform/ea/files";
			//"C:/Users/rlawl_000/Desktop/projectU/workspace/uniform/uniform/WebContent/ea/files";
	private static final String PATH = "D:/00.BITCAMP/java142Uniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniForm/ea/files";
	public static void readFile(HttpServletRequest req
							   ,HttpServletResponse resp) throws IOException{
		req.setCharacterEncoding("UTF-8");
		
		String fileName = (String)req.getAttribute("file");
		String filePath = PATH + "/" + fileName;
		
		File file = new File(filePath);
		
		if(file.isDirectory()){
			return;
		}
		
		long fileSize = file.length();
		if(fileSize>Integer.MAX_VALUE){
			System.out.println("File size is too big"); 
			return ;
		}
		
		//mimetype
		String mimeType;
		String disposition = "filename=\"" + filePath + "\"";
		
		if(filePath.toLowerCase().endsWith("xml")){
			mimeType = "text/xml;charset=utf-8";
		}else if(filePath.toLowerCase().endsWith("doc")){
			mimeType = "application/msword";
		}else if(filePath.toLowerCase().endsWith("xls")){
			mimeType = "application/vnd.ms-excel";
		}else if(filePath.toLowerCase().endsWith("xlsx")){
			mimeType = "application/x-msexcel";
		}else if(filePath.toLowerCase().endsWith("hwp")){
			mimeType = "application/octet-stream";
		}else if(filePath.toLowerCase().endsWith("gif")){
			mimeType = "image/gif";
		}else if(filePath.toLowerCase().endsWith("jpg")){			
			mimeType = "image/jpeg";
		}else{
			mimeType = "application/octet-stream";
		}
		
		resp.setBufferSize(0);
		
		fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		resp.setHeader("Content-Disposition", "attachment; filename=" + fileName + ";");
		resp.setHeader("Content-Transfer-Encoding", "7bit");
		resp.setHeader("Accept-Ranges", "bytes");
		resp.setContentLength((int)fileSize);
		resp.setHeader("Connection", "close");
		resp.setContentType(mimeType + ";charset=UTF-8");

		FileInputStream in = new FileInputStream(file);
		
		final int BUF_SIZE = 8 * 1024;
		final OutputStream out = resp.getOutputStream();
		final byte[] buf = new byte[BUF_SIZE];
		int n;
		
		while(-1 != (n = in.read(buf)))
		{
			out.write(buf, 0, n);
		}
		out.flush();
	
	}
	
	
}
