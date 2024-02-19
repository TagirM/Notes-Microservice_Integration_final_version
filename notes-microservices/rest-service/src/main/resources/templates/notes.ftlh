<#import "blocks/template.ftlh" as t>
<@t.template>
    <h3 style="text-align: left">Поиск заметок по имени</h3><hr>
    <form action="/rest-service" method="get">
        <div class="form-row">
            <div class="form-group col-md-10">
                <input type="text" name="search" <#if search??>value="${search}"</#if> class="form-control"
                       id="search">
            </div>
            <button style="width: 100%" type="submit" class="btn btn-dark">Поиск</button>
        </div>
    </form>
    <hr>
    <div class="card-columns">
        <#list results as result>
            <a href="/rest-service/${result.id}" class="product-link">
                <div class="card text-white bg-dark my-3 product">
                    <div class="card-body">
                        <h5 class="card-title">Title: ${result.title}</h5>
                    </div>
                </div>
            </a>
        <#else>
            <h1 style="text-align: center">Не найдено</h1>
        </#list>
    </div>
</@t.template>