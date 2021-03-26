var flag = true;
	fnTrunk = {
		addOn : function(select){
			select.addClass('on').siblings().removeClass('on');
		},
		btnNextFn : function(select, index){
			this.addOn(select.eq(index));
		},
		btnPrevFn : function(select, index){
			this.addOn(select.eq(index));
		},
		siteMapFn : function(mag, hei, top, m, h, t){
			var magHei = mag.children().height() + 12;
			if(flag === true){
				mag.stop().animate({height:0, marginTop : m});
			}else if(flag === false){
				mag.stop().animate({height:magHei, marginTop : m});
			}
			hei.stop().animate({height : h});
			top.stop().animate({top : t});
		},
		addTop : function(select, find, calNum){
			var elHei = select.children('li').innerHeight(),
				selectLength = select.length;
			for(var i = 0; i < selectLength; i++){
				var positionList = select.eq(i).find(find);
				positionList.each(function(i){
					$(this).css('top', elHei * i + calNum)
				});
			}
		},
		fadeFn : function(select, index, sec){
			var 	leng = select.length;	
			select.eq(index).fadeIn(sec).siblings().fadeOut(sec);
		},
		addBlind : function(){
			var $body = $('body'),
				addEl = '<div class="blind"></div>';
			$body.css('height','auto').append(addEl).find('.blind').fadeTo(1000, 0.5)
		}
	}

$(document).ready(function(){
	var $a = $('body a'),
		$all_menu = $('.all_menu'),
		$eventList = $('.event-wrap').children('li'),
		$visualList = $('.visual-list-wrap').children('li'),
		$alertList = $('.alret-list').children('li'),
		$listWrap = $('.list-wrap'),
		$btnGroup = $('.btn-group'),
		$subMapList = $('.sub-map-list');
		vIdx = 0, // 비쥬얼 인덱스
		aIdx = 0; // 알림창 인덱스
	var windowHEI,
		targetAdd,
		targetLength;
		
	// 문서 로드시에 실행
	$(window).resize(function(){
		sbw();
		//mobile tablet mode - allmenu auto height
		var hMode = $("body").height();
		windowHEI = hMode;
	});
	$(window).trigger("resize");

	$a.on('click', function(e){
		var $this = $(this);
		if($this.attr('href') == '#'){
			e.preventDefault();
		} 
	});
	fnTrunk.addTop($subMapList, ".is-position", 20);
	var visualRel = setInterval(function(){fnVisual($eventList, $visualList, 1000)},5000), // 비쥬얼 인터벌
		alretRedl = setInterval(function(){fnAlret($alertList, $alertList, 300)},2000); // 알림창 인터벌
	// 기본 실행 종료

	/////////////////////////
	// main page
	$listWrap.on('click', 'li', function(){
		var $this = $(this),
			thisIdx = $this.index();
		fnTrunk.addOn($(this));
		if($this.parents().is('.visual-list-wrap')){
			fnTrunk.fadeFn($eventList, thisIdx, 500);
		}else if($this.parents().is('.tabs-section')){
			var $tabsCon = $this.parents('.tabs-section').find('.tabs-content');
			fnTrunk.addOn($tabsCon.eq(thisIdx));
		}else if($this.parents().is('.site-map')){
			var standardEl = $this.parents('.site-map'),
				magEl = standardEl.find('.btn-group'),
				heiEl = standardEl.find('.sub-list-wrap'),
				topEl = standardEl.find('.sub-map-list'),
				moveNum = topEl.innerHeight();
			flag = false;
			fnTrunk.siteMapFn(magEl, heiEl, topEl, moveNum, moveNum, 0 );
		}
		return false;
	});
	$btnGroup.on('click', 'button', function(){
		var $this = $(this),
			listWrap = $this.parents('.btn-wrap').find('.list-wrap'),
			targetAdd = listWrap.children('li'),
			onTarget = listWrap.children('li.on'),
			onIdx = onTarget.index();
		if($this.is('.next')){
			onIdx ++;
			btnFn($this, targetAdd, onIdx);
			if($this.parents().is('.alret-area')) countNum(targetAdd,onIdx, targetAdd.length);
			//console.log(onIdx);
		}else if($this.is('.prev')){
			onIdx --;
			btnFn($this, targetAdd, onIdx);
			if($this.parents().is('.alret-area')) countNum(targetAdd,onIdx, targetAdd.length);
		}else if($this.is('.toggleControll')){
			if(flag === true){
				flag = false;
				$this.addClass('play').text('시작');
				if($this.parent().is('.visual-btn-group')) clearInterval(visualRel);
				else if($this.parents().is('.alret-area')) clearInterval(alretRedl);
			}else if(flag === false){
				flag = true;
				$this.removeClass('play').text('정지');
				if($this.parent().is('.visual-btn-group')) visualRel = setInterval(function(){fnVisual($eventList, $visualList, 1000)},3000);
				else if($this.parents().is('.alret-area')) alretRedl = setInterval(function(){fnAlret($alertList, $alertList, 300)},2000);
			}
		}else if($this.is('.alret-more')){
			//console.log("modal");
			fnTrunk.addBlind();
			alertOpen();
		}else if($this.is('.alret-close')){
			// 알림 모달 닫기
			alretClose();
		}else if($this.is('.tabs-btn-more')){ 
			var	$this = $(this),
				$tabsMoreArea = $this.parents('.tabs-more').find('.list-wrap'),
				moreHei = $tabsMoreArea.children('li').height();
				$tabsMoreArea.stop().animate({height: (moreHei * 2) + 1});
		}else if($this.is('.site-map-close')){
			flag = true;
			var standardEl = $this.parents('.site-map'),
				magEl = standardEl.find('.btn-group'),
				heiEl = standardEl.find('.sub-list-wrap'),
				topEl = standardEl.find('.sub-map-list'),
				moveNum = topEl.innerHeight();
			fnTrunk.siteMapFn(magEl, heiEl, topEl, 0, 0, -moveNum-10 );
		}
	});

	function alertOpen(){ // 모달
		var $body = $('body'),
			$alretOnImg = $('.alret-list').find('li.on img'),
			$alretModal = $('.alret-modal'),
			$alretImg = $('.alret-modal-img img'),
			onImgSrc = $alretOnImg.attr('src'),
			onImgAlt = $alretOnImg.attr('alt');
		$alretModal.show();
		$alretImg.attr({
			src : onImgSrc,
			alt : onImgAlt
		})
	}
	function alretClose(){
		var $body = $('body'),
			$alretModal = $('.alret-modal');
		$body.css('height','100%');
		$('.blind').remove();
		$alretModal.hide();
	}

	function fnVisual(fade, add, sec){
		var leng = fade.length;
		vIdx ++;
		if(vIdx === leng) vIdx = 0;
		else if(vIdx < 0) vIdx = leng - 1;
		fnTrunk.fadeFn(fade, vIdx, sec);
		fnTrunk.addOn(add.eq(vIdx));
	}

	function fnAlret(fade, add, sec){
		var leng = fade.length;
		aIdx ++;
		if(aIdx === leng) aIdx = 0;
		else if(aIdx < 0) aIdx = leng - 1;
		fnTrunk.fadeFn(fade, aIdx, sec);
		fnTrunk.addOn(add.eq(aIdx));
		countNum(fade, aIdx+1, leng);
	}

	function countNum(select, count, lengNum){
		if(count < 1) count = lengNum;
		$('.location-num').text(count);
		$('.total-num').text(lengNum);	
	}

	function btnFn(click, select, index){
		var leng = select.length;
		if(index === leng) index = 0;
		else if(index < 0) index = leng - 1;
		fnTrunk.addOn(select.eq(index));
		if(click.parents().is('.visual-wrap')){
			fnTrunk.fadeFn($eventList, index, 500);
		}else if(click.parents().is('.alret-wrap')){
			fnTrunk.fadeFn($alertList, index, 300);
		}
	}
	// main end
	
	// top menu
	$(".box_lnb > nav > ul > li > a").bind("mouseenter focus", function(){
		$(this).addClass("on");
		$(".box_lnb > nav > ul > li").removeClass("on");
		$(this).parent("li").addClass("on");
		if ( $(this).hasClass("on") ) {
			$(".box_lnb > nav > ul > li > a").removeClass("on");
			$(".box_lnb > nav > ul > li > .box_wrap_ls").hide();
			$(this).parent().find(".box_wrap_ls").show();
		} else {
			$(".box_lnb > nav > ul > li > a").removeClass("on");
			$(".box_lnb > nav > ul > li > .box_wrap_ls").hide();
			$(this).find(".box_wrap_ls").hide();
		}
		//return false;
	});
	$(".box_lnb").bind("mouseleave", function(){
		$(".box_lnb > nav > ul > li > a").removeClass("on");
		$(".box_lnb > nav > ul > li > .box_wrap_ls").hide();
		$(".box_lnb > nav > ul > li").removeClass("on");
		return false;
	});
	$(".box_cate_name").bind("mouseleave", function(){
		$(".box_lnb > nav > ul > li > a").removeClass("on");
		$(".box_lnb > nav > ul > li > .box_wrap_ls").hide();
		$(".box_lnb > nav > ul > li").removeClass("on");
		return false;
	});
	//tab focus
	$(".box_cate_btn > p > a").bind("focusin", function(){
		$(".box_lnb > nav > ul > li > .box_wrap_ls").hide();
	});

	$(".mainVisual > li > div > a").on("focusin", function(){
		$(".box_wrap_ls").hide();
	});

	// 헤더 search bar
	function sbw() {
		if ( $(window).width() < 860 ) {
			var searchBarW = $("body.tablet #box_header").width()-125;
		} 
		$("body.tablet .header_search").each(function(){
			$(this).css("width", searchBarW);
		});
		$("body.desktop .header_search").each(function(){
			$(this).removeAttr("style");
			$(".box_search_top").removeClass("on");
		});
	}
	$("body.tablet .btn_search_res").click(function(){
		$(this).parent().toggleClass("on");
		if ( $(".box_search_top").hasClass("on") ) {
			$("body.tablet #box_header .box_lnb .box_search_top .header_search").show();
		} else {
			$("body.tablet #box_header .box_lnb .box_search_top .header_search").hide();
		}
	});

	// 헤더 all menu
	// all menu open 버튼 : 변수 위치 상단,
	
	// mobile nav
	$(".all_menu > nav > dl:first-child").addClass("on").css('height',windowHEI + 200);
	$all_menu.on('click', 'dl', function(){
		var $this = $(this);
		$this.addClass('on').css('height',windowHEI + 200)
			.siblings('dl').removeClass('on').css('height', 0);
	});
	$("button.btn_all_menu").click(function(){
		$('.all_menu').stop().animate({
			'right' : 0,
		},550);
		$('.wrap_all_menu').show();
	});
	$("button.btn_all_menu_close").click(function(){
		$('.all_menu').stop().animate({
			'right' : -420,
		},550);
	});
	/* mobile nav */
	//$(".all_menu > nav > dl:first-child").addClass("on");
	//$(".all_menu > nav > dl").click(function(){
	//	$(".all_menu > nav > dl").removeClass("on");
	//	$(this).addClass("on");
	//});
	$(".all_menu > nav > dl > dd:last-child").addClass("last");
	$(".all_menu > nav > dl > dd > p").next("ul").each(function(){
		$(this).parent().find("p").addClass("depth03");
	});
	$(".all_menu > nav > dl > dd > p.depth03").click(function(){
		$(".all_menu > nav > dl > dd").removeClass("on");
		$(this).parent().addClass("on");
		return false;
	});
	
	
	// zoom in , out
	var nowZoom = 100; // 현재비율
	var maxZoom = 200; // 최대비율
	var minZoom = 80; // 최소비율

	function zoomIn(){
		if (nowZoom < maxZoom){
			nowZoom += 10; // 25%씩 커짐
		} else {
			return
		}
		document.body.style.zoom = nowZoom + "%";
	}
	function zoomOut(){
		if (nowZoom > minZoom){
			nowZoom -= 10; // 25%씩 작아짐
		} else {
			return
		}
		document.body.style.zoom = nowZoom + "%";
	}
	function zoomOri(){
		if (nowZoom > minZoom){
			nowZoom = 100;
		} else if (nowZoom < maxZoom){
			nowZoom = 100;
		} else {
			return
		}
		document.body.style.zoom = nowZoom + "%";
	}
	$(".zoom_in").click(function(){
		zoomIn();
	});
	$(".zoom_out").click(function(){
		zoomOut();
	});
	$(".zoom_ori").click(function(){
		zoomOri();
	});
	
	//카드뉴스 클래스 부여
	$(".box_card").eq(0).addClass("n1");
	$(".box_card").eq(1).addClass("n2");
	$(".box_card").eq(2).addClass("n3");
	$(".box_card").eq(3).addClass("n4");
	$(".box_card").eq(4).addClass("n5");
	$(".box_card").eq(5).addClass("n6");
	$(".box_card").eq(6).addClass("n7");
	$(".box_card").eq(7).addClass("n8");

	function mCardnews() {
		var windowWidth = $(window).width();
		if (windowWidth < 420) { 
			$('.card_list > li').hide();
			$('.card_list > li.c1').show();
			$('.m_card_cate li').eq(0).click(function(){
				$('.card_list > li').hide();
				$('.card_list > li.c1').show();
			});
			$('.m_card_cate li').eq(1).click(function(){
				$('.card_list > li').hide();
				$('.card_list > li.c2').show();
			});
			$('.m_card_cate li').eq(2).click(function(){
				$('.card_list > li').hide();
				$('.card_list > li.c3').show();
			});
			$('.m_card_cate li').eq(3).click(function(){
				$('.card_list > li').hide();
				$('.card_list > li.c4').show();
			});
		} else if (windowWidth > 420) {
			$('.card_list > li').show();
		}
	}
	$(window).on("orientationchange load resize", mCardnews);
	$(".m_card_cate > li > h4").click(function(){
		$(".m_card_cate > li > h4").removeClass("on");
		$(this).addClass("on");
	});
	
	// 카드뉴스 배경 높이 설정
	function cardAutoHeight() {
		var windowWidth = $(window).width();
		var cardClass = $("#box_cardnews .group_card01 > div");
		var cardBox = $('#box_cardnews');
		var cardMore = $('#box_cardnews .btn_more');
		
		var cardHeight = cardClass.outerHeight();
		var cardWidth = cardClass.outerWidth();

		if (windowWidth < 480) { 
			cardBox.css('height',cardHeight+110);
			//cardMore.css('width',cardWidth-42);
		} else if (windowWidth < 860) {
			cardBox.css('height',cardHeight+120);
			//cardMore.css('width',cardWidth);
		} else {
			cardBox.css('height',cardHeight+120);
			//cardMore.css('width',cardWidth);
			//console.log(cardHeight);
		}
	}
	$(window).on("orientationchange load resize", cardAutoHeight);
	cardAutoHeight();

	//알림창 배너 전체보기
	function bannerAll() {
		var bnAllBtn = $('.box_slider .box_controller .bn_sl_zoom');
		var bnContainer = $('.bg_notify');
		var bnClose = $('.bg_notify .close');
		var overlayBg = $('.bg_overlay');	
		
		bnAllBtn.on('click',function(){
			overlayBg.show();
			bnContainer.fadeIn();
		});
		bnClose.on('click',function(){
			overlayBg.hide();
			bnContainer.fadeOut();
		});
	} bannerAll();
	
	//이미지 가로 세로 자동 크기 조절
	/* function autoImgresize() {
		var windowWidth = $(window).width();
		var imgTarget = $('#articleBox').find('img');

		if (windowWidth < 860) { 
			$(imgTarget).each(function(){
				var imgWidth = $(this).prop('naturalWidth');
				var imgHeight = $(this).prop('naturalHeight');

				if ( imgWidth < imgHeight) {
					var imgHeightHalf = - $(this).prop('height')/13;
					$(this).css('width','300px').css('margin-top',imgHeightHalf);
					console.log("세로로 긴 이미지네요");
				} else if ( imgWidth > imgHeight ) {
					var imgWidthHalf = -windowWidth/60+"%";
					$(this).css('height','440px').css('margin-left',imgWidthHalf);
					console.log(imgWidthHalf);
				}
			});
		} else {
			$(imgTarget).each(function(){
				$(this).css('height','440px').css('margin-left','0px');
			});
		}
	}
	$(window).on("orientationchange load resize ", autoImgresize);
	autoImgresize(); */
	
	/////////////////////////
	// sub page
	/////////////////////////
	
	// category move
	$('.box_cate_btn .btnL').mouseenter(function(){
		$('.box_cate_btn .btnL a').css('width','auto');
		$('.box_cate_btn .btnL a').stop().animate({
			'padding-left' : 45,
			'padding-right' : 25
		},550,'easeOutCirc',function(){
		});
	});
	$('.box_cate_btn .btnL').mouseleave(function(){
		$('.box_cate_btn .btnL a').css('width','45px');
		$('.box_cate_btn .btnL a').stop().animate({
			'padding-left' : 0,
			'padding-right' : 0
		},550,'easeOutCirc',function(){
		});
	});
	$('.box_cate_btn .btnR').mouseenter(function(){
		$('.box_cate_btn .btnR a').css('width','auto');
		$('.box_cate_btn .btnR a').stop().animate({
			'padding-left' : 25,
			'padding-right' : 45
		},550,'easeOutCirc',function(){
		});
	});
	$('.box_cate_btn .btnR').mouseleave(function(){
		$('.box_cate_btn .btnR a').css('width','45px');
		$('.box_cate_btn .btnR a').stop().animate({
			'padding-left' : 0,
			'padding-right' : 0
		},550,'easeOutCirc',function(){
		});
	});

	// nav menu fix
	$("#nav_header_fix > nav > ul > li > .nav_title > a").click(function(){
		$("body.tablet .nav_title").addClass("on");
		if ($(this).parent(".nav_title").hasClass("on")) {
			$(".nav_title").removeClass("on");
			$(".nav_list").hide();
			$(this).parent().parent().find(".nav_list").slideDown();
		} else {
			$(".nav_title").removeClass("on");
			$(".nav_list").hide();
			$(this).parent(".nav_title").next(".nav_list").slideUp();
		}
		return false
	});

	$("#nav_header_fix").on("mouseleave focusout", function(){
		$(".nav_list").slideUp();
	});

	// 메뉴 즐겨찾기 버튼
	$(".box_share > ul > li > button.fav").click(function(){
		$(this).next(".box_fav").toggle();
	});
	$(".box_fav > .title > button.close").click(function(){
		$(this).parent().parent(".box_fav").hide();
	});
	// sns 공유
	$(".box_share > ul > li > button.share").click(function(){
		$(this).toggleClass("on");
		$(this).next(".box_sns").toggle();
	});
	$(".box_sns > button.close").click(function(){
		$(".box_share > ul > li > button.share").removeClass("on");
		$(this).parent(".box_sns").hide();
	});

	// side menu
	$("#box_sidebar > nav > ul > li > a").next(".div_3").each(function(){
		$(this).parent().find("a").addClass("depth03");
	});

	// mobile Tab
	$("#tab ul li a").each(function(){
		if ($(this).hasClass("on")) {
			$(this).parent().addClass("show");
		}
	});
	$("#tab > button.mBtn").click(function(){
		$(this).toggleClass("on");
		if ($(this).hasClass("on")) {
			$("#tab > ul > li").addClass("on");
			$(this).parent().find("ul > li > a").show();
		} else {
			$(this).parent().find("ul > li").removeClass("on");
			$(this).parent().find("ul > li > a").hide();
		}
		return false;
	});
	
	// 하단 바로가기 박스
	$(".btn_quick_toggle > button").click(function(){
		$(this).toggle();
		$("#box_quick > div > div").hide();
		$("#box_wrap_quick").toggleClass("open")
	});
	$("#box_quick > div > h4 > span").click(function(){
		$("#box_wrap_quick").toggleClass("open")
		$("#box_quick > div > div").toggle();
		$("#box_wrap_quick").removeAttr("style");
		$(".btn_quick_toggle > button").toggle();
	});


/* 	function scrolled() {

		$("#mTop").stop().fadeOut();

		$(this).off('scroll')[0].setTimeout(function(){
			if ($(window).scrollTop() > 20){
				$("#mTop").stop().fadeIn();
			} else {
				$("#mTop").stop().fadeOut();
			}
			$(this).on('scroll',scrolled);
		},1500)
	}
	$(window).on('scroll',scrolled);
 */
	// visual area
	$(window).scroll( function(){
		if ($(window).scrollTop() > 20){
			$("body.tablet .box_lnb").addClass("fixed");
			$("#mTop").fadeIn();
		} else {
			$("body.tablet .box_lnb").removeClass("fixed");
			$("#mTop").fadeOut();
		}
		var sHeight = $(window).scrollTop();
		if (sHeight > 120){
			$("#box_header .box_lnb nav").addClass("fixed");
			$(".box_cate_name").addClass("fixed");
			$("#nav_header_fix").addClass("fixed");
			$(".box_topmenu_bg").addClass("fixed");
			$("#box_sub").css("margin-top", "217px");
		} else {
			$("#box_header .box_lnb nav").removeClass("fixed");
			$(".box_cate_name").removeClass("fixed");
			$("#nav_header_fix").removeClass("fixed");
			$(".box_topmenu_bg").removeClass("fixed");
			$("#box_sub").css("margin-top", "0");
		}
	});
	
	// top button
	$("button#mTop").click(function(){
		$("html, body, .all_menu").animate({
			scrollTop : 0
			}, 600);
	});


	/////////////////////////
	// bx-slider
	/////////////////////////

	// main-lnb
	$(".main-lnb-wrap > ul").bxSlider({
		pager: false,
		//auto: true,
		controls: true,
		//autoControls: true,
		maxSlides: 10,
		moveSlides: 1,
		slideWidth: 120,
		slideMargin: 0
	});

	// 주요정보 바로가기
	$(".family-site > ul").bxSlider({
		pager: false,
		auto: true,
		controls: true,
		autoControls: true,
		maxSlides: 10,
		moveSlides: 1,
		slideWidth: 83,
		slideMargin: 0
	});

	// banner-list-wrap
	$(".banner-list-wrap > ul").bxSlider({
		pager: false,
		auto: true,
		controls: true,
		autoControls: true,
		maxSlides: 6,
		moveSlides: 1,
		slideWidth: 170,
		slideMargin: 10
	});

	/////////////////////////
	// contents
	/////////////////////////
	// 명예의 전당
		$("#tab_js #tab_04 > ul > li > a").click(function(){
			$("#tab_js #tab_04 > ul > li > a").removeClass("on");
			$(this).addClass("on");
		});
		$('#tab_js').tabs();

	// 사이트링크
	$(".box_sitelink > ul").masonry();

	// 찾아오시는 길
	$(".map_list_btn").click(function(){
		$(this).toggleClass("on");
		$(".map_list").toggle();
	});
	$(".map_list > li > a").click(function(){
		$(this).parent().parent().hide();
		$(".map_list_btn").removeClass("on");
	});
	
	// layer popup
	$(".layer_popup button.close").click(function(){
		$(".layer_popup").hide();
	});
});
