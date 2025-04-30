package com.example.mgt_smartautopark_educationblock;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class VideoListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VideoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<VideoModel> videoList = new ArrayList<>();
        videoList.add(new VideoModel("Обучающее видео 1", "Описание 1"));
        videoList.add(new VideoModel("Обучающее видео 2", "Описание 2"));
        videoList.add(new VideoModel("Обучающее видео 3", "Описание 3"));

        adapter = new VideoAdapter(videoList);
        recyclerView.setAdapter(adapter);
    }
}
