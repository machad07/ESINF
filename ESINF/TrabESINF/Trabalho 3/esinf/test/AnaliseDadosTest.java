/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Element.Element;
import Element.Element_Comparable_AtomicMass;
import Element.Element_Comparable_AtomicNumber;
import Element.Element_Comparable_Element;
import Element.Element_Comparable_Symbol;

import java.io.IOException;
import java.util.*;

import org.junit.*;

import static org.junit.Assert.*;

/**
 *
 * @author tigas
 */
public class AnaliseDadosTest {
    AnaliseDados test;
    
    public AnaliseDadosTest() throws IOException {
        test = new AnaliseDados();
        test.readFile("Periodic Table of Elements.csv");
    }

    /**
     * Test of readFile method, of class ReadPeriodicTable.
     */
    @Test
    public void testReadFile() throws Exception {
        AnaliseDados instance = new AnaliseDados();
        instance.readFile("Periodic Table of Elements.csv");

        int expResultAvlAtomicMass = 118;
        int resultAvlAtomicMass = instance.getAvlAtomicMass().size();
        assertEquals(expResultAvlAtomicMass,resultAvlAtomicMass);

        int expResultAvlElement = 118;
        int resultAvlElement = instance.getAvlElement().size();
        assertEquals(expResultAvlElement,resultAvlElement);

        int expResultAvlSymbol = 118;
        int resultAvlSymbol = instance.getAvlSymbol().size();
        assertEquals(expResultAvlSymbol,resultAvlSymbol);

        int expResultAvlAtomicNumber = 118;
        int resultAvlAtomicNumber = instance.getAvlAtomicNumber().size();
        assertEquals(expResultAvlAtomicNumber,resultAvlAtomicNumber);

        int expResultBstElectronConfiguration = 95;
        int resultBstElectronConfiguration = instance.getBstElectronConfiguration().size();
        assertEquals(expResultBstElectronConfiguration,resultBstElectronConfiguration);
    }

    /**
     * Test of sort method, of class ReadPeriodicTable.
     */
    @Test
    public void testSortElementsBetween() {
        float atomicMassMin = 20;
        float atomicMassMax = 65;
        List<Element> expResult = new LinkedList<>();
        int[] dados = {23,14,12,15,27,28,20,11,19,25,22,21,16,26,29,10,18,17,24,13};
        for (int i=0; i<20;i++)
        expResult.add(test.getElementByAtomicNumber(dados[i]));

        Map<String,Map<String, Integer>> map = new TreeMap<>();
        List<Element> result = test.sortElementsBetween(atomicMassMin, atomicMassMax, map);
         assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of getElementByAtomicNumber method, of class ReadPeriodicTable.
     */
    @Test
    public void testGetElementByAtomicNumber() {
        Element expResult = new Element_Comparable_AtomicNumber(1,
                "Hydrogen","H",1.00794F,1.008F,1,1,"gas"
                ,null,"Nonmetal", 0.012F,0.79F,2.2F,
                13.5984F,0.00008988F, 14.175, 20.28,3,"Cavendish",
                1766, 14.304F, "1s1",1,1);
        Element_Comparable_AtomicNumber result = test.getElementByAtomicNumber(1);
        assertEquals(expResult,result);
    }

    /**
     * Test of getElementByElement method, of class ReadPeriodicTable.
     */
    @Test
    public void testGetElementByElement() {
        Element expResult = new Element_Comparable_Element(1,
                "Hydrogen","H",1.00794F,1.008F,1,1,"gas"
                ,null,"Nonmetal", 0.012F,0.79F,2.2F,
                13.5984F,0.00008988F, 14.175, 20.28,3,"Cavendish",
                1766, 14.304F, "1s1",1,1);
        Element_Comparable_Element result = test.getElementByElement("Hydrogen");
        assertEquals(expResult,result);
    }

    /**
     * Test of getElementByAtomicMass method, of class ReadPeriodicTable.
     */
    @Test
    public void testGetElementByAtomicMass() {
        Element expResult = new Element_Comparable_AtomicMass(1,
                "Hydrogen","H",1.00794F,1.008F,1,1,"gas"
                ,null,"Nonmetal", 0.012F,0.79F,2.2F,
                13.5984F,0.00008988F, 14.175, 20.28,3,"Cavendish",
                1766, 14.304F, "1s1",1,1);
        Element_Comparable_AtomicMass result = test.getElementByAtomicMass(1.008F);
        assertEquals(expResult,result);
    }

    /**
     * Test of getElementBySymbol method, of class ReadPeriodicTable.
     */
    @Test
    public void testGetElementBySymbol() {
        Element expResult = new Element_Comparable_Symbol(1,
                "Hydrogen","H",1.00794F,1.008F,1,1,"gas"
                ,null,"Nonmetal", 0.012F,0.79F,2.2F,
                13.5984F,0.00008988F, 14.175, 20.28,3,"Cavendish",
                1766, 14.304F, "1s1",1,1);
        Element_Comparable_Symbol result = test.getElementBySymbol("H");
        assertEquals(expResult,result);
    }

    /**
     * Test of getElectronConfigurationCount method, of class ReadPeriodicTable.
     */
    @Test
    public void testGetElectronConfigurationCount() {
        TreeMap<Integer, LinkedList> expResult = new TreeMap<>();
        LinkedList dados = new LinkedList();
        dados.add("[Xe]");
        expResult.put(32,dados);

        dados = new LinkedList();
        dados.add("[Ar]");
        dados.add("[Kr]");
        expResult.put(18,dados);

        dados = new LinkedList();
        dados.add("[Xe] 4f14");
        expResult.put(17,dados);

        dados = new LinkedList();
        dados.add("[Kr] 4d10");
        dados.add("[Rn]");
        expResult.put(9,dados);

        dados = new LinkedList();
        dados.add("[Ar] 3d10");
        dados.add("[He]");
        dados.add("[Ne]");
        dados.add("[Xe] 4f14 5d10");
        expResult.put(8,dados);

        dados = new LinkedList();
        dados.add("[Ar] 3d10 4s2");
        dados.add("[He] 2s2");
        dados.add("[Kr] 4d10 5s2");
        dados.add("[Ne] 3s2");
        dados.add("[Xe] 4f14 5d10 6s2");
        expResult.put(7,dados);

        dados = new LinkedList();
        dados.add("[Ar] 3d5");
        dados.add("[Kr] 4d5");
        dados.add("[Xe] 4f7");
        expResult.put(2,dados);

        TreeMap<Integer, LinkedList<String>> result = test.getElectronConfigurationCount();
        result.remove(1);
        result.descendingMap();
        assertEquals(expResult, result);
    }

    /**
     * Test of findLongestPath method, of class ReadPeriodicTable.
     */
    @Test
    public void testFindLongestPath() {
        String expected = "D([He] 2s2,[Ne] 3s2) = 7";
        assertEquals(expected,test.findLongestPath());
    }

    /**
     * Test of completeBinaryTree method, of class ReadPeriodicTable.
     */
    @Test
    public void testCompleteBinaryTree() {
        LinkedHashMap<Integer,LinkedList<String>> expected = new LinkedHashMap<>();
        LinkedList<String> toAdd = new LinkedList<>();
        LinkedList<String> toAdd1 = new LinkedList<>();
        LinkedList<String> toAdd2 = new LinkedList<>();
        LinkedList<String> toAdd3 = new LinkedList<>();
        LinkedList<String> toAdd4 = new LinkedList<>();
        toAdd.add("[Kr] 4d10");
        expected.put(0,toAdd);
        toAdd1.add("[He]");
        toAdd1.add("[Xe]");
        expected.put(1,toAdd1);
        toAdd2.add("[Ar] 3d10");
        toAdd2.add("[Kr]");
        toAdd2.add("[Ne]");
        toAdd2.add("[Xe] 4f14 5d10");
        expected.put(2,toAdd2);
        toAdd3.add("[Ar]");
        toAdd3.add("[Ar] 3d10 4s2");
        toAdd3.add("[He] 2s2");
        toAdd3.add("[Kr] 4d10 5s2");
        toAdd3.add("[Rn]");
        toAdd3.add("[Xe] 4f14");
        toAdd3.add("[Xe] 4f14 5d10 6s2");
        toAdd3.add("[Kr] 4d1");
        expected.put(3,toAdd3);
        toAdd4.add("[Ne] 3s2");
        toAdd4.add("1s1");
        toAdd4.add("[Ar] 3d1");
        toAdd4.add("1s2");
        toAdd4.add("[Ar] 3d10 4s2 4p1");
        toAdd4.add("[Ar] 3d1 4s2");
        toAdd4.add("[He] 2s2 2p1");
        toAdd4.add("[Ar] 3d10 4s1");
        toAdd4.add("[Kr] 4d10 5s2 5p1");
        toAdd4.add("[Rn] 5f2");
        toAdd4.add("[Ar] 3d10 4s2 4p2");
        toAdd4.add("[Xe] 4f14 5d1");
        toAdd4.add("[Ar] 3d10 4s2 4p3");
        toAdd4.add("[Xe] 4f14 5d10 6s2 6p1");
        toAdd4.add("[Ar] 3d10 4s2 4p4");
        toAdd4.add("[Kr] 4d1 5s2");
        expected.put(4,toAdd4);
        assertEquals(expected,test.completeBinaryTree());

    }

}
