<#import "pattern/common.ftlh" as common>
<@common.page>
    <div class="site-banner">
        <div class="banner-content">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="text-content colored">
                            <h1>Обратная связь</h1>
                            <div class="breadcum-items mt-2">
                                <span class="item color-primary"><a href="/">Обратная связь /</a></span>
                                <span class="item colored">Список обратной связи</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div style="display:block; margin: 0 auto; max-width: 1050px; margin-top: 50px" class="table-responsive">
        <#if contactList?size gt 0>
        <table class="table table-dark">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Имя</th>
                <th scope="col">Фамилия</th>
                <th scope="col">Email</th>
                <th scope="col">Message</th>
                <th scope="col">Дата отправки</th>
                <th scope="col">Удалить</th>
            </tr>
            </thead>
            <tbody>
                <#list contactList as ns>
                    <tr>
                        <th scope="row">${ns?index}</th>
                        <td>${ns.name}</td>
                        <td style="    height: 134px;
    overflow: hidden;
    display: -webkit-box;
    -webkit-line-clamp: 4;
    -webkit-box-orient: vertical;">${ns.soname}</td>
                        <td>${ns.email}</td>
                        <td>${ns.message}</td>
                        <td>${ns.date_send}</td>
                        <td><a href="/manager/feedback/delete/${ns.id}" class="btn-danger">Удалить</a></td>
                    </tr>
                </#list>
            </tbody>
        </table>
            <#else>
            <p>На данный момент обратной связи нет.</p>
        </#if>
    </div>
</@common.page>