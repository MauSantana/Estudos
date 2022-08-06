import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // Instanciando objetos
        PilhaObj<Operacao> pilhaOperacao = new PilhaObj<>(10);
        FilaObj<Operacao> filaOperacao = new FilaObj<>(10);

        ContaBancaria conta1 = new ContaBancaria(1, 500.00);
        ContaBancaria conta2 = new ContaBancaria(2, 700.00);

        // Variáveis locais
        Scanner leitor = new Scanner(System.in);
        Scanner leitorNl = new Scanner(System.in);
        Integer contadorOperacao = 0;
        Integer qtdOperacaoDesfeita;
        Integer opcao;
        Boolean fim = false;
        Integer numero;
        String tipoOperacao;
        Double valor;
        ContaBancaria contaAlvo = null;
        Boolean valida;

        System.out.println(conta1);
        System.out.println(conta2);

        while (!fim) {

            System.out.println("\n----------Menu----------\n" +
                    "1- Debitar valor\n" +
                    "2- Depositar valor\n" +
                    "3- Desfazer operação\n" +
                    "4- Agendar operação\n" +
                    "5- Executar operações agendadas\n" +
                    "6- Sair");
            opcao = leitor.nextInt();

            switch (opcao) {
                case 1:
                    valida = true;
                    System.out.println("Digite o número da conta da qual deseja debitar:");
                    numero = leitor.nextInt();
                    System.out.println("Digite o valor a ser debitado: R$");
                    valor = leitor.nextDouble();

                    if (numero == conta1.getNumero()) {
                        contaAlvo = conta1;
                    }
                    else if (numero == conta2.getNumero()) {
                            contaAlvo = conta2;
                    }
                    else {
                        System.out.println("Número de conta inválida!");
                        valida = false;
                    }

                    if (valida) {
                        if (contaAlvo.debitar(valor)) {
                            Operacao debito = new Operacao(contaAlvo, "Débito", valor);
                            pilhaOperacao.push(debito);
                            contadorOperacao++;
                        }
                    }
                    break;

                case 2:
                    valida = true;
                    System.out.println("Digite o número da conta na qual deseja depositar:");
                    numero = leitor.nextInt();
                    System.out.println("Digite o valor a ser depositado: R$");
                    valor = leitor.nextDouble();

                    if (numero == conta1.getNumero()) {
                        contaAlvo = conta1;
                    }
                    else if (numero == conta2.getNumero()) {
                        contaAlvo = conta2;
                    }
                    else {
                        System.out.println("Número de conta inválida!");
                        valida = false;
                    }

                    if (valida) {
                        contaAlvo.depositar(valor);
                        Operacao deposito = new Operacao(contaAlvo, "Depósito", valor);
                        pilhaOperacao.push(deposito);
                        contadorOperacao++;
                    }
                    break;

                case 3:
                    System.out.println("Digite a quantidade de operações a serem desfeitas:");
                    qtdOperacaoDesfeita = leitor.nextInt();

                    if (qtdOperacaoDesfeita > contadorOperacao || qtdOperacaoDesfeita == 0) {
                        System.out.println("Quantidade inválida");
                    } else {
                        for (Integer i = 0; i < qtdOperacaoDesfeita; i++) {
                            Operacao op = pilhaOperacao.pop();
                            if (("Débito").equals(op.getTipoOperacao())) {
                                op.getContaBancaria().depositar(op.getValor());
                            } else if ("Depósito".equals(op.getTipoOperacao())) {
                                op.getContaBancaria().debitar(op.getValor());
                            }
                        }
                        contadorOperacao -= qtdOperacaoDesfeita;
                    }
                    break;

                case 4:
                    valida = true;
                    System.out.println("Digite qual operação deseja agendar(Débito ou Depósito):");
                    tipoOperacao = leitorNl.nextLine();
                    System.out.println("Digite o número da conta:");
                    numero = leitor.nextInt();
                    System.out.println("Digite o valor: R$");
                    valor = leitor.nextDouble();

                    if (numero == conta1.getNumero()) {
                        contaAlvo = conta1;
                    }
                    else if (numero == conta2.getNumero()) {
                        contaAlvo = conta2;
                    }
                    else {
                        System.out.println("Número de conta inválida!");
                        valida = false;
                    }

                    if (valida) {
                        Operacao operacaoAgendada = new Operacao(contaAlvo, tipoOperacao, valor);
                        filaOperacao.insert(operacaoAgendada);
                        System.out.println("Operação Agendada");
                    }
                    break;

                case 5:
                    if (filaOperacao.isEmpty()) {
                        System.out.println("Não há operações agendadas");
                    } else {
                        while(!filaOperacao.isEmpty()){

                            Operacao op = filaOperacao.poll();

                            if("Depósito".equals(op.getTipoOperacao())) {
                                op.getContaBancaria().depositar(op.getValor());
                            } else if("Débito".equals(op.getTipoOperacao())){
                                op.getContaBancaria().debitar(op.getValor());
                            }
                        }
                    }
                    break;

                case 6:
                    fim = true;
                    System.out.println("Programa encerrado!");
                    break;

                default:
                    System.out.println("\nOpção Inválida");

            }
        }
        System.out.println(conta1);
        System.out.println(conta2);
    }
}
