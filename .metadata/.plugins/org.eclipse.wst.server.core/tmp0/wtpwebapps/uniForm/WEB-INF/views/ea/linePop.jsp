<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>결재선 지정</title>
		<!-- 제이쿼리 -->
		<script type="text/javascript"
			src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
		<script>
			$(document).ready(function(){
				
				$("#deptSelect1").hide();
				$("#teamSelect1").hide();
				$("#memSelect1").hide();
				$("#deptSelect2").hide();
				$("#teamSelect2").hide();
				$("#memSelect2").hide();
				$("#deptSelect3").hide();
				$("#teamSelect3").hide();
				$("#memSelect3").hide();					
				
				$("#ok2_btn").hide();
				var linename1 = "";
				var linename2 = "";
				var linename3 = "";
				
				var ln = opener.$("#ea_linename").val();
				if(ln.match("전결")){
					$("#line3_btn").attr("disabled", true);
					$("#showline3").val("전결");
				}
				
				if(ln.match("휴가")){
					$("#line3_btn").attr("disabled", true);
					$("#showline3").val("휴가계");
					$("#ok_btn").hide();
					$("#ok2_btn").show();
				}
				
				//기안서, 기안전결시 완료 버튼 
				$("#ok_btn").click(function(){
					if(ln.match("전결")){
						$("#showline3").val("");
					}
					
					opener.line($("#ea_line1").val(), $("#ea_line2").val(), $("#ea_line3").val(), $("#showline1").val(), $("#showline2").val(), $("#showline3").val());
					
					window.close();
				
				});
				
				//휴가계 완료 버튼
				$("#ok2_btn").click(function(){
					opener.line($("#ea_line1").val(), $("#ea_line2").val(), $("#showline1").val(), $("#showline2").val());
					window.close();
					
				});
				//결재선1 선택 버튼 클릭시 
				$("#line1_btn").click(function(){
					$("#deptSelect1").children("option").remove();
					$("#deptSelect1").append("<option>선택</option>");
					$("#teamSelect1").hide();
					$("#memSelect1").hide();	
					var ino = "";
					
					$.ajax({
						url : "/ea/deptSelect.uni",
						data : {},
						type : "post",
						success : function(data){	
								
								var president = data.president;
								var dept = data.dept;
							
								for(var j=0;j<president.length;j++){
									console.log("leader 확인 : " + president[j]);
									$("#deptSelect1").append("<option value="+president[j].i_no+">"+president[j].i_nameKr+" 총장</option>");
									ino = president[j].i_no;
									linename1 = president[j].i_nameKr + " 총장";
								}
								
								for(var i=0;i<dept.length;i++){
									
									$("#deptSelect1").append("<option value="+dept[i].code_detail+">"+dept[i].code_detail+"</option>");
		
								}
								
								
							},
							error : function(e){
								console.log("whenError : " + e.responseText);
							}
						});
						
						$("#deptSelect1").show();
						
						//처 선택시, 처장 팀 조회
						$("#deptSelect1").change(function(){
							$("#teamSelect1").children("option").remove();
							$("#teamSelect1").append("<option>선택</option>");
							$("#memSelect1").hide();
							
							//결재선 총장으로 value주기
							if($("#deptSelect1").val()== ino){
								$("#ea_line1").val(ino);
								$("#showline1").val(linename1);
								ino = "";
							}
							
							$.ajax({
								url : "/ea/teamSelect.uni",
								data : {dept : $("#deptSelect1").val()},
								type : "post",
								success : function(data){
									console.log("data : "+data);
									//둘다 list담아옴
									var leader = data.deptLeader;
									var team = data.team;
									
									for(var j=0;j<leader.length;j++){
										console.log("leader 확인 : " + leader[j]);
										$("#teamSelect1").append("<option value="+leader[j].i_no+">"+leader[j].i_nameKr+" 처장</option>");
										ino = leader[j].i_no;
										linename1 = leader[j].i_nameKr + " 처장";
									}
									
									for(var i=0;i<team.length;i++){
										
										$("#teamSelect1").append("<option value="+team[i].code_detail+">"+team[i].code_detail+"</option>");
									}

								},
								error : function(e){
									console.log("whenError : " + e.responseText);
								}
							});
							
							$("#teamSelect1").show();
						});
						
						//팀 선택시, 팀장 조회
						$("#teamSelect1").change(function(){
							$("#memSelect1").children("option").remove();
							$("#memSelect1").append("<option>선택</option>");
							
							if($("#teamSelect1").val()== ino){
								$("#ea_line1").val(ino);
								$("#showline1").val(linename1);
								ino = "";
							}
							
							$.ajax({
								url : "/ea/teamLeaderSelect.uni",
								data : {team : $("#teamSelect1").val()},
								type : "post",
								success : function(data){
									var leader = data;
									
									for(var i=0;i<leader.length;i++){
										
										$("#memSelect1").append("<option value="+leader[i].i_no+">"+leader[i].i_nameKr+" 팀장</option>");
										ino = leader[i].i_no;
										linename1 = leader[i].i_nameKr + " 팀장";
									}
								
								},
								error : function(e){
									console.log("whenError : " + e.responseText);
								}
							});
							
							$("#memSelect1").show();
							
						}); 
						
						$("#memSelect1").change(function(){
							
							if($("#memSelect1").val()== ino){
								$("#ea_line1").val(ino);
								$("#showline1").val(linename1);
							}
						});
						
				}); //1클릭
				

				
				$("#line2_btn").click(function(){
					$("#deptSelect1").hide();
					$("#teamSelect1").hide();
					$("#memSelect1").hide();
					$("#deptSelect2").children("option").remove();
					$("#deptSelect2").append("<option>선택</option>");
					$("#teamSelect2").hide();
					$("#memSelect2").hide();


					var ino = "";
					
					$.ajax({
						url : "/ea/deptSelect.uni",
						data : {},
						type : "post",
						success : function(data){	
							//console.log("확인  : " + data);
							var president = data.president;
							var dept = data.dept;
						
							
							
							for(var j=0;j<president.length;j++){
								console.log("leader 확인 : " + president[j]);
								$("#deptSelect2").append("<option value="+president[j].i_no+">"+president[j].i_nameKr+" 총장</option>");
								ino = president[j].i_no;
								linename2 = president[j].i_nameKr + " 총장"
							}
							
							for(var i=0;i<dept.length;i++){
								
								$("#deptSelect2").append("<option value="+dept[i].code_detail+">"+dept[i].code_detail+"</option>");
	
							}
							
							
						},
						error : function(e){
							console.log("whenError : " + e.responseText);
						}
					});
					
					$("#deptSelect2").show();
					
					//처 선택시, 처장 팀 조회
					$("#deptSelect2").change(function(){
						$("#teamSelect2").children("option").remove();
						$("#teamSelect2").append("<option>선택</option>");
						$("#memSelect2").hide();
						
						//결재선 총장으로 value주기
						if($("#deptSelect2").val()== ino){
							$("#ea_line2").val(ino);
							$("#showline2").val(linename2);
							ino = "";
						}
						
						$.ajax({
							url : "/ea/teamSelect.uni",
							data : {dept : $("#deptSelect2").val()},
							type : "post",
							success : function(data){
								console.log("data : "+data);
								//둘다 list담아옴
								var leader = data.deptLeader;
								var team = data.team;
								
								for(var j=0;j<leader.length;j++){
									console.log("leader 확인 : " + leader[j]);
									$("#teamSelect2").append("<option value="+leader[j].i_no+">"+leader[j].i_nameKr+" 처장</option>");
									ino = leader[j].i_no;
									linename2 = leader[j].i_nameKr + " 처장";
								}
								
								for(var i=0;i<team.length;i++){
									
									$("#teamSelect2").append("<option value="+team[i].code_detail+">"+team[i].code_detail+"</option>");
								}
								
								if($("#deptSelect2").val()== ino){
									$("#ea_line2").val(ino);
									$("#showline2").val(linename2);
								}
							},
							error : function(e){
								console.log("whenError : " + e.responseText);
							}
						});
						
						$("#teamSelect2").show();
					});
					
					//팀 선택시, 팀장 조회
					$("#teamSelect2").change(function(){
						$("#memSelect2").children("option").remove();
						$("#memSelect2").append("<option>선택</option>");
						
						if($("#teamSelect2").val()== ino){
							$("#ea_line2").val(ino);
							$("#showline2").val(linename2);
							ino = "";
						}
						
						$.ajax({
							url : "/ea/teamLeaderSelect.uni",
							data : {team : $("#teamSelect2").val()},
							type : "post",
							success : function(data){
								var leader = data;
								
								for(var i=0;i<leader.length;i++){
									
									$("#memSelect2").append("<option value="+leader[i].i_no+">"+leader[i].i_nameKr+" 팀장</option>");
									ino = leader[i].i_no;
									linename2 = leader[i].i_nameKr;
								}
							
							},
							error : function(e){
								console.log("whenError : " + e.responseText);
							}
						});
						
						$("#memSelect2").show();
						
					}); 
					
					$("#memSelect2").change(function(){
						
						if($("#memSelect2").val()== ino){
							$("#ea_line2").val(ino);
							$("#showline2").val(linename2);
						}
					});
						
				}); //line2_btn click
				
				$("#line3_btn").click(function(){
					$("#deptSelect2").hide();
					$("#teamSelect2").hide();
					$("#memSelect2").hide();
					$("#deptSelect3").children("option").remove();
					$("#deptSelect3").append("<option>선택</option>");
					$("#teamSelect3").hide();
					$("#memSelect3").hide();

					var ino = "";
					
					$.ajax({
						url : "/ea/deptSelect.uni",
						data : {},
						type : "post",
						success : function(data){	
							
							var president = data.president;
							var dept = data.dept;
							
							for(var j=0;j<president.length;j++){
								console.log("leader 확인 : " + president[j]);
								$("#deptSelect3").append("<option value="+president[j].i_no+">"+president[j].i_nameKr+" 총장</option>");
								ino = president[j].i_no;
								linename3 = president[j].i_nameKr + " 총장";
							}
							
							for(var i=0;i<dept.length;i++){
								
								$("#deptSelect3").append("<option value="+dept[i].code_detail+">"+dept[i].code_detail+"</option>");
	
							}
							
						},
						error : function(e){
							console.log("whenError : " + e.responseText);
						}
					});
					
					$("#deptSelect3").show();
					
					//처 선택시, 처장 팀 조회
					$("#deptSelect3").change(function(){
						$("#teamSelect3").children("option").remove();
						$("#teamSelect3").append("<option>선택</option>");
						$("#memSelect3").hide();
						
						//결재선 총장으로 value주기
						if($("#deptSelect3").val()== ino){
							$("#ea_line3").val(ino);
							$("#showline3").val(linename3);
							ino = "";
						}
						
						$.ajax({
							url : "/ea/teamSelect.uni",
							data : {dept : $("#deptSelect3").val()},
							type : "post",
							success : function(data){
								console.log("data : "+data);
								//둘다 list담아옴
								var leader = data.deptLeader;
								var team = data.team;
								//console.log("Ddd > " + leader.length);
								
								for(var j=0;j<leader.length;j++){
									console.log("leader 확인 : " + leader[j]);
									$("#teamSelect3").append("<option value="+leader[j].i_no+">"+leader[j].i_nameKr+" 처장</option>");
									ino = leader[j].i_no;
									linename3 = leader[j].i_nameKr + " 처장";
								}
								
								for(var i=0;i<team.length;i++){
									
									$("#teamSelect3").append("<option value="+team[i].code_detail+">"+team[i].code_detail+"</option>");
								}
								
								if($("#deptSelect3").val()== ino){
									$("#ea_line3").val(ino);
									$("#showline3").val(linename3);
								}
							},
							error : function(e){
								console.log("whenError : " + e.responseText);
							}
						});
						
						$("#teamSelect3").show();
					});
					
					//팀 선택시, 팀장 조회
					$("#teamSelect3").change(function(){
						$("#memSelect3").children("option").remove();
						$("#memSelect3").append("<option>선택</option>");
						
						if($("#teamSelect3").val()== ino){
							$("#ea_line3").val(ino);
							$("#showline3").val(linename3);
							ino = "";
						}
						
						$.ajax({
							url : "/ea/teamLeaderSelect.uni",
							data : {team : $("#teamSelect3").val()},
							type : "post",
							success : function(data){
								var leader = data;
								
								for(var i=0;i<leader.length;i++){
									
									$("#memSelect3").append("<option value="+leader[i].i_no+">"+leader[i].i_nameKr+" 팀장</option>");
									ino = leader[i].i_no;
									linename3 = leader[i].i_nameKr + " 팀장";
								}
							
							},
							error : function(e){
								console.log("whenError : " + e.responseText);
							}
						});
						
						$("#memSelect3").show();
						
					}); 
					
					$("#memSelect3").change(function(){
						
						if($("#memSelect3").val()== ino){
						$("#ea_line3").val(ino);
						$("#showline3").val(linename3);
						}
					});
					
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
			input.show{
				background-color : transparent;
				border-color : transparent;
				text-align : center;
			}
			
			.lineClass td{
				border:1px solid #dddee0;
				border-collapse:collapse;
				margin:0;
				padding:0;
				border-left: none;	
				border-right: none;
				border-top: none;
			}
			
			table .title{
				font-size:18px;
				font-weight:bold;
				border-bottom: 2px solid #0c335e;
			}
		</style>
	</head>
	<body>
		<table class="">
			<tr>
				<td width="250">
					<table class="lineClass">
						<tr>
							<td colspan="4" class="title"><br><br>
								결재선 지정
							</td>
						</tr>
						<tr>
							<td width="50" align="center" height="30">
								1차
							</td>
							<td>
								<input type="text" name="showline1" id="showline1" readonly class="show">
							</td>
							<td>	
								<input type="button" name="line1_btn" id="line1_btn" value="선택" class="grey_btn">
							</td>
						</tr>
						<tr>
							<td width="50" align="center" height="30">
								2차
							</td>
							<td>
								<input type="text" name="showline2" id="showline2" readonly class="show">
							</td>
							<td>	
								<input type="button" name="line2_btn" id="line2_btn" value="선택" class="grey_btn">
							</td>
						</tr>
						<tr>
							<td width="50" align="center" class="3rdline" height="30">
								3차
							</td>
							<td>
								<input type="text" name="showline3" id="showline3" readonly class="show">
							</td>
							<td>	
								<input type="button" name="line3_btn" id="line3_btn" value="선택" class="grey_btn">
							</td>
						</tr>
					</table>					
				</td>
				<td>
					<table>
						<tr height="68"><td><br><br></td>
						</tr>
						<tr height="30">
							<td height="30">
								<select id="deptSelect1">
									<option>선택</option>
								</select>
								<select id="teamSelect1">
									<option>선택</option>	
								</select>
								<select id="memSelect1">
									<option>선택</option>	
								</select>								
							</td>
						</tr>
						<tr height="30">
							<td height="30">
								<select id="deptSelect2">
									<option>선택</option>
								</select>
								<select id="teamSelect2">
									<option>선택</option>	
								</select>
								<select id="memSelect2">
									<option>선택</option>	
								</select>							
							</td>
						</tr>
						<tr height="30">
							<td height="30">
								<select id="deptSelect3">
									<option>선택</option> 
								</select>
								<select id="teamSelect3">
									<option>선택</option>	
								</select>
								<select id="memSelect3">
									<option>선택</option>	
								</select>								
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2"><br><br>
					<form name="d" id="d">
						<input type="button" name="cc_btn" id="cc_btn" value="취소" onclick="window.close()" class="grey_btn">
						<input type="button" name="ok_btn" id="ok_btn" value="완료" onclick="window.close()" class="blue_btn">
						<input type="button" name="ok2_btn" id="ok2_btn" value="완료" onclick="window.close()" class="blue_btn">
					</form>
				</td>
				
			</tr>
		</table>	
		<form name="eaGianForm" id="eaGianForm" accept-charset="utf-8" target="main">
			<input type="hidden" name="ea_line1" id="ea_line1" >
			<input type="hidden" name="ea_line2" id="ea_line2" >
			<input type="hidden" name="ea_line3" id="ea_line3" >					
	    </form>
	</body>
</html>