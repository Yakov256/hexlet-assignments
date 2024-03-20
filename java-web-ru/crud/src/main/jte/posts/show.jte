@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

@template.layout.page(
content = @`
    <main>
        <h3>${page.getPost().getName()}</h3>
        <p>${page.getPost().getBody()}</p>
        <a href="${NamedRoutes.postsPath()}">Back to posts</a>
    </main>
`
)