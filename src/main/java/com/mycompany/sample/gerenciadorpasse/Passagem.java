package com.mycompany.sample.gerenciadorpasse;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("passagem")
public class Passagem {
    protected TipoPassagem tipoPassagem;
    protected double saldo;
    protected double gastoMes;
    protected double gastoTotal;
    protected int mesAtual;
    protected int anoAtual;

    public Passagem() {
        this.saldo = 0.0;
        this.gastoMes = 0.0;
        this.gastoTotal = 0.0;
        this.mesAtual = LocalDate.now().getMonthValue();
        this.anoAtual = LocalDate.now().getYear();
    }

    public void somarValor(double valor) {
        this.saldo += valor;
    }

    public void somarGastoTotal(double valor) {
        this.gastoTotal += valor;
    }

    public void alterarParaValorPersonalizado(double valorPersonalizado) {
        this.saldo = valorPersonalizado;
    }

    public void subtrairValorPassagem() {
        if (this.saldo >= this.tipoPassagem.getValor()) {
            this.saldo -= this.tipoPassagem.getValor();
        }
    }

    public void somarGastoMes(double gastoMes) {
        if (this.saldo >= this.tipoPassagem.getValor()) {
            this.gastoMes += gastoMes;
            this.gastoTotal += gastoMes;
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

    @JsonProperty("gastoTotal")
    public double getGastoTotal() {
        return gastoTotal;
    }

    @JsonProperty("tipoPassagem")
    public TipoPassagem getTipoPassagem() {
        return tipoPassagem;
    }

    @JsonProperty("mesAtual")
    public int getMesAtual() {
        return mesAtual;
    }

    @JsonProperty("anoAtual")
    public int getAnoAtual() {
        return anoAtual;
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
    
    public void setMesAtual(int mesAtual) {
        this.mesAtual = mesAtual;
    }
    
    public void setAnoAtual(int anoAtual) {
        this.anoAtual = anoAtual;
    }
}
