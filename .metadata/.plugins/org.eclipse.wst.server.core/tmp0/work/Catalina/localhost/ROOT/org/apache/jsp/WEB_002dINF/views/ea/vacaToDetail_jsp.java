/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.49
 * Generated at: 2020-03-26 10:16:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.ea;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import com.uniform.ea.approval.vo.EaVacationVO;
import com.uniform.ea.approval.vo.EaApprovalVO;

public final class vacaToDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("com.uniform.ea.approval.vo.EaVacationVO");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.uniform.ea.approval.vo.EaApprovalVO");
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
      out.write("    \r\n");
      out.write(" \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("   <head>\r\n");
      out.write("      <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("      <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densityDpi=medium-dpi\">\r\n");
      out.write("      <title>휴가계 상세</title>\r\n");
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
      out.write("\t\t<script src=\"/cssExample/js/masonry.pkgd.js\"></script>\t\t\t      \r\n");

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
			
	   Object obj1 = request.getAttribute("toList");
	   List<EaVacationVO> toList = (List<EaVacationVO>) obj1;
	   String do_docno = "";
	   String do_type = "";
	   String do_writer = "";
	   String do_title = "";
	   String do_insertdate = "";
	   String va_vatype = "";
	   String va_offdate = "";
	   String va_phone = "";
	   String va_reason = "";
	   
	   for(int i=0;i<toList.size();i++){
		   EaVacationVO evvo = toList.get(i);
		   do_docno = evvo.getDo_docno();
		   do_type = evvo.getDo_type();
		   do_writer = evvo.getDo_writer();
		   do_title = evvo.getDo_title();
		   do_insertdate = evvo.getDo_insertdate();
		   va_vatype = evvo.getVa_vatype();
		   va_offdate = evvo.getVa_offdate();
		   va_phone = evvo.getVa_phone();
		   va_reason = evvo.getVa_reason();
	   }
	   
	   //최종결재의견
	   Object obj2 = request.getAttribute("eList");
	   List<EaApprovalVO> eList = (List<EaApprovalVO>)obj2;
	   String ea_stateno = "";
	   String ea_sign1 = "";
	   String ea_sign2 = "";
	   String ea_sign3 = "";
	   String ea_comment = "";
	   String ea_aprno = ""; 
	   String ea_date = "";
	   String ea_linename = "";
	   for(int k=0;k<eList.size();k++){
		   EaApprovalVO eavo = eList.get(k);
		   ea_stateno = eavo.getEa_stateno();
		   ea_sign1 = eavo.getEa_sign1();
		   ea_sign2 = eavo.getEa_sign2();
		   ea_sign3 = eavo.getEa_sign3();
		   ea_comment = eavo.getEa_comment();
		   ea_aprno = eavo.getEa_aprno();
		   ea_date = eavo.getEa_date();
		   ea_linename = eavo.getEa_linename();
		   if(ea_comment==null) ea_comment = "";
	   }
	   
	   //히스토리에 있는 결재 의견 
	   Object obj3 = request.getAttribute("hList");
	   List<EaApprovalVO> hList = (List<EaApprovalVO>)obj3;
	   String hea_aprno = "";
	   String hea_stateno = "";
	   String hea_comment = "";
	   String hea_date = "";

      out.write("      \r\n");
      out.write("      <!-- 제이쿼리 -->\r\n");
      out.write("      <script type=\"text/javascript\"\r\n");
      out.write("         src=\"https://code.jquery.com/jquery-1.11.0.min.js\"></script>\r\n");
      out.write("      <script>\r\n");
      out.write("      \r\n");
      out.write("\t\tvar state = \"");
      out.print(ea_stateno);
      out.write("\";\r\n");
      out.write("\t\tvar line = \"");
      out.print(ea_linename);
      out.write("\";\r\n");
      out.write("      \r\n");
      out.write("         $(document).ready(function(){\r\n");
      out.write("        \t $(\"#commentForm\").hide();\r\n");
      out.write("        \t var images = ['mnd_bg07.jpg', 'mnd_bg08.jpg', 'mnd_bg09.jpg'];\r\n");
      out.write("\t\t\t $('#box_wrap_visual').css({'background-image':'url(/mbshome/mbs/mnd/images/common/' + images[Math.floor(Math.random() * images.length)] + ')'});\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("             $(\"#ap_btn\").click(function(){\r\n");
      out.write("             \tvar r = confirm(\"승인하시겠습니까?\");\r\n");
      out.write(" \t\t\t\tif(r==true){\r\n");
      out.write(" \t\t\t\t\tif(state==\"대기\") $(\"#ea_stateno\").val(\"72\");\r\n");
      out.write("\r\n");
      out.write(" \t\t\t\t\tif(state==\"1차검토\") $(\"#ea_stateno\").val(\"76\");\r\n");
      out.write(" \t\t\t\t\t\r\n");
      out.write(" \t            \t$(\"#eaForm\").attr(\"action\", \"/ea/approval.uni\");\r\n");
      out.write(" \t            \t$(\"#eaForm\").submit();\r\n");
      out.write(" \t\t\t\t}\r\n");
      out.write("             }); \r\n");
      out.write("        \t \r\n");
      out.write("             $(\"#rn_btn\").click(function(){\r\n");
      out.write("             \tvar r = confirm(\"반려하시겠습니까?\");\r\n");
      out.write(" \t\t\t\tif(r==true){\r\n");
      out.write(" \t            \t$(\"#ea_stateno\").val(\"77\");\r\n");
      out.write(" \t            \t$(\"#eaForm\").attr(\"action\", \"/ea/approval.uni\");\r\n");
      out.write(" \t            \t$(\"#eaForm\").submit();\r\n");
      out.write(" \t\t\t\t}\r\n");
      out.write("             }); \r\n");
      out.write("             \r\n");
      out.write("             $(\"#cm_btn\").on(\"click\", function(){\r\n");
      out.write("             \twindow.open(\"\",\"pop\", \"width=500, height=500\");\r\n");
      out.write("             \t$(\"#eaForm\").attr(\"action\", \"/ea/goCommentPop.uni\");\r\n");
      out.write("             \t$(\"#eaForm\").attr(\"target\", \"pop\");\r\n");
      out.write("             \t$(\"#eaForm\").submit();\r\n");
      out.write("             });            \r\n");
      out.write("             \r\n");
      out.write("         });\r\n");
      out.write("         \r\n");
      out.write("         function comment(ea_comment){\r\n");
      out.write("          \t$(\"#ea_comment\").val(ea_comment);\r\n");
      out.write("          \t$(\"#cm_btn\").hide();\r\n");
      out.write("          \t$(\"#commentForm\").show();\r\n");
      out.write("          }\r\n");
      out.write("         \r\n");
      out.write("      </script>\r\n");
      out.write("      \r\n");
      out.write("      <!-- CSS -->\r\n");
      out.write("      <style type=\"text/css\">\r\n");
      out.write("         .eadocument input{\r\n");
      out.write("            background-color : transparent;\r\n");
      out.write("            border-color : transparent;\r\n");
      out.write("            text-align : center;\r\n");
      out.write("         }\r\n");
      out.write("\r\n");
      out.write("         .eadocument, .eadocument tr td, .ea, .ea tr td,\r\n");
      out.write("         .va, .va tr td, .comment, .comment tr td\r\n");
      out.write("         {\r\n");
      out.write("            border:1px solid black;\r\n");
      out.write("            border-collapse:collapse;\r\n");
      out.write("            margin:0;\r\n");
      out.write("            padding:0;\r\n");
      out.write("         }\r\n");
      out.write("         \r\n");
      out.write("      </style>\r\n");
      out.write("   </head>\r\n");
      out.write("   <body>\r\n");
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
      out.write("\t</script>\t\r\n");
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
      out.write("\t\t\t\t\t\t<a href=\"#\"><img src=\"/common/img/uniform2.JPG\" width=\"180\" height=\"53\"></a>\r\n");
      out.write("\t\t\t\t\t</h2>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn_all_menu\">전체메뉴 열기</button>\r\n");
      out.write("\t\t\t\t<nav>\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li style=\"background-image: none;\"><a href=\"#\" id=\"navFirst\">학교정보</a>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"box_wrap_ls dep05\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"box_ls\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">항목1</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">항목2</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">항목3</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">항목4</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/ea/goEaMain.uni\">전자결재</a>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"box_wrap_ls dep03\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"box_ls\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a>기안서 작성</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a>품의서 작성</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a>휴가계 작성</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"/ea/goMenuTo.uni\">결재할 문서</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"/ea/goMenuIng.uni\">결재중 문서</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"/ea/goMenuEd.uni\">결재한 문서</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"/ea/goMenuFin.uni\">완료함</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"/ea/goMenuRe.uni\">반려함</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">양식다운로드</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">일정관리</a>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"box_wrap_ls dep02\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"box_ls\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">항목1</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">항목2</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">항목3</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">항목4</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">학생관리</a> \r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"box_wrap_ls dep01\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"box_ls\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">항목1</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">항목2</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">항목3</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">항목4</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</li>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">공지/게시판</a>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"box_wrap_ls dep04\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"box_ls\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">항목1</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">항목2</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">항목3</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">항목4</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">인사관리</a>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"box_wrap_ls dep06\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"box_ls\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">항목1</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">항목2</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">항목3</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">항목4</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
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
      out.write("\t\t\t\t\t\t<a href=\"#none\">휴가계 작성</a>\r\n");
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
      out.write("\t\t\t<li class=\"on\"><a class=\"more\">결재문서 작성</a>\t\t\t\r\n");
      out.write("\t\t\t\t<ul class=\"moreli\" style=\"display:none\">\r\n");
      out.write("\t\t\t\t\t<li><a>기안서 작성</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a>품의서 작성</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a>휴가계 작성</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li><a href=\"/ea/goMenuTo.uni\">결재할 문서</a></li> \r\n");
      out.write("\t\t\t<li><a href=\"/ea/goMenuIng.uni\">결재중 문서</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"/ea/goMenuEd.uni\">결재한 문서</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"/ea/goMenuFin.uni\">완료함</a></li>\r\n");
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
      out.write("\t\t\t<h1 class=\"title\">기안서 작성</h1>\r\n");
      out.write("\t\t</section> \t\r\n");
      out.write("\t\t<!-- 컨텐츠 내용 --> \r\n");
      out.write("\t\t<section class=\"box_instruc_con\">\r\n");
      out.write("\t\t\t<div id=\"printContents\"> \r\n");
      out.write("\t\t\t\t<section class=\"marB40\">\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("      <table border=\"0\" style=\"border-collapse:collapse; margin:0; padding:0;\">    \r\n");
      out.write("         <tr>\r\n");
      out.write("\t\t\t<td align=\"right\" colspan=\"2\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<input type=\"button\" name=\"ap_btn\" id=\"ap_btn\" value=\"승인\" class=\"blue_btn\">\r\n");
      out.write("\t\t\t\t&nbsp;\r\n");
      out.write("\t\t\t\t<input type=\"button\" name=\"rn_btn\" id=\"rn_btn\" value=\"반려\" class=\"blue_btn\">\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("         </tr>\r\n");
      out.write("\t\t <tr>\r\n");
      out.write("\t\t \t<td align=\"right\" colspan=\"2\">\r\n");
      out.write("\t\t \t\t<br><br>\r\n");
      out.write("\t\t \t</td>\r\n");
      out.write("\t\t </tr>    \r\n");
      out.write("\t\t   \r\n");
      out.write("\t\t <!-- 이거 tr 지울까? -->   \r\n");
      out.write("         <tr height=\"70\" >\r\n");
      out.write("            <td colspan=\"2\" style=\"text-align:center; font-size:30px;\">휴 가 계 </td>\r\n");
      out.write("         </tr>\r\n");
      out.write("         \r\n");
      out.write("         <tr>\r\n");
      out.write("            <td width=\"470\">\r\n");
      out.write("               \r\n");
      out.write("               <table class=\"eadocument\">\r\n");
      out.write("                  <tr height=\"35\">\r\n");
      out.write("                     <td width=\"150\" align=\"center\">종류</td>\r\n");
      out.write("                     <td width=\"310\">");
      out.print(do_type );
      out.write("</td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                  <tr height=\"35\">\r\n");
      out.write("                     <td width=\"150\" align=\"center\">작성자</td>\r\n");
      out.write("                     <td width=\"310\">");
      out.print(do_writer );
      out.write("</td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                  <tr height=\"35\">\r\n");
      out.write("                     <td width=\"150\" align=\"center\">제목</td> \r\n");
      out.write("                     <td width=\"310\">");
      out.print(do_title );
      out.write("</td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                  <tr height=\"35\">\r\n");
      out.write("                     <td width=\"150\" align=\"center\">작성일자</td>\r\n");
      out.write("                     <td width=\"310\">");
      out.print(do_insertdate );
      out.write("</td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("               </table>\r\n");
      out.write("            </td>\r\n");
      out.write("            \r\n");
      out.write("            <td align=\"right\">\r\n");
      out.write("               <!-- 결재도장부분 -->\r\n");
      out.write("               <table class=\"ea\">\r\n");
      out.write("                  <tr height=\"35\">\r\n");
      out.write("                     <td rowspan=\"2\" width=\"30\" align=\"center\">결재</td>\r\n");
      out.write("                     <td width=\"120\" align=\"center\">검토</td>\r\n");
      out.write("                     <td width=\"120\" align=\"center\">승인</td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                  <tr height=\"105\">\r\n");
      out.write("                     <td><img src=\"");
      out.print(ea_sign1 );
      out.write("\" width=\"120\" height=\"105\" alt=\"\"></td>\r\n");
      out.write("                     <td><img src=\"");
      out.print(ea_sign2 );
      out.write("\" width=\"120\" height=\"105\" alt=\"\"></td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("               </table>\r\n");
      out.write("            </td>\r\n");
      out.write("         </tr>\r\n");
      out.write("      </table>\r\n");
      out.write(" \r\n");
      out.write("      <!-- 결재의견부분 -->    \r\n");
      out.write("      <table class=\"comment\">\r\n");
      out.write("\t\t <tr height=\"35\">\r\n");
      out.write("   \t\t\t<td width=\"100\" align=\"center\">결재자</td>\r\n");
      out.write("   \t\t\t<td width=\"100\" align=\"center\">결재내용</td>\r\n");
      out.write("   \t\t\t<td width=\"343\" align=\"center\">결재의견</td>\r\n");
      out.write("   \t\t\t<td width=\"200\" align=\"center\">결재일시</td>\r\n");
      out.write("   \t\t </tr>\r\n");
      out.write(" \r\n");
      out.write("   \t\t <tr height=\"35\">\r\n");
      out.write("   \t\t \t<td></td>\r\n");
      out.write("   \t\t \t<td></td>\r\n");
      out.write("   \t\t \t<td><input type=\"button\" name=\"cm_btn\" id=\"cm_btn\" value=\"결재의견 입력\">   \t  \r\n");
      out.write("   \t\t \t\t<form name=\"eaForm\" id=\"eaForm\">\r\n");
      out.write("   \t\t \t\t\t<input type=\"hidden\" name=\"ea_stateno\" id=\"ea_stateno\">\r\n");
      out.write("   \t\t \t\t\t<input type=\"hidden\" name=\"ea_docno\" id=\"ea_docno\" value=\"");
      out.print(do_docno);
      out.write("\">\r\n");
      out.write("   \t  \t\t\t\t<input type=\"text\" name=\"ea_comment\" id=\"ea_comment\" style=\"width:340px; background-color:transparent;\r\n");
      out.write("            \t\tborder-color:transparent;\" readonly >\r\n");
      out.write("   \t \t\t\t</form>\r\n");
      out.write("   \t  \t\t</td>\r\n");
      out.write("   \t\t \t<td></td>\r\n");
      out.write("   \t\t </tr>\r\n");
      out.write("   \t\t \r\n");

		for(int j=0;j<hList.size();j++){
			EaApprovalVO eavo = hList.get(j);
			hea_aprno = eavo.getEa_aprno(); //이름
			hea_stateno = eavo.getEa_stateno(); //상태디테일
			hea_comment = eavo.getEa_comment();
			hea_date = eavo.getEa_date();
			if(hea_comment==null) hea_comment = "";

      out.write("   \t\t\r\n");
      out.write("   \t\t <tr height=\"35\">\r\n");
      out.write("   \t\t \t<td>");
      out.print(hea_aprno );
      out.write("</td>\r\n");
      out.write("   \t\t \t<td>");
      out.print(hea_stateno );
      out.write("</td>\r\n");
      out.write("   \t\t \t<td>");
      out.print(hea_comment );
      out.write("</td>\r\n");
      out.write("   \t\t \t<td>");
      out.print(hea_date );
      out.write("</td>\r\n");
      out.write("   \t\t </tr>\t\t\r\n");
      out.write("   \t\t \r\n");

		} //for문
		if(ea_aprno!=null&& ea_aprno.length()>0&&!ea_stateno.equals("대기")){	

      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t <tr height=\"35\">\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t \t<td>");
      out.print(ea_aprno );
      out.write("</td>\r\n");
      out.write("\t\t \t<td>");
      out.print(ea_stateno );
      out.write("</td>\r\n");
      out.write("\t\t \t<td>");
      out.print(ea_comment );
      out.write("</td>\r\n");
      out.write("\t\t \t<td>");
      out.print(ea_date );
      out.write("</td>\r\n");
      out.write("\t\t </tr>\r\n");

		}

      out.write("\t\t \r\n");
      out.write("      </table>\t\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("      <!-- 문서내용부분  -->\r\n");
      out.write("      <table class=\"va\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"150\" height=\"50\" align=\"center\">휴가종류</td>\r\n");
      out.write("\t\t\t\t<td width=\"590\" align=\"left\">");
      out.print(va_vatype );
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td height=\"50\" align=\"center\">신청일자</td>\r\n");
      out.write("\t\t\t\t<td width=\"590\" align=\"left\">");
      out.print(va_offdate );
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td height=\"50\" align=\"center\">연락처</td>\r\n");
      out.write("\t\t\t\t<td width=\"590\" align=\"left\">");
      out.print(va_phone );
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\t\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td height=\"50\" align=\"center\">신청사유</td>\r\n");
      out.write("\t\t\t\t<td><textarea name=\"va_reason\" id=\"va_reason\" style=\"width:590px;height:200px;\">");
      out.print(va_reason );
      out.write("</textarea></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("      </table>       \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</section>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</section>\r\n");
      out.write("\t</article>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\t\r\n");
      out.write("\t<!-- // 컨텐츠 -->\r\n");
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
      out.write("<!-- //푸터 -->\t\r\n");
      out.write("   </body>\r\n");

	}

      out.write("   \r\n");
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
