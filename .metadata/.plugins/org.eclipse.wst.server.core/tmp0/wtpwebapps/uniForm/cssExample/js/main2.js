$(document).ready(function(){
	var mndMenuId = location.href;
    
	if (mndMenuId.indexOf("mnd_05") >= 0) {   
		document.getElementById('prevMenu').innerHTML = "국방부 소개";
		document.getElementById('nextMenu').innerHTML = "민원ㆍ국민참여";
		$(".box_cate_name").addClass("mnd05");
	}    
	if (mndMenuId.indexOf("mnd_03") >= 0) {
		document.getElementById('prevMenu').innerHTML = "정보공개";
		document.getElementById('nextMenu').innerHTML = "국방소식";
		$(".box_cate_name").addClass("mnd03");
	}     
	if (mndMenuId.indexOf("mnd_02") >= 0) {
		document.getElementById('prevMenu').innerHTML = "민원ㆍ국민참여";
		document.getElementById('nextMenu').innerHTML = "국방정책";
		$(".box_cate_name").addClass("mnd02");
	}   
	if (mndMenuId.indexOf("mnd_01") >= 0) {
		document.getElementById('prevMenu').innerHTML = "국방소식";
		document.getElementById('nextMenu').innerHTML = "국방콘텐츠";
		$(".box_cate_name").addClass("mnd01");
	}  
	if (mndMenuId.indexOf("mnd_04") >= 0) { 
		document.getElementById('prevMenu').innerHTML = "국방정책";
		document.getElementById('nextMenu').innerHTML = "국방부 소개";
		$(".box_cate_name").addClass("mnd04");
	}  
	if (mndMenuId.indexOf("mnd_06") >= 0) {
		document.getElementById('prevMenu').innerHTML = "국방콘텐츠";
		document.getElementById('nextMenu').innerHTML = "정보공개";
		$(".box_cate_name").addClass("mnd06");
	}        
 
  	if (mndMenuId.indexOf("mnd_07") >= 0) { 
		document.getElementById('prevMenu').innerHTML = "국방부 소개";
		document.getElementById('nextMenu').innerHTML = "정보공개";
		$(".box_cate_name").addClass("mnd07");
	}   
});
   
function move1DepthMenu(mndMenuId, position2) { 
   	    
	if (position2.indexOf("N") >= 0) {  
		  
	    if (mndMenuId.indexOf("mnd_01") >= 0) {   
			location.href = "/mbshome/mbs/mnd/subview.jsp?id=mnd_040000000000";
	    }  
	    if (mndMenuId.indexOf("mnd_02") >= 0) {
	       location.href = "/mbshome/mbs/mnd/subview.jsp?id=mnd_010000000000";
	    }      
	    if (mndMenuId.indexOf("mnd_03") >= 0) {
	       location.href = "/mbshome/mbs/mnd/subview.jsp?id=mnd_020000000000";
	    }  
	    if (mndMenuId.indexOf("mnd_04") >= 0) {
	       location.href = "/mbshome/mbs/mnd/subview.jsp?id=mnd_060000000000";
	    }  
	    if (mndMenuId.indexOf("mnd_05") >= 0) {
	       location.href = "/mbshome/mbs/mnd/subview.jsp?id=mnd_030000000000";  
	    }  
	    if (mndMenuId.indexOf("mnd_06") >= 0) {
	    	location.href = "/mbshome/mbs/mnd/subview.jsp?id=mnd_050000000000";	
	    }  
	    if (mndMenuId.indexOf("mnd_07") >= 0) {
	    	location.href = "/mbshome/mbs/mnd/subview.jsp?id=mnd_050000000000";	
	    }  		
	        
	} else {  
  	
	    if (mndMenuId.indexOf("mnd_01") >= 0) {
			location.href = "/mbshome/mbs/mnd/subview.jsp?id=mnd_020000000000"; 
	    }  
	    if (mndMenuId.indexOf("mnd_02") >= 0) {
	        location.href = "/mbshome/mbs/mnd/subview.jsp?id=mnd_030000000000";
	    }  
	    if (mndMenuId.indexOf("mnd_03") >= 0) {
	        location.href = "/mbshome/mbs/mnd/subview.jsp?id=mnd_050000000000";
	    }  
	    if (mndMenuId.indexOf("mnd_04") >= 0) {
	        location.href = "/mbshome/mbs/mnd/subview.jsp?id=mnd_010000000000"; 
	    }  
	    if (mndMenuId.indexOf("mnd_05") >= 0) {
	        location.href = "/mbshome/mbs/mnd/subview.jsp?id=mnd_060000000000";
	    }  
	    if (mndMenuId.indexOf("mnd_06") >= 0) {
	    	location.href = "/mbshome/mbs/mnd/subview.jsp?id=mnd_040000000000";	
	    }	
	    if (mndMenuId.indexOf("mnd_07") >= 0) { 
	    	location.href = "/mbshome/mbs/mnd/subview.jsp?id=mnd_060000000000";	
	    }  	
	}         
      
}    

function printByJquery(options) {
	$("#printContents").printElement(options); 
}  
    
 
function jf_print() {
	printByJquery({
		printMode: 'popup', //팝업설정 popup = 팝업창 , iframe = iframe
		overrideElementCSS: ['/mbshome/mbs/mnd/css/guide.css', { href: '/mbshome/mbs/mnd/css/guide.css', media: 'print'}], //css경로
		styleToAdd:'width:100%; height:100%;',
		pageTitle:'대한민국 국방부 - 프린트 미리보기', //팝업 타이틀
		leaveOpen: true //false = 인쇄후 창닫기
	});  

}   
    
function shareKakaoStory() {
	var s = location.href; 
	var popUrl = "https://story.kakao.com/share?url="+encodeURIComponent(s)+"&text="+encodeURIComponent(document.title);
	window.open(popUrl, 'facebook');
	  
}

function shareFacebook() {
	var s = location.href;
	var popUrl = "http://www.facebook.com/sharer.php?t="+encodeURIComponent(document.title)+"&u="+encodeURIComponent(s);
	window.open(popUrl, 'facebook');
}
  
function shareTwitter() { 
	var s = location.href;
	var popUrl = "http://twitter.com/share?text="+encodeURIComponent(document.title)+"&url="+encodeURIComponent(s);
	window.open(popUrl, 'twitter');
}  

function sharePinterest() { 
	var s = location.href;
	var popUrl = "http://www.pinterest.com/pin/create/button/?url="+encodeURIComponent(s) + "&description=" +encodeURIComponent(document.title);
	window.open(popUrl, 'pinterest');
}  

function shareNaver() {  
	var s = location.href;
	var popUrl = "http://blog.naver.com/openapi/share?url="+encodeURIComponent(s) + "&title=" +encodeURIComponent(document.title);
	window.open(popUrl, 'naver');
}  
 
  

//공지사항 탭///////////////////////////////////////////////////////////////////////////

var TabbedContent = {
	init: function() {	
		$(".notice_tab").hover(function() {
			var background = $(this).parent().find(".moving_arrow");
			$(background).stop().animate({
				left: $(this).position()['left']
			}, {
				duration: 300
			});
			TabbedContent.slideContent($(this));
		});
	},
	
	slideContent: function(obj) {
		var margin = $(obj).parent().parent().find(".slide_notice").width();
		margin = margin * ($(obj).prevAll().size() - 1);
		margin = margin * -1;
		
		$(obj).parent().parent().find(".notice_slider").stop().animate({
			marginLeft: margin + "px"
		}, {
			duration: 300
		});
	}
}

/*
$(document).ready(function() {
	TabbedContent.init();
});
*/


//팝업존///////////////////////////////////////////////////////////////////////////

function popupRolling(obj) {
	var _root = this;
	var index = obj.index || 0;
	var speed = obj.speed || 3000;
	var tabContainer = document.getElementById(obj.wrap);
	var tabAnchor = tabContainer.getElementsByTagName("A");
	var rollTimer = null;

	// 탭을 제외한 모든링크 오버시 롤링 정지
	var tabA = new Array;
	for(var i=0; i<tabAnchor.length; i++) {
		if (hasClass(tabAnchor[i], "popup_tab")){
			tabA.push(tabAnchor[i]);
		}
		
		var etcLink = tabAnchor[i];
		addEvent(etcLink, "mouseover focus", function(e){
			_root.actionStop();
			var e = e || window.event;
			stopBubble(e);
			return stopDefault(e);
		});
		
		addEvent(etcLink, "blur", function(e){
			_root.actionStart();
		});
	}
	
	// 탭링크 클릭/오버시 동작 설정
	for(var i=0; i<tabA.length; i++) {
		var alink = tabA[i];
		alink.container = tabContainer;
		alink.targetEl = document.getElementById(alink.href.split("#")[1]);
		alink.targetEl.style.display = "none";
		alink.targetEl.style.filter = "alpha(opacity=0)";
		alink.targetEl.style.opacity = 0;

		alink.imgEl = alink.getElementsByTagName("img")[0];
		alink.cnt = i;

		alink.onclick = function(){
			_root.actionStop();
			alinkAction.call(this);
			return false;
		}
		if(!alink.container.first) alink.container.first = tabA[index];
	}
	if(tabContainer.first) alinkAction.call(tabContainer.first); // 초기 첫번째메뉴 활성화
	
	function alinkAction(e){
		rollActive = this.cnt;
		
		var oldActive = this.container.current;
		if(oldActive == this) return false;

		if(oldActive && oldActive.targetEl){
			oldActive.targetEl.style.display = "";
			motion.animate(oldActive.targetEl, { opacity:0, speed:30, speedRatio:0.07}, function(){
				oldActive.targetEl.style.display = "none";
			});

			if(oldActive.imgEl && oldActive.imgEl.src.indexOf("on.") != -1) oldActive.imgEl.src = oldActive.imgEl.src.replace("_on.", ".");
			removeClass(parentEle(oldActive, "LI"), "current");
		}
		
		var scopeA = this;
		this.targetEl.style.display = "block";
		motion.animate(this.targetEl, { opacity:1, speed:30, speedRatio:0.07 }, function(){
			scopeA.targetEl.style.display = "block";
		});
		
		if(this.imgEl &&  this.imgEl.src.indexOf("on.") == -1) this.imgEl.src = this.imgEl.src.replace(/\.(?=gif|jpg|png)/, "_on.");
		addClass(parentEle(this, "LI"), "current");

		this.container.current = this;
		return false;
	};

	// 오버시멈추고 / 마우스아웃시 롤링시작
	var rollActive = index || 0;
	addEvent(tabContainer, "mouseover", function(e){  _root.actionStop();  });
	addEvent(tabContainer, "mouseout", function(e){  _root.actionStart();  });
	
	function rollAction(){		
		rollActive++;
		if(rollActive >= tabA.length) rollActive = 0;
		alinkAction.call( tabA[rollActive] );
	}
	
	this.actionStart = function(){
		if( ! rollTimer ) rollTimer = setInterval(function(){  rollAction();  }, speed);
	}
	this.actionStop = function(){
		clearInterval( rollTimer );
		rollTimer = null;
	}
	_root.actionStart();
}

// 마이메뉴///////////////////////////////////////////////////////////////////////////
function smartRolling(obj){
	var _root = this;
	var to = 0;
	var from = 0;
	var mvCnt = obj.mvCnt || 8; // 리스트가 움직일 갯수
	var sFlag = true;

	var ele = document.getElementById(obj.ele);
	var eleCvWidth = ele.parentNode.offsetWidth; /* 리스트부모의 총넓이(리스트레이어의 딱 넓이 만큼) */
	var list = ele.getElementsByTagName("LI"); /* 상품리스트들 */
	var listWidth = list[0].offsetWidth;
	var visibleListCnt =  parseFloat(eleCvWidth/listWidth);
	var oldAxis = 0;
	
	var btnLchk = true; // <<, >> 버튼 활성화 관련
	var btnRchk = true;

	ele.style.position = "absolute";
	ele.style.width = (listWidth*list.length) + "px";
	ele.style.left = 0;

	var btnLeft = document.getElementById(obj.btnLeft);
	var btnRight = document.getElementById(obj.btnRight);
	btnLeft.onclick = function(){ _root.leftMove() };
	btnRight.onclick = function(){ _root.rightMove() };
	
	// 리스트이동
	this.gotoNum = function(num){
		var lengths = list.length;
		
		// >> 움직임
		if(oldAxis >= lengths-visibleListCnt && num>lengths-visibleListCnt || num>=lengths)
			num = 0;
		else if(num<lengths && num>lengths-visibleListCnt)
			num = lengths-visibleListCnt;
		
		// << 움직임
		if(num<0 && num>-mvCnt)
			num = 0;
		else if(num<0 && num<=-mvCnt)
			num = lengths-visibleListCnt;

		from = _root.getStyle(ele, "left");
		to = -(listWidth*num);
		oldAxis = num;

		_root.btnVisibility();
		_root.action();
	}
	
	// 리스트의 움직일 갯수변경
	this.mvCnt = function(num){
		mvCnt = Number(num);
	}

	// css스타일을 얻을때 사용하는 함수
	this.getStyle = function(el, what){
		var target = el;
		var value = "";
		if(target.currentStyle){
			value = target.currentStyle[what];
		}else if(window.getComputedStyle){
			value = window.getComputedStyle(target,null)[what];
		}
		return parseFloat(value);
	}

	// 왼쪽방향 << 이미지가 클릭되었을때
	this.leftMove = function(){
		if(!sFlag) return false;
		sFlag = false;
		_root.gotoNum(oldAxis-mvCnt);
	}
	
	// 오른쪽방향 >> 이미지가 클릭되었을때
	this.rightMove = function(){
		if(!sFlag) return false;
		sFlag = false;
		_root.gotoNum(oldAxis+mvCnt);
	}
	
	// 화살표 보이기/가리기
	this.btnVisibility = function(){
		if(btnLeft.alpha != "no"){
			btnLeft.alpha = "no"
			btnLeft.style.filter = "alpha(opacity=10)";
			btnLeft.style.opacity = 0.1;
			
			btnRight.style.filter = "alpha(opacity=10)";
			btnRight.style.opacity = 0.1;
		}else{
			btnLeft.alpha = "yes"
			if(oldAxis!=0){
				btnLeft.style.filter = "alpha(opacity=100)";
				btnLeft.style.opacity = 1.;
			}
			
			if(oldAxis!=list.length-visibleListCnt){
				btnRight.style.filter = "alpha(opacity=100)";
				btnRight.style.opacity = 1.;
			}
		}
	}
	
	// 리스트들 움직이는 동작부분
	this.action = function(){
		var func_smartRolling = setInterval(function(){
			var speed = (to-from)*0.2;
			speed = (to>from) ? Math.ceil(speed) : Math.floor(speed);
			
			from = _root.getStyle(ele, "left");
			ele.style.left = from+speed+"px";
			
			if( to==from || Math.abs(from)==1 ){
				_root.btnVisibility();
				clearInterval(func_smartRolling);
				ele.style.left = to+"px";
				sFlag = true;
			}
		}, 36);
	}
}

//스마트메뉴 /////////////////////////////////////////////////////////////////
//설정 버튼 출력//
$(document).ready(function(){
	$("div#smartArea").bind('mouseenter',function(){
		if ($("div#smartArea a.smart_set").is(":hidden")) {
			$("div#smartArea a.smart_set").show("fast");
		}
		$(this).addClass('wiz_set_border');
	}).bind('mouseleave',function(){
		$("div#smartArea a.smart_set").hide("fast");
		$(this).removeClass('wiz_set_border');
	});

	$("#smartList").hide();
	$("a.smart_set").click(function() {
		$("#smartList").show('slow');
	});
	$("a.smartListHide").click(function() {
		$("#smartList").hide('slow');
	});
});

//배너존 /////////////////////////////////////////////////////////////////////////
var bannerArr = new Array();
var b_process = true; //true일 때 스크롤 false일 때 stop
var speed = 2; //스크롤속도-작을수록빠름

function initBanner(bannerBox, bannerContent, delay) {
	
	bannerArr[bannerArr.length] = bannerBox;	
	
	var bannerArrsum = 1; //initBanner함수전체호출수-추가할때마다수정요함
	bannerBox.delay = delay/(speed/bannerArrsum);
	bannerBox.moveOffset = bannerBox.offsetHeight;//Safari만다른값.가끔될때도있음.
	bannerBox.count = 0;
	bannerBox.bannerOver = false;
	bannerBox.cont = bannerContent;
	bannerBox.cont.currentHeight = 0;
 
	bannerBox.move = setInterval("moveBanners()", speed );
	p_num = bannerBox.move;
 
	for (i=0; i<bannerArr.length; i++) {
		bannerArr[i].onmouseover = function() { this.bannerOver=true; }
		bannerArr[i].onmouseout = function() { this.bannerOver=false; }
	}
}

function moveBanner_Change() {

	if(b_process == true){
		b_process = false;
		document.getElementById('b_play').src = '/image/mkmain/site_playbutton.png';
		document.getElementById('b_play').alt = '시작';
		clearInterval(p_num);
	} else if(b_process == false){
		b_process = true;
		document.getElementById('b_play').src = '/image/mkmain/site_stopbutton_b.png';
		document.getElementById('b_play').alt = '정지';
		p_num = setInterval("moveBanners()", speed );
	}
}
 
function moveBanners() {
	for (i=0; i<bannerArr.length; i++) {
		if (bannerArr[i].cont.currentHeight % bannerArr[i].moveOffset == 0 && bannerArr[i].count < bannerArr[i].delay) {
			if(!bannerArr[i].bannerOver) bannerArr[i].count++;//bannerOver가 false 일때 카운트증가시킨다
		} else {
			bannerArr[i].count = 0;
 
			bannerArr[i].cont.currentHeight -= bannerArr[i].moveOffset;//스크롤안함
 
			if (bannerArr[i].cont.currentHeight % (bannerArr[i].cont.offsetHeight) == 0) {
				bannerArr[i].cont.currentHeight = 0;
			}
			bannerArr[i].cont.style.top = bannerArr[i].cont.currentHeight + "px";
		}
	}
}
function prevBanner(bannerArrnum) {
	
	var bannerArrnum = bannerArrnum-1;
	bannerArr[bannerArrnum].count = 0;
	bannerArr[bannerArrnum].cont.currentHeight+= bannerArr[bannerArrnum].moveOffset;

	if (-bannerArr[bannerArrnum].cont.currentHeight < 0) {
			bannerArr[bannerArrnum].cont.currentHeight = bannerArr[bannerArrnum].moveOffset-bannerArr[bannerArrnum].cont.offsetHeight;
	}

	bannerArr[bannerArrnum].cont.style.top = bannerArr[bannerArrnum].cont.currentHeight + "px";
}
function nextBanner(bannerArrnum) {
	
	var bannerArrnum = bannerArrnum-1;
	bannerArr[bannerArrnum].count = 0;
	bannerArr[bannerArrnum].cont.currentHeight-= bannerArr[bannerArrnum].moveOffset;

	if (-bannerArr[bannerArrnum].cont.currentHeight >= bannerArr[bannerArrnum].cont.offsetHeight) {
		bannerArr[bannerArrnum].cont.currentHeight = 0;
	}
	
	bannerArr[bannerArrnum].cont.style.top = bannerArr[bannerArrnum].cont.currentHeight + "px";
}

function prevnextCheck(listname,mode,cnt){
	var displayNo = "";
	for(i=1;i<=cnt;i++){
		var obj = document.getElementById(listname + i);
		if(obj.style.display != "none"){
			displayNo = i;
			obj.style.display = "none";
			break;
		}
	}
			
	if(mode == "prev") {
			if(displayNo > 1){
			displayNo = displayNo - 1;
			}else{
			displayNo = 1;
			}
	}
	if(mode == "next"){
			if(displayNo < cnt){
				displayNo = displayNo + 1;
			}else{
			displayNo = cnt;
			}
	}
	if(
		scrollingnewscount) 
		scrollingnewscount = displayNo;
		//if(displayNo < 1) displayNo = cnt;
		//if(displayNo > cnt) displayNo = 1;
			
		var obj2 = document.getElementById(listname + displayNo);
		obj2.style.display = "block";
}