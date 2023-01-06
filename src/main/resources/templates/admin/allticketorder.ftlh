<#import "pattern/common.ftlh" as common>
<@common.page>

    <div class="site-banner">
        <div class="banner-content">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="text-content colored">
                            <h1>Заказы</h1>
                            <div class="breadcum-items mt-2">
                                <span class="item color-primary"><a href="/">Заказы /</a></span>
                                <span class="item colored">Список заказов</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div style="display:block; margin: 0 auto; max-width: 1050px; margin-top: 50px" class="table-responsive">
        <#if today??>
         <a style="margin-bottom: 30px" class ="btn btn-accent" href="javascript:(print());"> <i class="icon icon-printer"></i>Распечатать</a>
        </#if>
        <a style="margin-bottom: 30px" class="btn btn-accent" href="/manager/allticketorder/today">Билеты на сегодня <i class="icon icon-calendar"></i></a>
        <#if ticketOrder?size gt 0>
        <table class="table table-dark">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Номер шоу</th>
                <th scope="col">Фамилия и имя</th>
                <th scope="col">Дата покупки</th>
                <th scope="col">Количество билетов</th>
                <th scope="col">Уникальный номер</th>
                <th scope="col">Сумма заказа</th>
                <th scope="col">Статус</th>
                <th scope="col">Изменить статус</th>
            </tr>
            </thead>
            <tbody>
                <#list ticketOrder as ts>
                    <tr>
                        <th scope="row">${ts?index}</th>
                        <td>${ts.idShow}</td>
                        <td>${customerService.getCustomerById(ts.idCustomer).getName() + " " + customerService.getCustomerById(ts.idCustomer).getSoname()}</td>
                        <td>${ts.dateBuy}</td>
                        <td>${ts.countTicket}</td>
                        <td>${ts.uuid_order}</td>
                        <td>${ts.summa_order}</td>
                        <td style="color: <#if ts.status?string=='ОБРАБОТКА'>yellow<#else>green</#if>">${ts.status}</td>
                        <td><a href="/moderator/testimonals/delete/${ts.id}" class="btn-danger">Изменить</a></td>
                    </tr>
                </#list>
            </tbody>
        </table>
            <#else>
            <p>На данный момент заказов нет.</p>
        </#if>
    </div>
</@common.page>