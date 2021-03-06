<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
						<div id="sendmessage">Your message has been sent. Thank you!</div>
						<div id="errormessage"></div>
						<form action="/board/parcel/articleReply" method="post"
							role="form" class="contactForm">
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-btn">
										<button id="mystatus" type="button"
											class="btn btn-default dropdown-toggle"
											data-toggle="dropdown">
											말머리 <span class="caret"></span>
										</button>
										<ul id="mytype" class="dropdown-menu">
											<li style="text-align: center;" value="5">[오시개]</li>
											<li style="text-align: center;" value="6">[가시개]</li>
										</ul>
									</div>
									<input type="hidden" id="group" name="group"
										value=${article.group }> <input type="hidden"
										id="step" name="step" value=${article.step }> <input
										type="hidden" id="order" name="order" value=${article.order }>
									<input type="hidden" id="categoryNo" name="categoryNo" value="">
									<input type="text" name="title" class="form-control" id="title"
										placeholder="제목을 입력해 주세요" data-rule="required"
										data-msg="제목을 입력해 주세요!" />
									<div class="validation"></div>
								</div>
							</div>
							<div class="form-group">
								<textarea class="form-control" name="content" rows="5"
									data-rule="required" data-msg="내용을 입력해 주세요!"
									placeholder="내용을 입력해 주세요" id="articleContent"></textarea>
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
	<!--<script src="/resources/contactform/contactform.js"></script>-->

	<script>
		$('#mytype li').on(
				'click',
				function() {
					// 버튼에 선택된 항목 텍스트 넣기 
					$('#mystatus').html(
							$(this).text() + ' <span class="caret"></span>');

					// 선택된 항목 값(value) 얻기
					$('#categoryNo').val($(this).attr('value'));
				});

		$('.contactForm').submit(function() {

			if ($('#categoryNo').val() == "") {
				swal({
					type : 'error',
					title : '말머리를 선택해 주세요!'
				});
				return false;
			}

			else if ($('#title').val().trim().length < 1) {
				swal({
					type : 'error',
					title : '제목을 입력해 주세요!'
				});
				$('#title').focus();
				return false;
			}

			else if ($('#articleContent').val().trim().length < 1) {
				swal({
					type : 'error',
					title : '내용을 입력해 주세요!'
				});
				$('#articleContent').focus();
				return false;
			}
		})
	</script>
</body>

</html>