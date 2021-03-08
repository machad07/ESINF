
package graph;

import graphbase.Edge;
import graphbase.Graph;

import java.util.LinkedList;

/**
 *
 * @author DEI-ESINF
 */
public class EdgeAsDoubleGraphAlgorithms {



    private static <V> void shortestPath(AdjacencyMatrixGraph<V, Integer> graph, int sourceIdx, boolean[] knownVertices, int[] verticesIndex, double [] minDist){
        minDist[sourceIdx] = 0;
        while (sourceIdx != -1) {
            knownVertices[sourceIdx] = true;
            for (V vx : graph.vertices()) {
                int vAdj = graph.toIndex(vx);
                Integer edge = graph.privateGet(sourceIdx, vAdj);
                if (edge != null) {
                    if (!knownVertices[vAdj] && minDist[vAdj] > minDist[sourceIdx] + edge) {
                        minDist[vAdj] = minDist[sourceIdx] + edge;
                        verticesIndex[vAdj] = sourceIdx;
                    }
                }
            }

            Double min = Double.MAX_VALUE;
            sourceIdx = -1;
            for (int i = 0; i < graph.numVertices; i++) {
                if (!knownVertices[i] && minDist[i] < min) {
                    min = minDist[i];
                    sourceIdx = i;
                }
            }
        }
    }


    /*
     * Determine the shortest path between two vertices using Dijkstra's algorithm
     * @param graph Graph object
     * @param source Source vertex
     * @param dest Destination vertices
     * @param path Returns the vertices in the path (empty if no path)
     * @return minimum distance, -1 if vertices not in graph or no path
     *
     */

    public static <V> double shortestPath(AdjacencyMatrixGraph<V,Integer> graph, V vOrig, V vDest, LinkedList<V> shortPath) {
        int sourceIdx = graph.toIndex(vOrig);
        if (sourceIdx == -1)
            return -1;

        int destIdx = graph.toIndex(vDest);
        if (destIdx == -1)
            return -1;

        shortPath.clear();
        int nverts = graph.numVertices();
        boolean[] visited = new boolean[nverts]; //default value: false
        int[] verticesIndex = new int[nverts];
        double[] dist = new double[nverts];

        for (int i = 0; i < nverts; i++) {
            dist[i] = Double.MAX_VALUE;
            verticesIndex[i] = -1;
        }

        shortestPath(graph, sourceIdx, visited, verticesIndex, dist);
        if (dist[destIdx] != Double.MAX_VALUE) {
            recreatePath(graph, sourceIdx, destIdx ,verticesIndex, shortPath);
        }
        return shortPath.isEmpty() ? 0 : dist[destIdx];
    }

    /**
     * Recreates the minimum path between two vertex, from the result of Dikstra's algorithm
     * @param graph Graph object
     * @param sourceIdx Source vertex 
     * @param destIdx Destination vertices
     * @param verticesIndex index of vertices in the minimum path
     * @param //Queue Vertices in the path (empty if no path)
     */
    private static <V> void recreatePath(AdjacencyMatrixGraph<V, Integer> graph, int sourceIdx,
                                         int destIdx, int[] verticesIndex, LinkedList<V> path){

        path.add(graph.vertices.get(destIdx));
        if (sourceIdx != destIdx){
            destIdx = verticesIndex[destIdx];        
            recreatePath(graph, sourceIdx, destIdx, verticesIndex, path);
        }
    }



}
