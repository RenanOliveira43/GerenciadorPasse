package gerenciadorpasse;

public class User {
    protected String userName;
    protected boolean isFirstAccess;
    protected Passagem passagem;

    public User() {
        this.passagem = new Passagem();
        this.isFirstAccess = true;
    }

    public String getUserName() {
        return this.userName;
    }

    public Passagem getPassagem() {
        return this.passagem;
    }

    public void setPassagem(Passagem passagem) {
        this.passagem = passagem;
    }

    public boolean isFirstAccess() {
        return this.isFirstAccess;
    }

    public void setIsFirstAcess() {
        this.isFirstAccess = false;
    }   
}
