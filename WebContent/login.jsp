<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>

	<head>
		<title>用户登录</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="css/layui.css" />
		<link rel="stylesheet" href="css/layui.mobile.css" />
		<script src="layui.js" type="text/javascript" charset="utf-8"></script>
		<script src="jquery-1.11.3.min.js"></script>
		<script type="text/javascript">
			$(function() {
				//“登录”的单击动作
				$("#login").bind("click", function() {
					var username = $("#username");
					var password = $("#password");
					//验证通过后，用AJAX提交请求
					$.ajax({
						type: 'POST',
						url: 'ajaxProcess.jsp',
						data: {
							username: $.trim(username.val()),
							password: $.trim(password.val())
						},
						success: function(data) {
							//data代表服务端返回的数据
							if($.trim(data) == "1") { //登录成功，跳转到系统主页
								location.href = "success.jsp";
							} else { //登录失败
								$("#tipinfo").html("用户名或密码错误");
							}
						}
					});
				});
			});
			layui.use('form', function() {
				var form = layui.form; //初始化表单，并进行监听

			});
		</script>

	</head>

	<body style="background-image:url(images/BG.jpg); background-repeat:no-repeat; ">
		<div class="layui-row layui-col-md-offset6" style="margin-top: 15%;">
			<div class="layui-container" style="padding-top: 45px; width: 350px; height: 400px; background-color: rgba(255,255,255,0.7);">
				<div class="layui-row" >
					<blockquote class="layui-elem-quote">用户登录</blockquote>
					<br />
					<div class="layui-form">
						<div class="layui-form-item">
							<label class="layui-form-label">账号：</label>
							<div class="layui-input-block">
								<input id="username" type="text" name="username" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
							</div>
						</div>
						<br />
						<div class="layui-form-item">
							<label class="layui-form-label">密码：</label>
							<div class="layui-input-block">
								<input id="password" type="password" name="password" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
							</div>
						</div>
						<br />
						<div class="layui-form-item">
							<div class="layui-input-block">
								<button id="login" class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</body>

</html>