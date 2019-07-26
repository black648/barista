<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script type="text/javascript" src="../resources/include/twb_js/jquery-3.1.1.min.js"></script>
    <title>회원가입</title>
    
    
    <script type="text/javascript">
    
	//$("#idCheck").on("click",
		
    
    
    	function toSubmit() {
    		
    		var frm = document.frm;

    		if(frm.email.value=='') {
    			alert("에메일을 입력하세요");
    			frm.email.focus();
    			return;
    		}
    		if(frm.tel1.value=='') {
    			alert("휴대폰 번호를 입력하세요");
    			frm.email.focus();
    			return;
    		}
    		if(frm.tel2.value=='') {
    			alert("휴대폰 번호를 입력하세요");
    			frm.tel2.focus();
    			return;
    		}
    		if(frm.tel3.value=='') {
    			alert("휴대폰 번호를 입력하세요");
    			frm.tel3.focus();
    			return;
    		}
    		if(frm.address1.value=='') {
    			alert("주소를 입력하세요");
    			frm.address1.focus();
    			return;
    		}
    
    		
    		
    		document.frm.submit();
    	}
    </script>
    
    
<!-- sub 이름 -->	
<div id="sub1_1">
	<div class="wrap1">
		<div class="top">
			<div class="name">기본정보 수정</div>
		</div>
	</div>
</div>

<!-- //sub 이름 -->
<div id="request">
	<div class="wrap1">
	<form name="frm" id="frm" method="post">
		<input type="hidden" name="idChk" id="idChk" value="" />
		<input type="hidden" name="prvID" id="prvID" value="" />
		<div class="row_table">
		<table width="100%" cellpadding="0" cellspacing="0" border="0" summary="회원가입">
			<caption>회원가입</caption>
			<colgroup>
			<col width="22%">
			<col width="28%">
			<col width="22%">
			<col width="28%">
			</colgroup>
			<tr>
				<th>아이디</th><td colspan="3"><input class="input2" type="text" name="mber_id" id="mber_id" readOnly="readOnly" value="${memberVO.mber_id }" /></td>
			</tr>

			<tr>
				<th >이름</th><td  colspan="3"><input class="input2" type="text" name="mber_name" id="mber_name" value="${memberVO.mber_name }" /></td>
			</tr>
			

			<tr>
				<th >이메일</th><td  colspan="3"><input class="input2" type="text" name="email" id="email"  value="${memberVO.email }"/></td>
			</tr>

			<tr>
				<th >전화번호</th>
				<td  colspan="3">
			<select name="tel1" id="tel1">
			<option value="010" <c:if test="${memberVO.tel1 eq '010' }">selected</c:if>>010</option>
			<option value="011" <c:if test="${memberVO.tel1 eq '011' }">selected</c:if>>011</option>
			<option value="016" <c:if test="${memberVO.tel1 eq '016' }">selected</c:if>>016</option>
			<option value="019" <c:if test="${memberVO.tel1 eq '019' }">selected</c:if>>019</option>
			</select>
			<input type="text" class="input" title="전화번호 중간" id="tel2" name="tel2" value="${memberVO.tel2 }" />
			<input type="text" class="input" title="전화번호 마지막" id="tel3" name="tel3" value="${memberVO.tel3 }" />
			</td>
			</tr>
			
			<tr>
				<th><label for="address1">주소</label></th><td  colspan="3"><input class="input3" type="text" title="주소" id="address1" name="address1"  value="${memberVO.address1}"></td>
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