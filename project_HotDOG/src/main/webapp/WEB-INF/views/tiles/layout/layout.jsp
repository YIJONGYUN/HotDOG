<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta name="description" content="Bootstrap 3 template for corporate business" />
    <title>핫도그</title>
    
    <!-- 파비콘 설정 -->
    <link rel="shortcut icon" href="/resources/img/dog.ico">
    
    <!-- bootstrap css -->
	<link href="/resources/css/bootstrap.min.css" rel="stylesheet" />
	
	<!-- Theme skin -->
	<link id="t-colors" href="/resources/skins/default.css" rel="stylesheet" />
	
	<!-- boxed bg -->
	<link id="bodybg" href="/resources/bodybg/bg1.css" rel="stylesheet" type="text/css" />
    
	<!-- CSS -->
	<link href="/resources/plugins/flexslider/flexslider.css" rel="stylesheet" media="screen" />
	<link href="/resources/css/cubeportfolio.min.css" rel="stylesheet" />
	<link href="/resources/css/style.css" rel="stylesheet" />
	
	<!-- Theme skin -->
	<link id="t-colors" href="/resources/skins/default.css" rel="stylesheet" />
	
	<!-- boxed bg -->
	<link id="bodybg" href="/resources/bodybg/bg1.css" rel="stylesheet" type="text/css" />

    <!-- Custom Fonts -->
    <link href="/resources/css/font-awesome.css" rel="stylesheet" type="text/css">
    <!-- SweetAlert CSS -->
    <link href="/resources/css/sweetalert2.min.css" rel="stylesheet">
    
    <!-- jQuery -->
    <script src="/resources/js/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/js/bootstrap.min.js"></script>
    <!-- SweetAlert JavaScript -->
    <script src="/resources/js/sweetalert2.min.js"></script>
    
<style type="text/css">

@font-face { 
     font-family:"setFont";
     src:url("/resources/fonts/A뉴굴림2.TTF") format("truetype");
}    

body, div, h2 { 
     font-family:setFont;
} 
</style>
    
</head>
<body>
<div id="wrapper">
   <div id="header">
      <tiles:insertAttribute name="header" />
   </div>
   <div id="content">
      <tiles:insertAttribute name="content" />
   </div>
   <div id="footer">
      <tiles:insertAttribute name="footer" />
   </div>
</div>

	<script src="/resources/js/jquery.min.js"></script>
	<script src="/resources/js/modernizr.custom.js"></script>
	<script src="/resources/js/jquery.easing.1.3.js"></script>
	<script src="/resources/js/bootstrap.min.js"></script>
	<script src="/resources/plugins/flexslider/jquery.flexslider-min.js"></script>
	<script src="/resources/plugins/flexslider/flexslider.config.js"></script>
	<script src="/resources/js/jquery.appear.js"></script>
	<script src="/resources/js/stellar.js"></script>
	<script src="/resources/js/classie.js"></script>
	<script src="/resources/js/uisearch.js"></script>
	<script src="/resources/js/jquery.cubeportfolio.min.js"></script>
	<script src="/resources/js/google-code-prettify/prettify.js"></script>
	<script src="/resources/js/animate.js"></script>
	<script src="/resources/js/custom.js"></script>
</body>

</html>
