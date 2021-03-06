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
		
		<title>????????? ?????? ??????</title>
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
	                // ???????????? ???????????? ????????? ??????????????? ????????? ????????? ???????????? ??????.
	
	                // ????????? ????????? ?????? ????????? ?????? ????????? ????????????.
	                // ???????????? ????????? ?????? ?????? ????????? ??????('')?????? ????????????, ?????? ???????????? ?????? ??????.
	                var fullRoadAddr = data.roadAddress; // ????????? ?????? ??????
	                var extraRoadAddr = ''; // ????????? ????????? ?????? ??????
	
	                // ??????????????? ?????? ?????? ????????????. (???????????? ??????)
	                // ???????????? ?????? ????????? ????????? "???/???/???"??? ?????????.
	                if(data.bname !== '' && /[???|???|???]$/g.test(data.bname)){
	                    extraRoadAddr += data.bname;
	                }
	                // ???????????? ??????, ??????????????? ?????? ????????????.
	                if(data.buildingName !== '' && data.apartment === 'Y'){
	                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                }
	                // ?????????, ?????? ????????? ????????? ?????? ??????, ???????????? ????????? ?????? ???????????? ?????????.
	                if(extraRoadAddr !== ''){
	                    extraRoadAddr = ' (' + extraRoadAddr + ')';
	                }
	                // ?????????, ?????? ????????? ????????? ?????? ?????? ????????? ????????? ????????????.
	                if(fullRoadAddr !== ''){
	                    fullRoadAddr += extraRoadAddr;
	                }
	
	                // ??????????????? ?????? ????????? ?????? ????????? ?????????.
		                document.getElementById('i_postNo').value = data.zonecode; //5?????? ??????????????? ??????
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
				
				if("<%=i_gender%>"=="???"){
					$(".mil").prop("readonly",true).css("background","lightgray");
				}
				
				if(<%=mailBool%>){
					if(jQuery.inArray("<%=mailEnd%>",['naver','daum','google','yahoo','hotmail','nate'])== -1){
						$("#mailSelect").val("<%=mailEnd%>");
						$("#select").prop("disabled",true);
					}
				}// ????????? ?????? ????????? ???????????? ?????? ????????? ????????? ?????? ?????? ???????????? ???????????? ???????????? ??????
				
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
					alert("?????? ?????? ??????");
					
					var i_nameKr = $("#i_nameKr").val();
					var i_firstName = $("#i_firstName").val();
					var i_lastName = $("#i_lastName").val();
					var i_birth = $("#i_birth").val();
					var i_rrn = $("#i_rrn").val();
					var i_hp = $("#i_hp").val();
					
					if(i_nameKr==null||i_nameKr==""){
						alert("????????? ?????? ?????? ???????????????.");
						return false;
					}else if(i_firstName==null||i_firstName==""||i_lastName==null||i_lastName==""){
						alert("????????? ?????? ?????? ???????????????.");
						return false;
					}else if(i_birth==""||i_birth==null){
						alert("??????????????? ?????? ?????? ???????????????.");
						return false;
					}else if(i_rrn==null||i_rrn==""){
						alert("????????????????????? ?????? ?????? ???????????????.");
						return false;
					}else if(i_hp==null||i_hp==""){
						alert("??????????????? ?????? ?????? ???????????????.");
						return false;
					}else{
						var ext = $("#file").val().split(".").pop().toLowerCase();
						if(ext!=""){
							if(jQuery.inArray(ext,['gif','png','jpg','jpeg'])== -1){
								alert("????????? ????????? ????????? ???????????????.");
								return false;
							}
						}// ?????? ???????????? ??????????????? ???????????? if??? ??????
						
						callFileUpload();
					}
				});
			});
			
			function callFileUpload(){
				var form = $("#updateForm");
				var formData = new FormData(form);
				formData.append("file",$("#file")[0].files[0]);
				alert("?????????????");
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
						alert("???????????? >>> : " + request.status + " : error=" + error);
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
						if(d.indexOf("??????")>-1){
							return false;
						}else{
							opener.goEmMain();
							window.close();
						}
					},
					error:function(request,status,error){
						alert("???????????? >> : " + request.status +" : error=" + error);
					}
				});
			}
		</script>		
	</head>
	<body>
		<input type="button" class=blue_btn style="height:18pt;" value="????????????" id="update_btn">
		<h2>????????? ?????? ??????</h2>
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
						??????<br>??????
<%		
	}
%>					</td>
					<th align="left">*?????????(??????)</th>
					<td align="left">
						<input type="text" id="i_nameKr" name="i_nameKr" style="width:150px;" value="<%=ecvo.getI_nameKr()%>">
					</td>
				</tr>
				
				<tr>
					<th align="left">*??????(???)</th>
					<td>
						<input type="text" id="i_firstName" name="i_firstName" style="width:150px;" value="<%=ecvo.getI_firstName()%>">
					</td>			
				</tr>
				
				<tr>
					<th align="left">*??????(??????)</th>
					<td>
						<input type="text" id="i_lastName" name="i_lastName" style="width:150px;" value="<%=ecvo.getI_lastName()%>">
					</td>			
				</tr>
				
				<tr>
					<th align="left">*????????????</th>
					<td>
						<input type="text" id="i_birth" name="i_birth" style="width:150px;" value="<%=ecvo.getI_birth()%>">
					</td>
				</tr>
				
				<tr>
					<th align="left" width="150px">*??????????????????</th>
					<td>
						<input type="text" id="i_rrn" name="i_rrn" placeholder="-??? ?????? ??????" style="width:150px;" value="<%=ecvo.getI_rrn()%>">
					</td>
				</tr>
				
				<tr>
					<td>
						<input type="file" width="100px" id="file" class="file">
						<input type="hidden" id="em_img" name="em_img">
						<input type="hidden" id="old_img" name="old_img" value="<%=ecvo.getEm_img()%>">
					</td>		
					<th align="left" width="50px">??????</th>
					<td>
						<select id="i_gender" name="i_gender" disabled>
							<option value="???">??????</option>
							<option value="???">??????</option>
						</select>
					</td>
				</tr>
			</table>
			</div>
			
			<div class="table_wrap">
			<table border="0">
				<tr>
					<th width="100px">*????????????</th>
					<td>
						<input type="text" id="i_hp" name="i_hp" value="<%=ecvo.getI_hp()%>">
					</td>
					<th width="100px">????????????</th>
					<td>
						<input type="text" id="i_tel" name="i_tel" value="<%=tel%>">
					</td>
				</tr>
			</table>
			</div>
			
			<div class="table_wrap">
			<table border="0">
				<tr>
					<th width="100px">?????????</th>
					<td>
						<input type="text" id="i_mail" name="i_mail" style="width:128px;" value="<%=mailFir%>">@
						<select id="mailSelect">
							<option value="self">????????????</option>
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
					<th width="100px">????????????</th>
					<td>
						<input type="text" id="i_postNo" name="i_postNo" placeholder="????????????" value="<%=ecvo.getI_postNo() %>" readonly>
						<input type="button" class=grey_btn onclick="sample4_execDaumPostcode()" value="???????????? ??????">
					</td>
				</tr>
			
				<tr>
					<th>???????????????</th>
					<td>
						<input type="text" id="i_doro" name="i_doro" placeholder="???????????????" style="width:400px" value="<%=ecvo.getI_doro() %>" readonly>
					</td>
				</tr>
			
				<tr>
					<th>?????? ??????</th>
					<td>
						<input type="text" id="i_jibun" name="i_jibun" placeholder="????????????" style="width:400px" value="<%=ecvo.getI_jibun() %>" readonly>
					</td>
				</tr>
				
				<tr>
					<th>?????? ??????</th>
					<td>
						<input type="text" id="i_detail" name="i_detail" style="width:400px" placeholder="????????????" value="<%=ecvo.getI_detail() %>">
					</td>
				</tr>
				
				<tr>
					<th width="100px">?????????</th>
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
					<th width="100px">????????????</th>
					<td width="600px">
						<select id="em_academic" name="em_academic" style="width:130px;">
							<option value="">??????</option>
							<option value="??????">??????</option>
							<option value="??????">??????</option>
							<option value="?????????">?????????</option>
							<option value="??????">??????</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<th width="100px">??????</th>
					<td>
						<select id="em_dept" name="em_dept" style="width:130px;">
							<option value="">??????</option>
							<option value="11">?????????</option>
							<option value="12">?????????</option>
							<option value="13">?????????</option>
							<option value="14">???????????????</option>
						</select>
					</td>
				</tr>
			
				<tr>
					<th width="100px">??????</th>
					<td>
						<select id="em_position" name="em_position" style="width:130px;">
							<option value="">??????</option>
							<option value="31">??????</option>
							<option value="32">??????</option>
							<option value="33">??????</option>
							<option value="34">??????</option>
							<option value="35">??????</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<th width="100px">???</th>
					<td>
						<select id="em_team" name="em_team" style="width:130px;">
							<option value="">??????</option>
							<option value="51">?????????</option>
							<option value="52">?????????</option>
							<option value="53">???????????????</option>
							<option value="54">?????????</option>
							<option value="55">???????????????</option>
							<option value="56">?????????</option>
							<option value="57">?????????</option>
							<option value="58">???????????????</option>
							<option value="59">?????????????????????</option>
						</select>
					</td>
				</tr>
			</table>
			</div>
			
			<div class="table_wrap">
			<table border="0">
				<tr>
					<th width="100px">??????</th>
					<td>
						<select class="mil" id="em_military" name="em_military" style="width:130px;">
							<option value="">??????</option>
							<option value="??????">??????</option>
							<option value="??????">??????</option>
							<option value="??????">??????</option>
						</select>
					</td>
					<th width="100px">??????</th>
					<td>
						<input class="mil" type="text" name="em_mNo" placeholder="-??? ?????? ??????" style="width:157px;" value="<%=mNo%>">
					</td>
				</tr>
				
				<tr>
					<th>?????????</th>
					<td>
						<input class="mil" type="text" name="em_mStart" style="width:126px;" value="<%=mStart%>">
					</td>
					<th>?????????</th>
					<td>
						<input class="mil" type="text" name="em_mEnd" style="width:157px;" value="<%=mEnd%>">
					</td>
				</tr>
			</table>
			</div>
			
			<div class="table_wrap">
			<table border="0">
				<tr>
					<th width="20px">????????????</th>
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