<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
				<!-- 新 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">

		<!-- 主页css样式 -->
		<link rel="stylesheet" href="css/index.css">  

		<!-- font-awesome图标 -->
		<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">  


		<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
		<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

		<script src="js/index.js"></script>

	</head>


	<body>
	
        <%@include file="head.jsp" %>

		<div class="contain-fluid index-first-contain">

			<div class="slide_page">
				<div class="slide_left">
					<a href="javascript:;" class="js_left"><i class="fa fa-angle-left fa-2x" style="color: white"></i></a>
				</div>

				<div class="slide_right">
					<a href="javascript:;" class="js_right"><i class="fa fa-angle-right fa-2x" style="color: white"></i></a>
				</div>
			</div>

			<div class="section-inner">

				<div class="section-inner-title">
					<h1 class="section-inner-font font-color-white">新歌首发</h1>
				</div>

							<div class=" section-inner-slide">
				<ul class="playlist-list">
					<c:forEach items="${newIndexMusicList}" var="music" varStatus="status">
						<li class="section-slide-item" id="slide-body">
							<div class="playlist-cover-box link-white">
								<div class="playlist-cover" id="slide">
									<a id="play" data-id="${music.musicid}" data-path="${music.musicpath}"
										href="javascript:;"> <img class="section-img"
										src="${music.musicphoto}"> <i class="icon-play"></i>
									</a>
								</div>

								<h4 class="playlist-title">
									<span> <a data-id="music.musicid"
										data-path="${music.musicpath}" href="javascript:;">${music.musicname}</a>

									</span>
								</h4>

								<div class="playlist-author">
									<a data-id="${music.singerid}" href="javascript:;">${music.singername}</a>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>

			</div>
			</div>	

			
			<!-- <div class="mod_slide_action">
				<div class="slide_action slide_action--left">
					<a href="javascript:;" class="slide_action__btn slide_action__btn--left">
						<i class="icon_txt">上一页</i>
						<i class="slide_action__arrow slide_action__arrow--left"></i>
					</a>
				</div>

				<div class="slide_action slide_action--right">
					
				</div>
			</div> -->


		</div>

		<div class="contain-fluid index-second-contain">
				<div class="second-inner">
					<div class="section-inner-title">
					<h1 class="section-inner-font ">精彩推荐</h1>
					</div>
					
				

				  <!--幻灯片代码-->
					<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
						  <!-- Indicators -->
						  <ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
							<li data-target="#carousel-example-generic" data-slide-to="4"></li>
							<li data-target="#carousel-example-generic" data-slide-to="5"></li>
						  </ol>
		
		  <!-- Wrapper for slides -->
						  <div class="carousel-inner" role="listbox">
							<div class="item active">
							  <img src="img/1.jpg" alt="Responsive image" class="img-responsive">
							  
							</div>
							<div class="item">
							  <img src="img/2.jpg" alt="Responsive image" class="img-responsive">
							 
							</div>
							<div class="item">
							  <img src="img/3.jpg" alt="Responsive image" class="img-responsive">
							  
							</div>
							<div class="item">
							  <img src="img/4.jpg" alt="Responsive image" class="img-responsive">
							  
							</div>
							<div class="item">
							  <img src="img/5.jpg" alt="Responsive image" class="img-responsive">
							  
							</div>
						  </div>
		
						  <!-- Controls -->
						  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
							<span class="glyphicon glyphicon-chevron-left"></span>
							<span class="sr-only">Previous</span>
						  </a>
						  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
							<span class="glyphicon glyphicon-chevron-right"></span>
							<span class="sr-only">Next</span>
						  </a>
					</div>
				</div>	
			</div>

<div class="contain-fluid toplist">
		<div class="section-inner">
			<div class="section-inner-title">
				<h1 class="section-inner-font font-color-white">排行榜</h1>
			</div>

			<div class="toplist-contain">
				<ul class="toplist-list">
					<li class="toplist-item">
						<div class="toplist-bg1 link-white">
							<h3 class="toplist-hd">
								<a href="toplist?type=new">
									<p class="icon_size">巅峰榜</p>
									<div class="icon-size-lg">新歌</div>
								</a>
							</h3>
							<ul class="toplist-songlist">
								<c:forEach items="${newMusicList}" var="music" varStatus="status"
									begin="0" end="3" step="1">
									<li class="toplist-song">
										<div class="toplist-number">${status.count}</div>
										<div class="toplist-songname">
											<a data-id="${music.musicid}" href="javascript:;">${music.musicname}</a>
										</div>
										<div class="toplist-artist">
											<a data-id="${music.singerid}" href="javascript:;">${music.singername}</a>
										</div>
									</li>
								</c:forEach>

							</ul>
						</div>
					</li>

					<li class="toplist-item">
						<div class="toplist-bg2 link-white">
							<h3 class="toplist-hd">
								<a href="toplist?type=hot">
									<p class="icon_size">巅峰榜</p>
									<div class="icon-size-lg">热歌</div>
								</a>
							</h3>
							<ul class="toplist-songlist">
								<c:forEach items="${hotMusicList}" var="music" varStatus="status"
									begin="0" end="3" step="1">
									<li class="toplist-song">
										<div class="toplist-number">${status.count}</div>
										<div class="toplist-songname">
											<a data-id="${music.musicid}" href="javascript:;">${music.musicname}</a>
										</div>
										<div class="toplist-artist">
											<a data-id="${music.singerid}" href="javascript:;">${music.singername}</a>
										</div>
									</li>
								</c:forEach>


							</ul>
						</div>
					</li>

					<li class="toplist-item">
						<div class="toplist-bg3 link-white">
							<h3 class="toplist-hd">
								<a href="toplist?type=dlm">
									<p class="icon_size">巅峰榜</p>
									<div class="icon-size-lg">下载最多</div>
								</a>
							</h3>
							<ul class="toplist-songlist">
								<c:forEach items="${dlmMusicList}" var="music" varStatus="status"
									begin="0" end="3" step="1">
									<li class="toplist-song">
										<div class="toplist-number">${status.count}</div>
										<div class="toplist-songname">
											<a data-id="${music.musicid}" href="javascript:;">${music.musicname}</a>
										</div>
										<div class="toplist-artist">
											<a data-id="${music.singerid}" href="javascript:;">${music.singername}</a>
										</div>
									</li>
								</c:forEach>

							</ul>
						</div>
					</li>


				</ul>
			</div>
		</div>
	</div>

	<div class="footer contain-fluid">
		<div class="section-inner">
			<div class="footer-copyright">
				<p>
					<a href="#" class="关于腾讯">关于腾讯</a> | <a href="#" class="服务条款">服务条款</a>
					| <a href="#" class="用户服务协议">用户服务协议</a> | <a href="#" class="广告服务">广告服务</a>
					| <a href="#" class="客服中心">客服中心</a>
				</p>

				<p>
					Copyright © 1998 - 2017 Tencent. <a href="#"
						class="All Rights Reserved">All Rights Reserved.</a>
				</p>

				<p>
					腾讯公司 <a href="#" title="版权所有">版权所有</a> <a href="#"
						title="腾讯网络文化经营许可证">腾讯网络文化经营许可证</a>
				</p>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	var objWin;
	$(".playlist-cover a").click(function(){
			var jthis = $(this);			
			$.ajax({
				url:"playMusic",
					type:"POST",
					contentType: "application/json;charset=utf-8",
					data:JSON.stringify({'musicid':jthis.attr("data-id")}),
					success:function(data){					
						if (objWin == null || objWin.closed) {  
							objWin =  window.open("html/player.html");
						}else{
					/* 	alert("已添加到播放列表"); */
						}
					},
					error:function(XMLHttpRequest, textStatus, errorThrown){
						alert(jthis.attr("data-id")+textStatus);
					}
			})
		})
	</script>

	</body>

</html>