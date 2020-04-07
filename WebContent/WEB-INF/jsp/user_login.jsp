<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>智远图书网</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/static/css/styles.css"/>
  </head>  
  <body>
    <div id="container">
    	<%@ include file="user_include/header.jsp" %>
    	<div id="main">
    		<div class="box" id="register">
    			<div class="title">用户登录</div>
				<form action="${pageContext.request.contextPath }/user_login" method="post" style="margin: 10px;">
					<table cellspacing="0" class="no-border">
				    	<tr>
				    		<td style="text-align: right;">登录账号：</td>
				    		<td><input type="text" name="userId" class="txt" value="" /></td>
				    	</tr>
				    	<tr>
				    		<td style="text-align: right;">登录密码：</td>
				    		<td><input type="password" name="userPsw" class="txt" value="" /></td>
				    	</tr>
				    	<tr>
				    		<td>&nbsp;</td>
				    		<td><input type="submit" value=" 登  录 " class="btn" />&nbsp;&nbsp;</td>
				    	</tr>
				    </table>
				</form>
    		</div>
    	</div>  	
		<%@ include file="user_include/footer.jsp" %>
	</div>
  </body>
</html>