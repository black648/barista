<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@page import="java.util.Date"%> 
	
	<c:set var="date1" value="<%=new Date()%>" /> 
	<fmt:formatDate var="yyyy" value='${date1}' pattern='yyyy'/> 	
	<fmt:formatDate var="mm" value='${date1}' pattern='mm'/> 
	<fmt:formatDate var="dd" value='${date1}' pattern='dd'/> 
	<!-- varchar타입의 데이터형식을 포맷하기 위해 fmt:parseDate 이용하여 변환 -->
	<fmt:parseDate value='${masterVO.bgnde}' var='bgnde' pattern='yyyyMMddHHmm'/> 
	<fmt:parseDate value='${masterVO.endde}' var='endde' pattern='yyyyMMddHHmm'/>	
	<fmt:parseDate value='${masterVO.examde}' var='examde' pattern='yyyymmdd'/>	
    <script type="text/javascript">
    $(document).ready(function(){
	   	$("#onDetailView").click(function(event) {
	   		event.preventDefault();
	   		$("#txt3").toggle();
	   		
	   	});
    });
    
    

		
	</script>

	
	<!-- sub 이름 -->	
<div id="sub1_1">
	<div class="wrap1">
		<div class="top">
			<div class="name">합격 여부 확인</div>
		</div>
	</div>
</div>
<!-- sub 이름 -->	
<div id="register">
<div class="wrap1">

			<c:choose>
				<c:when test="${masterVO.examScoreVO.fail_yn eq 'N' and masterVO.examScoreVO.pass_yn eq 'Y'}">
					<c:set var="pass_yn" value="합격" />
				</c:when>
				<c:otherwise><c:set var="pass_yn" value="불합격" /></c:otherwise>
			</c:choose>	
		

		<div class="content">
			<div class="txt1">
				<c:choose>
					<c:when test="${pass_yn eq '합격' }"><span>축하</span>합니다.</c:when>
					<c:otherwise><span>안타깝지만</span></c:otherwise>
				</c:choose>
				
			</div>
			<div class="txt2">${memberVO.mber_name} 님께서는 <span>${masterVO.title }</span> 검정에 
			${pass_yn} 하셨습니다.</div>
			<div id="txt3" class="txt3" style="display:none">
				<div class="scoreBoard">
					<dl><dt>제 1과목</dt><dd>${masterVO.examScoreVO.section1} <c:if test="${masterVO.examScoreVO.section1 lt 40}">과락</c:if> </dd></dl>
					<dl><dt>제 2과목</dt><dd>${masterVO.examScoreVO.section2} <c:if test="${masterVO.examScoreVO.section2 lt 40}">과락</c:if> </dd></dl>
					<dl><dt>제 3과목</dt><dd>${masterVO.examScoreVO.section3} <c:if test="${masterVO.examScoreVO.section3 lt 40}">과락</c:if> </dd></dl>
					<dl><dt>제 4과목</dt><dd>${masterVO.examScoreVO.section4} <c:if test="${masterVO.examScoreVO.section4 lt 40}">과락</c:if> </dd></dl>
					<dl><dt>제 5과목</dt><dd>${masterVO.examScoreVO.section5} <c:if test="${masterVO.examScoreVO.section5 lt 40}">과락</c:if> </dd></dl>
					<dl><dt>종합점수</dt><dd>${masterVO.examScoreVO.total} </dd></dl>
					<dl><dt>최종점수</dt><dd>${masterVO.examScoreVO.score} </dd></dl>
				</div>
			</div>
			
		</div>

		<div class="button">
			<span id="onDetailView"><img src="/resources/include/twb_images/sub_images/sub1_9_on1.jpg" title="검정결과 상세보기" /></span>
		   	<input type="image" src="/resources/include/twb_images/sub_images/sub1_9_on2.jpg" title="실기시험 접수">
		</div>
		
</div>




</div>
	