<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>图书网后台管理系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/static/css/mgr.css"/>
  </head>  
  <body>
    <div id="container">
    	<%@ include file="admin_include/header.jsp" %>
    	<div id="main">
			<div class="section-left">
				<h2>图书分类信息</h2>
				<table class="table" cellspacing="0">
			    	<tr>
			    		<td class="header" width="200">图书分类</td>
			    		<td class="header" width="60">操作</td>
			    	</tr>
			    	<c:forEach items="${categories }" var="categ">
			    		<tr>
				    		<td>${categ.category }</td>
				    		<td><a href="${pageContext.request.contextPath }/delete_category?id=${categ.id }">删除</a></td>
				    	</tr>
			    	</c:forEach>		    
			    </table>
			</div>
			<div class="section-right">
				<h2>添加分类信息</h2>
				<form action="${pageContext.request.contextPath }/add_category_action" method="post">
					<p>分类名称：<input type="text" name="category"  /><input type="submit" value=" 保 存 "  /></p>						
			    </form>
			</div>			
			<div class="cf"></div>
		</div>  	
		<%@ include file="admin_include/footer.jsp" %>
	</div>
  </body>
</html>
