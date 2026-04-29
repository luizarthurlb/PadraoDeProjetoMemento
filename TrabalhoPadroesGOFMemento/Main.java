import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Editor editor = new Editor();
        Historico historico = new Historico();

        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Digitar texto");
            System.out.println("2 - Salvar estado");
            System.out.println("3 - Desfazer");
            System.out.println("4 - Mostrar texto atual");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o texto: ");
                    String texto = scanner.nextLine();
                    editor.setTexto(texto);
                    break;

                case 2:
                    historico.salvar(editor.salvar());
                    System.out.println("Estado salvo!");
                    break;

                case 3:
                    if (historico.temEstados()) {
                        editor.restaurar(historico.desfazer());
                        System.out.println("Desfeito!");
                    } else {
                        System.out.println("Nada para desfazer.");
                    }
                    break;

                case 4:
                    System.out.println("Texto atual: " + editor.getTexto());
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}