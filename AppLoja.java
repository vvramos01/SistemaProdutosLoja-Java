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
            //validar codigo
            boolean codigoExiste = p.stream()
                    .anyMatch(prod -> prod.getCodigo() == codigo);
            if (codigoExiste) {
                System.out.println("Código já Cadastrado!");
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
       for (Produto pro: p){
           System.out.println(pro);
       }
    }
}
