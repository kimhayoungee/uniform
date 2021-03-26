<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.uniform.mm.message.vo.MmMessageVO" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
<%
	HttpSession hs = request.getSession();
	String i_no = (String)hs.getAttribute("i_no");
	MmMessageVO mmvo = (MmMessageVO)request.getAttribute("mmvo");
	String mm_recipient = mmvo.getMm_recipient();
%>	
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>쪽지보내기</title>
		<script type="text/javascript"
				src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#insert_btn").on("click",function(){
					var message = $("#message").val();
					var i_no = "<%=i_no%>";
					var recipient = "<%=mm_recipient%>";
					
					if(message==null||message==""){
						alert("내용을 입력해 주세요");
						return false;
					}
					
					callInsertMessage(recipient,message,i_no)
				});
				
			});
			
			function callInsertMessage(recipient,message,i_no){
				$.ajax({
					url:"/mm/insertMessage.uni",
					type:"POST",
					data:{
						mm_recipient:recipient,
						mm_message:message,
						i_no:i_no
					},
					success:function(data){
						alert(data);
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
		<h2>쪽지쓰기</h2>
		<p>
		<input type="button" id="insert_btn" value="보내기">
		<br>
		<br>
		받는사람
		<input type="text" value="<%=mmvo.getI_nameKr() %>" disabled>
		<br>
		<br>
		내용<br>
		<textarea rows="5" cols="55" id="message"></textarea>
	</body>
</html>