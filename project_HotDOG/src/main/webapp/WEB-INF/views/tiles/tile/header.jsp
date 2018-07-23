<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  prefix="m" uri="urlDecode"%> 

<!-- start header -->
<header>
<div id = "header">
	<div class="navbar navbar-default navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/"><img src="/resources/img/logo1.png" alt="" width="50%"/></a>
			</div>
			<div class="navbar-collapse collapse ">
				<ul class="nav navbar-nav">

					<li><a href="portfolio.html">수정3</a></li>
					<li><a href="portfolio.html">수정</a></li>
					
					<li class="dropdown"><a href="#" class="dropdown-toggle "
						data-toggle="dropdown" data-hover="dropdown" data-delay="0"
						data-close-others="false">Blog <i class="fa fa-angle-down"></i></a>
						<ul class="dropdown-menu">
							<li><a href="blog-rightsidebar.html">Blog right
									sidebar</a></li>
							<li><a href="blog-leftsidebar.html">Blog left sidebar</a></li>
							<li><a href="post-rightsidebar.html">Post right
									sidebar</a></li>
							<li><a href="post-leftsidebar.html">Post left sidebar</a></li>
						</ul></li>
					<li><a href="/user/loginPage">로그인</a></li>
				</ul>
			</div>
		</div>
	</div>
	</div>
</header>
<!-- end header -->