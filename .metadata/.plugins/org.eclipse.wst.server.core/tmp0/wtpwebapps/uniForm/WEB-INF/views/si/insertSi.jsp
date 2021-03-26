<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>학생 등록</title>
		<style type="text/css">
			input.file{
				width:100px;
			}
		</style>
		
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
		
		<script type="text/javascript"
				src="/include/js/jquery-1.11.0.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#insert_btn").on("click",function(){
					alert("학생 등록");
					
					var i_nameKr = $("#i_nameKr").val();
					var i_firstName = $("#i_firstName").val();
					var i_lastName = $("#i_lastName").val();
					var i_birth = $("#i_birth").val();
					var i_rrn = $("#i_rrn").val();
					var i_hp = $("#i_hp").val();
					
					if(i_nameKr==null||i_nameKr==""){
						alert("이름은 필수 입력 사항입니다.");
						return false;
					}else if(i_firstName==null||i_firstName==""||i_lastName==null||i_lastName==""){
						alert("이름은 필수 입력 사항입니다.");
						return false;
					}else if(i_birth==""||i_birth==null){
						alert("생년월일은 필수 입력 사항입니다.");
						return false;
					}else if(i_rrn==null||i_rrn==""){
						alert("주민등록번호는 필수 입력 사항입니다.");
						return false;
					}else if(i_hp==null||i_hp==""){
						alert("전화번호는 필수 입력 사항입니다.");
						return false;
					}else{
						var ext = $("#file").val().split(".").pop().toLowerCase();
						if(ext!=""){
							if(jQuery.inArray(ext,['gif','png','jpg','jpeg'])== -1){
								alert("이미지 파일만 업로드 가능합니다.");
								return false;
							}
						}// 파일 업로드가 이미지인지 확인하는 if문 종료
						
						callImgUpload();
					}
				});
				
				$("#mailSelect").on("change",function(){
					var plus = $("#mailSelect").val();
					
					if(plus=="self"){
						$("#select").prop("disabled",false);
						$("#select").val("");
					}else{
						$("#select").prop("disabled",true);
						$("#select").val(plus);
					}
				});
				
			});
			
			function callImgUpload(){
				var form = $("#siForm");
				var formData = new FormData(form);
				formData.append("file",$("#file")[0].files[0]);
				
				$.ajax({
					url:"/si/imgUpload.uni",
					processData:false,
					contentType:false,
					type:"POST",	
					data:formData,
					success:function(data){
						alert(data);
						
						callInsertData(data);
					},
					error:function(request,status,error){
						alert("에러났다 >>> : " + request.status + " : error=" + error);
					}
				});
			}
			
			function callInsertData(d){
				$("#si_img").val(d);
				var i_mail = $("#i_mail").val();
				
				if(i_mail!=null&&i_mail!=""){
					$("#i_mail").val(i_mail + "@" + $("#select").val());
				}
				$("#i_firstName").val($("#i_firstName").val().toUpperCase());
				$("#i_lastName").val($("#i_lastName").val().toUpperCase());
				
				var formData = $("#siForm").serialize();
				
				$.ajax({
					url:"/si/insertSi.uni",
					type:"POST",
					data:formData,
					success:function(data){
						alert(data);
						
						if(data.indexOf("실패")>-1){
							return false;
						}else{
							opener.goSiMain();
							window.close();
						}
					}
				});
			}
		</script>
	</head>
	<body>
		<h2>학생 등록</h2>
		<p>
		
		</p>
		<input type="button" value="등록하기" id="insert_btn">
		<p>
		
		</p>
		<form id="siForm">
			<table border="1">
				<tr align="center">
					<td height="100px" rowspan="5">사진<br>등록</td>
					<th align="left">*학생명(한글)</th>
					<td>
						<input type="text" id="i_nameKr" name="i_nameKr" style="width:258px;">
					</td>
				</tr>
				
				<tr>
					<th align="left">*영문(성)</th>
					<td>
						<input type="text" id="i_firstName" name="i_firstName" style="width:258px;">
					</td>			
				</tr>
				
				<tr>
					<th align="left">*영문(이름)</th>
					<td>
						<input type="text" id="i_lastName" name="i_lastName" style="width:258px;">
					</td>			
				</tr>
				
				<tr>
					<th align="left">*생년월일</th>
					<td>
						<input type="text" id="i_birth" name="i_birth" style="width:258px;">
					</td>
				</tr>
				
				<tr>
					<th align="left" width="150px">*주민등록번호</th>
					<td>
						<input type="text" id="i_rrn" name="i_rrn" placeholder="-는 빼고 입력" style="width:258px;">
					</td>
				</tr>
				
				<tr>
					<td>
						<input type="file" width="100px" id="file" class="file">
						<input type="hidden" id="si_img" name="si_img">
					</td>		
					<th align="left" width="50px">성별</th>
					<td>
						<select id="i_gender" name="i_gender">
							<option value="남">남성</option>
							<option value="여">여성</option>
						</select>
					</td>
				</tr>
			</table>
			
			<table border="1">
				<tr>
					<th width="100px">*전화번호</th>
					<td>
						<input type="text" id="i_hp" name="i_hp">
					</td>
					<th width="100px">비상연락</th>
					<td>
						<input type="text" id="i_tel" name="i_tel">
					</td>
				</tr>
			</table>
			
			<table border="1">
				<tr>
					<th width="100px">이메일</th>
					<td>
						<input type="text" id="i_mail" name="i_mail" style="width:142px;">@
						<select id="mailSelect">
							<option value="self">직접입력</option>
							<option value="naver.com">naver.com</option>
							<option value="daum.net">daum.net</option>
							<option value="google.com">google.com</option>
							<option value="yahoo.co.kr">yahoo.co.kr</option>
							<option value="hotmail.com">hotmail.com</option>
							<option value="nate.com">nate.com</option>
						</select>
						<input type="text" id="select">
					</td>
				</tr>
			</table>
			<p>
			
			</p>
			<table border="1">
				<tr>
					<th width="115px">우편번호</th>
					<td>
						<input type="text" id="i_postNo" name="i_postNo" placeholder="우편번호" readonly>
						<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
					</td>
				</tr>
			
				<tr>
					<th>도로명주소</th>
					<td>
						<input type="text" id="i_doro" name="i_doro" placeholder="도로명주소" style="width:400px" readonly>
					</td>
				</tr>
			
				<tr>
					<th>지번 주소</th>
					<td>
						<input type="text" id="i_jibun" name="i_jibun" placeholder="지번주소" style="width:400px" readonly>
					</td>
				</tr>
				
				<tr>
					<th>상세 주소</th>
					<td>
						<input type="text" id="i_detail" name="i_detail" style="width:400px" placeholder="상세주소">
					</td>
				</tr>
			</table>
			<p>
			
			</p>
			<table border="1">
				<tr>
					<th width="91px">학과</th>
					<td>
						<select id="si_major" name="si_major">
							<option value="">선택</option>
							<option value="41">공연예술학과</option>
							<option value="42">유아교육과</option>
							<option value="43">관광학과</option>
							<option value="44">디자인학과</option>
							<option value="45">항공운항과</option>
							<option value="46">사회복지학과</option>
						</select>
					</td>
					<th width="91px">학년</th>
					<td>
						<select id="si_grade" name="si_grade">
							<option value="">선택</option>
							<option value="1">1학년</option>
							<option value="2">2학년</option>
						</select>
					</td>
					<th width="91px">학기</th>
					<td>
						<select id="si_semester" name="si_semester">
							<option value="">선택</option>
							<option value="1">1학기</option>
							<option value="2">2학기</option>
						</select>
					</td>
				</tr>
			</table>
			
			<table border="1">
				<tr>
					<th width="150px">학적상태</th>
					<td>
						<select name="si_register">
							<option value="">선택</option>
							<option value="등록">등록</option>
							<option value="휴학">휴학</option>
							<option value="복학">복학</option>
							<option value="졸업">졸업</option>
						</select>
					</td>
					<th width="120px">출신고교</th>
					<td>
						<input type="text" name="si_highschool" style="width:184px;">
					</td>
				</tr>
				
				<tr>
					<th>입학일자</th>
					<td colspan="3">
						<input type="text" name="si_admissionDate" style="width:361px;">
					</td>
				</tr>
				
				<tr>
					<th colspan="4">입학정보</th>
				</tr>
				
				<tr>
					<td colspan="4">
						<textarea cols="55" rows="5" style="width:514px;" name="si_admissionInfo"></textarea>
					</td>
				</tr>
			</table>
		</form>	
	</body>
</html>