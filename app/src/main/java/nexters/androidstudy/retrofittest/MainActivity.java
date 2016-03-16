package nexters.androidstudy.retrofittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.SimpleXmlConverterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

//주석
public class MainActivity extends AppCompatActivity {

    private static final String GITHUB_URL = "https://api.github.com";
    private static final String NAVER_SEARCH_URL = "https://openapi.naver.com/v1/search/blog.xml/";
    private static final String X_NAVER_CLIENT_ID = "dLpJzqQJNQ_zJzxrQYz8";
    private static final String X_NAVER_CLIENT_SECRET = "wEPagYZLAB";
    //butter kinife를 이용한 view injection
    @Bind(R.id.title_textview) TextView titleTextview;
    @Bind(R.id.request_btn) Button requestBtn;
    @Bind(R.id.recyclerView) RecyclerView recyclerView;

    GithubService githubService;
    NaverSearchService naverSearchService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //Retrofit retrofit = new Retrofit.Builder().baseUrl(GITHUB_URL).addConverterFactory(GsonConverterFactory.create()).build();
        //githubService = retrofit.create(GithubService.class);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NAVER_SEARCH_URL)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        naverSearchService = retrofit.create(NaverSearchService.class);
    }
    @OnClick(R.id.request_btn)
    public void requestBtnClick(){
        /*Call<List<GithubItem>> call = githubService.githubItemContributors("seongbongjang", "retrofit");

        call.enqueue(new Callback<List<GithubItem>>() {
            @Override
            public void onResponse(Call<List<GithubItem>> call, Response<List<GithubItem>> response) {
                List<GithubItem> contributors = response.body();
                titleTextview.setText(response.message());
                setContent(contributors);
            }

            @Override
            public void onFailure(Call<List<GithubItem>> call, Throwable t) {

            }
        });*/
        Log.i("onResponse", "IN!!");
        String str="";
        try{
            str = URLEncoder.encode("고구마", "utf-8");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        Log.i("onResponse", "CALL!!");
        Call<List<NaverSearchItem>> call = naverSearchService.naverSearchItemContributors(str);
        call.enqueue(new Callback<List<NaverSearchItem>>() {
            @Override
            public void onResponse(Call<List<NaverSearchItem>> call, Response<List<NaverSearchItem>> response) {
                Log.i("onResponse", "RESPONSE!!");
                Log.i("onResponse", response.toString());
                //List<NaverSearchItem> contributors = response.body();
                Log.i("onResponse", "END!!");
            }

            @Override
            public void onFailure(Call<List<NaverSearchItem>> call, Throwable t) {
                Log.i("onResponse", t.getMessage());
            }
        });
    }

    private void setContent(List<GithubItem> contributors) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RecyclerAdapter(getApplicationContext(),contributors));
    }
}
