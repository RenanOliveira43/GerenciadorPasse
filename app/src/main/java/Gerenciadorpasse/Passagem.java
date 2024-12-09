package gerenciadorpasse;

public class Passagem {
    protected TipoPassagem tipoPassagem;
    protected double saldo;
    protected double gastoMes;
    protected double gastoTotal;

    public Passagem() {
        this.saldo = 0.0;
        this.gastoMes = 0.0;
        this.gastoTotal = 0.0;
    }

    public void somarValor(double valor) {
        this.saldo += valor;
    }

    public void alterarParaValorPersonalizado(double valorPersonalizado) {
        this.saldo = valorPersonalizado;
    }

    public void subtrairValorPassagem() {
        if (this.saldo >= this.tipoPassagem.getValor()){
            this.saldo -= this.tipoPassagem.getValor();
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public double getGastoMes() {
        return gastoMes;
    }

    public void somarGastoMes(double gastoMes) {
        if (this.saldo >= this.tipoPassagem.getValor()){
            this.gastoMes += gastoMes;
        }
    }

    public double getGastoTotal() {
        return gastoTotal;
    }

    public TipoPassagem getTipoPassagem() {
        return tipoPassagem;
    }

    public void setTipoPassagem(TipoPassagem tipoPassagem) {
        this.tipoPassagem = tipoPassagem;
    }
}
