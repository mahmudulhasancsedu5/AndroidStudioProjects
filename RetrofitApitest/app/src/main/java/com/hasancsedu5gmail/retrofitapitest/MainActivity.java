package com.hasancsedu5gmail.retrofitapitest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String GITHUB_URL = "https://api.github.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    private void addListView(){

        EditText etUserName = (EditText) findViewById(R.id.text_userName);
        String userName = etUserName.getText().toString();

        final ListView listView = (ListView) findViewById(R.id.list_repo);

        Retrofit.Builder builder =
                new Retrofit.Builder()
                .baseUrl(GITHUB_URL)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        GitHubClient gitHubClient =  retrofit.create(GitHubClient.class);
        Call<List<GitHubRepo>> call=gitHubClient.reposForUser(userName);

        //use the call obj

        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {

//                Log.v("Res : ",response.body().toString());
                List<GitHubRepo> reposList = response.body();
//                List<String> repoNameList = new ArrayList<String>();
//                for(GitHubRepo repo : reposList){
//                    repoNameList.add(repo.getName());
//                }
//
//                ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                        MainActivity.this,
//                        android.R.layout.simple_list_item_1,
//                        repoNameList
//                );

                GitHubRepoAdapter adapter1 = new GitHubRepoAdapter(MainActivity.this,reposList);
                listView.setAdapter(adapter1);
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {

                Log.e("Retrofit Error : ","Error ....");
            }
        });


    }

    public void onClickGetList(View view) {

        addListView();
    }
}
