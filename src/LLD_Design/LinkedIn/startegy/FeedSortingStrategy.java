package LLD_Design.LinkedIn.startegy;

import LLD_Design.LinkedIn.entity.Post;

import java.util.List;

public interface FeedSortingStrategy {

    List<Post> sort(List<Post> posts);

}
