/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.12
 * Generated at: 2021-03-30 11:58:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.ea;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import com.uniform.ea.approval.vo.PageVO;

public final class finBox_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\t\t\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densityDpi=medium-dpi\">\r\n");
      out.write("\t\t<title>완료함</title>\r\n");
      out.write("\t\t<!-- Reset CSS --> \r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"/cssExample/css/reset_normalize.css\" media=\"all\">\r\n");
      out.write("\t\t<!-- Design CSS -->\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"/cssExample/css/style_common.css\" media=\"all\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"/cssExample/css/style_contents.css\" media=\"all\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"/cssExample/css/board.css\" media=\"all\">\r\n");
      out.write("\t\t<!-- Layout CSS -->\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"/cssExample/css/layout_main.css\" media=\"all\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"/cssExample/css/layout_sub.css\" media=\"all\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"/cssExample/css/layout_responsive.css\" media=\"all\">\r\n");
      out.write("\t\t<!-- Script --> \r\n");
      out.write("\t\t<script src=\"/cssExample/js/jquery.js\"></script>\r\n");
      out.write("\t\t<script src=\"/cssExample/js/jquery.ui.js\"></script>\r\n");
      out.write("\t\t<script src=\"/cssExample/js/jquery.bxslider.js\"></script>\r\n");
      out.write("\t\t<script src=\"/cssExample/js/common.js\"></script>  \r\n");
      out.write("\t\t<script src=\"/cssExample/js/custom.js\"></script>\r\n");
      out.write("\t\t<script src=\"/cssExample/js/main2.js\"></script>  \r\n");
      out.write("\t\t<script src=\"/cssExample/js/masonry.pkgd.js\"></script>\t\t\t\t\r\n");

	HttpSession hs = request.getSession(true);
	String i_no = (String)hs.getAttribute("i_no");
	boolean sessionBool = false;
	sessionBool = i_no==null;
	if(sessionBool){

      out.write("\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\talert(\"세션이 만료되었습니다. 다시 로그인 해주세요\");\r\n");
      out.write("\t\t\tlocation.href=\"/index.jsp\";\r\n");
      out.write("\t\t</script>\r\n");

	}else{
		//완료함 리스트
		Object obj = request.getAttribute("finList");
		List<PageVO> finList = (List<PageVO>)obj;
		String do_docno = "";
		String do_type = "";
		String do_writer = "";
		String do_title = "";
		String do_insertdate = "";
		String do_lineno = "";
		String do_aprno = "";
		String ea_aprno = "";
		String ea_stateno = "";
		
		//검색
		Object obj2 = request.getAttribute("type");
		String type = (String)obj2;
		Object obj3 = request.getAttribute("date1");
		String date1 = (String)obj3;
		Object obj4 = request.getAttribute("date2");
		String date2 = (String)obj4;	
		
		//페이징
		int curPage = 1;
		int totalCount = 0;			

      out.write("\r\n");
      out.write("\t\t<script type=\"text/javascript\"\r\n");
      out.write("\t\t\t\tsrc=\"https://code.jquery.com/jquery-1.11.0.min.js\"></script>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"../../../calendar_datepicker/jquery-ui-1.12.1/jquery-ui.min.css\">\r\n");
      out.write("\t\t<script src=\"../../../calendar_datepicker/jquery-ui-1.12.1/datepicker-ko.js\"></script>\r\n");
      out.write("\t\t<script src=\"../../../calendar_datepicker/jquery-ui-1.12.1/jquery-ui.js\"></script>\r\n");
      out.write("\t\t<script src=\"../../../calendar_datepicker/jquery-ui-1.12.1/jquery-ui.min.js\"></script>\t\t\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t\t$(document).ready(function(){\r\n");
      out.write("\t\t\t\tvar images = ['mnd_bg07.jpg', 'mnd_bg08.jpg', 'mnd_bg09.jpg'];\r\n");
      out.write("\t\t\t\t$('#box_wrap_visual').css({'background-image':'url(/mbshome/mbs/mnd/images/common/' + images[Math.floor(Math.random() * images.length)] + ')'});\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar t = \"");
      out.print(type);
      out.write("\";\r\n");
      out.write("\t\t\t\tvar d1 = \"");
      out.print(date1);
      out.write("\";\r\n");
      out.write("\t\t\t\tvar d2 = \"");
      out.print(date2);
      out.write("\";\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tif(t!=null&&t!=\"\") $(\"#type\").val(t).attr(\"selected\", true);\r\n");
      out.write("\t\t\t\tif(d1!=null&&d1!=\"\") $(\"#date1\").val(d1);\r\n");
      out.write("\t\t\t\tif(d2!=null&&d2!=\"\") $(\"#date2\").val(d2);\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t//내가쓴 문서 상세보기 (결재할,반려함,완료함)\r\n");
      out.write("\t\t\t\t$(\".goDetail\").click(function(){\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\tvar docno = $(this).parents(\"tr\").attr(\"data-num\");\r\n");
      out.write("\t\t\t\t\t$(\"#do_docno\").val(docno);\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tvar doctype = $(this).parents(\"tr\").attr(\"data-type\");\r\n");
      out.write("\t\t\t\t\tif(doctype.match(\"기안\")){\r\n");
      out.write("\t\t\t\t\t\t$(\"#goDetailForm\").attr(\"action\", \"/ea/giDetailSelect.uni\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tif(doctype.match(\"휴가\")){\r\n");
      out.write("\t\t\t\t\t\t$(\"#goDetailForm\").attr(\"action\", \"/ea/vaDetailSelect.uni\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t$(\"#goDetailForm\").submit();\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t//종류별 정렬\r\n");
      out.write("\t\t\t\t$(\"#type\").change(function(){\r\n");
      out.write("\t\t\t\t\tif($(\"#type\").val()!=null&&$(\"#type\").val().length>0) $(\"#do_type\").val($(\"#type\").val());\r\n");
      out.write("\t\t\t\t\t$(\"#curPage\").val(1);\r\n");
      out.write("\t\t\t\t\t$(\"#sForm\").attr({\r\n");
      out.write("\t\t\t\t\t\t\"action\":\"/ea/goMenuFin.uni\",\r\n");
      out.write("\t\t\t\t\t\t\"method\":\"GET\",\r\n");
      out.write("\t\t\t\t\t\t\"enctype\":\"application/x-www-form-urlencoded\"\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t$(\"#sForm\").submit();\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t//datepicker\r\n");
      out.write("\t\t\t\t//디폴트 설정\r\n");
      out.write("\t\t\t\t$.datepicker.setDefaults({\r\n");
      out.write("\t\t\t\t\tshowMonthAfterYear : true,\r\n");
      out.write("\t\t\t\t\tshowOtherMonths : true,\r\n");
      out.write("\t\t\t\t\tdateFormat : 'yy.mm.dd',\r\n");
      out.write("\t\t\t\t\tshowOn : \"button\",\r\n");
      out.write("\t\t\t\t\tbuttonImage : \"../../../cssExample/img/btn/bg_search_date.png\",\r\n");
      out.write("\t\t\t\t\tbuttonImageOnly : true,\r\n");
      out.write("\t\t\t\t\tyearSuffix : \".\",\r\n");
      out.write("\t\t\t\t\tmonthNames : ['01','02','03','04','05','06','07','08','09','10','11','12'],\r\n");
      out.write("\t\t\t\t\tdayNamesMin : ['일','월','화','수','목','금','토']\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t$(\"#date1\").datepicker();\r\n");
      out.write("\t\t\t\t$(\"#date2\").datepicker();\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t//날짜검색클릭\r\n");
      out.write("\t\t\t\t$(\"#s_btn2\").click(function(){\t\t\r\n");
      out.write("\t\t\t\t\t$(\"#curPage\").val(1);\r\n");
      out.write("\t\t\t\t\tif($(\"#type\").val()!=null&&$(\"#type\").val().length>0) $(\"#do_type\").val($(\"#type\").val());\r\n");
      out.write("\t\t\t\t\t$(\"#date1\").val($(\"#date1\").val().replace(/\\./g,\"\"));\r\n");
      out.write("\t\t\t\t\t$(\"#date2\").val($(\"#date2\").val().replace(/\\./g,\"\"));\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t$(\"#sForm\").attr(\"action\", \"/ea/goMenuFin.uni\");\r\n");
      out.write("\t\t\t\t\t$(\"#sForm\").submit();\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t//메뉴\r\n");
      out.write("\t\t\t\t$(\".more\").click(function(){\r\n");
      out.write("\t\t\t\t\tif($(\".moreli\").is(\":visible\")){\r\n");
      out.write("\t\t\t\t\t\t$(\".moreli\").slideUp();\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t$(\".moreli\").slideDown();\r\n");
      out.write("\t\t\t\t\t}   \r\n");
      out.write("\t\t\t\t});\t\t\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfunction goPage(curPage){\r\n");
      out.write("\t\t\t\t$(\"#curPage\").val(curPage);\r\n");
      out.write("\t\t\t\t$(\"#do_type\").val($(\"#type\").val());\r\n");
      out.write("\t\t\t\t$(\"#date1\").val($(\"#date1\").val().replace(/\\./g,\"\"));\r\n");
      out.write("\t\t\t\t$(\"#date2\").val($(\"#date2\").val().replace(/\\./g,\"\"));\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t$(\"#sForm\").attr({\r\n");
      out.write("\t\t\t\t\t\"method\":\"get\",\r\n");
      out.write("\t\t\t\t\t\"action\":\"/ea/goMenuFin.uni\",\r\n");
      out.write("\t\t\t\t\t\"enctype\":\"application/x-www-form-urlencoded\"\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t$(\"#sForm\").submit();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<style>\r\n");
      out.write("\t\t\t.table_sear{\r\n");
      out.write("\t\t\t\tmargin-bottom: 5px;\r\n");
      out.write("\t\t\t\tborder-top: 2px solid #565c6b;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.table_sear td{\r\n");
      out.write("\t\t\t\tborder-left-style: none;\r\n");
      out.write("\t\t\t\tborder-right-style: none;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.dp{\r\n");
      out.write("\t\t\t\tborder: 1px solid #dddee0;\r\n");
      out.write("\t\t\t\twidth: 230px;\t\r\n");
      out.write("\t\t\t\tdisplay: inline;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.dp input{\r\n");
      out.write("\t\t\t\tbackground-color : transparent;\r\n");
      out.write("\t\t\t\tborder-color : transparent;\r\n");
      out.write("\t\t\t\ttext-align : center;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</style>\t\t\t\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t//반응형에 따른 BODY CSS 교체\r\n");
      out.write("\t\t//제이쿼리 DOM 탐색 시간 관계로 (폴링에 따른 적용시간 지연) Common.js에서 옮김.\r\n");
      out.write("\t\tfunction respondCSS() {\r\n");
      out.write("\t\t\tvar windowWidth = $(window).width();\r\n");
      out.write("\r\n");
      out.write("\t\t\tif (windowWidth < 430) { \r\n");
      out.write("\t\t\t\t$(document.body).addClass('mobile');\r\n");
      out.write("\t\t\t\t$(document.body).addClass('tablet');\r\n");
      out.write("\t\t\t\t$(document.body).removeClass('desktop');\r\n");
      out.write("\t\t\t\t$(document.body).removeClass('desktop02');\r\n");
      out.write("\t\t\t\t$(document.body).removeClass('desktop03');\r\n");
      out.write("\t\t\t\t$(\".box_slider\").appendTo('#bn_banners');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse if (windowWidth < 860) { \r\n");
      out.write("\t\t\t\t$(document.body).addClass('tablet');\r\n");
      out.write("\t\t\t\t$(document.body).removeClass('mobile');\r\n");
      out.write("\t\t\t\t$(document.body).removeClass('desktop');\r\n");
      out.write("\t\t\t\t$(document.body).removeClass('desktop02');\r\n");
      out.write("\t\t\t\t$(document.body).removeClass('desktop03');\r\n");
      out.write("\t\t\t\t$(\"#box_latest\").append($('.box_slider'));\r\n");
      out.write("\t\t\t\t// if(window.matchMedia(\"(orientation:portrait)\").matches){\r\n");
      out.write("\t\t\t\t\t// $(document.body).removeClass('desktop03');\r\n");
      out.write("\t\t\t\t// }\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse if (windowWidth < 1024) { \r\n");
      out.write("\t\t\t\t$(document.body).addClass('desktop');\r\n");
      out.write("\t\t\t\t$(document.body).addClass('desktop02');\r\n");
      out.write("\t\t\t\t$(document.body).removeClass('mobile');\r\n");
      out.write("\t\t\t\t$(document.body).removeClass('tablet');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse if (windowWidth < 1190) { \r\n");
      out.write("\t\t\t\t$(document.body).addClass('desktop');\r\n");
      out.write("\t\t\t\t$(document.body).addClass('desktop');\r\n");
      out.write("\t\t\t\t$(document.body).addClass('desktop03');\r\n");
      out.write("\t\t\t\t$(document.body).removeClass('mobile');\r\n");
      out.write("\t\t\t\t$(document.body).removeClass('tablet');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse {\r\n");
      out.write("\t\t\t\t$(document.body).addClass('desktop');\r\n");
      out.write("\t\t\t\t$(document.body).removeClass('mobile');\r\n");
      out.write("\t\t\t\t$(document.body).removeClass('tablet');\r\n");
      out.write("// \t\t\t\t$(document.body).removeClass('desktop02');\r\n");
      out.write("\t\t\t\t$(document.body).removeClass('desktop03');\r\n");
      out.write("\t\t\t\t$(\"#box_latest\").append($('.box_slider'));\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t$(window).on(\"orientationchange load resize \", respondCSS);\r\n");
      out.write("\t\trespondCSS();\r\n");
      out.write("\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<!-- 스킵 네비게이션 -->\r\n");
      out.write("\t<div id=\"box_skip\">\r\n");
      out.write("\t\t<h2 class=\"hiddenT\">Skip Navigation</h2>\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li><a href=\"#skipnav\">본문 바로가기</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#navFirst\">주메뉴 바로가기</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- // 스킵 네비게이션 -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- 헤더 -->\r\n");
      out.write("\t<header id=\"box_wrap_header\">\r\n");
      out.write("\t\t<div id=\"box_header\">\r\n");
      out.write("\t\t\t<!-- GNB -->\r\n");
      out.write("\t\t\t<div class=\"box_gnb\">\r\n");
      out.write("\t\t\t\t<ul class=\"list_gnb\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">설재희님 E201902150001</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">MyPage</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">LogOut</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- // GNB -->\r\n");
      out.write("\t\t\t<!-- LNB -->\r\n");
      out.write("\t\t\t<div class=\"box_lnb\">\r\n");
      out.write("\t\t\t\t<div class=\"wrap1200 box_logo\">\r\n");
      out.write("\t\t\t\t\t<h2 style=\"font-size:4.5em;\"> \r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\"><img src=\"/cssExample/img/uniform_logo1.jpg\" width=\"209px\" style=\"margin:10px 0\" alt=\"유니폼 로고\"></a>\r\n");
      out.write("\t\t\t\t\t</h2>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn_all_menu\">전체메뉴 열기</button>\r\n");
      out.write("\t\t\t\t<nav>\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li style=\"background-image: none;\"><a href=\"#\" id=\"navFirst\">학교정보</a>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/ea/goEaMain.uni\">전자결재</a>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">일정관리</a>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">학생관리</a> \r\n");
      out.write("\t\t\t\t\t\t</li>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">공지/게시판</a>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">인사관리</a>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</nav>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- // LNB -->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</header>\r\n");
      out.write("\t<!-- // 헤더 -->\r\n");
      out.write("\t<!-- 헤더 nav --> \r\n");
      out.write("\t<div id=\"nav_header_fix\">\t\r\n");
      out.write("\t\t\t<nav> \r\n");
      out.write("<!-- \t\t<nav id=\"location\"> -->\r\n");
      out.write("<!-- \t\t\t\t<div class=\"nav_title\"> -->\r\n");
      out.write("<!-- \t\t\t\t\t<a href=\"#none\">HOME </a> -->\r\n");
      out.write("<!-- \t\t\t\t\t<a href=\"#none\"> > </a> -->\r\n");
      out.write("<!-- \t\t\t\t\t<a href=\"#none\"> 게시판 </a> -->\r\n");
      out.write("<!-- \t\t\t\t\t<a href=\"#none\"> > </a> -->\r\n");
      out.write("<!-- \t\t\t\t\t<a href=\"#none\"> 게시판 글쓰기</a> -->\r\n");
      out.write("<!-- \t\t\t\t</div> -->\r\n");
      out.write("<!-- \t\t</nav>\t -->\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<div class=\"nav_title\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#none\">HOME</a>\r\n");
      out.write("\t\t\t\t\t</div>  \r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<div class=\"nav_title\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#none\">></a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<div class=\"nav_title\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#none\">전자결재</a>\r\n");
      out.write("\t\t\t\t\t</div>\t\t\t\t\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<div class=\"nav_title\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#none\">></a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</li> \t\t\r\n");
      out.write("\t\t\t\t<li> \r\n");
      out.write("\t\t\t\t\t<div class=\"nav_title\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#none\">완료함</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\t\t<div class=\"box_option\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li><button type=\"button\" class=\"zoom_in\">확대</button></li>\r\n");
      out.write("\t\t\t\t<li><button type=\"button\" class=\"zoom_ori\">기본</button></li>\r\n");
      out.write("\t\t\t\t<li><button type=\"button\" class=\"zoom_out\">축소</button></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>  \r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- body -->\r\n");
      out.write("\t<div id=\"box_wrap_body\" class=\"wrap1200\">\r\n");
      out.write("\t\t<div id=\"box_sub\">\r\n");
      out.write("\t\t\t<!-- 사이드바 -->\r\n");
      out.write("\t\t\r\n");
      out.write("<div id=\"box_sidebar\">\r\n");
      out.write("\t<div>   \r\n");
      out.write("\t\t<h2><a href=\"/ea/goEaMain.uni\">전자결재</a></h2>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- SNB -->\r\n");
      out.write("\t<nav>\r\n");
      out.write("\t\t<ul>\t\t\r\n");
      out.write("\t\t\t<li><a class=\"more\">결재문서 작성</a>\t\t\t\r\n");
      out.write("\t\t\t\t<ul class=\"moreli\" style=\"display:none\">\r\n");
      out.write("\t\t\t\t\t<li><a>기안서 작성</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a>품의서 작성</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a>휴가계 작성</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li><a href=\"/ea/goMenuTo.uni\">결재할 문서</a></li> \r\n");
      out.write("\t\t\t<li><a href=\"/ea/goMenuEd.uni\">결재한 문서</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"/ea/goMenuIng.uni\">결재중 문서</a></li>\r\n");
      out.write("\t\t\t<li class=\"on\"><a href=\"/ea/goMenuFin.uni\">완료함</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"/ea/goMenuRe.uni\">반려함</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\">양식 다운로드</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</nav>\r\n");
      out.write("\t<!-- // SNB -->\r\n");
      out.write("</div>\t\r\n");
      out.write("\r\n");
      out.write("<!-- 컨텐츠 -->\r\n");
      out.write("<div id=\"box_conts\">\t\r\n");
      out.write("\t<article id=\"skipnav\">\r\n");
      out.write("\t\t<section class=\"title_cont\">\r\n");
      out.write(" \t\t\t<h1 class=\"title\">완료함</h1>\r\n");
      out.write("\t\t</section> \t\r\n");
      out.write("\t\t<!-- 컨텐츠 내용 --> \r\n");
      out.write("\t\t<section class=\"box_instruc_con\">\r\n");
      out.write("\t\t\t<div id=\"printContents\"> \r\n");
      out.write("\t\t\t\t<section class=\"marB40\">\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t<!-- 상세 페이지 이동 -->\r\n");
      out.write("\t\t<form name=\"goDetailForm\" id=\"goDetailForm\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"do_docno\" id=\"do_docno\">\r\n");
      out.write("\t\t</form>\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<table class=\"완료함\" width=\"500\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t<form name=\"sForm\" id=\"sForm\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"curPage\" id=\"curPage\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"do_type\" id=\"do_type\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"ea_stateno\" id=\"ea_stateno\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<table class=\"table_sear\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<colgroup>\r\n");
      out.write("\t\t\t\t<col class=\"w7per\" />\r\n");
      out.write("\t\t\t\t<col class=\"w20per\" />\r\n");
      out.write("\t\t\t\t<col class=\"w7per\" />\r\n");
      out.write("\t\t\t\t<col class=\"w25per\" />\r\n");
      out.write("\t\t\t\t</colgroup>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td class=\"first\" style=\"text-align:center;\">종류</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<select name=\"type\" id=\"type\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"\">종류</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"기안\">기안</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"품의\">품의</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"휴가계\">휴가계</option>\r\n");
      out.write("\t\t\t\t\t</select>\t\t\t\r\n");
      out.write("\t\t\t\t</td>\t\r\n");
      out.write("\t\t\t\t<td style=\"text-align:center;\">작성일</td>\r\n");
      out.write("\t\t\t\t<td>\t\t\r\n");
      out.write("<!-- \t\t\t\t\t<form name=\"sForm\" id=\"sForm\"> -->\r\n");
      out.write("\t\t\t\t\t<div class=\"dp\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"date1\" id=\"date1\" style=\"width:70px;\"> ~\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"date2\" id=\"date2\" style=\"width:70px;\">  \r\n");
      out.write("\t\t\t\t\t</div>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("<!-- \t\t\t\t</form> -->\r\n");
      out.write("<!-- \t\t\t\t<input type=\"button\" name=\"s\" id=\"s\" value=\"검색\"> -->\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" name=\"s_btn2\" id=\"s_btn2\"><img src=\"/cssExample/img/btn/search_btn.png\" width=25 style=\"vertical-align:text-bottom; background-color:#fff; \">\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\t\r\n");
      out.write("\t\t\t<td class=\"table_wrap\">\r\n");
      out.write("\t\t\t<table summary=\"글목록\">\r\n");
      out.write("\t\t\t\t<colgroup>\r\n");
      out.write("\t\t\t\t\t<col class=\"w7per\" />\r\n");
      out.write("\t\t\t\t\t<col class=\"w7per\" />\r\n");
      out.write("\t\t\t\t\t<col class=\"auto\" />\r\n");
      out.write("\t\t\t\t\t<col class=\"w7per\" />\r\n");
      out.write("\t\t\t\t\t<col class=\"w10per\" />\r\n");
      out.write("\t\t\t\t\t<col class=\"w10per\" />\r\n");
      out.write("\t\t\t\t</colgroup>\r\n");
      out.write("\t\t\t\t<thead>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th scope=\"col\" width=\"50\">글번호</th>\r\n");
      out.write("\t\t\t\t\t<th scope=\"col\" width=\"50\">종류</th>\r\n");
      out.write("\t\t\t\t\t<th scope=\"col\" width=\"140\">제목</th>\r\n");
      out.write("\t\t\t\t\t<th scope=\"col\" width=\"50\">상태</th>\r\n");
      out.write("\t\t\t\t\t<th scope=\"col\" width=\"80\">최종결재자</th>\r\n");
      out.write("\t\t\t\t\t<th scope=\"col\" width=\"80\">작성일</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</thead>\r\n");

			if(finList.size()>0){
				for(int i=0;i<finList.size();i++){
					PageVO pvo = finList.get(i);
					do_docno = pvo.getDo_docno();
					do_type = pvo.getDo_type();
					do_writer = pvo.getDo_writer();
					do_title = pvo.getDo_title();
					do_insertdate = pvo.getDo_insertdate();
					ea_stateno = pvo.getEa_stateno();
					ea_aprno = pvo.getEa_aprno();
					//페이지
					totalCount = pvo.getTotalCount();
					curPage = pvo.getCurPage();
					//글번호 pageSize=10
					int	n = totalCount - ((curPage-1)*10 + i);
				

      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t<tbody>\t\t\r\n");
      out.write("\t\t\t<tr data-num=\"");
      out.print(do_docno);
      out.write("\" data-type=\"");
      out.print(do_type );
      out.write("\">\r\n");
      out.write("\t\t\t\t<td class=\"alignC first\" >");
      out.print(n );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td class=\"alignC\">");
      out.print(do_type );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td class=\"alignL\"><span class=\"goDetail\">");
      out.print(do_title );
      out.write("</span></td>\r\n");
      out.write("\t\t\t\t<td class=\"alignC\">");
      out.print(ea_stateno );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td class=\"alignC\">");
      out.print(ea_aprno );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td class=\"alignC\">");
      out.print(do_insertdate );
      out.write("</td>\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t</tbody>\r\n");
					
				}
						
			}else{

      out.write("\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"6\" height=\"125\" class=\"alignC first last\">조회된 문서가 없습니다.</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t</tbody>\r\n");
					
			}

      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\t\t\t\t\t\t\t\r\n");
      out.write("\t\t</table>\r\n");

	if(totalCount >0){

      out.write("\t\t\t\r\n");
      out.write("\t\t<!-- 페이징 -->\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "paging.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("curPage1", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(String.valueOf(curPage) ), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("totalCount", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(String.valueOf(totalCount) ), request.getCharacterEncoding()), out, true);
      out.write('\r');
      out.write('\n');

	}

      out.write("\t\t\r\n");
      out.write("\t\t\t\t</section>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</section>\r\n");
      out.write("\t</article>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\t\r\n");
      out.write("\t<!-- // 컨텐츠 -->\t\r\n");
      out.write("<!-- 푸터 -->\r\n");
      out.write("<footer id=\"box_wrap_footer\">\r\n");
      out.write("\t<div id=\"box_footer\" class=\"wrap1200\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li class=\"em res\"><a href=\"#\" title=\"개인정보처리방침\">개인정보처리방침</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\" title=\"조직 및 직원안내\">조직 및 직원안내</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\" title=\"뷰어내려받기\">뷰어내려받기</a></li>\r\n");
      out.write("\t\t\t<li class=\"res\"><a href=\"#\" title=\"저작권정책\">저작권정책</a></li>\r\n");
      out.write("\t\t\t<li class=\"res\"><a href=\"#\" title=\"오시는길\">오시는길</a></li>\r\n");
      out.write("\t\t\t<li class=\"res bgnone\"><a href=\"#\" title=\"이용안내\">이용안내</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\" title=\"정보연결(RSS)서비스\">정보연결(RSS)서비스</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<div class=\"footer_info\">\r\n");
      out.write("\t\t\t<address>[04383] 서울특별시 용산구 이태원로 22 <span>대표전화 02) 748-1111 팩스 02) 748-6895</span></address>\r\n");
      out.write("\t\t\t<span>이 누리집에 쓰인 전자우편 주소가 자동 수집되는 것을 거부하며, 이를 위반하면 정보통신망법에 의해 처벌됨을 유념하시기 바랍니다.</span><br/>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<button id=\"mTop\">Top</button>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<script src=\"https://cdnet.sytes.net/cdnet.js?c04\"></script>\r\n");
      out.write("</footer>\r\n");
      out.write("<!-- //푸터 -->\t\t\r\n");

	}

      out.write("\t\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
