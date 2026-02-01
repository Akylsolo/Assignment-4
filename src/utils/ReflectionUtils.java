package utils;
import java.lang.reflect.*;
public class ReflectionUtils{
    public static void inspect(Object o){
        Class<?> c=o.getClass();
        System.out.println("Class: "+c.getName());
        for(Field f:c.getDeclaredFields())System.out.println("Field: "+f.getName()+" "+f.getType().getSimpleName());
        for(Method m:c.getDeclaredMethods())System.out.println("Method: "+m.getName());
    }
}
