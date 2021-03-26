<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
<%
	String total = request.getParameter("total");
	String curPage = request.getParameter("curPage");
	
	int itotal = Integer.parseInt(total);
	int icurPage = Integer.parseInt(curPage);
	int listSize = 10;
	int pageSize = 10;
	
	int currentFirst = ((icurPage-1)/pageSize)*pageSize + 1;
	int currentLast = ((icurPage-1)/pageSize)*pageSize + pageSize;
	int nextFirst = (((icurPage-1)/pageSize)+1)*pageSize + 1;
	int prevLast = (((icurPage-1)/pageSize)-1)*pageSize + 1;
	
	int lastPage = 1;
	lastPage = itotal/listSize;
	
	if(itotal%listSize!=0){
		lastPage = lastPage + 1;
	}
	
	currentLast = (currentLast>lastPage)?lastPage:currentLast;
%>	
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			a{text-decoration:none;}
		</style>
	</head>
	<body>
<%
	if(itotal>0){
%>	
		<div align="center" class="paging">
<%
		if(icurPage>1){
%>
			<a href="javascript:goMessageMain('1')">◀</a>
<%			
		}else{
%>
			<a href="#">◀</a>
<%			
		}

		if(prevLast>0){
%>		
			<a href="javascript:goMessageMain(<%=prevLast%>)">◁</a>
<%
		}else{
%>			
			<a href="#">◁</a>
<%
		}
		
		for(int i=currentFirst;i<currentFirst+pageSize&&i<=lastPage;i++){
			if(i==icurPage){
%>
				<a href="#"><%=i %></a>
<%				
			}else{
%>
				[<a href="javascript:goMessageMain(<%=i%>)"><%=i %></a>]
<%				
			}
		}
		
		if(nextFirst<=lastPage){
%>
			<a href="javascript:goMessageMain(<%=nextFirst%>)">▷</a>
<%			
		}else{
%>
			<a href="#">▷</a>
<%			
		}
		
		if(icurPage<lastPage){
%>
			<a href="javascript:goMessageMain(<%=lastPage%>)">▶</a>
<%			
		}else{
%>
			<a href="#">▶</a>
<%			
		}
%>			
		</div>
	</body>
<%
	}
%>	
</html>