// 상세보기 modal
var eventDetailModal = $('#eventDetailModal');
var modalTitle = $('.modal-title');
var modalHeader = $('.modal-header');

// 상세보기 modal에서 사용하는 태그 아이디
var detailTitle = $('#detail-title');	// 일정명
var detailUsername = $('#detail-username');	// 작성자명
var detailStart = $('#detail-start');	// 시작일
var detailEnd = $('#detail-end');		// 종료일
var detailType = $('#detail-type');		// 공유캘린더
var detailDesc = $('#detail-desc');		// 내용
var detailAllDay = $('#detail-allDay');	// 종일여부
var detailColor = $('#detail-color');	// 색상
// event객체가 제공해주지 않는 추가 데이터 변수		
var detailDept = $('#detail-dept');					// 부서
var detailPlace = $('#detail-place');				// 장소
var detailParticipant = $('#detail-participant');	// 내부참여자
var detailAlarm = $('#detail-alarm');				// 푸쉬알림
var detailAlarmTime = $('#detail-alarmTime');		// 알림시간(푸쉬알림 true일 경우만)
var detailMessage = $('#detail-message');			// 쪽지
var detailRecipient = $('#detail-recipient');		// 쪽지수신인(쪽지 true일 경우만)

// 일정클릭 후 상세보기 데이터 조회할 때 필요한 글번호
var detailPmno = "";					// 글번호
// 상세보기 글 작성자의 회원번호(수정,삭제 권한줄 때 현재 로그인 중인 회원번호와 비교)
var detailIno = "";						// 작성자 회원번호

// 상세보기 modal에 있는 부서
var detailDeptRow = $('.deptRow-detailEvent');
// 상세보기 modal에 있는 알람시간
var detailAlarmTimeRow = $('.alarmTimeRow-detailEvent');
// 상세보기 modal에 있는 쪽지수신인
var detailRecipientRow = $('.recipientRow-detailEvent');

// 상세보기 modal에 있는 버튼 컨테이너
var detailBtnContainer = $('.modalBtnContainer-detailEvent');
// 상세보기 modal에 있는 수정,삭제 버튼
// 세션에서 가져온 회원번호와 조회한 상세보기 데이터의 회원번호 비교
// 일치할 경우 수정,삭제버튼 띄우고 그 외엔 숨기기
var detailBtnPrivilege = $('.privilege-detailEvent');

// ============ 일정 상세보기 함수 ========================================================
var detailEvent = function (event, element, view) {
	console.log('상세보기 일정번호 >>> event. _id : ' + event._id);
	
    $('.popover.fade.top').remove();
    $(element).popover("hide");

    // 부서, 알람시간, 쪽지수신인 숨겨두기
    detailDeptRow.hide();
    detailAlarmTimeRow.hide();
    detailRecipientRow.hide();   
    // 수정, 삭제버튼 숨겨두기
    detailBtnPrivilege.hide();
    
    // 일정수정시 기존 데이터 조회에 사용할 글번호 데이터 event객체에서 꺼내기
    detailPmno = event._id;
    
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
	        	console.log('array.type >>> : ' + array.type);
	        	console.log('array.dept >>> : ' + array.dept);
	        	console.log('array.allDay >>> : ' + array.allDay);

	            // 상세보기 태그에 기존 데이터 뿌려주기
	            modalTitle.html('일정 상세보기').css('color', '#ffffff');
	            modalHeader.css('background', array.backgroundColor).css('border-top-left-radius','6px').css('border-top-right-radius','6px');
	            detailTitle.html(array.title);
	            detailUsername.html(array.username);
	            detailType.html(array.type);
	            detailDesc.html(array.description);
	            detailColor.html(array.backgroundColor).css('color', event.backgroundColor);	        		        	
	        	detailPlace.html(array.place);
	        	detailAlarmTime.html(array.alarmTime);
	        	detailRecipient.html(array.recipient);	    
	        	detailStart.html(array.start);	        	
                detailEnd.html(array.end);
                
                // 세션에서 꺼내온 회원번호
                var loginInoVal = loginIno.val();
                // 상세보기 데이터에서 꺼내온 회원번호
                var iNo = array.i_no;
                console.log('loginInoVal : ' + loginInoVal + ', iNo : ' + iNo);
                
                // 로그인 회원번호과 작성글 회원번호가 일치할 경우 
                if(loginInoVal == iNo){
                    // 수정,삭제버튼 띄우기
                	detailBtnPrivilege.show();
                }
                
                // 공유캘린더 값이 부서일 경우, 부서 보여주기
                if(array.type == "부서"){
                	detailDeptRow.show();
                }
                // 알람여부,쪽지발송에 체크했을 경우 알람시간,쪽지수신인 보여주기
                if(array.alarm === "true"){
                	detailAlarmTimeRow.show();
                }
                if(array.message === "true"){
                	detailRecipientRow.show();
                }
                
	            // allDay가 true일 경우 "ON", 시간생략
	            if (array.allDay === true) {
	            	console.log('array.allDay if문 진입 >>> : ' + array.allDay);
	            	detailAllDay.html("ON");
	            } else {
	            	detailAllDay.html("OFF");
	            }	        	
	            // 알림여부 String을 boolean으로 변환 후 체크
	            if(array.alarm === "true"){
	            	console.log('array.alarm if문 진입 >>> : ' + array.alarm);
	            	detailAlarm.html("ON");
	            }else{
	            	detailAlarm.html("OFF");
	            }
	            // 쪽지수신여부 String을 boolean으로 변환 후 체크
	            if(array.message === "true"){
	            	console.log('array.message if문 진입 >>> : ' + array.message);
	            	detailMessage.html("ON");
	            }else{
	            	detailMessage.html("OFF");
	            }

	            // 부서코드 부서명으로 변환 후 뿌리기
            	detailDept.html(replaceDeptCode(array.dept));

	        })
	        console.log('상세조회 데이터 조회 성공!');
	        return eventDetailMap;
	      },
	      error: function(request, status, error){
          	alert('code='+request.status+" message=" + request.responseText + " error=" + error);
          }
	      
	    });

    detailBtnContainer.show();
    eventDetailModal.modal('show');
//==========================================================================================
    // 수정 버튼 클릭시 수정 modal로 변경
    $('#updateModal').unbind();
    $('#updateModal').on('click', function (event, jsEvent, view) {
    	console.log('상세보기 modal에서 수정버튼 클릭 !');    	   	
    	// 상세보기 modal 숨기기
    	eventDetailModal.modal('hide');
    	// 수정 modal에 뿌려줄 기존데이터 조회용 글번호 event객체에 담기
    	event._id = detailPmno;
    	console.log('상세보기 modal에서 수정버튼 클릭 >>> _id : ' + event._id);
    	
    	// 이벤트 수정 함수 호출(editEvent.js)
    	editEvent(event);
    });

//==========================================================================================
    // 삭제버튼
    $('#deleteEvent').on('click', function () {
        $('#deleteEvent').unbind();
        $("#calendar").fullCalendar('removeEvents', [event._id]);

        eventDetailModal.modal('hide');

        //삭제시
        $.ajax({
            type: "POST",
            url: "/plan/planDelete.uni",
            data: {
            	pm_no : detailPmno
            },
            success: function (response) {
                alert('삭제되었습니다.');
            },
            error: function(request, status, error){
            	alert('code='+request.status+" message=" + request.responseText + " error=" + error);
            }
        });
    });
};