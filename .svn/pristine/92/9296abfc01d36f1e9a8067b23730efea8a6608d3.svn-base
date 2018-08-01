<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>layui-test</title>

</head>
<body>
	<table class="layui-table">
		 <tr>
			<th>ID</th>
			<th>用户ID</th>
			<th>数量</th>
			<th>等级</th>
			<th>添加时间</th>
			<th>IP地址</th>
		</tr>
		<c:forEach items="${list}" var="member">
		<tr>
			<th>${member.id}</th>
			
		</tr>
		</c:forEach>
	</table>
	<div id="test1"></div>
	<div class="layui-upload">
  <button type="button" class="layui-btn" id="test2">上传图片</button>
  <div class="layui-upload-list">
    <img class="layui-upload-img" id="demo1">
    <p id="demoText"></p>
  </div>
</div>

<table class="layui-table two">
	<script>
		$(document).ready(function() {
			$(".two").load("updatestaff3");
		});
	</script>
</table>
<div id="testtwo"></div>
</body>
<script>
//layui.use(['laypage','upload'],function(){

</script>
</html>