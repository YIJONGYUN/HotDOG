<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<body>
	<div id="wrapper">
		<section id="inner-headline">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<ul class="breadcrumb">
							<li><a href="/"><i class="fa fa-home"></i></a>
							<i class="icon-angle-right"></i></li>
							<li class="active"><a href="/board/mating">도그시그널</a></li>
						</ul>
					</div>
				</div>
			</div>
		</section>
		<section id="content">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2">
						<div class="text-center">
			        		<img src="/resources/img/dog_signal.png" alt="" width="30%"/>
			        	</div>
						<hr class="colorgraph">
						<table class="table table-bordered text-center" data-effect="fade">
			              <thead>
			                <tr>
			                  <td>${category.content}</td>
			                  <th colspan="5">${article.title}</th>
			                </tr>
			              </thead>
			              <tbody>
			               <tr>
			                  <td>작성자</td>
			                  <td>${user.name}</td>
			                  <td>작성일</td>
			                  <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${article.regDate}" /></td>
			                  <td>조회수</td>
			                  <td>${article.hitCount}</td>
			                </tr>
			                <tr>
			                  <td colspan="6">
			                  	<textarea class="form-control text-center" rows="5" cols="50" readonly="readonly" style="background-color: white; resize: none;">${article.content}</textarea>
			                  </td>
			                </tr>
			              </tbody>
			            </table>
						<hr class="colorgraph">
						<a href="/board/mating" class="btn btn-default"> 목록 </a>
						<div class="bs-docs-example pull-right">
							<div class="btn-group">
								<a href="/board/mating/editForm/${article.articleNo}" class="btn btn-primary">수정</a>
								<a href="/board/mating/delete/${article.articleNo}" class="btn btn-theme">삭제 </a>
								<a href="/board/mating/rearticleForm/${article.articleNo}/${article.group}" class="btn btn-warning">답글</a>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-8 col-md-offset-2">
						<div class="comment-area">
							<h4>댓글 ${replyCount}</h4>
							
							<c:choose>
								<c:when test="${empty replyList}">
									<div class="media-content">
										<p align="center"> 댓글이 존재하지 않습니다! </p>
									</div>
								</c:when>
								<c:otherwise>
									<c:forEach items="${replyList}" var="reply" varStatus="status">
										<div class="media">
											<a class="pull-left"><img src="/resources/img/dog2.png"/></a>
											<div class="media-body">
												<div class="media-content">
													<h6><span><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${reply.regDate}"/></span> ${name[status.index].name} </h6>
													<p> ${reply.content} </p>
												</div>
											</div>
										</div>
									</c:forEach>
								</c:otherwise>
							</c:choose>
							<hr class="colorgraph">
							<form role="form" action="/board/mating/registReply" method="post">
								<div class="col-md-10">
									<div class="form-group">
										<textarea class="form-control" rows="2" placeholder="댓글을 작성해 주세요!" style="resize: none;" name="content"></textarea>
										<input type="hidden" name="articleNo" value="${articleNo}">
									</div>
								</div>
								<div class="col-md-2">
									<button type="submit" class="btn btn-lg btn-theme" style="margin-left: 20%">등록</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
	<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
	<script src="/resources/contactform/contactform.js"></script>

</body>

</html>
