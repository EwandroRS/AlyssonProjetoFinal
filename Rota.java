package model;

public class Rota {
    private Cidade destino;
    private int distancia;

    public Rota(Cidade destino, int distancia) {
        this.destino = destino;
        this.distancia = distancia;
    }

    public Cidade getDestino() {
        return destino;
    }

    public int getDistancia() {
        return distancia;
    }

    @Override
    public String toString() {
        return "-> " + destino.getNome() + " (" + distancia + " km)";
    }
}
