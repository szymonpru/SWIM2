package com.example.turli.swim2.Adapters;

import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.Toast;

import com.example.turli.swim2.AlbumsFragment;
import com.example.turli.swim2.ArtistClasses.Authors;
import com.example.turli.swim2.DetailsActivity;
import com.example.turli.swim2.ImagesFragment;

/**
 * Created by turli on 12.04.2018.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {

    private int authorId;

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(Authors.BUNDLE_KEY_AUTHOR_ID,authorId);
        if(position==0) {
            ImagesFragment imagesFragment = new ImagesFragment();
            imagesFragment.setArguments(bundle);
            return imagesFragment;
        } else {
            AlbumsFragment albumsFragment = new AlbumsFragment();
            albumsFragment.setArguments(bundle);
            return albumsFragment;
        }
    }

    @Override
    public int getCount() {
        return DetailsActivity.PAGES_NUM;
    }
}
