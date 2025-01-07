package com.mycompany.sample.gerenciadorpasse;

public enum TipoPassagem {
    COMUM("comum", 5.70f),
    ESTUDANTE("estudante", 2.28f),
    UNIVERSITARIO("universitario", 2.85f);

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
