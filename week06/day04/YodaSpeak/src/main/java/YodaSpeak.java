/**
 * Created by georgezsiga on 4/20/17.
 */
public class YodaSpeak {
  Retrofit retrofit = new Retrofit.Builder()
      .baseUrl("https://api.github.com/")
      .build();

  GitHubService service = retrofit.create(GitHubService.class);

  Call<ResponseBody> repos = service.listRepos("octocat");

  System.out.println(repos.execute().body().string());
}
