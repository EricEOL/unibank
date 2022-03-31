package domain;

import java.util.GregorianCalendar;

public class Loan {

    private final Account account;
    private final Double valueInicial;
    private Double valueCorrente;
    private final Double valueParcelas;
    private final int parcelas;
    private int parcelasPagas;
    private GregorianCalendar dataDoProximoPagamento;

    public Loan(Account account, Double valueInicial, int parcelas) {
        this.account = account;
        this.valueInicial = valueInicial;
        this.valueParcelas = valueInicial/parcelas;
        this.parcelas = parcelas;

        GregorianCalendar dataPagamento = new GregorianCalendar();
        dataPagamento.add(GregorianCalendar.MONTH, 1);

        this.dataDoProximoPagamento = dataPagamento;
    }

    public String pagarParcela() {
        if(parcelasPagas < parcelas) {
            try {
                this.account.withdraw(valueParcelas);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return e.getMessage();
            }

            valueCorrente -= valueParcelas;
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

    public Account getConta() {
        return account;
    }

    public Double getValueInicial() {
        return valueInicial;
    }

    public Double getValueCorrente() {
        return valueCorrente;
    }

    public void setValueCorrente(Double valueCorrente) {
        this.valueCorrente = valueCorrente;
    }

    public Double getValueParcelas() {
        return valueParcelas;
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
