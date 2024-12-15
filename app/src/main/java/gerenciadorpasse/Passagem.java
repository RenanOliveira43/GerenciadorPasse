package gerenciadorpasse;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="passagem")
public class Passagem {
    protected TipoPassagem tipoPassagem;
    protected double saldo;
    protected double gastoMes;
    protected double gastoTotal;

    public Passagem() {

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

    @XmlElement(name="saldo")
    public double getSaldo() {
        return saldo;
    }

    @XmlElement(name="gastoMes")
    public double getGastoMes() {
        return gastoMes;
    }

    public void somarGastoMes(double gastoMes) {
        if (this.saldo >= this.tipoPassagem.getValor()){
            this.gastoMes += gastoMes;
        }
    }

    @XmlElement(name="gastoTotal")
    public double getGastoTotal() {
        return gastoTotal;
    }

    @XmlElement(name="tipoPassagem")
    public TipoPassagem getTipoPassagem() {
        return tipoPassagem;
    }

    public void setTipoPassagem(TipoPassagem tipoPassagem) {
        this.tipoPassagem = tipoPassagem;
    }
}
