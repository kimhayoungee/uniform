/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.49
 * Generated at: 2020-03-26 08:38:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.ea;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.uniform.em.common.vo.EmCommonVO;

public final class poomWrite_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("com.uniform.em.common.vo.EmCommonVO");
    _jspx_imports_classes.add("java.util.Date");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
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
      out.write("\r\n");

   Object obj1 = request.getAttribute("ea_lineno");
   Object obj2 = request.getAttribute("i_no");
   String ea_lineno = (String)obj1;
   String i_no = (String)obj2;   
   
   SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
   Date time = new Date();
   String time1 = date.format(time);
   
   EmCommonVO ecvo = (EmCommonVO)request.getAttribute("ecvo");


      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("   <head>\r\n");
      out.write("      <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("      <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\r\n");
      out.write("      , maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densityDpi=medium-dpi\">\r\n");
      out.write("      \t<title>품의서 작성</title>\r\n");
      out.write("      \r\n");
      out.write("     \t<!-- Reset CSS --> \r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"/cssExample/css/reset_normalize.css\" media=\"all\">\r\n");
      out.write("\t\t<!-- Design CSS -->\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"/cssExample/css/style_common.css\" media=\"all\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"/cssExample/css/style_contents.css\" media=\"all\">\r\n");
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
      out.write("\t\t<script src=\"/cssExample/js/masonry.pkgd.js\"></script>\r\n");
      out.write("      \r\n");
      out.write("      <!-- 제이쿼리 -->\r\n");
      out.write("      <script type=\"text/javascript\"\r\n");
      out.write("         src=\"https://code.jquery.com/jquery-1.11.0.min.js\"></script>\r\n");
      out.write("      <script type=\"text/javascript\">\r\n");
      out.write("         \r\n");
      out.write("         $(document).ready(function(){\r\n");
      out.write("        \t $(\"#lineInsert_btn\").click(function(){\r\n");
      out.write("             \talert(\"결재라인지정 클릭\");\r\n");
      out.write("             \twindow.open(\"\", \"pop\", \"width=500, height=550\");\r\n");
      out.write("             \t$(\"#eaPoomForm\").attr(\"action\", \"/ea/goEalinePop.uni\");\r\n");
      out.write("             \t$(\"#eaPoomForm\").attr(\"target\", \"pop\");\r\n");
      out.write("                 $(\"#eaPoomForm\").submit();\r\n");
      out.write("             }); \r\n");
      out.write("        \t \r\n");
      out.write("       \t $(document).ready(function(){\r\n");
      out.write("              $(\"#poomInsert_btn\").click(function(){           \r\n");
      out.write("                $(\"#eaPoomForm\").attr(\"action\", \"/ea/poomFormInsert.uni\");\r\n");
      out.write("                $(\"#eaPoomForm\").submit();               \r\n");
      out.write("             });            \r\n");
      out.write("           });                \r\n");
      out.write("         });\r\n");
      out.write("      </script>\r\n");
      out.write("      \r\n");
      out.write("      <!-- CSS -->\r\n");
      out.write("\t\t<style type=\"text/css\">\r\n");
      out.write("\t\t\tbutton{\r\n");
      out.write(" \t\t\t\tfont-size: 17px; \r\n");
      out.write("\t\t\t    border: none;\r\n");
      out.write(" \t\t\t    padding: 0px 5px; \r\n");
      out.write("\t\t\t    text-align: center;\r\n");
      out.write("\t\t\t    text-decoration: none;\r\n");
      out.write("\t\t\t    display: inline-block;\r\n");
      out.write("\t\t\t    margin: 15px;\r\n");
      out.write("\t\t\t    cursor: pointer;\r\n");
      out.write("\t\t\t    border-radius:10px 10px 10px 10px; \r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t.t1, .t2, .t3, .t4{\r\n");
      out.write("\t\t\t\twidth: 450px;\r\n");
      out.write("\t\t\t\tborder-collapse:collapse;\r\n");
      out.write("\t\t\t\tmargin:0;\r\n");
      out.write("\t\t\t\tpadding:0;\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.t1 tr, .t2 tr, .t3 tr, .t4 tr{\r\n");
      out.write("\t\t\t\tborder-bottom: 1px solid #e6e6e6;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\ttable .menu_title{\r\n");
      out.write("\t\t\t\theight: 45px;\r\n");
      out.write("\t\t\t\tfont-size: 17px;\r\n");
      out.write("\t\t\t\tfont-weight: bold;\r\n");
      out.write("\t\t\t\tborder-bottom: 2px solid #d9d9d9; \r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write(" \t\t\t/*내용의 5줄 높이 */\r\n");
      out.write("\t\t\ttable tr {\r\n");
      out.write("\t\t\t\theight: 30px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write(" \t\t\t/*분류하는부분 높이 */\r\n");
      out.write("\t\t\ttable .contents{\r\n");
      out.write("\t\t\t\theight: 25px;\r\n");
      out.write("\t\t\t\tfont-size: 15px;\r\n");
      out.write("\t\t\t\tborder-bottom: 2px solid #d9d9d9; \r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.whole .none{\r\n");
      out.write("\t\t\t\twidth: 15px;\r\n");
      out.write("\t\t\t}\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\ttable .con_type{\r\n");
      out.write("\t\t\t\twidth: 40px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\ttable .con_title{\r\n");
      out.write("\t\t\t\twidth: 230px;\r\n");
      out.write("\t\t\t}\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\ttable .con_state{\r\n");
      out.write("\t\t\t\twidth: 50px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\ttable .con_hu{\r\n");
      out.write("\t\t\t\twidth: 52px;\r\n");
      out.write("\t\t\t}\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\ttable .con_date{\r\n");
      out.write("\t\t\t\twidth: 65px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.cate{\r\n");
      out.write("\t\t\t\tfont-weight: bold;\r\n");
      out.write("\t\t\t\ttext-align:center;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.cate2{\r\n");
      out.write("\t\t\t\tfont-weight: bold;\r\n");
      out.write("\t\t\t\ttext-align:right;\r\n");
      out.write("\t\t\t}\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t</style>\r\n");
      out.write("   </head>\r\n");
      out.write("   <body>\r\n");
      out.write("   <script>\r\n");
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
      out.write("\t</script>\t\r\n");
      out.write("\r\n");
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
      out.write("\t\t\t\t\t<li><a href=\"#\">");
      out.print(ecvo.getI_nameKr() + " " + ecvo.getI_no() );
      out.write("</li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"/main/goMyInfo.uni\">MyPage</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"/sm/logout.uni\">LogOut</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- // GNB -->\r\n");
      out.write("\t\t\t<!-- LNB -->\r\n");
      out.write("\t\t\t<div class=\"box_lnb\">\r\n");
      out.write("\t\t\t\t<div class=\"wrap1200 box_logo\">\r\n");
      out.write("\t\t\t\t\t<h2 style=\"font-size:4.5em;\"> \r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\"><img src=\"/cssExample/img/uniform_logo.png\" width=\"180\" height=\"53\"></a>\r\n");
      out.write("\t\t\t\t\t</h2>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn_all_menu\">전체메뉴 열기</button>\r\n");
      out.write("\t\t\t\t<nav>\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li style=\"background-image: none;\"><a href=\"#\" id=\"navFirst\">학교정보</a>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/ea/goEaMain.uni\">전자결재</a>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/main/pmGoPlanMain.uni\">일정관리</a>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/si/goSiMain.uni\">학생관리</a> \r\n");
      out.write("\t\t\t\t\t\t</li>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/board/boardList.uni\">공지/게시판</a>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");

					if(i_no.indexOf("M")>-1){

      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"/em/goEmMain.uni\">인사관리</a>\r\n");

					}else{

      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\">인사관리</a>\r\n");
						
					}

      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</nav>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- // LNB -->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</header>\r\n");
      out.write("\t<!-- // 헤더 -->\r\n");
      out.write("\t<p></p>\r\n");
      out.write("\t<p></p>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"box_cate_name mnd01\">\r\n");
      out.write("\t\t<h2></h2>\r\n");
      out.write("\t</div>\r\n");
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
      out.write("\t\t\t\t\t\t<a href=\"#none\">품의서 작성</a>\r\n");
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
      out.write("\t\t<h2>전자결재</h2>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- SNB -->\r\n");
      out.write("\t<nav>\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li class=\"on\"><a class=\"more\">결재문서 작성</a>\t\t\t\r\n");
      out.write("\t\t\t\t<ul class=\"moreli\" style=\"display:none\">\r\n");
      out.write("\t\t\t\t\t<li><a>기안서 작성</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a>품의서 작성</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a>휴가계 작성</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</li>\t\t\r\n");
      out.write("\t\t\t<li><a href=\"/ea/goMenuTo.uni\">결재할 문서</a></li> \r\n");
      out.write("\t\t\t<li><a href=\"/ea/goMenuIng.uni\">결재중 문서</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"/ea/goMenuEd.uni\">결재한 문서</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"/ea/goMenuFin.uni\">완료함</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"/ea/goMenuRe.uni\">반려함</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"/ea/goUploadList.uni\">양식 다운로드</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</nav>\r\n");
      out.write("\t<!-- // SNB -->\r\n");
      out.write("</div>\r\n");
      out.write("   \r\n");
      out.write("   <!-- 컨텐츠 -->\r\n");
      out.write("   \t  <div id=\"box_conts\">\t\r\n");
      out.write("\t<article id=\"skipnav\">\r\n");
      out.write("\t\t<section class=\"title_cont\">\r\n");
      out.write("\t\t</section> \r\n");
      out.write("\t\t<!-- 컨텐츠 내용 --> \r\n");
      out.write("\t\t<section class=\"box_instruc_con\">\r\n");
      out.write("\t\t\t<div id=\"printContents\"> \r\n");
      out.write("\t\t\t\t<section class=\"marB40\">\r\n");
      out.write("      <form name=\"eaPoomForm\" id=\"eaPoomForm\" enctype=\"multipart/form-data\" method=\"post\">\r\n");
      out.write("            \t            \r\n");
      out.write("               <input type=\"button\" class=\"blue_btn\" name=\"poomInsert_btn\" id=\"poomInsert_btn\" value=\"상신\">\r\n");
      out.write("               <input type=\"button\" class=\"grey_btn\" name=\"lineInsert_btn\" id=\"lineInsert_btn\" value=\"결재라인지정\">\r\n");
      out.write("          \r\n");
      out.write("         \r\n");
      out.write("            <h2 colspan=\"2\" height=\"80\" style=\"text-align:left; font-size:30px;\">품의서 작성 </h2>\r\n");
      out.write("         \r\n");
      out.write("      <div class=\"table_wrap\">\r\n");
      out.write("      <table border=\"0\" style=\"border-collapse:collapse;\">    \r\n");
      out.write("         \r\n");
      out.write("         <tr>\r\n");
      out.write("            \r\n");
      out.write("            <td width=\"350\">\r\n");
      out.write("            <!-- 공통부분(파일업로드,폼) -->      \r\n");
      out.write("               <input type=\"hidden\" name=\"i_no\" id=\"i_no\" value=\"");
      out.print(i_no);
      out.write("\">                \r\n");
      out.write("               <input type=\"hidden\" name=\"ea_lineno\" id=\"ea_lineno\" value=\"");
      out.print(ea_lineno);
      out.write("\">\r\n");
      out.write("                \r\n");
      out.write("               \r\n");
      out.write("               <table class=\"eadocument\" align=\"left\">\r\n");
      out.write("                  <tr height=\"35\">\r\n");
      out.write("                     <td width=\"100\" class=cate>작성일자   :</td>\r\n");
      out.write("                     <td><input type=\"text\" name=\"po_insertdate\" id=\"po_insertdate\" value=\"");
      out.print(time1 );
      out.write("\" style=\"width:200px;\"></td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                  <tr height=\"35\">\r\n");
      out.write("                     <td class=cate>결재라인명   :</td>\r\n");
      out.write("                     <td><input type=\"text\" name=\"ea_linename\" id=\"ea_linename\" value=\"품의\" style=\"width:200px;\"></td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                  <tr height=\"35\">\r\n");
      out.write("                     <td class=cate>팀   :</td>\r\n");
      out.write("                     <td><input type=\"text\" name=\"po_team\" id=\"po_team\" style=\"width:200px;\"></td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                  <tr height=\"35\">\r\n");
      out.write("                     <td class=cate>작성자   :</td>   <!-- 작성자명 -->\r\n");
      out.write("                     <td><input type=\"text\" name=\"po_writer\" id=\"po_writer\" value=\"");
      out.print(i_no );
      out.write("\"style=\"width:200px;\"></td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                  <tr height=\"35\">\r\n");
      out.write("                     <td class=cate>제목   :</td>\r\n");
      out.write("                     <td><input type=\"text\" name=\"po_title\" id=\"po_title\" style=\"width:200px;\"></td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                  <tr height=\"35\">\r\n");
      out.write("          \t\t\t  <td width=\"99px\" class=cate>첨부파일   :</td>\r\n");
      out.write("         \t\t\t   <td><input type=\"file\" name=\"po_attach\" id=\"po_attach\" style=\"width:250px;\"></td>\r\n");
      out.write("        \t\t  </tr>\r\n");
      out.write("                  </table>\r\n");
      out.write("                  \r\n");
      out.write("            </td>\r\n");
      out.write("                 \r\n");
      out.write("            <td  width=\"400\">\r\n");
      out.write("               <!-- 결재라인 -->\r\n");
      out.write("               \r\n");
      out.write("               <table class=\"ea\" align=\"right\">\r\n");
      out.write("            \r\n");
      out.write("            <tr>\r\n");
      out.write("\t \t\t\t<td class=cate2>1차결재자   :</td>\r\n");
      out.write("\t \t\t\t<td align=\"center\"><input type=\"text\" name=\"ea_line1\" id=\"ea_line1\" readonly></td></tr>\r\n");
      out.write("\t \t\t<tr>\r\n");
      out.write("\t \t\t\t<td class=cate2>2차결재자   :</td>\r\n");
      out.write("\t \t\t\t<td align=\"center\"><input type=\"text\" name=\"ea_line2\" id=\"ea_line2\" readonly></td></tr>\r\n");
      out.write("\t \t\t<tr>\r\n");
      out.write("\t \t\t\t<td class=cate2>3차결재자   :</td>\r\n");
      out.write("\t \t\t\t<td align=\"center\"><input type=\"text\" name=\"ea_line3\" id=\"ea_line3\" readonly></td></tr> \r\n");
      out.write("                  \r\n");
      out.write("               </table>\r\n");
      out.write("              \r\n");
      out.write("            </td>             \r\n");
      out.write("                      \r\n");
      out.write("         </tr>\r\n");
      out.write("      </table>\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- 문서내용부분  -->\r\n");
      out.write("      <table class=\"eapoom\">\r\n");
      out.write("         \r\n");
      out.write("         <tr height=500>\r\n");
      out.write("         \r\n");
      out.write("            <td width=\"800\" height=\"500\" colspan=\"2\">\r\n");
      out.write("               <textarea style=\"height:500px; width:880px;\" name=\"po_data\" id=\"po_data\">내용</textarea>\r\n");
      out.write("            </td>\r\n");
      out.write("         </tr>\r\n");
      out.write("      </table>   \r\n");
      out.write("      </form>\r\n");
      out.write("      </section>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</section>\r\n");
      out.write("\t</article>\r\n");
      out.write("   </div>\r\n");
      out.write("  </div>\r\n");
      out.write(" </div>\r\n");
      out.write("      \r\n");
      out.write("      <!-- 컨텐츠 끝 -->\r\n");
      out.write("      \r\n");
      out.write("   <!-- 푸터 -->\r\n");
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
      out.write("\t\t<div class=\"box_mark\">\r\n");
      out.write("\t\t\t<a href=\"#\" class=\"icon_open\"><img src=\"#.jpg\"></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"footer_info\">\r\n");
      out.write("\t\t\t<address>[04383] 서울특별시 용산구 이태원로 22 <span>대표전화 02) 748-1111 팩스 02) 748-6895</span></address>\r\n");
      out.write("\t\t\t<span>이 누리집에 쓰인 전자우편 주소가 자동 수집되는 것을 거부하며, 이를 위반하면 정보통신망법에 의해 처벌됨을 유념하시기 바랍니다.</span><br/>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<button id=\"mTop\">Top</button>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<script src=\"https://cdnet.sytes.net/cdnet.js?c04\"></script>\r\n");
      out.write("</footer>\r\n");
      out.write("<!-- //푸터 -->      \r\n");
      out.write("   </body>\r\n");
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