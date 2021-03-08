import graphbase.Graph;

/**
 * The type Borders network.
 */
public class BordersNetwork {
    /**
     * The Graph borders.
     */
    public Graph<Country, String> graphBorders;

    /**
     * Instantiates a new Borders network.
     */
    public BordersNetwork() {
            this.graphBorders = new Graph<>(false) ;
        }

    /**
     * Add country.
     *
     * @param country the country
     */
    public void addCountry(Country country) {
            graphBorders.insertVertex(country);
        }

    /**
     * Add border.
     *
     * @param country1 the country 1
     * @param country2 the country 2
     */
    public void addBorder(Country country1, Country country2) {
            graphBorders.insertEdge(country1,country2,"border", country1.distanciaFrom(country2));
        }

    /**
     * Gets graph borders.
     *
     * @return the graph borders
     */
    public Graph<Country, String> getGraphBorders() {
        return this.graphBorders;
    }
}


