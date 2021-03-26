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
	</head>
	<body>
<%
	if(itotal>0){
%>	
		<div class="paging">
<%
		if(icurPage>1){
%>
			<span class="btnFirst"><a href="javascript:goListNotice('1')">◀</a></span>
<%			
		}else{
%>
			<span class="btnFirst"><a href="#">◀</a></span>
<%			
		}

		if(prevLast>0){
%>		
			<span class="btnPrev"><a href="javascript:goListNotice(<%=prevLast%>)">◁</a></span>
<%
		}else{
%>			
			<span class="btnPrev"><a href="#">◁</a></span>
<%
		}
%>		
		<ul class="pager">
<%		
		for(int i=currentFirst;i<currentFirst+pageSize&&i<=lastPage;i++){
			if(i==icurPage){
%>
				<li class="on"><a href="#"><%=i %></a></li>
<%				
			}else{
%>
				<li><a href="javascript:goListNotice(<%=i%>)"><%=i %></a></li>
<%				
			}
		}
%>		
		</ul>
<%			
		if(nextFirst<=lastPage){
%>
			<span class="btnNext"><a href="javascript:goListNotice(<%=nextFirst%>)">▷</a></span>
<%			
		}else{
%>
			<span class="btnNext"><a href="#">▷</a></span>
<%			
		}
		
		if(icurPage<lastPage){
%>
			<span class="btnEnd"><a href="javascript:goListNotice(<%=lastPage%>)">▶</a></span>
<%			
		}else{
%>
			<span class="btnEnd"><a href="#">▶</a></span>
<%			
		}
%>			
		</div>
	</body>
<%
	}
%>	
</html>