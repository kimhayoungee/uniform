<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ page import="com.uniform.ea.approval.controller.EaApprovalController"  %>
<%@ page import="com.uniform.common.utils.FileReadUtil"  %>
<%@ page import="com.uniform.ea.approval.vo.EaPoomVO"  %>
<%@ page import="java.util.ArrayList"  %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>���� �ٿ�ε� ���̴�</title>
	</head>
	<body>
		
	<%
	
				Object filePath = request.getAttribute("FilePath");
				filePath = (String)filePath;
				
				Object fileName = request.getAttribute("fileName");
				fileName = (String)fileName;
				
				request.setAttribute("filePath", filePath);
				request.setAttribute("fileName" ,fileName);
				
				FileReadUtil fru = new FileReadUtil();
				fru.readFile(request, response);
				
				
	
	%>
        
	</body>
</html>