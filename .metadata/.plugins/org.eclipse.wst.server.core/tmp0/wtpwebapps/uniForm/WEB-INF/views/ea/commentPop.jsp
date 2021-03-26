<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>결재의견</title>
		<script type="text/javascript"
				src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
		<script>
			$(document).ready(function(){
				$("#ok_btn").on("click", function(){
					alert(":" + $("#ea_comment").val());
					opener.comment($("#ea_comment").val());
					window.close();
				});
				
				$("#cc_btn").click(function(){
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
			
			.title{
				font-size:20px;
				font-weight:bold;
			}
		</style>
	</head>
	<body>
		
			<br><br>
			<table border="0" align="center" class="table" width="500">
				<tr>
					<td align="left" class="title">결재의견</td>
				</tr>
				<tr>	
					
					<td width="300" height="300">
						<form name="cForm" id="cForm">
							<br><textarea name="ea_comment" id="ea_comment" style="width:480px; height:300px;"></textarea>
						</form>
					</td>
				</tr>
				<tr>	
					<td colspan="2" align="center">
						<br>
						<input type="button" name="cc_btn" id="cc_btn" value="취소" class="grey_btn">
						<input type="button" name="ok_btn" id="ok_btn" value="입력" class="blue_btn">
					</td>
				</tr>
			</table>
		
	</body>
</html>