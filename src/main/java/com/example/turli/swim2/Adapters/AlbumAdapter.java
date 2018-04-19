package com.example.turli.swim2.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.turli.swim2.ArtistClasses.Album;
import com.example.turli.swim2.ArtistClasses.Authors;
import com.example.turli.swim2.R;

/**
 * Created by turli on 09.04.2018.
 */

public class AlbumAdapter extends RecyclerView.Adapter {
    private final int authorId;
    private final Authors author;

    public AlbumAdapter(int authorId) {
        super();
        this.authorId = authorId;
        author = Authors.list.get(authorId);
    }

    @Override

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_row_view,parent,false);
        return new AlbumAdapter.AlbumViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Album item = author.getAlbum(position);
        AlbumViewHolder viewHolder = (AlbumViewHolder) holder;


        viewHolder.imageView.setImageResource(item.getAlbumPicture());
        viewHolder.textViewAlbumName.setText(item.getTitle());
        viewHolder.textViewYear.setText(item.getYear() + "");
    }

    @Override
    public int getItemCount() {
        return author.getAlbumSize();
    }

    class AlbumViewHolder extends RecyclerView.ViewHolder{

        TextView textViewAlbumName;
        TextView textViewYear;
        ImageView imageView;

        public AlbumViewHolder(ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.album_row_view, parent, false));
            textViewAlbumName = itemView.findViewById(R.id.album_name_text_view);
            textViewYear = itemView.findViewById(R.id.album_year_text_view);
            imageView = itemView.findViewById(R.id.album_image);

        }

        public AlbumViewHolder(View itemView) {
            super(itemView);
            textViewAlbumName = itemView.findViewById(R.id.album_name_text_view);
            textViewYear = itemView.findViewById(R.id.album_year_text_view);
            imageView = itemView.findViewById(R.id.album_image);
        }
    }
}
