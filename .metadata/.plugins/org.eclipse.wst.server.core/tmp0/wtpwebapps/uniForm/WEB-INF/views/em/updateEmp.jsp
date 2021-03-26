<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.uniform.em.common.vo.EmCommonVO" %>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
<%
	EmCommonVO ecvo = (EmCommonVO)request.getAttribute("updateVO");
	String i_gender = ecvo.getI_gender();
	String em_img = ecvo.getEm_img();
	String[] mail = {};
	String mailFir = "";
	String mailEnd = "";
	int d = 1;
	boolean mailBool = false;
	if(ecvo.getI_mail()!=null&&ecvo.getI_mail()!=""){
		mail = ecvo.getI_mail().split("@");
		mailBool = true;
		for(int i=0;i<mail.length;i++){
			if(i==1){
				mailEnd = mail[i];
			}else if(i==0){
				mailFir = mail[i];
			}
		}
	}
	String tel = "";
	String military = "";
	String mNo = "";
	String mStart = "";
	String mEnd = "";
	String exemp = "";
	
	if(ecvo.getI_tel()!=null&&ecvo.getI_tel()!=""){
		tel = ecvo.getI_tel();
	}
	if(ecvo.getEm_military()!=null&&ecvo.getEm_military()!=""){
		military = ecvo.getEm_military();
	}
	if(ecvo.getEm_mNo()!=null&&ecvo.getEm_mNo()!=""){
		mNo = ecvo.getEm_mNo();
	}
	if(ecvo.getEm_mStart()!=null&&ecvo.getEm_mStart()!=""){
		mStart = ecvo.getEm_mStart();
	}
	if(ecvo.getEm_mEnd()!=null&&ecvo.getEm_mEnd()!=""){
		mEnd = ecvo.getEm_mEnd();
	}
	if(ecvo.getEm_exemp()!=null&&ecvo.getEm_exemp()!=""){
		exemp = ecvo.getEm_exemp();
	}
%>	
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0
      , maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densityDpi=medium-dpi">
		
		<!-- Reset CSS --> 
		<link rel="stylesheet" href="/cssExample/css/reset_normalize.css" media="all">
		<!-- Design CSS -->
		<link rel="stylesheet" href="/cssExample/css/style_common.css" media="all">
		<link rel="stylesheet" href="/cssExample/css/style_contents.css" media="all">
		<!-- Layout CSS -->
		<link rel="stylesheet" href="/cssExample/css/layout_main.css" media="all">
		<link rel="stylesheet" href="/cssExample/css/layout_sub.css" media="all">
		<link rel="stylesheet" href="/cssExample/css/layout_responsive.css" media="all">
		<!-- Script --> 
		<script src="/cssExample/js/jquery.js"></script>
		<script src="/cssExample/js/jquery.ui.js"></script>
		<script src="/cssExample/js/jquery.bxslider.js"></script>
		<script src="/cssExample/js/common.js"></script>  
		<script src="/cssExample/js/custom.js"></script>
		<script src="/cssExample/js/main2.js"></script>  
		<script src="/cssExample/js/masonry.pkgd.js"></script>
		
		<title>교직원 정보 수정</title>
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
				$("#i_gender").val("<%=i_gender%>");
				$("#em_dept").val("<%=ecvo.getEm_dept()%>");
				$("#em_position").val("<%=ecvo.getEm_position()%>");
				$("#em_team").val("<%=ecvo.getEm_team()%>");
				
				if("<%=i_gender%>"=="여"){
					$(".mil").prop("readonly",true).css("background","lightgray");
				}
				
				if(<%=mailBool%>){
					if(jQuery.inArray("<%=mailEnd%>",['naver','daum','google','yahoo','hotmail','nate'])== -1){
						$("#mailSelect").val("<%=mailEnd%>");
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
				
				if("<%=ecvo.getEm_academic()%>"!='null'&&"<%=ecvo.getEm_academic()%>"!=""){
					$("#em_academic").val("<%=ecvo.getEm_academic()%>");
				}
				
				if("<%=military%>"!=null&&"<%=military%>"!=""){
					$("#em_military").val("<%=military%>");
				}
				
				$("#update_btn").on("click",function(){
					alert("사원 정보 수정");
					
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
				alert("여기까지?");
				formData.append("old_img",$("#old_img").val());
				
				$.ajax({
					url:"/em/insertImage.uni",
					processData:false,
					contentType:false,
					type:"POST",	
					data:formData,
					success:function(data){
						alert(data);
						
						callUpdateEmp(data);
					},
					error:function(request,status,error){
						alert("에러났다 >>> : " + request.status + " : error=" + error);
					}
				});
			}
			
			function callUpdateEmp(img){
				$("#em_img").val(img);
				var i_mail = $("#i_mail").val();
				
				if(i_mail!=null&&i_mail!=""){
					$("#i_mail").val(i_mail + "@" + $("#select").val());
				}
				
				var formData = $("#updateForm").serialize();
				
				$.ajax({
					url:"/em/updateEmp.uni",
					type:"POST",
					data:formData,
					success:function(d){
						alert(d);
						if(d.indexOf("실패")>-1){
							return false;
						}else{
							opener.goEmMain();
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
		<input type="button" class=blue_btn style="height:18pt;" value="수정하기" id="update_btn">
		<h2>교직원 정보 수정</h2>
		<p>
		
		</p>
		
		<p>
		
		</p>
		<form id="updateForm">
		<div class="table_wrap">
			<table border="0">
				<tr align="center">
					<td height="100px" rowspan="5">
<%
	if(em_img!=null&&em_img!=""){
%>
						<img src="/common/img/<%=em_img%>" width="100px" height="130px">
<%		
	}else{
%>
						사진<br>등록
<%		
	}
%>					</td>
					<th align="left">*사원명(한글)</th>
					<td align="left">
						<input type="text" id="i_nameKr" name="i_nameKr" style="width:150px;" value="<%=ecvo.getI_nameKr()%>">
					</td>
				</tr>
				
				<tr>
					<th align="left">*영문(성)</th>
					<td>
						<input type="text" id="i_firstName" name="i_firstName" style="width:150px;" value="<%=ecvo.getI_firstName()%>">
					</td>			
				</tr>
				
				<tr>
					<th align="left">*영문(이름)</th>
					<td>
						<input type="text" id="i_lastName" name="i_lastName" style="width:150px;" value="<%=ecvo.getI_lastName()%>">
					</td>			
				</tr>
				
				<tr>
					<th align="left">*생년월일</th>
					<td>
						<input type="text" id="i_birth" name="i_birth" style="width:150px;" value="<%=ecvo.getI_birth()%>">
					</td>
				</tr>
				
				<tr>
					<th align="left" width="150px">*주민등록번호</th>
					<td>
						<input type="text" id="i_rrn" name="i_rrn" placeholder="-는 빼고 입력" style="width:150px;" value="<%=ecvo.getI_rrn()%>">
					</td>
				</tr>
				
				<tr>
					<td>
						<input type="file" width="100px" id="file" class="file">
						<input type="hidden" id="em_img" name="em_img">
						<input type="hidden" id="old_img" name="old_img" value="<%=ecvo.getEm_img()%>">
					</td>		
					<th align="left" width="50px">성별</th>
					<td>
						<select id="i_gender" name="i_gender" disabled>
							<option value="남">남성</option>
							<option value="여">여성</option>
						</select>
					</td>
				</tr>
			</table>
			</div>
			
			<div class="table_wrap">
			<table border="0">
				<tr>
					<th width="100px">*전화번호</th>
					<td>
						<input type="text" id="i_hp" name="i_hp" value="<%=ecvo.getI_hp()%>">
					</td>
					<th width="100px">비상연락</th>
					<td>
						<input type="text" id="i_tel" name="i_tel" value="<%=tel%>">
					</td>
				</tr>
			</table>
			</div>
			
			<div class="table_wrap">
			<table border="0">
				<tr>
					<th width="100px">이메일</th>
					<td>
						<input type="text" id="i_mail" name="i_mail" style="width:128px;" value="<%=mailFir%>">@
						<select id="mailSelect">
							<option value="self">직접입력</option>
							<option value="naver.com">naver.com</option>
							<option value="daum.net">daum.net</option>
							<option value="google.com">google.com</option>
							<option value="yahoo.co.kr">yahoo.co.kr</option>
							<option value="hotmail.com">hotmail.com</option>
							<option value="nate.com">nate.com</option>
						</select>
						<input type="text" id="select" value="<%=mailEnd%>">
					</td>
				</tr>
			</table>
			</div>
			<p>
			
			</p>
			<div class="table_wrap">
			<table border="0">
				<tr>
					<th width="100px">우편번호</th>
					<td>
						<input type="text" id="i_postNo" name="i_postNo" placeholder="우편번호" value="<%=ecvo.getI_postNo() %>" readonly>
						<input type="button" class=grey_btn onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
					</td>
				</tr>
			
				<tr>
					<th>도로명주소</th>
					<td>
						<input type="text" id="i_doro" name="i_doro" placeholder="도로명주소" style="width:400px" value="<%=ecvo.getI_doro() %>" readonly>
					</td>
				</tr>
			
				<tr>
					<th>지번 주소</th>
					<td>
						<input type="text" id="i_jibun" name="i_jibun" placeholder="지번주소" style="width:400px" value="<%=ecvo.getI_jibun() %>" readonly>
					</td>
				</tr>
				
				<tr>
					<th>상세 주소</th>
					<td>
						<input type="text" id="i_detail" name="i_detail" style="width:400px" placeholder="상세주소" value="<%=ecvo.getI_detail() %>">
					</td>
				</tr>
				
				<tr>
					<th width="100px">입사일</th>
					<td>
						<input type="text" id="em_hireDate" name="em_hireDate" style="width:400px;" value="<%=ecvo.getEm_hireDate() %>">
					</td>
				</tr>
			</table>
			</div>
			<p>
			
			</p>
			<div class="table_wrap">
			<table border="0">
				<tr>
					<th width="100px">최종학력</th>
					<td width="600px">
						<select id="em_academic" name="em_academic" style="width:130px;">
							<option value="">선택</option>
							<option value="중졸">중졸</option>
							<option value="고졸">고졸</option>
							<option value="초대졸">초대졸</option>
							<option value="대졸">대졸</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<th width="100px">처부</th>
					<td>
						<select id="em_dept" name="em_dept" style="width:130px;">
							<option value="">선택</option>
							<option value="11">기획처</option>
							<option value="12">교학처</option>
							<option value="13">사무처</option>
							<option value="14">국제협력처</option>
						</select>
					</td>
				</tr>
			
				<tr>
					<th width="100px">직위</th>
					<td>
						<select id="em_position" name="em_position" style="width:130px;">
							<option value="">선택</option>
							<option value="31">총장</option>
							<option value="32">처장</option>
							<option value="33">팀장</option>
							<option value="34">과장</option>
							<option value="35">사원</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<th width="100px">팀</th>
					<td>
						<select id="em_team" name="em_team" style="width:130px;">
							<option value="">선택</option>
							<option value="51">기획팀</option>
							<option value="52">홍보팀</option>
							<option value="53">입학관리팀</option>
							<option value="54">교무팀</option>
							<option value="55">학사지원팀</option>
							<option value="56">총무팀</option>
							<option value="57">재무팀</option>
							<option value="58">국제교류팀</option>
							<option value="59">국제학생지원팀</option>
						</select>
					</td>
				</tr>
			</table>
			</div>
			
			<div class="table_wrap">
			<table border="0">
				<tr>
					<th width="100px">군필</th>
					<td>
						<select class="mil" id="em_military" name="em_military" style="width:130px;">
							<option value="">선택</option>
							<option value="현역">현역</option>
							<option value="면제">면제</option>
							<option value="공익">공익</option>
						</select>
					</td>
					<th width="100px">군번</th>
					<td>
						<input class="mil" type="text" name="em_mNo" placeholder="-는 빼고 입력" style="width:157px;" value="<%=mNo%>">
					</td>
				</tr>
				
				<tr>
					<th>입대일</th>
					<td>
						<input class="mil" type="text" name="em_mStart" style="width:126px;" value="<%=mStart%>">
					</td>
					<th>전역일</th>
					<td>
						<input class="mil" type="text" name="em_mEnd" style="width:157px;" value="<%=mEnd%>">
					</td>
				</tr>
			</table>
			</div>
			
			<div class="table_wrap">
			<table border="0">
				<tr>
					<th width="20px">면제사유</th>
					<td>
						<textarea class="mil" style=width:550px; rows="5" cols="59" name="em_exemp"><%=exemp %></textarea>
					</td>
				</tr>
			</table>
			</div>
			<input type="hidden" name="i_no" value="<%=ecvo.getI_no()%>">
		</form>
	</body>
</html>