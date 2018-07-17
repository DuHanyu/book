<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/css.css'/>">
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/css/user/regist.css'/>">
	<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/common.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/jsps/js/user/regist.js'/>"></script>
  </head>
  
  <body>
<div class="divBody">
  <div class="divTitle">
    <span class="spanTitle">新用户注册</span>
  </div>
  <div class="divCenter">
  
  <form:form action="register" method="post" id="registForm" modelAttribute="user">
   <!--  <input type="hidden" name="method" value=""/> -->
    <table>
      <tr>
        <td class="tdLabel">用户名：</td>
        <td class="tdInput">
         <form:input path="loginname" id="loginname" class="input"/>
        </td>
        <td class="tdError">
            <label class="labelError" id="loginnameError"><form:errors path="loginname"></form:errors></label>
        </td>
      </tr>
      <tr>
        <td class="tdLabel">登录密码：</td>
        <td class="tdInput">
        <form:password path="loginpass" id="loginpass" class="input"/>
        </td>
        <td class="tdError">
          <label class="labelError" id="loginpassError"><form:errors path="loginpass"></form:errors></label>
        </td>
      </tr>
      <tr>
        <td class="tdLabel">确认密码：</td>
        <td class="tdInput">
        <form:password path="reloginpass" id="reloginpass" class="input"/>
        </td>
        <td class="tdError">
          <label class="labelError" id="reloginpassError"><form:errors path="reloginpass"></form:errors></label>
        </td>
      </tr>
      <tr>
        <td class="tdLabel">Email：</td>
        <td class="tdInput">
        <form:input path="email" id="email" class="input"/>
        </td>
        <td class="tdError">
          <label class="labelError" id="emailError"><form:errors path="email"></form:errors></label>
        </td>
      </tr>
      <tr>
        <td class="tdLabel">图形验证码：</td>
        <td class="tdInput">
        <form:input path="verifyCode" id="verifyCode" class="input"/>
        </td>
        <td class="tdError">
          <label class="labelError" id="verifyCodeError"><form:errors path="verifyCode"></form:errors></label>
        </td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td>
          <span class="verifyCodeImg"><img id="imgVerifyCode" width="100" src="<c:url value='/verifyCode'/>" /></span>
        </td>
        <td><a href="javascript: _hyz()">换一张</a></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td>
          <input type="image" src="<c:url value='/images/regist1.jpg'/>" id="submitBtn"/>
        </td>
        <td>&nbsp;</td>
      </tr>
    </table>
   </form:form>
  </div>
</div>
  </body>
</html>
	