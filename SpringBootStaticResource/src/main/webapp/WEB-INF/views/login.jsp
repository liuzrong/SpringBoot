<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录界面</title>

<link rel="stylesheet" href="/assets/static/css/jq22.css"/>
</head>
<body>
<!-- begin -->
<div id="login">
    <div class="wrapper">
        <div class="login">
            <form action="#" method="post" class="container offset1 loginform">
                <div id="owl-login">
                    <div class="hand"></div>
                    <div class="hand hand-r"></div>
                    <div class="arms">
                        <div class="arm"></div>
                        <div class="arm arm-r"></div>
                    </div>
                </div>
                <div class="pad">
                    <input type="hidden" name="_csrf" value="9IAtUxV2CatyxHiK2LxzOsT6wtBE6h8BpzOmk="/>
                    <div class="control-group">
                        <div class="controls">
                            <label for="userName" class="control-label fa fa-envelope"></label>
                            <input id="userName" type="text" name="email" placeholder="Email" tabindex="1" autofocus="autofocus" class="form-control input-medium" />
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <label for="password" class="control-label fa fa-asterisk"></label>
                            <input id="password" type="password" name="password" placeholder="Password" tabindex="2" class="form-control input-medium" />
                        </div>
                    </div>
                </div>
                <div class="form-actions"><a href="#" tabindex="5" class="btn pull-left btn-link text-muted">Forgot password?</a><a href="#" tabindex="6" class="btn btn-link text-muted">Sign Up</a>
                    <button type="button" id="doLogin" tabindex="4" class="btn btn-primary">Login</button>
                </div>
            </form>
        </div>
    </div>
    <script src="/assets/static/js/jquery.min.js"></script>
    <script>
    $(function() {
        $('#login #password').focus(function() {
            $('#owl-login').addClass('password');
        }).blur(function() {
            $('#owl-login').removeClass('password');
        });

        //简单登录操作
        $("#doLogin").click(function (e) {
            $.ajax({
                type : "POST",
                url : "/login",
                data : {
                    "userName" : $("#userName").val(),
                    "password" : $("#password").val()
                },
                dataType : "json",
                success : function(data) {
                    if (data.result == "1") {
                        window.location.href ="/learn";
                    } else {
                        alert("账号密码不能为空！");
                    }
                }
            });
        });
    });
    </script>
</div>
<!-- end -->
</body>
</html>