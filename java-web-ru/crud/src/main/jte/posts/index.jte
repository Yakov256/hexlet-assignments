@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(
content = @`
    <div>
        <p>
            <a href="${NamedRoutes.postsBuildPath()}">add new post</a>
        </p>
    </div>
    @if(page.getPosts().isEmpty())
        <p>
            Posts list is empty
        </p>
    @else
        @for(var post : page.getPosts())
            <div>
                <a href="${NamedRoutes.postPath(post.getId())}">
                        <div>${post.getName()}</div>
                </a>
            </div>
        @endfor

        <nav aria-label="Page navigation example">
            <ul class="pagination">
                @if(page.isHasPreviousPage())
                    <li class="page-item">
                        <a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getCurPage() - 1}">Previous</a>
                    </li>
                @endif

                @for(var i = 1; i <= page.getPagesTotalAmount(); i++)
                    <li class="page-item @if(i == page.getCurPage()) active @endif">
                        <a class="page-link" href="${NamedRoutes.postsPath()}?page=${i}">${i}</a>
                    </li>
                @endfor

                @if(page.isHasNextPage())
                    <li class="page-item">
                        <a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getCurPage() + 1}">Next</a>
                    </li>
                @endif
            </ul>
        </nav>
        <a href="${NamedRoutes.rootPath()}">Back to home</a>
    @endif
`
)