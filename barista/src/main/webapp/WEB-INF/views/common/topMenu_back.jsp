<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="menu"><!--menu-->
				<ul>
				<c:forEach var="menuList" items="${menuList}" varStatus="status">
					<c:choose>
					<c:when test="${menuList.lvl eq 1 }">
					 	<!-- 1레벨의 url을 변수 선언  -->
						<c:set var="pUrl" value="${menuList.url }" />
						
						<c:if test="${menuList.ord ne 1 }">
							</ul>
							</li>
						</c:if>
					
						
						<li onmouseover="javascript:menu_view(${menuList.ord});" onmouseout="javascript:menu_hide(${menuList.ord});">${menuList.menu_name }
						<ul id="submenu${menuList.ord}"  onmouseover="javascript:menu_view(${menuList.ord});" onmouseout="javascript:menu_hide(${menuList.ord});">
					</c:when>
					<c:otherwise>
						<li class="submenu1" onClick="location.href='/${pUrl}/${menuList.url }'">${menuList.menu_name }(${menuList.menu_form })</li>
					</c:otherwise>
					
					</c:choose>
					<c:if test="${status.last }">
					</ul>
				</li>
					</c:if>
				</c:forEach>
				<!-- 
					<li onmouseover="javascript:menu_view(1);" onmouseout="javascript:menu_hide(1);">바리스타
						<ul id="submenu1"  onmouseover="javascript:menu_view(2);" onmouseout="javascript:menu_hide(1);">
							<li class="submenu1" onClick="location.href='../user_sub.php?pagecode=01_02_01_00_00'">바리스타 소개(H)</li>
							<li class="submenu1" onClick="location.href='/calendar/list'">바리스타 주요일정</li>
						</ul>
					</li>
        
					<li onmouseover="javascript:menu_view(2);" onmouseout="javascript:menu_hide(2);">취업정보
						<ul id="submenu2" onmouseout="javascript:menu_hide(2);">
							<li class="submenu2" onClick="location.href='../user_sub.php?pagecode=01_03_01_00_00'">취업정보안내(H)</li>
							<li onClick="location.href='../user_sub.php?pagecode=01_03_02_00_00'">이력서등록(개발)</li>
							<li onClick="location.href='../user_sub.php?pagecode=01_03_03_00_00'">일자리현황(개발)</li>
						</ul>
					</li>
        
					<li onmouseover="javascript:menu_view(3);" onmouseout="javascript:menu_hide(3);">교육정보
						<ul id="submenu3" onmouseout="javascript:menu_hide(3);">
							<li class="submenu3" onClick="location.href='../user_sub.php?pagecode=01_03_01_00_00'">교육안내(H)</li>
							<li onClick="location.href='../user_sub.php?pagecode=01_03_02_00_00'">교육일정(개발)</li>
							<li onClick="location.href='../user_sub.php?pagecode=01_03_02_00_00'">교육신청(개발)</li>
							<li onClick="location.href='../user_sub.php?pagecode=01_03_02_00_00'">신청조회(개발)</li>
							<li onClick="location.href='../user_sub.php?pagecode=01_03_02_00_00'">수료증발급(개발)</li>
						</ul>
					</li>
        
					<li onmouseover="javascript:menu_view(4);" onmouseout="javascript:menu_hide(4);">자격정보
						<ul id="submenu4"  onmouseout="javascript:menu_hide(4);">
							<li class="submenu4" onClick="location.href='../user_sub.php?pagecode=01_03_02_00_00'">자격증소개(H)</li>
							<li onClick="location.href='../user_sub.php?pagecode=01_03_02_00_00'">시험일정(개발)</li>
							<li onClick="location.href='/exam/intro'">시험신청(개발)</li>
							<li onClick="location.href='/exam/viewIntro'">시험접수확인(개발)</li>
							<li onClick="location.href='/exam/passList'">합격자조회(개발)</li>
							<li onClick="location.href='../user_sub.php?pagecode=01_03_02_00_00'">자격증발급(개발)</li>
						</ul>
					</li>

					<li onmouseover="javascript:menu_view(5);" onmouseout="javascript:menu_hide(5);">알림마당
						<ul id="submenu5" onmouseout="javascript:menu_hide(5);">
							<li class="submenu4" onClick="location.href='/board/notice/list'">공지사항</li>
							<li onClick="location.href='../user_sub.php?pagecode=01_03_02_00_00'">FAQ</li>
							<li onClick="location.href='/qna/list'">Q&A</li>
						</ul>
					</li>
				 -->
		
				</ul>
			</div><!--menu-->