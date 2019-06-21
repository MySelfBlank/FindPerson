<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<% 
    //进行登录页验证，防止没有登录直接进入此页面
    String username=(String)session.getAttribute("username");
    //username==null说明
    if(username==null){
        out.println("<script>location.href='login.jsp';</script>");
        return;
    } 
%>
<html>

	<head>
		<title>系统主页</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="css/layui.css" />
		<link rel="stylesheet" type="text/css" href="css/layui.mobile.css" />
		<script src="jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="layui.js" type="text/javascript" charset="utf-8"></script>
		<style type="text/css">
			.layui-container {
				display: flex;
				flex-direction: row;
			}
			
			.left {
				flex-grow: 0;
				width: 20%;
			}
			
			.right {
				width: 100%;
			}
		</style>

		<script type="text/javascript">
			function logout() {
				if(confirm('你确认要退出吗')) {
					location.href = 'logoutServlet';
				}
			};
			$(function() {
				//点击“添加新闻“链接的动作
				$("#addNews").bind("click", function() {
					//用AJAX发送GET请求获取“添加新闻”页面
					$.ajax({
						type: 'GET',
						url: 'addPeople.jsp',
						success: function(data) {
							//将“添加新闻”页面的内容插入到页面的“主区域”
							$(".right").html(data);
						}
					});
				});

			});
			$(function() {
				//点击“添加新闻“链接的动作
				$("#listNews").bind("click", function() {
					//用AJAX发送GET请求获取“添加新闻”页面
					$.ajax({
						type: 'GET',
						url: 'ListnewsServlet',
						success: function(data) {
							//将“添加新闻”页面的内容插入到页面的“主区域”
							$(".right").html(data);
						}
					});
				});

			});
			layui.use('element', function() {
				var element = layui.element;
			});
		</script>
	</head>

	<body>
		<div class="layui-header">
			<ul class="layui-nav" lay-filter="">
				<li class="layui-nav-item">
					<a href="javascript:void(0)">
						<h2 style="font-size: 20px;" ;>全国在逃通缉人员查询系统</h2></a>
				</li>
				<li class="layui-nav-item" style="float: right;">
					<a href="javascript:logout()">退出</a>
				</li>
				<li class="layui-nav-item" style="float: right;">
					<a href="javascript:void(0)">
						<span style="font-weight:600"><%=username %></span>&nbsp 你好&nbsp，欢迎登录！</a>
				</li>
			</ul>
		</div>
		<div class="layui-container" style="margin-top: 1%;">
			<div class="left">
				<div style="font-weight:bold;line-height:30px">
					<h2>基础管理</h2></div>
				<div style="line-height:30px">
					<a id="addNews" href="javascript:void(0)" class="layui-btn layui-btn-danger">添加通缉</a>
				</div>
				<br />
				<div style="line-height:30px">
					<a id="listNews" href="javascript:void(0)" class="layui-btn layui-btn-danger">当前通缉</a>
				</div>
			</div>
			<div class="right" style="text-align: center;">
				<span>当前未显示到任何内容</span>
			</div>
		</div>
	</body>

</html>