package LLD_Design.problems.LinkedIn.startegy;

import LLD_Design.problems.LinkedIn.entity.Post;

import java.util.List;

public interface FeedSortingStrategy {

    List<Post> sort(List<Post> posts);

}
