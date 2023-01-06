<#import "pattern/common.ftlh" as common>
<@common.page>

    <div class="site-banner">
        <div class="banner-content">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="text-content colored">
                            <h1>Редактирование пользователя</h1>
                            <div class="breadcum-items mt-2">
                                <span class="item color-primary"><a href="/">Пользователь /</a></span>
                                <span class="item colored">${editCustomer.id}</span>
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
                            <h2>Редактирование пользователя - ${editCustomer.id}</h2>
                            <form name="contactform" action="/admin/edit/customer/${editCustomer.id}" method="post"
                                  class="contact-form d-flex flex-wrap mt-4">
                                <div class="text-input flex-container">
                                    <input type="text" name="name" value="${editCustomer.name}"
                                           placeholder="Имя" class="name mr-3 mb-3" minlength="5"
                                           maxlength="255" required="required">
                                    <input type="text" name="soname" value="${editCustomer.soname}"
                                           placeholder="Фамилия" class="name mr-3 mb-3" minlength="5"
                                           maxlength="255" required="required">
                                    <input type="text" name="username" value="${editCustomer.username}"
                                           placeholder="Имя пользователя" class="name mr-3 mb-3" minlength="5"
                                           maxlength="255" required="required">
                                    <input type="email" name="email" value="${editCustomer.email}"
                                           placeholder="Email" class="name mr-3 mb-3" minlength="5"
                                           maxlength="255" required="required">
                                </div><!--text-input-->
                                <label for="role">Роль в системе</label>
                                <select name="role" required="required" aria-label="role">
                                    <option <#if editCustomer.rolename == "CUSTOMER">selected</#if> value="CUSTOMER">Пользователь</option>
                                    <option <#if editCustomer.rolename == "ADMIN">selected</#if> value="ADMIN">Пользователь</option>
                                    <option <#if editCustomer.rolename == "MODERATOR">selected</#if> value="MODERATOR">Модератор</option>
                                    <option <#if editCustomer.rolename == "MANAGER">selected</#if> value="MANAGER">Менеджер</option>
                                </select>
                                <button type="submit" name="submit">Редактировать</button>
                            </form>
                        </div><!--contact-information-->
                    </div>
                </div>
            </div><!--col-md-6-->
        </div>
    </section>
</@common.page>