package com.mycompany.sample.gerenciadorpasse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("usuario")
public class User {
    protected String userName;
    protected boolean isFirstAccess;
    protected Passagem passagem;
    protected String pathAvatarImagem;
    
    public User(String userName) {
        this.userName = userName;
        this.passagem = new Passagem();
        this.isFirstAccess = true;
    }

    public User() {
    }

    @JsonProperty("userName")
    public String getUserName() {
        return userName;
    }

    @JsonProperty("passagem")
    public Passagem getPassagem() {
        return passagem;
    }

    @JsonProperty("pathAvatarImagem")
    public String getPathAvatarImagem() {
        return pathAvatarImagem;
    }

    public void setPathAvatarImagem(String pathAvatarImagem) {
        this.pathAvatarImagem = pathAvatarImagem;
    }

    public void setPassagem(Passagem passagem) {
        this.passagem = passagem;
    }

    @JsonProperty("isFirstAccess")
    public boolean isFirstAccess() {
        return isFirstAccess;
    }

    public void setIsFirstAccess(boolean bool) {
        this.isFirstAccess = bool;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
