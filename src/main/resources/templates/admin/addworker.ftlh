<#include "pattern/security.ftlh"/>
<#import "pattern/common.ftlh" as common>
<@common.page>

    <div class="site-banner">
        <div class="banner-content">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="text-content colored">
                            <h1>Добавление Работника</h1>
                            <div class="breadcum-items mt-2">
                                <span class="item color-primary"><a href="/">Работники /</a></span>
                                <span class="item colored">Добавление Работника</span>
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
                            <h2>Добавление работника</h2>
                            <form name="contactform" action="/manager/addworker" method="post"
                                  class="contact-form d-flex flex-wrap mt-4">
                                <div class="text-input flex-container" style="flex-wrap: wrap">
                                    <input type="text" name="name"
                                           placeholder="Имя работника" class="name mr-3 mb-3" minlength="5"
                                           maxlength="255" required="required" style="width: 100%">
                                    <input type="text" name="soname"
                                           placeholder="Фамилия работника" class="name mr-3 mb-3" minlength="5"
                                           maxlength="255" required="required" style="width: 100%">
                                    <input type="text" name="work_position"
                                           placeholder="Должность" class="name mr-3 mb-3" minlength="5"
                                           maxlength="255" required="required" style="width: 100%">

                                    <input type="text" name="link_facebook"
                                           placeholder="Ссылка на facebook" class="name mr-3 mb-3" minlength="5"
                                           maxlength="1024" required="required" style="width: 100%">
                                    <input type="text" name="urlphoto"
                                           placeholder="Ссылка на фото" class="name mr-3 mb-3" minlength="5"
                                           maxlength="1024" required="required" style="width: 100%">
                                </div><!--text-input-->
                                <textarea name="describe" placeholder="Описание" style="height: 150px;"
                                          minlength="5" maxlength="2524" required="required">
                                     </textarea>
                                <button type="submit" name="submit">Добавить</button>
                            </form>
                        </div><!--contact-information-->
                    </div>
                </div>
            </div><!--col-md-6-->
        </div>
    </section>
    <#if message??>
        <script>
            alert('Работник с таким именем и фамилией уже есть! Попробуйте еще раз!')
        </script>
    </#if>
</@common.page>