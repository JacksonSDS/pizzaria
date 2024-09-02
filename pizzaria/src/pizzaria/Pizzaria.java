package pizzaria;

import java.util.*;

public class Pizzaria {

    static class Pizza {
        String nome;
        double preco;

        Pizza(String nome, double preco) {
            this.nome = nome;
            this.preco = preco;
        }
    }

    static class Cliente {
        String nome;
        String email;
        String numero;

        Cliente(String nome, String email, String numero) {
            this.nome = nome;
            this.email = email;
            this.numero = numero;
        }
    }

    static List<Pizza> carrinho = new ArrayList<>();
    static Cliente cliente;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo à La casa das pizzas del Jackson, bom apetite!");

        System.out.println("   _______________| |_");
        System.out.println("  /_____pizzaria______|   ");
        System.out.println(" |         |     _    |");
        System.out.println(" |         |    |_|   | ");
        System.out.println(" |    _    |          |");
        System.out.println(" |   |.|   |          |");
        System.out.println(" |___|_|___|__________|\n");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Cardápio de pizzas");
            System.out.println("2. Seu carrinho");
            System.out.println("3. Cadastro");
            System.out.println("4. Pagar e gerar recibo (via PIX)");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    exibirMenuPizza(scanner);
                    break;
                case 2:
                    exibirCarrinho(scanner);
                    break;
                case 3:
                    fazerCadastro(scanner);
                    break;
                case 4:
                    try {
                        pagarEGerarRecibo();
                    } catch (Exception e) {
                        System.out.println("Ocorreu um erro ao processar o pagamento: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Obrigado por visitar a Pizzaria do Jackson. Até logo!");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    public static void exibirMenuPizza(Scanner scanner) {
        System.out.println("\nMenu de Pizzas:");
        System.out.println("1. Muçarela - R$ 31.00");
        System.out.println("2. Calabresa - R$ 33.00");
        System.out.println("3. Portuguesa - R$ 33.00");
        System.out.println("4. Frango com Catupiry - R$ 35.00");
        System.out.println("5. Quatro Queijos - R$ 38.00");
        System.out.println("6. Carne Seca - R$ 38.00");
        System.out.println("7. Espanhola - R$ 40.00");
        System.out.println("8. Meio a Meio");
        System.out.println("9. Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                carrinho.add(new Pizza("Muçarela", 31.00));
                System.out.println("Você adicionou Muçarela - R$ 31.00 ao carrinho");
                break;
            case 2:
                carrinho.add(new Pizza("Calabresa", 33.00));
                System.out.println("Você adicionou Calabresa - R$ 33.00 ao carrinho");
                break;
            case 3:
                carrinho.add(new Pizza("Portuguesa", 33.00));
                System.out.println("Você adicionou Portuguesa - R$ 33.00 ao carrinho");
                break;
            case 4:
                carrinho.add(new Pizza("Frango com Catupiry", 35.00));
                System.out.println("Você adicionou Frango com Catupiry - R$ 35.00 ao carrinho");
                break;
            case 5:
                carrinho.add(new Pizza("Quatro Queijos", 38.00));
                System.out.println("Você adicionou Quatro Queijos - R$ 38.00 ao carrinho");
                break;
            case 6:
                carrinho.add(new Pizza("Carne Seca", 38.00));
                System.out.println("Você adicionou Carne Seca - R$ 38.00 ao carrinho");
                break;
            case 7:
                carrinho.add(new Pizza("Espanhola", 40.00));
                System.out.println("Você adicionou Espanhola - R$ 40.00 ao carrinho");
                break;
            case 8:
                escolherMeioAMeio(scanner);
                break;
            case 9:
                break;
            default:
                System.out.println("Opção inválida. Por favor, escolha novamente.");
        }
    }

    public static void escolherMeioAMeio(Scanner scanner) {
        System.out.println("\nEscolha o primeiro sabor:");
        System.out.println("1. Muçarela - R$ 31.00");
        System.out.println("2. Calabresa - R$ 33.00");
        System.out.println("3. Portuguesa - R$ 33.00");
        System.out.println("4. Frango com Catupiry - R$ 35.00");
        System.out.println("5. Quatro Queijos - R$ 38.00");
        System.out.println("6. Carne Seca - R$ 38.00");
        System.out.println("7. Espanhola - R$ 40.00");
        System.out.print("Escolha uma opção: ");
        int opcao1 = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nEscolha o segundo sabor:");
        System.out.println("1. Muçarela - R$ 31.00");
        System.out.println("2. Calabresa - R$ 33.00");
        System.out.println("3. Portuguesa - R$ 33.00");
        System.out.println("4. Frango com Catupiry - R$ 35.00");
        System.out.println("5. Quatro Queijos - R$ 38.00");
        System.out.println("6. Carne Seca - R$ 38.00");
        System.out.println("7. Espanhola - R$ 40.00");
        System.out.print("Escolha uma opção: ");
        int opcao2 = scanner.nextInt();
        scanner.nextLine();

        double[] precos = {31.00, 33.00, 33.00, 35.00, 38.00, 38.00, 40.00};
        double precoTotal = (precos[opcao1 - 1] + precos[opcao2 - 1]) / 2;

        String[] nomes = {"Muçarela", "Calabresa", "Portuguesa", "Frango com Catupiry", "Quatro Queijos", "Carne Seca", "Espanhola"};
        String nomePizza = "Meio a Meio (" + nomes[opcao1 - 1] + " / " + nomes[opcao2 - 1] + ")";

        carrinho.add(new Pizza(nomePizza, precoTotal));
        System.out.printf("Você adicionou %s - R$ %.2f ao carrinho\n", nomePizza, precoTotal);
    }

    public static void exibirCarrinho(Scanner scanner) {
        if (carrinho.isEmpty()) {
            System.out.println("\nSeu carrinho está vazio.");
            return;
        }

        System.out.println("\nSeu Carrinho:");
        for (int i = 0; i < carrinho.size(); i++) {
            Pizza pizza = carrinho.get(i);
            System.out.printf("%d. %s - R$ %.2f\n", i + 1, pizza.nome, pizza.preco);
        }

        System.out.println("\nMenu do Carrinho:");
        System.out.println("1. Remover item");
        System.out.println("2. Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Digite o número do item que você deseja remover: ");
                int item = scanner.nextInt();
                scanner.nextLine();
                if (item < 1 || item > carrinho.size()) {
                    System.out.println("Número de item inválido. Por favor, tente novamente.");
                } else {
                    carrinho.remove(item - 1);
                    System.out.println("Item removido com sucesso.");
                }
                break;
            case 2:
                break;
            default:
                System.out.println("Opção inválida. Por favor, escolha novamente.");
        }
    }

    public static void fazerCadastro(Scanner scanner) {
        System.out.println("\nPor favor, insira seus dados:");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();
        while (!validarEmail(email)) {
            System.out.print("Email inválido. Por favor, insira um email válido: ");
            email = scanner.nextLine();
        }

        System.out.print("Número de telefone: ");
        String numero = scanner.nextLine();
        while (!validarTelefone(numero)) {
            System.out.print("Número de telefone inválido. Por favor, insira um número de telefone válido: ");
            numero = scanner.nextLine();
        }

        cliente = new Cliente(nome, email, numero);
        System.out.println("Cadastro realizado com sucesso!");
    }

    public static boolean validarEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    public static boolean validarTelefone(String telefone) {
        return telefone.matches("\\d{10,11}");
    }

    public static void pagarEGerarRecibo() throws Exception {
        if (cliente == null || carrinho.isEmpty()) {
            System.out.println("\nNão há itens no carrinho ou o cliente não foi cadastrado ainda.");
            return;
        }

        System.out.println("\nRealizando pagamento via PIX...");
        System.out.println("Pagamento confirmado! Gerando recibo...");

        System.out.println("\nRecibo:");
        System.out.println("Cliente: " + cliente.nome);
        System.out.println("Email: " + cliente.email);
        System.out.println("Número de telefone: " + cliente.numero);
        System.out.println("\nItens do pedido:");
        double total = 0;
        for (Pizza pizza : carrinho) {
            System.out.printf("- %s: R$ %.2f\n", pizza.nome, pizza.preco);
            total += pizza.preco;
        }
        System.out.printf("\nTotal: R$ %.2f\n", total);

        carrinho.clear();
        cliente = null;
    }
}
