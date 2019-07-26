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
    
<!-- subTit -->
	<div class="subTit sub05">
		<h1>공<span>/</span>지<span>/</span>사<span>/</span>항</h1>
	</div>
<!-- // subTit -->
	<!-- Content -->
	<div class="content">
		<!-- 검색 -->
		<form method="get">
		<input type="hidden" name="page" value="1" />
		<input type="hidden" name="perPageNum" value="10" />
		<div class="content-search">
			<div class="search_wrap clearfix">
				<select title="검색 분류" id="searchType" name="searchType">
					<option value="tc" <c:out value="${cri.searchType eq 'tc'?'selected':'' }" />>전체</option>
					<option value="t" <c:out value="${cri.searchType eq 't'?'selected':'' }" /> >제목</option>
					<option value="c" <c:out value="${cri.searchType eq 'c'?'selected':'' }" /> >내용</option>
				</select>
				<input type="text" placeholder="검색어를 입력해주세요." title="검색어입력" id="keyword" name="keyword" value="${cri.keyword }" />
				<button type="button" onclick="javascript:searchBtn()" class="btn-search">검색</button>
			</div>

			<p class="fR">전체 : <span class="Gold bold">${pageMaker.totalCount }</span>건</p>
		</div>
		<!-- // 검색 -->
		<!-- table -->
		<table summary="번호, 구분, 제목, 등록자, 등록일, 조회수 항목으로 구성된 접수확인 안내표입니다." class="tb01 mT40">
			<caption>접수확인 안내표</caption>
			<colgroup>
				<col style="width:7%;" />
				<col style="width:10%;" />
				<col style="width:*;" />
				<col style="width:10%;" />
				<col style="width:10%;" />
				<col style="width:7%;" />
			</colgroup>
			<thead>
				<tr>
					<th scope="col"/>번호</th>
					<th scope="col"/>구분</th>
					<th scope="col"/>제목</th>
					<th scope="col"/>등록자</th>
					<th scope="col"/>등록일</th>
					<th scope="col"/>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="boardVO" items="${list}">
				<tr>
					<th scope="row" class="tC">${boardVO.id }</th>
					<td class="tC">${boardVO.dept }</td>
					<td><span class="ellipsis" style="width:700px;"><a href="view${pageMaker.makeSearch(pageMaker.cri.page)}&id=${boardVO.id}">${boardVO.title }</a></span></td>
					<td class="tC">${boardVO.upd_nm} </td>
					<td class="tC"><fmt:formatDate pattern="yyyy-MM-dd" value="${boardVO.cre_de }" /></td>
					<td class="tC">${boardVO.read_cnt }</td>
				</tr>
				</c:forEach>
				</tbody>
		</table>
		<!-- // table -->
		<jsp:include page="../common/paging.jsp"></jsp:include>
		</form>
	</div>