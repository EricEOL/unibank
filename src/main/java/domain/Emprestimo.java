package domain;

import java.util.GregorianCalendar;

public class Emprestimo {

    private final Conta conta;
    private final Double valorInicial;
    private Double valorCorrente;
    private final Double valorParcelas;
    private final int parcelas;
    private int parcelasPagas;
    private GregorianCalendar dataDoProximoPagamento;

    public Emprestimo(Conta conta, Double valorInicial, int parcelas) {
        this.conta = conta;
        this.valorInicial = valorInicial;
        this.valorParcelas = valorInicial/parcelas;
        this.parcelas = parcelas;

        GregorianCalendar dataPagamento = new GregorianCalendar();
        dataPagamento.add(GregorianCalendar.MONTH, 1);

        this.dataDoProximoPagamento = dataPagamento;
    }

    public String pagarParcela() {
        if(parcelasPagas < parcelas) {
            try {
                this.conta.sacar(valorParcelas);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return e.getMessage();
            }

            valorCorrente -= valorParcelas;
            parcelasPagas += 1;

            this.atualizarDataDoProximoPagamento();
            return "A parcela nº " + parcelasPagas + " foi paga. Faltam " + (parcelas - parcelasPagas) + " parcelas para quitação";
        } else {
            return "Não há nenhuma parcela a ser paga nesse EMPRÉSTIMO, já está quitado";
        }
    }

    public void atualizarDataDoProximoPagamento() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.add(GregorianCalendar.MONTH, 1);

        this.dataDoProximoPagamento = calendar;
    }

    public Conta getConta() {
        return conta;
    }

    public Double getValorInicial() {
        return valorInicial;
    }

    public Double getValorCorrente() {
        return valorCorrente;
    }

    public void setValorCorrente(Double valorCorrente) {
        this.valorCorrente = valorCorrente;
    }

    public Double getValorParcelas() {
        return valorParcelas;
    }

    public int getParcelas() {
        return parcelas;
    }

    public int getParcelasPagas() {
        return parcelasPagas;
    }

    public GregorianCalendar getDataDoProximoPagamento() {
        return dataDoProximoPagamento;
    }
}
