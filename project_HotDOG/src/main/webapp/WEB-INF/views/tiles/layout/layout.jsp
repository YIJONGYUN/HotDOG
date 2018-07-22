<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <title>핫도그</title>
    
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
</body>

</html>
