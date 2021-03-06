<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
							<li class="active"><a href="/board/info">독스타그램</a></li>
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
							<img src="/resources/img/dogstagram.png" width="30%" />
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
											<c:when test="${empty boardInfoList}">
												<td colspan="9">게시물이 존재하지 않습니다.</td>
											</c:when>
											<c:otherwise>
												<c:forEach items="${boardInfoList}" var="articleDTO"
													varStatus="status">
													<!-- status는 현재 for-each문에서 몇 번 째 순환 중인지 알 수 있다. -->
													<input type="hidden" id="articleNo"
														value="${articleDTO.articleNo}">
													<!-- 게시글 상세 내용 조회시 articleNo가 필요하기 때문에 숨겨서 보내준다. -->
													<tr>
														<td>${listNo-status.index}</td>
														<c:choose>
														<c:when test="${articleDTO.step > 0}">
															<td></td>
														</c:when>
														<c:otherwise>
															<td>${category[status.index].content}</td>
														</c:otherwise>
														</c:choose>
														<td colspan="4" align=left>
														<c:choose>
														<c:when test="${articleDTO.title == '삭제된 게시물입니다.'}">
														<c:choose>
															<c:when test="${articleDTO.step > 0}">
																<c:forEach begin="1" end="${articleDTO.step}" step="1">　</c:forEach>
															<img src="/resources/img/reply.png" width="3%" style="margin-bottom: 0px;" />
															</c:when> 
														</c:choose>${articleDTO.title}[${reply[status.index]}]
														</c:when>
														<c:otherwise>
														<a href="/board/info/detail/${articleDTO.articleNo}"
															style="color: black;"><c:choose>
															<c:when test="${articleDTO.step > 0}">
																<c:forEach begin="1" end="${articleDTO.step}" step="1">　</c:forEach>
															<img src="/resources/img/reply.png" width="3%" style="margin-bottom: 0px;" />
															</c:when> 
														</c:choose>${articleDTO.title}[${reply[status.index]}]</a>
														</c:otherwise>
														</c:choose>
														</td>
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
						<a href="/board/info/form" class="btn btn-warning pull-right"><i
							class="fa fa-heart"></i> 글쓰기 </a>

						<div class="col-lg-12">
							<div class="text-center">
								<ul class="pagination">
									<c:if test="${prevLink > 0}">
									<li><a href="javascript:goList('${prevLink}')">&laquo;</a></li>
								</c:if>
								
								<c:forEach var="i" items="${pages}" >
									<c:choose>
										<c:when test="${curPage == i}">
											<li><a style="background-color:#fecf71">${i}</a></li>
										</c:when>
									<c:otherwise>
										<li><a href="javascript:goList('${i}')">${i}</a></li>
									</c:otherwise>
									</c:choose>
								</c:forEach>
								
								<c:if test="${nextLink > 0}">
									<li><a href="javascript:goList('${nextLink}')">&raquo;</a></li>
								</c:if>
								</ul>
							</div>
						</div>
						
						<div id="form-group" style="display: none;">
							<form id="listForm" action="/board/info" method="get">
							 <p>
							  <input type="hidden" name="curPage" />
							 </p>
							</form>
						</div>
						
						<form action="/board/info/search" method="post" id="selectForm">
							<div class="col-md-4 col-md-offset-4">
								<div class="input-group">
									<div class="input-group-btn">
										<button type="button" class="btn btn-default dropdown-toggle"
											data-toggle="dropdown" id="type">
											검색 <span class="caret"></span>
										</button>
										<ul class="dropdown-menu" id="myType">
											<li style="text-align: center;" id="제목">제목</li>
											<li style="text-align: center;" id="작성자">작성자</li>
											<li style="text-align: center;" id="내용">내용</li>
										</ul>
									</div>

									<input type="hidden" id="searchOption" name="searchOption"
										value="기본"> <input type="text" class="form-control"
										id="keyword" name="keyword"> <span
										class="input-group-btn">
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
		$(function() {
			$('#myType li').on('click',function() {
			//드롭다운 선택항목 넣기
			$('#type').html($(this).text()+ '<span class="caret"></span>');
			//키워드옵션넣기
			$('#searchOption').val($(this).attr('id'));
			})
		})
		/** 검색 유효성 검사 */
		$('#selectForm').submit(function() {
			var searchOption = $('#searchOption').val();
			var keyword = $('#keyword').val();  
			
			/** 검색 조건 없을 때 */
			if(searchOption==="기본"){
				swal({
					  type: 'warning',
					  title: '검색할 조건을 선택하세요!'
				});
				return false;
			}
			
			/** 검색 내용 없을 때 */
			if(keyword.trim().length<1){
				swal({
					  type: 'warning',
					  title: '검색할 내용을 입력하세요!'
				});
				return false;
			}
			
			return true;
		})
		
		function goList(page) {
				location.href = "/board/info?searchOption=${searchOption}&keyword=${keyword}&curPage=" + page;
			}
	</script>
</body>

</html>
