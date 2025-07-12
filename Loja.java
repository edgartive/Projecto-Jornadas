import java.util.Scanner;
class Produto {
    public String nome; 
    public float preco; 
    public int quantidadeDisponivel;
    public String categoria; 

    public Produto(String nome, float preco, int quantidadeDisponivel, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.categoria = categoria;
    }
}

// Classe que representa a loja
class Loja {
    private Produto[] produtos;
    private float totalVendas; 
    private float valorTotalEstoque;

    public Loja() {
        produtos = new Produto[]{
            new Produto("Coca-Cola", 80, 20, "Bebidas"),
            new Produto("Pepsi", 75, 15, "Bebidas"),
            new Produto("Guarana", 80, 25, "Bebidas"),
            new Produto("Sumo de Maca", 100, 30, "Bebidas"),
            new Produto("Sumo de Laranja",100, 28, "Bebidas"),
            new Produto("Agua Mineral", 70, 50, "Bebidas"),
            new Produto("Cerveja", 55, 10, "Bebidas"),
            new Produto("Vinho Tinto", 300, 5, "Bebidas"),
            new Produto("Whisky", 500, 8, "Bebidas"),
            new Produto("Champagne", 60, 7, "Bebidas"),
            new Produto("Coxinha", 25, 40, "Alimentos"),
            new Produto("Empada", 30, 35, "Alimentos"),
            new Produto("Pastel", 20, 45, "Alimentos"),
            new Produto("Kibe", 35, 30, "Alimentos"),
            new Produto("Enroladinho", 28, 38, "Alimentos"),
            new Produto("Bolinho de Bacalhau", 40, 25, "Alimentos"),
            new Produto("Pao de Queijo", 15, 50, "Alimentos"),
            new Produto("Salgadinho", 95, 45, "Alimentos"),
            new Produto("Frango a Passarinho", 145, 20, "Alimentos"),
            new Produto("Batata Frita", 50, 50, "Alimentos"),
            new Produto("Chocolate ao Leite", 50, 30, "Doces"),
            new Produto("Chocolate Amargo", 55, 25, "Doces"),
            new Produto("Bala de Caramelo", 10, 100, "Doces"),
            new Produto("Doce de Leite", 30, 40, "Doces"),
            new Produto("Biscoito Amanteigado", 20, 50, "Doces"),
            new Produto("Pudim", 40, 15, "Doces"),
            new Produto("Bolo de Chocolate", 60, 10, "Doces"),
            new Produto("Sorvete de Morango", 70, 12, "Doces"),
            new Produto("Sorvete de Chocolate", 70, 12, "Doces"),
            new Produto("Gelatina", 20, 20, "Doces"),
            new Produto("Maca", 20, 50, "Frutas"),
            new Produto("Banana", 15, 45, "Frutas"),
            new Produto("Laranja", 15, 40, "Frutas"),
            new Produto("Manga", 30, 30, "Frutas"),
            new Produto("Abacaxi", 40, 20, "Frutas"),
            new Produto("Uva", 50, 25, "Frutas"),
            new Produto("Melancia", 60, 15, "Frutas"),
            new Produto("Pera", 25, 35, "Frutas"),
            new Produto("Mamao", 20, 40, "Frutas"),
            new Produto("Kiwi", 35, 20, "Frutas"),
            new Produto("Cheesecake", 80, 15, "Sobremesas"),
            new Produto("Tiramisu", 90, 10, "Sobremesas"),
            new Produto("Mousse de Maracuja", 70, 20, "Sobremesas"),
            new Produto("Creme Brulee", 100, 8, "Sobremesas"),
            new Produto("Bolo de Cenoura", 50, 25, "Sobremesas"),
            new Produto("Trufa", 40, 30, "Sobremesas"),
            new Produto("Brownie", 60, 15, "Sobremesas"),
            new Produto("Torta de Limao", 170, 12, "Sobremesas"),
            new Produto("Pave", 55f, 20, "Sobremesas"),
            new Produto("Sufle de Chocolate", 80, 10, "Sobremesas")
        };
    }

    //exibir produtos por categoria
    private void exibirProdutosPorCategoria(String categoria) {
        System.out.println("\n------ PRODUTOS DA CATEGORIA: " + categoria.toUpperCase() + " ------");
        for (Produto produto : produtos) {
            if (produto.categoria.equalsIgnoreCase(categoria)) {
                System.out.printf("%s - Mt %.2f (Estoque: %d)\n", produto.nome, produto.preco, produto.quantidadeDisponivel);
            }
        }
        System.out.println("-----------------------------------");
    }

    //exibir todos os produtos disponíveis na loja
    void exibirProdutos() {
        System.out.println("\n------ PRODUTOS DISPONIVEIS ------");
        for (Produto produto : produtos) {
            System.out.printf("%s - Mt %.2f (Estoque: %d) - Categoria: %s\n", produto.nome, produto.preco, produto.quantidadeDisponivel, produto.categoria);
        }
        System.out.println("-----------------------------------");
    }

    //adicionar um produto e registrar a venda
    void adicionarAoCarrinho() {
        Scanner scanner = new Scanner(System.in);
        exibirProdutos(); 
        
        System.out.print("Digite o nome do produto para adicionar ao carrinho: ");
        String nomeProduto = scanner.nextLine();
        
        // Encontra o produto com base no nome fornecido
        Produto produtoSelecionado = encontrarProdutoPorNome(nomeProduto);
        
        if (produtoSelecionado == null) {
            System.out.println("Produto nao encontrado.");
            return;
        }
        
        System.out.print("Digite a quantidade desejada: ");
        int quantidade = scanner.nextInt(); 
        
        // Verifica se a quantidade é válida e se está disponível em estoque
        if (quantidade <= 0 || quantidade > produtoSelecionado.quantidadeDisponivel) {
            System.out.println("Quantidade invalida ou nao disponivel em estoque.");
            return;
        }
        
        // Atualiza a quantidade e registra o valor da venda
        produtoSelecionado.quantidadeDisponivel -= quantidade;
        float valorVenda = produtoSelecionado.preco * quantidade;
        totalVendas += valorVenda;
        valorTotalEstoque += produtoSelecionado.preco * quantidade;
        
        System.out.printf("Produto %s (Mt %.2f) adicionado ao carrinho. Total: Mt %.2f\n", produtoSelecionado.nome, produtoSelecionado.preco, valorVenda);
    }

    // Método para devolver um produto ao estoque
    void devolverProduto() {
        Scanner scanner = new Scanner(System.in);
        exibirProdutos(); // Exibe os produtos disponíveis
        
        System.out.print("Digite o nome do produto para devolver: ");
        String nomeProduto = scanner.nextLine(); // Recebe o nome do produto a ser devolvido
        
        // Encontra o produto com base no nome fornecido
        Produto produtoSelecionado = encontrarProdutoPorNome(nomeProduto);
        
        if (produtoSelecionado == null) {
            System.out.println("Produto nao encontrado.");
            return;
        }
        
        System.out.print("Digite a quantidade a ser devolvida: ");
        int quantidade = scanner.nextInt(); 
        
        // Verifica se a quantidade é válida
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida.");
            return;
        }
        
        // Atualiza a quantidade do produto e registra o valor da devolução
        produtoSelecionado.quantidadeDisponivel += quantidade;
        float valorDevolucao = produtoSelecionado.preco * quantidade;
        totalVendas -= valorDevolucao;
        valorTotalEstoque -= produtoSelecionado.preco * quantidade;
        
        System.out.printf("Produto %s (Mt %.2f) devolvido. Total a ser descontado: Mt %.2f\n", produtoSelecionado.nome, produtoSelecionado.preco, valorDevolucao);
    }

    //encontrar produto pelo nome
    private Produto encontrarProdutoPorNome(String nome) {
        for (Produto produto : produtos) {
            // Compara o nome do produto com o nome fornecido (ignora maiúsculas e minúsculas)
            if (produto.nome.equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null; // Retorna null se o produto não for encontrado
    }

    // exibir o total de vendas e o valor total do estoque
    void exibirTotais() {
        System.out.printf("Total de Vendas: Mt %.2f\n", totalVendas);
        System.out.printf("Valor Total do Estoque: Mt%.2f\n", valorTotalEstoque);
    }

    //exibir o menu e lidar com as escolhas do usuário
    public static void menu(Loja loja) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
			System.out.println("____WELCOME TO NATASHAS'S STORE");
            System.out.println("\n------ MENU ------");
            System.out.println("1. Exibir Todos os Produtos");
            System.out.println("2. Exibir Produtos por Categoria");
            System.out.println("3. Adicionar ao Carrinho");
            System.out.println("4. Devolver Produto");
            System.out.println("5. Exibir Totais");
            System.out.println("6. Sair");
            System.out.println("-------------------");
            System.out.print("Opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    loja.exibirProdutos(); 
                    break;
                case 2:
                    // Exibe o menu de categorias
                    System.out.println("\n------ CATEGORIAS ------");
                    System.out.println("1. Bebidas");
                    System.out.println("2. Alimentos");
                    System.out.println("3. Doces");
                    System.out.println("4. Frutas");
                    System.out.println("5. Sobremesas");
                    System.out.println("------------------------");
                    System.out.print("Escolha a categoria: ");
                    int categoriaEscolhida = scanner.nextInt(); 
                    scanner.nextLine(); // Consome o restante da linha

                    // Exibe produtos de acordo com a categoria
                    switch (categoriaEscolhida) {
                        case 1:
                            loja.exibirProdutosPorCategoria("Bebidas");
                            break;
                        case 2:
                            loja.exibirProdutosPorCategoria("Alimentos");
                            break;
                        case 3:
                            loja.exibirProdutosPorCategoria("Doces");
                            break;
                        case 4:
                            loja.exibirProdutosPorCategoria("Frutas");
                            break;
                        case 5:
                            loja.exibirProdutosPorCategoria("Sobremesas");
                            break;
                        default:
                            System.out.println("Categoria invalida. Tente novamente.");
                            break;
                    }
                    break;
                case 3:
                    loja.adicionarAoCarrinho(); 
                    break;
                case 4:
                    loja.devolverProduto(); 
                    break;
                case 5:
                    loja.exibirTotais(); 
                    break;
                case 6:
                    System.out.println("Saindo..."); 
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente."); 
                    break;
            }
        } while (opcao != 6); 
    }
    
    // Método principal para executar o programa
    public static void main(String[] args) {
        Loja loja = new Loja(); //instância da loja
        menu(loja); //menu e permite interações do usuário
    }
}
