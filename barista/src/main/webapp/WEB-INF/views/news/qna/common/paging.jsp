<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

				<!--Paging Start-->
		<div class="paging_area">
			<div class="paging">
				
					<a href="list${pageMaker.makeSearch(1)}" class="prev"><img src="/resources/include/images/ico/ico_prev2.png" alt="첫 페이지" /></a>&#160;
					
					<c:if test="${pageMaker.prev }">
					<a class="prev" href="list${pageMaker.makeSearch(pageMaker.startPage-1) }">
					<img src="/resources/include/images/ico/ico_prev.png" alt="이전 페이지 이동"/></a>
					</c:if>
					
					<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
					<a href="list${pageMaker.makeSearch(idx) }" <c:out value="${pageMaker.cri.page ==idx?'class=num on':'num'}"/>>${idx }</a>&#160;
					</c:forEach>
				
					<c:if test="${pageMaker.next && pageMaker.endPage >0 }">
						<a href="list${pageMaker.makeSearch(pageMaker.endPage+1) }" class="next">
						<img src="/resources/include/images/ico/ico_next.png" alt="다음 페이지 이동"/></a>
					</c:if>
				
					<a href="?pageIndex=21" onclick="fnLinkPage(21);return false; " class="next"><img src="/resources/include/images/ico/ico_next2.png" alt="마지막 페이지" /></a>&#160;

			</div>
		</div>
				<!--Paging End-->