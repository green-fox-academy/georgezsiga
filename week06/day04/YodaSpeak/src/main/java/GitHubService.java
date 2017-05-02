import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by georgezsiga on 4/20/17.
 */
public interface GitHubService {
  @GET("users/{user}/repos")
  Call<ResponseBody> listRepos(@Path("user") String user);
}
