package com.example.mgt_smartautopark_educationblock;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Video> videoList = new ArrayList<>();
        videoList.add(new Video("Видео 1", "Описание содержания"));
        videoList.add(new Video("Видео 2", "Описание содержания"));

        VideoAdapter adapter = new VideoAdapter(videoList);
        recyclerView.setAdapter(adapter);
    }
}