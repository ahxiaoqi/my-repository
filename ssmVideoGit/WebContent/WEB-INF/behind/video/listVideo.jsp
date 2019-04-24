<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">

<!--表示使用IE最新的渲染模式进行解析-->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!--
    	兼容一些移动设备，会根据屏幕的大小缩放
    	width=device-width  表示宽度是设备的宽度（很多手机的宽度都是980px）
    	initial-scale=1  初始化缩放级别   1-5
    	minimum-scale=1  maximum-scale=5
    	user-scalable=no  禁止缩放
    -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>视频列表管理</title>

<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->

<!-- 如果IE版本小于9，加载以下js,解决低版本兼容问题 -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->


<!--
    	引入网络的jquery  ,如果想换成自己的，导入即可
    	网站优化：建议将你网站的css\js等代码，放置在互联网公共平台上维护，比如：七牛
    -->
<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>

<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/confirm.js"></script>
<style type="text/css">
th {
	text-align: center;
}
</style>

</head>
<body>


	<nav class="navbar-inverse">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">

				<a class="navbar-brand" href="<c:url value='/video/list.do'/>">视频管理系统</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-9">
				<ul class="nav navbar-nav">
					<li class="active"><a href="<c:url value='/video/list.do'/>">视频管理</a></li>
					<li><a href="#">主讲人管理</a></li>
					<li><a href="#">课程管理</a></li>
				</ul>
				<p class="navbar-text navbar-right">
					<span>${sessionScope.userName}</span> <i class="glyphicon glyphicon-log-in"
						aria-hidden="true"></i>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/admin/exit.do"
						class="navbar-link">退出</a>
				</p>
			</div>
		</div>
		
	</nav>

	<div class="jumbotron" style="padding-top: 15px;padding-bottom: 15px;">
		<div class="container">
			<h2>视频管理</h2>
		</div>
	</div>


	<div class="container">

		<div class="row">
			<div class="col-md-2">
				<a href="<c:url value="/video/toadd.do" />"  class="btn btn-info dropdown-toggle">添加</a>
				<button id="btn" onclick="deleteBatch()" class="btn btn-primary" type="button">
					批量删除 <span id="delbtn" class="badge" id="delNum">0</span>
				</button>
			</div>
			<div class="row">
				<!-- 查询相关组件 -->
				<form id="searchForm" class="navbar-form " action="<c:url value='/video/findVedioByCondition.do'/>"  method="post">
						<div class="btn-group">
							<select class="selecter form-control" name="speakerId" >
							<option value="0" ${speakerId==speaker.id?'selected':'' } >请选择讲师</option>
							<c:forEach items="${speakers }" var="speaker">
								<option name="id" value="${speaker.id }" ${speakerId==speaker.id?'selected':'' }>${speaker.speakerName }</option>
						</c:forEach>
					</select>
					</div>
					<div class="btn-group">
						<select class="selecter form-control" name="courseId" >
						<option value="0"  ${courseId==course.id ?'selected':'' }>请选择专辑</option>
						<c:forEach items="${courses }" var="course">
							<option value="${course.id }" ${courseId==course.id ?'selected':'' }>${course.courseTitle }</option>
						</c:forEach>
					</select>
					</div>
					<div class="btn-group">
						<input class="inputer form-control" type="text" name="detail" placeholder="课程简介" value="${detailInput }">
					</div>
					<div class="btn-group">
						<input class="inputer form-control" type="text" name="title" placeholder="标题" value="${titleInput }">
					</div>
					<div class="btn-group">
					<!-- 隐藏的输入框,用于存储当前页数据 -->
					<input id="pageNoInput" type="hidden" name="pageNo" value="">
					<button type="submit" class="btn btn-info dropdown-toggle">查询</button>
					<a id="clearBtn" class="btn btn-danger" href="<c:url value='/video/list.do'/>">清空</a>
					</div>
				</form>

			</div>

		</div>
	</div>

	<div class="container" style="margin-top: 20px;">
		<form id="deleteBatchForm" action="<c:url value='/video/deleteBatch.do'/>" method="post">
			<table class="table table-bordered table-hover"
				style="text-align: center;table-layout:fixed">
				<thead>
					<tr class="active">
						<th style="width:3%"><input id="checkall" type="checkbox" onclick="selectAll()"
							id="checkAllId" /></th>
						<th style="width:5%">序号</th>
						<th style="width:15%">名称</th>
						<th style="width:12%;">专辑标题</th>
						<th style="width:12%;">专辑介绍</th>
						<th style="width:5%">讲师</th>
						<th style="width:5%">时长</th>
						<th style="width:5%">播放次数</th>
						<th style="width:5%">编辑</th>
						<th style="width:5%">删除</th>
					</tr>
					<c:forEach items="${videos }" var="video" varStatus="i">
						<tr class="active">
							<th style="width:3%"><input  name="checkId" type="checkbox" onclick="selectCount()" class="check"  value="${video.id }"
							 /></th>
						<th style="width:5%">${i.index+1}</th>
						<th style="width:15%">${video.title }</th>
						<th style="width:12%;">${video.course.courseTitle }</th>
						<th style="width:12%;">${video.course.couserDesc }</th>
						<th style="width:5%">${video.speaker.speakerName }</th>
						<th style="width:5%">${video.time }</th>
						<th style="width:5%">${video.playNum }</th>
						<th style="width:5%"><a class="glyphicon glyphicon-pencil"  href="<c:url  value='/video/toUpdate.do?id=${video.id }'/>"></a></th>
						<th style="width:5%"><a class="glyphicon glyphicon-trash" onclick="delById(${video.id })" ></a></th>
						</tr>
					</c:forEach>
				</thead>
				<tbody>
					
				</tbody>
			</table>	
				<div class="">
					<nav aria-label="Page navigation">
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
					</nav>
			</div>
			
		</form>

	</div>
	<script type="text/javascript">
		var btn = document.getElementById("checkall");
		var delbtn = document.getElementById('delbtn');
		var boxArr = document.getElementsByClassName("check");
		function selectCount(){
			var num = 0;
			for(var i=0;i<boxArr.length;i++){
				
				if(boxArr[i].checked){
					num++;
				}
				delbtn.innerHTML=num;
			}
			delbtn.innerHTML=num;
		} 
		function selectAll(){
			if(btn.checked){
				for(var i=0;i<boxArr.length;i++){
					boxArr[i].checked='checked';
				}
				selectCount();
			}
			else{
				for(var i=0;i<boxArr.length;i++){
					boxArr[i].checked=false;
				}
				selectCount();
			}
		}
		
		
		function goPage(pageNo){
			// 获取搜索form表单中的隐藏输入框,并给value赋值
			$("#pageNoInput").attr("value",pageNo);
			// 获得搜索form表单对象
			$("#searchForm").submit();
		}
		function delById(id){
			url="http://localhost:8080/ssmVideo/video/delete.do?id="+id;
			if(confirm('确认删除吗?')){
				window.location.href=url;
				window.enent.returnValue=true;
			}
			else{
				return false;
			}
		}
		function deleteBatch(){
			$("#deleteBatchForm").submit();
		}
		
	</script>
</body>
</html>