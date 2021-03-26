<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>비밀번호 변경</title>
<%
	HttpSession hs = request.getSession();
	String i_no = (String)hs.getAttribute("i_no");
%>		
		<script type="text/javascript"
				src="/include/js/jquery-1.11.0.min.js"></script>
		<script type="text/javascript">
			var i_no = "<%=i_no%>";
			$(document).ready(function(){
				$(".second").hide();
				
				$("#em_pw2").keyup(function(){
					var em_pw = $("#em_pw").val();
					var em_pw2 = $("#em_pw2").val();

					var pwBool = em_pw==em_pw2&&em_pw.length==em_pw2.length;
					if(pwBool){
						$(".html").html("비밀번호가 일치합니다");
					}else{
						$(".html").html("비밀번호가 일치하지 않습니다");
					}
				});
				
				$("#pwChk").on("click",function(){
					var pw = $("#pw").val();
					
					if(pw.length==0&&pw==null){
						alert("비밀번호를 입력해 주세요");
						return false;
					}else{
						callpwChk(pw);
					}
				});
				
				$("#em_pw").keyup(function(){
					var len = $("#em_pw").val().length;
					if(len>=5){
						$("#em_pw2").attr("disabled",false);
					}else{
						$("#em_pw2").attr("disabled",true);
						$("#em_pw2").val("");
						$(".html").html("비밀번호가 일치하지 않습니다");
					}
				});
				
				
				$("#change").on("click",function(){
					var disabled = $("#em_pw2").prop("disabled");
					var len = $("#em_pw").val().length;
					
					if(len>=5&&!disabled){
						var pwtext = $(".html").html();
						if(pwtext.indexOf("않습니다")>-1){
							alert("재입력 비밀번호가 일치하지 않습니다");
							return false;
						}else{
							callUpdatePw();
						}
					}else{
						alert("비밀번호는 5자 이상 입력해 주세요");
						return false;
					}
				});
				
			});
			
			function callpwChk(pw){
				$.ajax({
					url:"/em/passwordChk.uni",
					type:"POST",
					data:{
						em_pw:pw,
						i_no:i_no
					},
					success:function(data){
						alert(data);
						if(data.indexOf("않습니다")>-1){
							$("#pw").val("").focus();
							return false;
						}
						$(".first").hide();
						$(".second").show();
					},
					error:function(request,status,error){
						alert("에러났다 >> : " + request.status + " : error=" + error);
					}
				});
			}
			
			function callUpdatePw(){
				var em_pw = $("#em_pw").val();
				
				$.ajax({
					url:"/em/updatePw.uni",
					type:"POST",
					data:{
						em_pw:em_pw,
						i_no:i_no
					},
					success:function(data){
						alert(data);
						opener.goUpdatePage();
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
		<h1>비밀번호 변경</h1><p>
		<div align="center" class="first">
			기존 비밀번호 입력 : <input type="password" id="pw">
			<input type="button" id="pwChk" value="확인">
		</div>
		
		<div align="center" class="second">
			변경 할 비밀번호 : <input type="password" id="em_pw"><p>
			비밀번호는 5자 이상<br>
			확인 : <input type="password" id="em_pw2" disabled>
			<input type="button" id="change" value="변경하기"><br>
			<span class="html">비밀번호가 일치하지 않습니다</span>
		</div>
	</body>
</html>