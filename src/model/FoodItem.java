package model;
import exception.InvalidInputException;
public class FoodItem extends MenuItem{
    private boolean vegetarian;private double caloriesPer100g;
    public FoodItem(){}public FoodItem(int id,String name,double price,boolean vegetarian,double caloriesPer100g){
        super(id,name,price);this.vegetarian=vegetarian;this.caloriesPer100g=caloriesPer100g;}
    public boolean isVegetarian(){return vegetarian;}public void setVegetarian(boolean vegetarian){this.vegetarian=vegetarian;}
    public double getCaloriesPer100g(){return caloriesPer100g;}public void setCaloriesPer100g(double caloriesPer100g){this.caloriesPer100g=caloriesPer100g;}
    @Override public double calculateCalories(){return caloriesPer100g;}
    @Override public void validate()throws InvalidInputException{
        super.validate();if(caloriesPer100g<=0)throw new InvalidInputException("Calories must be > 0");
    }
    @Override public String entityType(){return "FoodItem";}
}
