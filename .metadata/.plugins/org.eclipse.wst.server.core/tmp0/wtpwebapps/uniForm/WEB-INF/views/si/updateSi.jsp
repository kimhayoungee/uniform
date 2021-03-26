<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.uniform.si.info.vo.SiInfoVO" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
<%
	SiInfoVO sivo = (SiInfoVO)request.getAttribute("cDetailVO");
	String si_img = "";
	if(sivo.getSi_img()!=null&&sivo.getSi_img()!=""){
		si_img = sivo.getSi_img();
	}
	
	String[] mail = {};
	if(sivo.getI_mail()!=null&&sivo.getI_mail()!=""){
		mail = sivo.getI_mail().split("@");
	}else{
		mail[0] = "";
	}
	
	String si_register = sivo.getSi_register().substring(0,2);
	
	String si_graduationDate = sivo.getSi_graduationDate();
	if(si_graduationDate==null||si_graduationDate==""){
		si_graduationDate = "";
	}
	
%>	
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>학생 정보 수정</title>
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
				$("#si_major").val("<%=sivo.getSi_major()%>");
				$("#i_gender").val("<%=sivo.getI_gender()%>").prop("disabled",true);
				$("#si_grade").val("<%=sivo.getSi_grade()%>");
				$("#si_semester").val("<%=sivo.getSi_semester()%>");
				$("#si_register").val("<%=si_register%>");
				
				if("<%=mail[0]%>"!=null&&"<%=mail[0]%>"!=""){
					if(jQuery.inArray("<%=mail[1]%>",['naver','daum','google','yahoo','hotmail','nate'])== -1){
						$("#mailSelect").val("<%=mail[1]%>");
						$("#select").prop("disabled",true);
					}
				}// 직원의 메일 주소가 등록되어 있고 주소가 셀렉트 박스 안에 존재하는 주소일때 자동으로 선택
				
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
				
				$("#update_btn").on("click",function(){
					alert("학생 정보 수정");
					
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
						
						callFileUpload();
					}
				});
				
			});
			
			function callFileUpload(){
				var form = $("#updateForm");
				var formData = new FormData(form);
				formData.append("file",$("#file")[0].files[0]);
				formData.append("old_img",$("#old_img").val());
				
				$.ajax({
					url:"/si/uploadFile.uni",
					processData:false,
					contentType:false,
					type:"POST",	
					data:formData,
					success:function(data){
						alert(data);
						
						callUpdateSi(data);
					},
					error:function(request,status,error){
						alert("에러났다 >>> : " + request.status + " : error=" + error);
					}
				});
			}
			
			function callUpdateSi(img){
				$("#si_img").val(img);
				console.log("여기 1");
				if($("#si_register").val()=="<%=si_register%>"){
					$("#si_register").val("");
				}
				console.log("여기 2");
				var i_mail = $("#i_mail").val();
				console.log("여기 3");
				if(i_mail!=null&&i_mail!=""){
					$("#i_mail").val(i_mail + "@" + $("#select").val());
				}
				console.log("여기 4");
				var formData = $("#updateForm").serialize();
				
				$.ajax({
					url:"/si/updateSi.uni",
					type:"POST",
					data:formData,
					success:function(data){
						alert(data);
						if(d.indexOf("실패")>-1){
							return false;
						}else{
							opener.goSiMain();
							window.close();
						}
					},
					error:function(request,status,error){
						alert("에러났다 >> : " + request.status +" : error=" + error);
					}
				});
			}
		</script>		
	</head>
	<body>
		<h2>학생 정보 수정</h2>
		<p>
		
		</p>
		<input type="button" value="수정하기" id="update_btn">
		<p>
		
		</p>
		<form id="updateForm">
			<table border="1">
				<tr align="center">
					<td height="100px" rowspan="5">
<%
		if(si_img==null||si_img==""){
%>					
						사진<br>등록
<%
		}else{
%>
						<img src="/si/img/<%=si_img%>" width="100px" height="130px">
<%			
		}
%>						
					</td>
					<th align="left">*학생명(한글)</th>
					<td>
						<input type="text" id="i_nameKr" name="i_nameKr" style="width:258px;" value="<%=sivo.getI_nameKr()%>">
					</td>
				</tr>
				
				<tr>
					<th align="left">*영문(성)</th>
					<td>
						<input type="text" id="i_firstName" name="i_firstName" style="width:258px;" value="<%=sivo.getI_firstName()%>">
					</td>			
				</tr>
				
				<tr>
					<th align="left">*영문(이름)</th>
					<td>
						<input type="text" id="i_lastName" name="i_lastName" style="width:258px;" value="<%=sivo.getI_lastName()%>">
					</td>			
				</tr>
				
				<tr>
					<th align="left">*생년월일</th>
					<td>
						<input type="text" id="i_birth" name="i_birth" style="width:258px;" value="<%=sivo.getI_birth()%>">
					</td>
				</tr>
				
				<tr>
					<th align="left" width="150px">*주민등록번호</th>
					<td>
						<input type="text" id="i_rrn" name="i_rrn" placeholder="-는 빼고 입력" style="width:258px;" value="<%=sivo.getI_rrn()%>">
					</td>
				</tr>
				
				<tr>
					<td>
						<input type="file" width="100px" id="file" class="file">
						<input type="hidden" id="si_img" name="si_img">
						<input type="hidden" id="old_img" name="old_img" value="<%=sivo.getSi_img()%>">
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
						<input type="text" id="i_hp" name="i_hp" value="<%=sivo.getI_hp()%>">
					</td>
					<th width="100px">비상연락</th>
					<td>
						<input type="text" id="i_tel" name="i_tel" value="<%=sivo.getI_tel()%>">
					</td>
				</tr>
			</table>
			
			<table border="1">
				<tr>
					<th width="100px">이메일</th>
					<td>
						<input type="text" id="i_mail" name="i_mail" style="width:142px;" value="<%=mail[0]%>">@
						<select id="mailSelect">
							<option value="self">직접입력</option>
							<option value="naver.com">naver.com</option>
							<option value="daum.net">daum.net</option>
							<option value="google.com">google.com</option>
							<option value="yahoo.co.kr">yahoo.co.kr</option>
							<option value="hotmail.com">hotmail.com</option>
							<option value="nate.com">nate.com</option>
						</select>
						<input type="text" id="select" value="<%=mail[1]%>">
					</td>
				</tr>
			</table>
			<p>
			
			</p>
			<table border="1">
				<tr>
					<th width="115px">우편번호</th>
					<td>
						<input type="text" id="i_postNo" name="i_postNo" placeholder="우편번호" value="<%=sivo.getI_postNo()%>"readonly>
						<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
					</td>
				</tr>
			
				<tr>
					<th>도로명주소</th>
					<td>
						<input type="text" id="i_doro" name="i_doro" placeholder="도로명주소" style="width:400px" value="<%=sivo.getI_doro()%>" readonly>
					</td>
				</tr>
			
				<tr>
					<th>지번 주소</th>
					<td>
						<input type="text" id="i_jibun" name="i_jibun" placeholder="지번주소" style="width:400px" value="<%=sivo.getI_jibun()%>" readonly>
					</td>
				</tr>
				
				<tr>
					<th>상세 주소</th>
					<td>
						<input type="text" id="i_detail" name="i_detail" style="width:400px" value="<%=sivo.getI_detail()%>" placeholder="상세주소">
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
					<th>이수학점</th>
					<td>
						<input type="text" id="si_credits" name="si_credits">
					</td>
					<th>평균학점</th>
					<td>
						<input type="text" id="si_avg" name="si_avg">
					</td>
				</tr>
			</table>

			<table border="1">
				<tr>
					<th width="150px">학적상태</th>
					<td>
						<select id="si_register" name="si_register">
							<option value="">선택</option>
							<option value="등록">등록</option>
							<option value="휴학">휴학</option>
							<option value="복학">복학</option>
							<option value="졸업">졸업</option>
						</select>
					</td>
					<th width="120px">출신고교</th>
					<td>
						<input type="text" name="si_highschool" style="width:184px;" value="<%=sivo.getSi_highschool()%>">
					</td>
				</tr>
				
				<tr>
					<th>입학일자</th>
					<td colspan="3">
						<input type="text" name="si_admissionDate" style="width:361px;" value="<%=sivo.getSi_admissionDate()%>">
					</td>
				</tr>
				
				<tr>
					<th>졸업일자</th>
					<td colspan="3">
						<input type="text" name="si_graduationDate" style="width:361px;" value="<%=si_graduationDate%>">
					</td>
				</tr>
				
				<tr>
					<th colspan="4">입학정보</th>
				</tr>
				
				<tr>
					<td colspan="4">
						<textarea cols="55" rows="5" style="width:514px;" name="si_admissionInfo"><%=sivo.getSi_admissionInfo() %></textarea>
					</td>
				</tr>
			</table>
			<input type="hidden" name="i_no" value="<%=sivo.getI_no()%>">
		</form>
	</body>
</html>