package com.lunger.touchsearch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by Allen on 2018/11/1 0001.
 * 布局中的顶级容器
 */

public class RootViewGroup extends RelativeLayout {

    public RootViewGroup(Context context) {
        super(context);
    }

    public RootViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RootViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        // 结论：
        // 返回true 事件会死在这里
        // 返回false 事件传给上一层的onTouchEvent
        // 返回super.dispatchTouchEvent(ev) 事件传给本层的onInterceptTouchEvent
        if (ev.getAction() == MotionEvent.ACTION_DOWN)
            Log.d("wbl", "RootViewGroup -> dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN)
            Log.d("wbl", "RootViewGroup -> onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN)
            Log.d("wbl", "RootViewGroup -> onTouchEvent");
        return super.onTouchEvent(event);
    }


}
