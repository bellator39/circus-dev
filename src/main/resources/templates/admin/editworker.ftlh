<#include "pattern/security.ftlh"/>
<#import "pattern/common.ftlh" as common>
<@common.page>

    <div class="site-banner">
        <div class="banner-content">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="text-content colored">
                            <h1>Редактирование Работника</h1>
                            <div class="breadcum-items mt-2">
                                <span class="item color-primary"><a href="/">Работники /</a></span>
                                <span class="item colored">Редактирование Работника</span>
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
                            <h2>Редактирование работника - ${editWorker.id}</h2>
                            <form name="contactform" action="/manager/edit/worker/${editWorker.id}" method="post"
                                  class="contact-form d-flex flex-wrap mt-4">
                                <div class="text-input flex-container" style="flex-wrap: wrap">
                                    <input type="text" name="name" value="${editWorker.name}"
                                           placeholder="Имя работника" class="name mr-3 mb-3" minlength="5"
                                           maxlength="255" required="required" style="width: 100%">
                                    <input type="text" name="soname" value="${editWorker.soname}"
                                           placeholder="Фамилия работника" class="name mr-3 mb-3" minlength="5"
                                           maxlength="255" required="required" style="width: 100%">
                                    <input type="text" name="work_position" value="${editWorker.work_position}"
                                           placeholder="Должность" class="name mr-3 mb-3" minlength="5"
                                           maxlength="255" required="required" style="width: 100%">

                                    <input type="text" name="link_facebook" value="${editWorker.link_facebook}"
                                           placeholder="Ссылка на facebook" class="name mr-3 mb-3" minlength="5"
                                           maxlength="1024" required="required" style="width: 100%">
                                    <input type="text" name="urlphoto" value="${editWorker.urlphoto}"
                                           placeholder="Ссылка на фото" class="name mr-3 mb-3" minlength="5"
                                           maxlength="1024" required="required" style="width: 100%">
                                    <img width="80" height="50" src="${editWorker.urlphoto}">
                                </div><!--text-input-->
                                <textarea name="describe" placeholder="Описание" style="height: 150px;"
                                          minlength="5" maxlength="2524" required="required">
                                    ${editWorker.describe}
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
            alert('Работник с таким именем и фамилией уже есть! Попробуйте еще раз!')
        </script>
    </#if>
</@common.page>