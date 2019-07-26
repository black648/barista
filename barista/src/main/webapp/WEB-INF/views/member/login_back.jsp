<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>로그인</title>



<!-- sub 이름 -->	
<div id="sub1_1">
	<div class="wrap1">
		<div class="top">
			<div class="name">로그인</div>
		</div>
	</div>
</div>

<!-- //sub 이름 -->
<div id="request">
	<div class="wrap1">
	
	<dl class="login_dl33" id="con_btn">
				<dt>회원 로그인</dt>
				<dd class="scol">바리스타 홈페이지에 오신 것을 환영합니다.</dd>
				<dd>로그인 하시면 회원님을 위한 더 많은 서비스를 경험하실 수 있습니다.</dd>
				<dd>바리스타 회원이 되시면, 자격증 조회/발급 서비스를 편리하게 이용하실 수 있습니다.</dd>
				<c:if test="${memberVO.mber_id ne null }"><br /><dd>${memberVO.mber_name}님의 아이디는 <font color="#FF0000">${memberVO.mber_id }</font> 입니다.</dd></c:if>
	</dl>
	
	<form name="frm" action="/member/loginPost" method="post">
		<!-- 
		<div class="row_table">
		<table width="80%" cellpadding="0" cellspacing="0" border="0" summary="로그인">
			<caption>로그인</caption>
			<colgroup>
				<col width="22%">
				<col width="28%">
				<col width="22%">
				<col width="28%">
			</colgroup>
			<tr>
				<th>아이디</th><td colspan="3"><input class="input2" type="text" name="mber_id" id="mber_id" /></td>
			</tr>
			<tr>
				<th >비밀번호</th><td  colspan="3"><input class="input2" type="password" name="password" id="password" /></td>
			</tr>


		</table>
		</div>
		<div class="button">
			<input type="image" src="../resources/include/twb_images/sub_images/sub1_3_on.jpg" title="확인">
			<a href="/main/main"><img src="../resources/include/twb_images/sub_images/sub1_3_off.jpg" alt="취소" /></a>
		
		</div>
		-->
		
		
		<div class="login_div33">
				<div class="firstd">
 
				<!--
					<label for="id">아이디</label>
					<input type="text" name="id" id="id" value="" size="20" title="아이디" /><br />
					<label for="password">비밀번호</label>
					<input type="password" name="password"  id="password" value="" size="20" title="비밀번호" /><br />
					<!-- <a href="javascript:" id="logintBtn" class="login_btn"><img src="/img/vkm/academy/images/login/login_new_14.gif" alt="로그인" /></a> -->
					
				<div class="login_wrap">
                    <div class="login_left">
                        <label for="id">아이디</label>
                        <input type="text" name="mber_id" id="mber_id" value="" size="20" title="아이디" value="${memberVO.mber_id }" /><br />
                        <label for="password">비밀번호</label>
                        <input type="password" name="password"  id="password" value="" size="20" title="비밀번호" /><br />
                        <span  style="width:100px;"><input style="width:15px;" type="checkbox" name="useCookie"> 아이디 저장</span>
                    </div>
                    <div class="login_btn">
                        <button type="submit"  value="로그인" class="han_btnl" alt="로그인" />로그인</button>
                     </div>
				</div>

					<ul>
						<li><span>아이디를 잊으셨나요?</span><a href="/member/idFind"><img src="../resources/include/twb_images/login/login_new_20.gif" alt="아이디찾기" /></a></li>
						<li><span>비밀번호를 잊으셨나요?</span><a href="/member/pwFind"><img src="../resources/include/twb_images/login/login_new_25.gif" alt="비밀번호찾기" /></a></li>
						<li><span>아직 바리스타 회원이 아니세요?</span><a href="/member/mberForm"><img src="../resources/include/twb_images/login/login_new_27.gif" alt="회원가입하기" /></a></li>
					</ul>
				</div>
				
				<div style="clear:both"></div>
			</div>
			<ul class="login_ul33">
				<!--li>회원가입/로그인 문의 서비스데스크 033)738-3860</li>
				<li>관광안내 문의 1330 (일반전화, 공중전화), 02) 1330 (휴대폰)</li-->
				<li>회원가입/로그인 문의  033)000-0000 [온라인 원격지원]</li>
				<li>자격증안내 문의 033)111-1111 </li>
			</ul>
		<!--/내용-->
		
		
		
		</form>
	</div>

</div>
<!-- table-->