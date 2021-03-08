import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;


public class Main {
    private static AnaliseDados ad;


    public static void main(String agrs[]) throws IOException, ParseException {
        menu();
    }

    /**
     * Menu.
     *
     * @throws IOException    the io exception
     * @throws ParseException the parse exception
     */
    public static void menu() throws IOException, ParseException {
        String menu1 ="Que tipo de rede deseja ler:\n" +
                "1.Big\n" +
                "2.Small\n";
        System.out.printf("%s",menu1);

        Scanner sc = new Scanner(System.in);
        String x =sc.nextLine();

        int check = 0;

        do {
            switch (x) {
                case("1"):
                    ad = new AnaliseDados();
                    ad.lerFicheiros("big/busers.txt","big/bcountries.txt","big/brelationships.txt","big/bborders.txt");
                    ad.centralidadeCountries();
                    check=1;
                    break;

                case("2"):
                    ad = new AnaliseDados();
                    ad.lerFicheiros("small/susers.txt","small/scountries.txt","small/srelationships.txt","small/sborders.txt");
                    ad.centralidadeCountries();
                    check=1;
                    break;

                default:
                    System.out.printf("Valor inválido, por favor tente novamente:\n");
                    x =sc.nextLine();

            }
        }while(check!=1);

        String menu2 ="\nFuncionalidades:\n" +
                "1. Amigos dos utilizadores mais populares.\n" +
                "2. Verificar se a rede é conetada.\n" +
                "3. Amigos nas proximidades.\n" +
                "4. Cidades com maior centralidade.\n" +
                "5. Caminho terreste mais curto entre dois utilizadores.\n" +
                "\nsair. Encerrar aplicação.\n";

        String verMenu = "\n0. Mostra menu.\n";

        System.out.printf("%s",menu2);

        x =sc.nextLine();
        check = 0;

        do {
            switch (x) {
                case("0"):
                    System.out.printf("%s",menu2);
                    x = sc.nextLine();
                    break;

                case("1"):
                    System.out.printf("\nInsira o número de utilizadores mais populares que deseja:\n");
                    x = sc.nextLine();
                    ad.getAmigosPopulares(Integer.parseInt(x));
                    System.out.printf("%s",verMenu);
                    x = sc.nextLine();
                    break;

                case("2"):
                    System.out.printf("%s",ad.eConecta());
                    System.out.printf("%s",verMenu);
                    x = sc.nextLine();
                    break;

                case("3"):
                    System.out.printf("Insira o utilizador:\n");
                    String user =sc.nextLine();
                    System.out.printf("\nInsira o número de fronteiras:\n");
                    int nFronteiras = sc.nextInt();
                    sc.nextLine();
                    ad.amigosProximidades(user,nFronteiras);
                    System.out.printf("%s",verMenu);
                    x = sc.nextLine();
                    break;

                case("4"):
                    System.out.printf("Quantas cidades deseja ver:\n");
                    String nCidades = sc.nextLine();

                    System.out.printf("Qual a percentagem minima de utilizadores deseja que as cidades tenham:\n");
                    String prelativa = sc.nextLine();

                    ad.printExercicio5(Integer.parseInt(nCidades),Double.parseDouble(prelativa));
                    System.out.printf("%s",verMenu);
                    x = sc.nextLine();
                    break;

                case("5"):
                    System.out.printf("Insira o utilizador origem:\n");
                    String user1 =sc.nextLine();
                    System.out.printf("Insira o utilizador destino:\n");
                    String user2 =sc.nextLine();
                    System.out.printf("Insira o número de cidades intermédias:\n");
                    int intermedias = sc.nextInt();
                    sc.nextLine();
                    ad.caminhoTerrestreCurto(user1,user2,intermedias);

                    System.out.printf("%s",verMenu);
                    x = sc.nextLine();
                    break;

                case("sair"):
                    check=1;
                    break;

                default:
                    System.out.printf("Valor inválido, por favor tente novamente:\n");
                    System.out.printf("%s",verMenu);
                    x =sc.nextLine();

            }
        }while(check!=1);

    }
}
