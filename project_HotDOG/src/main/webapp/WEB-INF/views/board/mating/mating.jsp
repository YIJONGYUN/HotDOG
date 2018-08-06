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
							<li><a href="/"><i class="fa fa-home"></i></a> <i
								class="icon-angle-right"></i></li>
							<li class="active"><a href="/board/mating">도그시그널</a></li>
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
							<img src="/resources/img/dog_signal.png" width="20%" />
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
											<c:when test="${empty boardMatingList}">
												<td colspan="9">게시물이 존재하지 않습니다.</td>
											</c:when>
											<c:otherwise>
												<c:forEach items="${boardMatingList}" var="articleDTO" varStatus="status">
													<input type="hidden" id="articleNo" value="${articleDTO.articleNo}">
													<tr>
														<td>${articleNumber - status.index}</td>
														<td>${category[status.index].content}</td>
														<td colspan="4"><a href="/board/mating/detail/${articleDTO.articleNo}" style="color: black;">
														<c:choose>
															<c:when test="${articleDTO.step > 0}">
															<c:forEach begin="1" end="${articleDTO.step}" step="1">
																 <img src="/resources/img/reply.png" width="3%" style="margin-bottom: 0px;" /> 
															</c:forEach>
															</c:when> 
														</c:choose>
														${articleDTO.title}  [${replyNumber[status.index]}]</a></td>
														<td>${name[status.index].name}</td>
														<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${articleDTO.regDate}" /></td>
														<td>${articleDTO.hitCount}</td>
													</tr>
												</c:forEach>
											</c:otherwise>
										</c:choose>
									</tbody>
								</table>
							</div>
						</div>
						<a href="/board/mating/form" class="btn btn-warning pull-right"><i
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
						<div class="col-md-4 col-md-offset-4">
							<form action="/board/mating/search" method="get" id="searchForm">
								<div class="input-group">
									<div class="input-group-btn">
										<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" id="searchList">
											검색 <span class="caret"></span>
										</button>
										<ul class="dropdown-menu" id="mySearch" role="menu">
											<li style="text-align: center;" value="title" id="title">제목</li>
											<li style="text-align: center;" value="author" id="author">작성자</li>
											<li style="text-align: center;" value="content" >내용</li>
										</ul>
										<input type="hidden" name="searchType" id="searchType">
									</div>
	
									<input type="text" class="form-control" id="keyword" name="keyword"> 
									
									<span class="input-group-btn">
										<button class="btn btn-default" type="submit">Go!</button>
									</span>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
	<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
	
	<script>
		$(function() {
			$('#mySearch li').on('click', function() {
				var type = $(this).attr('value');
				
			    // 버튼에 선택된 항목 텍스트 넣기 
			    $('#searchList').html($(this).text()+' <span class="caret"></span>');
			    // 검색 타입 value 값으로 넣기
			    $('#searchType').val(type);
			});
		})
		
		$("#searchForm").submit(function() {
			var searchType = $('#searchType').val();	// 검색 타입
			var keyword = $('#keyword').val();			// 검색할 내용
			
			/** 검색 유형을 선택하지 않고 버튼 눌렀을 경우 */
			if (searchType === "") {
				swal({
					  type: 'warning',
					  title: '검색할 유형을 선택하세요!'
				});
				return false;
			}
			
			/* 검색어를 입력하지 않고 버튼 눌렀을 경우 */
			if (keyword.trim().length < 1) {
				swal({
					  type: 'warning',
					  title: '검색어를 입력하세요!'
				});
				$('#keyword').focus();
				return false;
			}
			
			return true;
		})
		
	</script>

</body>

</html>
