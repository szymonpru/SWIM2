package com.example.turli.swim2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.turli.swim2.Adapters.AuthorAdapter;
import com.example.turli.swim2.ArtistClasses.Initializer;

public class RecyclerActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setUpRecyclerView();
        Initializer.initialize();
    }

    private void setUpRecyclerView() {
        setContentView(R.layout.activity_recycler);
        mRecyclerView = findViewById(R.id.recycler_view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new AuthorAdapter());
        mRecyclerView.setHasFixedSize(true);
        setUpItemTouchHelper();
    }

    private void setUpItemTouchHelper() {
        ItemTouchHelper.SimpleCallback simpleCallback = new CallBack(0,ItemTouchHelper.RIGHT);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);

    }

    private class CallBack extends ItemTouchHelper.SimpleCallback{
        public CallBack(int dragDirs, int swipeDirs) {
            super(dragDirs, swipeDirs);
        }

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
          AuthorAdapter adapter = (AuthorAdapter) mRecyclerView.getAdapter();
          int pos = viewHolder.getAdapterPosition();
          adapter.remove(pos);
          adapter.notifyItemRemoved(pos);
        }
    }
}


