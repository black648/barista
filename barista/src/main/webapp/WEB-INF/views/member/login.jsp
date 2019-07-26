<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>로그인</title>

	<!-- Content -->
	<div class="content">
		<div class="login_box">
			<h4>회원 로그인</h4>
			<p style="line-height:1.4;"><span  class="Gold">바리스타 홈페이지에 오신 것을 환영합니다.</span><br/>로그인 하시면 회원님을 위한 더 많은 서비스를 경험하실 수 있습니다.<br/>바리스타 회원이 되시면 자격증 조회 및 발급 서비스를 편리하게 이용하실 수 있습니다.</p>
			<c:if test="${memberVO2 ne null }">
			<br /><p style="line-height:1.4;"><font color="#FF0000">${mberName}</font> 님의 아이디는 <br />
				<c:forEach items="${memberVO2 }" var="memberVO">
					<font color="#FF0000">${memberVO.mber_id }</font> <br />
				</c:forEach>
				입니다.</p>
			
			</c:if>
			<form name="frm" action="/member/loginPost" method="post">
				<div class="box">
					<dl>
						<dt>아이디</dt>
						<dd><input type="text" name="mber_id" id="mber_id" value="" title="아이디" value="${memberVO.mber_id }" /></dd>
	
						<dt class="clearfix">비밀번호</dt>
						<dd><input type="password" name="password"  id="password" value="" title="비밀번호" /></dd>
					</dl>
	
					<button type="submit" class="btn btn_brown btn_login2" style="border-radius:0; float:right; width:100px; height:70px;">로그인</button>
			</form>
				<div class="mT20 mB10 f12 fL full">
					<input  type="checkbox" name="useCookie" />
					<label for="save">아이디 저장</label>
					<button type="button" onclick="location.href='/member/idFind'" class="btn btn_grey fR mL10">아이디 찾기</button>
					<button type="button" onclick="location.href='/member/pwFind'" class="btn btn_grey fR mL10">비밀번호 찾기</button>
					<button type="button" onclick="location.href='/member/mberForm'" class="btn btn_brown2 fR">회원가입</button>
				</div>
	
				<ul class="clearfix f12">
					<li>회원가입/로그인 문의 033)000-0000  [온라인 원격지원]</li>
					<li>자격증안내 문의 033)000-0000</li>
				</ul>
			</div>
			
		</div>
	</div>
	<!-- // Content -->