/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import com.sun.tools.javac.util.Pair;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.*;

import javafx.util.Pair;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tigas
 */
public class AnaliseDadosTest {
    AnaliseDados test;
    
    public AnaliseDadosTest() throws IOException, ParseException {
        test = new AnaliseDados();
        test.lerFicheiros("small/susers.txt","small/scountries.txt",
                "small/srelationships.txt","small/sborders.txt");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of lerFicheiros method, of class AnaliseDados.
     */
    @Test
    public void testLerFicheiros() throws Exception {
        System.out.println("lerFicheiros");
        String ficheiroUsers = "small/susers.txt";
        String ficheiroCoutries = "small/scountries.txt";
        String ficheiroRelationships = "small/srelationships.txt";
        String ficheiroBorders = "small/sborders.txt";
        AnaliseDados instance = new AnaliseDados();
        instance.lerFicheiros(ficheiroUsers, ficheiroCoutries, ficheiroRelationships, ficheiroBorders);

        int expResultUsers = 26;
        int resultUsers = instance.getListaUsers().size();
        assertEquals(expResultUsers, resultUsers);

        int expResultCountries = 13;
        int resultCountries = instance.getListaCountries().size();
        assertEquals(expResultCountries, resultCountries);

        int expResultRelationshipsVertex = 26;
        int resultRelashionshipsVertex = instance.getRelatioshipsNetwork().getGraphRelationships().numVertices();
        assertEquals(expResultRelationshipsVertex, resultRelashionshipsVertex);

        int expResultRelationshipsEdges = 45;
        int resultRelashionshipsEdges = instance.getRelatioshipsNetwork().getGraphRelationships().numEdges();
        assertEquals(expResultRelationshipsEdges, resultRelashionshipsEdges);

        int expResultBordersVertex = 13;
        int resultBordersVertex = instance.getBordersNetwork().getGraphBorders().numVertices();
        assertEquals(expResultBordersVertex, resultBordersVertex);

        int expResultBordersEdges = 50;
        int resultBordersEdges = instance.getBordersNetwork().getGraphBorders().numEdges();
        assertEquals(expResultBordersEdges, resultBordersEdges);
    }

    /**
     * Test of eConecta method, of class AnaliseDados.
     */
    @Test
    public void testEConecta() {
        System.out.println("eConecta");
        String result = test.eConecta();
        String expResult = String.format("A rede de amizades é conectada: %d ligações para conseguir contactar qualquer utilizador.\n",5);
        assertEquals(expResult, result);
    }

    /**
     * Test of cidadesMaiorCentralidadeComPUtilizadores method, of class AnaliseDados.
     */
    @Test
    public void testCidadesMaiorCentralidadeComPUtilizadores() {
        System.out.println("cidadesMaiorCentralidadeComPUtilizadores");
        List<Country> result = test.sortByMediaProximidade(5, 3);

        List<Country> expResult = new ArrayList<>();

        expResult.add(test.getCountryById("argentina"));
        expResult.add(test.getCountryById("bolivia"));
        expResult.add(test.getCountryById("brasil"));
        expResult.add(test.getCountryById("chile"));
        expResult.add(test.getCountryById("colombia"));

        assertEquals(expResult, result);
    }

    /**
     * Test of getAmigosPopulares method, of class AnaliseDados.
     */
    @Test
    public void testGetAmigosPopulares() {
        System.out.println("getAmigosPopulares()");
        List<User> result = test.getAmigosPopulares(2);
        List<User> expResult = new ArrayList<>();
        expResult.add(test.listaUsers.get(2));
        expResult.add(test.listaUsers.get(7));
        expResult.add(test.listaUsers.get(24));

        assertEquals(expResult, result);
    }

    @Test
    /**
     * Test of testAmigosProximidades method, of class AnaliseDados.
     */
    public void testAmigosProximidades() {
        System.out.println("amigosProximidades()");
        HashMap<String, ArrayList<String>> result = test.amigosProximidades("u32",2);
        HashMap<String, ArrayList<String>> expResult = new HashMap<>();
        ArrayList<String> t1= new ArrayList<>(Arrays.asList("u1","u33","u25"));
        ArrayList<String> t2= new ArrayList<>(Arrays.asList("u29"));
        ArrayList<String> t3= new ArrayList<>(Arrays.asList("u26"));
        expResult.put("lima",new ArrayList<String>());
        expResult.put("bogota",new ArrayList<String>());
        expResult.put("paramaribo",new ArrayList<String>());
        expResult.put("montevideu",new ArrayList<String>());
        expResult.put("lapaz",new ArrayList<String>());
        expResult.put("caracas",new ArrayList<String>());
        expResult.put("buenosaires",new ArrayList<String>());
        expResult.put("quito",new ArrayList<String>());
        expResult.put("assuncao",new ArrayList<String>());
        expResult.put("brasilia",t1);
        expResult.put("santiago",t2);
        expResult.put("caiena",new ArrayList<String>());
        expResult.put("georgetwon",t3);
        assertEquals(expResult, result);
    }

    @Test
    /**
     * Test of caminhoTerrestreCurto method, of class AnaliseDados.
     */
    public void testeCaminhoTerrestreCurto() {

        System.out.println("testeCaminhoTerrestreCurto()");
        ArrayList<Country> percurso = new ArrayList<>();
        Country pais1 = test.getCountryByName("brasil");
        Country pais2 = test.getCountryByName("suriname");
        Country pais3 = test.getCountryByName("guiana");
        Country pais4 = test.getCountryByName("venezuela");
        Country pais5 = test.getCountryByName("colombia");
        Country pais6 = test.getCountryByName("equador");
        percurso.add(pais1);
        percurso.add(pais2);
        percurso.add(pais3);
        percurso.add(pais4);
        percurso.add(pais5);
        percurso.add(pais6);
        double distance=5682.698253910819;
        Pair expResult= new Pair<>(percurso,distance);
        Pair result=test.caminhoTerrestreCurto("u1","u5",1);
        assertEquals(expResult, result);

    }
}
