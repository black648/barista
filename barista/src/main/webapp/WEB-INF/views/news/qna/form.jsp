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
    			if(document.getElementById("attachFile2")!=null && document.getElementById("attachFile2").style.display=="none") {
    				document.getElementById("attachFile2").style.display="inline-block";
    			}else if(document.getElementById("attachFile3")!=null && document.getElementById("attachFile3").style.display=="none") {
    				document.getElementById("attachFile3").style.display="inline-block";
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
    
    
    
    
   <!-- Content -->
	<div class="content">
		<p class="notice_tit">게시내용이 본 게시판과 관련이 없거나 <span class="Orange">상업적인 내용, 특정인이나 특정사안을 비방하는 내용</span> 등은 예고 없이 삭제될 수 있습니다.</p>
		<p class="tR f12 mT40 mB10">(<span class="Orange Bold">*</span> 표시는 필수 입력사항입니다.)</p>
		<form name="frm" id="frm" method="post" onsubmit="toSubmit();return false;" enctype="multipart/form-data">	
		<input type="hidden" name="division" value="qna" />   
		<!-- table -->
		<table summary="아이디, 성명, 전화번호, 이메일, 제목, 내용, 공개여부, 파일첨부 항목으로 구성된 게시글 작성표입니다." class="tb03">
			<caption>게시글 작성표</caption>
			<colgroup>
				<col style="width:10%;" />
				<col style="width:40%;" />
				<col style="width:10%;" />
				<col style="width:40%;" />
			</colgroup>
			<tbody>
				<tr>
					<th scope="row">아이디</th>
					<td><input type="text" name="mber_id" style="width:210px;" value="${memberVO.mber_id }" readOnly /></td>
					<th scope="row">성명</th>
					<td><input type="text" name="mber_name" style="width:210px;" value="${memberVO.mber_name }" readOnly /></td>
				</tr>
				<tr>
					<th scope="row">전화번호</th>
					<td>
						<input type="text" name="mber_phone" style="width:210px;" value="${memberVO.mber_phone }" readOnly />
					</td>
					<th scope="row">E-mail</th>
					<td>
					<input type="text" name="email" style="width:210px;" value="${memberVO.email }" readOnly />
					</td>
				</tr>
				<tr>
					<th scope="row" class="must">제목</th>
					<td colspan="3"><input type="text" id="title" name="title" value="" class="full" /> </td>
					
				</tr>
				<tr>
					<th scope="row" class="must">내용</th>
					<td colspan="3">
						<textarea id="content" name="content" rows="10" cols="60" class="autosize"  onkeydown="calculateByteCount();fc_chk_byte(this,3000);"></textarea>
						<div><strong class="fontBrown"><span id="byteCount">0</span></strong> 자/ 3000 자</div>
					</td>
				</tr>
				<tr>
					<th scope="row" class="must">공개여부</th>
					<td>
						<input type="radio" name="off_at" id="othbcAt1"   value="Y" />
						<label for="othbcAt1" class="mR20">공개</label> 
						<input type="radio"  name="off_at" id="othbcAt2"  value="N" />
						<label for="othbcAt2">비공개</label> 
					</td>
					<td colspan="2" class="pL0">
						<ul>
							<li class="bu04">공개로 설정하셔도 작성자의 개인 정보는 공개되지 않습니다.</li>
							<li class="bu04">비공개로 설정하시면 관리자에게만 게시글이 공개됩니다.</li>
							<li class="bu04">관리자의 판단으로 공개가 적합하지 않을 경우 공개를 비공개로 바꿀 수 있습니다.</li>
						</ul>
					</td>
				</tr>
				<tr>
					<th scope="row">파일첨부</th>
					<td colspan="3">
						파일 첨부 시 <strong>전체 용량은 최대 4MB를 넘을 수 없습니다.</strong><br/>첨부파일은 jpg, jpeg, gif, hwp, doc, xls, ppt, docx, xlsx, pdf, zip, arz, txt 확장자만 첨부 가능합니다.<br/>
						<div class="filebox mT10 full clearfix">
							<label for="files">파일</label>
							<input type="file" id="attachFile1" name="attachFile1" title="파일찾기"  style="width:calc(100% - 40px);" /><br />
							<input type="file" id="attachFile2" name="attachFile2" title="파일찾기" style="width:calc(100% - 40px); display:none;" /> <br />
							<input type="file" id="attachFile3" name="attachFile3" title="파일찾기" style="width:calc(100% - 40px); display:none; margin-left:40px;" />
							
						</div>

						<!-- button -->
						<div class="mT5 pL40">
							<button class="btn btn_gold btn_attAdd mR10" id="attrAdd" type="button">첨부파일 추가</button>
							<button class="btn btn_gold btn_attDel" id="attrDel" type="button">첨부파일 삭제</button>
						</div>
						<!-- // button -->
					</td>
				</tr>
			</tbody>

		</table>
		<!-- // table -->
		
		<div class="notice_txt clearfix">
			<img src="/resources/include/images/05_notice/bg_notice.png" alt="확성기 이미지" />

			<div>
				<h4 class="bu02 tit">다음과 같은 경우 예고없이 글이 삭제되거나 회신하지 않을 수 있습니다.</h4>
				<ul>
					<li class="bu04">자료 등록 시 글쓴이의 개인정보가 입력되지 않거나 허위로 기재된 경우</li>
					<li class="bu04">저속한 표현, 타인의 명예훼손, 불건전한 내용, 중복등록, 광고성 내용, 특정사안에 대한 동참 선동의 경우</li>
					<li class="bu04">학교 레포트 용 질의나 자료요구의 경우</li>
					<li class="bu04">한 사람이 3회 이상 동일 또는 유사한 의견을 등록하는 행위</li>
					<li class="bu04">특정사안에 대한 공식적인 답변에도 불구하고 이를 계속해서 문제로 삼거나, 품위를 손상시키는 지나친 내용</li>
				</ul>
			</div>
		</div>
		<!-- button -->
		<div class="mT20 tC full">
			<button type="submit" class="btn btn_brown btn_save mR10">저장</button>
			<button type="button" onclick="location.href='/news/qna/list'" class="btn btn_grey btn_cancel">취소</button>
		</div>
		<!-- // button -->
		</form>
	</div>
	<!-- // Content --> 
    
    
    
    
    
    