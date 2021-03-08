//import com.sun.tools.javac.util.Pair;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import graph.*;
import graphbase.*;
import javafx.util.Pair;

/**
 * The type Analise dados.
 */
public class AnaliseDados {
    /**
     * The Lista users.
     */
    public List<User> listaUsers;
    /**
     * The Lista countries.
     */
    public List<Country> listaCountries;
    /**
     * The Borders network.
     */
    public BordersNetwork bordersNetwork;
    /**
     * The Relatioships network.
     */
    public RelatioshipsNetwork relatioshipsNetwork;

    /**
     * Instantiates a new Analise dados.
     */
    public AnaliseDados() {
    }

    /**
     * Ler ficheiros.
     *
     * @param ficheiroUsers         the ficheiro users
     * @param ficheiroCoutries      the ficheiro coutries
     * @param ficheiroRelationships the ficheiro relationships
     * @param ficheiroBorders       the ficheiro borders
     * @throws IOException the io exception
     */
// 1)
    public void lerFicheiros(String ficheiroUsers, String ficheiroCoutries, String ficheiroRelationships, String ficheiroBorders) throws IOException{
        lerFicheiroUsers(ficheiroUsers);
        lerFicheiroCountries(ficheiroCoutries);
        lerFicheiroRelationships(ficheiroRelationships);
        lerFicheiroBorders(ficheiroBorders);
    }

    /**
     * Ler ficheiro users.
     *
     * @param ficheiroUsers the ficheiro users
     * @throws IOException the io exception
     */
    public void lerFicheiroUsers(String ficheiroUsers) throws IOException {
        String linha;
        BufferedReader in = new BufferedReader(new FileReader(ficheiroUsers));
        try{
            this.listaUsers = new ArrayList<>();
            while ((linha = in.readLine())!= null) {
                String[] dados = linha.split(",");
                if (dados.length == 3) {
                    if(getUserById(dados[0].trim())==null) {
                        User user = new User(dados[0].trim(), Integer.parseInt(dados[1].trim()), dados[2].trim());
                        if(!this.listaUsers.contains(user))
                            this.listaUsers.add(user);
                    }
                } else {
                    throw new IllegalArgumentException("Ficheiro de utilizadores com dados invalidos.");
                }
            }
        } finally { in.close(); }
    }

    /**
     * Ler ficheiro countries.
     *
     * @param ficheiroCoutries the ficheiro coutries
     * @throws IOException the io exception
     */
    public void lerFicheiroCountries(String ficheiroCoutries) throws IOException {
        String linha;
        BufferedReader in = new BufferedReader(new FileReader(ficheiroCoutries));
        try{
            this.listaCountries = new ArrayList<>();
            while ((linha = in.readLine())!= null) {
                String[] dados = linha.split(",");
                if (dados.length == 6) {
                    if(getCountryById(dados[0].trim())==null) {
                        Country country = new Country(dados[0].trim(), dados[1].trim(), Double.parseDouble(dados[2].trim()),
                                dados[3].trim(), Float.parseFloat(dados[4].trim()), Float.parseFloat(dados[5].trim()));
                        if(!this.listaCountries.contains(country))
                            this.listaCountries.add(country);
                    }
                } else {
                    throw new IllegalArgumentException("Ficheiro de paises com dados invalidos.");
                }
            }
        } finally { in.close(); }
    }

    /**
     * Ler ficheiro relationships.
     *
     * @param ficheiroRelationships the ficheiro relationships
     * @throws IOException the io exception
     */
    public void lerFicheiroRelationships(String ficheiroRelationships) throws IOException {
        String linha;
        BufferedReader in = new BufferedReader(new FileReader(ficheiroRelationships));
        try{
            this.relatioshipsNetwork = new RelatioshipsNetwork();
            while ((linha = in.readLine())!= null) {
                String[] dados = linha.split(",");
                if (dados.length == 2) {
                    User user1 = getUserById(dados[0].trim());
                    User user2 = getUserById(dados[1].trim());
                    if(user1!= null && user2!= null) {
                        this.relatioshipsNetwork.addUser(user1);
                        this.relatioshipsNetwork.addUser(user2);
                        this.relatioshipsNetwork.addRelationship(user2,user1);
                    }
                } else {
                    throw new IllegalArgumentException("Ficheiro de relações com  dados invalidos.");
                }
            }
        } finally { in.close(); }
    }

    /**
     * Ler ficheiro borders.
     *
     * @param ficheiroBorders the ficheiro borders
     * @throws IOException the io exception
     */
    public void lerFicheiroBorders(String ficheiroBorders) throws IOException {
        String linha;
        BufferedReader in = new BufferedReader(new FileReader(ficheiroBorders));
        try{
            this.bordersNetwork = new BordersNetwork();
            while ((linha = in.readLine())!= null) {
                String[] dados = linha.split(",");
                if (dados.length == 2) {
                    Country country1 = getCountryById(dados[0].trim());
                    Country country2 = getCountryById(dados[1].trim());
                    if(country1!= null && country2!= null) {
                        this.bordersNetwork.addCountry(country1);
                        this.bordersNetwork.addCountry(country2);
                        this.bordersNetwork.addBorder(country1,country2);
                    }
                } else {
                    throw new IllegalArgumentException("Ficheiro de fronteiras com  dados invalidos.");
                }
            }
        } finally { in.close(); }
    }

    /**
     * Centralidade countries.
     */
    public void centralidadeCountries(){
        for (Country country :this.listaCountries)
            country.mediaProximidade(this.listaCountries);
    }

    /**
     * Verifica se o grafo é conecto e se sim evolve o caminhi mais curto para aceder a qualquer outro vertice.
     *
     * @return the string
     */
// 3)
    public String eConecta(){
        LinkedList<User> a = GraphAlgorithms2.BFS(relatioshipsNetwork.getGraphRelationships(),relatioshipsNetwork.getVertex(0));
        LinkedList<User> b  = GraphAlgorithms2.BFS(relatioshipsNetwork.getGraphRelationships(),a.getLast());
        LinkedList al = new LinkedList();
        EdgeAsDoubleGraphAlgorithms.shortestPath(relatioshipsNetwork.getGraphRelationships(),b.getLast(),b.getFirst(),al);
        if(b.size()==relatioshipsNetwork.getGraphRelationships().numVertices())
            return (al.size()-1) != 1 ? String.format("A rede de amizades é conectada: %d ligações para conseguir contactar qualquer utilizador.\n",al.size()-1) :
                    String.format("A rede de amizades é conectada: %d ligação para conseguir contactar qualquer utilizador.\n",al.size()-1);
            return String.format("A rede de amizades não é conectada.\n");
    }

    /**
     * Print exercicio 5.
     *
     * @param nCidades  the n cidades
     * @param pRelativa the p relativa
     */
// 5)
    public void printExercicio5(int nCidades, double pRelativa){
        int count = 1;
        System.out.printf("%-4s|%-15s|%-15s|\n","", "Pais", "Capital");
        System.out.printf("----|---------------|---------------|\n");
        for (Country country : sortByMediaProximidade(nCidades, pRelativa)) {
            System.out.printf("%-4d|%-15s|%-15s|\n", count++, country.getName(), country.getCapital());
        }
    }

    /**
     * Sort by media proximidade list.
     *
     * @param nCidades   the n cidades
     * @param percentage the percentage
     * @return the list
     */
    public List<Country> sortByMediaProximidade(int nCidades, double percentage){
        List<Country> countryList = cidadesComPUtilizadores(percentage);

        Comparator<Country> byMediaProximidade = new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                if (o1.getCentralidade() < o2.getCentralidade())
                    return -1;
                if (o1.getCentralidade() > o2.getCentralidade())
                    return 1;
                return 0;
            }
        };

        Collections.sort(countryList,byMediaProximidade);
        if(nCidades==listaCountries.size() || nCidades>countryList.size())
            return countryList;
        return  countryList.subList(0,nCidades);
    }

    /**
     * Cidades com p% utilizadores list.
     *
     * @param percentage the percentage
     * @return the list
     */
    public List<Country> cidadesComPUtilizadores(double percentage){
        List<Country> cl = new ArrayList<>();
        for(Country country : listaCountries){
            if(percentUtilizadoresPais(country)>=percentage){
                cl.add(country);
            }
        }
        return cl;
    }

    /**
     * Percentagem de utilizadores por pais float.
     *
     * @param country the country
     * @return the float
     */
    public float percentUtilizadoresPais(Country country){
        float total = 0;
        for(User userAux: listaUsers){
            if(userAux.getCity().equalsIgnoreCase(country.getCapital())){
                total++;
            }
        }
        return (total/listaUsers.size())*100;
    }

    /**
     * Gets lista users.
     *
     * @return the lista users
     */
    public List<User> getListaUsers() {
        return this.listaUsers;
    }

    /**
     * Get country by name country.
     *
     * @param name the name
     * @return the country
     */
    public Country getCountryByName(String name){
        for (Country countryTemP:listaCountries){
            if (countryTemP.getName().equals(name))
                return countryTemP;
        }
        return null;
    }

    /**
     * Gets lista countries.
     *
     * @return the lista countries
     */
    public List<Country> getListaCountries() {
        return this.listaCountries;
    }

    /**
     * Gets borders network.
     *
     * @return the borders network
     */
    public BordersNetwork getBordersNetwork() {
        return this.bordersNetwork;
    }

    /**
     * Gets relatioships network.
     *
     * @return the relatioships network
     */
    public RelatioshipsNetwork getRelatioshipsNetwork() {
        return this.relatioshipsNetwork;
    }

    /**
     * Get country by capital country.
     *
     * @param countryCapital the country capital
     * @return the country
     */
    public Country getCountryByCapital(String countryCapital){
        for (Country country : this.listaCountries){
            if(country.getCapital().equalsIgnoreCase(countryCapital)) return country;
        }
        return null;
    }

    /**
     * Get user by id user.
     *
     * @param userId the user id
     * @return the user
     */
    public User getUserById(String userId){
        for (User user : this.listaUsers){
            if(user.getUser().equalsIgnoreCase(userId)) return user;
        }
        return null;
    }

    /**
     * Get country by id country.
     *
     * @param countryId the country id
     * @return the country
     */
    public Country getCountryById(String countryId){
        for (Country country : this.listaCountries){
            if(country.getName().equalsIgnoreCase(countryId)) return country;
        }
        return null;
    }

    /**
     * Gets amigos populares.
     *
     * @param n the n
     * @return the amigos populares
     */
//2
    public List<User> getAmigosPopulares(int n) {
        HashMap<User, Integer> unsortedUser = new HashMap();
        HashMap<User, Integer> sortedUser;
        List<User> friendslist = null;
        int contador=0;

        //Cria um mapa de todos os utilizadores e a quantidade de amigos de cada um
        for (User user : listaUsers) {
            unsortedUser.put(user, relatioshipsNetwork.getGraphRelationships().inDegree(user));
        }

        //Ordena a lista e reduz-la para apenas os n utilizadores pedidos com mais amigos
        sortedUser = sortByValue(unsortedUser, n);

        //Cria uma lista com todos os amigos do utilizador mais popular e depois remove amigos dessa lista caso estes
        //não sejam amigos em comum com os outros n-1 utilizadores mais populares
        for (User user:sortedUser.keySet()){
            if (contador==0){
                friendslist=(ArrayList<User>) relatioshipsNetwork.getGraphRelationships().directConnections(user);
            }else{
                friendslist.retainAll((ArrayList<User>) relatioshipsNetwork.getGraphRelationships().directConnections(user));
            }
            contador++;

        }
        for (User user: friendslist)
            System.out.println(user.user);

        return friendslist;
    }

    /**
     * Sort by value hash map.
     *
     * @param hm the hm
     * @param n  the n
     * @return the hash map
     */
    public HashMap<User, Integer> sortByValue(HashMap<User, Integer> hm, int n) {
        List<Map.Entry<User, Integer>> list = new LinkedList<Map.Entry<User, Integer>>(hm.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<User, Integer>>() {
            public int compare(Map.Entry<User, Integer> o1, Map.Entry<User, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        HashMap<User, Integer> temp = new LinkedHashMap<User, Integer>();
        for (Map.Entry<User, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
            n -= 1;
            if (n == 0) {
                return temp;
            }
        }
        return temp;
    }

    /**
     * Amigos proximidades hash map.
     *
     * @param userNum     the user num
     * @param nFronteiras the n fronteiras
     * @return the hash map
     */
//4
    public HashMap<String, ArrayList<String>> amigosProximidades(String userNum,int nFronteiras){
        HashMap<String, ArrayList<String>> mapCidadesAmigos = new HashMap<>();
        ArrayList<Country> paisProx = new ArrayList<>();
        ArrayList<String> cidadeProx = new ArrayList<>();
        User user = null;
        Country pais=null;

        //retorna o utilizador atraves do seu numero
        for(User userTemp:listaUsers){
            if(userTemp.getUser().equals(userNum))
                user=userTemp;
        }

        //Obtem o pais do utilizador selecionado
        for(Country paisTemp:listaCountries){
            if(user.city.equals(paisTemp.getCapital()))
                pais=paisTemp;
        }

        paisProx.add(pais);
        cidadeProx.add(user.city);

        //Obtem os pais que fazem fronteira para cada pais na lista paisProx, cajo um dos paises fronteira nao esteja na lista
        //é adicionado, isto é feito nFronteiras vezes
        for (int i = 0; i < nFronteiras; i++) {
            ArrayList<Country> listPais= new ArrayList<>(paisProx);
            for(Country paisTemp:listPais){
                for (Edge paisesFronteira :bordersNetwork.getGraphBorders().outgoingEdges(paisTemp)){
                    Country paisFronteira = (Country) paisesFronteira.getVDest();
                    if(!paisProx.contains(paisFronteira)) {
                        paisProx.add(paisFronteira);
                        cidadeProx.add(paisFronteira.capital);
                    }
                }
            }
        }

        //preenche o mapa com as cidades nas proximidades
        for (String cidade:cidadeProx){
            mapCidadesAmigos.put(cidade,new ArrayList<String>());
        }

        //a cada cidade vai ser associada uma lista de amigos do utilizador nessa cidade
        for (User amigo:relatioshipsNetwork.getGraphRelationships().directConnections(user)){
            if(cidadeProx.contains(amigo.getCity())){
               mapCidadesAmigos.get(amigo.city).add(amigo.user);
            }
        }

        for (String cidade:mapCidadesAmigos.keySet()) {
            if (!mapCidadesAmigos.get(cidade).isEmpty()) {
                System.out.println("\n" + cidade + ":");
                for (String amigo : mapCidadesAmigos.get(cidade))
                    System.out.println(amigo);
            }
        }

        return mapCidadesAmigos;
    }

    /**
     * Caminho terrestre curto pair.
     *
     * @param u1s         the u 1 s
     * @param u2s         the u 2 s
     * @param intermedias the intermedias
     * @return the pair
     */
//6
    public Pair<ArrayList<Country>,Double> caminhoTerrestreCurto(String u1s, String u2s, int intermedias) {
        ArrayList<User> userList = new ArrayList<>();
        ArrayList<String> cityList = new ArrayList<>();
        ArrayList<Country> countryList = new ArrayList<>();
        //retorna o utilizador atraves do seu numero e adiciona-lo a userList e a sua cidade a cityList
        for (User userTemp : listaUsers) {
            if (userTemp.getUser().equals(u1s)) {
                userList.add(userTemp);
                cityList.add(userTemp.getCity());
            }

            if (userTemp.getUser().equals(u2s)) {
                userList.add(userTemp);
                cityList.add(userTemp.getCity());
            }
        }

        if (cityList.get(0).equals(cityList.get(1))){
            System.out.println("Utilizadores inválidos pois vivem na mesma cidade");
            return null;
        }

        //Para cada utilizador, vai adicionar à lista as n (n=intermedias) cidades onde esse utilizador tem mais amigos, cajo essa cidade não se encontre na lista
        for (User user : userList) {
            List<User> friendslist = (ArrayList<User>) relatioshipsNetwork.getGraphRelationships().directConnections(user);
            HashMap<String, Integer> unsortedCityMap = new HashMap<>();
            HashMap<String, Integer> sortedCityMap = new HashMap<>();
            //Conta o número de amigos em cada cidade
            for (User amigo : friendslist) {
                if (!unsortedCityMap.containsKey(amigo.getCity())) {
                    unsortedCityMap.put(amigo.getCity(), 1);
                } else {
                    unsortedCityMap.put(amigo.getCity(), unsortedCityMap.get(amigo.getCity()) + 1);
                }
            }
            //Ordena o mapa de cidade por ordem decrescente de amigos, preservando apenas as n (n=intermedias) cidades
            sortedCityMap=sortByValue2(unsortedCityMap, intermedias);
            //Adiciona as cidades à lista de cidades, cajo esta já nao se encontre na lista
            for(String cidade : sortedCityMap.keySet()){
                if (!cityList.contains(cidade))
                    cityList.add(cidade);
            }
        }

        for (String city:cityList){
            for (Country country:listaCountries){
                if(city.equals(country.capital))
                    countryList.add(country);
            }
        }

        //Lista de paises intermedios
        ArrayList<Country> checkpoints= new ArrayList<>(countryList);
        checkpoints.remove(0);
        checkpoints.remove(0);


        double distance = 0;
        ArrayList<Country> checkpointsorder = new ArrayList<>();
        ArrayList<Country> percurso = new ArrayList<>();
        checkpointsorder.add(countryList.get(0));
        int contador=0;

        while (!checkpointsorder.get(checkpointsorder.size()-1).equals(countryList.get(1))) {
            double checkpointDistance=0;
            Country nextCheckpoint=null;
            LinkedList<Country> percursoCheckpoint = new LinkedList<>();

            int contador2=0;
            for (Country checkpoint : checkpoints) {
                LinkedList<Country> percursoIntermedio = new LinkedList<>();
                Double PossibleCheckPointDistance=GraphAlgorithms.shortestPath(bordersNetwork.getGraphBorders(),checkpointsorder.get(contador),checkpoint,percursoIntermedio);
                if (contador2==0){
                    checkpointDistance=PossibleCheckPointDistance;
                    percursoCheckpoint=percursoIntermedio;
                    nextCheckpoint=checkpoint;
                }
                if (PossibleCheckPointDistance<checkpointDistance){
                    checkpointDistance=PossibleCheckPointDistance;
                    percursoCheckpoint=percursoIntermedio;
                    nextCheckpoint=checkpoint;
                }
                contador2++;
            }
            checkpoints.remove(nextCheckpoint);
            checkpointsorder.add(nextCheckpoint);
            if(contador!=0)
            percursoCheckpoint.remove(0);
            percurso.addAll(percursoCheckpoint);
            distance+=checkpointDistance;

            contador++;
            if (checkpoints.isEmpty()) {
                LinkedList<Country> percursoIntermedio = new LinkedList<>();
                Double finalDistance=GraphAlgorithms.shortestPath(bordersNetwork.getGraphBorders(),checkpointsorder.get(checkpointsorder.size()-1),countryList.get(1),percursoIntermedio);
                percursoIntermedio.remove(0);
                percurso.addAll(percursoIntermedio);
                distance+=finalDistance;
                checkpointsorder.add(countryList.get(1));
            }
        }
        System.out.printf("O percurso é: ");
        for (Country pais:percurso) {
            if (!pais.equals(percurso.get(percurso.size() - 1))) {
                System.out.printf("%s, ", pais.capital);
            } else {
                System.out.printf("%s", pais.capital);
            }
        }
        System.out.printf("\nA distancia é: %.2fkm",distance);

        return new Pair<>(percurso,distance);

    }

    /**
     * Sort by value 2 hash map.
     *
     * @param hm the hm
     * @param n  the n
     * @return the hash map
     */
    public HashMap<String, Integer> sortByValue2(HashMap<String, Integer> hm, int n) {
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
            n -= 1;
            if (n == 0) {
                return temp;
            }
        }
        return temp;
    }


}







