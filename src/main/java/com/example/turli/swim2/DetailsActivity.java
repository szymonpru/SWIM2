package com.example.turli.swim2;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.turli.swim2.Adapters.MyPagerAdapter;
import com.example.turli.swim2.ArtistClasses.Authors;

public class DetailsActivity extends AppCompatActivity {

    public static final int PAGES_NUM = 2;

    public int getAuthorId() {
        return authorId;
    }

    private int authorId;
    private Authors author;

    private TextView authorTextView, categoryTextView;
    private ImageView imageView;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        init();

    }

    private void init() {
        Bundle data = getIntent().getExtras();
        authorId = data.getInt(Authors.BUNDLE_KEY_AUTHOR_ID);

        authorTextView=findViewById(R.id.author_name_text_view);
        categoryTextView=findViewById(R.id.category_name_text_view);
        imageView=findViewById(R.id.imageView);

        viewPager=findViewById(R.id.viewPager);
        pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        ((MyPagerAdapter)pagerAdapter).setAuthorId(authorId);
        viewPager.setAdapter(pagerAdapter);


        author= Authors.list.get(authorId);
        authorTextView.setText(author.getName());
        categoryTextView.setText(author.getCategory().getText());
        imageView.setImageResource(author.getAuthorPicture());
    }

    public static void start(Context context, int authorId) {
        Intent starter = new Intent(context, DetailsActivity.class);
        starter.putExtra(Authors.BUNDLE_KEY_AUTHOR_ID,authorId);
        context.startActivity(starter);
    }
}
