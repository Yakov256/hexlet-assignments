@import exercise.dto.posts.BuildPostPage
@param BuildPostPage page

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

        <div class="mx-auto p-4 py-md-5">
            <form action="/posts" method="post">
                <div>
                    <label class="form-label">
                        Название
                        <input type="text" class="form-control" name="name" value="${page.getName()}"/>
                    </label>
                </div>
                <div>
                    <label class="form-label">Содержание</label>
                    <textarea class="form-control" type="text" name="body">${page.getBody()}</textarea>
                </div>
                <input type="submit" class="btn btn-primary" value="Сохранить"/>
            </form>
        </div>
    `,
)
