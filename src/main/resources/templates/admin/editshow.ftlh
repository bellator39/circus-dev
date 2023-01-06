<#include "pattern/security.ftlh"/>
<#import "pattern/common.ftlh" as common>
<@common.page>

    <div class="site-banner">
        <div class="banner-content">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="text-content colored">
                            <h1>Редактирование Шоу</h1>
                            <div class="breadcum-items mt-2">
                                <span class="item color-primary"><a href="/">Шоу /</a></span>
                                <span class="item colored">Редактирование Шоу</span>
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
                            <h2>Редактирование представления</h2>
                            <form name="contactform" action="/admin/edit/show/${editShow.id}" method="post"
                                  class="contact-form d-flex flex-wrap mt-4">
                                <div class="text-input flex-container" style="flex-wrap: wrap">
                                    <input type="text" name="name" value="${editShow.name}"
                                           placeholder="Название шоу" class="name mr-3 mb-3" minlength="5"
                                           maxlength="255" required="required" style="width: 100%">
                                    <input type="text" name="countticket" value="${editShow.countAvailableTicket}"
                                           placeholder="Количество билетов" class="name mr-3 mb-3" min="50"
                                           max="500" required="required" style="width: 100%">
                                    <input type="number" name="price" value="${price}"
                                           placeholder="Цена за билет" class="name mr-3 mb-3" min="10" step="0.01"
                                           max="150" required="required" style="width: 100%">
                                    <input type="text" name="urlphoto" value="${editShow.urlPathLogoPhoto}"
                                           placeholder="Ссылка на фото" class="name mr-3 mb-3" minlength="5"
                                           maxlength="1024" required="required" style="width: 100%">
                                    <input type="datetime-local" name="datetime" value="${editShow.dateShow}"
                                           placeholder="Ссылка на фото" class="name mr-3 mb-3" minlength="5"
                                           maxlength="1024" required="required" style="width: 100%">
                                </div><!--text-input-->
                                <textarea name="describe" placeholder="Описание" style="height: 150px;"
                                          minlength="5" maxlength="2524" required="required">
                                    ${editShow.describe}
                                     </textarea>
                                <label for="typeshow">Тип шоу:</label>
                                <select name="typeshow" required="required">
                                    <option <#if editShow.typeShow==1>selected</#if> value="1">Шоу с животными</option>
                                    <option <#if editShow.typeShow==2>selected</#if> value="2">Шоу с музыкой</option>
                                    <option <#if editShow.typeShow==3>selected</#if> value="3">Шоу с огнем</option>
                                </select>
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
            alert('Шоу с таким название уже есть! Попробуйте еще раз!')
        </script>
    </#if>
</@common.page>