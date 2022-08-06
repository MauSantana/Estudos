package br.com.bandtec.mauricio.santana.c2;

public class Secretaria {

    private Integer totalInadimplentes;
    private Integer totalCancelamentos;
    private Integer totalPagamentos;

    public Secretaria() {
        this.totalInadimplentes = 0;
        this.totalCancelamentos = 0;
        this.totalPagamentos = 0;
    }

    public Integer getTotalInadimplentes() {
        return totalInadimplentes;
    }

    public Integer getTotalCancelamentos() {
        return totalCancelamentos;
    }

    public Integer getTotalPagamentos() {
        return totalPagamentos;
    }

    public void registraPagamento(Aluno aluno) {
        Boolean pagamentoRealizado = aluno.getInadimplente();

        aluno.setInadimplente(pagamentoRealizado = true);

        System.out.println(String.format("O aluno %s de RA %d está em dia com seu pagamento.",
                 aluno.getNome(), aluno.getRa()));
        this.totalPagamentos += 1;
    }

    public void registraAtrasoPagamento(Aluno aluno) {
        Boolean pagamentoNaoRealizado = aluno.getInadimplente();

        aluno.setInadimplente(pagamentoNaoRealizado = false);
        System.out.println(String.format("O aluno %s de RA %d está inadimplente.",
                 aluno.getNome(), aluno.getRa()));
        this.totalInadimplentes += 1;
    }

    public void registraCancelamento(Aluno aluno) {
        Boolean cancelamentoMatricula = aluno.getInadimplente();

        aluno.setInadimplente(cancelamentoMatricula = true);
        System.out.println(String.format("O aluno %s de RA %d cancelou a matricula.",
                 aluno.getNome(), aluno.getRa()));
        this.totalCancelamentos += 1;
    }

    public void verificaAprovacaoAluno(Aluno aluno) {
        if (aluno.getMedia() >= 6) {
            System.out.println(String.format("ALUNO: \nRA: %d\nNome: %s\nAtivo: %s\n"
                    + "Inadimplente: %s\nMedia: %.2f\n"
                    + "-----------\n"
                    + "O Aluno %s foi Aprovado", aluno.getRa(), aluno.getNome(),
                    aluno.getAtivo(), aluno.getInadimplente(), aluno.getMedia(), aluno.getNome()));
        } else {
            System.out.println(String.format("ALUNO: \nRA: %d\nNome: %s\nAtivo: %s\n"
                    + "Inadimplente: %s\nMedia: %.2f\n"
                    + "-----------\n"
                    + "O Aluno %s foi Reprovado", aluno.getRa(), aluno.getNome(),
                    aluno.getAtivo(), aluno.getInadimplente(), aluno.getMedia(), aluno.getNome()));
        }

    }

    @Override
    public String toString() {
        return "RELATÓRIO:\n" + "Pagamentos Realizados: " + this.totalPagamentos + "\nInadimplentes: " + this.totalInadimplentes + "\nEvasões: " + totalCancelamentos;
    }

}
