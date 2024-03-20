@import exercise.dto.posts.EditPostPage
@param EditPostPage page

<!-- BEGIN -->
@template.layout.page(
content = @`
    @if(page.getErrors() != null)
        <div class="mb-3">
            <ul>
                @for(var validator : page.getErrors().values())
                    @for(var error : validator)
                        <li>${error.getMessage()}</li>
                    @endfor
                @endfor
            </ul>
        </div>
    @endif

    <div>
        <form action="/posts/${page.getId()}" method="post">
            <div>
                Название
                <input type="text" class="form-control" name="name" value="${page.getName()}"/>
            </div>
            <div>
                Содержание
                <textarea class="form-control" type="text" name="body">${page.getBody()}</textarea>
            </div>
            <input type="submit" class="btn btn-primary" value="Сохранить"/>
        </form>
    </div>
`
)
<!-- END -->