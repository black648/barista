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
	<header id="header">
		<h1 class="logo"><a href="/main/main"><img src="/resources/include/images/header/logo.png" alt="바리스타 로고"/></a></h1>

		<nav id="gnb">
			<div class="top_menu">
				<ul>
					<c:choose>
					<c:when test="${login eq null }">
						<li><a href="/member/login">로그인</a></li>
						<li><a href="/member/mberAgree">회원가입</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="/member/mypage">내정보</a></li>
						<li><a href="/member/logout">로그아웃</a></li>
					</c:otherwise>
					</c:choose>
				</ul>
			</div>

			<!-- 검색 영역 -->
			<div class="search_box">
				<div class="search_bar">
					<input type="text" title="검색어를 입력하세요." value="검색어를 입력하세요." class="intxt" id="search" />
					<label for="search" class="label_search"><a href="#" class="btn" title="검색">검색</a></label>
				</div>
			</div>
			<!-- // 검색 영역 -->
			<!-- 메뉴리스트 -->
			<jsp:include page="/common/topMenu" />
			<!--  //메뉴리스트 -->
		
	</header>