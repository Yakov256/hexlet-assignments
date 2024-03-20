package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void index(Context ctx) {
        int postsPerPage = 5;
        Integer curPage = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        List<Post> posts = PostRepository.getEntities();
        int startIndex = (curPage - 1) * postsPerPage;
        int endIndex = Math.min(startIndex + postsPerPage, posts.size());
        List<Post> postsOnPage = posts.subList(startIndex, endIndex);
        int totalPages = (int) Math.ceil((double) posts.size() / postsPerPage);
        var page = new  exercise.dto.posts.PostsPage(postsOnPage, curPage, totalPages,
                curPage > 1, endIndex < posts.size());

        ctx.render("posts/index.jte", Collections.singletonMap("page", page));
    }

    public static void show(Context ctx) {
        long postId = ctx.pathParamAsClass("id", Long.class).get();
        Post post = PostRepository.find(postId).orElseThrow(() -> new NotFoundResponse("Page not found"));
        var page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }

    public static void build(Context ctx) {
        ctx.render("posts/build.jte");
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var body = ctx.formParam("body");

        var post = new Post(name, body);
        PostRepository.save(post);
        ctx.redirect(NamedRoutes.postsPath());
    }

    public static void edit(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var page = new PostPage(post);
        ctx.render("post/edit.jte", Collections.singletonMap("page", page));
    }


    public static void update(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var name = ctx.formParam("name");
        var body = ctx.formParam("email");
        var post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));

        post.setName(name);
        post.setBody(body);
        PostRepository.save(post);
        ctx.redirect(NamedRoutes.postsPath());
    }
    // END
}
