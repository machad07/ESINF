import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The type Country.
 */
public class Country {
    /**
     * The Name.
     */
    String name;
    /**
     * The Continent.
     */
    String continent;
    /**
     * The Population.
     */
    double population;
    /**
     * The Capital.
     */
    String capital;
    /**
     * The Latitude.
     */
    float latitude;
    /**
     * The Longitude.
     */
    float longitude;
    /**
     * The Centralidade.
     */
    double centralidade;

    /**
     * Instantiates a new Country.
     *
     * @param name       the name
     * @param continent  the continent
     * @param population the population
     * @param capital    the capital
     * @param latitude   the latitude
     * @param longitude  the longitude
     */
    public Country(String name, String continent, double population, String capital, float latitude, float longitude) {
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.capital = capital;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Media proximidade.
     *
     * @param listaCountries the lista countries
     */
    public void mediaProximidade(List<Country> listaCountries){
        double total=0;
        for(Country countrySec : listaCountries) {
            if(countrySec!=this)
                total = total + this.distanciaFrom(countrySec);
        }
        this.centralidade = total/(listaCountries.size()-1);
    }

    /**
     * Gets centralidade.
     *
     * @return the centralidade
     */
    public double getCentralidade() {
        return centralidade;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets continent.
     *
     * @return the continent
     */
    public String getContinent() {
        return continent;
    }

    /**
     * Sets continent.
     *
     * @param continent the continent
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }

    /**
     * Gets population.
     *
     * @return the population
     */
    public double getPopulation() {
        return population;
    }

    /**
     * Sets population.
     *
     * @param population the population
     */
    public void setPopulation(long population) {
        this.population = population;
    }

    /**
     * Gets capital.
     *
     * @return the capital
     */
    public String getCapital() {
        return capital;
    }

    /**
     * Sets capital.
     *
     * @param capital the capital
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }

    /**
     * Gets latitude.
     *
     * @return the latitude
     */
    public float getLatitude() {
        return latitude;
    }

    /**
     * Sets latitude.
     *
     * @param latitude the latitude
     */
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    /**
     * Gets longitude.
     *
     * @return the longitude
     */
    public float getLongitude() {
        return longitude;
    }

    /**
     * Sets longitude.
     *
     * @param longitude the longitude
     */
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    /**
     * Distancia from double.
     *
     * @param country2 the country 2
     * @return the double
     */
    public double distanciaFrom(Country country2){
        double latitude1r = this.latitude* Math.PI/180;
        double latitude2r = country2.getLatitude()* Math.PI/180;
        double dlatitude = (country2.getLatitude()-this.latitude) * Math.PI/180;
        double dlongitude = (country2.getLongitude()-this.longitude) * Math.PI/180;

        double a = Math.pow(Math.sin(dlatitude/2),2)+ Math.cos(latitude1r)*Math.cos(latitude2r)
                *Math.pow(Math.sin(dlongitude/2),2);
        double c = 2*Math.atan2(Math.toRadians(Math.sqrt(a)),Math.toRadians(Math.sqrt((1-a))));
        return 6371*c;
    }


}