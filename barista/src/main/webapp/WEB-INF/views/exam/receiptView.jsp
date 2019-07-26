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
   	function goUpdate(exam_sn) {
   		location.href="/exam/receiptForm?exam_sn="+exam_sn;
   	}
   	function goDelete(exam_sn) {
   		location.href="/exam/receiptDel?exam_sn="+exam_sn;
   	}

    
    
    

		
	</script>
    
    <!-- sub 이름 -->	
<div id="sub1_1">
	<div class="wrap1">
		<div class="top">
			<div class="name">접수확인</div>
		</div>
	</div>
</div>

<div id="request">
	<div class="wrap1">
		<form id="frm" name="frm" method="post" onsubmit="toSubmit();return false;" enctype="multipart/form-data">
			<input type="hidden" name="exam_sn" value="${examSn }" />
			<input type="hidden" name="apc_sn" value="${examApplicantVO.apc_sn }" />
			<input type="hidden" name="gunmul" value="${examApplicantVO.gunmul }" />
			<input type="hidden" name="grade" value="${examApplicantVO.grade }" />
			<input type="hidden" name="division" value="exam" />
			<div class="row_table">
			
			<!-- 
			<div class="photo"><img src='<spring:eval expression="@config['upload.dir']" />\_${attachVO.dirpath}\s_${attachVO.savedfilename}'></div>
			 -->
			 <div class="photo"><img src='/displayFile?file_mask_name=${attachVO.savedfilename}&path=${attachVO.dirpath} '></div>
			<table width="100%" cellpadding="0" cellspacing="0" border="0" summary="검정신청">
				<caption>검정신청</caption>
				<colgroup>
				<col width="22%">
				<col width="28%">
				<col width="22%">
				<col width="28%">
				</colgroup>
				
				
				<tr>
					<th class="pd">수험번호</th><td colspan="3">${examApplicantVO.apc_sn}</td>
				</tr>
				<tr>
					<th  class="pd" >시험명</th><td  colspan="3">${masterVO.title}</td>
				</tr>
				<tr>
					<th class="pd" >시험일정</th><td  colspan="3"><fmt:formatDate value="${examde}" pattern="yyyy-mm-dd"/> </td>
				</tr>
				<tr>
					<th class="pd" >시험장소</th><td  colspan="3">${codeVO.cd_nm } (${codeVO.cd_dscr })</td>
				</tr>
				<tr>
					<th >접수기간</th><td  colspan="3"><fmt:formatDate value="${bgnde}" pattern="yyyy-MM-dd HH:mm"/> ~ <fmt:formatDate value="${endde}" pattern="yyyy-MM-dd HH:mm"/>  </td>
				</tr>
				<tr>
					<th ><label for="mane">이름</label></th>
					<td>
					${memberVO.mber_name }
					</td>
					<th ><label for="eng_mane">영문이름</label></th>
					<td >${examApplicantVO.mber_engname}</td>
					
				</tr>
			
				<tr>
				<th >
		
				
				
				<label for="year">생년월일</label></th>
					<td  colspan="3">
						${examApplicantVO.birth}
					</td>
				</tr>
	
				<tr>
					<th >전화번호</th>
					<td  colspan="3">
					${memberVO.mber_phone }
					</td>
				</tr>
				
				
				
				<tr>
					<th><label for="email">이메일</label></th>
					<td colspan="3">
						${memberVO.email }
					</td>
				</tr>
				
				<tr>
					<th><label for="address">주소</label></th><td  colspan="3">${examApplicantVO.address1 }</td>
				</tr>
				
	
			</table>
			</div>
			<div class="button">
			<!-- 
			수정/삭제/인쇄하기 구현 필요.
			 -->
			
			<a href="#update" onclick="javascript:goUpdate('${examSn }')"><img src="http://tong.visitkorea.or.kr/ktobiz/images/common/btn/btnSaveBig.gif" /></a>
			<a href="#delete" onclick="javascript:goDelete('${examSn }')"><img src="http://tong.visitkorea.or.kr/ktobiz/images/common/btn/btnSaveBig.gif" /></a>
			<a href="#cancel" onclick="location.href='/exam/intro'"><img src="http://tong.visitkorea.or.kr/ktobiz/images/common/btn/btnCancelBig.gif" alt="취소"/></a>

			
			</div>
		</form>
	</div>
</div>