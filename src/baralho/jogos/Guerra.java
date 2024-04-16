package baralho.jogos;

import java.util.Scanner;
import baralho.jogos.Baralho;
import baralho.jogos.Carta;

public class Guerra {
    public static void main(String[] args) {
        int suasVitórias = 0;
        int minhasVitórias = 0;

        Baralho baralho = new Baralho();
        baralho.baralhar();

        int rodadas = getNumeroDeRodadas(baralho.numeroDeCartas());

        for (int i = 0; i < rodadas; i++) {

            Carta suaCarta = baralho.pegaCarta();
            System.out.print("Sua carta: " + suaCarta + "; ");
            Carta minhaCarta = baralho.pegaCarta();
            System.out.print("Minha carta: " + minhaCarta + "; ");

            if (suaCarta.compareTo(minhaCarta) > 0) {
                System.out.println("Voce ganha.");
                suasVitórias++;
            } else if (suaCarta.compareTo(minhaCarta) < 0) {
                System.out.println("Eu ganho.");
                minhasVitórias++;
            } else {
                System.out.println("Empate.");
            }
        } // for

        System.out.println("Voce ganhou " + suasVitórias
                + " vezes, eu ganhei " + minhasVitórias
                + " vezes, "
                + (rodadas - suasVitórias - minhasVitórias)
                + " empates.");
    } // main

    private static int getNumeroDeRodadas(int numeroDeCartasTotal) {
        Scanner sc = new Scanner(System.in);
        int rodadas = 0, numeroDeJogadores = 2;

        System.out.println("Quantas rodadas quer jogar?");
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.println("Digite um numero indicando quantas " +
                    "rodadas quer jogar!");
        }
        rodadas = sc.nextInt();
        if (rodadas > numeroDeCartasTotal / numeroDeJogadores) {
            System.out.println("O numero maximo de rodadas possiveis eh: " + numeroDeCartasTotal / numeroDeJogadores);
            rodadas = getNumeroDeRodadas(numeroDeCartasTotal);
        }
        return rodadas;
    }
}
