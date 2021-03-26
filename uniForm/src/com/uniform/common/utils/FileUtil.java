package com.uniform.common.utils;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileUtil {
	
	private static final String PATH = 
//			"C:/L_work/java142Uniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniForm";
//			"C:/Users/이상훈/Desktop/java142Uniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniForm";
			"D:/00.BITCAMP/java142Uniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniForm";
	
	public static String fileUpload(HttpServletRequest request,String upload)throws Exception{
		
		upload = PATH + upload;
		
		int size = 10*1024*1024;
		
		MultipartRequest mr = new MultipartRequest(request,upload,size,"UTF-8",new DefaultFileRenamePolicy());
		Enumeration<String> et = mr.getFileNames();
		String file_path = "";
		while(et.hasMoreElements()){
			String file = et.nextElement();
			file_path = mr.getFilesystemName(file);
			
			File f = new File(PATH+mr.getParameter("old_img"));
			boolean delete = f.delete();
			System.out.println("파일 삭제 >>> : " + delete);
		}
		
		if(file_path==null||file_path==""){
			file_path = mr.getParameter("old_img");
		}
		
		return file_path;
	} // end of fileUpload() 함수
	
}// end FileUpload class
