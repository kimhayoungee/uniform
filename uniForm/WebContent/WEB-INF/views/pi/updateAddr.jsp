<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>주소 변경</title>
		<script type="text/javascript"
				src="/include/js/jquery-1.11.0.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#addr_btn").on("click",function(){
					var i_postNo = $("#i_postNo").val();
					var i_doro = $("#i_doro").val();
					var i_jibun = $("#i_jibun").val();
					var i_detail = $("#i_detail").val();
					
					var postBool = i_postNo!=null&&i_postNo!="";
					var doroBool = i_doro!=null&&i_doro!="";
					var jibunBool = i_jibun!=null&&i_jibun!="";
					var detailBool = i_detail!=null&&i_detail!="";
					
					var addrBool = postBool||doroBool||jibunBool||detailBool
					alert(addrBool);
					if(addrBool){
						callAddr(i_postNo,i_doro,i_jibun,i_detail);
					}else{
						alert("빈칸을 입력할 수 없습니다");
						return false;
					}	
				});
				
			});
			
			function callAddr(i_postNo,i_doro,i_jibun,i_detail){
				$.ajax({
					url:"/em/updateInfo.uni",
					data:{
						i_postNo:i_postNo,
						i_doro:i_doro,
						i_jibun:i_jibun,
						i_detail:i_detail
					},
					success:function(data){
						alert(data);
						if(data.indexOf("실패")>-1){
							return false;
						}
						opener.goUpdatePage();
						window.close();
					},
					error:function(request,status,error){
						alert("에러났다 >> : " + request.status + " : error=" + error);
					}
				});
			}
		</script>	
			
		<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
		<script>
			function sample4_execDaumPostcode() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
	                var extraRoadAddr = ''; // 도로명 조합형 주소 변수
	
	                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                    extraRoadAddr += data.bname;
	                }
	                // 건물명이 있고, 공동주택일 경우 추가한다.
	                if(data.buildingName !== '' && data.apartment === 'Y'){
	                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                }
	                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                if(extraRoadAddr !== ''){
	                    extraRoadAddr = ' (' + extraRoadAddr + ')';
	                }
	                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
	                if(fullRoadAddr !== ''){
	                    fullRoadAddr += extraRoadAddr;
	                }
	
	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('i_postNo').value = data.zonecode; //5자리 새우편번호 사용
	                document.getElementById('i_doro').value = fullRoadAddr;
	                document.getElementById('i_jibun').value = data.jibunAddress;
		            }
		        }).open();
		    }
		</script>
	</head>
	<body>
		<table>
			<tr>
				<td align="center">우편번호</td>
				<td>
					<input type="text" id="i_postNo" placeholder="우편번호" readonly>
					<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
				</td>
			</tr>
		
			<tr>
				<td align="center">도로명주소</td>
				<td>
					<input type="text" id="i_doro" placeholder="도로명주소" readonly>
				</td>
			</tr>
		
			<tr>
				<td align="center">지번 주소</td>
				<td>
					<input type="text" id="i_jibun" placeholder="지번주소" readonly>
				</td>
			</tr>
			
			<tr>
				<td align="center">상세 주소</td>
				<td>
					<input type="text" id="i_detail" placeholder="상세주소">
				</td>
			</tr>
		</table>
		<input type="button" id="addr_btn" value="저장하기">
	</body>
</html>