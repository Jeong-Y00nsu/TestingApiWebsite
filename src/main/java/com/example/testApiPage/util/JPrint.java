package com.example.testApiPage.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JPrint {
    public static Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();

    public static String toString(Object o){
        if( o == null ) return "";
        return gson.toJson(o);
    }

    public static void print(Object o) {System.out.println(toString(o));}
}
