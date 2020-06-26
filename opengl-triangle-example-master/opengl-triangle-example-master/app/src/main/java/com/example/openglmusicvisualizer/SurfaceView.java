package com.example.openglmusicvisualizer;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

public class SurfaceView extends GLSurfaceView {

    public SurfaceView(Context context){
        super(context);
        init();
    }
    public SurfaceView(Context context, AttributeSet attrs){
        super(context, attrs);
        init();
    }

    private void init() {
        setEGLContextClientVersion(2);
        setPreserveEGLContextOnPause(true);
        setRenderer(new GLSurfaceViwRenderer());
    }
}