<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhouyc
  Date: 2017/6/30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>


<div class="intro">
	<div class="container">
		<div class="v-intro">
			<div class="left">
					<video id="" src="" class="video-js vjs-default-skin" controls width="627" height="280"
						   poster="/upload/video/${video.videoUrl}">
						  
				</video>
			</div>

			<div class="right">
				<p class="right-title">视频标题:${video.title }</p>
				<div class="avatar">
					<span style="background-image: url(/upload/images/${video.imageUrl})"></span>
					<p><b>讲师：${video.speaker.speakerName }</b><br><i>讲师描述</i></p>
				</div>
				<p class="video-intro">
					<span>本节内容：</span>${video.detail }
				</p>
			</div>
		</div>

		<div class="kcjs">
			<p class="title">课程介绍</p>
			<p class="content">${video.detail }</p>
		</div>

	</div>
</div>
<!--目录 :展现该专辑下的全部视频-->
<div class="catalog">
	<div class="container">
		<p class="title">目录</p>
			<div class="chapter">
				<p class="biaoti"><a href="#">视频标题</a></p>
				<p class="lecturer">视频描述</p>
				<p class="lecturer">讲师：xxx</p>
				<div class="v-info">
					<span class="count"><img src="static/img/count.png" alt="">播放次数</span>
					<span class="duration"><img src="static/img/player.png" alt="">播放次数</span>
				</div>
			</div>
	</div>
</div>