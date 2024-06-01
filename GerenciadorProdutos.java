import java.util.ArrayList;
import java.util.Scanner;

class Produto {
    String nome;
    String marca;
    String cor;
    float valor;

    public Produto(String nome, String marca, String cor, float valor) {
        this.nome = nome;
        this.marca = marca;
        this.cor = cor;
        this.valor = valor;
    }
}

public class GerenciadorProdutos {
    static ArrayList<Produto> produtos = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        int opcao;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Criar Produto");
            System.out.println("2. Ler Produtos");
            System.out.println("3. Atualizar Produto");
            System.out.println("4. Deletar Produto");
            System.out.println("5. Sair");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    criarProduto();
                    break;
                case 2:
                    lerProdutos();
                    break;
                case 3:
                    atualizarProduto();
                    break;
                case 4:
                    deletarProduto();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }

    static void criarProduto() {
        System.out.println("Digite o nome do produto:");
        String nome = scanner.next();
        System.out.println("Digite a marca do produto:");
        String marca = scanner.next();
        System.out.println("Digite a cor do produto:");
        String cor = scanner.next();
        System.out.println("Digite o valor do produto:");
        float valor = scanner.nextFloat();
        produtos.add(new Produto(nome, marca, cor, valor));
        System.out.println("Produto criado com sucesso!");
    }

    static void lerProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Não há produtos cadastrados.");
        } else {
            System.out.println("Lista de Produtos:");
            for (Produto produto : produtos) {
                System.out.println("Nome: " + produto.nome + ", Marca: " + produto.marca + ", Cor: " + produto.cor + ", Valor: " + produto.valor);
            }
        }
    }

    static void atualizarProduto() {
        if (produtos.isEmpty()) {
            System.out.println("Não há produtos cadastrados para atualizar.");
            return;
        }
        System.out.println("Digite o índice do produto que deseja atualizar:");
        int indice = scanner.nextInt();
        if (indice < 0 || indice >= produtos.size()) {
            System.out.println("Índice inválido!");
            return;
        }
        System.out.println("Digite o novo nome do produto:");
        String nome = scanner.next();
        System.out.println("Digite a nova marca do produto:");
        String marca = scanner.next();
        System.out.println("Digite a nova cor do produto:");
        String cor = scanner.next();
        System.out.println("Digite o novo valor do produto:");
        float valor = scanner.nextFloat();
        produtos.set(indice, new Produto(nome, marca, cor, valor));
        System.out.println("Produto atualizado com sucesso!");
    }

    static void deletarProduto() {
        if (produtos.isEmpty()) {
            System.out.println("Não há produtos cadastrados para deletar.");
            return;
        }
        System.out.println("Digite o índice do produto que deseja deletar:");
        int indice = scanner.nextInt();
        if (indice < 0 || indice >= produtos.size()) {
            System.out.println("Índice inválido!");
            return;
        }
        produtos.remove(indice);
        System.out.println("Produto deletado com sucesso!");
    }
}
