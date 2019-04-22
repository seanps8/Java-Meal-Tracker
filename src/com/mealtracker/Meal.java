package com.mealtracker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Meal {

    private ArrayList<Food> food = new ArrayList<>();
    private String mealName;
    private Date dateConsumed;

    Meal(String name, String timeOfMeal) {
        this.mealName = name;
        this.dateConsumed = setDate(timeOfMeal);
    }

    public void addFood(Food food) {
        this.food.add(food);
    }
    public String getName() {
        return this.mealName;
    }
    public String getDate() {
        String datePattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat mealFormat = new SimpleDateFormat(datePattern);
        return mealFormat.format(this.dateConsumed);
    }

    private Date setDate(String stringDate) {
        Date mealDate = new Date();
        String datePattern = "yyyy-MM-dd HH:mm:ss";
        try {
            SimpleDateFormat mealFormat = new SimpleDateFormat(datePattern);
            mealDate = mealFormat.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return mealDate;
    }

    public double getCalories() {
        double calorieCount = 0;
        for(Food food: this.food) {
            calorieCount += food.getCalories();
        }
        return calorieCount;
    }

    public double getFat(){
        double fatCount = 0;
        for(Food food: this.food){
            fatCount += food.getFat();
        }
        return fatCount;
    }

    public double getCarbs(){
        double carbCount = 0;
        for(Food food: this.food){
            carbCount += food.getCarbs();
        }
        return carbCount;
    }

    public double getProtein(){
        double proteinCount = 0;
        for(Food food: this.food){
            proteinCount += food.getProtein();
        }
        return proteinCount;
    }

    public void viewFoods(){
        for(Food food : this.food){
            System.out.println(food.getName());
        }
    }

    public boolean consumed(){
        boolean FRUIT = false;
        boolean VEGETABLE = false;
        boolean PROTEIN = false;
        boolean FAT = false;
        boolean DRINK = false;
        boolean WATER = false;
        boolean DESSERT = false;

        for (Food food : this.food){
            switch(food.getCategory()){
                case FRUIT:
                    FRUIT = true;
                    break;
                case VEGETABLE:
                    VEGETABLE = true;
                    break;
                case PROTEIN:
                    PROTEIN = true;
                    break;
                case FAT:
                    FAT = true;
                    break;
                case DRINK:
                    DRINK = true;
                    break;
                case WATER:
                    DRINK = true;
                    break;
                case DESSERT:
                    DRINK = true;
                    break;
                default:
                    break;
            }
        }


        return FRUIT && VEGETABLE && PROTEIN && FAT && DRINK && WATER && DESSERT;
    }
}
