<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
    
    
    <script type="text/javascript">
    	function addFile() {
    		var i;
    		var fileInput=document.getElementById('files');
    		var fileData=fileInput.files;
    		
    		
    		
    		for(i=0; i<5; i++) {
    			if(document.getElementById('file['+i+']').value=="") {
    				document.getElementById('file['+i+']').value=fileData;
    				
    				//$("#fileOut").append("<input type='hidden' name='file['"+i+"']' value='"+fileInput+"' />");
    				
    				
    				i++;
    			}
    		}
    		
    	}
		
    	
    	
    	

    	function toSubmit() {
    		if($("#title").val()=='') {
    			alert("제목을 입력하세요.");
    			$("#title").focus();
    			return false;		
    		}
    		if($("#content").val()=='') {
    			alert("내용을 입력하세요.");
    			$("#content").focus();
    			return false;		
    		}
    		if($("#othbcAt1").val()=='' && $("#othbcAt2").val()=='') {
    			alert("공개여부를 선택하세요.");
    			$("#othbcAt1").focus();
    			return false;		
    		}
    		
    		if(checkFileExt()) {
    			alert("111");
    			document.frm.submit();
    		}
    	}
    	
    	
    	function checkFileExt() {
    		var attFileCnt = parseInt($("#attachFileCnt").val()) ;
    		var fileObj;
    		var idx1, len, end;
    		var tmpFileName;
    		var fileName, fileExt;
    		var enableUploadFileExt = new Array("jpg","jpeg","gif","png","txt","hwp","doc","docx","ppt","pptx","xls","xlsx","pdf","zip");
    		if(attFileCnt>0) {
    			for(var i=1; i<attFileCnt; i++) {
    				fileObj=document.getElementById("attachFile"+i);
    				tmpFileName=fileObj.value;
    				idx1= tmpFileName.indexOf(":");
    				len= tmpFileName.lastIndexOf(".");
    				fileName=tmpFileName.substring(0,len);
    				fileExt=tmpFileName.substring(len+1,tmpFileName.length).toLowerCase();
    				var isEnableFile=false;
    				if(tmpFileName!="") {
    					for(var j=0; j<enableUploadFileExt.length; j++) {
    						if(fileExt==enableUploadFileExt[j]) {
    							isEnableFile=true;
    							break;
    						}
    					}
    					if(!isEnableFile) {
    						fileObj.outHTML = "<input type='file' id='attachfile'"+i+"name='attachfile'"+i+"title='파일첨부' />";
    						alert(fileExt+"확장자는 첨부가 불가능한 확장자 파일입니다.");
    						return false;
    					}
    				}
    			}
    		}
    		return true;
    	}

    	$(document).ready(function(){
    		$("#attrAdd").click(function(event) {
    			event.preventDefault();
    			if(document.getElementById("attach2")!=null && document.getElementById("attach2").style.display=="none") {
    				document.getElementById("attach2").style.display="inline-block";
    			}else if(document.getElementById("attach3")!=null && document.getElementById("attach3").style.display=="none") {
    				document.getElementById("attach3").style.display="inline-block";
    			}else {
    				alert("더 이상 추가할 수 없습니다.");
    			}
    			
    		});
    		$("#attrDel").click(function(event) {
    			event.preventDefault();
    			if(document.getElementById("attach3")!=null && document.getElementById("attach3").style.display=="inline-block") {
    				document.getElementById("attach3").style.display="none";
    			}else if(document.getElementById("attach2")!=null && document.getElementById("attach2").style.display=="inline-block") {
    				document.getElementById("attach2").style.display="none";
    			}else {
    				alert("더 이상 삭제할 수 없습니다.");
    			}
    			
    		});
    		
    	});
    	

	
    </script>
    
    <!-- sub 이름 -->	
<div id="sub1_1E	">
	<div class="wrap1">
		<div class="top">
			<div class="name">Q&A</div>
		</div>
	</div>
</div>


<div id="request">
	<div class="wrap1">


<div class="alertInfo pb30">게시내용이 본 게시판과 관련이 없거나 상업적인 내용, 특정인이나 특정사안을 비방하는 내용 등은 예고 없이 삭제될 수 있습니다. </div>


				
	<form name="frm" id="frm" method="post" onsubmit="toSubmit();return false;" enctype="multipart/form-data">	                
		               		

		<input type="hidden" name="division" value="qna" />


		<fieldset>
			<div class="tableWrapGray">
				<table class="commonWrite" summary="상담, 문의 입력( ID, 성명, 전화번호, 이메일은 회원가입시 등록한 데이터가 나오는 부분 /분류, 제목, 내용, 공개여부, 부가서비스선택, 파일첨부 선택 및 입력)">
				<caption>상담, 문의 입력</caption>
				<colgroup>
					<col style="width:20%;" />
					<col />
					<col style="width:20%;" />
					<col />
				</colgroup>
				<tbody>
					<tr class="line">
						<th id="idcolumn" class="first">ID</th>
						<td headers="idcolumn"><input type="text" name="mber_id" value="${memberVO.mber_id }" readOnly /></td>
						<th id="namecolumn">성명</th>
						<td headers="namecolumn" class="last"><input type="text" name="mber_name" value="${memberVO.mber_name }" readOnly /></td>
					</tr>
					<tr>
						<th id="phonecolumn" class="first">전화번호</th>
						<td headers="phonecolumn"><input type="text" name="mber_phone" value="${memberVO.mber_phone }" readOnly /></td>
						<th id="emailcolumn">이메일</th>
						<td headers="emailcolumn" class="last"><input type="text" name="email" value="${memberVO.email }" readOnly /></td>
					</tr>
					<!-- tr>
						<th scope="row" class="first"><strong class="fontBrown">*</strong> <label for="largeCode">분류</label></th>
						<td colspan="3">
							<select id="middleCode" name="middle_code" onchange="loadLowSelect(); return false;"  title="카테고리 분류1번째 선택">
								<option value=""></option>
							</select><span id="blankIn2"> </span>
							<select id="row_code" name="row_code" style="width:215px" title="카테고리 분류 2번째 선택">
								<option value=""></option>
							</select>
							<div class="mTxxs fontSmall fontGray">카테고리 분류는 관리자에 의해 변경될 수 있습니다</div>
						</td>
					</tr -->
					<tr>
						<th scope="row" class="first"><strong class="fontBrown">*</strong> <label for="title">제목</label></th>
						<td colspan="3">
							                <input type="text" id="title" name="title" value="" size="60" style="width:530px;"/> 						</td>
					</tr>
					<tr>
						<th scope="row" class="first"><strong class="fontBrown">*</strong> <label for="content">내용</label></th>
						<td colspan="3">
							                <textarea id="content" name="content" rows="10" cols="60"  style="width:530px;" onkeydown="calculateByteCount();fc_chk_byte(this,3000);"></textarea>
							<div class="txtR mTxxs"><strong class="fontBrown"><span id="byteCount">0</span></strong> 자/ 3000 자</div>
						</td>
					</tr>
					<tr>
						<th scope="row" class="first"><strong class="fontBrown">*</strong> 공개여부</th>
						<td colspan="3">
							<input type="radio" name="off_at" id="othbcAt1"   value="Y" /> <label for="othbcAt1">공개</label>
							<input type="radio" name="off_at" id="othbcAt2"  value="N" /> <label for="othbcAt2">비공개</label>
							<ul class="mTxs dotList">
								<li>공개로 설정하셔도 작성자의 개인 정보는 공개되지 않습니다.</li>
								<li>비공개로 설정하시면 관리자에게만 게시 글이 공개됩니다.</li>
								<li>관리자의 판단으로 공개가 적합하지 않을 경우 공개를 비공개로 바꿀 수 있습니다.</li>
							</ul>
						</td>
					</tr>

					<tr>
						<th scope="row" class="first">파일첨부</th>
						<td colspan="3">
						<ul class="dotList mTs">
							<li>파일 첨부 시 전체 용량은 최대 4 M 를 넘을 수 없습니다.</li>
							<li>첨부파일은 jpg,jpeg,gif,hwp,doc,xls,ppt,docx,xlsx,pdf,zip,arz,txt 확장자만 첨부가능합니다.</li>
						</ul>
							<!-- <input type="file" id="files" name="files" title="파일찾기" /> <input type="button" onclick="javascript:addFile()"> 
							 -->
							 
						<input type="hidden" name="attachFileCnt" id="attachFileCnt" value="0" />
						<div style="margin:5px 0px;">
							<button style="margin-right:5px;" id="attrAdd" type="button">+첨부파일추가</button><button id="attrDel" type="button">-첨부파일삭제</button><br />
						</div>
						<span id="attach1">						<input type="file" id="attachFile1" name="attachFile1" title="파일찾기" /></span> <br />
						<span id="attach2" style="display:none"><input type="file" id="attachFile2" name="attachFile2" title="파일찾기" /></span> <br />
						<span id="attach3" style="display:none"><input type="file" id="attachFile3" name="attachFile3" title="파일찾기" /></span>
						
						</td>
					</tr>
				</tbody>
				</table>
			</div>
			
			<div class="boxBottomLine">
				<p class="bulDotBigBrown"><strong>다음과 같은 경우 예고 없이 글이 삭제되거나 회신하지 않을 수 있습니다.</strong></p>
				<ul class="dotList">
					<li>자료 등록 시 글쓴이의 개인정보가 입력되지 않거나 허위로 기재된 경우</li>
					<li>저속한 표현, 타인의 명예훼손, 불건전한 내용, 중복등록, 광고성 내용, 특성사안에 대한 동참 선동의 경우</li>
					<li>학교 리포트용 질의나 자료요구의 경우</li>
					<li>한 사람이 3회 이상 동일 유사한 의견을 등록하는 행위</li>
					<li>특정사안에 대한 공식적인 답변에도 불구하고 이를 계속해서 문제로 삼거나, 품위를 손상시키는 지나친 내용</li>
				</ul>
			</div>

			<div class="btnGroupC">
				<input type="image" alt="저장" src="http://tong.visitkorea.or.kr/ktobiz/images/common/btn/btnSaveBig.gif" />
									<a href="#cancel" onclick="location.href='/kor/customer/involvement/qna/qna/list.kto?'"><img src="http://tong.visitkorea.or.kr/ktobiz/images/common/btn/btnCancelBig.gif" alt="취소"/></a>
			</div>
			
		</fieldset>
	</form>


			
		</div>
</div>