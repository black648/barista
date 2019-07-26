<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    

    <script>
    //이부분 수정중
    function fileDown(file_mask_name,path) {
    	
    	//var file_mask_name=$("#file_mask_name").val();
    	//var path=$("#path").val();
    	alert(file_mask_name);
    	alert(path);
    	location.href='../displayFile&'+file_mask_name+'&path='+path;
    }
    </script>
    <!-- sub 이름 -->	
<div id="sub1_1">
	<div class="wrap1">
		<div class="top">
			<div class="name">Q&A</div>
		</div>
	</div>
</div>


<div id="request">
	<div class="wrap1">
	<form action="" name="frm">
	<input type="hidden" id="file_mask_name" value="${qnaAttachVO.file_mask_name} " />
	<input type="hidden" id="path" value="${qnaAttachVO.path} " />
<div class="tableWrapGray">


  	<div class="tableWrap">
		<div class="basicView">
			<p class="date" title="등록 및 수정 날짜"></p>
			<p class="tit" title="제목">${qnaVO.title}</p>
			
			<div class="customer" title="글쓴이">
				<span >등록자</span> ${qnaVO.mber_name }
				<span >등록일</span> <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${qnaVO.cre_de }" />
			</div>
										
			<div class="cont" title="내용">
				<pre>${qnaVO.content }</pre>
			</div>
			<div class="addFile" title="첨부파일">

									
									<c:forEach var="attachVO" items="${list }">
									
									<!-- <a href='../downFile?path=${attachVO.dirpath}&file_mask_name=${attachVO.savedfilename}&file_name=${attachVO.orgfilename}' target="_blank">
									 -->	
  									<a href='../downFile${attachVO.makeFile()}' target="_blank"> 
										<img alt="${attachVO.orgfilename} " src="http://tong.visitkorea.or.kr/ktobiz/images/common/ico/viewicon.gif"/>
											${attachVO.orgfilename}
									</a>
							
									</c:forEach>
			</div>
		</div>
	</div>




</div>
<div class="btnGroup">
				<a href="list${pageMaker.makeQuery(pageMaker.cri.page)}"><img src="/resources/include/twb_images/btn/btnList.gif" alt="목록" /></a>
	</div>
</form>

</div></div>