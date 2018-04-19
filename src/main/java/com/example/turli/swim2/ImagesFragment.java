package com.example.turli.swim2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.example.turli.swim2.Adapters.ImagesAdapter;
import com.example.turli.swim2.ArtistClasses.Authors;

import java.util.ArrayList;

/**
 * Created by turli on 12.04.2018.
 */

public class ImagesFragment extends Fragment {
    private GridView gridView;
    private ArrayList<Integer> images = new ArrayList<>();
    private View view;
    private int authorID;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_images,container,false);
        setGridView();
        authorID = getArguments().getInt(Authors.BUNDLE_KEY_AUTHOR_ID);
        setImages();

        return view;
    }

    private void setGridView() {
        gridView =  view.findViewById(R.id.grid_view);
        gridView.setAdapter(new ImagesAdapter(view.getContext(),images));
    }

    private void setImages(){
        Authors author = Authors.list.get(authorID);
        while(images.size()<6){
            images.add(author.getAuthorPicture());
            int randomIndexFromAlbums = (int)(Math.random()*author.getAlbumSize());
            images.add(author.getAlbum(randomIndexFromAlbums).getAlbumPicture());
        }
    }

}
