var i_no = $("#i_no").val();

window.onload = function () {
	            if (window.Notification) {
	                Notification.requestPermission();
	            }
	        }

var timeId = setInterval(function(){
	        	var size = $("#size").val();
	        	$.ajax({
	        		url:"/main/getMessageCnt.uni",
	        		type:"POST",
	        		data:{
	        			i_no:i_no
	        		},
	        		success:function(data){
	        			if(data>size){
	        				var cnt = data - size;
	        				$("#size").val(data);
	        				notifyM(cnt);
	        			}
	        		},
	        		error:function(e){
	        			alert("에러났다 > : " + e);
	        		}
	        	});
	        },10000);

var calendarId = setInterval(function(){	
					var getTimes = getTime();
					console.log("rrrr >> : " +  getTimes);
					$.ajax({
						url:"/main/getPlanList.uni",
						type:"POST",
						dataType:"json",
						data:{
							i_no:i_no
						},
						success:function(data){
							for(var i=0;i<data.length;i++){
								
								var timeBool = data[i].pm_alarmTime==getTimes;
								
								if(timeBool){
									notifyA();
								}
							}
						},
						error:function(request,status,error){
							console.log("에러 났다 >> : " +  request.status + " : error=" + error);
						}
					});
				 },1000);

function getTime(){
	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	var day = date.getDate();
	var hour = date.getHours();
	var minute = date.getMinutes();
	var second = date.getSeconds();
	
	var nowTime = year + "-" + addzero(month) + "-" + addzero(day) + " " + addzero(hour) + ":" + addzero(minute);
	console.log(nowTime + ":" + addzero(second));
	
	return nowTime;
}


function notifyM(cnt) {
	clearTimeout(timeId);
    if (Notification.permission !== 'granted') {
        alert('notification is disabled');
    }
    else {
        var notification = new Notification('새로운 쪽지가 도착했습니다', {
            icon: 'http://localhost:8088/pilotExam/pushWeb/img/calendar.gif',
            body: '새 쪽지 '+cnt+'개',
        });
        
        notification.onclick = function () {      
            location.href='/mm/goMessageMain.uni';
        };
    }
}

function notifyA() {
	clearTimeout(calendarId);
    if (Notification.permission !== 'granted') {
        alert('notification is disabled');
    }
    else {
        var notification = new Notification('일정을 확인해 주세요', {
            icon: 'http://localhost:8088/pilotExam/pushWeb/img/calendar.gif',
            body: '일정 확인',
        });
        
        notification.onclick = function () {
            location.href='/main/pmGoPlanMain.uni';
        };
    }
}


function addzero(num) {

	if(num < 10) { num = "0" + num; }

		return num;

}