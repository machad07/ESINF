import java.io.IOException;
import java.text.ParseException;
import java.util.*;
public class main {
    private static AnaliseDados ad;
    public static final String FICHEIRO_LEITURA= "owid-covid-data.csv";

    public static void main(String args[]) throws IOException, ParseException {
        ad = new AnaliseDados(FICHEIRO_LEITURA);
        menu();
    }

    public static void menu() throws IOException, ParseException{
        //TimeZone.setDefault( TimeZone.getTimeZone("UTC"));
        String[] array = new String[6];
        array[0]="Africa";
        array[1]="Asia";
        array[2]="Europe";
        array[3]="North America";
        array[4]="South America";
        array[5]="Oceania";
        String continentes= "%n1-Africa%n2-Asia%n3-Europe%n4-North America%n5-South America%n6-Oceania%n";
        String menu ="%n1-Lista de paises ordenada por número de dias necessários para atingir 50000 casos" +
                    "%n2-Devolve o total de novos_casos/novas_mortes por continente/mês%n"+
                    "3-Paises de um continente ordenados por novos casos positivos num dado mês%n4-Países com mais de 70%s fumadores%n" +
                    "5-Sair%n";
        System.out.printf(menu,"%");

        Scanner sc = new Scanner(System.in);
        String x =sc.nextLine();
        int num=0;

            do {
                switch (x) {
                    case ("0"):
                        System.out.printf(menu,"%");
                        x = sc.nextLine();
                        break;
                    case ("1"):
                        //long Start2 = System.currentTimeMillis();
                        ad.numMinDias();
                        //long End2 = System.currentTimeMillis();
                        //System.out.printf("numMinDias() = %d ms\n", End2 - Start2);
                        System.out.println("\n0-Mostrar menu\n");
                        x = sc.nextLine();
                        break;

                    case ("2"):
                        //long Start3 = System.currentTimeMillis();
                        TreeMap<String, TreeMap<Integer, ArrayList<Integer>>> data = ad.novosCasosMortesPorContinenteMes();
                        //TreeMap<String, TreeMap<Integer, int[]>> data = ad.novosCasosMortesPorContinenteMes23();
                        //ad.novosCasosMortesPorContinenteMesAdapter();
                        //long End3 = System.currentTimeMillis();
                        ad.printnovosCasosMortesPorContinenteMes(data);
                        //System.out.printf("novosCasosMortesPorContinenteMesAdapter() = %d ms\n", End3 - Start3);
                        System.out.println("\n0-Mostrar menu\n");
                        x = sc.nextLine();
                        break;

                    case ("3"):
                        System.out.printf("Selecione o continente:"+continentes);
                        String y = sc.nextLine();
                        String continente =null;
                        int num1=0;
                        do{
                            switch (y) {
                                case ("1"):
                                    continente = "Africa";
                                    num1=1;
                                    break;
                                case ("2"):
                                    continente = "Asia";
                                    num1=2;
                                    break;
                                case ("3"):
                                    continente = "Europe";
                                    num1=3;
                                    break;
                                case ("4"):
                                    continente = "North America";
                                    num1=4;
                                    break;
                                case ("5"):
                                    continente = "South America";
                                    num1=5;
                                    break;
                                case ("6"):
                                    continente = "Oceania";
                                    num1=6;
                                    break;
                                default:
                                        System.out.println("Opção inválida");
                                        System.out.printf("Selecione o continente:"+continentes);
                                        y = sc.nextLine();
                                    break;
                            }
                        }while(num1==0);
                        System.out.println("selecione o mês(1-12)");
                        String z=sc.nextLine();
                        int num2=0;
                        do {
                            try {
                                num2=Integer.parseInt(z);
                                if (num2 < 12 && num2 > 0) {
                                    //long Start4 = System.currentTimeMillis();
                                    ad.casosPositivosNumContinente(continente, num2);
                                    //long End4 = System.currentTimeMillis();
                                    //System.out.printf("\nnovosCasosMortesPorContinenteMesAdapter() = %d ms\n", End4 - Start4);
                                }else{
                                    System.out.println("Opção inválida\nSelecione o mês(1-12)");
                                    z = sc.nextLine();
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Opção inválida\nSelecione o mês(1-12)");
                                z = sc.nextLine();
                            }
                        }while(num2 > 12 || num2 < 1);
                        System.out.println("\n0-Mostrar menu\n");
                        x = sc.nextLine();
                        break;

                    case ("4"):
                        //long Start5 = System.currentTimeMillis();
                        System.out.println(ad.findPaisesComMais70Fumadores());
                        //long End5 = System.currentTimeMillis();
                        //System.out.printf("findPaisesComMais70Fumadores() = %d ms\n", End5 - Start5);
                        System.out.println("\n0-Mostrar menu\n");
                        x = sc.nextLine();
                        break;

                    case ("5"):
                        num = 5;
                        break;

                    default:
                        try {
                            System.out.println("Opção inválida");
                            System.out.println("\n0-Mostrar menu\n");
                            x = sc.nextLine();
                            num =Integer.parseInt(x);
                        } catch (NumberFormatException e) {
                            System.out.println("Opção inválida");
                            System.out.println("\n0-Mostrar menu\n");
                            x = sc.nextLine();
                        }
                }
            } while (num != 5);
    }

}
