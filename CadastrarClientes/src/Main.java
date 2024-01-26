import java.util.ArrayList;
import java.util.Scanner;

//Criando a classe "Conta".Nela serão declaradas as váriaveis do novo cliente, bem como o construtor para retornar os dados
class Conta {
    String nome;
    String tipoConta;
    String conta;
    String agencia;
    double saldo;

    //Criando construtor -> O construtor recebe as variáveis da classe conta
    public Conta(String nome, String tipoConta, String conta, String agencia, String saldo) {
        this.nome = nome;
        this.tipoConta = tipoConta;
        this.conta = conta;
        this.agencia = agencia;
        this.saldo = Double.parseDouble(saldo);
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Tipo da conta: " + tipoConta + ", Conta: " + conta + ", agência: " + agencia + ", Saldo: R$" + saldo;
    }
}


public class Main {
    public static void main(String[] args) {
        //Criando um objeto do tipo Scanner para ler o que o úsuário digitar
        Scanner read = new Scanner(System.in);

        // Criando uma lista para incluir o cliente cadastrado
        ArrayList<Conta> contas = new ArrayList<>();

        //Criando uma variável para receber a opção que o usuário irá escolher
        int opcao;

        //Criando uma estrura de repetição do tipo do/while

        do {
            System.out.println("--------------------------------:");
            System.out.println("Menu de Cadastro de Clientes:");
            System.out.println("\n1. Cadastrar Conta");
            System.out.println("2. Acessar contas");
            System.out.println("3. Remover contas");
            System.out.println("4. Sair");
            System.out.print("\nEscolha a opção desejada: ");

            opcao = read.nextInt();

            //Criando a estrura switch case (executa uma declaração vinda de múltiplas condições)

            switch (opcao) {
                case 1:
                    cadastrarContas(read, contas);
                    break;
                case 2:
                    listarContas(contas);
                    break;
                case 3:
                    removerConta(read,contas);
                    break;
                case 4:
                    System.out.println("\nSaindo do programa. Até mais!");
                    break;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");

            }

        } while (opcao != 4);
        read.close();

    }

    //Criando o método Cadastrar contas
    private static void cadastrarContas(Scanner read, ArrayList<Conta> contas) {
        read.nextLine();
        System.out.print("Informe o nome do cliente: ");
        String nome = read.nextLine();

        System.out.print("Informe o tipo da conta: ");
        String tipoConta = read.nextLine();
        System.out.print("Informe o número da conta: ");
        String conta = read.nextLine();
        System.out.print("Informe o número da agência: ");
        String agencia = read.nextLine();
        System.out.print("Informe o saldo inicial da conta: R$ ");
        String saldo = read.nextLine();


        //Criei uma váriavel "contaCadastrada" do tipo Conta que recebe as variáveis da classe conta
        Conta contaCadastrada = new Conta(nome, tipoConta, conta, agencia, saldo);

        //A variavel "contaCadastrada" será inserida na lista "contas"
        contas.add(contaCadastrada);

        //Imprimindo a mensagem:
        System.out.println("Cliente cadastrado com sucesso!");
    }

    //Criando metodo "listarContas"
    private static void listarContas(ArrayList<Conta> contas) {
        //Utilizando estrura condicional if/else
        if (contas.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("Lista de clientes: \n");
            for (Conta contaCadastrada : contas) {
                System.out.println(contaCadastrada);
            }
        }
    }

    private static void removerConta(Scanner read, ArrayList<Conta> contas) {
        read.nextLine();
        if (contas.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("Informe o nome do cliente que deseja remover: ");

            //declarando uma váriavel para receber o nome digitado
            String clienteRemover = read.nextLine();

            //declarano variavel bolleana para verificar se o cliente existe ou não
            boolean clienteEncontrado = false;

            for (Conta contasCadastradas : contas) {
                if (contasCadastradas.nome.equals(clienteRemover)) {
                    clienteEncontrado = true;
                    contas.remove(contasCadastradas);
                    System.out.println("Cliente Removido com sucesso!");
                    break;

                }
            }
            if(!clienteEncontrado){
                System.out.println("Cliente não encontrado.\n");
            }

        }
    }
}
