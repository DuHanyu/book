<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书分类</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" type="text/css" href="<c:url value='/adminjsps/admin/css/book/list.css'/>">
<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/pager/pager.css'/>" />
<script type="text/javascript" src="<c:url value='/jsps/pager/pager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/adminjsps/admin/js/book/list.js'/>"></script>
  </head>
  
  <body>
<div class="divBook">
<ul>

<c:forEach items="${requestScope.pageInfo.list }" var="page">

 <li>
  <div class="inner">
    <a class="pic" href="<c:url value='/adminLoad/${page.bid }'/>"><img src="<c:url value='/${page.image_b }'/>" border="0"/></a>
    <p class="price" >
		<span class="price_n">&yen;${page.currPrice }</span>
		<span class="price_r">&yen;${page.price }</span>
		(<span class="price_s">${page.discount }折</span>)
	</p>
	
	
	<c:url value="admidFindSelectBook" var="author">
	  <c:param name="author" value="${page.author }"></c:param>
	</c:url>
	
	<c:url value="admidFindSelectBook" var="press">
	  <c:param name="press" value="${page.press }"></c:param>
	</c:url>
	
	<p><a id="bookname" title="${page.bname }" href="<c:url value='/adminLoad/${page.bid }'/>">${page.bname }</a></p>
	<p><a href="<c:url value='${author }'/>" name='P_zz' title='${page.author }'>${page.author }</a></p>
	<p class="publishing">
		<span>出版社：</span><a href="<c:url value='${press }'/>">${page.press }</a>
	</p>
  </div>
 </li>
</c:forEach>


</ul>
</div>
<div style="float:left; width: 100%; text-align: center;">
	<hr/>
	<br/>
	<%@include file="/jsps/pager/pager.jsp" %>
</div>
  </body>
 
</html>

