<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script type="text/javascript" src="../resources/include/twb_js/jquery-3.1.1.min.js"></script>
    <title>회원가입</title>
    
    
    <script type="text/javascript">
    
	//$("#idCheck").on("click",
			function idCheck(){
	 			//alert("1111111111111111");
	 			
	 			var mber_id=$("#mber_id").val();
	 			var result1="";
	 		
    			$.ajax({
    			type:'post',
    			url:'/member/idCheck',
    			dataType:'text',
    			data:{mber_id:mber_id},
    			success:function(result) {
    				if(document.frm.mber_id.value=='' ){
    					alert("아이디를 입력해주세요.");
    					document.frm.mber_id.focus();
    				}
    				else if(result=='') {
    					alert("사용가능한 아이디입니다.");
    					alert(result);
    					$("#idChk").val('Y');
    					$("#prvID").val(mber_id);
    					document.frm.password.focus();
    					
    				}else{
    					alert("이미 사용중인 아이디입니다.");
    					$("#idChk").val('N');
    					document.frm.mber_id.focus();
    				}
    			}
    		});
    	}
	
			function emailCheck(){
	 			//alert("1111111111111111");
	 			
	 			var email=$("#email").val();
	 			var result1="";
	 			if(document.frm.email.value=='' ){
					alert("이메일을 입력해주세요.");
					document.frm.email.focus();
				}else {
	    			$.ajax({
	    			type:'post',
	    			url:'/member/emailCheck',
	    			dataType:'json',
	    			data:{email:email},
	    			success:function(result) {
	    				alert(result.rst);
	    				alert(result.emailKeyVO2.key);
	    				if(result.rst=='Y') {
	    					alert("인증키가 이메일로 발급되었습니다.");
	    					$("#emailChk").val('Y');
	    					$("#emailKey").val(result.emailKeyVO2.key);
	    					document.frm.email.focus();
	    					
	    				}else{
	    					alert("이미 사용중인 이메일입니다.");
	    					$("#emailChk").val('N');
	    					document.frm.email.focus();
	    				}
	    			}
	    		});
			}
    	}
	
    
    
    	function toSubmit() {
    		
    		var frm = document.frm;
    		
    		if($("#idChk").val()=="" || $("#idChk").val()=="N" || $("#prvID").val()!=frm.mber_id.value) {
    			alert("아이디 중복 확인을 해주세요.");
    			frm.mber_id.focus();
    			return;
    		}
    		
    		if(frm.mber_id.value=='') {
    			alert("아이디를 입력하세요");
    			frm.mber_id.focus();
    			return;
    		}
    		if(frm.password.value=='') {
    			alert("비밀번호를 입력하세요");
    			frm.password.focus();
    			return;
    		}
    		if(frm.password.value!=frm.password2.value) {
    			alert("비밀번호를 확인하세요");
    			frm.password.focus();
    			return;
    		}
    		if(frm.password.value.length<6 || frm.password.value.length>16) {
    			alert("비밀번호는 6글자 이상 16글자 이하만 이용 가능합니다.");
    			frm.password.focus();
    			return;
    		}
    		
    		
    		if(frm.mber_name.value=='') {
    			alert("이름을 입력하세요");
    			frm.mber_name.focus();
    			return;
    		}
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
    		if($("#emailChk").val()=="" || $("#emailChk").val()=="N" || $("#emailKey").val()!=frm.key.value) {
    			alert("이메일 인증을 확인해 주세요.");
    			frm.mber_id.focus();
    			return;
    		}
    		
    		
    		document.frm.submit();
    	}
    	
    	
    	 $(document).ready(function(){
    		    var orgEmail1="";
    		    $("#email2").on("change", function() { 
    		    	//이부분 현재 에러로 확인 필요함.
    		    	orgEmail1=$("#email").val().split("@");
    		    	if($("#email2").val()!=""){ 
    		    	    $("#email").val(orgEmail1[0]+$("#email2").val());
    		    	}
    		
    		    });
    	    });

    	
    </script>
    
    
<!-- sub 이름 -->	
<div id="sub1_1">
	<div class="wrap1">
		<div class="top">
			<div class="name">회원가입</div>
		</div>
	</div>
</div>

<!-- //sub 이름 -->
<div id="request">
	<div class="wrap1">
	<form name="frm" id="frm" action="/member/mberFormPost" method="post">
		<input type="hidden" name="idChk" id="idChk" value="" />
		<input type="hidden" name="prvID" id="prvID" value="" />
		<input type="hidden" name="emailChk" id="emailChk" value="" />
		<input type="hidden" name="emailKey" id="emailKey" value="" />
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
				<th>아이디</th><td colspan="3"><input class="input2" type="text" name="mber_id" id="mber_id" /> <a href="#" onclick="javascript:idCheck()">ID중복체크</a></td>
			</tr>
			<tr>
				<th >비밀번호</th><td  colspan="3"><input class="input2" type="password" name="password" id="password" /></td>
			</tr>
			<tr>
				<th >비밀번호 확인</th><td  colspan="3"><input class="input2" type="password" name="password2" id="password2" /></td>
			</tr>
			<tr>
				<th >이름</th><td  colspan="3"><input class="input2" type="text" name="mber_name" id="mber_name" /></td>
			</tr>
			

		
			
			<tr>
					<th><label for="email">이메일</label></th>
					<td colspan="3">
						<input class="input2" type="text" title="이메일1" id="email" name="email">
						<select name="email2" id="email2">
							<option value="">직접입력</option>
							<option value="@naver.com">네이버</option>
							<option value="@daum.net">다음</option>
							<option value="@gmail.com">구글</option>
						</select>
						 <a href="#" onclick="javascript:emailCheck()">인증</a>
					</td>
				</tr>
			<tr>
				<th><label for="key">이메일인증키</label></th>
				<td colspan="3">
						<input class="input2" type="text" title="이메일인증키" id="key" name="key">
					</td>
			</tr>

			<tr>
				<th >전화번호</th>
				<td  colspan="3">
			<select name="tel1" id="tel1">
			<option value="010">010</option>
			</select>
			<input type="text" class="input" title="전화번호 중간" id="tel2" name="tel2" />
			<input type="text" class="input" title="전화번호 마지막" id="tel3" name="tel3" />
			</td>
			</tr>
			
			<tr>
				<th><label for="address1">주소</label></th><td  colspan="3"><input class="input3" type="text" title="주소" id="address1" name="address1"></td>
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