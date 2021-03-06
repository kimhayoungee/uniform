<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>로그인</title>
		<style type="text/css">
			* { padding: 0; margin: 0 }
			.outline {width: 1024px; height: 650px; background: url('#') 0 0 no-repeat;}
			.loginArea {margin: 192px 0 0 352px;}
			
			body,html {background-color:#f5f6f7;}
			h1 {
			    margin-top: 20px;
			    margin-bottom: 10px;
			}
			.uniform_login .logo {
			    text-align: center;
			    height: 205px;
			}
			.uniform_login {padding:140px 0 0;}
			.uniform_login .logo {text-align:center;height:170px;}
			.uniform_login .entry_ipt {width:460px; margin: 0 auto;} 
			.uniform_login .entry_ipt * {box-sizing: content-box !important;}
			.uniform_login .entry_ipt input {border:1px solid #dadada;width:418px;height:30px;padding:10px 20px;font-size:16px;color:#989898;}
			.uniform_login .entry_ipt .user_id {position:relative;height:62px;}
			.uniform_login .entry_ipt .user_id label {position:absolute;left:1px;top:14px;}
			.uniform_login .entry_ipt .user_pwd {position:relative;height:72px;}
			.uniform_login .entry_ipt .user_pwd label {position:absolute;left:1px;top:14px;}
			.uniform_login .entry_ipt .login_btn {
			    display: block;
			    height: 50px !important;
			    margin: 15px 0 15px;
			    background-color: #295e9c;
			    cursor: pointer;
			    text-align: center;
			    vertical-align: middle;
			    color: #fff !important;
			    font-size: 20px !important;
			    font-weight: 700;
			}
			.uniform_login .txt_notice {width:460px; margin: 0 auto 40px;} 
			.uniform_login .txt_notice h2 {margin:5px 0 5px;background:url("/cssExample/img/btn/bul_q.jpg") 0 2px no-repeat;padding-left:17px;font-weight:bold;line-height:1.2;font-weight:bold;color:#454343;font-size:13px;}
			.uniform_login .txt_notice .txt_01 {color:#989898; line-height:1.4;letter-spacing:-1px;}
			.uniform_login .txt_notice .txt_01 .txt01 {color:#989898;}
			.uniform_login .txt_notice .txt_01 .txt02 {color:#3f3e3e;}
			.uniform_login .txt_notice .txt_01 .txt03 {color:#356bbc;}
			.uniform_login .txt_notice .txt_02 {
				color:#989898; 
				line-height:1.4;
				margin:0;
				padding:0;
				font-family:"","arial";
				font-size: 12px;
				line-height:15px

			}
			.uniform_login .txt_notice .txt_02 strong {text-decoration:underline;color:#356bbc;}
	    </style>
<%
	String result = (String)request.getAttribute("result");
	boolean logBool = result!=null&&result.length()>0;
	String i_no = (String)request.getAttribute("id");
	boolean idBool = i_no!=null&&i_no.length()>0;
%>		
		<script type="text/javascript"
				src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				if(<%=logBool%>){
					alert("<%=result%>");
					if(<%=idBool%>){
						$("#i_no").val("<%=i_no%>");
					}// 아이디를 입력하고 로그인 실패시 입력한 id를 돌려주는 if문 종료
				}// 로그인 실패 문구 출력하는 if문 종료
				
				$("#login_btn").click(function(){
					var i_no = $("#i_no").val().trim();
					var em_pw = $("#em_pw").val().trim();
					
					if(i_no==""){
						alert("아이디를 입력해 주세요");
						$("#i_no").focus();
						return false;
					}else if(em_pw==""){
						alert("비밀번호를 입력해 주세요");
						$("#em_pw").focus();
						return false;
					}else{
						callLogin(i_no,em_pw);
					}
				});		
				
			});
			
			function callLogin(i_no,em_pw){
				$.ajax({
					url:"/sm/login.uni",
					type:"POST",
					data:{
						i_no:i_no,
						em_pw:em_pw
					},
					success:function(data){
						if(data.indexOf("않습니다")>-1){
							alert(data);
							$("#i_no").val(i_no);
							$("#em_pw").val("").focus();
							return false;
						}else{
							location.href="/main/goMain.uni";
						}
					},
					error:function(request,status,error){
						alert("에러 났습니다 >> : " + request.status + " error = " + error);
					}
				});
			}

		</script>		
	</head>
	<body>
		<div style="position:relative; left:0px; top:0px; width:100%; height:100%;">
			<div class="uniform_login">
			<h1 class="logo"><img src="/cssExample/img/uniform_logo.png"  width="460px" alt="유니폼 로고" /></h1>				
		
			<div class="entry_ipt">
				<div class="user_id">
					<label for="i_no"><img src="/cssExample/img/btn/txt_userid.jpg"  width="70" height="20" alt="아이디" /></label>
					<input type="text" id="i_no">
				</div>
				<div class="user_pwd">
					<label for="em_pw"><img src="/cssExample/img/btn/txt_userpwd.jpg"  width="85" height="20" alt="비밀번호" /></label>
					<input type="password" id="em_pw">
				</div>
				<div class="btn_align">
					<input type="button" class="login_btn" id="login_btn" value="로그인">
				</div>
				<p class="txt01"></p>
			</div> <!-- //.entry_ipt -->
			
			<div class="txt_notice">
				<p style="margin-top:50px; border-top:1px solid #dadada;"></p>
				<h2>꼭 확인하세요!</h2>
				<p class="txt_02">
					계정정보 분실시 uni-master@uniform.co.kr 로 문의 바랍니다.<br />
					(비밀번호 변경은 로그인 후 <strong>마이페이지</strong>에서 가능)
				</p>
			</div>
			
			<script type="text/javascript">
				$(".entry_ipt input").focus(function(){
					$(this).parent().find("label").hide();
				});
				$(".entry_ipt input").blur(function(){
					var this_val = this.defaultValue;
					var new_val = $(this).val();
					if(new_val == this_val || new_val.length < 1){
					$(this).parent().find("label").show();
					}
				});
			</script>
			
			</div> <!-- //.uniform_login -->
		</div> <!-- //end of style -->
	</body>
</html>