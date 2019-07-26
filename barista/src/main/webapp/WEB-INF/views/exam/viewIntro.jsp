<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@page import="java.util.Date"%> 
	
	<c:set var="date1" value="<%=new Date()%>" /> 
	<fmt:formatDate var="yyyy" value='${date1}' pattern='yyyy'/> 	
	<fmt:formatDate var="mm" value='${date1}' pattern='mm'/> 
	<fmt:formatDate var="dd" value='${date1}' pattern='dd'/> 
		
    <script type="text/javascript">
  
    function toSubmit() {
		if($("#exam_sn").val()=='') {
			alert("접수한 검정을 선택하세요.");
			$("#exam_sn").focus();
			return false;		
		}
		document.frm.action="/exam/receiptView";
		document.frm.submit();
	
	}
    
    
		
	</script>
    
    <!-- sub 이름 -->	
<div id="sub1_1">
	<div class="wrap1">
		<div class="top">
			<div class="name">검정 신청</div>
		</div>
	</div>
</div>

<div id="request">
	<div class="wrap1">
		<h3>${memberVO.mber_name }님께서 접수하신 검정 목록입니다.</h3>
		<form name="frm" id="frm" onsubmit="toSubmit();return false;">
			<div class="row_table">
			<table width="100%" cellpadding="0" cellspacing="0" border="0" summary="검정신청">
				<caption>검정신청</caption>
				<colgroup>
				<col width="22%">
				<col width="78%">
				</colgroup>
				<tr>
					<th>시험명</th>
					<td>
						<select style="width:500px;" name="exam_sn" id="exam_sn">
							<option value="">선택하세요.</option>
							<c:forEach var="list" items="${list }">
							<!-- varchar타입의 데이터형식을 포맷하기 위해 fmt:parseDate 이용하여 변환 -->
							<fmt:parseDate value='${list.bgnde}' var='bgnde' pattern='yyyyMMddHHmm'/> 
							<fmt:parseDate value='${list.endde}' var='endde' pattern='yyyyMMddHHmm'/>
							<option value="${list.exam_sn }">${list.title } ( <fmt:formatDate value="${bgnde}" pattern="yyyy-MM-dd HH:mm"/> ~ <fmt:formatDate value="${endde}" pattern="yyyy-MM-dd HH:mm"/> )</option>
							</c:forEach>
						</select>
					</td>
				</tr>
			</table>
			</div>
			<div class="button">
				<input type="image" src="/resources/include/twb_images/sub_images/sub1_3_on.jpg" title="확인">
			
			</div>
		</form>
	</div>
</div>