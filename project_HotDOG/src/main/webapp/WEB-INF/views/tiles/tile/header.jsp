<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  prefix="m" uri="urlDecode"%> 

<header>
<div class="navbar navbar-default navbar-static-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
			</button>
			<a class="navbar-brand" href="/"><img src="/resources/img/logo1.png" width="50%"/></a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="/about">핫도그란?</a></li>
				<li><a href="/board/info">독스타그램</a></li>
				<li><a href="/board/parcel">이리오시개</a></li>
				<li><a href="/board/mating">도그시그널</a></li>
				<c:choose>
					<c:when test="${login.id eq null}">
						<li><a href="/user/loginPage">로그인</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="/user/logout">${login.name} 님</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</div>
</header>
