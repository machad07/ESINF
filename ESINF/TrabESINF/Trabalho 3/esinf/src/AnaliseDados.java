import Element.*;
import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * The type Analise dados.
 */
public class AnaliseDados {
    /**
     * The Avl atomic number.
     */
    AVL<Element> avlAtomicNumber;
    /**
     * The Avl element.
     */
    AVL<Element> avlElement;
    /**
     * The Avl symbol.
     */
    AVL<Element> avlSymbol;
    /**
     * The Avl atomic mass.
     */
    AVL<Element> avlAtomicMass;
    /**
     * The Bst electron configuration.
     */
    BST<String> bstElectronConfiguration;

    /**
     * Instantiates a new Analise dados.
     */
    public AnaliseDados() {
        avlAtomicNumber = new AVL();
        avlElement = new AVL();
        avlSymbol = new AVL();
        avlAtomicMass = new AVL();
        bstElectronConfiguration = new BST<>();
    }

    /**
     * Read file.
     *
     * @param file the file
     * @throws IOException the io exception
     */
    public void readFile(String file) throws IOException {
        String linha;
        BufferedReader in = new BufferedReader(new FileReader(file));
        try {
            in.readLine();
            while ((linha = in.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 24) {
                    Element element = new Element_Comparable_AtomicNumber(toInteger(dados[0]), chekNull(dados[1]), chekNull(dados[2]), toFloat(dados[3]),
                            toFloat(dados[4]), toInteger(dados[5]), toInteger(dados[6]), chekNull(dados[7]), chekNull(dados[8]),
                            dados[9], toFloat(dados[10]), toFloat(dados[11]), toFloat(dados[12]), toFloat(dados[13]),
                            toFloat(dados[14]), toDouble(dados[15]), toDouble(dados[16]), toInteger(dados[17]), chekNull(dados[18]),
                            toInteger(dados[19]), toFloat(dados[20]), chekNull(dados[21]), toInteger(dados[22]), toInteger(dados[23]));
                    avlAtomicNumber.insert(element);

                    Element element1 = new Element_Comparable_Element(toInteger(dados[0]), chekNull(dados[1]), chekNull(dados[2]), toFloat(dados[3]),
                            toFloat(dados[4]), toInteger(dados[5]), toInteger(dados[6]), chekNull(dados[7]), chekNull(dados[8]),
                            dados[9], toFloat(dados[10]), toFloat(dados[11]), toFloat(dados[12]), toFloat(dados[13]),
                            toFloat(dados[14]), toDouble(dados[15]), toDouble(dados[16]), toInteger(dados[17]), chekNull(dados[18]),
                            toInteger(dados[19]), toFloat(dados[20]), chekNull(dados[21]), toInteger(dados[22]), toInteger(dados[23]));
                    avlElement.insert(element1);

                    Element element2 = new Element_Comparable_Symbol(toInteger(dados[0]), chekNull(dados[1]), chekNull(dados[2]), toFloat(dados[3]),
                            toFloat(dados[4]), toInteger(dados[5]), toInteger(dados[6]), chekNull(dados[7]), chekNull(dados[8]),
                            dados[9], toFloat(dados[10]), toFloat(dados[11]), toFloat(dados[12]), toFloat(dados[13]),
                            toFloat(dados[14]), toDouble(dados[15]), toDouble(dados[16]), toInteger(dados[17]), chekNull(dados[18]),
                            toInteger(dados[19]), toFloat(dados[20]), chekNull(dados[21]), toInteger(dados[22]), toInteger(dados[23]));
                    avlSymbol.insert(element2);

                    Element element3 = new Element_Comparable_AtomicMass(toInteger(dados[0]), chekNull(dados[1]), chekNull(dados[2]), toFloat(dados[3]),
                            toFloat(dados[4]), toInteger(dados[5]), toInteger(dados[6]), chekNull(dados[7]), chekNull(dados[8]),
                            dados[9], toFloat(dados[10]), toFloat(dados[11]), toFloat(dados[12]), toFloat(dados[13]),
                            toFloat(dados[14]), toDouble(dados[15]), toDouble(dados[16]), toInteger(dados[17]), chekNull(dados[18]),
                            toInteger(dados[19]), toFloat(dados[20]), chekNull(dados[21]), toInteger(dados[22]), toInteger(dados[23]));
                    avlAtomicMass.insert(element3);
                    bstElectronConfiguration.insert(chekNull(dados[21]));
                } else {
                    throw new IllegalArgumentException("Something went wrong, please restart the program.");
                }
            }
        } finally {
            in.close();
        }
    }

    /**
     * Print um b.
     *
     * @param atomicMassMin the atomic mass min
     * @param atomicMassMax the atomic mass max
     */
    public void printUmB(float atomicMassMin, float atomicMassMax) {
        System.out.printf("|=====================================================================================================================================================================|\n");

        System.out.printf("| %-15s| %-15s| %-15s| %-15s| %-15s| %-25s| %-30s| %-20s|\n", "Atomic Number", "Element", "Symbol",
                "Atomic Mass", "Phase", "Type", "Discoverer", "Year of Discovery");
        System.out.printf("|================|================|================|================|================|==========================|===============================|=====================|\n");
        Map<String, Map<String, Integer>> map = new TreeMap<>();
        for (Element element : sortElementsBetween(atomicMassMin, atomicMassMax, map)) {
            System.out.printf("| %-15d| %-15s| %-15s| %-15f| %-15s| %-25s| %-30s| %-20s|\n",
                    element.getAtomicNumber(), element.getElement(), element.getSymbol(), element.getAtomicMass(),
                    element.getPhase(), element.getType(), element.getDiscoverer() != null ? element.getDiscoverer() : "",
                    (element.getYearOfDiscovery() != 0 ? element.getYearOfDiscovery() : ""));
        }


        System.out.printf("\n                           |====================================================================================|\n");
        System.out.printf(" %-26s| %-15s| %-15s| %-15s| %-15s| %-15s|\n",
                "", "artificial", "gas", "liq", "solid", "TOTAL");
        System.out.printf("|==========================|================|================|================|================|================|\n");

        for (String type : map.keySet()) {
            System.out.printf("| %-25s| %-15s| %-15s| %-15s| %-15s| %-15s|\n", type.isEmpty() ? "Without Type" : type, map.get(type).get("artificial")
                    , map.get(type).get("gas"), map.get(type).get("liq"), map.get(type).get("solid"),
                    (map.get(type).get("artificial") + map.get(type).get("gas")
                            + map.get(type).get("liq") + map.get(type).get("solid")));
        }
    }

    /**
     * Sort elements between list.
     *
     * @param atomicMassMin the atomic mass min
     * @param atomicMassMax the atomic mass max
     * @param map           the map
     * @return the list
     */
    public List<Element> sortElementsBetween(float atomicMassMin, float atomicMassMax, Map<String, Map<String, Integer>> map) {
        List<Element> countryList = getElementsBetween(atomicMassMin, atomicMassMax, map);

        Comparator<Element> byDiscovererAndYearOfDiscovery = new Comparator<>() {
            @Override
            public int compare(Element o1, Element o2) {
                if (o1.getDiscoverer() == null)
                    return 1;

                if (o2.getDiscoverer() == null)
                    return -1;

                if (o1.getDiscoverer().compareTo(o2.getDiscoverer()) == 0) {
                    if (o2.getYearOfDiscovery() != o1.getYearOfDiscovery()) {
                        return o2.getYearOfDiscovery() - o1.getYearOfDiscovery();
                    } else {
                        return Float.compare(o1.getAtomicMass(), o2.getAtomicMass());
                    }
                }

                if (Character.isUpperCase(o1.getDiscoverer().charAt(0)) && Character.isUpperCase(o2.getDiscoverer().charAt(0))) {
                    return o1.getDiscoverer().compareTo(o2.getDiscoverer());
                } else if (Character.isLowerCase(o1.getDiscoverer().charAt(0)) && Character.isLowerCase(o2.getDiscoverer().charAt(0))) {
                    return o1.getDiscoverer().compareTo(o2.getDiscoverer());
                } else if (Character.isLowerCase(o1.getDiscoverer().charAt(0)) && Character.isUpperCase(o2.getDiscoverer().charAt(0))) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };

        Collections.sort(countryList, byDiscovererAndYearOfDiscovery);
        return countryList;
    }

    /**
     * Gets elements between.
     *
     * @param atomicMassMin the atomic mass min
     * @param atomicMassMax the atomic mass max
     * @param map           the map
     * @return the elements between
     */
    public List getElementsBetween(float atomicMassMin, float atomicMassMax, Map<String, Map<String, Integer>> map) {
        List<Object> list = new LinkedList<>();
        Map<String, Integer> data;

        if (avlAtomicMass.root() == null) {
            return null;
        }

        Queue<BST.Node> queue = new LinkedList<>();
        queue.add(avlAtomicMass.root());

        BST.Node<Element> curr = null;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size > 0) {
                size--;
                curr = queue.poll();

                if (curr.getElement().getAtomicMass() >= atomicMassMin && curr.getElement().getAtomicMass() <= atomicMassMax) {
                    list.add(curr.getElement());
                    if (map.get(curr.getElement().getType()) == null) {
                        data = new TreeMap<>();
                        data.put("artificial", 0);
                        data.put("gas", 0);
                        data.put("liq", 0);
                        data.put("solid", 0);
                    } else {
                        data = map.get(curr.getElement().getType());
                    }
                    data.put(curr.getElement().getPhase(), data.get(curr.getElement().getPhase()) + 1);
                    map.put(curr.getElement().getType(), data);
                }

                if (curr.getLeft() != null && (curr.getLeft().getElement().getAtomicMass() >= atomicMassMin ||
                        curr.getLeft().getElement().getAtomicMass() <= atomicMassMax)) {
                    queue.add(curr.getLeft());
                }

                if (curr.getRight() != null && (curr.getRight().getElement().getAtomicMass() >= atomicMassMin ||
                        curr.getRight().getElement().getAtomicMass() <= atomicMassMax)) {
                    queue.add(curr.getRight());
                }

            }
        }
        return list;
    }

    /**
     * Gets element by atomic number.
     *
     * @param atomicNumber the atomic number
     * @return the element by atomic number
     */
    public Element_Comparable_AtomicNumber getElementByAtomicNumber(int atomicNumber) {
        Element p = new Element_Comparable_AtomicNumber(atomicNumber);
        BST.Node<Element> node = avlAtomicNumber.find(avlAtomicNumber.root(), p);
        if (node != null)
            return (Element_Comparable_AtomicNumber) node.getElement();
        return null;
    }

    /**
     * Gets element by element.
     *
     * @param Element the element
     * @return the element by element
     */
    public Element_Comparable_Element getElementByElement(String Element) {
        Element p = new Element_Comparable_Element(Element);
        BST.Node<Element> node = avlElement.find(avlElement.root(), p);
        if (node != null)
            return (Element_Comparable_Element) node.getElement();
        return null;
    }

    /**
     * Gets element by atomic mass.
     *
     * @param atomicMass the atomic mass
     * @return the element by atomic mass
     */
    public Element_Comparable_AtomicMass getElementByAtomicMass(float atomicMass) {
        Element p = new Element_Comparable_AtomicMass(atomicMass);
        BST.Node<Element> node = avlAtomicMass.find(avlAtomicMass.root(), p);
        if (node != null)
            return (Element_Comparable_AtomicMass) node.getElement();
        return null;
    }

    /**
     * Gets element by symbol.
     *
     * @param symbol the symbol
     * @return the element by symbol
     */
    public Element_Comparable_Symbol getElementBySymbol(String symbol) {
        Element p = new Element_Comparable_Symbol(symbol);
        BST.Node<Element> node = avlSymbol.find(avlSymbol.root(), p);
        if (node != null)
            return (Element_Comparable_Symbol) node.getElement();
        return null;
    }

    /**
     * Gets electron configuration count.
     *
     * @return the electron configuration count
     */
    public TreeMap<Integer, LinkedList<String>> getElectronConfigurationCount() {
        TreeMap<String, Integer> configurationCount = new TreeMap<>();
        TreeMap<Integer, LinkedList<String>> totalCount = new TreeMap<>();

        for (String config : bstElectronConfiguration.inOrder()) {
            String[] dados = config.split(" ");
            String configuration = dados[0];
            addRepetition(configuration, configurationCount, totalCount);
            for (int i = 1; i < dados.length; i++) {
                configuration = configuration + " " + dados[i];
                addRepetition(configuration, configurationCount, totalCount);
            }

        }
        return totalCount;
    }

    /**
     * Add repetition.
     *
     * @param config      the config
     * @param configCount the config count
     * @param totalCount  the total count
     */
    public void addRepetition(String config, TreeMap<String, Integer> configCount, TreeMap<Integer, LinkedList<String>> totalCount) {
        if (configCount.get(config) == null) {
            configCount.put(config, 1);
            LinkedList a = totalCount.get(1);
            if (a == null)
                a = new LinkedList();
            a.add(config);
            totalCount.put(1, a);
        } else {
            int count = configCount.get(config) + 1;
            configCount.put(config, count);
            if (totalCount.containsKey(count - 1)) {
                totalCount.get(count - 1).remove(config);


                if (totalCount.get(count - 1).size() == 0)
                    totalCount.remove(count - 1);

                LinkedList aux = totalCount.get(count);
                if (aux == null)
                    aux = new LinkedList();
                aux.add(config);
                totalCount.put(count, aux);
            }
        }
    }

    /**
     * Print dois a.
     */
    public void printDoisA() {
        TreeMap<Integer, LinkedList<String>> map = getElectronConfigurationCount();
        map.remove(1);
        for (Integer configurationCount : map.descendingKeySet()) {
            System.out.printf("%3d %-30s\n", configurationCount, map.get(configurationCount));
        }
    }

    /**
     * Avl decr avl.
     *
     * @return the avl
     */
//2.B
    public AVL<String> avlDecr() {
        AVL<String> avl = new AVL<>();
        Map<Integer, LinkedList<String>> totalCount = getElectronConfigurationCount().descendingMap();
        for (Integer i : totalCount.keySet()) {
            if (i > 2) {
                List<String> list = totalCount.get(i);
                for (String ce : list) {
                    avl.insert(ce);
                }
            }
        }
        return avl;
    }


    private int max;

    /**
     * Find longest path string.
     *
     * @return the string
     */
//2.C
    public String findLongestPath() {
        AVL<String> avl = avlDecr();
        ArrayList<String> listleft = longestPath(avl.root.getLeft());
        ArrayList<String> listright = longestPath(avl.root.getRight());
        int size = listright.size() + listleft.size();
        return "D(" + listleft.get(0) + "," + listright.get(0) + ") = " + size;
    }

    /**
     * Longest path array list.
     *
     * @param root the root
     * @return the array list
     */
    public ArrayList<String> longestPath(AVL.Node<String> root) {

        //Se a raiz for nula significa que não há árvore binária, então retorna um vetor vazio
        if (root == null) {
            ArrayList<String> output = new ArrayList<>();
            return output;
        }

        // chamada recursiva no root.right
        ArrayList<String> right = longestPath(root.getRight());

        // chamada recursiva no root.left
        ArrayList<String> left = longestPath(root.getLeft());

        //Compara o tamanho dos dois ArrayList e insere o nó atual
        if (right.size() < left.size()) {
            left.add(root.getElement());
        } else {
            right.add(root.getElement());
        }

        // Return ArrayList
        return (left.size() >
                right.size() ? left : right);
    }

    /**
     * Complete binary tree map.
     *
     * @return the map
     */
//2.D
    public Map<Integer, List<String>> completeBinaryTree() {
        AVL<String> avl = avlDecr();
        //Lista de elementos únicos
        List<String> listUnique = new ArrayList<>();
        //Lista de elemntos repetidos
        List<String> listElementRepetidos = getElementList(listUnique);

        //Obtem um mapa de todos os elementos por nível. em que a key é o nível e a lista dos elementos é o value
        Map<Integer, List<String>> elementsPerLevel = avl.nodesByLevel();

        int numLevels = elementsPerLevel.size();

        if (isCompleteBT(avl.root)) {
            System.out.println(avl);
            return elementsPerLevel;
        }

        for (String s1 : elementsPerLevel.get(numLevels - 3)) {
            BST.Node<String> node = avl.find(avl.root, s1);
            if (node.getLeft() == null) {
                BST.Node<String> node1 = new BST.Node<>(getUniqueElement(listUnique, listElementRepetidos, node, true), null, null);
                node.setLeft(node1);
                elementsPerLevel.get(numLevels - 2).add(node1.getElement());
            }
            if (node.getRight() == null) {
                BST.Node<String> node1 = new BST.Node<>(getUniqueElement(listUnique, listElementRepetidos, node, false), null, null);
                node.setRight(node1);
                elementsPerLevel.get(numLevels - 2).add(node1.getElement());
            }
        }

        for (String s2 : elementsPerLevel.get(numLevels - 2)) {
            if (isCompleteBT(avl.root)) {
                System.out.println(avl);
                return elementsPerLevel;
            }
            BST.Node<String> node = avl.find(avl.root, s2);
            if (node.getLeft() == null) {
                BST.Node<String> node1 = new BST.Node<>(getUniqueElement(listUnique, listElementRepetidos, node, true), null, null);
                node.setLeft(node1);
                elementsPerLevel.get(numLevels - 1).add(node1.getElement());
            }

            if (node.getRight() == null) {
                BST.Node<String> node1 = new BST.Node<>(getUniqueElement(listUnique, listElementRepetidos, node, false), null, null);
                node.setRight(node1);
                elementsPerLevel.get(numLevels - 1).add(node1.getElement());
            }

        }
        System.out.println(avl);
        return elementsPerLevel;
    }

    /**
     * Gets unique element.
     *
     * @param listUnique           the list unique
     * @param listElementRepetidos the list element repetidos
     * @param node                 the node
     * @param tf                   the tf
     * @return the unique element
     */
    public String getUniqueElement(List<String> listUnique, List<String> listElementRepetidos, AVL.Node<String> node, boolean tf) {
        for (String s : listUnique) {
            if (s.compareTo(node.getElement()) < 0 && tf) {
                listElementRepetidos.add(s);
                listUnique.remove(s);
                return s;
            }
            if (s.compareTo(node.getElement()) > 0 && !tf) {
                listElementRepetidos.add(s);
                listUnique.remove(s);
                return s;
            }
        }
        return null;
    }

    /**
     * Gets element list.
     *
     * @param listUnique the list unique
     * @return the element list
     */
    public ArrayList<String> getElementList(List<String> listUnique) {
        TreeMap<Integer, LinkedList<String>> treeMap = getElectronConfigurationCount();
        ArrayList<String> list = new ArrayList<>();
        for (Integer i : treeMap.keySet()) {
            if (i > 1)
                list.addAll(treeMap.get(i));
        }
        listUnique.addAll(treeMap.get(1));
        return list;
    }

    /**
     * Is complete bt boolean.
     *
     * @param root the root
     * @return the boolean
     */
    public static boolean isCompleteBT(BST.Node root) {
        if (root == null)
            return true;

        Queue<BST.Node> queue = new LinkedList<>();

        boolean flag = false;

        queue.add(root);
        while (!queue.isEmpty()) {
            BST.Node temp_node = queue.remove();

            if (temp_node.getLeft() != null) {
                if (flag == true)
                    return false;

                queue.add(temp_node.getLeft());
            } else
                flag = true;

            if (temp_node.getRight() != null) {
                if (flag == true)
                    return false;

                queue.add(temp_node.getRight());

            } else
                flag = true;
        }
        return true;
    }


    /**
     * To integer int.
     *
     * @param a the a
     * @return the int
     */
    public int toInteger(String a) {
        if (a.isEmpty())
            return 0;
        return Integer.parseInt(a.trim());
    }

    /**
     * To float float.
     *
     * @param a the a
     * @return the float
     */
    public float toFloat(String a) {
        if (a.isEmpty())
            return 0;
        return Float.parseFloat(a.trim());
    }

    /**
     * To double double.
     *
     * @param a the a
     * @return the double
     */
    public double toDouble(String a) {
        if (a.isEmpty())
            return 0;
        return Double.parseDouble(a.trim());
    }

    /**
     * Chek null string.
     *
     * @param a the a
     * @return the string
     */
    public String chekNull(String a) {
        if (a.isEmpty())
            return null;
        return a.trim();
    }

    /**
     * Gets avl atomic number.
     *
     * @return the avl atomic number
     */
    public AVL getAvlAtomicNumber() {
        return avlAtomicNumber;
    }

    /**
     * Gets avl element.
     *
     * @return the avl element
     */
    public AVL getAvlElement() {
        return avlElement;
    }

    /**
     * Gets avl symbol.
     *
     * @return the avl symbol
     */
    public AVL getAvlSymbol() {
        return avlSymbol;
    }

    /**
     * Gets avl atomic mass.
     *
     * @return the avl atomic mass
     */
    public AVL getAvlAtomicMass() {
        return avlAtomicMass;
    }

    /**
     * Gets bst electron configuration.
     *
     * @return the bst electron configuration
     */
    public BST<String> getBstElectronConfiguration() {
        return bstElectronConfiguration;
    }
}
