<%--
  Created by IntelliJ IDEA.
  User: 陈浩翔
  Date: 2017/3/6
  Time: 下午 8:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>演示动态验证码</title>
    <script type="text/javascript">
        var path = "${pageScope.basePath}";
//        function changImg() {
//            var img = document.getElementById("servletImg");
//            var time = new Date().getTime();
//            //如果没有这个,下面的img.src = path + "gifCaptcha?" + time;不会起作用，因为浏览器的缓存技术，图片可能并不会刷新
//            img.src = "";
//            //解决火狐下验证码刷不出的问题
//            img.src = path + "gifCaptcha?" + time;
//            //?号后面的东西是通过get方式传递的
//        }

        //这样也可以解决火狐下验证码刷不出的问题，但是页面会晃动
        function changImg() {
            var a = document.getElementById("Imga");
            var time = new Date().getTime();
            var src = path + "gifCaptcha?" + time;
            a.innerHTML="<img id='servletImg' src="+src+" alt='UIFuture验证码'/>";
        }
    </script>
</head>
<body>
演示动态验证码：
<a onclick="javascript:changImg();" href="javascript:void(0);" id="Imga">
    <img id="servletImg" src="gifCaptcha" alt="UIFuture验证码"/>
</a>
</body>
</html>