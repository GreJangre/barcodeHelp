package com.example.jangre.barcodehelp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DeserializeModel {

    public static final int PARENT = 0;
    public static final int CHILD = 1;

    @SerializedName("position")
    @Expose
    private String position;
    @SerializedName("foodName")
    @Expose
    private List<foodName> foodName = null;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<foodName> getFoodName() {
        return foodName;
    }

    public void setFoodName(List<foodName> foodName) {
        this.foodName = foodName;
    }

    public class foodName {

        @SerializedName("food")
        @Expose
        private String food;
        @SerializedName("date")
        @Expose
        private String date;

        public String getFood() {
            return food;
        }

        public void setFood(String food) {
            this.food = food;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }
}
