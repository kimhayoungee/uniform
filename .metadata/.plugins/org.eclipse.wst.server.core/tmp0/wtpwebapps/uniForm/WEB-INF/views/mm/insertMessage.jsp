<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>쪽지 보내기</title>
<%
	HttpSession hs = request.getSession();
	String i_no = (String)hs.getAttribute("i_no");
%>			
		<script type="text/javascript"
				src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#search").keyup(function(){
					var name = $("#search").val();
					
					if(name!=""){
						callSearch(name);
					}else{
						return false;
					}
				});
				
				$("#insert_btn").on("click",function(){
					var list = $("#list").val();
					var message = $("#message").val();
					var i_no = "<%=i_no%>";
					
					if(list.indexOf("선택")>-1){
						alert("수신인을 입력해 주세요");
						return false;
					}else if(list==i_no){
						alert("자신에게 보낼 수 없습니다.");
						return false;
					}
					
					if(message==null||message==""){
						alert("내용을 입력해 주세요");
						return false;
					}
					
					callInsertMessage(list,message,i_no);
				});
				
			});
			
			function callInsertMessage(list,message,i_no){
				$.ajax({
					url:"/mm/insertMessage.uni",
					type:"POST",
					data:{
						mm_recipient:list,
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
			
			function callSearch(name){
				$.ajax({
					url:"/em/searchName.uni",
					type:"POST",
					dataType:"json",
					data:{
						i_nameKr:name
					},
					success:function(data){
						$("#list").empty();
						var select = $("<option>선택</option>");
						$("#list").append(select);
						for(var i=0;i<data.length;i++){
							var i_no = data[i].i_no;
							var tag = $("<option value="+i_no+">" + data[i].i_nameKr + "</option>");
							$("#list").append(tag);
						}
					},
					error:function(request,status,error){
						alert("에러났다 >> : " + request.status + " : error=" + error);
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
		<input type="text" id="search" placeholder="이름 검색">
		<select id="list">
			<option>선택</option>
		</select>
		<br>
		<br>
		내용<br>
		<textarea rows="5" cols="55" id="message" title="쪽지 내용을 입력해 주세요"></textarea>
	</body>
</html>