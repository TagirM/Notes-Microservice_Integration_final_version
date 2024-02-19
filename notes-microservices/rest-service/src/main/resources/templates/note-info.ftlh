<#import "blocks/template.ftlh" as t>
<@t.template>
    <div class="container cards-box-char">
        <hr>
        <div class="card-columns">
            <div class="card text-white bg-dark my-3 product">
                <div class="card-body">
                    <h5 class="card-title">Title: ${result.title}</h5>
                    <p class="card-text">NoteId: ${result.id}</p>
                    <p class="card-text">Content: ${result.content}</p>
                    <p class="card-text">Created at ${result.createTime}</p>
                </div>
            </div>
        </div>
    </div>
</@t.template>