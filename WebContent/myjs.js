$( function() {
	var name = $("#name");
	var sex = $("#sex");
	var idcard = $("#idcard");
	var home = $("#home");
	var time = $("#adddate");
	var level = $("#level");
	var detail = $("#detail");
	var layer = layui.layer;
	//添加新闻“保存”的单击动作
	$("#addNewsBtn").bind("click", function() {

		//验证通过后，用AJAX提交请求
		$.ajax({
			type: 'POST',
			url: 'AddNewsServlet',
			data: {
				name: $.trim(name.val()),
				sex: $.trim(sex.val()),
				idcard: $.trim(idcard.val()),
				home: $.trim(home.val()),
				time: $.trim(time.val()),
				level: $.trim(level.val()),
				detail: $.trim(detail.val())
			},
			success: function(data) {
				//data代表服务端返回的数据
				if($.trim(data) == "1") { //添加成功
					//设置提示信息为绿色
					$("#tipinfo").css("color", "green");
					
					$("#tipinfo").html("添加成功");
					//等待3秒后，重新用AJAX加载“添加新闻”页面
					
					setTimeout('ajaxLoadAddNewsPage()',3000);
					
				} else { //添加失败
					$("#tipinfo").html("添加失败");
				}
			}
		});
	});

});
$( function() {
	var name = $("#name");
	var sex = $("#sex");
	var idcard = $("#idcard");
	var home = $("#home");
	var time = $("#adddate");
	var level = $("#level");
	var detail = $("#detail");
	var id=$("#id").val();
	var layer = layui.layer;
	//添加新闻“保存”的单击动作
	$("#updateNewsBtn").bind("click", function() {

		//验证通过后，用AJAX提交请求
		$.ajax({
			type: 'POST',
			url: 'UpdateNewsServlet',
			data: {
				
				name: $.trim(name.val()),
				sex: $.trim(sex.val()),
				idcard: $.trim(idcard.val()),
				home: $.trim(home.val()),
				time: $.trim(time.val()),
				level: $.trim(level.val()),
				detail: $.trim(detail.val()),
				id:id
			},
			success: function(data) {
				//data代表服务端返回的数据
				if($.trim(data) == "1") { //添加成功
					//设置提示信息为绿色
					$("#tipinfo").css("color", "green");
					
					$("#tipinfo").html("添加成功");
					//等待3秒后，重新用AJAX加载“添加新闻”页面
					
					setTimeout('ajaxLoadAddNewsPage()',3000);
					
				} else { //添加失败
					$("#tipinfo").html("添加失败");
				}
			}
		});
	});

});
//用AJAX重加载“添加新闻”页面
function ajaxLoadAddNewsPage() {
	$.ajax({
		type: 'GET',
		url: 'addPeople.jsp',
		success: function(data) {
			$("#right").html(data);
		}
	});
}
//分页
function toPage(page,url){
	$.ajax({
			 type: 'GET',
			 url: url+"?pageno="+page ,
			 data: $('#SearchForm').serialize(),		 
			 success: function(data) {
				alert(data);
				$(".right").html(data);
			 }
	});
	//alert(data);
}

//删除
function ajaxDel(url,method,returnurl){	
	if(confirm('你确认要删除吗？')){
		$.ajax({
			 type: method,
			 url: url ,
			 success: function(data) {
				  var msg="删除失败";
				  //data代表服务端返回的数据
				  if($.trim(data)=="1"){//删除成功
					 msg='删除成功';
				  }
				  alert(msg);
				  //ajaxLoadListNewsPage();
				  ajaxLoadPage(returnurl)
			 }
	    });
	}
}

//加载任意界面
function ajaxLoadPage(pageurl){
//	$.ajax({
//		type: 'GET',
//		url: 'ListnewsServlet',
//		success: function(data) {
//			//将“添加新闻”页面的内容插入到页面的“主区域”
//			$(".right").html(data);
//		}
//	});
	$.ajax({
		 type: 'GET',
		 url: pageurl ,
		 success: function(data) {
			  alert(data);
			  $(".right").html(data);
			  
		 }
	 });	
}
function sendAjaxNoParam(url,method){
	$.ajax({
			 type: method,
			 url: url ,
			 success: function(data) {
				  $(".right").html(data);
			 }
	});
}
//搜索 
//$("#SearchBtn").bind("click",function(){  
//	   $.ajax({
//			 type: 'POST',
//			 url: 'ListNewsServlet' ,
//			 data: $('#SearchForm').serialize(),
//			 success: function(data) {
//				  //将“添加新闻”页面的内容插入到页面的“主区域”
//				  alert(data);
//				  $(".right").html(data);
//			 }
//		});
//});