package com.alcanciaApp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Alcancia {

    private static Alcancia instancia;
    private List<Moneda> monedaList;

    public static Alcancia getInstancia() {
        if (instancia == null) {
            instancia = new Alcancia();
        }
        return instancia;
    }

    private Alcancia() {
        this.monedaList = new ArrayList<>();
    }

    public List<Moneda> getMonedaList() {
        return monedaList;
    }

    /**
     * Permite conocer la cantidad de monedas
     */
    public void conocerCantidadMonedas() {
        System.out.println("La alcancía cuenta con "
                + this.monedaList.size()
                + " moneda(s)");
    }

    /**
     * Permite conocer la cantidades de monedas segun la denominacion de esta
     *
     * @param valor valor de la moneda
     */
    public void conocerCantidadMonedasDenominacion(int valor) {
        long cantidad = this.monedaList.stream()
                .filter(m -> m.getValor() == valor)
                .count();
        System.out.println("La alcancía cuenta con "
                + cantidad
                + " moneda(s) de " + valor + "$");
    }

    /**
     * Permite conocer la cantidad de dinero segun la denominacion de la moneda
     *
     * @param valor valor de la moneda
     */
    public void conocerCantidadDineroDenominacion(int valor) {
        Optional<Integer> total = this.monedaList.stream()
                .filter(m -> m.getValor() == valor)
                .map(m -> m.getValor())
                .reduce((sum, v) -> {
                    return sum + v;
                });
        System.out.println("La alcancía cuenta con "
                + (total.isPresent() ? total.get() : "0")
                + "$ en monedas de " + valor);
    }

}
