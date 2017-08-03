<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>企业日常事务管理系统-发布新消息</title>
<link href="css/css.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/channel.css" type="text/css" rel="stylesheet" media="all" />
<script src="js/menu.js" type="text/javascript"></script>
<style type="text/css">
.oLi {
	margin: 0 auto;
	width: 1000px;
}

.oLi ul li {
	float: left;
	width:100px;
	margin-left:30px;
}
a{
text-decoration:none;
}
</style>
</head>
<body>
	<div class="oLi">
		<ul>
			<li><a href="main_">首页</a></li>
			<li><a href="msg_">消息列表</a></li>
			<li><a href="publish">发布新消息</a></li>
			<li><a href="prj">身份识别</a></li>
		</ul>
		<div style="float:none;"></div>
	</div>
	<div align="center">企业日常事务管理系统，为企业内部通信提供最简便的服务！</div>
	<div align="center">
		<img src="images/banner.jpg" width="970" height="147" />
	</div>
	<div id="conmenu"></div>
	<div id="place">
		当前位置：[<a href="main_">首页</a>] - [发布新消息]
	</div>
	<div id="channelcont">
		<div id="channelleft">
			<div class="channelinleft">
				<div id="messageBox">
					<p>
						<font color="red">${error}</font>
					</p>
					<form action="msgPublish" method="post">
						<p>
							消息标题： <input type="text" name="title" size="50" />
						</p>
						<p>消息内容：</p>
						<p>
							<textarea rows="6" cols="89" name="otxt"></textarea>
						</p>
						<p align="center">
							<input type="submit" value="提交" /> <input type="reset"
								value="重置" />
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="copyright">
		<ul>
			<li></li>
			<li>企业日常事务管理系统 &nbsp;&copy;2009-2010</li>
		</ul>
	</div>
	<div class="end"></div>
</body>
</html>