/*
* A collection of graph algorithms.
*/
package graphbase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author DEI-ESINF
 */

public class GraphAlgorithms {
    
   /*
   * Performs breadth-first search of a Graph starting in a Vertex 
   * @param g Graph instance
   * @param vInf information of the Vertex that will be the source of the search
   * @return qbfs a queue with the vertices of breadth-first search 
   */
   public static <V, E> LinkedList<V> BreadthFirstSearch(Graph<V, E> g, V vert) {
       if (!g.validVertex(vert)) return null;
       boolean visited[] = new boolean[g.numVertices()];
       LinkedList<V> result = new LinkedList<>();
       LinkedList queue = new LinkedList<V>();
       int visits = g.getKey(vert);
       visited[visits] = true;
       queue.add(vert);
       result.add(vert);

       while (!result.isEmpty()) {
           vert = result.remove();
           for (V vis : g.adjVertices(vert)) {
               visits = g.getKey(vis);
               if (!visited[visits]) {
                   queue.add(vis);
                   result.add(vis);
                   visited[visits] = true;

               }
           }
       }
       return queue;
   }
   
   /*
   * Performs depth-first search starting in a Vertex   
   * @param g Graph instance
   * @param vOrig Vertex of graph g that will be the source of the search
   * @param visited set of discovered vertices
   * @param qdfs queue with vertices of depth-first search
   */
    private static<V,E> void DepthFirstSearch(Graph<V,E> g, V vOrig, LinkedList<V> qdfs){

        throw new UnsupportedOperationException("Not supported yet.");
    }

   /*
   * @param g Graph instance
   * @param vInf information of the Vertex that will be the source of the search
   * @return qdfs a queue with the vertices of depth-first search 
   */
    public static<V,E> LinkedList<V> DepthFirstSearch(Graph<V,E> g, V vert){
    
        throw new UnsupportedOperationException("Not supported yet.");
    }
   
    /*
   * Returns all paths from vOrig to vDest
   * @param g Graph instance
   * @param vOrig Vertex that will be the source of the path
   * @param vDest Vertex that will be the end of the path
   * @param visited set of discovered vertices
   * @param path stack with vertices of the current path (the path is in reverse order)
   * @param paths ArrayList with all the paths (in correct order)
   */
    private static<V,E> void allPaths(Graph<V,E> g, V vOrig, V vDest,  
                                           LinkedList<V> path, ArrayList<LinkedList<V>> paths){
  
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
   /*
   * @param g Graph instance
   * @param voInf information of the Vertex origin
   * @param vdInf information of the Vertex destination 
   * @return paths ArrayList with all paths from voInf to vdInf 
   */
    public static<V,E> ArrayList<LinkedList<V>> allPaths(Graph<V,E> g, V vOrig, V vDest){
    
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /*
   * Computes shortest-path distance from a source vertex to all reachable 
   * vertices of a graph g with nonnegative edge weights
   * This implementation uses Dijkstra's algorithm
   * @param g Graph instance
   * @param vOrig Vertex that will be the source of the path
   * @param visited set of discovered vertices
   * @param pathkeys minimum path vertices keys  
   * @param dist minimum distances
   */
    protected static<V,E> void shortestPathLength(Graph<V,E> g, V vOrig, 
                                    boolean[] visited, V[] pathKeys, double[] dist){   
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /*
    * Extracts from pathKeys the minimum path between voInf and vdInf
    * The path is constructed from the end to the beginning
    * @param g Graph instance
    * @param voInf information of the Vertex origin
    * @param vdInf information of the Vertex destination 
    * @param pathkeys minimum path vertices keys  
    * @param path stack with the minimum path (correct order)
    */
    protected static<V,E> void getPath(Graph<V,E> g, V vOrig, V vDest, V[] pathKeys, LinkedList<V> path){
    
       throw new UnsupportedOperationException("Not supported yet.");
    }

    //shortest-path between vOrig and vDest
    public static<V,E> double shortestPath(Graph<V,E> g, V vOrig, V vDest, LinkedList<V> shortPath){
      
        throw new UnsupportedOperationException("Not supported yet.");
    }
   
    //shortest-path between voInf and all other
    public static<V,E> boolean shortestPaths(Graph<V,E> g, V vOrig, ArrayList<LinkedList<V>> paths, ArrayList<Double> dists){
      
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    /**
     * Reverses the path
     * @param path stack with path
     */
    private static<V,E> LinkedList<V> revPath(LinkedList<V> path){ 
   
        LinkedList<V> pathcopy = new LinkedList<>(path);
        LinkedList<V> pathrev = new LinkedList<>();
        
        while (!pathcopy.isEmpty())
            pathrev.push(pathcopy.pop());
        
        return pathrev ;
    }    
}