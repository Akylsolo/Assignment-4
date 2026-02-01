package utils;
import model.*;import java.util.*;import java.util.stream.*;
public class SortingUtils{
    public static List<MenuItem> sortByPriceAsc(List<MenuItem> list){
        return list.stream().sorted((a,b)->Double.compare(a.price(),b.price())).collect(Collectors.toList());
    }
    public static List<MenuItem> sortByPriceDesc(List<MenuItem> list){
        return list.stream().sorted((a,b)->Double.compare(b.price(),a.price())).collect(Collectors.toList());
    }
    public static Optional<MenuItem> cheapestFood(List<MenuItem> list){
        return list.stream().filter(i->i instanceof FoodItem).min(Comparator.comparingDouble(MenuItem::price));
    }
}
