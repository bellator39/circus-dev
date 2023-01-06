<!DOCTYPE html>
<html lang="en">
<head>
    <title>Circus</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link type="image/png" sizes="16x16" rel="icon" href="/static/publicpage/images/brand3.png">
    <link rel="stylesheet" type="text/css" href="/static/auth/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/static/auth/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="/static/auth/fonts/iconic/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" type="text/css" href="/static/auth/vendor/animate/animate.css">
    <link rel="stylesheet" type="text/css" href="/static/auth/vendor/css-hamburgers/hamburgers.min.css">
    <link rel="stylesheet" type="text/css" href="/static/auth/vendor/animsition/css/animsition.min.css">
    <link rel="stylesheet" type="text/css" href="/static/auth/vendor/select2/select2.min.css">
    <link rel="stylesheet" type="text/css" href="/static/auth/vendor/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" type="text/css" href="/static/auth/css/util.css">
    <link rel="stylesheet" type="text/css" href="/static/auth/css/main.css">
</head>
<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <form class="login100-form validate-form" action="/customer/signup" method="post">
					<span class="login100-form-title p-b-26">
						Добро пожаловать
					</span>
                <span class="login100-form-title p-b-48">
						<i class="zmdi zmdi-accounts"></i>
					</span>
                <div class="wrap-input100 validate-input" data-validate="Имя минимум 5 символов">
                    <input class="input100" type="text" name="name" minlength="5" maxlength="50">
                    <span class="focus-input100" data-placeholder="Имя"></span>
                </div>
                <div class="wrap-input100 validate-input" data-validate="Фамилия минимум 5 символов">
                    <input class="input100" type="text" name="soname" minlength="5" maxlength="50">
                    <span class="focus-input100" data-placeholder="Фамилия"></span>
                </div>
                <div class="wrap-input100 validate-input" data-validate="Логин минимум 5 символов">
                    <input class="input100" type="text" name="username" minlength="5" maxlength="100">
                    <span class="focus-input100" data-placeholder="Логин"></span>
                </div>
                <div class="wrap-input100 validate-input" data-validate="Подходящий email это: a@b.c">
                    <input class="input100" type="text" name="email">
                    <span class="focus-input100" data-placeholder="Email"></span>
                </div>
                <div class="wrap-input100 validate-input" data-validate="Введите пароль">
						<span class="btn-show-pass">
							<i class="zmdi zmdi-eye"></i>
						</span>
                    <input class="input100" type="password" name="password" minlength="8" maxlength="45">
                    <span class="focus-input100" data-placeholder="Пароль"></span>
                </div>

                <div class="container-login100-form-btn">
                    <div class="wrap-login100-form-btn">
                        <div class="login100-form-bgbtn"></div>
                        <button class="login100-form-btn" type="submit">
                            Создать
                        </button>
                    </div>
                </div>

                <div class="text-center p-t-115">
						<span class="txt1">
							Есть аккаунт?
						</span>

                    <a class="txt2" href="/login">
                        Войти
                    </a>
                </div>
            </form>
        </div>
    </div>
</div>
<#if message??>
<script>
    alert('${message}')
</script>
</#if>

<div id="dropDownSelect1"></div>

<script src="/static/auth/vendor/jquery/jquery-3.2.1.min.js"></script>
<script src="/static/auth/vendor/animsition/js/animsition.min.js"></script>
<script src="/static/auth/vendor/bootstrap/js/popper.js"></script>
<script src="/static/auth/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="/static/auth/vendor/select2/select2.min.js"></script>
<script src="/static/auth/vendor/daterangepicker/moment.min.js"></script>
<script src="/static/auth/vendor/daterangepicker/daterangepicker.js"></script>
<script src="/static/auth/vendor/countdowntime/countdowntime.js"></script>
<script src="/static/auth/js/main.js"></script>

</body>
</html>