package baralho.jogos;

enum Valor {
    AS(1), DOIS(2), TRES(3), QUATRO(4), CINCO(5), SEIS(6), SETE(7),
    OITO(8), NOVE(9), DEZ(10), VALETE(11), DAMA(12), REI(13);

    private final int valor;

    Valor(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }

}
