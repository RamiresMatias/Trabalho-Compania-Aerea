package companhiaaerea;

public class Voo {
    int numero;
    String origem;
    String destino;
    String horario;
    Assento assentos[]; // vetor de assentos

    public Voo() {
    }

    public Voo(int numero, String origem, String destino, String horario, int quantAssentos) {
        this.numero = numero;
        this.origem = origem;
        this.destino = destino;
        this.horario = horario;
        this.assentos = new Assento[quantAssentos];
        
        for(int i = 0; i < quantAssentos; i++){
          this.assentos[i] = new Assento((i + 1), null);  
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Assento[] getAssentos() {
        return assentos;
    }

    public void setAssentos(Assento[] assentos) {
        this.assentos = assentos;
    }
}
