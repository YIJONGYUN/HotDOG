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
							<li><a href="/"><i class="fa fa-home"></i></a><i class="icon-angle-right"></i></li>
							<li class="active">로그인</li>
						</ul>
					</div>
				</div>
			</div>
		</section>
		<section id="content">
			<div class="container">

				<div class="row">
					<div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
						<form action="/" method="get" role="form" class="register-form">
							<h2>Sign in <small>manage your account</small></h2>
							<hr class="colorgraph">

							<div class="form-group">
								<input type="text" name="id" id="id" class="form-control input-lg" placeholder="ID" tabindex="4" data-rule="required" data-msg="ID를 입력해 주세요!" />
							</div>
							<div class="form-group">
								<input type="password" class="form-control input-lg" id="password" placeholder="Password" data-rule="required" data-msg="비밀번호를 입력해 주세요!" />
							</div>

							<hr class="colorgraph">
							<div class="row">
								<div class="col-xs-12 col-md-6">
									<input type="submit" value="로그인" class="btn btn-primary btn-block btn-lg" tabindex="7">
								</div>
								<div class="col-xs-12 col-md-6" style="margin-top: 2%">아직 계정이 없으세요? <a href="/user/registerPage">회원가입</a></div>
							</div>
						</form>
					</div>
				</div>

			</div>
		</section>
	</div>
	<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
	<script src="/resources/contactform/contactform.js"></script>

</body>

</html>
