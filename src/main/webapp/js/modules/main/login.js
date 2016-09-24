var login = {
	url:{
		login_url : basePath+"/login",
		index_url : basePath+"/index"
	},
	init:function(){
		//鼠标点击登录事件
		$("#submitbtn").click(function(){
			login.login();
		});
	},
	//登录方法
	login:function(){
		if(!login.validate()) return;
		var params = $("#form").serializeArray();
		$.post(login.url.login_url,params,function(result){
			if(result.code==-1){
				$("#info").html(result.msg);
			}else{
				//登录验证成功
				location.href = login.url.index_url;
			}
		});
	},
	//验证
	validate:function(){
		var userName = $("#username").val();
		var password = $("#password").val();
		if(userName.length==0 || password.length==0){
			$("#info").html("帐号或密码不能为空！");
			return false;
		}
		return true;
	}
};