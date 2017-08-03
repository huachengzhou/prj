<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main</title>
<link href="css/css.css" type="text/css" rel="stylesheet" media="all" />
<style type="text/css">
body {
	text-align: center;
	margin:0; padding:0; color:#000; font-size:12px; color:#123472; line-height:150%; font-family:"宋体",Arial, Helvetica, sans-serif;
	list-style-type: none;
}

.oLi {
	margin: 0 auto;
	width: 1000px;
}

.oLi ul li {
	float: left;
	width: 100px;
	margin-left: 30px;
}

a {
	text-decoration: none;
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
		<div style="float: none;"></div>
	</div>
	
	<div id="topexplain">企业日常事务管理系统，为企业内部通信提供最简便的服务！</div>
	
	<div id="topmenu">
		<img src="images/banner.jpg" width="970" height="147" />
	</div>
	
	<div id="bookmunu" style="margin-top:50px;margin-bottom:40px;height:310px;">
		<div class="jsmenu" id="jsmenu">
			<c:choose>
				<c:when test="${empty sessionScope.employee}">
	                                              没有进行身份识别,请进行身份识别
	            </c:when>
				<c:otherwise>
					<table width="1000px;" style="margin: 0 auto;">
						<tbody>
							<tr>
								<td>员工编号:${employee.employeeID}</td>
							</tr>
							<tr>
								<td>员工姓名:${employee.employeeName}</td>
							</tr>
							<tr>
								<td>员工性别:${employee.employeeSex}</td>
							</tr>
							<tr>
								<td>员工日期:<fmt:formatDate value="${employee.employeeBirth}"/> </td>
							</tr>
							<tr>
								<td>办公室电话:${employee.employeePhone}</td>
							</tr>
							<tr>
								<td>地址:${employee.employeePlace}</td>
							</tr>
							<tr>
								<td>管理层领导:${employee.lead ? '是':'否'}</td>
							</tr>
						</tbody>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>