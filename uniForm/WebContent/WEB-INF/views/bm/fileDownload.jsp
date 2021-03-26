<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.uniform.bm.board.utils.FileReadUtil"  %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
					  "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>첨부파일 다운로드 중...</title>
	</head>
	<body>
		<%
			String path = (String)request.getAttribute("path");
			String bm_file = (String)request.getAttribute("bm_file");
			
			request.setAttribute("path",path);
			request.setAttribute("bm_file",bm_file);
			
			FileReadUtil fru = new FileReadUtil();
			fru.readFile(request, response);
		%>
	</body>
</html>