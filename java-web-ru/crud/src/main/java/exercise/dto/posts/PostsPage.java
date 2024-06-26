package exercise.dto.posts;

import java.util.List;
import exercise.model.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;


// BEGIN
@AllArgsConstructor
@Getter
public class PostsPage {
    private List<Post> posts;
    private int curPage;
    private int pagesTotalAmount;
    private boolean hasPreviousPage;
    private boolean hasNextPage;
}
// END


