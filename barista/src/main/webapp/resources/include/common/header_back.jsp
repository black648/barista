<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <% request.setCharacterEncoding("EUC-KR"); %>
    
    
    <script type="text/javascript">
		$(document).ready(function() {
			if("${message}" != null && "${message}" != "") {
				alert("${message}");
			}
		});
</script>
	<div class="topbox"><!--헤더-->
		<div class="top">
			<div class="hotlink">
				<ul>
					<li onClick="location.href='/main/main'">HOME</li>
					
					<c:choose>
						<c:when test="${login eq null }">
							<li onClick="location.href='/member/login'">로그인</li>
							<li onClick="location.href='/member/mberForm'"  class="end">회원가입</li>
						</c:when>
						<c:otherwise>
							<li onClick="location.href='/member/mypage'">내정보</li>
							<li onClick="location.href='/member/logout'"  class="end">로그아웃</li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div><!-- /hotlink -->
			<div class="h_logo"><!--logo-->
				<a href="/main/main"><img src="/resources/include/twb_images/h_logo.jpg" alt="상단로고"></a>
			</div><!--logo-->
			<!-- 메뉴리스트 -->
			<jsp:include page="/common/topMenu" />
			<!--  //메뉴리스트 -->

		</div><!-- /top -->
	</div><!-- /헤더 -->