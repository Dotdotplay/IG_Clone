package com.example.ig_clone;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String  TAG = "MainActivity";
    private TextView etDescription;
    private Button btnCaptureImage;
    private ImageView ivPostImage;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etDescription = findViewById(R.id.tvDescription);
        btnCaptureImage = findViewById(R.id.btnTakePicture);
        ivPostImage = findViewById(R.id.ivImage);
        btnSubmit = findViewById(R.id.btnSubmit);
        queryPosts();
    }

    private void queryPosts() {
        Log.d("hi","hello im in query posts");
        ParseQuery<Post> postQuery = new ParseQuery<Post>(Post.class);
        postQuery.include(Post.KEY_USER);
        postQuery.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> objects, ParseException e) {
                Log.d("hi","hello im in done function ");

                for (int i = 0; i < objects.size(); i ++) {
                    Post post = objects.get(i);
                    //Log.d("hi","hello im in for loop posts");
                    //Log.d(TAG,"Posts: "+ post.getDescription() + "username" + post.getUser().getUsername());
                }
            }
        });

    }
}
