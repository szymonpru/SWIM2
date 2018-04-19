package com.example.turli.swim2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.turli.swim2.Adapters.AlbumAdapter;
import com.example.turli.swim2.ArtistClasses.Authors;



public class AlbumsFragment extends Fragment {
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
    private int authorId;
    private View view;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager layoutManager;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_albums,container,false);
        authorId = getArguments().getInt(Authors.BUNDLE_KEY_AUTHOR_ID);
        setRecyclerView();

        return view;
    }

    private void setRecyclerView(){
        recyclerView = view.findViewById(R.id.albums_recycler_view);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new AlbumAdapter(authorId);
        recyclerView.setAdapter(adapter);
    }

}
