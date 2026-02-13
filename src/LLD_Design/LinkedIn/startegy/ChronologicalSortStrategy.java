package LLD_Design.LinkedIn.startegy;

import LLD_Design.LinkedIn.entity.Post;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ChronologicalSortStrategy implements FeedSortingStrategy {

    @Override
    public List<Post> sort(List<Post> posts) {
       List<Post> result = new ArrayList<>();

       posts.stream()
               .sorted(Comparator.comparing(Post::getCreatedAt))
               .forEach(result::add);
       return result;
    }
}
