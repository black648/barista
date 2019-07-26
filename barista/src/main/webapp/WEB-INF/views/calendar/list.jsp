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
			<div class="name">바리스타 주요일정</div>
		</div>
	</div>
</div>


<div id="calendar">
	<div class="wrap1">
		<div class="search">
			<form name="searchFrm" action="/calendar/list" >
				<span class="yyyy">
					<select name="cal_yyyy" id="cal_yyyyy"> 
						<c:forEach items="${getYYYYList }" var="yyyyList">
							<option value="${yyyyList }" <c:if test="${yyyyList eq cal_yyyy}">selected="selected"</c:if> >${yyyyList }</option>
						</c:forEach>
					
					</select>
				</span>
				<span class="mm">
					<select name="cal_mm" id="cal_mm"> 
						<c:forEach  var="mmList" begin="1" end="12" varStatus="status2">
							<option value="${mmList }" <c:if test="${mmList eq cal_mm}">selected="selected"</c:if> >${mmList }</option>
						</c:forEach>
					</select>
				</span>
				<span class="btn"><input type="submit" value="조회" style="width:80px; padding:8px 15px;" /></span>
			</form>
		</div>
		<div class="content">
			<table class="calTable" width="100%" cellpadding="0" cellspacing="0" border="0" summary="바리스타주요일정">
				<caption>바리스타주요일정</caption>
				<colgroup>
				<col width="14.28%">
				</colgroup>
				<tr>
					<th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th class="last">토</th>
				</tr>
				
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
							<td><span class="hol">${list.cal_dd }</span></td>
						</c:when>
						<c:when test="${list.cal_day_num eq '7'}">
							<td class="last"><span class="hol">${list.cal_dd }</span></td></tr>
						</c:when>
						<c:otherwise>
							<td><span>${list.cal_dd }</span></td>
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
					
			</table>
		</div>
	</div>
</div>
