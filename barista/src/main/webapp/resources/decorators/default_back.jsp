<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><sitemesh:write property="title" /></title>
<jsp:include page="../include/common/script.jsp" />
</head>
<body>
<div id="wrap"><!--전체-->

<jsp:include page="../include/common/header.jsp" />

<sitemesh:write property="body" />

<jsp:include page="../include/common/footer.jsp" />

</div>
</body>
</html>