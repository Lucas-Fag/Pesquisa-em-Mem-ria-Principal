public class PesquisaSequencialComSentinela implements Pesquisa {

    private static int cont = 0;
    private static int[] vetorCrescente = CriaVetor.criaVetorCrescente(100);
    private static int[] vetorAleatorio = CriaVetor.criaVetorAleatorio(100); 
    
    @Override
    public int algoritmo(int chave, int[] vetor) {
        cont = 0;
        int i = 0;
        int c[] = new int[vetor.length + 1];
        System.arraycopy(vetor, i, c, i, vetor.length);
        c[vetor.length] = chave; //A última posição do vetor possui o sentinela
        while (c[i] != chave) {
            cont++;
            i++;
        }

        cont++;

        if (i < vetor.length - 1) {
            return i;
        }
        return -1; //indice inválido
    }


    @Override
    public void piorCaso() {
        algoritmo(101, vetorCrescente);
        System.out.println(cont + " Operações");
    }

    @Override
    public void medioCaso() {
        int busca = (int) (Math.random() * 100);
        algoritmo(busca, vetorAleatorio);
        System.out.println("Busca: " + busca);
        CriaVetor.print(vetorAleatorio);
        System.out.println("Operações: " + cont);
    }

    @Override
    public void melhorCaso() {
        algoritmo(0, vetorCrescente);
        System.out.println("Operações: " + cont);
    }

}
