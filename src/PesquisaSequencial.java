public class PesquisaSequencial implements Pesquisa {
    
    private static int cont = 0;
    private static int[] vetorCrescente = CriaVetor.criaVetorCrescente(100);
    private static int[] vetorAleatorio = CriaVetor.criaVetorAleatorio(100); 
    
    @Override
    public int algoritmo(int chave, int v[]) {
        cont = 0;

        for (int i = 0; i < v.length; i++) {
            cont += 2;
            if (v[i] == chave) {
                return i;
            }
        }

        return -1; //índice inválido
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