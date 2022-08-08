public class PesquisaBinaria implements Pesquisa {

    private static int cont = 0;
    private static int[] vetorCrescente = CriaVetor.criaVetorCrescente(100);

    @Override
    public int algoritmo(int chave, int[] v) {
        cont = 0;
        int inicio = 0, meio, fim = v.length - 1;
        while (inicio <= fim) {
            cont++;
            meio = (inicio + fim) / 2;
            if (chave < v[meio]) {
                cont++;
                fim = meio - 1;
            } else if (chave > v[meio]) {
                cont++;
                inicio = meio + 1;
            } else {
                return meio;
            }
        }
        return -1;
    }

    @Override
    public void piorCaso() {
        algoritmo(101, vetorCrescente);
        System.out.println(cont + " Operações");
    }

    @Override
    public void medioCaso() {
        int busca = (int) (Math.random() * 100);
        algoritmo(busca, vetorCrescente);
        System.out.println("Busca: " + busca);
        CriaVetor.print(vetorCrescente);
        System.out.println("Operações: " + cont);
    }

    @Override
    public void melhorCaso() {
        algoritmo(vetorCrescente[(vetorCrescente.length - 1) / 2], vetorCrescente);
        System.out.println("Operações: " + cont);
    }
    
}
