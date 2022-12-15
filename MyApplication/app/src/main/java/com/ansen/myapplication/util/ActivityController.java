package com.ansen.myapplication.util;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chris
 * @version 1.0
 * @since 2022-12-15
 */
public class ActivityController {
    public static List<AppCompatActivity> mActivityList = new ArrayList<>();

    private static AppCompatActivity mCurrentActivity;

    public static void addActivity(AppCompatActivity activity) {
        mActivityList.add(activity);
    }

    public static void removeActivity(AppCompatActivity activity) {
        mActivityList.remove(activity);
    }

    public static void setCurrentActivity(AppCompatActivity activity) {
        mCurrentActivity = activity;
    }

    public static AppCompatActivity getCurrentActivity() {
        return mCurrentActivity;
    }

    public static void finishAll() {
        for (AppCompatActivity activity : mActivityList) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
