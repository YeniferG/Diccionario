package com.sofka.diccionario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManejadorArchivo {

    Diccionario palabra = new Diccionario();
    String archivo = "diccionario.txt";

    public String primeraLetraMayuscula(String palabra){
        String mayuscula = (palabra.substring(0,1)).toUpperCase();
        String primeraMayuscula = mayuscula.concat(palabra.substring(1,palabra.length()));
        return primeraMayuscula;
    }

    public void agregarDatos(Diccionario palabra){
        try {
            FileWriter myWriter = new FileWriter(archivo, true);
            myWriter.write(primeraLetraMayuscula(palabra.getPalabraEspanol()) + " = " + primeraLetraMayuscula(palabra.getPalabraIngles()) + "\n");
            myWriter.close();
            System.out.println("Palabra agregada correctamente!");
        } catch (IOException e) {
            System.out.println("No se pudo agregar la palabra");
            e.printStackTrace();
        }

    }

    public void imprimirArchivo(){
        try {
            FileReader r = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(r);

            String temp = "";
            String check = buffer.readLine();
            if(check != null){
                System.out.println(check);;
                while(temp != null){
                    temp = buffer.readLine();
                    if(temp== null){
                        break;
                    }
                    System.out.println(temp);
                };
            }
            else{
                System.out.println("No se encontro información");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void buscarTraduccion(String palabraEspanol){
        palabraEspanol = primeraLetraMayuscula(palabraEspanol);
        try {
            FileReader r = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(r);

            String temp = "";

                while(temp != null){
                    temp = buffer.readLine();
                    if(temp != null){
                        String[] listaTemporal = temp.split(" = ");
                        if (listaTemporal[0].equals(palabraEspanol)){
                            System.out.println("La Traducción de " + palabraEspanol + " es: " + listaTemporal[1]);
                            break;
                        }
                    }
                    else {
                        System.out.println("No se encuentra la palabra " + palabraEspanol + " en el Dicionario");
                        break;
                    }
                };

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
