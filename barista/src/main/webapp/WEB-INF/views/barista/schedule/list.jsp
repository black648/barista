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
			location.href="/barista/schedule/list?cal_yyyy="+cal_yyyy+"&cal_mm="+cal_mm;
			
			
		}

		
	</script>
    
<!-- subTit -->
	<div class="subTit sub01">
		<h1>바<span>/</span>리<span>/</span>스<span>/</span>타<span>/</span>주<span>/</span>요<span>/</span>일<span>/</span>정</h1>
	</div>
<!-- // subTit -->

<!-- Content -->
	<div class="content">
		<form name="searchFrm" action="/barista/schedule/list" >
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

				<div class="cal">
					<p class="mon"><span>${cal_mm}</span></p>

					<table summary="요일, 날짜별 주요일정 안내표입니다." class="tbl">
						<caption>주요일정 안내표</caption>
						<colgroup>
							<col style="width:14%;"/>
							<col style="width:14%;"/>
							<col style="width:14%;"/>
							<col style="width:14%;"/>
							<col style="width:14%;"/>
							<col style="width:14%;"/>
							<col style="width:14%;"/>
						</colgroup>
						<thead>
							<tr>
								<th scope="col">SUN</th>
								<th scope="col">MON</th>
								<th scope="col">TUE</th>
								<th scope="col">WED</th>
								<th scope="col">THU</th>
								<th scope="col">FRI</th>
								<th scope="col">SAT</th>
							</tr>
						</thead>
						<tbody>
						
						
					<c:forEach  var="list" items="${getCalList }" varStatus="status">
					<c:if test="${list.cal_day_num eq '1' }">
						<tr>
					</c:if>
					<c:choose>
						<c:when test="${list.cal_dd eq 1}">
							<c:forEach  var="intTd" begin="1" end="${list.cal_day_num-1 }">
								<td></td>
							</c:forEach>
						</c:when>
						
					</c:choose>
					<c:choose>
						<c:when test="${list.holiday_yn eq 'Y' and list.cal_day_num ne '7' }">
							<td style="color:#cf1e1e;">
								<span class="date">${list.cal_dd }</span>
								<p class="txt">${list.text }</p>
							</td>
						</c:when>
						<c:when test="${list.cal_day_num eq '7'}">
							<td class="last"><span class="date">${list.cal_dd }<p class="txt"></p></span></td></tr>
						</c:when>
						<c:otherwise>
							<td><span <c:choose>
								<c:when test="${fn:length(list.calendarDetailVO) ne 0}">class="date on"</c:when>
								<c:otherwise>class="date"</c:otherwise>
							</c:choose>><a href="/barista/schedule/view?spec_date=${list.cal_yyyymmdd }" >${list.cal_dd }</a></span>
							<c:forEach var="detail" items="${list.calendarDetailVO }"  >
								<p class="bu03 txt ellipsis">${fn:substring(detail.memo,0,12)}...</p>
							</c:forEach>
							</td>
						</c:otherwise>
					</c:choose>
					
					<c:if test="${status.last and list.cal_day_num ne '7'  }">
						<c:forEach  var="lasTd" begin="1" end="${6-list.cal_day_num }" varStatus="status2">
								<td></td>
								
								<c:if test="${status2.last }">
									<td class="last"></td>
								</c:if>
						</c:forEach>
					</c:if>
				</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- // Calendar -->
		</form>
	</div>
	<!-- // Content -->