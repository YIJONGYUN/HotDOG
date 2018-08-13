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
							<li class="active">회원가입</li>
						</ul>
					</div>
				</div>
			</div>
		</section>
		<section id="content">
			<div class="container">

				<div class="row">
					<div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
						<form role="form" class="register-form" action="/user/regist" method="post">
							<h2>Sign Up <small>It's free and always will be.</small></h2>
							<hr class="colorgraph">
							<div class="row">
								<div class="col-xs-9 col-sm-9">
									<div class="form-group">
										<input type="text" name="id" id="id" class="form-control input-lg" placeholder="ID" tabindex="1">
									</div>
								</div>
								<div class="col-xs-3 col-sm-3">
									<div class="form-group">
										<input type="button" value="CHECK" class="btn btn-primary input-lg" style="padding-right: 25%; padding-left: 25%; margin-left: 7%">
									</div>
								</div>
										
							</div>
							<div class="row">
								<div class="col-xs-12 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="password" name="password" id="password" class="form-control input-lg" placeholder="Password" tabindex="2">
									</div>
								</div>
								<div class="col-xs-12 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="password" name="password_confirmation" id="password_confirmation" class="form-control input-lg" placeholder="Confirm Password" tabindex="3">
									</div>
								</div>
							</div>
							<div class="form-group">
								<input type="text" name="name" id="name" class="form-control input-lg" placeholder="Name" tabindex="4">
							</div>
							<div class="form-group">
								<input type="text" name="phone" id="phone" class="form-control input-lg" placeholder="Phone Number" tabindex="5">
							</div>

							<hr class="colorgraph">
							<div class="row">
								<div class="col-xs-12 col-md-6">
									<input type="submit" value="가입하기" class="btn btn-theme btn-block btn-lg" tabindex="6">
								</div>
								<div class="col-xs-12 col-md-6"  style="margin-top: 2%">이미 계정이 있으신가요? <a href="/user/loginPage">로그인</a></div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>

	</div>
	<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
	
	<script type="text/javascript">
		$('.register-form').submit(function() {
			
			if ($('#id').val().trim().length < 1) {
				swal({
					  type: 'error',
					  title: 'ID를 입력해 주세요!'
				});
				$('#id').focus();
				return false;
			}
			
			if ($('#password').val().trim().length < 1) {
				swal({
					  type: 'error',
					  title: '비밀번호를 입력해 주세요!'
				});
				$('#password').focus();
				return false;
			}
			
			if ($('#password_confirmation').val().trim().length < 1) {
				swal({
					  type: 'error',
					  title: '비밀번호를 한번 더 입력해 주세요!'
				});
				$('#password_confirmation').focus();
				return false;
			}
			
			if ($('#name').val().trim().length < 1) {
				swal({
					  type: 'error',
					  title: '이름을 입력해 주세요!'
				});
				$('#name').focus();
				return false;
			}
			
			if ($('#phone').val().trim().length < 1) {
				swal({
					  type: 'error',
					  title: '전화번호를 입력해 주세요!'
				});
				$('#phone').focus();
				return false;
			}
			
			if ($('#password').val() != $('#password_confirmation').val()) {
				swal({
					  type: 'error',
					  title: '비밀번호가 일치하지 않습니다.'
				});
				$('#password').focus();
				return false;
			}
		});
	</script>

</body>

</html>
