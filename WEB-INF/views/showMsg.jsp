<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>showMsg</title>
<style type="text/css">
body{
    font-size:14px;
    text-align:center;
    margin:0 auto;
}
.oLi {
	width: 1000px;
	text-align:center;
	margin:0 auto;
}
.oLi ul{
	width:800px;
	text-align:center;
	margin:0 auto;
}
.oLi ul li {
	float: left;
	width: 70px;
	margin-left: 100px;
	text-align:center;
}

a {
	text-decoration: none;
}
.test {
	overflow-y: auto;
	width:100px;
	white-space: nowrap;
}

</style>
</head>
<body>
 <div align="center"> <h2>企业日常事务管理系统，为企业内部通信提供最简便的服务！</h2> </div>
	<div class="oLi">
		<ul>
			<li><a href="main_">首页</a></li>
			<li><a href="msg_">消息列表</a></li>
			<li><a href="publish">发布新消息</a></li>
			<li><a href="prj">身份识别</a></li>
		</ul>
		<div style="float: none;"></div>
	</div>
	
	<div style="width:1000px;height:400px;margin-left:0;margin-right:0;text-align:center;margin-top:80px;margin-bottom:30px;">
	
	<div style="float:left;width:600px;height:100%;" class="text">
		<h4><font> ${message.messageTitle}  </font></h4><br>
		<p> <font>${message.messageContent}</font> </p>
		<h5>time:<fmt:formatDate value="${message.publishTime}"/></h5><br>
		<div>
		    <c:forEach items="${replys}" var="reply">
		        <ul>
		            <li>回复人id: ${reply.replyID}</li>
		            <li>回复人内容:${reply.replyContent}</li>
		            <li>回复人时间 <fmt:formatDate value="${reply.replyTime}"/></li>
		        </ul>
		    </c:forEach>
		    <p> 第 ${page.currentPage} 共${page.totalPage}页</p>
		</div>
	</div>
	
	<div style="float:right;width:300px;height:100%;">
	    <p><font color="red">${error}</font></p>
	    <p><font color="blue">回复</font></p>
	    <form action="commitReply" method="post">
	        <textarea rows="5" cols="70" name="content"></textarea>
	        <input type="hidden" name="messageID" value="${message.messageID}">
	        <input type="submit" value="提交"><br>
	        <input type="reset" value="重置"><br>
	    </form>
	</div>
	
	<div style="float:none;"></div>
	</div>
</body>
</html>