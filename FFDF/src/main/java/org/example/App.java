package org.example;

import java.sql.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )

    {
        java.sql.Date date = new Date(120,11,31+34);
        System.out.println(date.toString());
        System.out.println(date.toLocalDate().plusDays(50));
        System.out.println( "Hello World!" );
    }

}
