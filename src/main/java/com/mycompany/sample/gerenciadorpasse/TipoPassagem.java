package com.mycompany.sample.gerenciadorpasse;

public enum TipoPassagem {
    COMUM("comum", 5.45f),
    ESTUDANTE("estudante", 2.18f),
    UNIVERSITARIO("universitario", 2.73f);

    private final String name;
    private final double valor;

    TipoPassagem(String name, double valor) {
        this.name = name;
        this.valor = valor;
    }
    
    public static TipoPassagem valueOfCodigo(String name) {
        for (TipoPassagem tipoPassagem : TipoPassagem.values()) {
            if (tipoPassagem.name.equals(name)) {
                return tipoPassagem;
            }
        }
        return null;
    }

    public double getValor() {
        return this.valor;
    }
}
