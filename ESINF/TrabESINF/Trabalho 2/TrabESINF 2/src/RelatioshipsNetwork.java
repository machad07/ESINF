import graph.*;


/**
 * The type Relatioships network.
 */
public class RelatioshipsNetwork {
    /**
     * The Graph relationships.
     */
    public AdjacencyMatrixGraph<User, Integer> graphRelationships;

    /**
     * Instantiates a new Relatioships network.
     */
    public RelatioshipsNetwork() {
        this.graphRelationships = new AdjacencyMatrixGraph<>();
    }

    /**
     * Add user.
     *
     * @param user the user
     */
    public void addUser(User user) {
        graphRelationships.insertVertex(user);
    }

    /**
     * Add relationship.
     *
     * @param user1 the user 1
     * @param user2 the user 2
     */
    public void addRelationship(User user1, User user2) {
        graphRelationships.insertEdge(user2, user1, 1);
    }

    /**
     * Get vertex user.
     *
     * @param i the
     * @return the user
     */
    public User getVertex(int i){
        return graphRelationships.getVertex(i);
    }

    /**
     * Gets graph relationships.
     *
     * @return the graph relationships
     */
    public AdjacencyMatrixGraph<User, Integer> getGraphRelationships() {
        return this.graphRelationships;
    }
}
