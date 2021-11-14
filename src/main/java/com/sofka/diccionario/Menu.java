package com.sofka.diccionario;

import java.awt.*;
import java.util.Scanner;

public class Menu {

    Scanner entrada = new Scanner(System.in);
    ManejadorArchivo datos = new ManejadorArchivo();


    public void mostrarMenu(){
        System.out.println("Por favor seleciona una de las siguientes opciones: " +
                "\n1. Registrar una palabra " +
                "\n2. Imprimir el diccionario " +
                "\n3. Traducir una palabra");
    }

    public void cargarMenu(){

        mostrarMenu();
        int opcion = entrada.nextInt();

        switch (opcion){

            case 1:
            {
                System.out.println("*** REGISTRAR UNA PALABRA ***");
                System.out.println("Dame la palabra en español: ");
                String solucionador = entrada.nextLine(); //Esta linea se agrega por que el compilador no quiere coger el primer scanner
                String palabraEspanol = entrada.nextLine();
                System.out.println("Dame la palabra en inglés: ");
                String palabraIngles = entrada.nextLine();
                Diccionario palabra = new Diccionario(palabraEspanol, palabraIngles);
                datos.agregarDatos(palabra);
                System.out.println("------------------------------------------------");
                mostrarMenuContinuar();
            }break;
            case 2:
            {
                System.out.println("***DICCIONARIO*** ");
                datos.imprimirArchivo();
                System.out.println("------------------------------------------------");
                mostrarMenuContinuar();
            }break;
            case 3:
            {
                System.out.println("*** BUSCADOR DE PALABRAS ***");
                System.out.println("Por favor digita la palabra que necesitas: ");
                String solucion = entrada.nextLine();
                String palabra = entrada.nextLine();
                datos.buscarTraduccion(palabra);
                System.out.println("------------------------------------------------");
                mostrarMenuContinuar();
            }break;
            default:{
                System.out.println("Opcion Invalida!");
            }
        }

    }

    public void mostrarMenuContinuar(){

        System.out.println("¿Desea permanecer en el Diccionario? \n1. Continuar y volver al menu principal \n2. Salir");
        int continuar = entrada.nextInt();
        switch (continuar){
            case 1:{
                System.out.println("///////////////////////////////////////////////////\n");
                cargarMenu();
            }break;
            case 2:{
                System.out.println("***************************************************************");
                System.out.println("Gracias por utilizar nuestro Diccionario \n***VUELVE PRONTO***");
            }break;

            default:{
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("Opcion Invalida! \nDigita una opción valida por favor: ");
                cargarMenu();
            }
        }
    }

}
