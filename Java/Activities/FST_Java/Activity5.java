package org.activities;

abstract class Book {
    String title;
    abstract void setTitle(String string);
    public String getTitle(){
        return title;
    }
}

 class MyBook extends Book{
    @Override
    void setTitle(String string) {
       title = string ;
    }
}

public class Activity5{
    public static void main(String[] args) {
        String title = "Title of the book";
        Book myBook = new MyBook();
        myBook.setTitle(title);
        System.out.println("The title is: " + myBook.getTitle());
    }
}