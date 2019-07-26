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
    
    
<!-- sub 이름 -->	
<div id="sub1_1">
	<div class="wrap1">
		<div class="top">
			<div class="name">아이디찾기</div>
		</div>
	</div>
</div>

<!-- //sub 이름 -->
<div id="request">
	<div class="wrap1">
	<form name="frm" id="frm" method="post">

	 <div class="login_div33">
	 	<div class="all">
	 	<div class="login_wrap">
                    <div class="login_left">
                        <label for="mber_name">이름</label>
                        <input class="input2" type="text" name="mber_name" id="mber_name"/><br />
                        <label for="mber_phone">휴대폰 번호</label>
                        
					<select name="tel1" id="tel1">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="019">019</option>
					</select>
					<input type="text" style="width:70px;" title="전화번호 중간" id="tel2" name="tel2" />
					<input type="text" style="width:70px;" title="전화번호 마지막" id="tel3" name="tel3" />
                      
                    </div>
                    <div class="login_btn">
                        <a onclick="javascript:toSubmit()"  value="조회" class="han_btnl" alt="조회" >조회</a>
                     </div>
				</div>
	 	</div>
	 
	 </div>
	 
		</form>
	</div>

</div>
<!-- table-->