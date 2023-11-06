package main;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    private List<List<Integer>> tabela;

    public Principal() {
        tabela = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tabela.add(new ArrayList<>());
        }
    }

    public void readequarTabela(Principal tabelaAntiga) {
        for (int i = 0; i < tabelaAntiga.size(); i++) {
            List<Integer> lista = tabelaAntiga.get(i);
            for (int numero : lista) {
                int posicao = hash(i);
                tabela.get(posicao).add(numero);
            }
        }
    }
    
    public int size() {
        int size = 0;
        for (List<Integer> lista : tabela) {
            size += lista.size();
        }
        return size;
    }


    public void inserirNumero(int numero) {
        int posicao = hash(numero);
        tabela.get(posicao).add(numero);
    }

    public List<Integer> get(int posicao) {
        return tabela.get(posicao);
    }

    private int hash(int valorAntigo) {
        return valorAntigo % 5;  // Função hash de divisão
    }

    public static void main(String[] args) {
    	Principal tabelaAntiga = new Principal();
        // Inserir valores na tabela antiga...

    	Principal tabelaNova = new Principal();
        tabelaNova.readequarTabela(tabelaAntiga);
        // Agora a tabelaNova contém os valores readequados
    }
}
