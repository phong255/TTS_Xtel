package Exceptions;

import org.apache.log4j.Logger;

public class DatabaseException extends RuntimeException{
    final Logger log = Logger.getLogger(DatabaseException.class);
    public DatabaseException(String message){
        super(message);
    }
    public DatabaseException(Throwable throwable){
        super(throwable);
    }
    public DatabaseException(){
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }

    @Override
    public String getMessage() {
        return "Lỗi kết nối database.";
    }
}
