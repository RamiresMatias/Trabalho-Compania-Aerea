package companhiaaerea;

public class Assento {
    int numero;
    Passageiro passageiro; // se passageiro for null, o
    // assento está vazio

    public Assento() {
    }

    public Assento(int numero, Passageiro passageiro) {
        this.numero = numero;
        this.passageiro = passageiro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }
}
