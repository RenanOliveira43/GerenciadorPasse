package com.mycompany.sample.gerenciadorpasse;

import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("usuario")
public class User {
    protected String userName;
    protected boolean isFirstAccess;
    protected Passagem passagem;
    protected String pathAvatarImagem;
    protected List<String> usosPassagem= new ArrayList<>();
    
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

    @JsonProperty("usosPassagem")
    public List<String> getUsoPassagem() {
        return usosPassagem;
    }

    @JsonIgnore
    public String getUltimoUsoPassagem() {
        if (usosPassagem.isEmpty()) {
            return null;
        }
        return usosPassagem.get(usosPassagem.size() - 1);
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
