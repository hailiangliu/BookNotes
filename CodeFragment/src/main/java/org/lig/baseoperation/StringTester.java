package org.lig.baseoperation;

import java.io.IOException;

/**
 * String
 *
 */
public class StringTester {

    public static void main(String[] args) throws IOException {
        String a = "abc";
        String b = "abc";
        System.out.println( a == b ); // true

        String c = new String( "abc" );
        String d = new String( "abc" );

        System.out.println( a == c );//false
        System.out.println( d == c );//false


        String e = "a" + "b" + "c";
        System.out.println( a == e );// true

        String f = new StringBuilder( "a" ).append( "b" ).append( "c" ).toString();
        System.out.println( a == f );

      //  System.in.read();
    }
}
