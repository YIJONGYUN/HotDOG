<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
						<div id="sendmessage">Your message has been sent. Thank you!</div>
						<div id="errormessage"></div>
						<form action="/board/mating/regist" method="post" role="form" class="contactForm">
							<div class="form-group">
								<div class="input-group">
						        	<div class="input-group-btn">
						            	<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" id="categoryList"> 말머리 <span class="caret"></span></button>
										<ul class="dropdown-menu" id="myCategory" role="menu">
											<c:forEach items="${categoryList}" var="category">
												<li style="text-align: center;" id="${category.categoryNo}">${category.content}</li>
											</c:forEach>
										</ul>
									</div>
						             
						            <input type="hidden" id="categoryNo" name="categoryNo">
						            
						  			<input type="text" name="title" class="form-control" id="title" placeholder="제목을 입력해 주세요" data-rule="required" data-msg="제목을 입력해 주세요!" />
									<div class="validation"></div>
						             
								</div>
							</div>
							<div class="form-group">
								<textarea class="form-control" name="content" rows="5" data-rule="required" data-msg="내용을 입력해 주세요!" placeholder="내용을 입력해 주세요" style="resize: none;"></textarea>
								<div class="validation"></div>
							</div>

							<div class="text-center">
								<button type="submit" class="btn btn-theme btn-block btn-md">등록</button>
							</div>
						</form>
						<hr class="colorgraph">

					</div>
				</div>
			</div>
		</section>
	</div>
	<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
	<!-- <script src="/resources/contactform/contactform.js"></script> -->
	
	<script>
		$(function() {
			$('#myCategory li').on('click', function() {
			    // 버튼에 선택된 항목 텍스트 넣기 
			    $('#categoryList').html($(this).text()+' <span class="caret"></span>');
			    // 카테고리 번호 속성으로 넣기
			    $('#categoryNo').val($(this).attr('id'));
			});
		})
		
 		$('.contactForm').submit(function() {
			if ($('#title').val().trim().length < 1) {
				alert("제목을 입력해 주세요!");
				$('.validation').html($(this).attr("제목을 입력해 주세요!"));
				return false;
			}
		}) 
	</script>

</body>

</html>
