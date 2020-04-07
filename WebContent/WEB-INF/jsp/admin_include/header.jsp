<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
		<c:if test="${empty user }">
			<jsp:forward page="/index"/>
		</c:if>
    	<div id="header"><h1>智远教育--图书网后台管理系统</h1></div>
    	<div id="info">${user.userName}，
    	您好！&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/user_out">登出</a></div>
    	<div class="menu">
    		<ul>
    			<li><a href="${pageContext.request.contextPath }/admin_home">首页</a></li>
    			<li><a href="${pageContext.request.contextPath }/category_access">图书分类管理</a></li>
    			<li><a href="book-mgr.html">图书管理</a></li>
    			<li><a href="#">购书订单管理</a></li>
    		</ul>	
    	</div>