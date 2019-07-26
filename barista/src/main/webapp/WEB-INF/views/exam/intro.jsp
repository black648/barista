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
			alert("현재 접수중인 검정을 선택하세요.");
			$("#exam_sn").focus();
			return false;		
		}
		
		$.ajax({
			type:'post',
			url:'/exam/selectReceiptYN',
			dataType:'text',
			data:{exam_sn:$("#exam_sn").val()},
			success:function(result) {
				if(result=='0' ){
					document.frm.action="/exam/receiptForm";
					document.frm.submit();
				}else{
					alert("동일한 날짜에 이미 신청하신 검정이 있습니다.");
					return false;
				}
			}
		});
		
		
	
	}
    
    
		
	</script>
    
	<!-- subTit -->
	<div class="subTit sub05">
		<h1>검<span>/</span>정<span>/</span>신<span>/</span>청<span>/</span>조<span>/</span>회</h1>
	</div>
	<!-- // subTit -->


	<!-- Content -->
	<div class="content">
		<!-- pass -->
		<div class="receipt">
			<p>합격정보를 확인할 검정을 선택하세요.</p>

			<h4 class="bu02 tit">시험명</h4>
			<form name="frm" id="frm" onsubmit="toSubmit();return false;">
			<select class="full" name="exam_sn" id="exam_sn">
				<option value="">선택하세요.</option>
				<c:forEach var="list" items="${list }">
				<!-- varchar타입의 데이터형식을 포맷하기 위해 fmt:parseDate 이용하여 변환 -->
				<fmt:parseDate value='${list.bgnde}' var='bgnde' pattern='yyyyMMddHHmm'/> 
				<fmt:parseDate value='${list.endde}' var='endde' pattern='yyyyMMddHHmm'/>
				<option value="${list.exam_sn }">${list.title } ( <fmt:formatDate value="${bgnde}" pattern="yyyy-MM-dd HH:mm"/> ~ <fmt:formatDate value="${endde}" pattern="yyyy-MM-dd HH:mm"/> )</option>
				</c:forEach>
			</select>

			<!-- button -->
			<div class="mT20 tR">
				<button type="submit" class="btn btn_brown btn_search">조회하기</button>
			</div>
			<!-- // button -->
			
			</form>
		</div>
		<!-- // pass -->
	</div>
	<!-- // Content -->

