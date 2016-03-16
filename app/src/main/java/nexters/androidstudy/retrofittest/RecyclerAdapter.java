package nexters.androidstudy.retrofittest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by SEONGBONG on 2016-03-15.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private Context mContext;
    private List<GithubItem> mItems;

    public RecyclerAdapter(Context context) {
        this(context,new ArrayList<GithubItem>());
    }

    public RecyclerAdapter(Context context,List<GithubItem> items) {
        this.mContext = context;
        this.mItems = items;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_composition,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        GithubItem item = mItems.get(position);
        holder.item1.setText(item.getLogin());
        holder.item2.setText(item.getUrl());

    }

    @Override
    public int getItemCount() {
        return this.mItems.size();
    }
    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.item_1) TextView item1;
        @Bind(R.id.item_2) TextView item2;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
