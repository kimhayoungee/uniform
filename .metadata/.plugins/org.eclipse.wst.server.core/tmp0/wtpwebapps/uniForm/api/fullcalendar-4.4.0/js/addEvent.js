// 일정등록 modal
var eventModal = $('#eventModal');

//현재 로그인 중인 아이디의 세션에서 꺼내온 회원번호(hidden태그), 작성자 회원번호로 등록
//var loginIno = $('#i_no');

var editTitle = $('#edit-title');	// 일정명
var editStart = $('#edit-start');	// 시작일
var editEnd = $('#edit-end');		// 종료일
var editType = $('#edit-type');		// 공유캘린더
var editDesc = $('#edit-desc');		// 내용
var editAllDay = $('#edit-allDay');	// 종일여부
var editColor = $('#edit-color');	// 색상

// event객체가 제공해주지 않는 추가 데이터 변수
var editPlace = $('#edit-place');				// 장소
var editParticipant = $('#edit-participant');	// 내부참여자
var editAlarm = $('#edit-alarm');				// 푸쉬알림
var editAlarmTime = $('#edit-alarmTime');		// 알림시간(푸쉬알림 true일 때만)
var editMessage = $('#edit-message');			// 쪽지
var editRecipient = $('#edit-recipient');		// 쪽지수신인(쪽지 true일 때만)

var editDept = "";				// 부서(다중선택된 부서데이터를 하나의 문자열로 변환해서 담아둘 변수)
var deptChk = $('.edit-dept');	// 부서 체크박스
var dept12 = $('#dept12');		// 기획처
var dept13 = $('#dept13');		// 교학처
var dept14 = $('#dept14');		// 사무처
var dept15 = $('#dept15');		// 국제협력처

// 일정등록(수정) modal에 있는 부서 선택 로우
var addDeptRow = $('.deptRow-addEvent');
// 일정등록(수정) modal에 있는 알람시간 로우
var addAlarmTimeRow = $('.alarmTimeRow-addEvent');
// 일정등록(수정) modal에 있는 쪽지수신인 로우
var addRecipientRow = $('.recipientRow-addEvent');

// 일정등록 modal에 있는 저장,취소버튼
var addBtnContainer = $('.modalBtnContainer-addEvent');
// 일정수정 modal에 있는 저장,취소버튼(일정등록 modal과 공유)
var modifyBtnContainer = $('.modalBtnContainer-modifyEvent');

//============ 새일정 등록 함수 ========================================================
var newEvent = function (start, end, eventType) {
	console.log('일정등록 시작일 - 종료일 >>> start - end : ' + start + " - " + end);
	console.log('일정등록 >>> editAllDay : ' + editAllDay);
	
	// 공유캘린더 선택메뉴 숨기기
    $("#contextMenu").hide();
    
    // 알람시간 디폴트값 설정(셀렉트박스로 수정시 1시간 전, 2시간 전, 3시간 전, 1일 전, 1주일 전 등으로 수정)
    // 1.시작일 하루 전
    var alarmTime;
    alarmTime = moment(start).subtract(1,'days').format('YYYY-MM-DD HH:mm');
    console.log('addEvent.js >>> alarmTime : ' + alarmTime);
    
    // 선택한 일자 데이터 및 카테고리 일정등록 modal에 세팅
    modalHeader.css('background', '#D25565')
    		   .css('border-top-left-radius','6px')
    		   .css('border-top-right-radius','6px');
    modalTitle.html('새로운 일정').css('color', '#ffffff');
    editStart.val(start);
    editEnd.val(end);
    editType.val(eventType).prop("selected", true);
    editAlarmTime.val(alarmTime);

    // 부서선택 체크박스 숨기기
    addDeptRow.hide();
    // 메뉴에서 부서를 선택하고 들어왔을 경우, 부서선택 체크박스 보이기
    if(eventType == '부서'){
		console.log('addEvent.js >>> 부서 선택');
		addDeptRow.show();
	}
    // 알람시간 선택 datepicker 숨기기
    addAlarmTimeRow.hide();
    // 쪽지수신인 선택 숨기기
    addRecipientRow.hide();    
    // 일정등록 modal용 저장,취소버튼 보이기
    addBtnContainer.show();
    // 일정수정 modal용 저장,취소버튼 숨기기
    modifyBtnContainer.hide();
    // 일정등록 modal 띄우기
    eventModal.modal('show');
    
    // 취소버튼 클릭시 입력중이던 데이터 초기화
    $('#add-reset').unbind();
    $('#add-reset').on('click', function () {
        eventModal.modal('hide');
    });
    
    // 지도검색 버튼 클릭 지도검색 함수 호출(placeMap.js)
    $('#searchPlace').unbind();
    $('#searchPlace').on('click', function (event, jsEvent, view) {
    	console.log('지도검색버튼 클릭!');
    	searchPlace(event);
    });
    
    // 저장 버튼 클릭
    $('#save-event').unbind();
    $('#save-event').on('click', function () {

    	var alBool = editAlarmTime.val().substring(11,13)<9||editAlarmTime.val().substring(11,13)>=19;
    	
    	if(alBool){
    		alert("업무 시간보다 빠르거나 늦게 설정할 수 없습니다.");
    		return false;
    	}
    	
    	// 부서 체크박스 중복선택 데이터 배열로 변환 저장
    	var deptArray = Array();

//    	var j = 0;
//    	console.log('------- deptChk : ' + deptChk + ' : deptChk.length : ' + deptChk.length);
//    	for(var i=0; i<deptChk.length; i++){
//    		if($('.edit-dept').prop("checked")){
//    			console.log('deptChk['+i+'].value : ' + deptChk[i].value);
//    			deptArray[j] = deptChk[i].value;  			
//    		}
//    		j++;
//    	}
    	
//    	$("input[name='dept[]']:checked").each(function() {
//			var test = $(this).val();
//			console.log('1-------test : ' + test);
//			deptArray.push(test);
//			console.log('2-------deptArray.toString() : ' + deptArray.toString());
//		});
    	
    	var testStr = "";
    	$("input[name='dept[]']:checked").each(function() {
    		var test = $(this).val();
    		testStr = testStr + test + ",";	
    	});
    	testStr = testStr.substring(0,testStr.lastIndexOf(','));    	
    	editDept = testStr;
    	
    	// 배열 스트링 변환
    	//editDept = deptArray.toString();
    	console.log('콤마 찍혔나 확인 >>> editDept : ' + editDept);
    	
    	// 일정등록 modal input 태그에 입력된 데이터 가져오기
        var eventData = {
        	i_no: loginIno.val(),	
            title: editTitle.val(),
            start: editStart.val(),
            end: editEnd.val(),
            description: editDesc.val(),
            type: editType.val(),
            backgroundColor: editColor.val(),
            textColor: '#ffffff',
            allDay: false,
            dept: editDept,
            place: editPlace.val(),
            alarm: editAlarm.val(),
            alarmTime: editAlarmTime.val(),
            message: editMessage.val(),
            recipient: editRecipient.val()
        };

        if (eventData.start > eventData.end) {
            alert('종료일이 시작일보다 앞설 수 없습니다.');
            return false;
        }

        if (eventData.title === '') {
            alert('일정명을 입력해주세요.');
            return false;
        }
        
        if(eventData.type === '부서'){
        	console.log('1 eventData.dept : ' + eventData.dept);
        	if(eventData.dept === ""){
        		console.log('2 eventData.dept : ' + eventData.dept);
        		alert('부서를 한 개 이상 선택해주세요.');
                return false;
        	}
        }
        
        var realEndDay;

        // 하루종일에 체크돼있을 경우
        if (editAllDay.is(':checked')) {
        	// 시작일, 종료일 날짜포맷 셋팅(시간 없음)
            eventData.start = moment(eventData.start).format('YYYY-MM-DD');
            eventData.end = moment(eventData.end).format('YYYY-MM-DD');
            eventData.allDay = "true";
        }else{
        	eventData.allDay = "false";
        }
        
        if (editAlarm.is(':checked')) {
        	console.log('checked alarm >>> 체크됨 if문');
        	eventData.alarm = "true";
        }else{
        	eventData.alarm = "false";
        }
        
        if (editMessage.is(':checked')) {
        	console.log('checked message >>> 체크됨 if문');
        	eventData.message = "true";
        }else{
        	eventData.message = "false";
        }
        
        // 알림설정이 true일 경우, 알람시간 null체크
        if(eventData.alarm == 'true'){
        	if(eventData.alarmTime==null){
        		alert('알림시간을 설정해주세요.')
                return false;
        	}
    	}
        // 쪽지발신이 true일 경우, 쪽지수신인 null체크
        if(eventData.message == 'true'){
        	if(eventData.recipient==null){
        		alert('쪽지 수신인을 설정해주세요.');
        		return false;
        	}
    	}
        
        //새로운 일정 저장
        $.ajax({
            url: "/plan/planInsert.uni",
            type: "POST",
            data:{
            	i_no : eventData.i_no,
            	pm_title : eventData.title,
            	pm_start : eventData.start,
            	pm_end : eventData.end,
            	pm_context : eventData.description,
            	pm_share : eventData.type,
            	pm_backgroundColor : eventData.backgroundColor,
            	pm_textColor : "#ffffff",
            	pm_allDay : eventData.allDay,
            	pm_dept : eventData.dept,
            	pm_place : eventData.place,
            	pm_alarm : eventData.alarm,
            	pm_alarmTime : eventData.alarmTime,
            	pm_message : eventData.message,
            	pm_recipient : eventData.recipient
            },
            success: function (response) {
            	alert('등록되었습니다.');
                // DB연동시 중복이벤트 방지를 위한
                $('#calendar').fullCalendar('removeEvents');
                // 리프레쉬
                $('#calendar').fullCalendar('refetchEvents');
            },
            error: function(request, status, error){
            	alert('일정 등록에 실패했습니다.');
            	alert('code='+request.status+" message=" + request.responseText + " error=" + error);
            }
            
        });
               
        $("#calendar").fullCalendar('renderEvents', eventData, true);        
        eventModal.modal('hide');
        

    });
};


$('body').on('shown.bs.modal', '.modal', function() {
	  $(this).find('select').each(function() {
	    var dropdownParent = $(document.body);
	    if ($(this).parents('.modal.in:first').length !== 0)
	      dropdownParent = $(this).parents('.modal.in:first');
	    //내부참여자에 select2 사용
	    $("#edit-participant").select2({
	    	ajax: {
	    		url: '/plan/planSearchMember.uni',
	    		type: 'post',
	    		dataType: 'json',
	    		delay: 250,
	    		// 검색 쿼리
	    		data: function (params) {
	    			return {
	    				// 검색창에 입력하는 단어
	    				q: params.term,
	    				page: params.page
	    			};
	    		},
	    		// 결과 표현
	    		processResults: function (data, params) {
	    			
	    			params.page = params.page || 1;
	    			 
	    			return {
	    				results: $.map(data, function(items){
//	    					alert('results >>> i_nameKr : ' + data.i_nameKr + ', pm_dept : ' + data.pm_dept + ', params.page : ' + params.page);
	    					
	    					return{
	    						i_nameKr: data.i_nameKr,
	    						pm_dept: data.pm_dept,
	    						i_no: data.i_no,
	    						pagination: {
	    					          more: (params.page * 20) < data.total_count
	    					    }
	    					}
	    				})
	    			};
	    		}, // end of processResults
	    		cache: true,
	    	}, // end of ajas
	    	placeholder: "내부참여자 검색",
	    	allowClear: true,
	    	closeOnSelect: false,
	    	tokenSeparators: [',', ' '],
	    	dropdownParent: dropdownParent,
	    	templateResult: formatMemberList,
	    	templateSelection: formatMemberSelection
	    }); // end of select2
	      
	    function formatMemberList(member){
	    	if(member.loading){
	    		return member.text;
	    	}
	    	
	    	var $container = $(
	    		"<span class='memI_nameKr'>" + member.i_nameKr + "</span>" +
	    		"<span class='memPm_dept'>" + member.pm_dept + "</span>"
	    	); // end of var $container
	    	
	    	$container.find("span[class='memI_nameKr']").text(member.i_nameKr);
	    	$container.find("span[class='memPm_dept']").text(member.pm_dept);
	    } // end of formatMemberList 함수

	    function formatMemberSelection (member) {
	    	  return member.i_nameKr || member.text;
	    }
	   
	  });
	});
////내부참여자에 select2 사용
//$("#edit-participant").select2({
//	ajax: {
//		url: '/plan/planSearchMember.uni',
//		type: 'post',
//		dataType: 'json',
//		delay: 250,
//		// 검색 쿼리
//		data: function (params) {
//			return {
//				// 검색창에 입력하는 단어
//				q: params.term		
//			};
//		},
//		// 결과 표현
//		processResults: function (data) {
//			return {
//				results: $.map(data, function(items){
//					return{
//						i_nameKr: items.i_nameKr,
//						pm_dept: items.pm_dept,
//						i_id: items.i_no
//					}
//				})
//			};
//		}, // end of processResults
//		cache: true,
//	}, // end of ajas
//	placeholder: "내부참여자 검색",
//	allowClear: true,
////	closeOnSelect: false,
//	templateResult: formatMemberList,
//	templateSelection: formatMemberSelection
//});

//쪽지수신인에 select2 사용
$("#edit-recipient").select2({
placeholder: "쪽지수신인 검색",
allowClear: true
});
