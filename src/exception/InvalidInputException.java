package exception;
public class InvalidInputException extends Exception{
    public InvalidInputException(String m){super(m);}
    public InvalidInputException(String m,Throwable c){super(m,c);}
}
