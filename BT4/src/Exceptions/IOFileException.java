package Exceptions;

import org.apache.log4j.Logger;

public class IOFileException extends RuntimeException{
    final Logger log = Logger.getLogger(IOFileException.class);
    public IOFileException(String message){
        super(message);
    }
    public IOFileException(){
    }
    public IOFileException(Throwable throwable){
        super(throwable);
    }
    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    @Override
    public String getMessage() {
        return "Lỗi đọc ghi file.";
    }
}
