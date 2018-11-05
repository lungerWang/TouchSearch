package com.lunger.touchsearch;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Allen on 2018/11/1 0001.
 * 最内层子视图
 */

public class ChildView extends View {

    public ChildView(Context context) {
        super(context);
    }

    public ChildView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ChildView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        // 结论：
        // 返回true 事件会死在这里
        // 返回false 事件传给上一层的onTouchEvent
        // 返回super.dispatchTouchEvent(ev) 事件传给本层的onTouchEvent
        if (ev.getAction() == MotionEvent.ACTION_DOWN)
            Log.d("wbl", "ChildView -> dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 结论：
        // 返回true 事件会死在这里
        // 返回false 事件传给上一层的onTouchEvent 当本层有点击事件时，不可以响应
        // 返回super.dispatchTouchEvent(ev) 事件传给上一层的onTouchEvent 当本层有点击事件时，可以响应
        if (event.getAction() == MotionEvent.ACTION_DOWN)
            Log.d("wbl", "ChildView -> onTouchEvent");
        return super.onTouchEvent(event);
    }


}
