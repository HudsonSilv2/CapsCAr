package model;

import java.time.LocalDate;

public class Aluguel {
    private String filial;
    private String veiculo;
    private String cliente;
    private LocalDate retirada;
    private LocalDate devolucao;

    // Getters e setters
    public String getFilial() { return filial; }
    public void setFilial(String filial) { this.filial = filial; }

    public String getVeiculo() { return veiculo; }
    public void setVeiculo(String veiculo) { this.veiculo = veiculo; }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public LocalDate getRetirada() { return retirada; }
    public void setRetirada(LocalDate retirada) { this.retirada = retirada; }

    public LocalDate getDevolucao() { return devolucao; }
    public void setDevolucao(LocalDate devolucao) { this.devolucao = devolucao; }
}
