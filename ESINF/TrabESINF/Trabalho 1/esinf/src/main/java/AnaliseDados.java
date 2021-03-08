import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * The type Analise dados.
 */
public class AnaliseDados {
    /**
     * The Lista.
     */
    public  Map<Pais, LinkedList<Casos>> lista;


    /**
     * Instantiates a new Analise dados.
     *
     * @param ficheiro the ficheiro
     * @throws IOException    the io exception
     * @throws ParseException the parse exception
     */
    public AnaliseDados(String ficheiro) throws IOException, ParseException {
        this.lista = new HashMap();
        //long Start = System.currentTimeMillis();
        lerFicheiro(ficheiro);
        //long End = System.currentTimeMillis();
        //System.out.printf("lerFicheiro() = %d ms\n",End-Start);
    }

    /**
     * Ler ficheiro.
     *
     * @param ficheiro the ficheiro
     * @throws IOException    the io exception
     * @throws ParseException the parse exception
     */
    // 1  Carregar e guardar a informação relativa aos países e respetivos dados da pandemia COVID-19 a partir do
    //ficheiro de texto fornecido.
    public void lerFicheiro(String ficheiro) throws IOException, ParseException {
        String linha;
        BufferedReader in = new BufferedReader(new FileReader(ficheiro));
        try{
            in.readLine();
            LinkedList<Casos> casosDoPais = new LinkedList<Casos>();
            while ((linha = in.readLine())!= null) {
                String[] dados = linha.split(",");
                if (dados.length == 18) {
                    Pais pais = new Pais(remover_Aspas(dados[0]),remover_Aspas(dados[1]),remover_Aspas(dados[2]), check_NA_long(dados[10]), check_NA_float(dados[11]), check_NA_float(dados[12]),
                            check_NA_float(dados[13]), check_NA_float(dados[14]), check_NA_float(dados[15]),
                            check_NA_float(dados[16]), check_NA_float(dados[17]));
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dados[3].trim());
                    Casos casoDoDia = new Casos(date, check_NA_int(dados[4]), check_NA_int(dados[5]),
                            check_NA_int(dados[6]), check_NA_int(dados[7]), check_NA_int(dados[8]), check_NA_int(dados[9]));
                    if (!lista.containsKey(pais))
                        casosDoPais = new LinkedList<Casos>();
                    if (!casosDoPais.contains(casoDoDia))  casosDoPais.add(casoDoDia);
                    lista.put(pais, casosDoPais);
                } else {
                    throw new IllegalArgumentException("Ficheiro dados invalidos.");
                }
            }
        } finally { in.close(); }
    }

    /**
     * Check na int int.
     *
     * @param a the a
     * @return the int
     */
    public  int check_NA_int (String a){
        if(a.compareTo("NA")!=0) return Integer.parseInt(a.trim());
        return 0;
    }

    /**
     * Check na float float.
     *
     * @param a the a
     * @return the float
     */
    public  float check_NA_float (String a){
        if(a.compareTo("NA")!=0) return Float.parseFloat(a.trim());
        return 0;
    }

    /**
     * Check na long long.
     *
     * @param a the a
     * @return the long
     */
    public  long check_NA_long (String a){
        if(a.compareTo("NA")!=0) return Long.parseLong(a.trim());
        return 0;
    }

    /**
     * Remover aspas string.
     *
     * @param a the a
     * @return the string
     */
    public  String remover_Aspas (String a){
        if(a.length()>3) return a.substring(1,a.length()-1);
        return " ";
    }


    /**
     * Novos casos mortes por continente mes tree map.
     *
     * @return the tree map
     */
    public TreeMap<String, TreeMap<Integer, ArrayList<Integer>>> novosCasosMortesPorContinenteMes(){
        Calendar calendar = Calendar.getInstance();
        TreeMap <String, TreeMap<Integer, ArrayList<Integer>>> listaCM = new TreeMap<>();
        TreeMap <Integer, ArrayList<Integer>> mesesData = new TreeMap<>();
        ArrayList<Integer> newCM = new ArrayList<>();
        newCM.add(0);
        for(Pais pais : lista.keySet()){

            if(mesesData!=null) mesesData = listaCM.get(pais.getContinente());

            LinkedList<Casos> listaCasos = lista.get(pais);
            for (Casos casosPais : listaCasos) {
                calendar.setTime(casosPais.getDate());
                if(mesesData!=null) {
                    if (mesesData.get(calendar.get(Calendar.MONTH)) != null) {
                        newCM.add(0, mesesData.get(calendar.get(Calendar.MONTH)).get(0) + casosPais.getNew_cases());
                        newCM.add(1, mesesData.get(calendar.get(Calendar.MONTH)).get(1) + casosPais.getNew_deaths());
                    } else {
                        newCM.add(0,  casosPais.getNew_cases());
                        newCM.add(1,  casosPais.getNew_deaths());
                    }
                }else{
                    newCM.add(0, casosPais.getNew_cases());
                    newCM.add( casosPais.getNew_deaths());
                    mesesData = new TreeMap<>();
                }
                mesesData.put(calendar.get(Calendar.MONTH),newCM);
                newCM = new ArrayList<>();
            }
            listaCM.put(pais.getContinente(),mesesData);

        }
        return listaCM;
    }

    /**
     * Printnovos casos mortes por continente mes.
     *
     * @param info the info
     */
    public void printnovosCasosMortesPorContinenteMes(TreeMap<String, TreeMap<Integer, ArrayList<Integer>>> info){
        System.out.printf("%-20s%-20s%-20s%-20s\n","continent", "month" , "new_cases", "new_deaths");
        for (Object key : info.keySet()) {
            String cont = key.toString();
            TreeMap<Integer, ArrayList<Integer>> info2 = info.get(key);
            for (Object key2 : info2.keySet()) {
                int mes = Integer.parseInt(key2.toString());
                ArrayList<Integer> aux= info2.get(key2);
                int mortes = aux.get(0);
                int casos = aux.get(1);
                System.out.printf("%-20s%-20s%-20d%-20d\n", cont, mes+1, mortes, casos);
            }
        }
    }

    /**
     * Num min dias hash map.
     *
     * @return the hash map
     * @throws ParseException the parse exception
     */
    // 2 Apresentar uma lista de países ordenados por ordem crescente do número mínimo de dias que foi
    //necessário para atingir os 50.000 casos positivos
    public  HashMap<Pais, ArrayList<Integer>> numMinDias() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        HashMap<Pais, ArrayList<Integer>> unsorted = new HashMap();
        for (Pais pais : lista.keySet()) {
            int position = binarySearch(lista.get(pais),0, lista.get(pais).size()-1,50000);
            if(position!=-1) {
                Date inicio = dateFormat.parse("2020-01-01");
                String inicioS=dateFormat.format(inicio);
                String fim = dateFormat.format(lista.get(pais).get(position).getDate());
                LocalDate d1 = LocalDate.parse(inicioS, DateTimeFormatter.ISO_LOCAL_DATE);
                LocalDate d2 = LocalDate.parse(fim, DateTimeFormatter.ISO_LOCAL_DATE);
                Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
                long diffDays = diff.toDays();
                ArrayList<Integer> slist = new ArrayList<>();
                slist.add(position);
                slist.add((int)diffDays);
                unsorted.put(pais, slist);
            }

        }
        HashMap<Pais,ArrayList<Integer>> sorted = sortByValue(unsorted);
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n","iso_code", "continent" , "location", "date", "total_cases", "mindays");
        for(Pais pais : sorted.keySet()){
            Casos caso = lista.get(pais).get(sorted.get(pais).get(0));
            System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n",pais.getIso_code(),pais.getContinente(),pais.getLocation(),
                    dateFormat.format(caso.getDate()),caso.getTotal_cases(),sorted.get(pais).get(1));
        }
        return sorted;

    }

    /**
     * Sort by value hash map.
     *
     * @param hm the hm
     * @return the hash map
     */
    public  HashMap<Pais, ArrayList<Integer>> sortByValue(HashMap<Pais, ArrayList<Integer>> hm){
        List<Map.Entry<Pais, ArrayList<Integer>> > list = new LinkedList<Map.Entry<Pais, ArrayList<Integer>> >(hm.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Pais, ArrayList<Integer>> >() {
            public int compare(Map.Entry<Pais, ArrayList<Integer>> o1, Map.Entry<Pais, ArrayList<Integer>> o2) {
                return (o1.getValue().get(1)).compareTo(o2.getValue().get(1));
            }
        });
        HashMap<Pais, ArrayList<Integer>> temp = new LinkedHashMap<Pais, ArrayList<Integer>>();
        for (Map.Entry<Pais, ArrayList<Integer>> aa : list) { temp.put(aa.getKey(), aa.getValue()); }
        return temp;
    }

    /**
     * Binary search int.
     *
     * @param Caselist the caselist
     * @param i        the
     * @param f        the f
     * @param x        the x
     * @return the int
     */
    public  int binarySearch(LinkedList<Casos> Caselist, int i, int f, int x) {
        if (f >= i) {
            int mid = i + (f - i) / 2;
            if(Caselist.get(mid).getTotal_cases() > x && Caselist.get(mid-1).getTotal_cases()<x)
                return mid;

            if (Caselist.get(mid).getTotal_cases() == x)
                return mid;

            if (Caselist.get(mid).getTotal_cases() > x)
                return binarySearch(Caselist, i, mid - 1, x);

            if (Caselist.get(mid).getTotal_cases() < x)
                return binarySearch(Caselist, mid + 1, f, x);

        }

        return -1;
    }


    /**
     * Casos positivos num continente hash map.
     *
     * @param continente the continente
     * @param mes        the mes
     * @return the hash map
     */
    //4 Devolver para cada dia de um determinado mês e para um dado continente, os países ordenados por
    //ordem decrescente do número de novos casos positivosntinente
    public  HashMap<Integer,HashMap<Pais,Integer>> casosPositivosNumContinente(String continente,int mes){
        HashMap<Integer,HashMap<Pais,Integer>> casosCont = new HashMap<>();
        HashMap<Pais,Integer> MapPaisPosicaoPrimeiroDia = new HashMap<>();

        //Obtem a posiçao do primeiro dia do mês com registado na tabela
        for(Pais pais : lista.keySet()){
            if(pais.getContinente().equals(continente)){
                int posicaoPrimeiroDia = binarySearchDate(lista.get(pais),0, lista.get(pais).size()-1,mes);
                MapPaisPosicaoPrimeiroDia.put(pais,posicaoPrimeiroDia);
            }
        }

        //Para cada dia do mes guarda um mapa com o pais e o numero de novos casos nesse dia
        YearMonth yearMonthObject = YearMonth.of(2020, mes);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        for (int i = 1; i < daysInMonth+1; i++) {
            HashMap<Pais,Integer> nCasosPorPais = new HashMap<>();
            for(Pais pais : MapPaisPosicaoPrimeiroDia.keySet()) {
                if (MapPaisPosicaoPrimeiroDia.get(pais) != lista.get(pais).size()) {
                    nCasosPorPais.put(pais, 0);
                    if (MapPaisPosicaoPrimeiroDia.get(pais) == -1) {
                        nCasosPorPais.put(pais, 0);
                    } else {
                        int[] dataArray = simpleDateFormat(lista.get(pais).get(MapPaisPosicaoPrimeiroDia.get(pais)).getDate());
                        if(i < dataArray[2])
                            nCasosPorPais.put(pais, 0);
                        else {
                            nCasosPorPais.put(pais, lista.get(pais).get(MapPaisPosicaoPrimeiroDia.get(pais)).getNew_cases());
                            MapPaisPosicaoPrimeiroDia.replace(pais, MapPaisPosicaoPrimeiroDia.get(pais) + 1);
                        }
                    }
                }
            }
            casosCont.put(i,nCasosPorPais);
        }
        for (Integer j: casosCont.keySet()) {
            casosCont.replace(j,sortByValueInteger(casosCont.get(j)));
            System.out.printf("Dia %2s  -->  ",j);
            int i =0;
            for(Pais pais: casosCont.get(j).keySet()) {
                if(i==0) {
                    System.out.printf("%s(%d)%n", pais.getLocation(), casosCont.get(j).get(pais));
                    i++;
                }else
                    System.out.printf("%-13s%s(%d)%n","", pais.getLocation(), casosCont.get(j).get(pais));

            }
        }
        return casosCont;
    }

    /**
     * Binary search date int.
     *
     * @param Caselist the caselist
     * @param i        the
     * @param f        the f
     * @param x        the x
     * @return the int
     */
    public  int binarySearchDate(LinkedList<Casos> Caselist, int i, int f, int x) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (f >= i) {
            int mid = i + (f - i) / 2;
            int[] dataMid=simpleDateFormat(Caselist.get(mid).getDate());
            if (dataMid[1] == x ){
                try{
                    int[] dataMid1=simpleDateFormat(Caselist.get(mid-1).getDate());
                    if(dataMid1[2]<dataMid[2])
                        return binarySearchDate(Caselist,i,mid-1,x);
                    else
                        return mid;
                }catch (IndexOutOfBoundsException e){
                    return mid;
                }
            }
            if (dataMid[1] > x)
                return binarySearchDate(Caselist, i, mid - 1, x);
            if (dataMid[1] < x)
                return binarySearchDate(Caselist, mid + 1, f, x);
        }
        return -1;
    }


    /**
     * Simple date format int [ ].
     *
     * @param date the date
     * @return the int [ ]
     */
    public  int[] simpleDateFormat(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String simple = dateFormat.format(date);
        String[] temp = simple.split("-");
        int[] dataArray = new int[3];
        for (int j = 0; j < 3; j++) {
            dataArray[j]= Integer.parseInt(temp[j]);
        }
        return dataArray;
    }

    /**
     * Sort by value integer hash map.
     *
     * @param hm the hm
     * @return the hash map
     */
    public  HashMap<Pais, Integer> sortByValueInteger(HashMap<Pais, Integer> hm){
        List<Map.Entry<Pais,Integer> > list = new LinkedList<Map.Entry<Pais, Integer> >(hm.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Pais, Integer> >() {
            public int compare(Map.Entry<Pais, Integer> o1, Map.Entry<Pais, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        HashMap<Pais, Integer> temp = new LinkedHashMap<Pais, Integer>();
        for (Map.Entry<Pais, Integer> aa : list) { temp.put(aa.getKey(), aa.getValue()); }
        return temp;
    }


    /**
     * Find paises com mais 70 fumadores array list.
     *
     * @return the array list
     */
    //5 Devolver numa estrutura adequada, todos os países com mais de 70% de fumadores, ordenados por
    //ordem decrescente do número de novas mortes.
    public  ArrayList findPaisesComMais70Fumadores(){
        ArrayList <ArrayList<String>> listaPaisesFumadores = new ArrayList() ;
        float numTotalFumadores=0;
        for(Pais pais : lista.keySet()){
            int numTotalNovasMortes=0;
            numTotalFumadores= pais.getFemale_smokers() + pais.getMale_smokers();
            if(numTotalFumadores > 70){
                ArrayList conteudo = new ArrayList();
                conteudo.add(pais.getLocation());
                conteudo.add(Float.toString(numTotalFumadores));
                numTotalNovasMortes = lista.get(pais).getLast().getTotal_deaths();
                conteudo.add(Integer.toString(numTotalNovasMortes));
                listaPaisesFumadores.add(conteudo);
            }
        }
        quickSort(listaPaisesFumadores,0,listaPaisesFumadores.size()-1);

        return listaPaisesFumadores;
    }

    /**
     * Quick sort.
     *
     * @param arr   the arr
     * @param begin the begin
     * @param end   the end
     */
    public  void quickSort(ArrayList arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private  int partition(ArrayList <ArrayList<String>> arr, int begin, int end) {
        int pivot = Integer.parseInt(arr.get(end).get(2));
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (Integer.parseInt(arr.get(j).get(2)) >= pivot) {
                i++;

                ArrayList swapTemp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, swapTemp);
            }
        }

        ArrayList swapTemp = arr.get(i + 1);
        arr.set(i + 1, arr.get(end));
        arr.set(end, swapTemp);

        return i+1;
    }
}
