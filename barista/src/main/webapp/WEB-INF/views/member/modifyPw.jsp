<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script type="text/javascript" src="../resources/include/twb_js/jquery-3.1.1.min.js"></script>
    <title>비밀번호 변경</title>
    
    
    <script type="text/javascript">
    
	//$("#idCheck").on("click",
		
    
    
    	function toSubmit() {
    		
    		var frm = document.frm;
			
    		if("${memberVO.password}" != frm.oldpassword.value) {
    			alert("현재 비밀번호가 다릅니다. 비밀번호를 확인하세요.");
    			frm.password.focus();
    			return;
    		}
    		if(frm.password.value=='') {
    			alert("변경할 비밀번호를 입력하세요");
    			frm.password.focus();
    			return;
    		}
    		if(frm.password2.value=='') {
    			alert("변경할 비밀번호를 입력하세요");
    			frm.password2.focus();
    			return;
    		}
    		if(frm.password.value!=frm.password2.value) {
    			alert("입력하신 비밀번호가 다릅니다. 비밀번호를 확인하세요.");
    			frm.password2.focus();
    			return;
    		}
    		if(frm.password.value.length<6 || frm.password.value.length>16) {
    			alert("비밀번호는 6글자 이상 16글자 이하만 이용 가능합니다.");
    			frm.password.focus();
    			return;
    		}
    
    		
    		
    		document.frm.submit();
    	}
    </script>
    
    
<!-- sub 이름 -->	
<div id="sub1_1">
	<div class="wrap1">
		<div class="top">
			<div class="name">비밀번호 수정</div>
		</div>
	</div>
</div>

<!-- //sub 이름 -->
<div id="request">
	<div class="wrap1">
	<form name="frm" id="frm" method="post">
		<input type="hidden" name="idChk" id="idChk" value="" />
		<input type="hidden" name="prvID" id="prvID" value="" />
		<input type="hidden" name="mber_id" id="mber_id" value="${memberVO.mber_id }" />
		
		<div class="row_table">
		<table width="100%" cellpadding="0" cellspacing="0" border="0" summary="비밀번호 수정">
			<caption>비밀번호 수정</caption>
			<colgroup>
			<col width="22%">
			<col width="28%">
			<col width="22%">
			<col width="28%">
			</colgroup>
			<tr>
				<th>현재 비밀번호</th><td colspan="3"><input class="input2" type="password" name="oldpassword" id="oldpassword" /></td>
			</tr>

			<tr>
				<th >새로운 비밀번호</th><td  colspan="3"><input class="input2" type="password" name="password" id="password" /></td>
			</tr>
			

			<tr>
				<th >비밀번호 확인</th><td  colspan="3"><input class="input2" type="password" name="password2" id="password2" /></td>
			</tr>

		</table>
		</div>
		<div class="button">
			<!-- <input type="image" src="../resources/include/twb_images/sub_images/sub1_3_on.jpg" title="확인"> -->
			
			<a onclick="javascript:toSubmit()" href="#"><img src="../resources/include/twb_images/sub_images/sub1_3_on.jpg" title="확인"></a>
			<a href="/main/main"><img src="../resources/include/twb_images/sub_images/sub1_3_off.jpg" alt="취소"></a>
		
		</div>
		</form>
	</div>

</div>
<!-- table-->