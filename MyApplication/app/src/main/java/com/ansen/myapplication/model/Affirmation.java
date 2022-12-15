package com.ansen.myapplication.model;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

/**
 * @author Chris
 * @version 1.0
 * @since 2022-12-15
 */
public class Affirmation {

    @StringRes
    private int stringResourceId;

    @DrawableRes
    private int imageResourceId;

    public Affirmation(int stringResourceId, int imageResourceId) {
        this.stringResourceId = stringResourceId;
        this.imageResourceId = imageResourceId;
    }

    public int getStringResourceId() {
        return stringResourceId;
    }

    public void setStringResourceId(int stringResourceId) {
        this.stringResourceId = stringResourceId;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}
