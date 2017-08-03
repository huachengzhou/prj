<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register</title>
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
.div_{
margin:0 auto;
width:1000px;
text-align:center;
}
.div2{
width:100%;
height:400px;
text-align:center;
}
</style>
</head>
<body>
	<div class="div_">
		<div class="div1"></div>
		
		<div class="div2">
		    <sf:form modelAttribute="eForm" commandName="eForm" action="isRedirect" method="post" >
		        <font color="blue">name:</font><sf:input path="employeeName"/><br>
		        <font color="blue">phone:</font><sf:input path="employeePhone"/><br>
		        <font color="blue">address:</font><sf:input path="employeePlace"/><br>
		        <font color="blue">employeeBirth:</font><sf:input path="employeeBirth"/>example:2017-05-12<br>
		        <font color="blue">password:</font><sf:password path="password"/><br>
		        
		        <font color="blue">sex:</font>
		        <sf:select path="employeeSex">
		            <sf:option value="1">man</sf:option>
		            <sf:option value="0">woman</sf:option>
		        </sf:select><br>
		        <font color="blue">是否为管理层:</font>
		        <sf:select path="isLead">
		            <sf:option value="1">Y</sf:option>
		            <sf:option value="0">N</sf:option>
		        </sf:select><br>
		        <input type="submit" value="submit">
		    </sf:form>
		</div>
	</div>
</body>
</html>