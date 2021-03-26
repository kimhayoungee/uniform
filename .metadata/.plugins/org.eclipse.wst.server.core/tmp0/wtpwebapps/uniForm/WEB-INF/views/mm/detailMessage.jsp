<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.uniform.mm.message.vo.MmMessageVO" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
<%
	MmMessageVO mmvo = (MmMessageVO)request.getAttribute("detailVO");
	String mm_recipient = mmvo.getI_no();
	String i_nameKr = mmvo.getI_nameKr();
	String mm_no = mmvo.getMm_no();
%>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>쪽지 확인</title>
		<script type="text/javascript"
				src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#return_btn").on("click",function(){
					var mm_recipient = "<%=mm_recipient%>";
					// 쿼리 스트링으로 한글 넘길시 데이터 encodeURI 해서 넘기면 잘 넘어감
					var i_nameKr = encodeURI("<%=i_nameKr%>");
					
					alert("확인 >> : " + mm_recipient + " : " + i_nameKr);
					
					location.href="/mm/goReturnMessage.uni?mm_recipient=" + mm_recipient + "&i_nameKr=" + i_nameKr;
				});
				
				$("#delete_btn").on("click",function(){
					var mm_no = "<%=mm_no%>";
					if(confirm("삭제 하시겠습니까?")){
						alert("삭제하러");
						callDetailDelete(mm_no);
					}else{
						return false;
					}
				});
			});
			
			function callDetailDelete(mm_no){
				$.ajax({
					url:"/mm/deleteMessage.uni",
					type:"POST",
					data:{
						mm_no:mm_no
					},
					success:function(data){
						alert(data);
						opener.goMessageMain();
						window.close();
					},
					error:function(request,status,error){
						alert("에러났다 >>> : " + request.status + " : error=" + error);
					}
				});
			}
		</script>		
	</head>
	<body>
		<h2>쪽지확인</h2>
		<p>
		<input type="button" id="return_btn" value="답장">
		<input type="button" id="delete_btn" value="삭제">
		<p>
		<strong>보낸사람</strong> <%=i_nameKr %>
		<br>
		<br>
		받은시간 <%=mmvo.getMm_insertDate() %>
		<br>
		<br>
		내용<br>
		<textarea rows="5" cols="55" disabled><%=mmvo.getMm_message() %></textarea>
	</body>
</html>