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
        // 结论：
        // 返回true 表示将事件进行拦截，并将拦截到的事件交由当前层级的 onTouchEvent 进行处理
        // 返回false 或 super.dispatchTouchEvent(ev)事件分发给孩子的dispatchTouchEvent
        if (ev.getAction() == MotionEvent.ACTION_DOWN)
            Log.d("wbl", "RootViewGroup -> onInterceptTouchEvent");
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 结论：
        // 返回true 事件会死在这里
        // 返回false 事件传给上一层的onTouchEvent 当本层有点击事件时，不可以响应
        // 返回super.dispatchTouchEvent(ev) 事件传给上一层的onTouchEvent 当本层有点击事件时，可以响应
        if (event.getAction() == MotionEvent.ACTION_DOWN)
            Log.d("wbl", "RootViewGroup -> onTouchEvent");
        return super.onTouchEvent(event);
    }


}
