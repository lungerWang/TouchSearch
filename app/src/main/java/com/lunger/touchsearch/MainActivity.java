package com.lunger.touchsearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    View child_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        child_view = findViewById(R.id.child_view);
//        child_view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("wbl", "onClick");
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
