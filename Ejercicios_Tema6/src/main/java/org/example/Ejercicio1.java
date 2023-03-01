package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejercicio1 {
    public static int mayor(int a, int b){
        if (a>b){
            return a;
        }else{
            return b;
        }
    }

    public static int comparar(int a, int b){
        if (a>b){
            return 1;
        }else if (a<b){
            return -1;
        }else{
            return 0;
        }
    }
    public static void main(String[] args) {
        System.out.println(mayor(5, 6));
        System.out.println(comparar(5, 6));
    }
}
