package com.mycompany.sample.gerenciadorpasse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("passagem") // Define o nome do tipo no JSON
public class Passagem {
    @JsonProperty("tipoPassagem")
    protected TipoPassagem tipoPassagem;

    @JsonProperty("saldo")
    protected double saldo;

    @JsonProperty("gastoMes")
    protected double gastoMes;

    @JsonProperty("gastoTotal")
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
        if (this.saldo >= this.tipoPassagem.getValor()) {
            this.saldo -= this.tipoPassagem.getValor();
        }
    }

    @JsonProperty("saldo")
    public double getSaldo() {
        return saldo;
    }

    @JsonProperty("gastoMes")
    public double getGastoMes() {
        return gastoMes;
    }

    public void somarGastoMes(double gastoMes) {
        if (this.saldo >= this.tipoPassagem.getValor()) {
            this.gastoMes += gastoMes;
        }
    }

    @JsonProperty("gastoTotal")
    public double getGastoTotal() {
        return gastoTotal;
    }

    @JsonProperty("tipoPassagem")
    public TipoPassagem getTipoPassagem() {
        return tipoPassagem;
    }

    public void setTipoPassagem(TipoPassagem tipoPassagem) {
        this.tipoPassagem = tipoPassagem;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setGastoMes(double gastoMes) {
        this.gastoMes = gastoMes;
    }

    public void setGastoTotal(double gastoTotal) {
        this.gastoTotal = gastoTotal;
    }
}
