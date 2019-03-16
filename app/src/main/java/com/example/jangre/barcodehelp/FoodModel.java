package com.example.jangre.barcodehelp;

public class FoodModel {

    private String mFood;
    private String mDate;
    private int mType;

    public FoodModel(String mFood, String mDate, int mType) {
        this.mFood = mFood;
        this.mDate = mDate;
        this.mType = mType;
    }

    public String getmFood() {
        return mFood;
    }

    public void setmFood(String mFood) {
        this.mFood = mFood;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public int getmType() {
        return mType;
    }

    public void setmType(int mType) {
        this.mType = mType;
    }
}
