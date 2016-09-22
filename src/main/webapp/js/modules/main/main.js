//获取当前网址
var localObj = window.location;
//获取带"/"的项目名
var contextPath = localObj.pathname.split("/")[1];
//获取项目的basePath
var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;

var server_context=basePath;