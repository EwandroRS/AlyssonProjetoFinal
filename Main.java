import model.Cidade;
import model.MapaCidades;

public class Main {
    public static void main(String[] args) {
        
        // Carrega o mapa a partir do arquivo expandido
        MapaCidades mapa = new MapaCidades();
        mapa.carregarDeArquivo("dados.txt");

        // --- BUSCANDO INSTÂNCIAS DAS CIDADES PARA OS TESTES ---
        System.out.println("=== Cidades Carregadas com Sucesso ===");
        Cidade paraiso = mapa.encontrarInstanciaPorNome("São Sebastião do Paraíso");
        Cidade monteSanto = mapa.encontrarInstanciaPorNome("Monte Santo de Minas");
        Cidade carrancas = mapa.encontrarInstanciaPorNome("Carrancas");
        Cidade pocosDeCaldas = mapa.encontrarInstanciaPorNome("Poços de Caldas");
        Cidade alfenas = mapa.encontrarInstanciaPorNome("Alfenas");
        Cidade itamogi = mapa.encontrarInstanciaPorNome("Itamogi");

        // --- TESTANDO CONEXÕES DE CIDADES ---
        System.out.println("\n=== Listando Conexões ===");
        // Itamogi agora deve ter 3 conexões
        mapa.listarConexoes(itamogi);
        // Poços de Caldas deve ter apenas 1 conexão
        mapa.listarConexoes(pocosDeCaldas);
        
        // --- TESTANDO EXISTÊNCIA DE CAMINHOS ---
        System.out.println("\n=== Verificando Existência de Caminhos ===");
        // Caminho direto
        System.out.println("Existe caminho entre Paraíso e Itamogi? " + mapa.existeCaminho(paraiso, itamogi));
        // Caminho mais longo: Paraíso -> Itamogi -> Guaxupé -> Poços de Caldas
        System.out.println("Existe caminho entre Paraíso e Poços de Caldas? " + mapa.existeCaminho(paraiso, pocosDeCaldas));
        // Caminho para cidade isolada
        System.out.println("Existe caminho entre Paraíso e Carrancas? " + mapa.existeCaminho(paraiso, carrancas));

        // --- TESTANDO CAMINHO PASSO A PASSO ---
        System.out.println("\n=== Exibindo Caminho Detalhado (Paraíso -> Alfenas) ===");
        // Este caminho deve passar por Passos: Paraíso -> Passos -> Alfenas
        for (Cidade cidade : mapa.caminhoEntreCidades(paraiso, alfenas)) {
            System.out.println("-> " + cidade);
        }

        System.out.println("\n=== Exibindo Caminho Detalhado (Monte Santo -> Poços de Caldas) ===");
        // Este caminho deve ser: Monte Santo -> Itamogi -> Guaxupé -> Poços de Caldas
        for (Cidade cidade : mapa.caminhoEntreCidades(monteSanto, pocosDeCaldas)) {
            System.out.println("-> " + cidade);
        }

        // --- TESTANDO FUNCIONALIDADES EXTRAS ---
        System.out.println("\n=== Cidades sem nenhuma conexão ===");
        // Deve listar apenas Carrancas
        mapa.listarCidadesSemConexao();

        System.out.println("\n=== Cidade mais populosa do sistema ===");
        // Com os novos dados, deve ser Poços de Caldas
        Cidade maisPopulosa = mapa.getCidadeMaisPopulosa();
        System.out.println(maisPopulosa != null ? maisPopulosa : "Nenhuma cidade cadastrada.");
    }
}