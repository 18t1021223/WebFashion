<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Favicon
		============================================ -->
<link rel="shortcut icon" type="image/x-icon"
	href="<c:url value='/assets/user/img/favicon.png'/>">

<!-- FONTS
		============================================ -->
<link href='http://fonts.googleapis.com/css?family=Oswald:400,700'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Bitter:400,700,400italic&amp;subset=latin,latin-ext'
	rel='stylesheet' type='text/css'>

<!-- animate CSS
		============================================ -->
<link rel="stylesheet" href="<c:url value='/assets/user/css/animate.css'/>">

<!-- FANCYBOX CSS
		============================================ -->
<link rel="stylesheet"
	href="<c:url value='/assets/user/css/jquery.fancybox.css'/>">

<!-- BXSLIDER CSS
		============================================ -->
<link rel="stylesheet"
	href="<c:url value='/assets/user/css/jquery.bxslider.css'/>">

<!-- MEANMENU CSS
		============================================ -->
<link rel="stylesheet"
	href="<c:url value='/assets/user/css/meanmenu.min.css'/>">

<!-- JQUERY-UI-SLIDER CSS
		============================================ -->
<link rel="stylesheet"
	href="<c:url value='/assets/user/css/jquery-ui-slider.css'/>">

<!-- NIVO SLIDER CSS
		============================================ -->
<link rel="stylesheet"
	href="<c:url value='/assets/user/css/nivo-slider.css'/>">

<!-- OWL CAROUSEL CSS 	
		============================================ -->
<link rel="stylesheet"
	href="<c:url value='/assets/user/css/owl.carousel.css'/>">

<!-- OWL CAROUSEL THEME CSS 	
		============================================ -->
<link rel="stylesheet" href="<c:url value='/assets/user/css/owl.theme.css'/>">

<!-- BOOTSTRAP CSS 
		============================================ -->
<link rel="stylesheet"
	href="<c:url value='/assets/user/css/bootstrap.min.css'/>">

<!-- FONT AWESOME CSS 
		============================================ -->
<link rel="stylesheet"
	href="<c:url value='/assets/user/css/font-awesome.min.css'/>">

<!-- NORMALIZE CSS 
		============================================ -->
<link rel="stylesheet" href="<c:url value='/assets/user/css/normalize.css'/>">

<!-- MAIN CSS 
		============================================ -->
<link rel="stylesheet" href="<c:url value='/assets/user/css/main.css'/>">

<!-- STYLE CSS 
		============================================ -->
<link rel="stylesheet" href="<c:url value='/assets/user/style.css'/>">

<!-- RESPONSIVE CSS 
		============================================ -->
<link rel="stylesheet" href="<c:url value='/assets/user/css/responsive.css'/>">

<!-- IE CSS 
		============================================ -->
<link rel="stylesheet" href="<c:url value='/assets/user/css/ie.css'/>">

<!-- MODERNIZR JS 
		============================================ -->
<script src="<c:url value='/assets/user/js/vendor/modernizr-2.6.2.min.js'/>"></script>
</head>

<body class="index-2">
	<tiles:insertAttribute name="header"/>
  	<tiles:insertAttribute name="body"/>
   	<tiles:insertAttribute name="footer"/>
      <!-- JS 
		===============================================-->
    <!-- jquery js -->
    <script src="<c:url value='/assets/user/js/vendor/jquery-1.11.3.min.js'/>"></script>

    <!-- fancybox js -->
    <script src="<c:url value='/assets/user/js/jquery.fancybox.js'/>"></script>

    <!-- bxslider js -->
    <script src="<c:url value='/assets/user/js/jquery.bxslider.min.js'/>"></script>

    <!-- meanmenu js -->
    <script src="<c:url value='/assets/user/js/jquery.meanmenu.js'/>"></script>

    <!-- owl carousel js -->
    <script src="<c:url value='/assets/user/js/owl.carousel.min.js'/>"></script>

    <!-- nivo slider js -->
    <script src="<c:url value='/assets/user/js/jquery.nivo.slider.js'/>"></script>

    <!-- jqueryui js -->
    <script src="<c:url value='/assets/user/js/jqueryui.js'/>"></script>

    <!-- bootstrap js -->
    <script src="<c:url value='/assets/user/js/bootstrap.min.js'/>"></script>

    <!-- wow js -->
    <script src="<c:url value='/assets/user/js/wow.js'/>"></script>
    <script>
        new WOW().init();
    </script>
    <!-- main js -->
    <script src="<c:url value='/assets/user/js/main.js'/>"></script>
    <!-- order page  js-->

</body>

</html>