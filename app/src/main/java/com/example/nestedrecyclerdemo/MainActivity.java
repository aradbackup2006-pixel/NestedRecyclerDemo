package com.example.nestedrecyclerdemo;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerVertical;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerVertical = findViewById(R.id.recyclerVertical);
        recyclerVertical.setLayoutManager(new LinearLayoutManager(this));

        // داده‌های نمونه
        List<List<User>> verticalList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<User> horizontalList = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                horizontalList.add(new User("User " + j, 20 + j));
            }
            verticalList.add(horizontalList);
        }

        VerticalAdapter verticalAdapter = new VerticalAdapter(this, verticalList, user ->
                Toast.makeText(MainActivity.this,
                        "Clicked: " + user.getName(), Toast.LENGTH_SHORT).show());
        recyclerVertical.setAdapter(verticalAdapter);
    }
}
