<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>企业日常事务管理系统-身份识别</title>
<style type="text/css">
body{
    margin:0; padding:0; color:#000; font-size:14px; color:#123472; line-height:150%; font-family:"宋体",Arial, Helvetica, sans-serif;
    text-align:center;
    list-style:none;
    list-style-type:none;
    direction: none;
}
#div_N {
	margin: 0 auto;
	font-size: 12px;
	color: black;
	width: 1000px;
}

.copyright {
	margin: 0 auto;
}

.copyright ul li {
	float: left;
	margin-left: 40px;
}

#indexfirst {
	margin: 0 auto;
	text-align: center;
}

.oLi ul li {
	float: left;
	width:100px;
	margin-left:30px;
}
a{
text-decoration:none;
}
a:link {color: blue}     
a:visited {color: #00FF00}  
a:hover {color: #FF00FF}    
a:active {color: #0000FF} 
</style>
</head>
<body id="div_N">
	<div align="center" style="text-align:center;">企业日常事务管理系统，为企业内部通信提供最简便的服务！</div>
	<div align="center">
		<img src="images/banner.jpg" width="970" height="147" />
	</div>
	<div class="oLi">
		<ul>
			<li><a href="main_">首页</a></li>
			<li><a href="msg_">消息列表</a></li>
			<li><a href="publish">发布新消息</a></li>
			<li><a href="prj">身份识别</a></li>
		</ul>
			<div style="float:none;"></div>
	</div>
	<div id="indexfirst">
		<div id="place">
			当前位置：[<a href="main">首页</a>] - [员工身份识别]
		</div>
		<div id="menunav2">
			<div class="tit">
				<h1>员工身份识别</h1>
			</div>
			<div>
				<font color="red">${error}</font>
				<form action="statusRecogniseAction" method="post">
					<p>
						员工编号：<input type="text" name="employeeID" value="${employeeID}" />
					</p>
					<p>&nbsp;</p>
					<p>
						系统口令：<input type="password" name="password" value="${password}" />
					</p>
					<p>&nbsp;</p>
					<p>
						<input type="submit" value="提交" /> <input type="reset" value="重置" />
					</p>
				</form>
			</div>
		</div>
	</div>


	<div class="copyright">
		<ul>
			<li>企业日常事务管理系统 </li>
			<li>&copy;2009-2010</li>
			<li style="float:right;"><a href="register">是否需要注册</a></li>
		</ul>
			<div style="float:none;"></div>
	</div>
</body>
</html>