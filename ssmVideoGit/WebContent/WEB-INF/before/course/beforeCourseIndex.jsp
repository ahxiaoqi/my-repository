<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<!DOCTYPE html>
<html>

<head>
<meta name="viewport"
	content="initial-scale=1, maximum-scale=1, user-scalable=no">
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta name="keywords"
	content="Web前端视频教程,大数据视频教程,HTML5视频教程,UI视频教程,PHP视频教程,java视频教程,python基础教程">
<meta name="description"
	content="智游教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智游教育,学习成就梦想！">
<%@include file="../include/style.html"%>
<title>在线公开课-智游教育|java|大数据|HTML5|python|UI|PHP视频教程</title>
</head>

<body class="w100">
	 <jsp:include page="../include/header.jsp"></jsp:include> 

	<div id="app">
		<!--banner图-->
		<div class="banner"
			style="background-image: url(<c:url value='/img/banner-1.jpg' />)">
		
			</div>

		<!--面包屑导航-->
		<div class="container mian-nav" id="navDiv">公开课 /${subject.subjectName }</div>
		<input type="hidden" id="" value="">
		<div class="classify">
			<div class="container" id="dataContainer">
				<div class="section">
						<c:forEach items="${subject.courses}" var="c">
				
							<div class="classifyName">
								<p class="title title-first">专辑标题:${c.courseTitle}</p>
							</div>
							<div class="kcIntro">
								<p class="int">
									<span>课程介绍：${c.couserDesc}</span>
								</p>
								<ul>
									<c:forEach items="${c.video }" var="v">
									<li  class="section-main" style="width:300px" onclick="getVideo(${v.id})">
									<div class="thum" style="background-image: url(/upload/images/${v.imageUrl} );"></div>
										<p>${v.title }</p> 
										<div class="classify-v-info">
											<span class="count" title="观看次数">
								 			<img src="<c:url value='/img/count.png' />" alt="">${v.playNum }</span>
											<span class="duration" title="视频时长">
												<img src="<c:url value='/img/player.png' />" alt=""></span>
										</div>
									</li>
									</c:forEach>
								</ul>
								
							</div>
						</c:forEach>
					<div id="bar" class="classifyName">
							
						  <ul class="pagination">
						    <li>
						    	<a href="#" onclick="goPage(${page.firstPage })">首页</a>
						    </li>
						    <li>
						      <a href="#" onclick="goPage(${page.pageNum-1})" aria-label="Previous">
						        <span aria-hidden="true">&laquo;</span>
						      </a>
						    </li>
						    	 <c:forEach begin="1" end="${page.pages }" var="count">
						    		<li class="${page.pageNum ==count?'active':''}">
						    		<a href="#" onclick="goPage(${count})">${count }</a>
						    		</li>
						    	</c:forEach> 
						    <li>
						    <li>
					      		<a href="#" onclick="goPage(${page.pageNum+1})" aria-label="Next">
					        	<span aria-hidden="true">&raquo;</span>
					      		</a>
						    </li>
						    <li>
						    	<a href="#" onclick="goPage(${page.lastPage })">尾页</a>
						    </li>
						  </ul>
						
						
					</div>
				</div>
					
					
			
				
				
				
				
			</div>
		
		</div>
	</div>
	 <%@include file="../include/footer.jsp"%>

	<%@include file="../include/script.html"%> 
<script src="<c:url value='/js/jquery-1.8.3.min.js' /> "></script>
	<script type="text/javascript">
		function getVideo(id){
			location.href='http://localhost:8080/ssmVideo/web/tovideoById.do?videoId='+id;
		}
	</script>


</body>

</html>