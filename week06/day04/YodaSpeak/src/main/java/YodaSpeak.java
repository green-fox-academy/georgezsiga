import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;

/**
 * Created by georgezsiga on 4/20/17.
 */

public class YodaSpeak {
  @GET
  public static void main(String[] args) {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .build();

    GitHubService service = retrofit.create(GitHubService.class);

    Call<ResponseBody> repos = service.listRepos("octocat");
    try {
      System.out.println(repos.execute().body().string());
    } catch (Exception e) {
      System.out.println("Huston, we have a problem");
    }
  }
}
