<#import "patterns/common.ftlh" as common>
<@common.page>
    <div class="site-banner">
        <div class="banner-content">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="text-content colored">
                            <h1>Оставьте свой отзыв</h1>
                            <div class="breadcum-items">
                                <span class="item color-primary"><a href="#">Отзыв /</a></span>
                                <span class="item colored">Отзыв</span>
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
                                        North Melbourne VIC 3051, Australia
                                    </li>
                                    <li><i class="icon icon-map-marker"></i>
                                        North Melbourne VIC 3051, Australia
                                    </li>
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
                                <h2>Ваш отзыв</h2>
                                <form name="contactform" action="/circusshow/testimonals" method="post"
                                      class="contact-form d-flex flex-wrap mt-4">
                                    <div class="text-input flex-container">
                                        <input type="text" name="name" placeholder="Имя" class="name mr-3 mb-3"
                                               minlength="5" required="required">
                                        <input type="text" name="soname" placeholder="Фамилия" class="name mr-3 mb-3"
                                               minlength="5" required="required">
                                    </div><!--text-input-->
                                    <textarea name="text" placeholder="Сообщение" style="height: 150px;"
                                              minlength="5"></textarea>
                                    <label for="rating">Ваша оценка</label>
                                    <select name="rating">
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                    </select>
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
</@common.page>