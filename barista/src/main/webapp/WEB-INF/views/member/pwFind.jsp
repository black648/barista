<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script type="text/javascript" src="../resources/include/twb_js/jquery-3.1.1.min.js"></script>
    <title>회원가입</title>
    
    
    <script type="text/javascript">
    

    
    	function toSubmit() {
    		
    		var frm = document.frm;
    		if(frm.mber_name.value=='') {
    			alert("이름을 입력하세요");
    			frm.mber_name.focus();
    			return;
    		}
    		if(frm.tel1.value=='') {
    			alert("휴대폰 번호를 입력하세요");
    			frm.tel1.focus();
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

    
    		
    		
    		document.frm.submit();
    	}
    </script>
    
<!-- Content -->
<div class="content">
	<div class="loginsearch_box">
	<h4 class="bu02 tit">비밀번호 찾기</h4> 
	<form name="frm" id="frm" method="post">
			<div class="box">
				<dl>
					<dt>아이디</dt>
					<dd> <input type="text" name="mber_id" id="mber_id"/></dd>
					<!-- 
					<dt>이름</dt>
					<dd> <input type="text" name="mber_name" id="mber_name"/></dd>
					-->
					<dt class="clearfix">휴대폰 번호</dt>
					<dd>
						<select name="tel1" id="tel1" class="half">
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="019">019</option>
						</select>
						<span>&nbsp;-&nbsp;</span>
						<input type="text" class="half" title="전화번호 중간" id="tel2" name="tel2" />
						<span>&nbsp;-&nbsp;</span>
						<input type="text" class="half" title="전화번호 마지막" id="tel3" name="tel3" />					
					</dd>
				</dl>

				<button  onclick="javascript:toSubmit()" class="btn btn_brown" style="border-radius:0; float:right; width:100px; height:70px;">조회</button>

				<div class="mT20 mB10 f12 fL full">
					<button type="button" onclick="location.href='/member/login'" class="btn btn_brown2 btn_login fR mL10">로그인</button>
					<button type="button" onclick="location.href='/member/mberAgree'" class="btn btn_grey btn_search fR mL10">회원가입</button>
				</div>
			</div>
	</form>
	</div>
</div>
<!-- // Content -->