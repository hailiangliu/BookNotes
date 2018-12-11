package org.lig.swapInteger;

import java.lang.reflect.Field;

/**
 *
 *
 */
public class Swaper {

    public static void swap(Integer a, Integer b) throws NoSuchFieldException, IllegalAccessException {

        int temp = a.intValue();


        Field aField = a.getClass().getDeclaredField( "value" );
        aField.setAccessible( true );
        aField.setInt(a, b.intValue()  );

        Field bField = a.getClass().getDeclaredField( "value" );
        bField.setAccessible( true );
        bField.setInt(b, temp  );

    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Integer a = 156;
        Integer b = -888;

        System.out.println("a="+a+", b="+b);

        Swaper.swap( a, b );

        System.out.println("a="+a+", b="+b);

    }
}
