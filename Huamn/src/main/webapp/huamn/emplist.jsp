<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/huamn/css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							遇见美好
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">员工信息管理</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Welcome ! ${sessionScope.user.realname}
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>工号</td>
							<td>姓名</td>
							<td>工资</td>
							<td>年龄</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${requestScope.temp}" var="temp">
							<tr>
								<td>${temp.id}</td>
								<td>${temp.name}</td>
								<td>${temp.salary}</td>
								<td>${temp.age}</td>
								<td>
									<a href="${pageContext.request.contextPath}/Temp/message?id=${temp.id}">修改</a>
									<a href="${pageContext.request.contextPath}/Temp/delete?id=${temp.id}">删除</a>
								</td>
							</tr>
						</c:forEach>
					</table>
					<p>
						<input type="button" class="button" value="添加员工" onclick="location='${pageContext.request.contextPath}/huamn/addEmp.jsp'"/>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
					1227971942@qq.com
				</div>
			</div>
		</div>
	</body>
</html>
