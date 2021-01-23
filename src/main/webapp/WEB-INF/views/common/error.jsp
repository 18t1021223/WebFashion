<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <!-- Favicon
		============================================ -->
<link rel="shortcut icon" type="image/x-icon"
	href="<c:url value='/assets/user/img/favicon.png'/>">
	
<title>Lỗi</title>

<!-- Google font -->
<link href="https://fonts.googleapis.com/css?family=Montserrat:500"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Titillium+Web:700,900"
	rel="stylesheet">

<!-- Custom stlylesheet -->
<link type="text/css" rel="stylesheet" href="<c:url value='/assets/css/style.css'/>" />

</head>
<body>

	<div id="notfound">
		<div class="notfound">
			<div class="notfound-404">
				<c:if test="${error.status ==null }">
					<h1>405</h1>
				</c:if>
				<c:if test="${error.status >0 }">
					<h1>${error.status }</h1>
				</c:if>
			</div>
			<h2>Oops! This Page Could Not Be Found</h2>
			<p>Sorry but the page you are looking for does not exist, have
				been removed. name changed or is temporarily unavailable</p>
			<a href="<c:url value="/home"/>">Go To Homepage</a>
		</div>
	</div>

</body>
</html>
