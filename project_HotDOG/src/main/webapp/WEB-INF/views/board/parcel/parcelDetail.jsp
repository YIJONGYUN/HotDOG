<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
							<li><a href="/"><i class="fa fa-home"></i></a> <i
								class="icon-angle-right"></i></li>
							<li class="active"><a href="/board/parcel">이리오시개</a></li>
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
							<img src="/resources/img/comeon.png" width="35%" />
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
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
											value="${article.regDate}" /></td>
									<td>조회수</td>
									<td>${article.hitCount}</td>
								</tr>
								<tr>
									<td colspan="6"><textarea class="form-control text-center"
											rows="5" cols="50" readonly="readonly"
											style="background-color: white;">${article.content}</textarea></td>
								</tr>
							</tbody>
						</table>
						<hr class="colorgraph">
						<a href="/board/parcel" class="btn btn-default"> 목록 </a>
						<div class="bs-docs-example pull-right">
							<div class="btn-group">
								<a href="/board/parcel/edit/${article.articleNo}"
									class="btn btn-primary">수정</a> <a
									href="/board/parcel/delete/${article.articleNo}"
									class="btn btn-theme">삭제 </a> <a
									href="/board/parcel/replyForm/${article.articleNo}"
									class="btn btn-warning">답글</a>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-8 col-md-offset-2">
						<div class="comment-area">
							<h4>댓글 ${replyCount }</h4>
							<c:choose>
								<c:when test="${empty replyList}">
									<div class="media">
										<div class="media-body">
											<div class="media-content">
												<p class="text-center">등록된 댓글이 없습니다.</p>
											</div>
										</div>
									</div>
								</c:when>
								<c:otherwise>
									<c:forEach items="${replyList}" var="replyDTO"
										varStatus="status">
										<div class="media">
											<a class="pull-left"><img src="/resources/img/dog2.png" /></a>
											<div class="media-body">
												<div class="media-content">
													<h6>
														<span><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
																value="${replyDTO.regDate }" /></span>
														${name[status.index].name }
													</h6>
													<p>${replyDTO.content}</p>
												</div>
											</div>
										</div>
									</c:forEach>
								</c:otherwise>
							</c:choose>
							<hr class="colorgraph">
							<form role="form" action="/board/parcel/reply" class="replyForm">
								<div class="col-md-10">
									<div class="form-group">
										<textarea class="form-control" rows="2"
											placeholder="댓글을 작성해 주세요!" name="content" id="replyContent"></textarea>
										<input type="hidden" id="articleNo" name="articleNo"
											value=${article.articleNo }>
									</div>
								</div>
								<div class="col-md-2">
									<button type="submit" class="btn btn-lg btn-theme"
										style="margin-left: 20%">등록</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
	<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
	<!--<script src="/resources/contactform/contactform.js"></script>-->

	<script>
		$('.replyForm').submit(function() {
			if ($('#replyContent').val().trim().length < 1) {
				swal({
					type : 'error',
					title : '댓글을 입력해 주세요!'
				});
				$('#replyContent').focus();
				return false;
			}
		})
	</script>

</body>

</html>
