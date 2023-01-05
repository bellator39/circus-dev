<#import "pattern/common.ftlh" as common>
<@common.page>

    <div class="site-banner">
        <div class="banner-content">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="text-content colored">
                            <h1>Редактирование новости</h1>
                            <div class="breadcum-items mt-2">
                                <span class="item color-primary"><a href="/">Новость /</a></span>
                                <span class="item colored">${editNews.newsName}</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <section class="contact-information padding-large mt-3">
        <div class="container">
            <div class="col-md-8 p-0">
                <div class="container">
                    <div class="row">
                        <div class="contact-information col-md-12">
                            <h2>Редактирование новости - ${editNews.id}</h2>
                            <form name="contactform" action="/moderator/edit/${editNews.id}" method="post"
                                  class="contact-form d-flex flex-wrap mt-4">
                                <div class="text-input flex-container">
                                    <input type="text" name="name" value="${editNews.newsName}"
                                           placeholder="Название новости" class="name mr-3 mb-3" minlength="5"
                                           maxlength="255" required="required">
                                    <input type="text" name="url" value="${editNews.urllogonews}"
                                           placeholder="Ссылка на логотип" class="name mr-3 mb-3" minlength="5"
                                           maxlength="1500" required="required">
                                    <img width="80" height="50" src="${editNews.urllogonews}">
                                </div><!--text-input-->
                                <textarea name="Text" placeholder="Текст новости" style="height: 150px;"
                                          minlength="5" maxlength="2524" required="required">
                            ${editNews.newsText}
                        </textarea>
                                <button type="submit" name="submit">Редактировать</button>
                            </form>
                        </div><!--contact-information-->
                    </div>
                </div>
            </div><!--col-md-6-->
        </div>
    </section>
</@common.page>