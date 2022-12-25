<#import "patterns/common.ftlh" as common>
<@common.page>
    <div class="site-banner">
        <div class="banner-content">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="text-content colored">
                            <h1>Контакт с нами</h1>
                            <div class="breadcum-items">
                                <span class="item color-primary"><a href="#">Главная /</a></span>
                                <span class="item colored">Контакты</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div><!--site-banner-->

    <section class="contact-information padding-large mt-3">
        <div class="container">
            <div class="row">
                <div class="col-md-6 p-0 mb-3">
                    <div class="container">
                        <h2>Конткаты</h2>

                        <div class="contact-detail d-flex flex-wrap mt-4">
                            <div class="detail mr-6 mb-4">
                                <h3>Телефоны</h3>
                                <ul class="list-unstyled">
                                    <li><i class="icon icon-phone"></i>+375-33-3280891</li>
                                    <li><i class="icon icon-phone"></i>+375-33-3280891</li>
                                </ul>
                            </div><!--detail-->
                            <div class="detail mb-4">
                                <h3>Emails</h3>
                                <ul class="list-unstyled">
                                    <li><i class="icon icon-envelope-o"></i>
                                        <a href="mailto:egorgurinovich@gmail.com">egorgurinovich@gmail.com</a></li>
                                    <li><i class="icon icon-envelope-o"></i>
                                        <a href="mailto:egorgurinovich@gmail.com">egorgurinovich@gmail.com</a></li>
                                </ul>
                            </div><!--detail-->
                            <div class="address detail mb-4">
                                <h3>Адрес</h3>
                                <ul class="list-unstyled">
                                    <li><i class="icon icon-map-marker"></i>
                                        North Melbourne VIC 3051, Australia</li>
                                    <li><i class="icon icon-map-marker"></i>
                                        North Melbourne VIC 3051, Australia</li>
                                </ul>
                            </div><!--detail-->
                            <div class="detail mb-4">
                                <h3>Социальные сети</h3>
                                <div class="social-links flex-container">
                                    <a href="#" class="icon icon-facebook"></a>
                                    <a href="#" class="icon icon-twitter"></a>
                                    <a href="#" class="icon icon-pinterest-p"></a>
                                    <a href="#" class="icon icon-youtube"></a>
                                    <a href="#" class="icon icon-linkedin"></a>
                                </div><!--social-links-->
                            </div><!--detail-->

                        </div><!--contact-detail-->
                    </div>
                </div><!--col-md-6-->

                <div class="col-md-6 p-0">
                    <div class="container">
                        <div class="row">
                            <div class="contact-information col-md-12">
                                <h2>Свяжитесь с нами</h2>
                                <form name="contactform" action="/contactus" method="post" class="contact-form d-flex flex-wrap mt-4">
                                    <div class="text-input flex-container">
                                        <input type="text" name="name" placeholder="Имя" class="name mr-3 mb-3" minlength="5" required="required">
                                        <input type="text" name="soname" placeholder="Фамилия" class="name mr-3 mb-3" minlength="5" required="required">
                                        <input type="email" name="email" placeholder="E-mail" class="mb-3" minlength="5" required="required">
                                    </div><!--text-input-->
                                    <textarea name="message" placeholder="Сообщение" style="height: 150px;" minlength="5"></textarea>
                                    <button type="submit" name="submit">Отправить</button>
                                </form>
                            </div><!--contact-information-->
                        </div>
                    </div>
                </div><!--col-md-6-->

            </div>
        </div>
    </section>
    <#if message??>
    <script>
        alert('Ваше сообщение отправленно! Спасибо, что Вы с нами!')
    </script>
    </#if>
    <section class="google-map">
        <div class="mapouter"><div class="gmap_canvas"><iframe width="100%" height="500" id="gmap_canvas" src="https://maps.google.com/maps?q=2880%20Broadway,%20New%20York&t=&z=13&ie=UTF8&iwloc=&output=embed" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"></iframe><a href="https://getasearch.com/fmovies"></a><br><style>.mapouter{position:relative;text-align:right;height:500px;width:100%;}</style><a href="https://www.embedgooglemap.net">embedgooglemap.net</a><style>.gmap_canvas {overflow:hidden;background:none!important;height:500px;width:100%;}</style></div></div>
    </section>
</@common.page>