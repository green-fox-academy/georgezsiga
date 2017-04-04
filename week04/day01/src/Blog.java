import java.util.ArrayList;
import java.util.List;

/**
 * Created by georgezsiga on 4/3/17.
 */
public class Blog {
  ArrayList<BlogPost> listOfBlogPosts;

  public Blog() {
    this.listOfBlogPosts = new ArrayList<>();
  }

  public void addBlogPosts() {
    BlogPost blog1 = new BlogPost("John Doe", "Lorem Ipsum", "2000.05.04.");
    blog1.text = "Lorem ipsum dolor sit amet.";
    listOfBlogPosts.add(blog1);
    BlogPost blog2 = new BlogPost("Tim Urban", "Wait but why", "2010.10.10.");
    blog2.text = "A popular long-form, stick-figure-illustrated blog about almost everything.";
    listOfBlogPosts.add(blog2)
    BlogPost blog3 = new BlogPost("William Turton",
        "One Engineer Is Trying to Get IBM to Reckon With Trump", "2017.03.28.");
    blog3.text = "Daniel Hanley, a cybersecurity engineer at IBM, doesn’t want to be the center of attention. When I asked to take his picture outside one of IBM’s New York City offices, he told me that he wasn’t really into the whole organizer profile thing.";
    listOfBlogPosts.add(blog3);
  }

  public void delete(int index) {
    blogList.remove(index);
  }

  public void update(int index, BlogPost blog) {
    blogList.set(index, blog);

  }

  public static void main(String[] args) {
    Blog list1 = new Blog();

    list1.

  }

}
