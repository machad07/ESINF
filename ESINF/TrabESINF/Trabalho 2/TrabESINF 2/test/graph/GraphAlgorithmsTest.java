
package graph;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author DEI-ESINF
 */
public class GraphAlgorithmsTest {

    AdjacencyMatrixGraph<String, String> completeMap = new AdjacencyMatrixGraph<>();
    AdjacencyMatrixGraph<String, String> incompleteMap;
	
    public GraphAlgorithmsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
	
    @SuppressWarnings("unchecked")
    @Before
    public void setUp() throws Exception {
		
		completeMap.insertVertex("Porto");
		completeMap.insertVertex("Braga");
		completeMap.insertVertex("Vila Real");
		completeMap.insertVertex("Aveiro");
		completeMap.insertVertex("Coimbra");
		completeMap.insertVertex("Leiria");

		completeMap.insertVertex("Viseu");
		completeMap.insertVertex("Guarda");
		completeMap.insertVertex("Castelo Branco");
		completeMap.insertVertex("Lisboa");
		completeMap.insertVertex("Faro");

		completeMap.insertEdge("Porto", "Aveiro", "A1");
		completeMap.insertEdge("Porto", "Braga", "A3");
		completeMap.insertEdge("Porto", "Vila Real", "A4");
		completeMap.insertEdge("Viseu", "Guarda", "A25");
		completeMap.insertEdge("Guarda",  "Castelo Branco", "A23");
		completeMap.insertEdge("Aveiro", "Coimbra", "A1");
		completeMap.insertEdge("Coimbra", "Lisboa", "A1");
		completeMap.insertEdge("Coimbra",  "Leiria",  "A34");
		completeMap.insertEdge("Aveiro", "Leiria", "A17");
		completeMap.insertEdge("Leiria", "Lisboa", "A8");

		
		incompleteMap = (AdjacencyMatrixGraph<String, String>) completeMap.clone();
		
		completeMap.insertEdge("Aveiro", "Viseu", "A25");
		completeMap.insertEdge("Leiria", "Castelo Branco", "A23");
		completeMap.insertEdge("Lisboa", "Faro", "A2");

	}

	
	@Test
	public void testDFS() {
		System.out.println("Test of DFS");

		LinkedList<String> path;

		assertTrue("Should be null if vertex does not exist", GraphAlgorithms2.DFS(completeMap, "LX")==null);

		path = GraphAlgorithms2.DFS(incompleteMap, "Faro");

		assertTrue("Should be just one", path.size()==1);

		Iterator<String> it = path.iterator();

		assertTrue("it should be Faro", it.next().compareTo("Faro")==0);
		
		path = GraphAlgorithms2.DFS(completeMap, "Porto");
		
		assertTrue("Should give all vertices ", path.size()==11);

		it = path.iterator();

		assertTrue("First in visit should be Porto", it.next().compareTo("Porto")==0);
		assertTrue("then Braga", it.next().compareTo("Braga")==0);
		assertTrue("then Vila Real", it.next().compareTo("Vila Real")==0);
		assertTrue("then Aveiro", it.next().compareTo("Aveiro")==0);

		assertTrue("then Coimbra", it.next().compareTo("Coimbra")==0);
		assertTrue("then Leiria", it.next().compareTo("Leiria")==0);
		assertTrue("then Castelo Branco", it.next().compareTo("Castelo Branco")==0);
		assertTrue("then Guarda", it.next().compareTo("Guarda")==0);
		assertTrue("then Viseu", it.next().compareTo("Viseu")==0);
		assertTrue("then Lisboa", it.next().compareTo("Lisboa")==0);
		assertTrue("then Faro", it.next().compareTo("Faro")==0);

		
		path = GraphAlgorithms2.DFS(incompleteMap, "Viseu");
		
		assertTrue("Should give 3 vertices", path.size()==3);

		it = path.iterator();

		assertTrue("First in visit should be Viseu", it.next().compareTo("Viseu")==0);
		assertTrue("then Guarda", it.next().compareTo("Guarda")==0);
		assertTrue("then Castelo Branco", it.next().compareTo("Castelo Branco")==0);
	}

	@Test
	public void testBFS() {
		System.out.println("Test of BFS");

		LinkedList<String> path;

		assertTrue("Should be null if vertex does not exist", GraphAlgorithms2.BFS(completeMap, "LX")==null);

		path = GraphAlgorithms2.BFS(incompleteMap, "Faro");

		assertTrue("Should be just one", path.size()==1);

		Iterator<String> it = path.iterator();

		assertTrue("it should be Faro", it.next().compareTo("Faro")==0);

		
		path = GraphAlgorithms2.BFS(completeMap, "Porto");
		
		assertTrue("Should give all vertices ", path.size()==11);

		it = path.iterator();

		assertTrue("First in visit should be Porto", it.next().compareTo("Porto")==0);
		assertTrue("then Braga", it.next().compareTo("Braga")==0);
		assertTrue("then Vila Real", it.next().compareTo("Vila Real")==0);
		assertTrue("then Aveiro", it.next().compareTo("Aveiro")==0);

		assertTrue("then Coimbra", it.next().compareTo("Coimbra")==0);
		assertTrue("then Leiria", it.next().compareTo("Leiria")==0);
		assertTrue("then Viseu", it.next().compareTo("Viseu")==0);
		assertTrue("then Lisboa", it.next().compareTo("Lisboa")==0);
		assertTrue("then Castelo Branco", it.next().compareTo("Castelo Branco")==0);
		assertTrue("then Guarda", it.next().compareTo("Guarda")==0);
		assertTrue("then Faro", it.next().compareTo("Faro")==0);

		
		path = GraphAlgorithms2.BFS(incompleteMap, "Viseu");
		
		assertTrue("Should give 3 vertices", path.size()==3);

		it = path.iterator();

		assertTrue("First in visit should be Viseu", it.next().compareTo("Viseu")==0);
		assertTrue("then Guarda", it.next().compareTo("Guarda")==0);
		assertTrue("then Castelo Branco", it.next().compareTo("Castelo Branco")==0);
		
	}

	@Test
	public void testTransitiveClosure() {
		AdjacencyMatrixGraph<String, String> newMap = new AdjacencyMatrixGraph<>();

		newMap.insertVertex("Porto");
		newMap.insertVertex("Braga");
		newMap.insertVertex("Vila Real");
		newMap.insertVertex("Aveiro");
		newMap.insertVertex("Coimbra");

		newMap.insertEdge("Porto", "Braga", "Estrada 1");
		newMap.insertEdge("Braga", "Vila Real", "Estrada 2");
		newMap.insertEdge("Vila Real", "Aveiro", "Estrada 3");
		newMap.insertEdge("Aveiro", "Coimbra", "Estrada 4");
		newMap.insertEdge("Coimbra", "Porto", "Estrada 4");

		AdjacencyMatrixGraph<String, String> result = GraphAlgorithms2.transitiveClosure(newMap, "Estrada 1");

		System.out.println(result);

		assertEquals(4, result.inDegree("Porto"));
		assertEquals(4, result.inDegree("Braga"));
		assertEquals(4, result.inDegree("Vila Real"));
		assertEquals(4, result.inDegree("Aveiro"));
		assertEquals(4, result.inDegree("Coimbra"));

	}

}
