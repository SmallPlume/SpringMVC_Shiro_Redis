var index = {
		url:{
			viewUrl : basePath + "/user/view",
			editUrl : basePath + "/user/edit",
			deltUrl : basePath + "/user/delt",
			kickUrl : basePath + "/user/kick",
		},
		init:function(){
			$("#view").click(function(){
				index.openShow(viewUrl, "查看信息");
			});
			$("#edit").click(function(){
				index.openShow(editUrl, "修改信息");
			});
		},
		//弹出窗
		openShow:function(url,title){
			layer.open({
				type: 2,
				area: ["700px", "530px"],
				fix: false, //不固定
				maxmin: true,
				title: title,
				content: url,
				success: function(layero, index) {
					//回填参数
					//console.log(layero, index);
				}
			});
		},
		//踢出登录用户
		kickout: function(id){
			if(id!=null || id!=""){
				$.post(index.url.kickUrl,{"id":id},function(r){
					if(r.code<0){
						return alert(r.msg,"error");
					}else{
						//刷新当前页面
						window.location.reload();
					}
				});
			}
		}
};