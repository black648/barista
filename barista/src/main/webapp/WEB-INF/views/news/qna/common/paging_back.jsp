<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

				<!--Paging Start-->
				<div class="page">
				
					<a href="list${pageMaker.makeSearch(1)}" class="imgbtn"><img src="/resources/include/twb_images/btn/frist_page.gif" alt="첫 페이지" /></a>&#160;
					
					<c:if test="${pageMaker.prev }">
					<a href="list${pageMaker.makeSearch(pageMaker.startPage-1) }"  class="imgbtn">
					<img src="/resources/include/twb_images/btn/previous_page.gif" alt="이전 페이지" /></a>&#160;
					</c:if>
					
					<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
					<a href="list${pageMaker.makeSearch(idx) }" <c:out value="${pageMaker.cri.page ==idx?'class=on':''}"/>>${idx }</a>&#160;
					</c:forEach>
				
					<c:if test="${pageMaker.next && pageMaker.endPage >0 }">
						<a href="list${pageMaker.makeSearch(pageMaker.endPage+1) }" class="imgbtn">
					<img src="/resources/include/twb_images/btn/next_page.gif" alt="다음 페이지" /></a>&#160;
					</c:if>
				
					<a href="?pageIndex=21" onclick="fnLinkPage(21);return false; " class="imgbtn"><img src="/resources/include/twb_images/btn/last_page.gif" alt="마지막 페이지" /></a>&#160;

				</div>
				<!--Paging End-->