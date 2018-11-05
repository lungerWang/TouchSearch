package com.lunger.touchsearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    View child_view;
    ViewGroup view_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        child_view = findViewById(R.id.child_view);
        view_group = findViewById(R.id.view_group);
//        child_view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("wbl", "child_view onClick");
//            }
//        });
//
//        view_group.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("wbl", "view_group onClick");
//            }
//        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        // 结论：
        // 返回true或者false  事件就死在这里了
        // 返回super.dispatchTouchEvent(ev)，事件往下传递
        if (ev.getAction() == MotionEvent.ACTION_DOWN)
            Log.d("wbl", "MainActivity -> dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN)
            Log.d("wbl", "MainActivity -> onTouchEvent");
        return super.onTouchEvent(event);
    }
}
