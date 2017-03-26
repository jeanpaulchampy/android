package fr.esilv.s8.afinal.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;


import fr.esilv.s8.afinal.R;
import fr.esilv.s8.afinal.models.Item;
import fr.esilv.s8.afinal.viewholders.YoutubeViewHolder;

/**
 * Created by Jean-Paul on 26/03/2017.
 */

public class youtubeAdapter extends RecyclerView.Adapter<YoutubeViewHolder>{
    private final List<Item> items;

    public youtubeAdapter(List<Item> items) {
        this.items = items;
    }

    @Override
    public YoutubeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new YoutubeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_youtube,parent,false));
    }

    @Override
    public void onBindViewHolder(YoutubeViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }
}
