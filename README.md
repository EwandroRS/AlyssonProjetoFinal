# 🗺️ Sistema de Mapeamento de Cidades em Java

Este projeto implementa um sistema de **representação de cidades e rotas** em Java, utilizando estruturas de dados como `TreeSet`, `HashMap` e algoritmos de busca em grafos. Ele permite carregar dados de um arquivo, listar conexões entre cidades, verificar caminhos e muito mais.

## 🚀 Funcionalidades

- 📥 **Carregamento automático** de cidades e rotas a partir de um arquivo `.txt`
- 🔎 **Busca de cidades** por nome
- 🔗 **Listagem de conexões** entre cidades
- 🧭 **Verificação de caminhos** entre duas cidades (mesmo que indiretos)
- 🛣️ **Exibição passo a passo do caminho** entre duas cidades
- 🏙️ **Listagem de cidades sem conexões**
- 👑 **Identificação da cidade mais populosa**

---

## 📁 Estrutura dos Arquivos

### `dados.txt`
O arquivo de entrada contém os dados de cidades e rotas:

```txt
# Cidades: nome, estado, populacao
São Sebastião do Paraíso,MG,70000
Itamogi,MG,10700
...

# Rotas: origem, destino, distancia
São Sebastião do Paraíso,Itamogi,30
Itamogi,Monte Santo de Minas,20
...
```

---

## 📦 Classes Principais

### `Cidade`
Representa uma cidade com nome, estado e população.

### `Rota`
Representa uma rota entre cidades com a distância em km.

### `MapaCidades`
Gerencia as cidades e suas conexões como um grafo, implementando os métodos de carregamento, busca e análise de caminhos.

### `Main`
Classe de teste que demonstra o uso de todas as funcionalidades.

---

## 🧪 Exemplos de Uso (Main.java)

```java
Cidade paraiso = mapa.encontrarInstanciaPorNome("São Sebastião do Paraíso");
Cidade carrancas = mapa.encontrarInstanciaPorNome("Carrancas");

mapa.listarConexoes(paraiso);
System.out.println("Existe caminho? " + mapa.existeCaminho(paraiso, carrancas));

for (Cidade cidade : mapa.caminhoEntreCidades(paraiso, alfenas)) {
    System.out.println("-> " + cidade);
}
```

---

## 🛠️ Tecnologias Utilizadas

- Java 8+
- Estruturas de dados: `TreeSet`, `HashMap`, `Set`, `List`
- Algoritmos de busca em grafos (DFS)

---

## 📄 Como Executar

1. Clone o repositório
2. Certifique-se de ter o `dados.txt` no mesmo diretório do projeto
3. Compile e execute a classe `Main.java`

```bash
javac Main.java model/*.java
java Main
```

---

## 📌 Observações

- O sistema é case-insensitive na busca por cidades
- A estrutura foi pensada para permitir expansão futura (ex: cálculo de menor caminho com Dijkstra)

---

## 👤 Autores

**Ewandro Rodrigues Silva**  
Estudante de Sistemas de Informação 
**Kaua Pereira Paim**
Estudante de Sistemas de Informação 


## Link do Video
*https://youtu.be/ktC-eRxg8uU*
