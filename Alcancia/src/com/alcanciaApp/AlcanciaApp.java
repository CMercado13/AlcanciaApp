package com.alcanciaApp;

import com.alcanciaApp.model.Alcancia;
import com.alcanciaApp.model.Moneda;
import java.util.Scanner;

/* 
* La alcancía solo puede recibir monedas de 50, 100, 200, 500 y 1000 pesos colombianos
* En cualquier momento yo puedo saber la cantidad de monedas dentro de la alcancía
* En cualquier momento yo puedo saber la cantidad de monedas por denominación 
    (50, 100, 200, 500 y 100) dentro de la alcancía. Es decir, yo puedo preguntar 
    cuántas monedas de 100 tengo y la aplicación debe darme el resultado
* En cualquier momento yo puedo saber la cantidad de dinero por denominación 
    dentro de la alcancía. Es decir, yo puedo preguntar cuanto dinero tengo en monedas 
    de 100 y la aplicación debe darme el resultado
 */
public class AlcanciaApp {

    private static boolean salir = true;

    public static void main(String[] args) {
        int opcion;
        Alcancia alcancia = Alcancia.getInstancia();
        Scanner sn = new Scanner(System.in);
        while (salir) {
            System.out.println("****** BIENVENIDO A TU ALCANCÍA ******");
            System.out.println("1. Agregar moneda.");
            System.out.println("2. Conocer cantidad de monedas.");
            System.out.println("3. Conocer cantidad de monedas segun su denomicación.");
            System.out.println("4. Conocer la cantidad de dinero segun denominación de la moneda.");
            System.out.println("5. Salir.");

            System.out.println("\n");
            System.out.println("Escribe una de las opciones");
            try {
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1:
                        AlcanciaApp.agregarMonedad(sn, alcancia);
                        //System.out.println(opcion);
                        break;
                    case 2:
                        AlcanciaApp.conocerCantidadMonedas(alcancia);
                        break;
                    case 3:
                        AlcanciaApp.conocerCantidadMonedasDenominacion(sn, alcancia);
                        break;
                    case 4:
                        AlcanciaApp.conocerCantidadDineroDenominacion(sn, alcancia);
                        break;
                    case 5:
                        AlcanciaApp.salir();
                        break;
                    default:
                        System.out.println("No seleccionaste una opción disponible");
                        break;

                }
            } catch (Exception e) {
                sn = new Scanner(System.in);
                System.out.println("Opcion no valida");
            }
        }
    }

    public static void agregarMonedad(Scanner sn, Alcancia alcancia) {
        System.out.println("****** INGRESAR MONEDA ******");
        System.out.println("1. Moneda de 50$");
        System.out.println("2. Moneda de 100$");
        System.out.println("3. Moneda de 200$");
        System.out.println("4. Moneda de 500$");
        System.out.println("5. Moneda de 1000$");
        System.out.println("6. Conocer cantidad de monedas.");
        System.out.println("7. Conocer cantidad de monedas segun su denominación.");
        System.out.println("8. Conocer la cantidad de dinero segun denominación de la moneda.");
        System.out.println("9. Salir.");
        System.out.println("\n");
        System.out.println("Escribe una de las opciones");
        int opcion = sn.nextInt();
        switch (opcion) {
            case 1:
                alcancia.getMonedaList().add(new Moneda(50));
                System.out.println("Moneda agregada");
                break;
            case 2:
                alcancia.getMonedaList().add(new Moneda(100));
                System.out.println("Moneda agregada");
                break;
            case 3:
                alcancia.getMonedaList().add(new Moneda(200));
                System.out.println("Moneda agregada");
                break;
            case 4:
                alcancia.getMonedaList().add(new Moneda(500));
                System.out.println("Moneda agregada");
                break;
            case 5:
                alcancia.getMonedaList().add(new Moneda(1000));
                System.out.println("Moneda agregada");
                break;
            case 6:
                AlcanciaApp.conocerCantidadMonedas(alcancia);
                break;
            case 7:
                AlcanciaApp.conocerCantidadMonedasDenominacion(sn, alcancia);
                break;
            case 8:
                AlcanciaApp.conocerCantidadDineroDenominacion(sn, alcancia);
                break;
            case 9:
                AlcanciaApp.salir();
                break;
            default:
                System.out.println("No seleccionaste una opción disponible");
                break;
        }
    }

    public static void conocerCantidadMonedas(Alcancia alc) {
        System.out.println("****** CONOCER CANTIDAD DE MONEDA ******");
        alc.conocerCantidadMonedas();
    }

    public static void conocerCantidadMonedasDenominacion(Scanner sn, Alcancia alcancia) {
        System.out.println("****** CONOCER CANTIDAD DE MONEDA ******");
        System.out.println("****** SELECCIONE DENOMICACIÓN ******");
        System.out.println("1. 50$");
        System.out.println("2. 100$");
        System.out.println("3. 200$");
        System.out.println("4. 500$");
        System.out.println("5. 1000$");
        System.out.println("6. Conocer cantidad de monedas.");
        System.out.println("7. Conocer la cantidad de dinero segun denominación de la moneda.");
        System.out.println("8. Salir.");
        int opcion = sn.nextInt();
        switch (opcion) {
            case 1:
                alcancia.conocerCantidadMonedasDenominacion(50);
                break;
            case 2:
                alcancia.conocerCantidadMonedasDenominacion(100);
                break;
            case 3:
                alcancia.conocerCantidadMonedasDenominacion(200);
                break;
            case 4:
                alcancia.conocerCantidadMonedasDenominacion(500);
                break;
            case 5:
                alcancia.conocerCantidadMonedasDenominacion(1000);
                break;
            case 6:
                AlcanciaApp.conocerCantidadMonedas(alcancia);
                break;
            case 7:
                AlcanciaApp.conocerCantidadDineroDenominacion(sn, alcancia);
                break;
            case 8:
                AlcanciaApp.salir();
                break;
            default:
                System.out.println("No seleccionaste una opción disponible");
                break;
        }
    }

    public static void conocerCantidadDineroDenominacion(Scanner sn, Alcancia alcancia) {
        System.out.println("****** CONOCER CANTIDAD DE DINERO ******");
        System.out.println("****** SELECCIONE DENOMICACIÓN ******");
        System.out.println("1. 50$");
        System.out.println("2. 100$");
        System.out.println("3. 200$");
        System.out.println("4. 500$");
        System.out.println("5. 1000$");
        System.out.println("6. Conocer cantidad de monedas.");
        System.out.println("7. Conocer cantidad de monedas segun su denominación.");
        System.out.println("8. Salir.");
        int opcion = sn.nextInt();
        switch (opcion) {
            case 1:
                alcancia.conocerCantidadDineroDenominacion(50);
                break;
            case 2:
                alcancia.conocerCantidadDineroDenominacion(100);
                break;
            case 3:
                alcancia.conocerCantidadDineroDenominacion(200);
                break;
            case 4:
                alcancia.conocerCantidadDineroDenominacion(500);
                break;
            case 5:
                alcancia.conocerCantidadDineroDenominacion(1000);
                break;
            case 6:
                AlcanciaApp.conocerCantidadMonedas(alcancia);
                break;
            case 7:
                AlcanciaApp.conocerCantidadMonedasDenominacion(sn, alcancia);
                break;
            case 8:
                AlcanciaApp.salir();
                break;
            default:
                System.out.println("No seleccionaste una opción disponible");
                break;
        }
    }

    public static void salir() {
        AlcanciaApp.salir = false;
        System.out.println("Finalizó el programa");
    }

}
