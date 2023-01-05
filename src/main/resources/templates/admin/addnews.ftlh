<#include "pattern/security.ftlh"/>
<#import "pattern/common.ftlh" as common>
<@common.page>

    <div class="site-banner">
        <div class="banner-content">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="text-content colored">
                            <h1>Добавление новости</h1>
                            <div class="breadcum-items mt-2">
                                <span class="item color-primary"><a href="/">Новости /</a></span>
                                <span class="item colored">Добавление новости</span>
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
                            <h2>Добавление новости</h2>
                            <form name="contactform" action="/moderator/addnews/${currentUserId}" method="post"
                                  class="contact-form d-flex flex-wrap mt-4">
                                <div class="text-input flex-container" style="flex-wrap: wrap">
                                    <input type="text" name="name"
                                           placeholder="Название новости" class="name mr-3 mb-3" minlength="5"
                                           maxlength="255" required="required" style="width: 100%">
                                    <input type="text" name="url" style="width: 100%"
                                           placeholder="Ссылка на логотип" class="name mr-3 mb-3" minlength="5"
                                           maxlength="1500" required="required">
                                    <select name="tag" required="required">
                                        <#list tagList as tl>
                                            <option value="${tl.id}">${tl.tagName}</option>
                                        </#list>
                                    </select>
                                </div><!--text-input-->
                                <textarea name="Text" placeholder="Текст новости" style="height: 150px;"
                                          minlength="5" maxlength="2524" required="required">
                        </textarea>
                                <button type="submit" name="submit">Редактировать</button>
                            </form>
                        </div><!--contact-information-->
                    </div>
                </div>
            </div><!--col-md-6-->
        </div>
    </section>
    <#if message??>
        <script>
            alert('Новость с таким заголовком уже есть! Попробуйте еще раз!')
        </script>

    </#if>
</@common.page>