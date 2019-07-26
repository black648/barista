<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%> 
    

    <script type="text/javascript">
		
		
		function searchBtn() {
			
			self.location="list"
				+'${pageMaker.makeQuery(1)}'
				+"&searchType="
				+$("select option:selected").val()
				+"&keyword="+encodeURIComponent($('#keyword').val());
		}
		
		function searchForm(cal_mm) {

		   	var cal_yyyy = $("#cal_yyyy").val();
			location.href="/barista/schedule?cal_yyyy="+cal_yyyy+"&cal_mm="+cal_mm;
			
			
		}

		
	</script>
    
<!-- subTit -->
	<div class="subTit sub01">
		<h1>바<span>/</span>리<span>/</span>스<span>/</span>타<span>/</span>주<span>/</span>요<span>/</span>일<span>/</span>정</h1>
	</div>
<!-- // subTit -->

<!-- Content -->
	<div class="content">
		<form name="searchFrm" action="/barista/schedule" >
		<!-- Calendar -->
		<div class="calendar">
			<div class="cal_top"></div>
			<div class="cal_box">
				<div class="year">
					<select name="cal_yyyy" id="cal_yyyy"> 
						<c:forEach items="${getYYYYList }" var="yyyyList">
							<option value="${yyyyList }" <c:if test="${yyyyList eq cal_yyyy}">selected="selected"</c:if> >${yyyyList }</option>
						</c:forEach>
					</select>

					<ul id="month_control">
						<li><a href="#" id="mmSearch" onclick="javascript:searchForm(1); return false;">Jan</a></li>
						<li><a href="#" id="mmSearch" onclick="javascript:searchForm(2); return false;">Feb</a></li>
						<li><a href="#" id="mmSearch" onclick="javascript:searchForm(3); return false;">Mar</a></li>
						<li><a href="#" id="mmSearch" onclick="javascript:searchForm(4); return false;">Apr</a></li>
						<li><a href="#" id="mmSearch" onclick="javascript:searchForm(5); return false;">May</a></li>
						<li><a href="#" id="mmSearch" onclick="javascript:searchForm(6); return false;">Jun</a></li>
						<li><a href="#" id="mmSearch" onclick="javascript:searchForm(7); return false;">Jul</a></li>
						<li><a href="#" id="mmSearch" onclick="javascript:searchForm(8); return false;">Aug</a></li>
						<li><a href="#" id="mmSearch" onclick="javascript:searchForm(9); return false;">Sep</a></li>
						<li><a href="#" id="mmSearch" onclick="javascript:searchForm(10); return false;">Oct</a></li>
						<li><a href="#" id="mmSearch" onclick="javascript:searchForm(11); return false;">Nov</a></li>
						<li><a href="#" id="mmSearch" onclick="javascript:searchForm(12); return false;">Dec</a></li>
					</ul>
				</div>

				<div class="cal" style="min-height:700px;">
				
					<p class="mon">
					<fmt:parseDate value='${spec_date}' var='spec_date' pattern='yyyyMMdd'/> 
					<span><fmt:formatDate value="${spec_date}" pattern="yyyy-MM-dd"/> 의 바리스타 일정 입니다.</span>
					</p> 
					
					<!-- table -->
					<table summary="일정 명, 세부일정"  class="tb03">
						<caption>게시글 작성표</caption>
						<colgroup>
							<col style="width:50%;" />
							<col style="width:50%;" />
							<col />
						</colgroup>
						<tbody>
							<tr>
								<th style="text-align:center;" scope="row">일정</th>
								<th style="text-align:center;" scope="row" >세부일정</td>
							</tr>
							<c:forEach items="${list }" var="list">
							<tr>
								<td>${list.memo } </td>
								<td>
								<p class="bu03 txt ellipsis">${list.memo1 }</p>
								<p class="bu03 txt ellipsis">${list.memo2 }</p>
								<p class="bu03 txt ellipsis">${list.memo3 }</p>
								</td>
							</tr>
							</c:forEach>
						</tbody>
			
					</table>
					<!-- // table -->
					
					
				</div>
			</div>
		</div>
		<!-- // Calendar -->
		</form>
	</div>
	<!-- // Content -->