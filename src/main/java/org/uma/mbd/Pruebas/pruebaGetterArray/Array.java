package org.uma.mbd.Pruebas.pruebaGetterArray;

import java.util.Arrays;

public class Array {
    int[] myNum;

    public Array(int longitud) {
        myNum = new int[longitud];
        for (int i = 0; i < longitud; i++) {
            myNum[i] = i + 3;
        }
    }

    public int getMyNum(int i) {
        return myNum[i];
    }

    public String toString() {
        return Arrays.toString(myNum);
    }

    public static void main(String[] args) {
        Array nuevo = new Array(10);
        System.out.println(nuevo);
        int a = nuevo.getMyNum(5);
        System.out.println(a);
    }
}
