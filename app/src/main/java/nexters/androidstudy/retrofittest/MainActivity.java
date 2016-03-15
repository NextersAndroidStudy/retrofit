package nexters.androidstudy.retrofittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//주석
public class MainActivity extends AppCompatActivity {

    private static final String TARGET_URL = "https://api.github.com";
    //butter kinife를 이용한 view injection
    @Bind(R.id.title_textview) TextView titleTextview;
    @Bind(R.id.request_btn) Button requestBtn;
    @Bind(R.id.recyclerView) RecyclerView recyclerView;

    GitHubService gitHubService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(TARGET_URL).addConverterFactory(GsonConverterFactory.create()).build();
        gitHubService = retrofit.create(GitHubService.class);
    }
    @OnClick(R.id.request_btn)
    public void requestBtnClick(){
        Call<List<RecyclerItem>> call = gitHubService.itemContributors("square", "retrofit");
        call.enqueue(new Callback<List<RecyclerItem>>() {
            @Override
            public void onResponse(Call<List<RecyclerItem>> call, Response<List<RecyclerItem>> response) {
                List<RecyclerItem> contributors = response.body();
                titleTextview.setText(response.message());
                setContent(contributors);
            }

            @Override
            public void onFailure(Call<List<RecyclerItem>> call, Throwable t) {

            }
        });
    }

    private void setContent(List<RecyclerItem> contributors) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RecyclerAdapter(getApplicationContext(),contributors));
    }
}
