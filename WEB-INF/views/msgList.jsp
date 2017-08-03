<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>消息列表</title>
<style type="text/css">
body{
    margin:0; padding:0; color:#000; font-size:12px; color:#123472; line-height:150%; font-family:"宋体",Arial, Helvetica, sans-serif;
    text-align:center;
    list-style:none;
    list-style-type: none;
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
a:link {color: blue}     
a:visited {color: #00FF00}  
a:hover {color: #FF00FF}    
a:active {color: #0000FF}  
.tab_{
    width:1000px;
    height:500px;
    border:1px solid #123472;
    margin-left:auto;
    margin-right:auto;
    margin-top:20px;
    margin-bottom:30px;
    text-align:center;
}
</style>
</head>
<body>
    <div align="center"> <h4>企业日常事务管理系统，为企业内部通信提供最简便的服务！</h4> </div>
	<div class="oLi">
		<ul>
			<li><a href="main_">首页</a></li>
			<li><a href="msg_">消息列表</a></li>
			<li><a href="publish">发布新消息</a></li>
			<li><a href="prj">身份识别</a></li>
		</ul>
		<div style="float: none;"></div>
	</div>
	<div align="center"><img src="images/banner.jpg" width="1000" height="147" /></div>
	<div class="tab_">
		<table width="1000px;" style="margin: 0 auto;">
			<caption>企业消息列表</caption>
			<tbody>
				<c:choose>
				    <c:when test="${page.hasPrePage}">
				    <tr><td> <a href="msg_?currentPage=1">首页</a> ;&nbsp;&nbsp;&nbsp;||&nbsp;&nbsp;&nbsp;&nbsp;
				             <a href="msg_?currentPage=${page.currentPage-1}">上一页</a> 
				    </td></tr>
				    </c:when>
				    <c:otherwise>
				        <tr> <td>首页 || 上一页</td> </tr>
				    </c:otherwise>
				</c:choose>
			</tbody>
			<tfoot>
			    <c:forEach  var="message" items="${requestScope.messages}">
				    <tr> <td> 
				    <a href="mList?messageID=${message.messageID}">${message.messageTitle}</a> 
				    <!-- 权限处理 -->
				    <c:choose>
				        <c:when test="${!sessionScope.employee.lead}"> . </c:when>
				        <c:otherwise>
				           <a href="deleteMessage?messageID=${message.messageID}">删除</a> 
				           <a href="updateMessage_?messageID=${message.messageID}">修改</a> 
				        </c:otherwise>
				    </c:choose>
				    </td> </tr>
				    <tr> <td> 发布人ID： ${message.messageID} </td> </tr>
				    <tr> <td> 发布时间：  <fmt:formatDate value="${message.publishTime}"/> </td> </tr>
				</c:forEach>
				
				<c:choose>
				    <c:when test="${page.hasNextPage}" >
					    <tr> <td>
					     <a href="msg_?currentPage=${page.currentPage+1}">下一页</a> ;&nbsp;&nbsp;||&nbsp;&nbsp;&nbsp;&nbsp;
					     <a href="msg_?currentPage=${page.totalPage}">尾页</a> 
					    </td>  </tr>
				    </c:when>
				    <c:otherwise>
				        <tr> <td>下一页 || 尾页</td> </tr>
				    </c:otherwise>
				</c:choose>
			    <tr> <td>当前第${page.currentPage}页,共${page.totalPage}页</td> </tr>
			</tfoot>
		</table>
	</div>
	<!-- 
a:link {color: #FF0000}     /* 未访问的链接 */
a:visited {color: #00FF00}  /* 已访问的链接 */
a:hover {color: #FF00FF}    /* 当有鼠标悬停在链接上 */
a:active {color: #0000FF}   /* 被选择的链接 */
	 -->
</body>
</html>