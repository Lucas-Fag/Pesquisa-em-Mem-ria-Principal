public class PesquisaInterpolacao implements Pesquisa {

    private static int cont = 0;
    private static int[] vetorCrescente = CriaVetor.criaVetorCrescente(100);
    private static int[] vetorAleatorio = CriaVetor.criaVetorAleatorio(100);

    public int algoritmo(int chave, int v[]) {        
        cont = 0;
        int ini = 0, meio, fim = v.length-1;
        while (ini <= fim && chave >= v[ini] && chave <= v[fim]) {
            meio = ((ini + ((fim-ini) * (chave-v[ini])) / (v[fim]-v[ini])));
            
            cont += 2;

            if (chave == v[meio]) {
                return meio;
            }
            
            cont++;
            if (chave > v[meio]) {
                ini = meio + 1;
            } else {
                fim = meio -1;
            }
        }
        return -1; //Índice impossível
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
