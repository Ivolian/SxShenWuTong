package com.unicorn.sxshenwutong.court.data;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.court.Court;
import com.unicorn.sxshenwutong.dagger.App;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.indexablerv.IndexableAdapter;

@App
public class CourtAdapter2 extends IndexableAdapter<Court> {

    private final LayoutInflater layoutInflater;

    @Inject
    public CourtAdapter2(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateTitleViewHolder(ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.index_airport, parent, false);
        return new IndexViewHolder(view);
    }

    @Override
    public RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.item_airport, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindTitleViewHolder(RecyclerView.ViewHolder holder, String indexTitle) {
        IndexViewHolder indexViewHolder = (IndexViewHolder) holder;
        indexViewHolder.tvIndex.setText(indexTitle);
    }

    @Override
    public void onBindContentViewHolder(RecyclerView.ViewHolder holder, Court court) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.tvAirportName.setText(court.getDmms());
    }

    public class IndexViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvIndex)
        TextView tvIndex;

        public IndexViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvAirport)
        TextView tvAirportName;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

}