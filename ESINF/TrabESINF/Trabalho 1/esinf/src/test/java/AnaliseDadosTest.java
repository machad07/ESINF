import org.junit.Assert;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class AnaliseDadosTest {
    AnaliseDados test;

    public AnaliseDadosTest() throws IOException, ParseException {
        test = new AnaliseDados("testes.csv");
    }

    @org.junit.jupiter.api.Test
    public void novosCasosMortesPorContinenteMes(){
        TreeMap<String, TreeMap<Integer, ArrayList<Integer>>> expResult = new TreeMap<>();
        //expResult.put("Africa",new TreeMap<>());
        expResult.put("Asia",new TreeMap<>());
        expResult.put("Europe",new TreeMap<>());
        //expResult.put("North America",new TreeMap<>());
        //expResult.put("Oceania",new TreeMap<>());
        expResult.put("South America",new TreeMap<>());



        ArrayList a1=new ArrayList();
        a1.add(0);
        a1.add(0);
        ArrayList a2=new ArrayList();
        a2.add(38);
        a2.add(0);
        ArrayList a3=new ArrayList();
        a3.add(477);
        a3.add(4);
        ArrayList a4=new ArrayList();
        a4.add(2406);
        a4.add(4);
        ArrayList a5=new ArrayList();
        a5.add(7872);
        a5.add(9);
        ArrayList a6=new ArrayList();
        a6.add(15446);
        a6.add(67);
        ArrayList a7=new ArrayList();
        a7.add(14516);
        a7.add(62);
        ArrayList a8=new ArrayList();
        a8.add(10819);
        a8.add(43);
        ArrayList a9=new ArrayList();
        a9.add(18274);
        a9.add(56);

        ArrayList l1=new ArrayList();
        l1.add(0);
        l1.add(0);
        ArrayList l2=new ArrayList();
        l2.add(950);
        l2.add(24);
        ArrayList l3=new ArrayList();
        l3.add(32981);
        l3.add(919);
        ArrayList l4=new ArrayList();
        l4.add(121740);
        l4.add(3428);
        ArrayList l5=new ArrayList();
        l5.add(126694);
        l5.add(5133);
        ArrayList l6=new ArrayList();
        l6.add(125127);
        l6.add(9517);
        ArrayList l7=new ArrayList();
        l7.add(239674);
        l7.add(9767);
        ArrayList l8=new ArrayList();
        l8.add(161548);
        l8.add(3536);


        ArrayList E1=new ArrayList();
        E1.add(0);
        E1.add(0);
        ArrayList E2=new ArrayList();
        E2.add(12);
        E2.add(0);
        ArrayList E3=new ArrayList();
        E3.add(10396);
        E3.add(114);
        ArrayList E4=new ArrayList();
        E4.add(7018);
        E4.add(533);
        ArrayList E5=new ArrayList();
        E5.add(1458);
        E5.add(124);
        ArrayList E6=new ArrayList();
        E6.add(1507);
        E6.add(39);
        ArrayList E7=new ArrayList();
        E7.add(5689);
        E7.add(52);
        ArrayList E8=new ArrayList();
        E8.add(11261);
        E8.add(55);
        ArrayList E9=new ArrayList();
        E9.add(22789);
        E9.add(145);



        expResult.get("Asia").put(0,a1);
        expResult.get("Asia").put(1,a2);
        expResult.get("Asia").put(2,a3);
        expResult.get("Asia").put(3,a4);
        expResult.get("Asia").put(4,a5);
        expResult.get("Asia").put(5,a6);
        expResult.get("Asia").put(6,a7);
        expResult.get("Asia").put(7,a8);
        expResult.get("Asia").put(8,a9);


        expResult.get("South America").put(1,l1);
        expResult.get("South America").put(2,l2);
        expResult.get("South America").put(3,l3);
        expResult.get("South America").put(4,l4);
        expResult.get("South America").put(5,l5);
        expResult.get("South America").put(6,l6);
        expResult.get("South America").put(7,l7);
        expResult.get("South America").put(8,l8);

        expResult.get("Europe").put(0,E1);
        expResult.get("Europe").put(1,E2);
        expResult.get("Europe").put(2,E3);
        expResult.get("Europe").put(3,E4);
        expResult.get("Europe").put(4,E5);
        expResult.get("Europe").put(5,E6);
        expResult.get("Europe").put(6,E7);
        expResult.get("Europe").put(7,E8);
        expResult.get("Europe").put(8,E9);

        TreeMap<String, TreeMap<Integer, ArrayList<Integer>>> result =test.novosCasosMortesPorContinenteMes();
        Assert.assertEquals(result,expResult);
    }

    @org.junit.jupiter.api.Test
    void numMinDias() throws ParseException {
        HashMap<Pais, ArrayList<Integer>> expResult = new HashMap();
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(68);
        l1.add(126);
        Pais pais1 = new Pais("PER","South America","Peru",32971846,(float)7.151,(float)85.755,(float)5.95,(float)4.8,(float)0,(float)1.6,(float)76.74);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(238);
        l2.add(238);
        Pais pais2 = new Pais("BHR","Asia","Bahrain",1701583,(float)2.372,(float)151.689,(float)16.52,(float)5.8,(float)37.6,(float)2,(float)77.29);
        expResult.put(pais1,l1);
        expResult.put(pais2,l2);
        HashMap<Pais, ArrayList<Integer>> result = test.numMinDias();
        Assert.assertEquals(result,expResult);
    }

    @org.junit.jupiter.api.Test
    void casosPositivosNumContinente() {
        HashMap<Integer,HashMap<Pais,Integer>> expResult = new HashMap<>();
        Pais pais1 = new Pais("HRV","Europe","Croatia",4105268,(float)19.724,(float)253.782,(float)5.59,(float)34.3,(float)39.9,(float)5.54,(float)78.49);
        Pais pais2 = new Pais("AUT","Europe","Austria",9006400,(float)19.202,(float)145.183,(float)6.35,(float)28.4,(float)30.9,(float)7.37,(float)81.54);
        HashMap<Pais,Integer> map1 = new HashMap<>();
        map1.put(pais2,89);
        map1.put(pais1,67);
        expResult.put(1,map1);
        HashMap<Pais,Integer> map2 = new HashMap<>();
        map2.put(pais2,126);
        map2.put(pais1,86);
        expResult.put(2,map2);
        HashMap<Pais,Integer> map3 = new HashMap<>();
        map3.put(pais2,85);
        map3.put(pais1,36);
        expResult.put(3,map3);
        HashMap<Pais,Integer> map4 = new HashMap<>();
        map4.put(pais1,36);
        map4.put(pais2,32);
        expResult.put(4,map4);
        HashMap<Pais,Integer> map5 = new HashMap<>();
        map5.put(pais1,22);
        map5.put(pais2,131);
        expResult.put(5,map5);
        HashMap<Pais,Integer> map6 = new HashMap<>();
        map6.put(pais1,58);
        map6.put(pais2,103);
        expResult.put(6,map6);
        HashMap<Pais,Integer> map7 = new HashMap<>();
        map7.put(pais1,28);
        map7.put(pais2,114);
        expResult.put(7,map7);
        HashMap<Pais,Integer> map8 = new HashMap<>();
        map8.put(pais1,62);
        map8.put(pais2,130);
        expResult.put(8,map8);
        HashMap<Pais,Integer> map9 = new HashMap<>();
        map9.put(pais1,77);
        map9.put(pais2,116);
        expResult.put(9,map9);
        HashMap<Pais,Integer> map10 = new HashMap<>();
        map10.put(pais1,61);
        map10.put(pais2,76);
        expResult.put(10,map10);
        HashMap<Pais,Integer> map11 = new HashMap<>();
        map11.put(pais1,45);
        map11.put(pais2,111);
        expResult.put(11,map11);
        HashMap<Pais,Integer> map12 = new HashMap<>();
        map12.put(pais1,91);
        map12.put(pais2,138);
        expResult.put(12,map12);
        HashMap<Pais,Integer> map13 = new HashMap<>();
        map13.put(pais1,130);
        map13.put(pais2,241);
        expResult.put(13,map13);
        HashMap<Pais,Integer> map14 = new HashMap<>();
        map14.put(pais1,180);
        map14.put(pais2,229);
        expResult.put(14,map14);
        HashMap<Pais,Integer> map15 = new HashMap<>();
        map15.put(pais1,208);
        map15.put(pais2,221);
        expResult.put(15,map15);
        HashMap<Pais,Integer> map16 = new HashMap<>();
        map16.put(pais1,162);
        map16.put(pais2,260);
        expResult.put(16,map16);
        HashMap<Pais,Integer> map17= new HashMap<>();
        map17.put(pais1,151);
        map17.put(pais2,162);
        expResult.put(17,map17);
        HashMap<Pais,Integer> map18 = new HashMap<>();
        map18.put(pais1,85);
        map18.put(pais2,344);
        expResult.put(18,map18);
        HashMap<Pais,Integer> map19 = new HashMap<>();
        map19.put(pais1,199);
        map19.put(pais2,158);
        expResult.put(19,map19);
        HashMap<Pais,Integer> map20 = new HashMap<>();
        map20.put(pais1,219);
        map20.put(pais2,425);
        expResult.put(20,map20);
        HashMap<Pais,Integer> map21 = new HashMap<>();
        map21.put(pais1,255);
        map21.put(pais2,308);
        expResult.put(21,map21);
        HashMap<Pais,Integer> map22 = new HashMap<>();
        map22.put(pais1,265);
        map22.put(pais2,275);
        expResult.put(22,map22);
        HashMap<Pais,Integer> map23 = new HashMap<>();
        map23.put(pais1,306);
        map23.put(pais2,216);
        expResult.put(23,map23);
        HashMap<Pais,Integer> map24 = new HashMap<>();
        map24.put(pais1,275);
        map24.put(pais2,140);
        expResult.put(24,map24);
        HashMap<Pais,Integer> map25 = new HashMap<>();
        map25.put(pais1,136);
        map25.put(pais2,308);
        expResult.put(25,map25);
        HashMap<Pais,Integer> map26 = new HashMap<>();
        map26.put(pais1,219);
        map26.put(pais2,291);
        expResult.put(26,map26);
        HashMap<Pais,Integer> map27 = new HashMap<>();
        map27.put(pais1,358);
        map27.put(pais2,316);
        expResult.put(27,map27);
        HashMap<Pais,Integer> map28= new HashMap<>();
        map28.put(pais1,304);
        map28.put(pais2,227);
        expResult.put(28,map28);
        HashMap<Pais,Integer> map29 = new HashMap<>();
        map29.put(pais1,357);
        map29.put(pais2,382);
        expResult.put(29,map29);
        HashMap<Pais,Integer> map30 = new HashMap<>();
        map30.put(pais1,312);
        map30.put(pais2,174);
        expResult.put(30,map30);
        HashMap<Pais,Integer> map31 = new HashMap<>();
        map31.put(pais1,262);
        map31.put(pais2,281);
        expResult.put(31,map31);
        HashMap<Integer,HashMap<Pais,Integer>> result = test.casosPositivosNumContinente("Europe",8);
        Assert.assertEquals(result,expResult);
    }

    @org.junit.jupiter.api.Test
    void findPaisesComMais70Fumadores() {
        ArrayList <ArrayList<String>> expResult = new ArrayList<>();
        ArrayList <String> dados = new ArrayList<>();

        dados.add("Croatia");
        dados.add(Float.toString((float)74.2));
        dados.add(Integer.toString(272));

        expResult.add(dados);

        ArrayList <ArrayList<String>> result =test.findPaisesComMais70Fumadores();
        Assert.assertEquals(result,expResult);
    }
}