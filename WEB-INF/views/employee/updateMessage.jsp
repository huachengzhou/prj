<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>updateMessage</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	color: #000;
	font-size: 12px;
	color: #123472;
	line-height: 150%;
	font-family: "宋体", Arial, Helvetica, sans-serif;
	text-align: center;
	list-style: none;
	list-style-type: none;
}

.oLi {
	width: 1000px;
	text-align: center;
	margin: 0 auto;
}

.oLi ul {
	width: 800px;
	text-align: center;
	margin: 0 auto;
}

.oLi ul li {
	float: left;
	width: 70px;
	margin-left: 100px;
	text-align: center;
}

a {
	text-decoration: none;
}

a:link {
	color: blue
}

a:visited {
	color: #00FF00
}

a:hover {
	color: #FF00FF
}

a:active {
	color: #0000FF
}
</style>
</head>
<body>
	<div align="center">
		<h4>企业日常事务管理系统，为企业内部通信提供最简便的服务！</h4>
	</div>
	<div class="oLi">
		<ul>
			<li><a href="main_">首页</a></li>
			<li><a href="msg_">消息列表</a></li>
			<li><a href="publish">发布新消息</a></li>
			<li><a href="prj">身份识别</a></li>
		</ul>
		<div style="float: none;"></div>
	</div>
	<div align="center">
		<img src="images/banner.jpg" width="1000" height="147" />
	</div>
	<div>
		<form action="updateMessage" method="post">
		    <font>messageTitle:</font><br>
		    <textarea rows="2" cols="80" name="messageTitle">${message.messageTitle}</textarea><br>
		    <input type="hidden" name="messageID" value="${message.messageID}">
		    <font>content:</font><br>
		    <textarea rows="5" cols="80" name="messageContent">${message.messageContent}</textarea><br>
			<input type="submit" value="submit"><br>
		</form>
	</div>
</body>
</html>