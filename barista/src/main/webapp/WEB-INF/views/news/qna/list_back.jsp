<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    

    <script type="text/javascript">
		
		
		function searchBtn() {
			
			self.location="list"
				+'${pageMaker.makeQuery(1)}'
				+"&searchType="
				+$("select option:selected").val()
				+"&keyword="+encodeURIComponent($('#keyword').val());
		}
		
	</script>
    
    <!-- sub 이름 -->	
<div id="sub1_1">
	<div class="wrap1">
		<div class="top">
			<div class="name">Q&A</div>
		</div>
	</div>
</div>


<div id="request">
	<div class="wrap1">
	<form method="get">
		<input type="hidden" name="page" value="1" />
		<input type="hidden" name="perPageNum" value="10" />
	<!--내용-->
				<div class="sub6_serch_box">
					<div class="left">
						<label for="search1">검색어</label>
					</div>
					<div class="left">
						<select class="s01" id="searchType" name="searchType">
							<option value="tc" <c:out value="${cri.searchType eq 'tc'?'selected':'' }" />>전체</option>
							<option value="t" <c:out value="${cri.searchType eq 't'?'selected':'' }" /> >제목</option>
							<option value="c" <c:out value="${cri.searchType eq 'c'?'selected':'' }" /> >내용</option>
						</select>   
					</div>
					<div class="left">
						<label class="hidden" for="s02">검색어 입력</label>
						<input class="s02" type="text" id="keyword" name="keyword" value="${cri.keyword }"  />
					</div>
					<div class="left">
						<a href="javascript:searchBtn()" id="searchBtn">검색</a>
					</div>
					<div class="clear"></div>
				</div>
	
<div class="tableWrapGray">
<p style="text-align:right; font-size:12px;">총 게시글 : ${pageMaker.totalCount } 건</p>
<table class="dataTable" summary="글번호,">
<caption>채용직무에 따른 채용정보표</caption>
<thead>
<tr>
<th scope="col">제목</th>
<th width="14%" scope="col">등록자</th>
<th width="23%" scope="col">등록일</th>
<th width="15%" scope="col">담당부서</th>
<th width="10%" scope="col">처리상태</th>
</tr>
</thead>
<tbody>
<c:forEach var="qnaVO" items="${list}">
<tr>
<td class="first title"><a href="view${pageMaker.makeSearch(pageMaker.cri.page)}&sn=${qnaVO.sn}">${qnaVO.title }</a></td>
<td>${qnaVO.mber_name }</td>
<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${qnaVO.cre_de }" /></td>
<td>교육지원팀</td>
<td>
<c:choose>
<c:when test="${qnaVO.state eq '1'}" >접수 중</c:when>
<c:when test="${qnaVO.state eq '2'}">처리 중</c:when>
<c:when test="${qnaVO.state eq '3'}">완료</c:when>
</c:choose>
</td>
</tr>
</c:forEach>
</tbody>

</table>
<a href="form">글쓰기</a>
</div>
<jsp:include page="common/paging.jsp"></jsp:include>
</form>



</div></div>