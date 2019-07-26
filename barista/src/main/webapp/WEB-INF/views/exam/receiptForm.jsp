<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	    var orgEmail1="";
	    $("#email2").on("change", function() { 
	    	//이부분 현재 에러로 확인 필요함.
	    	orgEmail1=$("#email1").val().split("@");
	    	if($("#email2").val()!=""){ 
	    	    $("#email1").val(orgEmail1[0]+$("#email2").val());
	    	}
	
	    });
    });

    
    
    
    function toSubmit() {
		
		var frm = document.frm;

		
		if(frm.mber_engname.value=='') {
			alert("영문이름을 입력하세요");
			frm.mber_engname.focus();
			return;
		}
		if(frm.exam_place_code.value=='') {
			alert("시험장소를 선택하세요");
			frm.exam_place_code.focus();
			return;
		}
		
		if(frm.year.value=='') {
			alert("생년월일을 선택하세요");
			frm.year.focus();
			return;
		}
		if(frm.month.value=='') {
			alert("생년월일을 선택하세요");
			frm.month.focus();
			return;
		}
		if(frm.date.value=='') {
			alert("생년월일을 선택하세요");
			frm.date.focus();
			return;
		}
		if(frm.address1.value=='') {
			alert("주소를 입력하세요");
			frm.address1.focus();
			return;
		}
		//수정의 경우 첨부파일을 체크하지 않도록.
		if(frm.attachVO.value!='' && document.getElementById("photo").value=="" ) {
			$("#photoYN").val("N");
				document.frm.submit();
		}else {
			if(checkFileExt()) {
				$("#photoYN").val("Y");
				document.frm.submit();
			}
		}
		
    }
		
		function checkFileExt() {
    		var fileObj;
    		var idx1, len, end;
    		var tmpFileName;
    		var fileName, fileExt;
    		var enableUploadFileExt = new Array("jpg","jpeg","gif","png");
    				fileObj=document.getElementById("photo");
    				tmpFileName=fileObj.value;
    				if(tmpFileName=="") {
    					alert("사진을 등록해주세요.");	
    					return false;
    				}
    				idx1= tmpFileName.indexOf(":");
    				len= tmpFileName.lastIndexOf(".");
    				fileName=tmpFileName.substring(0,len);
    				fileExt=tmpFileName.substring(len+1,tmpFileName.length).toLowerCase();
    				var isEnableFile=false;
    				if(document.getElementById('photo').files[0].size > 5000000){
    					alert("5MB 이상의 사진은 업로드 할 수 없습니다.");
    					return;  
					}



    				
    				if(tmpFileName!="") {
    				
    					for(var j=0; j<enableUploadFileExt.length; j++) {
    						if(fileExt==enableUploadFileExt[j]) {
    							
    							isEnableFile=true;
    							break;
    						}
    					}
    					if(!isEnableFile) {
    						fileObj.outHTML = "<input type='file' id='photo' name='photo' title='파일첨부' />";
    						alert(fileExt+"확장자는 첨부가 불가능한 확장자 파일입니다.");
    						return false;
    					}
    				}
    		return true;
			}

		
	</script>
    
    <!-- sub 이름 -->	
<div id="sub1_1">
	<div class="wrap1">
		<div class="top">
			<div class="name">시험접수</div>
		</div>
	</div>
</div>

<div id="request">
	<div class="wrap1">
		<form id="frm" name="frm" method="post" onsubmit="toSubmit();return false;" enctype="multipart/form-data">
			<input type="hidden" name="exam_sn" value="${examApplicantVO.exam_sn }" />
			<input type="hidden" name="apc_sn" value="${examApplicantVO.apc_sn }" />
			<input type="hidden" name="gunmul" value="${examApplicantVO.gunmul }" />
			<input type="hidden" name="grade" value="${examApplicantVO.grade }" />
			<input type="hidden" name="photoYN" id="photoYN" value="" />
			<input type="hidden" name="division" value="exam" />
			<input type="hidden" name="attachVO" value="${attachVO } " />
			<div class="row_table">
			<table width="100%" cellpadding="0" cellspacing="0" border="0" summary="검정신청">
				<caption>검정신청</caption>
				<colgroup>
				<col width="22%">
				<col width="28%">
				<col width="22%">
				<col width="28%">
				</colgroup>
				<tr>
					<th ><label for="mane">이름</label></th>
					<td><input type="hidden" title="이름" name="mber_name" id="mber_name" value="${memberVO.mber_name }" />
					${memberVO.mber_name }
					</td>
					<th ><label for="eng_mane">영문이름</label></th>
					<td ><input class="input2" type="text" title="영문이름" value="${examApplicantVO.mber_engname}" name="mber_engname"  id="mber_engname"></td>
					
				</tr>
				<tr>
					<th>검정명</th>
					<td colspan="3">

						${masterVO.title}</option>
					</td>
				</tr>
				<tr>
					<th >접수기간</th><td  colspan="3"><fmt:formatDate value="${bgnde}" pattern="yyyy-MM-dd HH:mm"/> ~ <fmt:formatDate value="${endde}" pattern="yyyy-MM-dd HH:mm"/>  </td>
				</tr>
				<tr>
					<th >검정일</th><td  colspan="3"><fmt:formatDate value="${examde}" pattern="yyyy-mm-dd"/>  </td>
				</tr>
				<tr>
					<!-- 20181018 개선해야할 부분
						 1.공통코드 테이블 생성. 
						 2.공통코드 테이블에 시험지역, 시험장소 부분을 코드로 등록
						 3.현재 페이지를 호출하는 컨트롤러에 시험장소 코드를 조회하여 데이터를 넘겨줘야할 필요가 있음.(exam_master 테이블에 컬럼추가 할 필요는 없음)
					 -->
					<th >시험장소</th>
					<td  colspan="3">
					<select class="input3" name="exam_place_code">
					<option value="">시험장소를 선택하세요.</option>
					<c:forEach items="${codeList }" var="codeList">
						<option value="${codeList.cd }" 
						<c:if test="${codeList.cd eq examApplicantVO.exam_place_code }"> selected="selected"</c:if>
						>${codeList.cd_nm } (${codeList.cd_dscr })</option>
					</c:forEach>
					</select>
					</td>
				</tr>
				
				<tr>
				<th >
		
				
				
				<label for="year">생년월일</label></th>
				<td  colspan="3">
				<select name="year" id="year">
				<option value="">선택하세요.</option>
				<!-- forEach 역순출력이 안됌...ex) 100 ->50 -->
				<c:forEach var="cnt" begin="0" end="60" varStatus="status">
					<c:set var="year" value="${yyyy - cnt}" />
					<option value="${year }" <c:if test="${year eq examApplicantVO.year}" >selected="selected"</c:if>>${year }</option> 
				</c:forEach>
				
				
				</select>
				<select name="month">
				<option value="">선택하세요.</option>
				<c:forEach var="cnt" begin="1" end="12" varStatus="status">
					<c:if test="${cnt lt 10 }">
						<c:set var="cnt" value="0${cnt}" />
					</c:if>
					<option value="${cnt }" <c:if test="${cnt eq examApplicantVO.month}" >selected="selected"</c:if>>${cnt }</option> 
				</c:forEach>
				</select>
				<select name="date">
				<option value="">선택하세요.</option>
				<c:forEach var="cnt" begin="1" end="31" varStatus="status">
					<c:if test="${cnt lt 10 }">
						<c:set var="cnt" value="0${cnt}" />
					</c:if>
					<option value="${cnt }" <c:if test="${cnt eq examApplicantVO.month}" >selected="selected"</c:if>>${cnt }</option> 
				</c:forEach>
				</select>
				</td>
				</tr>
	
				<tr>
					<th >전화번호</th>
					<td  colspan="3">
				<input type="hidden" title="이름" name="mber_phone" id="mber_phone" value="${memberVO.mber_phone }" />
					${memberVO.mber_phone }
				</td>
				</tr>
				
				
				
				<tr>
					<th><label for="email">이메일</label></th>
					<td colspan="3">
						<input class="input2" type="hidden" title="이메일1" id="email" name="email" value="${memberVO.email }">
						${memberVO.email }
					</td>
				</tr>
				
				<tr>
					<th><label for="address">주소</label></th><td  colspan="3"><input class="input3" type="text" title="주소" id="address1" name="address1" value="${examApplicantVO.address1 }" /></td>
				</tr>
				
				
				<tr>
					<th><label for="photo">사진등록</label></th><td  colspan="3"><input class="input3" type="file" title="사진등록" id="photo" name="photo" /><br />
						${attachVO.orgfilename }
					</td>
				</tr>
				
	
	
	
			</table>
			</div>
			<div class="button">
				<input type="image" alt="확인" src="../resources/include/twb_images/sub_images/sub1_3_on.jpg" title="확인" />
				<img src="/resources/include/twb_images/sub_images/sub1_3_off.jpg" alt="취소" />
			
			</div>
		</form>
	</div>
</div>