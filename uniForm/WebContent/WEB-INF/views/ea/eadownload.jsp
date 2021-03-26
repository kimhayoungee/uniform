<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.uniform.common.utils.FileReadUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>다운로드</title>
	</head>
	<body>
<%
	Object obj = request.getAttribute("file");
	String file = (String) obj;
	
	request.setAttribute("file", file);
	
	try{
		FileReadUtil.readFile(request, response);
	}catch(Exception e){}

%>	
	</body>
</html>