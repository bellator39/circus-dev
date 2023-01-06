<#import "pattern/common.ftlh" as common>
<@common.page>

    <div class="site-banner">
        <div class="banner-content">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="text-content colored">
                            <h1>Работники</h1>
                            <div class="breadcum-items mt-2">
                                <span class="item color-primary"><a href="/">Работники /</a></span>
                                <span class="item colored">Список работников</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div style="display:block; margin: 0 auto; max-width: 1050px; margin-top: 50px" class="table-responsive">
        <#if customerList?size gt 0>
            <table class="table table-dark">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Имя</th>
                    <th scope="col">Фамилия</th>
                    <th scope="col">Имя пользователя</th>
                    <th scope="col">Email</th>
                    <th scope="col">Роль</th>
                    <th scope="col">Дата регистрации</th>
                    <th scope="col">Изменить</th>
                </tr>
                </thead>
                <tbody>
                <#list customerList as ts>
                    <tr>
                        <th scope="row">${ts?index}</th>
                        <td>${ts.name}</td>
                        <td>${ts.soname}</td>
                        <td>${ts.username}</td>
                        <td>${ts.email}</td>
                        <td>${ts.rolename.name()}</td>
                        <td>${ts.date_registration}</td>
                        <td><a href="/admin/edit/customer/${ts.id}" class="btn-accent">Редактировать</a></td>
                    </tr>
                </#list>
                </tbody>
            </table>
        <#else>
            <p>На данный момент пользователей нет.</p>
        </#if>
    </div>
</@common.page>