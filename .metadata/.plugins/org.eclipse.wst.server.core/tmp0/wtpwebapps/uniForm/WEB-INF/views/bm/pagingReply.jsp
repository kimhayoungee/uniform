<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
<%
	String replyTotal = request.getParameter("replyTotal");
	String curReplyPage = request.getParameter("curReplyPage");
	
	int ireplyTotal = Integer.parseInt(replyTotal);
	int icurReplyPage = Integer.parseInt(curReplyPage);
	int listSize = 20;
	int pageSize = 10;
	
	int currentFirst = ((icurReplyPage-1)/pageSize)*pageSize + 1;
	int currentLast = ((icurReplyPage-1)/pageSize)*pageSize + pageSize;
	int nextFirst = (((icurReplyPage-1)/pageSize)+1)*pageSize + 1;
	int prevLast = (((icurReplyPage-1)/pageSize)-1)*pageSize + 1;
	
	int lastPage = 1;
	lastPage = ireplyTotal/listSize;
	
	if(ireplyTotal%listSize!=0){
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
	if(ireplyTotal>0){
%>	
		<div align="center" class="paging">
<%
		if(icurReplyPage>1){
%>
			<a href="javascript:goReplyList('1')">◀</a>
<%			
		}else{
%>
			<a href="#">◀</a>
<%			
		}

		if(prevLast>0){
%>		
			<a href="javascript:goReplyList(<%=prevLast%>)">◁</a>
<%
		}else{
%>			
			<a href="#">◁</a>
<%
		}
		
		for(int i=currentFirst;i<currentFirst+pageSize&&i<=lastPage;i++){
			if(i==icurReplyPage){
%>
				<a href="#"><%=i %></a>
<%				
			}else{
%>
				[<a href="javascript:goReplyList(<%=i%>)"><%=i %></a>]
<%				
			}
		}
		
		if(nextFirst<=lastPage){
%>
			<a href="javascript:goReplyList(<%=nextFirst%>)">▷</a>
<%			
		}else{
%>
			<a href="#">▷</a>
<%			
		}
		
		if(icurReplyPage<lastPage){
%>
			<a href="javascript:goReplyList(<%=lastPage%>)">▶</a>
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