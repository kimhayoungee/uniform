$(document).ready(function(){
	//마지막 처음 요소 클래스 부여
	$("ul").find(" > li:last").addClass("last");
	$("ul").find(" > li:first").addClass("first");
	$("ol").find(" > li:last").addClass("last");
	$("div").find(" > dl:last").addClass("last");

	$("table tr").find(" > th:first").addClass("first");
	$("table tr").find(" > th:last").addClass("last");
	$("table tr").find(" > td:first").addClass("first");
	$("table tr").find(" > td:last").addClass("last");
	
	$(".group_latest02:last").find('h3').css('background','none');
	$(".group_latest01:last").find('h3').css('background','none');

	$(".group_card01 > a").click(function(){
		$(this).parent().find(".box_card").eq(0).addClass("n1");
		$(this).parent().find(".box_card").eq(1).addClass("n2");
		$(this).parent().find(".box_card").eq(2).addClass("n3");
		$(this).parent().find(".box_card").eq(3).addClass("n4");
	});
});