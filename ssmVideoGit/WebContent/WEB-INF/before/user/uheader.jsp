<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<header>
	<div class="container top_bar clearfix">
		<img src="<c:url value='/img/logo.png'/>" alt="智游">
		<div id="tele">
			<span>4006-371-555</span>
			<span>0371-88888598</span>
		</div>
	</div>
	<menu>
		<div class="container clearfix">
			<ul class="clearfix f_left">
				<li><a href="<c:url value='/index.jsp'/>">首页</a></li>
				<li class="menu_active"><a href="#">个人中心</a></li>
			</ul>
			<div id="user_bar">
				<a href="#">
						<img id="avatar" src="static/img/avatar_lg.png" alt="">
						<img id="avatar" src="" alt="">
				</a>
				<a href="#" id="lay_out">退出</a>
			</div>
		</div>
	</menu>
</header>
