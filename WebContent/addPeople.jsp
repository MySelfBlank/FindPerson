<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>

	<head>
		<title>添加通缉</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="css/layui.mobile.css" type="text/css" rel="stylesheet" />
		<link rel="stylesheet" type="text/css" href="css/layui.css" />
		<script src="jquery-1.11.3.min.js"></script>
		<script src="layui.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="myjs.js"></script>
		<script type="text/javascript">
			layui.use('form', function() {
				var form = layui.form;

				});
			layui.use('laydate', function() {
				var laydate = layui.laydate;
				laydate.render({
					elem: '#adddate'

				});

			});
		</script>

		<style type="text/css">
			div #img {
				display: block;
				width: 45px;
				height: 45px;
				margin: 0;
				border-radius: 2px;
			}
		</style>
	</head>

	<body>
		<div class="layui-main">
			<div class="" style="margin-left: 5px;">
				<blockquote class="layui-elem-quote">添加通缉</blockquote>
				<div class="layui-form">
					<div class="layui-form-item">
						<label class="layui-form-label">照片：</label>
						<div class="layui-input-inline">
							<svg id="img" height="512pt" viewBox="0 0 512 512" width="512pt" xmlns="http://www.w3.org/2000/svg">
								<path d="m406 332.820312-60 89.589844 60 89.589844h106v-60c0-61.433594-46.40625-112.222656-106-119.179688zm0 0" fill="#0a77e8" />
								<path d="m392 332h-19.796875l-176.203125 60 60 120h150v-179.179688c-4.59375-.535156-9.265625-.820312-14-.820312zm0 0" fill="#0f9af0" />
								<path d="m0 452v60h106l60-89.589844-60-89.589844c-59.59375 6.957032-106 57.746094-106 119.179688zm0 0" fill="#0f9af0" />
								<path d="m139.796875 332h-19.796875c-4.734375 0-9.40625.285156-14 .820312v179.179688h150v-120zm0 0" fill="#13bdf7" />
								<path d="m372.203125 332h-116.203125l-30 45 30 45c55.8125 0 102.847656-38.300781 116.203125-90zm0 0" fill="#fdad86" />
								<path d="m216 24.441406 40 277.558594c66.167969 0 120-53.832031 120-120v-62zm0 0" fill="#fdad86" />
								<path d="m183.503906 24.441406c-28.84375 21.9375-47.503906 56.605469-47.503906 95.558594v62c0 66.167969 53.832031 120 120 120v-277.558594zm0 0" fill="#fdd396" />
								<path d="m256 0-30 55.617188 30 55.617187c13.902344 5.648437 29.09375 8.765625 45 8.765625h75c0-66.167969-53.832031-120-120-120zm0 0" fill="#b23c42" />
								<path d="m256 111.234375v-111.234375c-27.214844 0-52.339844 9.113281-72.496094 24.441406 8.207032 39.492188 35.878906 71.929688 72.496094 86.792969zm0 0" fill="#d55533" />
								<path d="m256 422v-90h-116.203125c13.355469 51.699219 60.390625 90 116.203125 90zm0 0" fill="#fdd396" />
							</svg>
							<!--<input id="name" type="text" name="title" required lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">-->
						</div>

					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">姓名：</label>
						<div class="layui-input-block">
							<input id="name" type="text" name="name" required lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
						</div>

					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">性别：</label>
						<div class="layui-input-block">
							<select id="sex" name="sex" lay-verify="required">
								<option value=""></option>
								<option value="0">男</option>
								<option value="1">女</option>

							</select>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">证件：</label>
						<div class="layui-input-inline">
							<input id="idcard" type="text" name="idcard" required lay-verify="required" placeholder="请输入证件号" autocomplete="off" class="layui-input">
						</div>
						<div class="layui-form-mid layui-word-aux">身份证/护照</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">家庭住址：</label>
						<div class="layui-input-inline">
							<input id="home" type="text" name="home" required lay-verify="required" placeholder="请输入住址" autocomplete="off" class="layui-input">
						</div>
						<div class="layui-form-mid layui-word-aux">请具体</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">发布时间：</label>
						<div class="layui-input-block">
							<input id="adddate" type="text" name="adddate" required lay-verify="required" placeholder="请输入发布时间" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">级别：</label>
						<div class="layui-input-block">
							<select id="level" name="level" lay-verify="required">
								<option value=""></option>
								<option value="0">一级通缉</option>
								<option value="1">二级通缉</option>
								<option value="2">三级通缉</option>
								<option value="3">四级通缉</option>
							</select>
						</div>
					</div>
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">详情：</label>
						<div class="layui-input-block">
							<textarea id="detail" name="detail" placeholder="请输入内容" class="layui-textarea"></textarea>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-input-block">
							<button id="addNewsBtn" class="layui-btn layui-btn-danger" lay-submit lay-filter="formDemo">立即提交</button>
							<div id="tipinfo"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>

</html>