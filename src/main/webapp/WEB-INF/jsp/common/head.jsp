<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
    pageContext.setAttribute("basePath",basePath);    
%>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- ä¸è¿°3ä¸ªmetaæ ç­¾*å¿é¡»*æ¾å¨æåé¢ï¼ä»»ä½å¶ä»åå®¹é½*å¿é¡»*è·éå¶åï¼ -->

<!-- æ° Bootstrap æ ¸å¿ CSS æä»¶ -->
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- jQueryæä»¶ãå¡å¿å¨bootstrap.min.js ä¹åå¼å¥ -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- ææ°ç Bootstrap æ ¸å¿ JavaScript æä»¶ -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!-- jQuery cookieæä½æä»¶ -->
<script src="//cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<!-- jQery countDonwåè®¡æ¶æä»¶  -->
<script src="//cdn.bootcss.com/jquery.countdown/2.1.0/jquery.countdown.min.js"></script>
<!-- 根目录 -->
<script type="text/javascript" src="${basePath}js/modules/main/main.js"></script>

<!-- 弹出框 -->
<script type="text/javascript" src="${basePath}layer/layer.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
