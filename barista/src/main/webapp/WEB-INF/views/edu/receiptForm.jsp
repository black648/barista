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
	<fmt:parseDate value='${masterVO.edu_bgnde}' var='edu_bgnde' pattern='yyyymmdd'/>	
	<fmt:parseDate value='${masterVO.edu_endde}' var='edu_endde' pattern='yyyymmdd'/>	
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

		if(frm.agree1.checked==false) {
			alert("개인정보 수집동의를 동의해주세요.");
			$("#cont1").show();
			frm.agree1.focus();
			return;
		}
		if(frm.agree2.checked==false) {
			alert("개인정보 활용동의를 동의해주세요.");
			$("#cont2").show();
			frm.agree2.focus();
			return;
		}
		if(frm.mber_engname.value=='') {
			alert("영문이름을 입력하세요");
			frm.mber_engname.focus();
			return;
		}
		if(frm.address1.value=='') {
			alert("주소를 입력하세요");
			frm.address1.focus();
			return;
		}
		
		frm.submit();
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

<!-- subTit -->
	<div class="subTit sub03">
		<h1>교<span>/</span>육<span>/</span>신<span>/</span>청</h1>
	</div>
	<!-- // subTit -->
	<!-- Content -->
	<div class="content">
	<form id="frm" name="frm" method="post"  onsubmit="toSubmit(); return false;" enctype="multipart/form-data">
		<input type="hidden" name="edu_sn" value="${masterVO.edu_sn }" />
		<input type="hidden" name="apc_sn" value="${applicantVO.apc_sn }" />
		<input type="hidden" name="gunmul" value="${applicantVO.gunmul }" />
		<input type="hidden" name="photoYN" id="photoYN" value="" />
		<input type="hidden" name="attachVO" value="${attachVO } " />
		<!-- 개인정보 수집동의 -->
		<div class="stu_list">
			<ul class="clearfix">
				<li>개인정보 수집동의</li>
			</ul>
			<div class="cont" id="cont1">
				<textarea readonly="readonly">제 1 장 총 칙

제 1 조 (목적)

본 약관은 바리스타 홈페이지 이용과 관련하여 이용자의 권리, 의무 및 책임사항 그리고 기타 필요한 사항을 규정하는 것을 목적으로 합니다.

제 2 조 (약관의 효력 및 변경)

약관의 내용은 서비스 화면에 게시하고 이용자가 동의함으로써 효력이 발생합니다. 검정단은 합리적인 사유가 발생될 경우에는 이 약관을 변경할 수 있으며, 약관이 변경되는 경우에는 최소한 7일전에 공지합니다. 또한 새로운 서비스가 개설될 경우, 별도의 명시된 설명이 없는 한 이 약관에 따라 제공됩니다.

① 본 약관은 검정원이 서비스 화면을 통해 게시하고 이용자가 이에 동의함으로써 효력을 발생합니다.

① 본 약관은 검정원이 서비스 화면을 통해 게시하고 이용자가 이에 동의함으로써 효력을 발생합니다.
				</textarea>
				<div class="tR mT10">
					<input type="checkbox" name="agree1" id="agree1" value="Y">
					<label for="agree1">약관을 읽고 동의합니다.</label>
				</div>
			</div>
		</div>
		<!-- // 개인정보 수집동의 -->
		<!-- 개인정보 활용동의 -->
		<div class="stu_list">
			<ul class="clearfix">
				<li>개인정보 활용동의</li>
			</ul>
			<div class="cont" id="cont2">
				<textarea readonly="readonly">제 1 장 총 칙

제 1 조 (목적)

본 약관은 바리스타 홈페이지 이용과 관련하여 이용자의 권리, 의무 및 책임사항 그리고 기타 필요한 사항을 규정하는 것을 목적으로 합니다.

제 2 조 (약관의 효력 및 변경)

약관의 내용은 서비스 화면에 게시하고 이용자가 동의함으로써 효력이 발생합니다. 검정단은 합리적인 사유가 발생될 경우에는 이 약관을 변경할 수 있으며, 약관이 변경되는 경우에는 최소한 7일전에 공지합니다. 또한 새로운 서비스가 개설될 경우, 별도의 명시된 설명이 없는 한 이 약관에 따라 제공됩니다.

① 본 약관은 검정원이 서비스 화면을 통해 게시하고 이용자가 이에 동의함으로써 효력을 발생합니다.

① 본 약관은 검정원이 서비스 화면을 통해 게시하고 이용자가 이에 동의함으로써 효력을 발생합니다.
				</textarea>
				<div class="tR mT10">
					<input type="checkbox" name="agree2" id="agree2" value="Y">
					<label for="agree1">약관을 읽고 동의합니다.</label>
				</div>
			</div>
		</div>
		<!-- // 개인정보 활용동의 -->
		
		<div class="stu_txt">
			<dl>	
				<dt class="bu02">교육명 : </dt>
				<dd>${masterVO.title}</dd>

				<dt class="bu02">접수기간 : </dt>
				<dd><fmt:formatDate value="${bgnde}" pattern="yyyy-MM-dd HH:mm"/> ~ <fmt:formatDate value="${endde}" pattern="yyyy-MM-dd HH:mm"/></dd>
			</dl>
		</div>
		<div class="stu_txt">
			<dl>	
				<dt class="bu02">교육일정 : </dt>
				<dd><fmt:formatDate value="${edu_bgnde}" pattern="yyyy-MM-dd"/> ~ <fmt:formatDate value="${edu_endde}" pattern="yyyy-MM-dd"/></dd>

				<dt class="bu02">접수번호 : </dt>
				<dd class="Orange">${applicantVO.apc_id}</dd>
			</dl>
		</div>

		<!-- 교육신청 -->
		<div class="clearfix">
			<h4 class="bu05 tit pB10">교육신청</h4>
			
			<div class="apply mT0">
				<div class="img_wrap">
					<img id="img">
				</div>
				
					<table summary="제목, 성명, 연락처, 성별, 생년월일, e-mail, 사진등록 항목으로 구성된 입사지원서 표입니다." class="tb03">
					<caption>입사지원서</caption>
					<colgroup>
						<col style="width:15%;">
						<col style="width:35%;">
						<col style="width:15%;">
						<col style="width:35%;">
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">성명</th>
							<td>
							<input type="hidden" title="이름" name="mber_name" id="mber_name" value="${memberVO.mber_name }" class="full">${memberVO.mber_name }</td>
							<th scope="row">영문명</th>
							<td>
								<input class="input2" type="text" title="영문이름" value="${applicantVO.mber_engname}" name="mber_engname"  id="mber_engname" class="full">
							</td>
						</tr>
						<tr>
							<th scope="row">연락처</th>
							<td colspan="3">
								<input type="hidden" title="연락처" name="mber_phone" id="mber_phone" value="${memberVO.mber_phone }" />
								${memberVO.mber_phone }					
							</td>
						</tr>
						<tr>
							<th scope="row" rowspan="2">주소</th>
							<td colspan="3" class="noBorder" style="padding-bottom:0;">
								<input type="text" title="주소" id="address1" name="address1" value="${applicantVO.address1 }" />
								<button class="btn btn_grey">우편번호 찾기</button>
							</td>
						</tr>
						<tr>
							<td colspan="3">
								<input type="text" title="상세주소" id="address2" name="address2" placeholder="상세주소를 입력하세요." value="${applicantVO.address1 }" class="full" />
							</td>
						</tr>
						<tr>
							<th scope="row">E-mail</th>
							<td colspan="3">
								<input class="input2" type="hidden" title="이메일1" id="email" name="email" value="${memberVO.email }" class="full">
								${memberVO.email }
							</td>
						</tr>
						<tr>
							<th scope="row">사진등록</th>
							<td colspan="3">
								이미지 파일 확장자(<strong>jpg, jpeg, png, gif</strong>)만 첨부 가능합니다.<br>
								<div class="filebox mT10 full clearfix">
									<label for="photo">파일</label>
									<input type="file" title="사진등록" id="photo" name="photo" style="width:calc(100% - 40px);">
								</div>				
							</td>
						</tr>
					</tbody>
				</table>
				</div>
			</div>
			<!-- // 교육신청 -->
			<!-- button -->
			<div class="mT40 tR">
				<button type="button" class="btn btn_grey btn_list mR10">목록보기</button>
				<button type="submit" class="btn btn_brown btn_check">접수하기</button>
			</div>
			<!-- //button -->
			</form>
	</div>	