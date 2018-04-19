package com.example.turli.swim2.Adapters;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.turli.swim2.ArtistClasses.Authors;
import com.example.turli.swim2.ArtistClasses.MusicCategory;
import com.example.turli.swim2.DetailsActivity;
import com.example.turli.swim2.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by turli on 26.03.2018.
 */

public class AuthorAdapter extends RecyclerView.Adapter {

    private static final Map<MusicCategory,Integer> colorMap = new HashMap<MusicCategory,Integer>(){{
            put(MusicCategory.POP, Color.rgb(233,0,255));
            put(MusicCategory.METAL, Color.DKGRAY);
            put(MusicCategory.BLUES,Color.rgb(0,170,255));
            put(MusicCategory.CLASSIC,Color.rgb(185,150,0));
            put(MusicCategory.ROCK,Color.rgb(150,30,30));
            put(MusicCategory.RAP,Color.rgb(120, 25, 220));
        }
    };

    public AuthorAdapter() {
    }

    public void setMaxTextSize(TextView textView)
    {
        Paint paint = new Paint();
        Rect bounds = new Rect();

        paint.setTypeface(textView.getTypeface());
        float textSize = textView.getTextSize();
        paint.setTextSize(textSize);
        String text = textView.getText().toString();
        paint.getTextBounds(text, 0, text.length(), bounds);

        while (bounds.width() > textView.getLayoutParams().width)
        {
            textSize--;
            paint.setTextSize(textSize);
            paint.getTextBounds(text, 0, text.length(), bounds);
        }

        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AuthorViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Authors item = Authors.list.get(position);
        AuthorViewHolder viewHolder = (AuthorViewHolder) holder;

        viewHolder.authorId = position;
        viewHolder.textViewAuthor.setText(item.getName());
        setMaxTextSize(viewHolder.textViewAuthor);
        viewHolder.textViewCategory.setText(item.getCategory().getText());
        viewHolder.imageView.setImageResource(item.getAuthorPicture());
        viewHolder.itemView.setBackgroundColor(getColorFromCategory(item.getCategory()));
    }

    @Override
    public int getItemCount() {
        return Authors.list.size();
    }

    public void remove(int position){
        Authors.list.remove(position);
    }

    private int getColorFromCategory(MusicCategory category){
        if(colorMap.containsKey(category)){
            return colorMap.get(category);
        }
        else return Color.BLUE;
    }

    class AuthorViewHolder extends RecyclerView.ViewHolder {

        TextView textViewAuthor;
        TextView textViewCategory;
        ImageView imageView;
        ConstraintLayout constraintLayout;
        int authorId;

        public AuthorViewHolder(final ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.author_row_view, parent, false));
            textViewAuthor = itemView.findViewById(R.id.text_view_author);
            textViewCategory = itemView.findViewById(R.id.text_view_category);
            imageView = itemView.findViewById(R.id.image_view);
            constraintLayout = itemView.findViewById(R.id.author_row_layout);

            constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DetailsActivity.start(parent.getContext(),authorId);
                }
            });

        }



    }



}


