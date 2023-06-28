package com.example.petdiary;

import android.graphics.drawable.Drawable;

public class WarningListViewItem {
   // private Drawable icon ;
    private String title_text;
    private String warning_text;


    /*public void setIcon(Drawable icon) {
        this.icon = icon ;
    }*/
    public void setTitle_text(String text) {
        this.title_text = text ;
    }

    public void setWarning_text(String text) {
        this.warning_text = text;
    }
    /*public Drawable getIcon() {
        return this.icon ;
    }*/

    public String getTitle_text() {
        return this.title_text ;
    }

    public String getWarning_text() {
        return this.warning_text;
    }

}
