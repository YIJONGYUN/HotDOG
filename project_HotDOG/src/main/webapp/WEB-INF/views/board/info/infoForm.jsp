<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
							<li class="active"><a href="/board/info">독스타그램</a></li>
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
			        	<img src="/resources/img/dogstagram.png" width="40%"/>
			        </div>
						<hr class="colorgraph">
						<div id="sendmessage">Your message has been sent. Thank you!</div>
						<div id="errormessage"></div>
						<form action="" method="post" role="form" class="contactForm">
							<div class="form-group">
								<div class="input-group">
						        	<div class="input-group-btn">
						            	<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"> 말머리 <span class="caret"></span></button>
										<ul class="dropdown-menu">
											<li style="text-align: center;">[의료/위생]</li>
											<li style="text-align: center;">[의류/미용]</li>
											<li style="text-align: center;">[사료/간식]</li>
											<li style="text-align: center;">[훈련/놀이]</li>
										</ul>
									</div>
						             
						  			<input type="text" name="name" class="form-control" id="name" placeholder="제목을 입력해 주세요" data-rule="required" data-msg="제목을 입력해 주세요!" />
									<div class="validation"></div>
						             
								</div>
							</div>
							<div class="form-group">
								<textarea class="form-control" name="content" rows="5" data-rule="required" data-msg="내용을 입력해 주세요!" placeholder="내용을 입력해 주세요"></textarea>
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
	<script src="/resources/contactform/contactform.js"></script>

</body>

</html>
