<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 메인 메뉴 -->
			<ul class="menu">
			<c:forEach var="menuList" items="${menuList}" varStatus="status">
					<c:choose>
					<c:when test="${menuList.lvl eq 1 }">
					 	<!-- 1레벨의 url을 변수 선언  -->
						<c:set var="pUrl" value="${menuList.url }" />
						
						<c:if test="${menuList.ord ne 1 }">
							</ul>
							</li>
						</c:if>
					
						
						<li><a href="#">${menuList.menu_name }</a>
						<ul class="lnb">
					</c:when>
					<c:otherwise>
						<li><a href="/${pUrl}/${menuList.url }">${menuList.menu_name }(${menuList.menu_form })</a></li>
					</c:otherwise>
					
					</c:choose>
					<c:if test="${status.last }">
					</ul>
				</li>
				<li id="menu_all"><a href="#">메뉴 전체보기</a></li>
					</c:if>
				</c:forEach>
			</ul>
			</nav>
				
			
			<div class="menu_all">
			<h4>사이트맵</h4>
			<c:forEach var="menuList" items="${menuList}" varStatus="status">
				<c:choose>
						<c:when test="${menuList.lvl eq 1 }">
						 	<!-- 1레벨의 url을 변수 선언  -->
							<c:set var="pUrl" value="${menuList.url }" />
							
							<c:if test="${menuList.ord ne 1 }">
								</dl>
							</c:if>
						
							<dl>
							<dt>${menuList.menu_name }</dt>
						</c:when>
						<c:otherwise>
						<dd><a href="/${pUrl}/${menuList.url }">${menuList.menu_name }(${menuList.menu_form })</a></dd>
					</c:otherwise>
					
				</c:choose>
				<c:if test="${status.last }"></dl></c:if>
			</c:forEach>
			<!-- 
			<dl>
				<dt>바리스타</dt>
				<dd><a href="#">바리스타 소개</a></dd>
				<dd><a href="#">바리스타 주요일정</a></dd>
			</dl>
			<dl>
				<dt>취업정보</dt>
				<dd><a href="#">취업정보안내</a></dd>
				<dd><a href="#">이력서 등록</a></dd>
				<dd><a href="#">일자리 현황</a></dd>
			</dl>
			<dl>
				<dt>교육정보</dt>
				<dd><a href="#">교육안내</a></dd>
				<dd><a href="#">교육일정</a></dd>
				<dd><a href="#">교육신청</a></dd>
				<dd><a href="#">신청조회</a></dd>
				<dd><a href="#">수료증발급</a></dd>
			</dl>
			<dl>
				<dt>자격정보</dt>
				<dd><a href="#">자격증안내</a></dd>
				<dd><a href="#">검정일정</a></dd>
				<dd><a href="#">검정신청</a></dd>
				<dd><a href="#">접수확인</a></dd>
				<dd><a href="#">합격자조회</a></dd>
				<dd><a href="#">자격증발급</a></dd>
			</dl>
			<dl>
				<dt>알림마당</dt>
				<dd><a href="#">공지사항</a></dd>
				<dd><a href="#">FAQ</a></dd>
				<dd><a href="#">Q&amp;A</a></dd>
			</dl>
			 -->
		</div>
		
			
			
			
			
			
			
			<!-- // 메인 메뉴 -->