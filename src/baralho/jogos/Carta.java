package baralho.jogos;

/**
 * Uma carta de um baralho comum. Num baralho comum, tem 52 cartas: 13 valores
 * (AS, 2, 3, ..., 10, valete, dama, rei) de 4 naipes (ouros, espadas, copas,
 * paus). Cartas podem ser criadas, comparadas (quanto a seu valor), etc.
 *
 * @author Jacques Philippe Sauvé, Raquel Vigolvino Lopes
 * @version 1.1 <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 */
public class Carta implements Comparable<Carta> {
    private Valor valor;
    private Naipe naipe;

    /**
     * Construtor de uma carta comum.
     *
     * @param valor O valor da carta (AS, 2, 3, ..., 10, VALETE, DAMA, REI).
     * @param naipe O naipe da carta (PAUS, OUROS, COPAS, ESPADAS).
     */
    public Carta(Valor valor, Naipe naipe) {
        this.valor = valor;
        this.naipe = naipe;
    }

    /**
     * Recupera o valor da carta.
     *
     * @return O valor da carta.
     */
    public int getValor() {
        return valor.getValor();
    }

    /**
     * Recupera o naipe da carta.
     *
     * @return O naipe da carta.
     */
    public Naipe getNaipe() {
        return naipe;
    }

    /**
     * Recupera o valor da menor carta deste tipo que pode ser criada. É possível
     * fazer um laço de menorValor() até maiorValor() para varrer todos os valores
     * possíveis de cartas.
     *
     * @return O menor valor.
     */
    public static int menorValor() {
        return Valor.AS.getValor();
    }

    /**
     * Recupera o valor da maior carta deste tipo que pode ser criada. É possível
     * fazer um laço de menorValor() até maiorValor() para varrer todos os valores
     * possíveis de cartas.
     *
     * @return O maior valor.
     */
    public static int maiorValor() {
        return Valor.REI.getValor();
    }

    /**
     * Recupera o "primeiro naipe" das cartas deste tipo. Ser "primeiro naipe" não
     * significa muita coisa, já que naipes não tem valor (um naipe não é menor ou
     * maior que o outro). Fala-se de "primeiro naipe" e "último naipe" para poder
     * fazer um laço de primeiroNaipe() até últimoNaipe() para varrer todos os
     * naipes possíveis de cartas.
     *
     * @return O primeiro naipe.
     */
    public static Naipe primeiroNaipe() {
        return Naipe.COPAS;
    }

    /**
     * Recupera o "último naipe" das cartas deste tipo. Ser "último naipe" não
     * significa muita coisa, já que naipes não tem valor (um naipe não é menor ou
     * maior que o outro). Fala-se de "primeiro naipe" e "último naipe" para poder
     * fazer um laço de primeiroNaipe() até últimoNaipe() para varrer todos os
     * naipes possíveis de cartas.
     *
     * @return O primeiro naipe.
     */
    public static Naipe ultimoNaipe() {
        return Naipe.PAUS;
    }

    /**
     * Compare esta carta a outra.
     *
     * @param outra A carta a comparar a esta.
     * @return Zero se forem iguais. Um valor < 0 se a carta for menor que a outra
     * carta. Um valor > 0 se a carta for maior que a outra carta.
     */
    public int compareTo(Carta outra) {
        return getValor() - outra.getValor();
    }

    /**
     * Testa a igualdade de um objeto com esta carta.
     *
     * @param objeto O objeto a comparar com esta carta.
     * @return true se o objeto for igual a esta carta, false caso contrário.
     */
    public boolean equals(Object objeto) {
        if (!(objeto instanceof Carta)) {
            return false;
        }
        Carta outra = (Carta) objeto;
        return getValor() == outra.getValor() &&
                getNaipe() == outra.getNaipe();
    }

    /**
     * Representa a carta como String.
     *
     * @return Um string representando a carta.
     */
    public String toString() {
        return valor.toString() + " de " + naipe.toString();
    }
}
