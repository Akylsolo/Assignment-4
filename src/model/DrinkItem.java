package model;
import exception.InvalidInputException;
public class DrinkItem extends MenuItem{
    private int volumeMl;private boolean alcoholic;
    public DrinkItem(){}public DrinkItem(int id,String name,double price,int volumeMl,boolean alcoholic){
        super(id,name,price);this.volumeMl=volumeMl;this.alcoholic=alcoholic;}
    public int getVolumeMl(){return volumeMl;}public void setVolumeMl(int volumeMl){this.volumeMl=volumeMl;}
    public boolean isAlcoholic(){return alcoholic;}public void setAlcoholic(boolean alcoholic){this.alcoholic=alcoholic;}
    @Override public double calculateCalories(){return alcoholic?volumeMl*0.5:volumeMl*0.2;}
    @Override public void validate()throws InvalidInputException{
        super.validate();if(volumeMl<=0)throw new InvalidInputException("Volume must be > 0");
    }
    @Override public String entityType(){return "DrinkItem";}
}
