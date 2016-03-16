package nexters.androidstudy.retrofittest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by SEONGBONG on 2016-03-16.
 */
public interface NaverSearchService {
    @GET("/{query}")
    @Headers({
            "X-Naver-Client-Id : dLpJzqQJNQ_zJzxrQYz8",
            "X-Naver-Client-Secret : wEPagYZLAB"
    })
    Call<List<NaverSearchItem>> naverSearchItemContributors(
            @Path("query") String query
    );
}
