package baralho.jogos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Um baralho comum de cartas. Num baralho comum, tem 52 cartas: 13 valores (AS,
 * 2, 3, ..., 10, valete, dama, rei) de 4 naipes (ouros, espadas, copas, paus).
 *
 * @author Jacques Philippe Sauvé, Raquel Vigolvino Lopes
 * @version 2.0 <br>
 */
public class Baralho {
    /**
     * O baralho é armazenado aqui. É protected porque alguns baralhos subclasses
     * dessa classe poderão talvez ter que mexer diretamente aqui para construir
     * baralhos especiais.
     */
    protected List<Carta> baralho;

    /**
     * Construtor de um baralho comum.
     */
    public Baralho() {
        baralho = new ArrayList<Carta>();
        for (Valor valor : Valor.values()) {
            for (Naipe naipe : Naipe.values()) {
                baralho.add(new Carta(valor, naipe));
            }
        }
    }

    /**
     * Imprime o baralho na ordem em que está baralhado.
     */
    public void imprimeBaralho() {
        for (Iterator<Carta> iterator = baralho.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
    }
    /**
     * Cria uma carta para este baralho.
     *
     * @param valor O valor da carta a criar.
     * @param naipe O naipe da carta a criar.
     * @return A carta criada.
     */
    protected Carta criaCarta(Valor valor, Naipe naipe) {
        return new Carta(valor, naipe);
    }

    /**
     * Recupera o valor da menor carta possível deste baralho. É possível fazer um
     * laço de menorValor() até maiorValor() para varrer todos os valores possíveis
     * de cartas.
     *
     * @return O menor valor.
     */
    public int menorValor() {
        return Carta.menorValor();
    }

    /**
     * Recupera o valor da maior carta possível deste baralho. É possível fazer um
     * laço de menorValor() até maiorValor() para varrer todos os valores possíveis
     * de cartas.
     *
     * @return O maior valor.
     */
    public int maiorValor() {
        return Carta.maiorValor();
    }

    /**
     * Recupera o "primeiro naipe" das cartas que podem estar no baralho. Ser
     * "primeiro naipe" não significa muita coisa, já que naipes não tem valor (um
     * naipe não é menor ou maior que o outro). Fala-se de "primeiro naipe" e
     * "último naipe" para poder fazer um laço de primeiroNaipe() até últimoNaipe()
     * para varrer todos os naipes possíveis de cartas.
     *
     * @return O primeiro naipe.
     */
    public Naipe primeiroNaipe() {
        return Carta.primeiroNaipe();
    }

    /**
     * Recupera o "último naipe" das cartas que podem estar no baralho. Ser "último
     * naipe" não significa muita coisa, já que naipes não tem valor (um naipe não
     * é menor ou maior que o outro). Fala-se de "primeiro naipe" e "último naipe"
     * para poder fazer um laço de primeiroNaipe() até últimoNaipe() para varrer
     * todos os naipes possíveis de cartas.
     *
     * @return O primeiro naipe.
     */
    public Naipe ultimoNaipe() {
        return Carta.ultimoNaipe();
    }

    /**
     * Recupera o número de cartas atualmente no baralho.
     *
     * @return O número de cartas no baralho.
     */
    public int numeroDeCartas() {
        return baralho.size();
    }

    /**
     * Recupera um iterador para poder varrer todas as cartas do baralho.
     *
     * @return Um iterador do baralho.
     */
    public Iterator<Carta> iterator() {
        return baralho.iterator();
    }

    /**
     * Baralha (traça) o baralho.
     */
    public void baralhar() {
        int posicao;
        Random rand = new Random();
        for (posicao = 0; posicao < numeroDeCartas(); posicao++) {
            // escolhe uma posição aleatória entre posição e númeroDeCartas()-1
            int posicaoAleatoria = rand.nextInt(baralho.size());
            // troca as cartas em posição e posAleatória
            Carta temp = baralho.get(posicao);
            baralho.set(posicao, baralho.get(posicaoAleatoria));
            baralho.set(posicaoAleatoria, temp);
        }
    }

    /**
     * Retira uma carta do topo do baralho e a retorna. A carta é removida do
     * baralho.
     *
     * @return A carta retirada do baralho.
     */
    public Carta pegaCarta() {
        if (numeroDeCartas() == 0)
            return null;
        return baralho.remove(numeroDeCartas() - 1);
    }

    public static void main(String[] args) {
        Baralho baralho = new Baralho();
        baralho.baralhar();
        baralho.imprimeBaralho();
    }
}
