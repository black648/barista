<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	
	
	<!-- subTit -->
	<div class="subTit sub03">
		<h1>마<span>/</span>이<span>/</span>페<span>/</span>이<span>/</span>지</h1>
	</div>
	<!-- // subTit -->
	<!-- Content -->
	<div class="content">
	<div class="clearfix">
			<h4 class="bu05 tit pB10"><strong>${memberVO.mber_name}</strong>님 방문을 환영합니다. 가입하신 회원정보는 아래와 같습니다.</h4>
			<div class="apply mT0">
				<div class="img_wrap">
					<img id="img">
				</div>
					<table summary="제목, 성명, 연락처, 성별, 생년월일, e-mail, 사진등록 항목으로 구성된 입사지원서 표입니다." class="tb03">
					<caption>회원정보</caption>
					<colgroup>
						<col style="width:30%;">
						<col style="width:70%;">
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">성명</th>
							<td>${memberVO.mber_name }</td>
						</tr>
						<tr>
							<th scope="row">연락처</th>
							<td>${memberVO.mber_phone }</td>
						</tr>
						<tr>
							<th scope="row">E-mail</th>
							<td>${memberVO.email }</td>
						</tr>
						<tr>
							<th scope="row">회원구분</th>
							<td headers="myPhone">
							<c:choose>
								<c:when test="${memberVO.mber_se eq 'KOR' }">일반회원</c:when>
								<c:when test="${memberVO.mber_se eq 'STF' }">바리스타 직원</c:when>
								<c:when test="${memberVO.mber_se eq 'ENG' }">English Member</c:when>
								<c:when test="${memberVO.mber_se eq 'JPN' }">Japanese Member</c:when>
								<c:when test="${memberVO.mber_se eq 'CHN' }">Chinese Member</c:when>
								<c:when test="${memberVO.mber_se eq 'ETC' }">ETC Member</c:when>
							</c:choose>
							</td>
						</tr>
						<tr>
							<th scope="row">업체명</th>
							<td >한국관광공사 관광정보전략팀</td>
						</tr>
						<tr>
							<th scope="row">주소</th>
							<td >
								${memberVO.address1}
							</td>
						</tr>
						
					</tbody>
				</table>
			</div>	
		</div>
		<!-- button -->
		<div class="mT20 tC full">
			<button type="button" onclick="location.href='/news/qna/list'" class="btn btn_brown btn_login mR10">회원정보수정</button>
			<button type="button" onclick="location.href='/news/qna/list'" class="btn btn_grey btn_check">비밀번호변경</button>
		</div>
		<!-- // button -->
		
		<h4 class="bu05 tit pB10">교육접수현황</h4>
		<table summary="제목, 등록자, 등록일, 담당부서, 처리상태 항목으로 구성된 접수확인 안내표입니다." class="tb01 mT40">
			<caption>접수확인 안내표</caption>
			<colgroup>
				<col style="width:10%;" />
				<col style="width:*;" />
				<col style="width:10%;" />
				<col style="width:10%;" />
				<col style="width:10%;" />
			</colgroup>
			<thead>
				<tr>
					<th scope="col"/>수험번호</th>
					<th scope="col"/>교육명</th>
					<th scope="col"/>신청기간</th>
					<th scope="col"/>교육기간</th>
					<th scope="col"/>처리상태</th>
				</tr>
			</thead>
			<tbody>
			<tr>
				<td class="first title">12312313</td>
				<td>타이틀</td>
				<td>1231231313213</td>
				<td>교육지원팀</td>
				<td>12321312</td>
			</tr>
			</tbody>
			
		</table>
</div>















	


	
	
	
	
	
	
	
	
	



<script type="text/javascript">   
$(document).ready(function() {
// 회원정보 홈 안내
    $('.memberHomeButton').poshytip({
        className: 'tip-violet', 
        showTimeout: 1,
        alignTo: 'target',
        alignX: 'center',
        offsetY: 18,
        allowTipHover: false
    });     
});
</script>
