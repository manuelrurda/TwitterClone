package com.codepath.apps.restclienttemplate.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.R;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder>{
    // Pass in the context and list of tweets
    Context context;
    List<Tweet> tweets;

    public TweetsAdapter(Context context, List<Tweet> tweets) {
        this.context = context;
        this.tweets = tweets;
    }


    // for each row inflate a layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);
        return new ViewHolder(view);
    }

    // Bind values based on position
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get data ready for display
        Tweet tweet = tweets.get(position);
        // Bind the data with viewholder
        holder.bind(tweet);
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    // Define viewholder

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvBody;
        TextView tvScreenName;
        ImageView ivProfileImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBody = itemView.findViewById(R.id.tvBody);
            tvScreenName = itemView.findViewById(R.id.tvScreenName);
            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
        }


        public void bind(Tweet tweet) {
            tvBody.setText(tweet.body);
            tvScreenName.setText("@"+tweet.user.screenName);
            Glide.with(context)
                    .load(tweet.user.publicImageUrl)
                    .into(ivProfileImage);

        }
    }

}
