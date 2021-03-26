<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>결재선 지정</title>
		<script type="text/javascript"
				src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
		<script>
			$(document).ready(function(){
				
				$("#gian_btn").click(function(){
					console.log("gian_btn 클릭");
					console.log("gian.val > " + $("#gian").val());
					if($("#gian").val()=="fullLine"){
						console.log("전체라인");
						$("#ea_linename").val("기안");
					}
					if($("#gian").val()=="arbitraryLine"){
						console.log("전결라인");
						$("#ea_linename").val("기안전결");
					}
					
					opener.linename($("#ea_linename").val());
					
					window.close();
		
				});
				
				$("#full_btn").click(function(){
					$("#ea_linename").val("기안");
					opener.linename($("#ea_linename").val());
					window.close();
				});
				$("#arbi_btn").click(function(){
					$("#ea_linename").val("기안전결");
					opener.linename($("#ea_linename").val());
					window.close();
				});				
				
				$("#cancel_btn").click(function(){
					window.close();
				});
			});
		</script>
		
		<style>
			input.blue_btn {
			    min-width: 48px;
			   background: #295e9c;
			   color: #fff;
			   border: 1px solid #333333;
			}
			input.grey_btn {
			   min-width: 48px;
			   background: #f3f3f3;
			   color: #33333;
			   border: 1px solid #d0d0d0;
			}		
		</style>		
	</head>
	<body>
		<form name="gianForm" id="gianForm">
			<div align="center">
				<br><br><br>
<!-- 				<select name="gian" id="gian" > -->
<!-- 					<option value="fullLine">기안서 라인</option> -->
<!-- 					<option value="arbitraryLine">기안서 전결 라인</option> -->
<!-- 				</select> -->
				<input type="button" name=full_btn id="full_btn" value="전체 결재선 " class="blue_btn">&nbsp;&nbsp;
				<input type="button" name="arbi_btn" id="arbi_btn" value="전결  " class="grey_btn">
				<input type="hidden" name="ea_linename" id="ea_linename">
														  
			</div>
		</form>
	</body>
</html>