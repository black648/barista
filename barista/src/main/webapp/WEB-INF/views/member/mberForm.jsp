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
    
	<!-- subTit -->
	<div class="subTit subLogin">
		<h1>회<span>/</span>원<span>/</span>가<span>/</span>입</h1>
	</div>
	 <!-- // subTit -->
	<!-- Content -->
	<div class="content">
	<form name="frm" id="frm" action="/member/mberFormPost" method="post">
		<input type="hidden" name="idChk" id="idChk" value="" />
		<input type="hidden" name="prvID" id="prvID" value="" />
		<input type="hidden" name="emailChk" id="emailChk" value="" />
		<input type="hidden" name="emailKey" id="emailKey" value="" />
	
		<!-- 로그인 박스 -->
		<div class="join_box">
			<!-- 상단 흐름도 -->
			<ul class="join_flow pB50 clearfix">
				<li>
					<p>개인정보<br/>이용동의</p>
				</li>
				<li class="on">
					<p>정보입력</p>
				</li>
				<li>
					<p>회원가입<br/>완료</p>
				</li>
			</ul>
			<!-- // 상단 흐름도 -->

			<h4 class="bu05 pB10">회원정보 입력</h4>
			<p class="tR f12">(<span class="Orange Bold">*</span> 표시는 필수 입력사항입니다.)</p>
			<!-- table -->
			<table summary="아이디, 비밀번호, 이름, 이메일, 전화번호, 주소 항목으로 구성된 회원정보 입력표입니다." class="tb02 mT10">
				<caption>회원정보 입력표</caption>
				<colgroup>
					<col style="width:20%;"/>
					<col style="width:80%;"/>
				</colgroup>
				<tbody>
					<tr>
						<th scope="row" class="must">아이디</th>
						<td>
							<input type="text" name="mber_id" id="mber_id" />
							<button type="button" onclick="javascript:idCheck()" class="btn btn_grey">ID 중복체크</button>
						</td>
					</tr>
					<tr>
						<th scope="row" class="must">비밀번호</th>
						<td>
							<input type="password" name="password" id="password" />
							영문자, 숫자를 포함하여 8-20글자를 입력해주세요.
						</td>
					</tr>
					<tr>
						<th scope="row" class="must">비밀번호 확인</th>
						<td>
							<input type="password" name="password2" id="password2" />
							<span class="Orange">비밀번호가 일치하지 않습니다.</span>
						</td>
					</tr>
					<tr>
						<th scope="row" class="must">이름</th>
						<td><input type="text" name="mber_name" id="mber_name" /></td>
					</tr>
					<tr>
						<th scope="row" class="must">이메일</th>
						<td>
							<input type="text" id="email" name="email" class="fL mR10"/>
							@
							<select name="email2" id="email2" title="직접선택">
								<option value="">직접입력</option>
								<option value="@naver.com">네이버</option>
								<option value="@daum.net">다음</option>
								<option value="@gmail.com">구글</option>
							</select>
							<button type="button" onclick="javascript:emailCheck()" class="btn btn_grey">E-mail 인증 </button>
						</td>
					</tr>
					<tr>
						<th scope="row" class="must">이메일 인증키</th>
						<td><input type="text" class="full" title="이메일인증키" id="key" name="key" /></td>
					</tr>
					<tr>
						<th scope="row">전화번호</th>
						<td>
							<select title="010" class="half" name="tel1" id="tel1">
								<option>010</option>
							</select>
							-
							<input type="text" class="half" title="전화번호 중간" id="tel2" name="tel2" />
							-
							<input type="text" class="half" title="전화번호 마지막" id="tel3" name="tel3" />
						</td>
					</tr>
					<tr>
						<th scope="row" rowspan="2">주소</th>
						<td class="noBorder" style="padding-bottom:0;">
							<input type="text" title="주소" id="address1" name="address1" />
							<button class="btn btn_grey">우편번호 찾기</button>
						</td>
					</tr>
					<tr>
						<td>
							<input type="text" placeholder="상세주소를 입력하세요." class="full"/>
						</td>
					</tr>
				</tbody>
			</table>
			<!-- // table -->
			
			<!-- button -->
			<div class="tC pT30">
				<button type="button" onclick="javascript:toSubmit()" class="btn btn_brown btn_check mR10">확인</button>
				<button type="button" onclick="/main/main" class="btn btn_grey btn_cancel">취소</button>
			</div>
			<!-- // button -->
		</div>
		<!-- // 로그인 박스 -->
		</form>
	</div>
	<!-- // Content -->