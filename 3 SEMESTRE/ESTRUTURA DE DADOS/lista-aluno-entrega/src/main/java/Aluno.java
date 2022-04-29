public class Aluno {
    private String ra;
    private String nome;
    private Double nota;


    public Aluno(String ra, String nome, Double nota) {
        this.ra = ra;
        this.nome = nome;
        this.nota = nota;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Aluno" +
                "\nRA =" + ra +
                "\nNOME ='" + nome +
                "\nNOTA =" + nota;
    }
}
