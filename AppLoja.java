package Exercicios;

import java.util.*;

public class AppLoja {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Produto> p = new ArrayList<>();

        System.out.print("Quantos produtos serão cadastrados: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("\nProduto #" + i + ":");
            System.out.print("Código: ");
            int codigo = sc.nextInt();

            // validar codigo
            boolean codigoExiste = p.stream()
                    .anyMatch(prod -> prod.getCodigo() == codigo);

            if (codigoExiste) {
                System.out.println(" Código já cadastrado!");
                i--;
                continue;
            }

            sc.nextLine();

            System.out.print("Nome: ");
            String nome = sc.nextLine();
            
            System.out.print("Preço: ");
            double preco = sc.nextDouble();

            p.add(new Produto(codigo, nome, preco));
        }

        //aumento
        System.out.print("\nDigite o código do produto a reajustar: ");
        int codigoBusca = sc.nextInt();

        Optional<Produto> produtoSelecionado = p.stream()
                .filter(prod -> prod.getCodigo() == codigoBusca)
                .findFirst();

        if (produtoSelecionado.isPresent()) {
            System.out.print("Digite a porcentagem de aumento (%): ");
            double porcentagem = sc.nextDouble();

            produtoSelecionado.get().aumentoPreco(porcentagem);
            System.out.println("\n Preço atualizado com sucesso!");
        } else {
            System.out.println("\n Codigo não encontrado!");
        }

        // listagem final
        System.out.println("\n Lista Atualizada de Produtos:");
        for (Produto pro : p) {
            System.out.println(pro);
        }

        sc.close();
    }
}
