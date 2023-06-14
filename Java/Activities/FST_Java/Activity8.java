package org.activities;

class CustomException extends Exception{
private String message = null;

CustomException(String customMessage){
    this.message = customMessage;
}

@Override
public String getMessage(){
    return message;
}
}


public class Activity8 {
    public static void main(String[] args) {
    try {
    exceptionTest("This time it will pass");
    exceptionTest(null);
    exceptionTest("Will not execute");
    }
    catch (CustomException e) {
        System.out.println("Inside catch block");
    }
    }
String string = "";
    public static void exceptionTest(String message) throws CustomException{
        if(message ==null)
            throw new CustomException("String value is null");
        else
            System.out.println(message);
    }
}
