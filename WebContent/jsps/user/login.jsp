<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/css/user/login.css'/>">
	<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/jsps/js/user/login.js'/>"></script>

  </head>
  
  <body>
	<div class="main">
	 <%--  <div><img src="<c:url value='/images/logo.gif'/>" /></div> --%>
	  <div>
	    <div class="imageDiv"><img class="img" src="<c:url value='/images/zj.png'/>"/></div>
        <div class="login1">
	      <div class="login2">
            <div class="loginTopDiv">
              <span class="loginTop">会员登录</span>
              <span>
                <a href="<c:url value='/jsps/user/regist.jsp'/>" class="registBtn"></a>
              </span>
            </div>
            <div>
            <form:form target="_top" action="login" method="post" id="loginForm" modelAttribute="user">
                <input type="hidden" name="method" value="" />
                  <table>
                    <tr>
                      <td width="50"></td>
                      <td><%-- <label class="error" id="msg"><form:errors path="*"/></label> --%></td>
                    </tr>
                    <tr>
                      <td width="50">用户名</td>
                      <td><form:input path="loginname"  class="input" id="loginname"/></td>
                    </tr>
                    <tr>
                      <td height="20">&nbsp;</td>
                      <td><label id="loginnameError" class="error"><form:errors path="loginname"/></label></td>
                    </tr>
                    <tr>
                      <td>密　码</td>
                      <td><form:input path="loginpass" id="loginpass" class="input"/></td>
                    </tr>
                    <tr>
                      <td height="20">&nbsp;</td>
                      <td><label id="loginpassError" class="error"><form:errors path="loginpass"/></label></td>
                    </tr>
                    <tr>
                      <td>验证码</td>
                      <td>
                      <form:input path="verifyCode" class="input yzm" id="verifyCode"/>
                        <img id="imgVerifyCode" src="<c:url value='/verifyCode'/>"/>
                        <a href="javascript: _hyz()">换张图</a>
                      </td>
                    </tr>
                    <tr>
                      <td height="20px">&nbsp;</td>
                      <td><label id="verifyCodeError" class="error"><form:errors path="verifyCode"/></label></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td align="left">
                        <input type="image" id="submit" src="<c:url value='/images/login1.jpg'/>" class="loginBtn"/>
                      </td>
                    </tr>																				
                 </table>
              </form:form>
            </div>
          </div>
        </div>
      </div>
	</div>
  </body>
</html>
	