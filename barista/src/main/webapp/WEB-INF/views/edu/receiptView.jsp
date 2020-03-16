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
	<fmt:parseDate value='${masterVO.edu_bgnde}' var='edu_bgnde' pattern='yyyymmdd'/>	
	<fmt:parseDate value='${masterVO.edu_endde}' var='edu_endde' pattern='yyyymmdd'/>	
    <script type="text/javascript">
   	function goUpdate(edu_sn) {
   		location.href="/edu/receiptForm?edu_sn="+edu_sn;
   	}
   	function goDelete(edu_sn) {
   		location.href="/edu/receiptDel?edu_sn="+edu_sn;
   	}

    
    
    

		
	</script>
    
    
    <!-- subTit -->
	<div class="subTit sub05">
		<h1>접<span>/</span>수<span>/</span>확<span>/</span>인</h1>
	</div>
	<!-- // subTit -->
	<!-- Content -->
	<div class="content">
		<!-- confrim -->
		<div class="confrim">
			<h4 class="bu05 tit">접수내용 확인</h4>
			<p class="tR f12 mB10">(<span class="Orange Bold">*</span> 표시는 필수 입력사항입니다.)</p>
			<form id="frm" name="frm" method="post" onsubmit="toSubmit();return false;" enctype="multipart/form-data">
				<input type="hidden" name="edu_sn" value="${eduSn }" />
				<input type="hidden" name="apc_sn" value="${eduApplicantVO.apc_sn }" />
				<input type="hidden" name="gunmul" value="${eduApplicantVO.gunmul }" />
				<input type="hidden" name="division" value="edu" />
				<!-- table_box -->
				<div class="table_box">
					<!-- table -->
					<table summary="아이디, 성명, 전화번호, 이메일, 제목, 내용, 공개여부, 파일첨부 항목으로 구성된 게시글 작성표입니다." class="tb03">
						<caption>게시글 작성표</caption>
						<colgroup>
							<col style="width:20%;" />
							<col style="width:80%;" />
						</colgroup>
						<tbody>
							<tr>
								<th scope="row">교육일련번호</th>
								<td>${eduApplicantVO.apc_sn}</td>
							</tr>
							<tr>
								<th scope="row">교육명</th>
								<td>${masterVO.title}</td>
							</tr>
							<tr>
								<th scope="row">교육일정</th>
								<td><fmt:formatDate value="${edu_bgnde}" pattern="yyyy-mm-dd"/> ~ <fmt:formatDate value="${edu_endde}" pattern="yyyy-mm-dd"/></td>
							</tr>
							<tr>
								<th scope="row">접수기간</th>
								<td><fmt:formatDate value="${bgnde}" pattern="yyyy-MM-dd HH:mm"/> ~ <fmt:formatDate value="${endde}" pattern="yyyy-MM-dd HH:mm"/></td>
							</tr>
							<tr>
								<th scope="row">이름</th>
								<td>${memberVO.mber_name }</td>
							</tr>
							<tr>
								<th scope="row">영문이름</th>
								<td>${eduApplicantVO.mber_engname}</td>
							</tr>
							<tr>
								<th scope="row">전화번호</th>
								<td>${memberVO.mber_phone }</td>
							</tr>
							<tr>
								<th scope="row">E-mail</th>
								<td>${memberVO.email }</td>
							</tr>
							<tr>
								<th scope="row">주소</th>
								<td>${eduApplicantVO.address1 }</td>
							</tr>
						</tbody>
					</table>
					<!-- // table -->
					<div class="photo"><img src='/displayFile?file_mask_name=${attachVO.savedfilename}&path=${attachVO.dirpath} '></div>
				</div>
				<!-- // table_box -->
				
				<!-- button -->
				<div class="mT20 tR">
					<button type="button" onclick="javascript:goUpdate('${eduSn }')" class="btn btn_brown btn_save mR10">접수정보 수정</button>
					<button type="button" onclick="javascript:goDelete('${eduSn }')" class="btn btn_red btn_cancel mR10">접수취소</button>
					<button type="button" onclick="location.href='/edu/intro'" class="btn btn_grey btn_list">이전페이지로</button>
				</div>
				<!-- // button -->
			</form>
		</div>
		<!-- // confrim -->
	</div>
	<!-- // Content -->
    