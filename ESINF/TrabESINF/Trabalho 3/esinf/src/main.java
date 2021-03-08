import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * The type Main.
 */
public class main {
    private static AnaliseDados ad;

    /**
     * Main.
     *
     * @param args the args
     * @throws IOException    the io exception
     * @throws ParseException the parse exception
     */
    public static void main(String args[]) throws IOException, ParseException {
        menu();
    }


    /**
     * Menu.
     *
     * @throws IOException    the io exception
     * @throws ParseException the parse exception
     */
    public static void menu() throws IOException, ParseException {
        ad = new AnaliseDados();
        ad.readFile("Periodic Table of Elements.csv");
        String menu1 = "\nFuncionalidades:\n" +
                "1. Pesquisar elemento.\n" +
                "2. Pesquisar por intrevalo.\n" +
                "3. Repetições de configurações eletronicas.\n" +
                "4. Configurações eletrónicas mais distantes.\n" +
                "5. Caminho terreste mais curto entre dois utilizadores.\n" +
                "\nsair. Encerrar aplicação.\n";

        String verMenu = "\n0. Mostra menu.\n";
        System.out.printf("%s", menu1);

        Scanner sc = new Scanner(System.in);

        String x = sc.nextLine();
        boolean check = true;

        do {
            switch (x) {
                case ("0"):
                    System.out.printf("%s", menu1);
                    x = sc.nextLine();
                    break;

                case ("1"):
                    String menu2 = "\nPesquisa por:\n" +
                            "1. Atomic Number\n" +
                            "2. Element\n" +
                            "3. Symbol\n" +
                            "4. Atomic Mass\n" +
                            "\nsair. Encerrar aplicação.\n";
                    System.out.printf("%s", menu2);
                    boolean check2 = true;
                    Object elementInfo;
                    x = sc.nextLine();
                    do {
                        switch (x) {
                            case ("1"):
                                System.out.printf("Insira aqui o numero atómico: ");
                                int atomicNumber = sc.nextInt();
                                    sc.nextLine();
                                elementInfo = ad.getElementByAtomicNumber(atomicNumber);
                                    if(elementInfo!=null) {
                                        System.out.printf("\nInformações do elemento:\n\n%s\n", elementInfo);
                                    }else {
                                        System.out.println("Elemento não encontrado");
                                    }
                                check2 = false;
                                break;

                            case ("2"):
                                System.out.printf("Insira aqui o elemento: ");
                                String element = sc.nextLine();
                                elementInfo = ad.getElementByElement(element.trim());
                                    if(elementInfo!=null) {
                                        System.out.printf("\nInformações do elemento:\n\n%s\n", elementInfo);
                                    }else {
                                        System.out.println("Elemento não encontrado");
                                    }
                                check2 = false;
                                break;

                            case ("3"):
                                System.out.printf("Insira aqui o simbolo: ");
                                String symbol = sc.nextLine();
                                elementInfo = ad.getElementBySymbol(symbol.trim());
                                    if(elementInfo!=null) {
                                        System.out.printf("\nInformações do elemento:\n\n%s\n", elementInfo);
                                    }else {
                                        System.out.println("Elemento não encontrado");
                                    }
                                check2 = false;
                                break;

                            case ("4"):
                                System.out.printf("Insira aqui o massa atomica: ");
                                float atomicMass = sc.nextFloat();
                                sc.nextLine();
                                elementInfo = ad.getElementByAtomicMass(atomicMass);
                                    if(elementInfo!=null) {
                                        System.out.printf("\nInformações do elemento:\n\n%s\n", elementInfo);
                                    }else {
                                        System.out.println("Elemento não encontrado");
                                    }
                                check2 = false;
                                break;

                        }
                    } while (check2);
                    System.out.printf("%s", verMenu);
                    x = sc.nextLine();
                    break;

                case ("2"):
                    float min;
                    float max;
                    System.out.printf("Introduza o intrevalo:\n");
                    System.out.printf("Valor minimo: ");
                    min = sc.nextFloat();
                    sc.nextLine();


                    System.out.printf("Valor maximo: ");
                    max = sc.nextFloat();
                    sc.nextLine();

                    ad.printUmB(min, max);

                    System.out.printf("\n%s", verMenu);
                    x = sc.nextLine();
                    break;

                case ("3"):
                    System.out.printf("\nEstas são as configurações eletrónicas com mais do que uma repetição:\n\n");

                    ad.printDoisA();

                    System.out.printf("%s", verMenu);
                    x = sc.nextLine();
                    break;

                case ("4"):
                    System.out.println(ad.findLongestPath());
                    System.out.printf("%s", verMenu);
                    x = sc.nextLine();
                    break;

                case ("5"):
                    ad.completeBinaryTree();
                    System.out.printf("%s", verMenu);
                    x = sc.nextLine();
                    break;

                case ("sair"):
                    check = false;
                    break;

                default:
                    System.out.printf("Valor inválido, por favor tente novamente:\n");
                    System.out.printf("%s", verMenu);
                    x = sc.nextLine();

            }
        } while (check);

    }
}


