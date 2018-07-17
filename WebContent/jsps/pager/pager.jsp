<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	function _go() {
		var currPage = $("#pageCode").val();//获取文本框中的当前页码
		if(!/^[1-9]\d*$/.test(currPage)) {//对当前页码进行整数校验
			alert('请输入正确的页码！');
			return;
		}
		if(currPage > ${requestScope.pageInfo.pages}) {//判断当前页码是否大于最大页
			alert('请输入正确的页码！');
			return;
		}
		location = "${requestScope.url}&currPage="+currPage;
	}
</script>


<div class="divBody">
	<div class="divContent">
		<%--上一页 --%>
		<c:if test="${requestScope.pageInfo.hasPreviousPage  }">
			<a
				href="${requestScope.url}&currPage=${requestScope.pageInfo.pageNum-1 }"
				class="aBtn bold">上一页</a>
		</c:if>
		<c:if test="${!requestScope.pageInfo.hasPreviousPage  }">
			<span class="spanBtnDisabled">上一页</span>
		</c:if>




		<%-- 计算begin和end --%>
		<%-- 如果总页数<=6，那么显示所有页码，即begin=1 end=${pb.tp} --%>
		<%-- 设置begin=当前页码-2，end=当前页码+3 --%>
		<%-- 如果begin<1，那么让begin=1 end=6 --%>
		<%-- 如果end>最大页，那么begin=最大页-5 end=最大页 --%>


		<%-- 显示页码列表 --%>
		<c:forEach items="${requestScope.pageInfo.navigatepageNums }"
			var="page_num">
			<c:if test="${requestScope.pageInfo.pageNum==page_num }">
				<span class="spanBtnSelect">${page_num }</span>
			</c:if>
			<c:if test="${requestScope.pageInfo.pageNum!=page_num }">
				<a href="${requestScope.url}&currPage=${page_num}" class="aBtn">${page_num }</a>
			</c:if>
		</c:forEach>


		<%-- 显示点点点 --%>
		<c:if
			test="${requestScope.pageInfo.pageNum<requestScope.pageInfo.pages }">
			<span class="spanApostrophe">...</span>
		</c:if>

		<%--下一页 --%>
		<c:if test="${requestScope.pageInfo.hasNextPage}">
			<a
				href="${requestScope.url}&currPage=${requestScope.pageInfo.pageNum+1 }"
				class="aBtn bold">下一页</a>
		</c:if>
		<c:if test="${!requestScope.pageInfo.hasNextPage   }">
			<span class="spanBtnDisabled">下一页</span>
		</c:if>


		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

		<%-- 共N页 到M页 --%>
		<span>共${requestScope.pageInfo.pages }页</span> <span>到</span> <input
			type="text" class="inputPageCode" id="pageCode"
			value="${requestScope.pageInfo.pageNum }" /> <span>页</span> <a
			href="javascript:_go();" class="aSubmit">确定</a>
	</div>
</div>