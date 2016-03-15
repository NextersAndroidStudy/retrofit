package nexters.androidstudy.retrofittest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by SEONGBONG on 2016-03-15.
 */
public interface GitHubService {
    @GET("/repos/{owner}/{repo}/contributors")
    Call<List<RecyclerItem>> itemContributors(
            @Path("owner") String user,
            @Path("repo") String repo);
}
