package exception;
public class DatabaseOperationException extends RuntimeException{
    public DatabaseOperationException(String m,Throwable c){super(m,c);}
}
