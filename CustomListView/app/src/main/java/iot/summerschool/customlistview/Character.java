package iot.summerschool.customlistview;

import android.graphics.drawable.Drawable;

public class Character {
    private String mName;
    private Drawable mImage;

    public Character(String name, Drawable image){
        this.mName = name;
        this.mImage = image;
    }

    public void setImage(Drawable image) {this.mImage = image;}
    public void setName(String name){this.mName = name;}

    public String getName(){ return this.mName; }
    public Drawable getImage(){ return this.mImage;}

}
