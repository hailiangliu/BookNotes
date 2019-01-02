package org.lig.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputUtil {

    public static String getString(){
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter a String :");
            String val = bufferedReader.readLine();

            return val;
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
//            if(bufferedReader != null){
//                try {
//                    bufferedReader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                bufferedReader = null;
//            }
        }
        return null;
    }
}
