package com.albinmathew.transitions;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

import com.albinmathew.transitions.core.TransitionBundleFactory;


public class ActivityTransitionLauncher {
    private static final String TAG = "TransitionLauncher";

    private final Activity activity;
    private View fromView;
    private Bitmap bitmap;


    private ActivityTransitionLauncher(Activity activity) {
        this.activity = activity;
    }

    public static ActivityTransitionLauncher with(Activity activity) {
        return new ActivityTransitionLauncher(activity);
    }

    public ActivityTransitionLauncher from(View fromView) {
        this.fromView = fromView;
        return this;
    }

    public ActivityTransitionLauncher image(final Bitmap bitmap) {
        this.bitmap = bitmap;
        return this;
    }

    public void launch(Intent intent) {
        final Bundle transitionBundle = TransitionBundleFactory.createTransitionBundle(activity, fromView, bitmap);
        intent.putExtras(transitionBundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(0, 0);
    }
}
