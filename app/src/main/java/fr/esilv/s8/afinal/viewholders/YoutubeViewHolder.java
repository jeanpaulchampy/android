package fr.esilv.s8.afinal.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.esilv.s8.afinal.R;
import fr.esilv.s8.afinal.models.Item;
import fr.esilv.s8.afinal.models.Youtube;

/**
 * Created by Jean-Paul on 26/03/2017.
 */

public class YoutubeViewHolder extends RecyclerView.ViewHolder {
    /*
    In a cell, some basic information will be displayed,
 such as the title, the description,
 the publication date, the author,
 and a thumbnail of the video.
     */
    private TextView title;
    private TextView desciption;
    private TextView publicationDate;
    //private TextView author;
    private ImageView thumbnail;
   // private Context context;
    public YoutubeViewHolder(View itemView) {
        super(itemView);
        title=(TextView) itemView.findViewById(R.id.title);
        desciption=(TextView)itemView.findViewById(R.id.description);
        publicationDate=(TextView) itemView.findViewById(R.id.publishedAt);
        thumbnail=(ImageView) itemView.findViewById(R.id.image);
       // this.context=context.getApplicationContext();

    }
    public void bind(Item item)
    {

        title.setText(item.getSnippet().getTitle());
        desciption.setText(item.getSnippet().getDescription());
        publicationDate.setText(item.getSnippet().getPublishedAt().toString());
        //author.setText(item.getSnippet().getThumbnails().);
        Picasso.with(itemView.getContext()).load(item.getSnippet().getThumbnails().getMedium().getUrl()).into(thumbnail);
    }
}
