<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script type="text/javascript" src="../resources/include/twb_js/jquery-3.1.1.min.js"></script>
    <title>회원가입</title>
    
    
    <script type="text/javascript">
    	function toSubmit() {
    		var frm = document.frm;
    		if(!$("#agree1").is(':checked') || !$("#agree2").is(':checked')) {
    			alert("개인정보 활용에 동의해 주셔야 회원가입이 가능합니다.")
    			return false;
    		}
    		frm.submit();
    		
    	}
	</script>
    
<!-- subTit -->
	<div class="subTit subLogin">
		<h1>회<span>/</span>원<span>/</span>가<span>/</span>입</h1>
	</div>
	<!-- // subTit -->
	<!-- Content -->
	<div class="content">
		<!-- 로그인 박스 -->
		<div class="join_box">
			<!-- 상단 흐름도 -->
			<ul class="join_flow pB50 clearfix">
				<li class="on">
					<p>개인정보<br/>이용동의</p>
				</li>
				<li>
					<p>정보입력</p>
				</li>
				<li>
					<p>회원가입<br/>완료</p>
				</li>
			</ul>
			<!-- // 상단 흐름도 -->

<h4 class="bu05 tit pB10">회원 이용약관</h4>
<form name="frm" id="frm" action="/member/mberForm" method="get" >			
<textarea readonly="readonly">제 1 장 총 칙

제 1 조 (목적)

본 약관은 바리스타 홈페이지 이용과 관련하여 이용자의 권리, 의무 및 책임사항 그리고 기타 필요한 사항을 규정하는 것을 목적으로 합니다.

제 2 조 (약관의 효력 및 변경)

약관의 내용은 서비스 화면에 게시하고 이용자가 동의함으로써 효력이 발생합니다. 검정단은 합리적인 사유가 발생될 경우에는 이 약관을 변경할 수 있으며, 약관이 변경되는 경우에는 최소한 7일전에 공지합니다. 또한 새로운 서비스가 개설될 경우, 별도의 명시된 설명이 없는 한 이 약관에 따라 제공됩니다.

① 본 약관은 검정원이 서비스 화면을 통해 게시하고 이용자가 이에 동의함으로써 효력을 발생합니다.
</textarea>
			<div class="tR mT10 pB50">
				<input type="checkbox" id="agree1"/>
				<label for="agree1">약관을 읽고 동의합니다.</label>
			</div>

			<h4 class="bu05 tit pB10">개인정보 수집&middot;활용이용에 관한 동의</h4>
			<textarea readonly="readonly">제 1 장 총 칙

제 1 조 (목적)

본 약관은 바리스타 홈페이지 이용과 관련하여 이용자의 권리, 의무 및 책임사항 그리고 기타 필요한 사항을 규정하는 것을 목적으로 합니다.

제 2 조 (약관의 효력 및 변경)

약관의 내용은 서비스 화면에 게시하고 이용자가 동의함으로써 효력이 발생합니다. 검정단은 합리적인 사유가 발생될 경우에는 이 약관을 변경할 수 있으며, 약관이 변경되는 경우에는 최소한 7일전에 공지합니다. 또한 새로운 서비스가 개설될 경우, 별도의 명시된 설명이 없는 한 이 약관에 따라 제공됩니다.

① 본 약관은 검정원이 서비스 화면을 통해 게시하고 이용자가 이에 동의함으로써 효력을 발생합니다.
</textarea>
			<div class="tR mT10">
				<input type="checkbox" id="agree2"/>
				<label for="agree1">약관을 읽고 동의합니다.</label>
			</div>

			
			<!-- button -->
			<div class="tC pT30">
				<button type="button" onclick="javascript:toSubmit()" class="btn btn_brown btn_check" style="padding:15px 40px; background-position:17px center; padding-right:20px!important;">모든 약관에 동의합니다.</button>
			</div>
			<!-- // button -->
</form>
		</div>
		<!-- // 로그인 박스 -->
	</div>
	<!-- // Content -->