/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.List;
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
public class CountryTest {
    AnaliseDados test;
    
    public CountryTest() throws IOException {
        test = new AnaliseDados();
        test.lerFicheiros("small/susers.txt","small/scountries.txt",
                "small/srelationships.txt","small/sborders.txt");
    }

    /**
     * Test of getCentralidade method, of class Country.
     */
    @Test
    public void testGetCentralidade() {
        System.out.println("getCentralidade");
        Country instance = test.getListaCountries().get(0);
        test.centralidadeCountries();
        double expResult = 3147.42;
        double result = instance.getCentralidade();
        assertEquals(expResult, result, 1);
    }

    /**
     * Test of distanciaFrom method, of class Country.
     */
    @Test
    public void testDistanciaFrom() {
        System.out.println("distanciaFrom");
        Country instance = test.getListaCountries().get(0);
        Country country2 = test.getListaCountries().get(1);
        double expResult = 2236.88;
        double result = instance.distanciaFrom(country2);
        assertEquals(expResult, result, 1);
    }
    
}
