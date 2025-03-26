import java.util.Objects;
import java.util.Scanner;

public class sistemaStudySurf {

    public static String[] listaAluno = new String[4];
    public static String[] idadeAluno = new String[4];
    public static String[] numeroAluno = new String[4];
    public static String[] conhecimentoAluno = new String[4];


    public static String[] listaProfessor = new String[4];
    public static String[] idadeProfessor = new String[4];
    public static String[] rgProfessor = new String[4];
    public static String[] enderecoProfessor = new String[4];


    public static String[] listaAulas = new String[10];
    public static String[] dataAula = new String[10];
    public static String[] horaAula = new String[10];
    public static String[] professor = new String[10];
    public static int contAulas = 0;
    
    
    public static int contDevedores = 0;  // Contador para devedores

    public static int[] quantidadeAlunosSeg = new int[10];
    public static String[] desempenhoAulaSeg = new String[10];
    public static int[] quantidadeAlunosTer = new int[10];
    public static String[] desempenhoAulaTer = new String[10];
    public static int[] quantidadeAlunosQuar = new int[10];
    public static String[] desempenhoAulaQuar = new String[10];
    public static int[] quantidadeAlunosQuin = new int[10];
    public static String[] desempenhoAulaQuin = new String[10];
    public static int[] quantidadeAlunosSex = new int[10];
    public static String[] desempenhoAulaSex = new String[10];

    public static int contSeg = 0, contTer = 0, contQuar = 0, contQuin = 0, contSex = 0;

    public static String[] devedores = new String[10]; // lista de alunos que deve
    public static double[] mensalidades = new double[10]; // valor da mensalidades
    public static String[] diaPagamento = new String[10]; // data de pagamento


    static Scanner input = new Scanner(System.in);
    static int senha = 1234, senhaDigitada, pesoAluno, o = 10, opcaoDirecionar;


    static String usuario = "studysurf", usuarioDigitado, opcao, possuiPrancha,escolhaPrancha, formaPagamento, finalCompra;

    static double alturaAluno;

    public static void main(String[] args) {
        int retorno = 0;

        while (retorno == 0) {
            retorno = login();
            if (retorno == 1) {
                opcoes();
            }
        }
    }


    public static int login() {

        System.out.println("\nSeja Bem Vindo ao sistema da Study Surf!");

        System.out.println("\n***** Faça seu login! *****");

        System.out.print("Digite seu nome de usuário: ");
        usuarioDigitado = input.next();

        System.out.print("Digite sua senha: ");
        senhaDigitada = input.nextInt();

        if ((senhaDigitada == senha) && (Objects.equals(usuarioDigitado, usuario))) {

            System.out.println("Login concluido!");
            return 1;

        } else {
            System.out.println("\nUsuário ou senha invalidos. Tente novamente!");
            return 0;
        }
    }

    public static void opcoes() {
        String menu = """
                \n*** Selecione uma opção ***
                1 - Cadastrar aluno
                2 - Cadastrar professor
                3 - Lista de alunos
                4 - Lista de professores
                5 - Marcar aulas
                6 - Lista de aulas
                7 - Relatório de aulas
                8 - Cadastrar mensalidades
                9 - Dados devedores
                10 - Encerrar sistema
                """;

        int opcao = 0;
        // "I" para enviar e receber os alunos
        // "P" para enviar e receber professores
        // "A" para enviar e receber aulas
        // "R" para enviar e receber relatorios
        // "C" para enviar e receberas mensalidades
        // "RP" para enviar e receber os relatorios de pagamento
        int i = 0, p = 0, a = 0, r = 0, c = 0, rp = 0;
        while (opcao != 10) {

            System.out.println(menu);
           
            try {
                opcao = input.nextInt();
            } catch (Exception e) {
                System.out.println("Erro! Opção inválida. Tente novamente.");
                input.nextLine(); // Limpar o buffer de entrada
                continue;
            }

            switch (opcao) {

                case 1:
                    i = cadastrarAluno(i);
                    break;

                case 2:
                    p = cadastrarProfessor(p);
                    break;

                case 3:
                    listaAlunos(i);
                    break;

                case 4:
                    listaProfessores(p);
                    break;

                case 5:
                    marcarAula(a);
                    break;

                case 6:
                    listaAulas(a);
                    break;

                case 7:
                    r = relatorioAulas(r);
                    break;

                case 8:
                   c = CadastrarMensalidades(c);
                    break;

                case 9:
                    rp = exibirRelatorioPagamento(rp);
                    break;

                case 10:
                    System.out.println("Finalizando o Sistema...");
                    break;
                default:
                    System.out.println("\nOpção invalida!");
            }
        }
    }

    public static void voltarMenu() {
        System.out.println("\nDeseja voltar ao menu?(sim para voltar e não para encerrar)");
        opcao = input.next();
        if (opcao.equalsIgnoreCase("sim")) {

        } else if (opcao.equalsIgnoreCase("não") || opcao.equalsIgnoreCase("nao")) {
            System.out.println("Obrigado por utilizar o sistema, volte sempre!");
            System.exit(o);
        }
    }

    public static void lojaPranchas() {
        System.out.println("Bem vindo a loja de pranchas da Study surf!\n");

        String pranchas = """
                *** Escolha um tipo de prancha disponivel! ***
                1- Long - R$3,000,00
                2- Fan - R$1,200,00
                3- Speed - R$1,000,00
                """;
        System.out.println(pranchas);
        escolhaPrancha = input.next();

        switch (escolhaPrancha) {
            case "1":
                System.out.println("Qual a forma de pagamento? (Debito, credito ou pix)");
                formaPagamento = input.next();

                System.out.println("Desejar finalizar ou cancelar a compra?)");
                finalCompra = input.next();

                if (finalCompra.equalsIgnoreCase("sim") || (finalCompra.equalsIgnoreCase("finalizar"))) {
                    System.out.println("Obrigado pela compra, volte sempre!");
                }
                else if (finalCompra.equalsIgnoreCase("cancelar") || finalCompra.equalsIgnoreCase("não")) {
                    System.out.println("Compra cancelada!");
                } else {
                    System.out.println("Opção digitada invalida!");
                    return;
                }
                    break;
            case "2":
                System.out.println("Qual a forma de pagamento? (Debito, credito ou pix)");
                formaPagamento = input.next();

                System.out.println("Desejar finalizar ou cancelar a compra?");
                finalCompra = input.next();

                if (finalCompra.equalsIgnoreCase("sim") || (finalCompra.equalsIgnoreCase("finalizar"))) {
                    System.out.println("Obrigado pela compra, volte sempre!");
                } else if (finalCompra.equalsIgnoreCase("cancelar") || finalCompra.equalsIgnoreCase("não")) {
                    System.out.println("Compra cancelada!");
                } else {
                    System.out.println("Opção digitada invalida!");
                    return;
                }
                break;
            case "3":
                System.out.println("Qual a forma de pagamento? (Debito, credito ou pix)");
                formaPagamento = input.next();

                System.out.println("Desejar finalizar ou cancelar a compra?");
                finalCompra = input.next();

                if (finalCompra.equalsIgnoreCase("sim") || (finalCompra.equalsIgnoreCase("finalizar"))) {
                    System.out.println("Obrigado pela compra, volte sempre!");
                } else if (finalCompra.equalsIgnoreCase("cancelar") || finalCompra.equalsIgnoreCase("não")) {
                    System.out.println("Compra cancelada!");
                } else {
                    System.out.println("Opção digitada invalida!");
                }
        }
    }

    public static void direcionamento() {
        String direcionar = """
                *** Selecione uma opção ***
                1- Ir para loja de pranchas
                2- Ir para o menu inicial
                3- sair
                """;
        System.out.println(direcionar);
        opcaoDirecionar = input.nextInt();

        if (opcaoDirecionar == 1) {
            lojaPranchas();
        } else if (opcaoDirecionar == 2) {
        } else if (opcaoDirecionar == 3) {
            System.out.println("Obrigado por utilizar o sistema, volte sempre!");
            System.exit(o);
        }
    }

    public static int cadastrarAluno(int i) {


        //for (i = 0; i < listaAluno.length; i++) {

        System.out.print("Digite o nome do aluno: ");
        listaAluno[i] = input.next();

        System.out.print("Digite a data de nascimento do aluno: ");
        idadeAluno[i] = input.next();

        System.out.print("Digite o número para contato: ");
        numeroAluno[i] = input.nextLine();
        try {
            numeroAluno[i] = String.valueOf(input.nextLine());
        } catch (Exception e) {
            System.out.println("Erro! Digite um número válido.");
            input.nextLine(); // Limpar o buffer de entrada
            return i; // Retorna sem cadastrar
        }

        System.out.print("Qual o nivel de conhecimento do aluno: ");
        conhecimentoAluno[i] = input.next();

        //}


        System.out.println("O aluno possui prancha?");
        possuiPrancha = input.next();

        if (Objects.equals(possuiPrancha.toUpperCase(), "NÃO") || (Objects.equals(possuiPrancha.toUpperCase(), "NAO"))) {

            System.out.println("Para recomendarmos o melhor tipo de prancha para o aluno informe:");

            System.out.println("Qual o peso do aluno?");
           //pesoAluno = input.nextInt();
            try {
                pesoAluno = input.nextInt();
            } catch (Exception e) {
                System.out.println("Erro! Digite um peso válido.");
                input.nextLine(); // Limpar o buffer de entrada
                return i; // Retorna sem cadastrar
            }

            System.out.println("Quanto de altura o aluno tem?(Ex: 1,80)");

            try {
                alturaAluno = input.nextDouble();
            } catch (Exception e) {
                System.out.println("Erro! Digite uma altura válida.(Ex: 1,80)");
                input.nextLine(); // Limpar o buffer de entrada
                return i; // Retorna sem cadastrar
            }

            if (pesoAluno >= 70 && pesoAluno <= 80) {
                if (alturaAluno >= 1.40 && alturaAluno <= 1.80) {
                    System.out.println("Analisando as caracteristicas do aluno recomendamos que a prancha seja uma Speed");
                }
            }
            if (pesoAluno > 81 && pesoAluno < 92) {
            }
            if (alturaAluno > 1.81 && alturaAluno < 1.90) {
                System.out.println("Analisando as caracteristicas do aluno recomendamos que a prancha seja uma Fan");

            }
            if (pesoAluno > 93 && pesoAluno < 120) {

            }
            if (alturaAluno > 1.82 && alturaAluno < 2.30)
                System.out.println("Analisando as caracteristicas do aluno recomendamos que a prancha seja uma Long ");

            System.out.println("Aluno cadastrado com sucesso!\n");

            direcionamento();


        } else if (Objects.equals(possuiPrancha.toUpperCase(), "SIM")) {
            System.out.println("Aluno cadastrado com sucesso!");
            voltarMenu();
        }


        i++;
        return (i);
    }

    public static int cadastrarProfessor(int p) {

        System.out.println("Qual nome do professor que deseja cadastrar: ");
        listaProfessor[p] = input.next();

        System.out.println("Qual a data de nascimento do professor ? ");
        idadeProfessor[p] = input.next();

        System.out.println("Qual RG do professor?(sem pontos ou traços) ");
        
        try {
            rgProfessor[p] = input.next();
        } catch (Exception e) {
            System.out.println("Erro! Digite um RG válido.");
            input.nextLine(); // Limpar o buffer de entrada
            return p; // Retorna sem cadastrar
        }

        System.out.println("Qual o endereço do Professor? ");
        enderecoProfessor[p] = input.nextLine();
        enderecoProfessor[p] = input.nextLine();

        System.out.println("Professor cadastrado com sucesso!");

        voltarMenu();
        p++;
        return (p);

    }

    public static void listaAlunos(int i) {

        System.out.println("\n**** Lista de alunos cadastrados ****\n");
        for (int j = 0; j < i; j++) {
            System.out.println("Nome: " + listaAluno[j]);
            System.out.println("Nascimento: " + idadeAluno[j]);
            System.out.println("Número: " + numeroAluno[j]);
            System.out.println("Nível de conhecimento: " + conhecimentoAluno[j]);
            System.out.println();
        }
        voltarMenu();

    }

    public static void listaProfessores(int p) {

        System.out.println("\n**** Lista de professores cadastrados ****");

        for (int k = 0; k < p; k++) {
            System.out.println("Nome: " + listaProfessor[k]);
            System.out.println("Nascimento: " + idadeProfessor[k]);
            System.out.println("RG: " + rgProfessor[k]);
            System.out.println("Endereço: " + enderecoProfessor[k]);
            System.out.println();
        }

        voltarMenu();

    }

    public static int marcarAula(int a) {
        if (contAulas < listaAulas.length) {  // Verifica se há espaço nos vetores
            System.out.println("Qual aluno deseja marcar a aula?");
            listaAulas[contAulas] = input.next();  // Adiciona o nome do aluno

            System.out.println("Qual é o dia desejado para a aula?");
            dataAula[contAulas] = input.next();  // Adiciona a data da aula

            System.out.println("Qual é o horário desejado para a aula?");
            horaAula[contAulas] = input.next();  // Adiciona o horário da aula

            System.out.println("Nome do professor que irá dar a aula:");
            professor[contAulas] = input.next();  // Adiciona o nome do professor

            contAulas++;  // Incrementa o contador de aulas

            System.out.println("Aula marcada com sucesso!");

            voltarMenu();
        } else {
            System.out.println("Não há espaço para mais aulas. Limite de 10 aulas atingido.");
        }
        a++;
        return (a);

    }

    public static void listaAulas(int a) {
        System.out.println("\n****** Lista de aulas ******");

        if (contAulas == 0) {
            System.out.println("Nenhuma aula marcada ainda.");
        } else {
            // Exibe todas as aulas registradas
            for (int i = 0; i < contAulas; i++) {
                System.out.println("Aluno: " + listaAulas[i] + " | Data: " + dataAula[i] + " | Hora: " + horaAula[i] + " | Professor: " + professor[i]);
            }
        }

        voltarMenu();
    }

    public static int relatorioAulas(int r) {

        System.out.println("Qual é o dia do relatório? (Segunda a sexta)");
        String dia = input.next();


        switch (dia) {
            case "segunda":
                if (contSeg < 10) {
                    System.out.println("Quantos alunos estavam na aula?");
                    quantidadeAlunosSeg[contSeg] = input.nextInt();

                    System.out.println("Como foi o desempenho dos alunos?(Bom, regular ou ruim)");
                    desempenhoAulaSeg[contSeg] = input.next();
                    contSeg++;
                } else {
                    System.out.println("Limite de relatórios para segunda atingido!");
                }
                break;

            case "terça":
                if (contTer < 10) {
                    System.out.println("Quantos alunos estavam na aula?");
                    quantidadeAlunosTer[contTer] = input.nextInt();

                    System.out.println("Como foi o desempenho dos alunos?");
                    desempenhoAulaTer[contTer] = input.next();
                    contTer++;
                } else {
                    System.out.println("Limite de relatórios para terça atingido!");
                }
                break;

            case "quarta":
                if (contQuar < 10) {
                    System.out.println("Quantos alunos estavam na aula?");
                    quantidadeAlunosQuar[contQuar] = input.nextInt();

                    System.out.println("Como foi o desempenho dos alunos?");
                    desempenhoAulaQuar[contQuar] = input.next();
                    contQuar++;
                } else {
                    System.out.println("Limite de relatórios para quarta atingido!");
                }
                break;

            case "quinta":
                if (contQuin < 10) {
                    System.out.println("Quantos alunos estavam na aula?");
                    quantidadeAlunosQuin[contQuin] = input.nextInt();

                    System.out.println("Como foi o desempenho dos alunos?");
                    desempenhoAulaQuin[contQuin] = input.next();
                    contQuin++;
                } else {
                    System.out.println("Limite de relatórios para quinta atingido!");
                }
                break;

            case "sexta":
                if (contSex < 10) {
                    System.out.println("Quantos alunos estavam na aula?");
                    quantidadeAlunosSex[contSex] = input.nextInt();

                    System.out.println("Como foi o desempenho dos alunos?");
                    desempenhoAulaSex[contSex] = input.next();
                    contSex++;
                } else {
                    System.out.println("Limite de relatórios para sexta atingido!");
                }
                break;

            default:
                System.out.println("Dia inválido! Tente novamente.");
                break;
        }


        System.out.println("Relatório criado com sucesso!");

        System.out.println("Deseja visualizar os relatórios?");
        String relatorios = input.next();

        if (Objects.equals(relatorios.toUpperCase(), "SIM")) {
            System.out.println("\n***** Relatórios por dia da semana *****\n");


            for (int relatorioS = 0; relatorioS < contSeg; relatorioS++) {
                System.out.println("Segunda: " + quantidadeAlunosSeg[relatorioS] + " Alunos e desempenho: " + desempenhoAulaSeg[relatorioS]);
            }


            for (int relatorioT = 0; relatorioT < contTer; relatorioT++) {
                System.out.println("Terça: " + quantidadeAlunosTer[relatorioT] + " Alunos e desempenho: " + desempenhoAulaTer[relatorioT]);
            }

            for (int relatorioQa = 0; relatorioQa < contQuar; relatorioQa++) {
                System.out.println("Quarta: " + quantidadeAlunosQuar[relatorioQa] + " Alunos e desempenho: " + desempenhoAulaQuar[relatorioQa]);
            }

            for (int relatorioQ = 0; relatorioQ < contQuin; relatorioQ++) {
                System.out.println("Quinta: " + quantidadeAlunosQuin[relatorioQ] + " Alunos e desempenho: " + desempenhoAulaQuin[relatorioQ]);
            }

            for (int relatorioSe = 0; relatorioSe < contSex; relatorioSe++) {
                System.out.println("Sexta: " + quantidadeAlunosSex[relatorioSe] + " Alunos e desempenho: " + desempenhoAulaSex[relatorioSe]);

            }
            if (Objects.equals(relatorios.toUpperCase(), "NÃO") || (Objects.equals(relatorios.toUpperCase(), "NAO"))) {

            }
        }
        r++;
        return r;
    }

    public static int CadastrarMensalidades(int c) {
        int indexDevedor = contDevedores; // vi no chat que é contador global
        System.out.println("\n*** Cadastro de Mensalidades ***");

        while (indexDevedor < devedores.length) {
            System.out.println("Digite o nome do aluno (ou 'fim' para terminar):");
            String nomeAluno = input.next();
            if (nomeAluno.equalsIgnoreCase("fim")) {
                break;
            }
            devedores[indexDevedor] = nomeAluno;

            System.out.println("Digite o valor da mensalidade de " + nomeAluno + ": ");
            mensalidades[indexDevedor] = input.nextDouble();

            input.nextLine(); // Para ir pra proxima linha

            System.out.println("Digite a data do pagamento (dd/mm/aaaa) para " + nomeAluno + ": ");
            diaPagamento[indexDevedor] = input.nextLine();

            indexDevedor++; // colocando um contador


            contDevedores = indexDevedor;// mesmo la de cima

            System.out.println("Deseja cadastrar outra mensalidade? (sim/não): ");
            String resposta = input.nextLine();
            if (resposta.equalsIgnoreCase("não") || resposta.equalsIgnoreCase("nao")) {
                break;
            }
        }

        System.out.println("\n*** Lista de Devedores e Mensalidades ***");
        for (c = 0; c < indexDevedor; c++) {
            System.out.println("Aluno: " + devedores[c] + " | Mensalidade: R$" + mensalidades[c] + " | Data de pagamento: " + diaPagamento[c]);
        }
        return (c);
    }

    public static int exibirRelatorioPagamento(int rp) {
        // Verificando se há devedores registrados
        if (contDevedores == 0) {
            System.out.println("Nenhum pagamento cadastrado.");
        } else {
            System.out.println("\n***** Relatórios de Pagamento *****");
            for (int i = 0; i < contDevedores; i++) {
                System.out.println("Aluno: " + devedores[i] + " | Mensalidade: R$" + mensalidades[i] + " | Data de pagamento: " + diaPagamento[i]);
            }
        }

        return (rp);
    }
}
