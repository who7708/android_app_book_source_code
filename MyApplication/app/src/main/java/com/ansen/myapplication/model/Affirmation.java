package com.ansen.myapplication.model;

import androidx.annotation.StringRes;

/**
 * @author Chris
 * @version 1.0
 * @since 2022-12-15
 */
public class Affirmation {

    @StringRes
    private int stringResourceId;

    public Affirmation(int stringResourceId) {
        this.stringResourceId = stringResourceId;
    }

    public int getStringResourceId() {
        return stringResourceId;
    }

    public void setStringResourceId(int stringResourceId) {
        this.stringResourceId = stringResourceId;
    }
}
