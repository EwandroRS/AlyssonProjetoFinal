package model;

import java.util.*;
import java.io.*;

public class MapaCidades {
    private TreeSet<Cidade> cidades;
    private HashMap<Cidade, Set<Rota>> grafo;

    public MapaCidades() {
        cidades = new TreeSet<>();
        grafo = new HashMap<>();
    }

    public void adicionarCidade(Cidade cidade) {
        cidades.add(cidade);
        grafo.putIfAbsent(cidade, new HashSet<>());
    }

    public void conectarCidades(Cidade origem, Cidade destino, int distancia) {
        if (!grafo.containsKey(origem) || !grafo.containsKey(destino)) return;
        grafo.get(origem).add(new Rota(destino, distancia));
        grafo.get(destino).add(new Rota(origem, distancia));
    }

    public void listarConexoes(Cidade cidade) {
        System.out.println("Conexões de " + cidade.getNome() + ":");
        Set<Rota> rotas = grafo.get(cidade);
        if (rotas == null || rotas.isEmpty()) {
            System.out.println("  Nenhuma conexão encontrada.");
            return;
        }
        for (Rota rota : rotas) {
            System.out.println("  " + rota);
        }
    }

    public boolean existeCaminho(Cidade origem, Cidade destino) {
        Set<Cidade> visitados = new HashSet<>();
        return busca(origem, destino, visitados);
    }

    private boolean busca(Cidade atual, Cidade destino, Set<Cidade> visitados) {
        if (atual.equals(destino)) return true;
        visitados.add(atual);
        for (Rota rota : grafo.getOrDefault(atual, Collections.emptySet())) {
            Cidade vizinha = rota.getDestino();
            if (!visitados.contains(vizinha)) {
                if (busca(vizinha, destino, visitados)) return true;
            }
        }
        return false;
    }

    public void listarCidadesSemConexao() {
        for (Cidade cidade : cidades) {
            if (grafo.get(cidade) == null || grafo.get(cidade).isEmpty()) {
                System.out.println("- " + cidade);
            }
        }
    }

    public Cidade getCidadeMaisPopulosa() {
        return cidades.stream().max(Comparator.comparingInt(Cidade::getPopulacao)).orElse(null);
    }

    public List<Cidade> caminhoEntreCidades(Cidade origem, Cidade destino) {
        List<Cidade> caminho = new ArrayList<>();
        Set<Cidade> visitados = new HashSet<>();
        if (buscarCaminho(origem, destino, visitados, caminho)) return caminho;
        return Collections.emptyList();
    }

    private boolean buscarCaminho(Cidade atual, Cidade destino, Set<Cidade> visitados, List<Cidade> caminho) {
        caminho.add(atual);
        if (atual.equals(destino)) return true;
        visitados.add(atual);
        for (Rota rota : grafo.getOrDefault(atual, Collections.emptySet())) {
            Cidade vizinha = rota.getDestino();
            if (!visitados.contains(vizinha)) {
                if (buscarCaminho(vizinha, destino, visitados, caminho)) return true;
            }
        }
        caminho.remove(caminho.size() - 1);
        return false;
    }

public void carregarDeArquivo(String caminho) {
    try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
        String linha;
        boolean lendoCidades = true;
        while ((linha = br.readLine()) != null) {
            if (linha.toLowerCase().contains("rotas:")) {
                lendoCidades = false;
                continue; 
            }
    
            if (linha.trim().isEmpty() || linha.startsWith("#")) {
                continue;
            }

            String[] partes = linha.split(",");
            if (lendoCidades) {
                String nome = partes[0].trim();
                String estado = partes[1].trim();
                int populacao = Integer.parseInt(partes[2].trim());
                adicionarCidade(new Cidade(nome, estado, populacao));
            } else {
                Cidade origem = encontrarInstanciaPorNome(partes[0].trim());
                Cidade destino = encontrarInstanciaPorNome(partes[1].trim());
                int distancia = Integer.parseInt(partes[2].trim());
                if (origem != null && destino != null) {
                    conectarCidades(origem, destino, distancia);
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    public Cidade encontrarInstanciaPorNome(String nome) {
        for (Cidade cidade : cidades) {
            if (cidade.getNome().equalsIgnoreCase(nome)) return cidade;
        }
        return null;
    }
}
