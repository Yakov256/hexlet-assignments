@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

<!-- Begin -->
@template.layout.page(
content = @`
<div class="mx-auto p-4 py-md-5">
    <main>
        <h3>Все посты</h3>

        <div><a href="${NamedRoutes.buildPostPath()}">Создать новый пост</a></div>

        <table class="table table-striped">
            @for(var post : page.getPosts())
                <tr>
                    <td>${post.getId()}</td>
                    <td><a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a></td>
                    <td>${post.getBody()}</td>
                </tr>
            @endfor
        </table>
    </main>
</div>
`
)
<!-- End -->