// ======= 모달창 닫을 때 초기화 함수 =================
$('.modal').on('hidden.bs.modal', function (e) {
    console.log('etcSetting.js >>> modal창 닫고 초기화');
    
    $(this).find('input, textarea').val("");
    $(this).find("select[name='color']").val("#D25565").css("color","#D25565");
    // 내부참여자,쪽지수신인 초기화하기
    $(this).find("select[name='participant']").val("");
    $(this).find("select[name='recipient']").val("");
    $(this).find("input:checkbox").prop('checked', false);
    
});

// ===== 공유캘린더'부서'선택시 modal에 부서 체크박스 나타내기 ========
editType.on('change', function () {
	if(editType.val() == '부서'){
		console.log('etcSetting.js >>> 부서 선택');
		addDeptRow.show();
	}else{
		addDeptRow.hide();
	}
});

// ===== 일정등록(수정)시 색상 선택할 때 modal 헤더 색상도 변경하기 =======
editColor.change(function () {
	var changeColor = $(this).val();
    $(this).css('color', changeColor);
    modalHeader.css('background', changeColor)
		       .css('border-top-left-radius','6px')
		       .css('border-top-right-radius','6px');
});

// ==== 알림여부 체크시 일정등록(수정)modal에 시간설정 나타내기 =======
editAlarm.on('change', function () {
	if (editAlarm.is(':checked')) {
		console.log('etcSetting.js >>> 알람여부 체크');
		addAlarmTimeRow.show();
	}else{
		addAlarmTimeRow.hide();
	}
});

// 쪽지수신여부 체크시 일정등록(수정)modal에 쪽지수신인 설정 row 나타내기
editMessage.on('change', function () {
	if (editMessage.is(':checked')) {
		console.log('etcSetting.js >>> 쪽지기능 체크');
		addRecipientRow.show();
	}else{
		addRecipientRow.hide();
	}
});

// ===================================================
// 알람시간 설정에 datetimepicker 사용
editAlarmTime.datetimepicker({
    format: 'YYYY-MM-DD HH:mm'
});

// 시작일, 종료일에 datetimepicker 사용
$("#edit-start, #edit-end").datetimepicker({
    format: 'YYYY-MM-DD HH:mm'
});

//
////내부참여자에 select2 사용
//$("#edit-participant").select2({
//    placeholder: "내부참여자 선택..",
//    allowClear: true
//});
//
//// 쪽지수신인에 select2 사용
//$("#edit-recipient").select2({
//    placeholder: "선택..",
//    allowClear: true
//});








//// editAllDay
//editAllDay.on('change', function () {
//	if (editAllDay.is(':checked')) {
//		$("#edit-start").datetimepicker().data('DateTimePicker').format('YYYY-MM-DD');
//		$("#edit-end").datetimepicker().data('DateTimePicker').format('YYYY-MM-DD');
//	}else{
//		$("#edit-start").datetimepicker().data('DateTimePicker').format('YYYY-MM-DD HH:mm');
//		$("#edit-end").datetimepicker().data('DateTimePicker').format('YYYY-MM-DD HH:mm');
//	}
//});
// ============ 필터 =============================================
// ========== 캘린더 조회 ======================
$('.type_filter').on('change', function () {
    $('#calendar').fullCalendar('rerenderEvents');
    // 공유캘린더 체크된 radio태그
    var typeFilterChck = $("input:radio[name=typeFilter]:checked");
    console.log('typeFilterChck.val() : ' + typeFilterChck.val());
    
    // '전체'를 선택할 경우 부서 체크박스 disabled 속성 추가
    if(typeFilterChck.val() === '전체'){
    	$('.dept_filter').attr("disabled", true);
    }
    // '부서'를 선택할 경우 부서 체크박스 disabled 속성 추가
    if(typeFilterChck.val() === '부서'){
    	$('.dept_filter').attr("disabled", true);
    	// 부서 체크박스 체크해제
    	$("input:checkbox[name='dept_filter']").prop("checked", false);
    }
    // '개인'을 선택할 경우 부서 체크박스 disabled 속성 제거
    if(typeFilterChck.val() === '개인'){
    	$('.dept_filter').attr("disabled", false);
    }   
});

// ======== 부서 조회 =========================
$('.dept_filter').on('change', function () {
    $('#calendar').fullCalendar('rerenderEvents');
    
    console.log('etcSetting.js >>> dept_filter 체크 변경시 발생 이벤트');
    
    // 부서 체크박스 전체를 선택할 경우 공유캘린더 전체 선택 후 disabled 속성 추가   
    var dept = $('input:checkbox.dept_filter:checked').map(function () {
    	console.log('$(this).val() : ' + $(this).val());
    	return $(this).val();
    }).get();
   
    console.log('dept : ' + dept + ', dept.length : ' + dept.length);
    
    if(dept.length===4){
    	console.log('부서 체크박스 4개 전부 선택됨');
    	// 공유캘린더 부서 선택
    	$("input:radio[id='typeFilterAll']").prop("checked", true);
    	// 부서 체크박스 비활성화
    	$('.dept_filter').attr("disabled", true);
    	// 부서 체크박스 체크해제
    	$("input:checkbox[name='dept_filter']").prop("checked", false);
    }
    
});





