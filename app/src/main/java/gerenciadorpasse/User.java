package gerenciadorpasse;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="usuario")
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

    @XmlElement(name="userName")
    public String getUserName() {
        return userName;
    }

    @XmlElement(name="passagem")
    public Passagem getPassagem() {
        return passagem;
    }

    @XmlElement(name="pathAvatarImagem")
    public String getPathAvatarImage() {
        return pathAvatarImagem;
    }

    public void setPathAvatarImagem(String pathAvatarImagem) {
        this.pathAvatarImagem = pathAvatarImagem;
    }

    public void setPassagem(Passagem passagem) {
        this.passagem = passagem;
    }

    @XmlElement(name="isFirstAccess")
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
