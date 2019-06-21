<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/layui.css" />
		<link rel="stylesheet" href="css/layui.mobile.css" />
		<script src="layui.js" type="text/javascript" charset="utf-8"></script>
		<script src="myjs.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>

		<blockquote class="layui-elem-quote">
			<h1>人员列表</h1>
		</blockquote>
		<form id="SearchForm"  method="post" class="">
			<table border="0" width="100%" height="60" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						统计类型：
						<select name="level">
							<option value="">全部</option>

							<c:forEach items="${classnames}" var="c">
								<option value="${c.id}" <c:if test="${c.id==id}">selected='selected'</c:if>>${c.level}</option>
							</c:forEach>

						</select>
						<div class="layui-row">
						
						
						内容：
						<br />
						<input type="text" class="layui-input" name="peopletitle" value="${peopletitle}" />
						</div>
						

						<a href="javascript:void(0);" id="SearchBtn" class="layui-btn">搜&nbsp索</a>
					</td>
				</tr>
			</table>
		</form>
		<table class="layui-table">
			<colgroup>


			</colgroup>
			<tr>
				<td>姓名</td>
				<td>性别</td>
				<td>住址</td>
				<td>证件号</td>
				<td>发布时间</td>
				<td>通缉等级</td>
				<td>详情</td>
				<td>操作</td>
				<td>id</td>
			</tr>
			<c:forEach items="${peoplelist}" var="r">
				<tr>
					<td>${r.name}</td>
					<td>${r.sex}</td>
					<td>${r.home}</td>
					<td>${r.idcard}</td>
					<td>${r.time}</td>
					<td>${r.level}</td>
					<td>${r.details}</td>
					
					
					<td>
						<div class="layui-row">
							<a href="javascript:sendAjaxNoParam('EditNewsServlet?id=${r.id}','post')" class="layui-btn layui-btn-xs">修改</a>
							<br />
							<a href="javascript:ajaxDel('DeleteNewsServlet?id=${r.id}','post','ListnewsServlet') " class="layui-btn layui-btn-danger layui-btn-xs">删除</a>
						</div>


					</td>
					<td>${r.id}</td>
				</tr>

			</c:forEach>

		</table>
		<script>
// 			function toPge(pageno,url) {
// 				
// 					//var f = document.getElementById("pageform");
// 					//f.action = "ListnewsServlet?pageno=" + pageno;
// 					
// 					$.ajax({
// 						type: 'POST',
// 						url: url+"&pageno="+pageno ,
// 						data: $('#SearchForm').serialize(),
// 						success: function(data) {
// 						$("#right").html(data);
// 							}
// 						});
// 
// 
// 					//f.submit();
// 				}
// 
//搜索用的AJAX
			$("#SearchBtn").bind("click",function(){  
				$.ajax({
					 type: 'POST',
					 url: 'ListnewsServlet',
					 data: $('#SearchForm').serialize(),		//表单序列化 
					 success: function(data) {
						alert(data);
						$(".right").html(data);
					 }
				});
				
			});
				//function del(id) {
					//if (confirm('你确定要删除')) {
						//location.href = 'delNewsServlet?id=' + id;
					//}
				//}
		</script>
		<div style="text-align:center">

			<form id="pageform" method="post">

				<input name="classnameid" type="hidden" value="${level}" />
				<input name="peopletitle" type="hidden" value="${peopletitle}" />



				共找到条${totalcount}记录，当前第${pageno}页，共${totalpage}页

				<c:if test="${pageno=='1'}">首页</c:if>
				<c:if test="${pageno!='1'}">
					<a href="javascript:toPage('1','ListnewsServlet')">首页</a>
				</c:if>


				<c:if test="${pageno=='1'}">上一页</c:if>
				<c:if test="${pageno!='1'}">
					<a href="javascript:toPage('${pageno-1}','ListnewsServlet')">上一页</a>
				</c:if>


				<c:if test="${pageno==totalpage}">下一页</c:if>
				<c:if test="${pageno!=totalpage}">
					<a href="javascript:toPage('${pageno+1}','ListnewsServlet')">下一页</a>
				</c:if>

				<c:if test="${pageno==totalpage}">尾页</c:if>
				<c:if test="${pageno!=totalpage}">
					<a href="javascript:toPage('${totalpage}','ListnewsServlet')">尾页</a>
				</c:if>
			</form>

		</div>
	</body>

</html>
