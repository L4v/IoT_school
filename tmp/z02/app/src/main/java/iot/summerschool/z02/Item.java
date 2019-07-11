package iot.summerschool.z02;

import android.graphics.drawable.Drawable;

public class Item {
    private String mText1, mText2;
    private Drawable mImage;

    public Item(String text1, String text2, Drawable image){
        this.mImage = image;
        this.mText1 = text1;
        this.mText2 = text2;
    }

    public String getText1(){ return this.mText1; }
    public String getText2(){ return this.mText2; }
    public Drawable getImage(){return this.mImage; }

    public void setText1(String s){ this.mText1 = s;}
    public void setText2(String s){ this.mText2 = s;}
    public void setImage(Drawable image){this.mImage = image;}
}
