<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
    <!-- sub 이름 -->	
<div id="sub1_1">
	<div class="wrap1">
		<div class="top">
			<div class="name">공지사항</div>
		</div>
	</div>
</div>


<div id="request">
	<div class="wrap1">
	<form action="">
<div class="tableWrapGray">


  	<div class="tableWrap">
		<div class="basicView">
			<p class="date" title="등록 및 수정 날짜"></p>
			<p class="tit" title="제목">${boardVO.title}</p>
			
			<div class="customer" title="담당자정보">
				<span >구분</span> ${boardVO.dept }
				<span >등록자</span> ${boardVO.upd_nm }
				<span >등록일</span> <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVO.cre_de }" />
			</div>
										
			<div class="cont" title="내용">
				<pre>${boardVO.content }</pre>
			</div>
			<div class="addFile" title="첨부파일">
													<a href="/viewer/view.kto?id=49856&amp;type=bd" target="_blank"><img alt="첨부1_내장산리조트_용지분양(입주신청)_공고문(온비드입찰) 새창으로 바로보기" src="http://tong.visitkorea.or.kr/ktobiz/images/common/ico/viewicon.gif"/></a>
									<a href="/file/download/bd/0ad8c703-0244-11e7-852d-a1b2f17307b5.pdf.kto"><img src="http://tong.visitkorea.or.kr/ktobiz/images/common/ico/icoAddFile.gif" alt="첨부파일" /> 첨부1_내장산리조트_용지분양(입주신청)_공고문(온비드입찰).pdf</a><br/>
													<a href="/viewer/view.kto?id=49857&amp;type=bd" target="_blank"><img alt="첨부1_내장산리조트관광지입주신청유의서_온비드입찰 새창으로 바로보기" src="http://tong.visitkorea.or.kr/ktobiz/images/common/ico/viewicon.gif"/></a>
									<a href="/file/download/bd/0aeb3d94-0244-11e7-852d-a1b2f17307b5.pdf.kto"><img src="http://tong.visitkorea.or.kr/ktobiz/images/common/ico/icoAddFile.gif" alt="첨부파일" /> 첨부1_내장산리조트관광지입주신청유의서_온비드입찰.pdf</a><br/>
													<a href="/viewer/view.kto?id=49858&amp;type=bd" target="_blank"><img alt="첨부2_내장산리조트관광지입주신청유의서_중대형부지 새창으로 바로보기" src="http://tong.visitkorea.or.kr/ktobiz/images/common/ico/viewicon.gif"/></a>
									<a href="/file/download/bd/0af305c5-0244-11e7-852d-a1b2f17307b5.pdf.kto"><img src="http://tong.visitkorea.or.kr/ktobiz/images/common/ico/icoAddFile.gif" alt="첨부파일" /> 첨부2_내장산리조트관광지입주신청유의서_중대형부지.pdf</a><br/>
													<a href="/viewer/view.kto?id=49859&amp;type=bd" target="_blank"><img alt="첨부2_내장산리조트용지분양(입주신청)공고문중대형부지 새창으로 바로보기" src="http://tong.visitkorea.or.kr/ktobiz/images/common/ico/viewicon.gif"/></a>
									<a href="/file/download/bd/0afc7ba6-0244-11e7-852d-a1b2f17307b5.pdf.kto"><img src="http://tong.visitkorea.or.kr/ktobiz/images/common/ico/icoAddFile.gif" alt="첨부파일" /> 첨부2_내장산리조트용지분양(입주신청)공고문중대형부지.pdf</a><br/>
			</div>
		</div>
	</div>




</div>
<div class="btnGroup">
				<a href="list${pageMaker.makeQuery(pageMaker.cri.page)}"><img src="/resources/include/twb_images/btn/btnList.gif" alt="목록" /></a>
	</div>
</form>

</div></div>