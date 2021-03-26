// 일정수정 modal에 있는 저장,취소버튼(일정등록 modal과 공유)
//var modifyBtnContainer = $('.modalBtnContainer-modifyEvent');

var deleteID = "";

/* ****************
 *  일정 편집
 * ************** */
var editEvent = function (event, element, view) {
	alert('일정수정 일정번호 데이터 확인 _id >>> ' + event._id);
	
    $('.popover.fade.top').remove();
    $(element).popover("hide");
    
    // 부서선택 체크박스 숨겨놓기
    addDeptRow.hide();
    // 알람시간 선택 datepicker 숨겨놓기
    addAlarmTimeRow.hide();
    // 쪽지수신인 선택 숨겨놓기
    addRecipientRow.hide();    
    
    deleteID = event._id;
    
    // event객체에 없는 데이터는 글번호로 상세조회 해서 가져오기
    $.ajax({
	      type: "POST",
	      url: "/plan/planDetail.uni",
	      dataType: "json",
	      data: {
	    	  pm_no: event._id
	      },
	      success: function (response) {	    	  
	        var eventDetailMap = response.map(function (array) {

	            // 수정폼에 기존 데이터 뿌려주기
	            modalTitle.html('일정 수정').css('color', '#ffffff');
	            editTitle.val(array.title);
	            editStart.val(moment(array.start).format('YYYY-MM-DD HH:mm'));
	            editEnd.val(moment(array.end).format('YYYY-MM-DD HH:mm'));
	            editType.val(array.type);
	            editDesc.val(array.description);
	            editColor.val(array.backgroundColor).css('color', array.backgroundColor);
	        	editPlace.val(array.place);
	        	editAlarmTime.val(array.alarmTime);
	        	editRecipient.val(array.recipient);	
	        	        	
	        	// 공유캘린더가 부서일 경우, 부서선택 체크박스 보여주기
	            if(array.type == '부서'){
	        		addDeptRow.show();
	        	}
	            // 알림설정이 true일 경우, 알림시간 선택 datepicker 보여주기
	            if(array.alarm == 'true'){
	            	addAlarmTimeRow.show();
	        	}
	            // 쪽지발신이 true일 경우, 쪽지수신인 선택 보여주기
	            if(array.message == 'true'){
	            	addRecipientRow.show();
	        	}
	            
	                    	
	        	// 하루종일 체크값 및 날짜포맷
	            if (array.allDay === true) {
	                editAllDay.prop('checked', true);	                
	                editStart.val(moment(array.start).format('YYYY-MM-DD'));
	                editEnd.val(moment(array.end).format('YYYY-MM-DD'));
	            } else {
	                editAllDay.prop('checked', false);
	            }
	            
	            // 알림여부 체크값
	            if(array.alarm === "true"){
	            	editAlarm.prop('checked', true);
	            }else{
	            	editAlarm.prop('checked', false);
	            }
	            // 쪽지수신여부 체크값
	            if(array.message === "true"){
	            	editMessage.prop('checked', true);
	            }else{
	            	editMessage.prop('checked', false);
	            }
	            
	        	// 부서 체크박스 구분자로 데이터 나눈 뒤 체크속성 입히기
	        	if(array.dept!=null && array.dept.length>0){
	        		console.log("dept 널체크 if문 진입!!! >>> array.dept : " + array.dept);
	        		console.log("array.dept.length : " + array.dept.length);
	        		
	        		// 부서 다중선택 split(',')로 나눠서 배열로 리턴하기	        		
	        		var editDeptArray = array.dept.split(',');        
		        	
		        	for(var i=0;i<editDeptArray.length;i++){
		        		deptCode = editDeptArray[i];
		        		console.log('editDeptArray.['+i+'] : ' + deptCode);
		        		if(deptCode === "12"){
		        			dept12.prop('checked', true);
		        		}
		        		if(deptCode === "13"){
		        			dept13.prop('checked', true);
		        		}
		        		if(deptCode === "14"){
		        			dept14.prop('checked', true);
		        		}
		        		if(deptCode === "15"){
		        			dept15.prop('checked', true);
		        		}
		        	} // end of for		

	        	} // end of if(부서데이터 널체크)

	        })
	        console.log('수정용 상세조회 데이터 조회 성공!');
	        return eventDetailMap;
	      },
	      error: function(request, status, error){
          	alert('code='+request.status+" message=" + request.responseText + " error=" + error);
          }
	      
	    });  
    
    addBtnContainer.hide();
    modifyBtnContainer.show();
    eventModal.modal('show');

    // 취소버튼 클릭시 입력중이던 데이터 초기화
    $('#modify-reset').unbind();
    $('#modify-reset').on('click', function () {        
        eventModal.modal('hide');
    });
    
    // 지도검색 버튼 클릭시 지도검색 함수 호출(placeMap.js)
    $('#searchPlace').unbind();
    $('#searchPlace').on('click', function (event, jsEvent, view) {
    	console.log('지도검색버튼 클릭!');
    	searchPlace(jsEvent, view);
    });
    
    // 저장(업데이트) 버튼 클릭시
    $('#updateEvent').unbind();
    $('#updateEvent').on('click', function () {

        if (editStart.val() > editEnd.val()) {
            alert('종료일이 시작일보다 빠를 수 없습니다.');
            return false;
        }

        if (editTitle.val() === '') {
            alert('일정명을 입력해주세요.')
            return false;
        }       

    	// 부서 체크박스 중복선택 데이터 배열로 변환 저장
    	var deptArray = Array();
    	var j = 0;

    	for(var i=0; i<deptChk.length; i++){
    		if(deptChk[i].checked == true){
    			deptArray[j] = deptChk[i].value;
    			j++;
    		}
    	}
    	// 배열 스트링 변환
    	editDept = deptArray.toString();
    	
    	// 공유캘린더 부서 선택시, 부서 널체크
        if(editType.val() === '부서'){
        	if(editDept === ""){
        		alert('부서를 한 개 이상 선택해주세요.');
                return false;
        	}
        }

        var statusAllDay;
        var startDate;
        var endDate;
        var statusAlarm;
        var statusMessage;
        
        // allDay 체크시 시분초 자르기
        if (editAllDay.is(':checked')) {
            statusAllDay = true;
            startDate = moment(editStart.val()).format('YYYY-MM-DD');
            endDate = moment(editEnd.val()).format('YYYY-MM-DD');
        } else {
            statusAllDay = false;
            startDate = editStart.val();
            endDate = editEnd.val();
        }

        if (editAlarm.is(':checked')) {
        	console.log('checked alarm >>> 체크됨 if문');
        	statusAlarm = "true";
        }else{
        	statusAlarm = "false";
        }
        
        if (editMessage.is(':checked')) {
        	console.log('checked message >>> 체크됨 if문');
        	statusMessage = "true";
        }else{
        	statusMessage = "false";
        }
        
        // 알림설정이 true일 경우, 알람시간 null체크
        if(statusAlarm == 'true'){
        	if(editAlarmTime.val()==null){
        		alert('알림시간을 설정해주세요.')
                return false;
        	}
    	}
        // 쪽지발신이 true일 경우, 쪽지수신인 null체크
        if(statusMessage == 'true'){
        	if(editRecipient.val()==null){
        		alert('쪽지 수신인을 설정해주세요.');
        		return false;
        	}
    	}
        
        eventModal.modal('hide');

        event.allDay = statusAllDay;
        event.start = startDate;
        event.end = endDate;
        
        $("#calendar").fullCalendar('updateEvents', event);
        
        // 일정 업데이트
        $.ajax({
            url: "/plan/planUpdate.uni",
            type: "POST",
            data: {
            	pm_no : event._id,
            	pm_title : editTitle.val(),
            	pm_start : event.start,
            	pm_end : event.end,
            	pm_allDay : event.allDay.toString(),
            	pm_context : editDesc.val(),
            	pm_share : editType.val(),
            	pm_backgroundColor : editColor.val(),
            	pm_dept : editDept,
            	pm_place : editPlace.val(),
            	pm_alarm : statusAlarm,
            	pm_alarmTime : editAlarmTime.val(),
            	pm_message : statusMessage,
            	pm_recipient : editRecipient.val()
            },
            success: function (response) {
                alert('수정되었습니다.');
                $('#calendar').fullCalendar('refetchEvents');
            },
            error: function(request, status, error){
            	alert('code='+request.status+" message=" + request.responseText + " error=" + error);
            }
        });

    });

};