import java.util.Scanner;

public class TrocoSA3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário o valor total das compras
        System.out.println("Valor Total das Compras:");
        double valorTotal = scanner.nextDouble();

        // Solicita ao usuário o valor recebido
        System.out.println("Valor Recebido:");
        double valorRecebido = scanner.nextDouble();

        // Calcula o troco
        double troco = valorRecebido - valorTotal;
        System.out.println("Troco: R$ " + String.format("%.2f", troco));

        // Calcula o menor número de notas e moedas para o troco
        int[] notas = {200, 100, 50, 20, 10, 5, 2}; // notas
        int[] moedas = {100, 50, 25, 10, 5, 1}; // moedas/centavos (Incluindo a moeda de R$ 1,00 "100 centavos")

        troco = Math.round(troco * 100); // arredondar
        int trocoInt = (int) troco;

        System.out.println("Notas e Moedas para troco:");
        for (int nota : notas) {
            int quantidade = trocoInt / (nota * 100);
            if (quantidade > 0) {
                System.out.println(quantidade + " Nota(s) de R$ " + nota);
                trocoInt %= (nota * 100);
            }
        }

        for (int moeda : moedas) {
            int quantidade = trocoInt / moeda;
            if (quantidade > 0) {
                double valorMoeda = moeda / 100.0;
                System.out.println(quantidade + " Moeda(s) de R$ " + String.format("%.2f", valorMoeda));
                trocoInt %= moeda;
            }
        }

        scanner.close();
    }
}
