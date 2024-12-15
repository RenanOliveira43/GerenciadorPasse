package gerenciadorpasse;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="usuario")
public class User {
    protected String userName;
    protected boolean isFirstAccess;
    protected Passagem passagem;

    public User(String userName) {
        this.passagem = new Passagem();
        this.isFirstAccess = true;
        this.userName = userName;
    }

    public User() {
        
    }

    @XmlElement(name="userName")
    public String getUserName() {
        return this.userName;
    }

    @XmlElement(name="passagem")
    public Passagem getPassagem() {
        return this.passagem;
    }

    public void setPassagem(Passagem passagem) {
        this.passagem = passagem;
    }

    @XmlElement(name="isFirstAccess")
    public boolean isFirstAccess() {
        return this.isFirstAccess;
    }

    public void setIsFirstAcess() {
        this.isFirstAccess = false;
    }   
}
