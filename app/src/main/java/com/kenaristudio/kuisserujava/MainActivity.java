package com.kenaristudio.kuisserujava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.kenaristudio.kuisserujava.Adapter.CategoryAdapter;
import com.kenaristudio.kuisserujava.Common.SpaceDecoration;
import com.kenaristudio.kuisserujava.DBHelper.DBHelper;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recycler_category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Kuis Seru Java");
        setSupportActionBar(toolbar);

        recycler_category = findViewById(R.id.recycler_category);
        recycler_category.setHasFixedSize(true);
        recycler_category.setLayoutManager(new GridLayoutManager(this, 2));

        //get screen height
        CategoryAdapter adapter = new CategoryAdapter(MainActivity.this, DBHelper.getInstance(this).getAllCategories());
        int SpaceInPixel = 4;
        recycler_category.addItemDecoration(new SpaceDecoration(SpaceInPixel));
        recycler_category.setAdapter(adapter);


    }
}
