package com.codyy.wideschool.wideschoolexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LivingClassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_living_class);
        View view_1  = findViewById(R.id.view_1);
        View view_2 = findViewById(R.id.view_2);
        DragViewUtil.drag(view_1);
        DragViewUtil.drag(view_2);



    }
}
