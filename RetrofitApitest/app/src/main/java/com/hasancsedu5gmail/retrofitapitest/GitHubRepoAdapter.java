package com.hasancsedu5gmail.retrofitapitest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mahmud on 9/14/2017.
 */

public class GitHubRepoAdapter extends ArrayAdapter<GitHubRepo> {

    private Context context;
    private List<GitHubRepo> repoList;


    public GitHubRepoAdapter(@NonNull Context context, List<GitHubRepo> repoList) {
        super(context,R.layout.repo_view ,repoList);
        this.context = context;
        this.repoList = repoList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.repo_view,parent,false);

        GitHubRepo repo = repoList.get(position);


        TextView tvName = row.findViewById(R.id.text_name);
        tvName.setText("Name : "+repo.getName());

        TextView tvId = row.findViewById(R.id.text_id);
        tvId.setText("Id : "+repo.getId());

        TextView tvFullName = row.findViewById(R.id.text_full_name);
        tvFullName.setText("Full Name : "+repo.getFull_name());





        return  row;



    }
}
