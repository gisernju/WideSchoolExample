package com.codyy.wideschool.wideschoolexample;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by codyy on 2017/12/22.
 */

public class DragViewUtil {
    public static void drag(View v) {
        v.setOnTouchListener(new OnDragTouchListener());
    }

    private static class OnDragTouchListener implements View.OnTouchListener {
        float x;
        float y;

        public OnDragTouchListener() {
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    x = event.getX();
                    y = event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    float xDistance = event.getX() - x;
                    float yDistance = event.getY() - y;
                    if(xDistance != 0  && yDistance != 0){
                        int left = (int)(v.getLeft() + xDistance);
                        int right = (int)(v.getRight() + xDistance);
                        int top = (int)(v.getTop() + yDistance);
                        int bottom = (int)(v.getBottom() + yDistance);
                        v.layout(left,top,right,bottom);
                    }
                    break;

                case MotionEvent.ACTION_CANCEL:
                    break;
            }
            return false;
        }
    }


}
