import java.util.*;

public class Recurso19_1 {
    public static void main(String[] args) {

        List<String> nomes = new LinkedList<>();
        nomes.add("Bob");
        nomes.add("Mary");
        nomes.add("Steve");
        nomes.add("Derek");
        nomes.add("Mary");
        nomes.add("Derek");
        nomes.add("Joe");
        nomes.add("Derek");
        nomes.add("Nicole");
        nomes.add("Mary");

        List<String> apelidos = new LinkedList<>();
        apelidos.add("Jones");
        apelidos.add("Ford");
        apelidos.add("Akers");
        apelidos.add("Smith");
        apelidos.add("Giles");
        apelidos.add("Smith");
        apelidos.add("Caiu");
        apelidos.add("Jones");
        apelidos.add("Jones");
        apelidos.add("Stepp");

        System.out.println(commonFirstName(nomes,apelidos));

    }

    public static String commonFirstName(List<String> names, List<String> nicknames) {
        HashMap<String, Set<String>> map = new HashMap<>();
        for (int i = 0; i < names.size(); i++) {
            if (map.containsKey(names.get(i))) {
                map.get(names.get(i)).add(nicknames.get(i));
            } else {
                map.put(names.get(i), new HashSet<>());
                map.get(names.get(i)).add(nicknames.get(i));
            }
        }
        int max = 0;
        String toReturn = "null";
        for (String name : map.keySet()) {
            if (map.get(name).size() > max) {
                max = map.get(name).size();
                toReturn = name;
            }
        }
        System.out.println("Ocurrencias: "+max);
        return "Nome: " + toReturn;
    }
}
