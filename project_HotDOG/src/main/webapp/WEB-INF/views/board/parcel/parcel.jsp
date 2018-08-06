<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!-- jstl이란 간단한 프로그램 로직을 구현하기 위해 사용하는 라이브러리이다. -->

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
					<div class="col-sm-12 col-lg-12">
						<div class="text-center">
							<img src="/resources/img/comeon.png" width="25%" />
						</div>
						<hr class="colorgraph">
						<div class="row">
							<div class="col-sm-12 col-lg-12">
								<table class="table table-striped table-hover text-center"
									data-effect="fade">
									<thead>
										<tr>
											<th>번호</th>
											<th>말머리</th>
											<th colspan="4">제목</th>
											<th>작성자</th>
											<th>작성일</th>
											<th>조회수</th>
										</tr>
									</thead>
									<tbody>
										<c:choose>
											<c:when test="${empty boardParcelList}">
												<td colspan="9">게시물이 존재하지 않습니다.</td>
											</c:when>
											<c:otherwise>
												<c:forEach items="${boardParcelList}" var="articleDTO"
													varStatus="status">
													<!-- status는 현재 for-each문에서 몇 번 째 순환 중인지 알 수 있다. -->
													<input type="hidden" id="articleNo"
														value="${articleDTO.articleNo}">
													<!-- 게시글 상세 내용 조회시 articleNo가 필요하기 때문에 숨겨서 보내준다. -->
													<tr>
														<td>${fn:length(boardParcelList)-((1-1) * 5 + status.index)}</td>
														<td>${category[status.index].content}</td>
														<td colspan="4"><a
															href="/board/parcel/detail/${articleDTO.articleNo}"
															style="color: black;">${articleDTO.title}</a>  [
															${replyCount[status.index]} ]</td>
														<td>${name[status.index].name}</td>
														<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
																value="${articleDTO.regDate}" /></td>
														<td>${articleDTO.hitCount}</td>
													</tr>
												</c:forEach>
											</c:otherwise>
										</c:choose>
									</tbody>
								</table>
							</div>
						</div>
						<a href="/board/parcel/form" class="btn btn-warning pull-right"><i
							class="fa fa-heart"></i> 글쓰기 </a>
						<div class="col-lg-12">
							<div class="text-center">
								<ul class="pagination">
									<li><a href="#">&laquo;</a></li>
									<li><a href="#">1</a></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">4</a></li>
									<li><a href="#">5</a></li>
									<li><a href="#">&raquo;</a></li>
								</ul>
							</div>
						</div>
						<form action="/board/parcel/search" id="searchForm">
							<div class="col-md-4 col-md-offset-4">
								<div class="input-group">
									<div class="input-group-btn">
										<button id="mystatus" type="button"
											class="btn btn-default dropdown-toggle"
											data-toggle="dropdown">
											검색 <span class="caret"></span>
										</button>
										<input type="hidden" id="searchOption" name="searchOption"
											value="">
										<ul id="mytype" class="dropdown-menu">
											<li style="text-align: center;" value="title">제목</li>
											<li style="text-align: center;" value="name">작성자</li>
											<li style="text-align: center;" value="content">내용</li>
										</ul>
									</div>

									<input id="keyword" name="keyword" type="text"
										class="form-control"> <span class="input-group-btn">
										<button class="btn btn-default" type="submit">Go!</button>
									</span>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>
	</div>
	<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>

	<script>
		$('#mytype li').on(
				'click',
				function() {
					$('#mystatus').html(
							$(this).text() + ' <span class="caret"></span>');
					$('#searchOption').val($(this).attr('value'));
				});

		$('#searchForm').submit(function() {

			if ($('#searchOption').val() == "") {
				swal({
					type : 'error',
					title : '검색 유형을 선택해 주세요!'
				});
				return false;
			} else if ($('#keyword').val().trim().length < 1) {
				swal({
					type : 'error',
					title : '검색할 내용을 입력해 주세요!'
				});
				$('#keyword').focus();
				return false;
			}
		});
	</script>

</body>

</html>
