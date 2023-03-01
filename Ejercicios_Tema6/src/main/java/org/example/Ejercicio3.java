package org.example;

import java.lang.reflect.Array;
import java.util.*;

public class Ejercicio3 {
    static Scanner sc = new Scanner(System.in);
    static Random r = new Random();

    public static void crearTabla(int[] tabla, int limiteInferior, int limiteSuperior) {
        for (int i = 0; i < tabla.length; i++) {
            tabla[i] = r.nextInt(limiteSuperior - limiteInferior + 1) + limiteInferior;
        }
    }

    public static int mayor(int[] tabla) {
        int mayor = tabla[0];
        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i] > mayor) {
                mayor = tabla[i];
            }
        }
        return mayor;
    }
    public static void main(String[] args) {
        int[] tabla = new int[10];
        System.out.println("Introduce un limite inferior");
        int limiteInferior = sc.nextInt();
        System.out.println("Introduce un limite superior");
        int limiteSuperior = sc.nextInt();
        crearTabla(tabla, limiteInferior, limiteSuperior);
        System.out.println(Arrays.toString(tabla));
        System.out.println("El mayor es: " + mayor(tabla));

    }
}
