public class Jogador {

    private Integer id;
    private String nome;
    private Double salario;
    private Integer nroJogos;
    private Integer vitorias;
    private Integer golsMarcados;
    private String time;

    public Jogador(Integer id, String nome, Double salario, Integer nroJogos, Integer vitorias, Integer golsMarcados, String time) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
        this.nroJogos = nroJogos;
        this.vitorias = vitorias;
        this.golsMarcados = golsMarcados;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Integer getNroJogos() {
        return nroJogos;
    }

    public void setNroJogos(Integer nroJogos) {
        this.nroJogos = nroJogos;
    }

    public Integer getVitorias() {
        return vitorias;
    }

    public void setVitorias(Integer vitorias) {
        this.vitorias = vitorias;
    }

    public Integer getGolsMarcados() {
        return golsMarcados;
    }

    public void setGolsMarcados(Integer golsMarcados) {
        this.golsMarcados = golsMarcados;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", salario=" + salario +
                ", nroJogos=" + nroJogos +
                ", vitorias=" + vitorias +
                ", golsMarcados=" + golsMarcados +
                ", time='" + time + '\'' +
                '}';
    }
}
