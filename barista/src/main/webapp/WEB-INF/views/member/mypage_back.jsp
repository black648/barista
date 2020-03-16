<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="wrap1">
	<h1 class="tit">
		<img src="/resources/include/twb_images/login/h1MemberInfo.gif" alt="회원정보" />
	</h1>

	<div class="memberInfoName">
		<strong>${memberVO.mber_name}</strong>님 방문을 환영합니다. 가입하신 회원정보는 아래와 같습니다.
	</div>
	<h2 class="tit">
		<img src="/resources/include/twb_images/login/h2MemberInfo01.gif" alt="기본정보" />
	</h2>
	<div class="tableWrapGray">
		
		<table class="dataTable2" summary="기본정보(아이디, 이메일, 연락처, 휴대폰번호)">
		
				
			<caption>기본정보 표</caption>
			<colgroup>
				<col style="width: 20%;" />
				<col />
				<col style="width: 20%;" /> 
				<col />
			</colgroup>
			<tbody>
				
					<tr>
						<th class="first" id="myId">아이디</th>
						<td headers="myId">${memberVO.mber_id}</td>
						<th id="myEmail">이메일</th>
						<td headers="myEmail">${memberVO.email}</td>
					</tr>
					<tr>
						<th class="first" id="myPhone">회원구분</th>
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
						<th id="myMoblPhone">휴대폰번호</th>
						<td headers="myMoblPhone">${memberVO.mber_phone}</td>
					</tr>
					<tr>
						<th scope="row" class="first">업체명</th>
						<td colspan="3" class="txtL">한국관광공사 관광정보전략팀</td>
					</tr>
					

					<tr>
						<th scope="row" class="first">주소</th>
						<td colspan="3" class="txtL">${memberVO.address1}</td>
					</tr>

				


			</tbody>
		</table>
	</div>


	<h2 class="tit mTl">
		<img src="/resources/include/twb_images/login/h2MemberInfo02.gif" alt="부가정보" />
	</h2>
	

	<div class="btnGroup">
		
	
		<a href="/member/modifyDefault"><img
			src="/resources/include/twb_images/login/btnMemberModify.gif"
			alt="회원정보수정하기" /></a>
		
		<a href="/member/modifyPw"><img
			src="/resources/include/twb_images/login/btnPssswordModify.gif"
			alt="비밀번호 변경" /></a>

	</div>

	<h2 class="tit mTl">
		<img src="/resources/include/twb_images/login/h2MemberInfo03.gif" alt="My스크랩" />
	</h2>
	<div class="tableWrap">
		<table class="basicList" summary="My스크랩 (폴더, 제목, 메모, 스크랩한 날짜)">
			<caption>My스크랩 표</caption>
			<colgroup>
				<col style="width: 12%;" />
				<col />
				<col style="width: 20%;" />
				<col style="width: 15%;" />
			</colgroup>
			<thead>
				<tr>
					<th scope="col" class="first">폴더</th>
					<th scope="col">제목</th>
					<th scope="col">메모</th>
					<th scope="col" class="last">스크랩한 날짜</th>
				</tr>
			</thead>
			<tbody>

				
				
					<tr>
						<td colspan="4">스크랩 정보가 존재하지 않습니다.</td>
					</tr>
				

			</tbody>
		</table>
	</div>
	<h2 class="tit mTl">
		<img src="/resources/include/twb_images/login/h2MemberInfo04.gif" alt="고객마당" />
	</h2>
	<div class="tableWrap">
		<table class="basicList" summary="고객마당 (게시판명, 제목, 등록일)">
			<caption>고객마당 표</caption>
			<colgroup>
				<col style="width: 25%;" />
				<col />
				<col style="width: 15%;" />
				
			</colgroup>
			<thead>
				<tr>
					<th scope="col" class="first">게시판명</th>
					<th scope="col">제목</th>
					<th scope="col" class="last">등록일</th>
					
				</tr>
			</thead>
			<tbody>
	
				
				
					<tr>
						<td colspan="3">게시글이 존재하지 않습니다.</td>
					</tr>
				

			</tbody>
		</table>
	</div>
  
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
