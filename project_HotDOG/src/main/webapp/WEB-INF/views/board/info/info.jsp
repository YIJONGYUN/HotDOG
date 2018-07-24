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
			      <div class="col-sm-12 col-lg-12">
			        <div class="text-center">
			        	<img src="/resources/img/dogstagram.png" width="30%"/>
			        </div>
			        <hr class="colorgraph">
			        <div class="row">
			          <div class="col-sm-12 col-lg-12">
			            <table class="table table-striped table-hover text-center" data-effect="fade">
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
			                <tr>
			                  <td>5</td>
			                  <td>[아들]</td>
			                  <td colspan="4"><a href="/board/info/detail" style="color: black;">화이트 포메라니언 4살입니다~</a></td>
			                  <td>이종윤</td>
			                  <td>2018-07-24</td>
			                  <td>23</td>
			                </tr>
							<tr>
			                  <td>4</td>
			                  <td>[딸]</td>
			                  <td colspan="4"><a style="color: black;">크림 푸들 시집 보내요</a></td>
			                  <td>심민정</td>
			                  <td>2018-07-24</td>
			                  <td>27</td>
			                </tr>
			                <tr>
			                  <td>3</td>
			                  <td>[아들]</td>
			                  <td colspan="4"><a style="color: black;">강아지 교배 시키려는데 조언 부탁드려요</a></td>
			                  <td>이종윤</td>
			                  <td>2018-07-22</td>
			                  <td>52</td>
			                </tr>
			                <tr>
			                  <td>2</td>
			                  <td>[아들]</td>
			                  <td colspan="4"><a style="color: black;">저희 강아지 교배를 어떻게 해야할까요</a></td>
			                  <td>권한별</td>
			                  <td>2018-07-21</td>
			                  <td>39</td>
			                </tr>
			                <tr>
			                  <td>1</td>
			                  <td>[딸]</td>
			                  <td colspan="4"><a style="color: black;">저희 강아지랑 교배할 강아지 있나요?</a></td>
			                  <td>심민정</td>
			                  <td>2018-07-21</td>
			                  <td>24</td>
			                </tr>
			              </tbody>
			            </table>
			          </div>
			        </div>
			        <a href="/board/info/form" class="btn btn-warning pull-right"><i class="fa fa-heart"></i> 글쓰기 </a>
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
						<div class="input-group">
				        	<div class="input-group-btn">
				            	<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"> 검색 <span class="caret"></span></button>
								<ul class="dropdown-menu">
									<li style="text-align: center;">제목</li>
									<li style="text-align: center;">작성자</li>
									<li style="text-align: center;">내용</li>
								</ul>
							</div>
				             
				  			<input type="text" class="form-control">
				             
				  			<span class="input-group-btn">
				 				<button class="btn btn-default" type="button">Go!</button>
				    		</span>
						</div>
					</div>
			    </div>
			</div>
			</div>
		</section>
	</div>
	<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>

</body>

</html>
