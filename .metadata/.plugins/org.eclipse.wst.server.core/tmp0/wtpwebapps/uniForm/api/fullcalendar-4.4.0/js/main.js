// ========== 변수 선언 ============================
var draggedEventIsAllDay;
var activeInactiveWeekends = true;

//현재 로그인 중인 아이디의 세션에서 꺼내온 회원번호(hidden태그)
var loginIno = $('#i_no');

// 필터 체크박스에서 공유캘린더 태그를 가져와 변수에 바인딩
var typeFilter = $('input:checkbox.type_filter:checked');
// 필터 체크박스에서 부서 태그를 가져와 변수에 바인딩
var deptFilter = $('input:checkbox.dept_filter:checked');

// ======= 일정 hover시 출력되는 일정요약 시작-종료시간 데이터포맷 =============
function getDisplayEventDate(event) {
	var displayEventDate;	
	
	// allDay가 아닐 경우 시간 포맷 HH:mm
	if (event.allDay === false) {
	    var startTimeEventInfo = moment(event.start).format('HH:mm');
	    var endTimeEventInfo = moment(event.end).format('HH:mm');
	    displayEventDate = startTimeEventInfo + " - " + endTimeEventInfo;
	// allDay일 경우 "하루종일"출력
	} else { 
		displayEventDate = "하루종일"; 
	}	
	
	return displayEventDate;
}
//======= 부서코드 변환 함수 =======================
function replaceDeptCode(code){
	console.log('etcSetting.js >>> 부서코드 변환 함수 code : ' + code);
	if(code!=null && code.length>0){
		code = code.replace("12","기획처");
		code = code.replace("13","교학처");
		code = code.replace("14","사무처");
		code = code.replace("15","국제협력처");
		code = code.replace(",",", ");
		code = ">> " + code;
	}else{
		code = "";
	}
	
	return code;
}
//======= 널값 빈칸 변환 함수 ======================
function isEmpty(value){
	console.log('etcSetting.js >>> 널값 빈칸 변환 함수');
	if(value==null || value.length===0){
		return "";
	}else{
		return value;
	}
}
// ========== 조회필터 =================================
// 전체일정(array) 캘린더에 뿌려줄 때 호출할 함수
function filtering(array) {
	console.log('filtering 함수 시작 >>> 공유캘린더 array.type : ' + array.type
									    + ', array._id : ' + array._id);
	// 함수 리턴값 boolean
	var filterBool = false;	

	// 공유캘린더 필터 선택값(전체 or 부서 or 개인 )
	var typeVal = $("input:radio[name='typeFilter']:checked").val();
	console.log('typeVal : ' + typeVal);
		
	// 전체를 선택했을 경우
	if(typeVal == '전체'){
		console.log('if문 진입 typeVal >>> 전체!');
		filterBool = true;
		console.log('filterBool : ' + filterBool);
		return filterBool;		
	}
	// 부서를 선택했을 경우
	if(typeVal == '부서'){
		console.log('if문 진입 typeVal >>> 부서!');
		filterBool = typeVal.indexOf(array.type) >= 0;
		console.log('filterBool : ' + filterBool);
		return filterBool;
	}
	// 개인을 선택했을 경우
	if(typeVal == '개인'){
		console.log('if문 진입 typeVal >>> 개인!');
		filterBool = typeVal.indexOf(array.type) >= 0;
		
		// 부서 체크값 배열로 가져오기(12,13,14,15)
		var deptCheck = $('input:checkbox.dept_filter:checked').map(function () {
			console.log('$(this).val() : ' + $(this).val());
			return $(this).val();
		}).get();
		
		console.log('필터 >>> deptCheck : ' + deptCheck + ' deptCheck.length : ' + deptCheck.length);
		console.log('필터 >>> array.dept : ' + array.dept);
				
		// 부서 필터 체크박스를 같이 선택했을 경우
		if(deptCheck && deptCheck.length>0){
			// 공유캘린더가 부서인 일정 중에서
			if(array.dept!=null && array.dept.length>0){	
				// db에서 가져온 부서데이터 구분자로 쪼개서 배열로 리턴
				var arrDept = array.dept.split(',');
				var arrDeptVal;
				for(var i=0; i<arrDept.length; i++){
					arrDeptVal = arrDept[i];
					console.log('arrDept['+i+'] : ' + arrDeptVal);
					
					filterBool = deptCheck.indexOf(arrDeptVal) >= 0;
					console.log('테스트 filterBool : ' + filterBool);
				} // end of for
			} // end of array.dept 널체크
		}// end of 부서필터 널체크			
		console.log('filterBool : ' + filterBool);
		return filterBool;
	}
		
	console.log('filterBool : ' + filterBool);
	return filterBool;
} // end of filtering() ============================

function calDateWhenResize(event) {

  var newDates = {
    startDate: '',
    endDate: ''
  };

  if (event.allDay) {
    newDates.startDate = moment(event.start._d).format('YYYY-MM-DD');
    newDates.endDate = moment(event.end._d).subtract(1, 'days').format('YYYY-MM-DD');
  } else {
    newDates.startDate = moment(event.start._d).format('YYYY-MM-DD HH:mm');
    newDates.endDate = moment(event.end._d).format('YYYY-MM-DD HH:mm');
  }

  return newDates;
} // end of calDateWhenResize()

function calDateWhenDragnDrop(event) {
  // 드랍시 수정된 날짜반영
  var newDates = {
    startDate: '',
    endDate: ''
  }

  //하루짜리 all day
  if (event.allDay && event.end === null) {
    newDates.startDate = moment(event.start._d).format('YYYY-MM-DD');
    newDates.endDate = newDates.startDate;
  }

  //2일이상 all day
  else if (event.allDay && event.end !== null) {
    newDates.startDate = moment(event.start._d).format('YYYY-MM-DD');
    newDates.endDate = moment(event.end._d).subtract(1, 'days').format('YYYY-MM-DD');
  }

  //all day가 아님
  else if (!event.allDay) {
    newDates.startDate = moment(event.start._d).format('YYYY-MM-DD HH:mm');
    newDates.endDate = moment(event.end._d).format('YYYY-MM-DD HH:mm');
  }

  return newDates;
}

// ========== 메인 캘린더 화면 출력  ===================================================
// planMain.jsp 파일에서 <div id="calendar">태그 위치에 캘린더 출력
var calendar = $('#calendar').fullCalendar({

  eventRender: function (event, element, view) {
	  
	  // ajax 성공시 리턴할 데이터 담을 변수
	  var renderResult;
	  	  
    // 일정요약 hover에 뿌려주기 위해, event객체에 없는 데이터는 글번호로 상세조회해서 가져오기
    $.ajax({
      type: "POST",
      url: "/plan/planDetail.uni",
      async: false,
      dataType: "json",
      data: {
    	  pm_no: event._id
      },
      success: function (response) {
    	  // 상세조회에 성공해서 꺼내온 데이터는 map형식으로 array객체에 담겨있음
    	  var eventDataMap = response.map(function (array) {
    		  
  		    // 일정에 hover시 일정요약
  		    element.popover({
  		    	title: $('<div />', {
  		    		class: 'popoverTitleCalendar',
  		    		text: array.title
  		    	}).css({
  		    		'background': event.backgroundColor,
  		    		'color': event.textColor
  		    	}),
  		    	content: $('<div />', {
  		    		class: 'popoverInfoCalendar'
  		    	}).append('<p><strong>일정명:</strong> ' + array.title + '</p>')
  		    	  .append('<p><strong>등록인:</strong> ' + array.username + '</p>')
  		    	  .append('<p><strong>캘린더:</strong> ' + array.type + ' ' + replaceDeptCode(array.dept) +'</p>')
  		    	  .append('<p><strong>시간:</strong> ' + getDisplayEventDate(event) + '</p>')
  		    	  .append('<p><strong>장소:</strong>' + isEmpty(array.place) + '</p>')
  		    	  .append('<div class="popoverDescCalendar"><strong>내용:</strong> ' + isEmpty(array.description) + '</div>'),
  		    	delay: {
  		    		show: "800",
  		    		hide: "50"
  		    	},
  		    	trigger: 'hover',
  		    	placement: 'top',
  		    	html: true,
  		    	container: 'body'
  		    }); // end of element.popover
  		    
  		    // 리턴해줄 필터링 함수 결과값
  		    renderResult = filtering(array);
  		    console.log('renderResult : ' + renderResult);
  		    
    	  }) // end of eventDataMap
      },
      error: function(request, status, error){
      		alert('code='+request.status+" message=" + request.responseText + " error=" + error);
      }		      
	}); // end of ajax
    return renderResult;
  }, // end of eventRender

  // 주말 숨기기 & 보이기 버튼
  customButtons: {
    viewWeekends: {
      text: '주말',
      click: function () {
        activeInactiveWeekends ? activeInactiveWeekends = false : activeInactiveWeekends = true;
        $('#calendar').fullCalendar('option', {
          weekends: activeInactiveWeekends
        });
      }
    }
  }, // end of customButtons

  // 헤더 버튼 & 뷰 포멧
  header: {
    left: 'today',
    center: 'prevYear, prev, title, next, nextYear',
    right: 'month,agendaWeek,agendaDay,listWeek'
  }, // end of header
  views: {
    month: {
      columnFormat: 'dddd'
    },
    agendaWeek: {
      columnFormat: 'M/D ddd',
      titleFormat: 'YYYY년 M월 D일',
      eventLimit: false
    },
    agendaDay: {
      columnFormat: 'dddd',
      eventLimit: false
    },
    listWeek: {
      columnFormat: ''
    }
  }, // end of views

//========== 전체일정 데이터 가져오기  ===================================================
  events: function (start, end, timezone, callback) {
	    $.ajax({
	      type: "POST",
	      url: "/plan/planList.uni",
	      dataType: "json",
	      data: {
	    	  // 날짜를 전달해 일정기간 데이터만 조회하기
	    	  // start와 end는 api가 제공해주는 prop으로 현재 렌더링된 달력 view의 첫날과 마지막날
	    	  // 년월까지만 자르고 db 쿼리문 조건부에서 비교
	    	  pm_start: start.format('YYYY-MM'),
	    	  pm_end: end.format('YYYY-MM'),
	    	  i_no: loginIno.val()
	      },
	      success: function (response) {
	    	  
	        var fixedDate = response.map(function (array) {
	        	// allDay(하루종일)는 true이고, start(시작일)과 end(종료일)이 다를 때(이틀 이상)
	        	if (array.allDay && array.start !== array.end) {
	            // 이틀 이상 AllDay 일정인 경우 달력에 표기시 종료일에 하루를 더해야 정상출력
	            array.end = moment(array.end).add(1, 'days');
	        	}
	        	return array;
	        });
	        callback(fixedDate);
	      } // end of success
	    }); // end of ajax
	  }, // end of events

  eventAfterAllRender: function (view) {
	// 월간캘린더 열람시 높이 자동 조정  
    if (view.name == "month") {
      $(".fc-content").css('height', 'auto');
    }
  },

  // 일정 리사이즈
  eventResize: function (event, delta, revertFunc, jsEvent, ui, view) {
    $('.popover.fade.top').remove();

    /** 리사이즈시 수정된 날짜반영
     * 하루를 빼야 정상적으로 반영됨. */
    var newDates = calDateWhenResize(event);

    //리사이즈한 일정 업데이트
    $.ajax({
      type: "POST",
      url: "",
      data: {
        id: event._id,
        //....
      },
      success: function (response) {
        alert('수정: ' + newDates.startDate + ' ~ ' + newDates.endDate);
      }
    });

  },

  eventDragStart: function (event, jsEvent, ui, view) {
    draggedEventIsAllDay = event.allDay;
  },

  // 일정 드래그앤드롭
  eventDrop: function (event, delta, revertFunc, jsEvent, ui, view) {
    $('.popover.fade.top').remove();

    //주,일 view일때 종일 <-> 시간 변경불가
    if (view.type === 'agendaWeek' || view.type === 'agendaDay') {
      if (draggedEventIsAllDay !== event.allDay) {
        alert('드래그앤드롭으로 종일<->시간 변경은 불가합니다.');
        location.reload();
        return false;
      }
    }

    // 드랍시 수정된 날짜반영
    var newDates = calDateWhenDragnDrop(event);

    //드롭한 일정 업데이트
    $.ajax({
      type: "POST",
      url: "",
      data: {
        //...
      },
      success: function (response) {
        alert('수정: ' + newDates.startDate + ' ~ ' + newDates.endDate);
      }
    });

  },

  	// 일자 클릭 이벤트
  	select: function (startDate, endDate, jsEvent, view) {
		// 기존에 바인딩했던 click이벤트 해제하기
		$(".fc-body").unbind('click');
		// click이벤트 새로 주기
		$(".fc-body").on('click', 'td', function (e) {
		// 공유캘린더 선택메뉴에 class,css주기
			
			var x = e.pageX - 630;
			var y = e.pageY - 470;
		$("#contextMenu")
			.addClass("contextOpened")
			.css({
				display: "block",
				left: x,
				top: y
			});
		return false;
	});
    // 오늘 날짜 데이터
    var today = moment();

    // 월간캘린더 열람시 시작일,종료일 셋팅
	if (view.name == "month") {
		startDate.set({
			hours: today.hours(),
			minute: today.minutes()
		});
		startDate = moment(startDate).format('YYYY-MM-DD HH:mm');
//		console.log('일자클릭이벤트 main.js >>> endDate 하루 빼기 전 : ' + moment(endDate).format('YYYY-MM-DD HH:mm'));
		// 일자 클릭시 endDate는 다음날 00:00로 자동셋팅 되므로 하루를 빼야함
		endDate = moment(endDate).subtract(1, 'days');
//		console.log('일자클릭이벤트 main.js >>> endDate 하루 뺀 후 : ' + moment(endDate).format('YYYY-MM-DD HH:mm'));
		// 하루를 빼면 시작일과 동일해지므로 1시간을 더해줌
		endDate.set({
			hours: today.hours() + 1,
			minute: today.minutes()
		});
		endDate = moment(endDate).format('YYYY-MM-DD HH:mm');
	} else {
		// 월간캘린더가 아닐 경우 다음날 00:00을 endDate로 사용
		startDate = moment(startDate).format('YYYY-MM-DD HH:mm');
		endDate = moment(endDate).format('YYYY-MM-DD HH:mm');
	}

    // 공유캘린더 선택메뉴 태그 변수설정
    var $contextMenu = $("#contextMenu");
    
    // 공유캘린더 선택메뉴 클릭시 발생이벤트
    $contextMenu.on("click", "a", function (e) {
      // url링크 자동이동 방지
      e.preventDefault();
      // 클릭한 값이 닫기가 아닐 때
      if ($(this).data().role !== 'close') {
    	// 일정추가함수 newEvent 호출, 선택한 데이터(eventType)넘기기
        newEvent(startDate, endDate, $(this).html());
      }
      // 공유캘린더 선택메뉴에 줬던 class제거 후 안보이게 숨기기
      $contextMenu.removeClass("contextOpened");
      $contextMenu.hide();
    });

    // 선택메뉴가 아닌 부분 클릭시 발생 이벤트
    $('body').on('click', function () {
    	// 공유캘린더 선택메뉴에 줬던 class제거 후 안보이게 숨기기
    	$contextMenu.removeClass("contextOpened");
    	$contextMenu.hide();
    });
  }, // end of event(일자클릭)

  // 이벤트 클릭시 상세보기 이벤트 함수 호출(detailEvent.js)
  eventClick: function (event, jsEvent, view) {
	  detailEvent(event);
  },

  defaultView: 'month',
  defaultDate: new Date(),
  locale: 'ko',
  timezone: "local",
  nextDayThreshold: "09:00:00",
  allDaySlot: true,
  displayEventTime: true,
  displayEventEnd: true,
  firstDay: 0, //월요일이 먼저 오게 하려면 1
  weekNumbers: false,
  selectable: true,
  weekNumberCalculation: "ISO",
  eventLimit: true,
  views: {
    month: {
      eventLimit: 12
    }
  },
  eventLimitClick: 'week', //popover
  navLinks: true,
  timeFormat: 'HH:mm',
  defaultTimedEventDuration: '01:00:00',
  editable: true,
  minTime: '00:00:00',
  maxTime: '24:00:00',
  slotLabelFormat: 'HH:mm',
  weekends: true,
  nowIndicator: true,
  dayPopoverFormat: 'MM/DD dddd',
  longPressDelay: 0,
  eventLongPressDelay: 0,
  selectLongPressDelay: 0
}); // end of calendar