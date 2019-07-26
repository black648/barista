 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <meta http-equiv='Content-Type' content='text/html; charset=utf-8' />
  <meta http-equiv="X-UA-compatible" content="IE=EmulateIE10" />

<link rel="stylesheet" href="/resources/include/twb_css/style.css" type="text/css">
<link rel="stylesheet" href="/resources/include/twb_css/init.css" type="text/css">
<link href="/resources/include/twb_css/user_form.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/resources/include/twb_js/jquery-3.1.1.min.js"></script> 
<script type="text/javascript" src="/resources/include/twb_js/jquery.form.js"></script>
<script type="text/javascript" src="/resources/include/twb_js/main.js"></script>
<script type="text/javascript" src="/resources/include/twb_js/jcarousellite_1.0.1c4.js"></script>
<script language="javascript">
/* 만약 오픈 되어 있어야 하는 서브메뉴가 있을때 사용 */
//var old_menuid = 메뉴번호;
var old_viewid = 0;
function menu_view(viewid){
 if(viewid!=old_viewid){
  document.getElementById("submenu"+viewid).style.display="block";
  if(old_viewid!="0")document.getElementById("submenu"+old_viewid).style.display="none";
  old_viewid = viewid;
 }
}
function menu_hide(hideid){
 document.getElementById("submenu"+hideid).style.display="none";
 old_viewid = 0;
}
</script>