/**
 * Created by georgezsiga on 4/20/17.
 */
public interface GitHubService {
  @GET("users/{user}/repos")
  Call<ResponseBody> listRepos(@Path("user") String user);
}
