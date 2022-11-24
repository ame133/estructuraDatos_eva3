/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva3_1_ordenamientos;

/**
 *
 * @author moviles
 */
public class Eva3_1_ordenamientos {
    public static void main(String[] args) {
        // TODO code application logic here
        int [] arregloDatos = new int [15];
        int [] arregloSel = new int [arregloDatos.length];
        int [] arregloIns = new int [arregloDatos.length];
        int [] arregloQ = new int [arregloDatos.length];
        System.out.println("ARREGLO ORIGINAL");
        llenar(arregloDatos);
        imprimir(arregloDatos);
        System.out.println("");
        System.out.println("SELECTION SORT");
        copiar(arregloDatos,arregloSel);
        imprimir(arregloSel);
        System.out.println("");
        double ini = System.nanoTime();
        selectionSort(arregloSel);
        double fin = System.nanoTime();
        imprimir(arregloSel);
        System.out.println("");
        System.out.println("Selection sort = " + (fin - ini));
        
        System.out.println("INSERTION SORT");
        copiar(arregloDatos, arregloIns);
        imprimir(arregloIns);
        ini = System.nanoTime();
        selectionSort(arregloIns);
        fin = System.nanoTime();
        System.out.println("");
        System.out.println("Insertion sort = " + (fin-ini));
        
        System.out.println("QUICK SORT");
        copiar(arregloDatos, arregloQ);
        imprimir(arregloQ);
        ini = System.nanoTime();
        System.out.println("");
        quickSort(arregloQ);
        fin = System.nanoTime();
        imprimir(arregloQ);
        System.out.println("");
        System.out.println("Quick sort = " + (fin-ini));
    }
    //llenar arreglo
    public static void llenar(int [] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int)(Math.random()*100);
        }
    }
    
    public static void imprimir(int [] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] < 10) {
                System.out.print("[" + arreglo[i] + "]");
            }else{
                System.out.print("[" + arreglo[i] + "]");
            }
            System.out.print("");
        }
    }
    public static void copiar(int [] arreglo, int [] copia){
        for (int i = 0; i < arreglo.length; i++) {
            copia[i] = arreglo[i];
        }
    }
    public static void selectionSort(int [] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            int min = i;
            //busco el elemento (posicion) mas pequeño
            for (int j = i+1; j < arreglo.length; j++) {
                //buscar el mas pequeño
                if (arreglo[min] > arreglo[j]) {
                    min = j;
                }
            }
            //SWAP intercambiar
            if (min != i) {
                int temp = arreglo[i];
                arreglo[i] = arreglo[min];
                arreglo[min] = temp;
            }
        }
    }
    public static void insertionSort(int[] arreglo){
        for (int i = 1; i < arreglo.length; i++) {
            int temp = arreglo[i];
            int insP = i;
            //buscamos en que punto debde de quedar temp
            //esa posicion queda almacenada en insP
            for (int prev = i-1; prev >=0; prev--) {
                if (arreglo[prev]>temp) {
                    //swap
                    arreglo [insP] = arreglo[prev];
                    insP--;
                }else{
                    break;
                }
            }
            arreglo[insP] = temp;
        }
    }
    //QUICKSORT
    public static void quickSort(int[] arreglo){
        quickSortRec(arreglo, 0, arreglo.length-1);
    }
    private static void quickSortRec(int [] arreglo, int ini, int fin){
        //pivote es una posicion
        //dos indices
        //ind_gran, busca los mayores al pivote
        //ind_peq, busca los menores al pivote
        //si se cruzan, se intercambia pivote con indice_peq
        int pivote, big, small, temp;
        pivote = ini;
        big = ini;
        small = fin;
        //mover los indices
        while(big < small){ //los indices se cruzaron
            while((arreglo[big] <= arreglo[pivote]) && (big < small)) //buscar los elementos más grandes que el pivote
                big++;
            while(arreglo[small] > arreglo[pivote])
                small--;

            //verificamos que no hayan cruzado los indices
            if(big<small){
                temp = arreglo[big];
                arreglo[big] = arreglo[small];
                arreglo[small] = temp;
            }
        }
        //intercambiar pivote con small
        temp = arreglo[pivote];
        arreglo[pivote] = arreglo[small];
        arreglo[small] = temp;
        pivote = small;
        
        //llamada recursiva
        if(pivote>ini)
            quickSortRec(arreglo, ini, pivote-1);
        if(pivote<fin)
            quickSortRec(arreglo, pivote+1, fin);
    }
}
