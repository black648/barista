<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
    <!-- subTit -->
	<div class="subTit sub05">
		<h1>공<span>/</span>지<span>/</span>사<span>/</span>항</h1>
	</div>
	<!-- // subTit -->
	<!-- Content -->
	<div class="content">
		<!-- table -->
		<table summary="아이디, 성명, 전화번호, 이메일, 제목, 내용, 공개여부, 파일첨부 항목으로 구성된 게시글 작성표입니다." class="tb03">
			<caption>게시글 작성표</caption>
			<colgroup>
				<col style="width:10%;" />
				<col style="width:40%;" />
				<col style="width:10%;" />
				<col style="width:40%;" />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th scope="row">제목</th>
					<td colspan="3">${boardVO.title}</td>
				</tr>
				<tr>
					<th scope="row">작성자</th>
					<td>${boardVO.upd_nm }</td>
					<th scope ="row">작성일</th>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVO.cre_de }" /></td>
				</tr>
				<tr>
					<th scope="row">첨부파일</th>
					<td colspan="3">
						<span class="fL inBlock attch ico_pdf"><a class="ellipsis" href="#">pdf : span 클래스에 따라 아이콘이 변경됩니다.</a></span>
						<span class="fL inBlock attch ico_img"><a class="ellipsis" href="#">img : span 클래스에 따라 아이콘이 변경됩니다</a></span>
						<span class="fL inBlock attch ico_ppt"><a class="ellipsis" href="#">ppt : span 클래스에 따라 아이콘이 변경됩니다.첨부파일 제목이 길면 글씨가 안보입니다.</a></span>
						<span class="fL inBlock attch ico_etc"><a class="ellipsis" href="#">etc : span 클래스에 따라 아이콘이 변경됩니다.</a></span>
						<span class="fL inBlock attch ico_txt"><a class="ellipsis" href="#">txt : span 클래스에 따라 아이콘이 변경됩니다.</a></span>
					</td>
				</tr>
				<tr>
					<th scope="row">내용</th>
					<td colspan="3">
						<textarea class="autosize" readonly="readonly">${boardVO.content }</textarea>
					</td>
				</tr>
			</tbody>

		</table>
		<!-- // table -->

		<!-- button -->
		<div class="mT20 tR">
			<button type="button" onclick="location.href='list${pageMaker.makeQuery(pageMaker.cri.page)}'" class="btn btn_brown btn_prev2">목록</button>
		</div>
		<!-- // button -->
	</div>
	<!-- // Content -->