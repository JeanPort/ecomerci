package br.com.truedev.ecomerci.dto;

public class FaturamentoMensal {

    private Integer mes;
    private Double valorTotal;

    public FaturamentoMensal(Integer mes, Double valorTotal) {
        this.mes = mes;
        this.valorTotal = valorTotal;
    }

    public FaturamentoMensal() {
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
