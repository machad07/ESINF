/**
 * The type Pais.
 */
public class Pais{

    /**
     * The Continente.
     */
    String continente;
    /**
     * The Iso code.
     */
    String iso_code;
    /**
     * The Location.
     */
    String location;
    /**
     * The Population.
     */
    long population;
    /**
     * The Aged 65 older.
     */
    float aged_65_older;
    /**
     * The Cardiovasc death rate.
     */
    float cardiovasc_death_rate;
    /**
     * The Diabetes prevalance.
     */
    float diabetes_prevalance;
    /**
     * The Female smokers.
     */
    float female_smokers;
    /**
     * The Male smokers.
     */
    float male_smokers;
    /**
     * The Hospital beds per thousand.
     */
    float hospital_beds_per_thousand;
    /**
     * The Life expectancy.
     */
    float life_expectancy;

    /**
     * Instantiates a new Pais.
     *
     * @param iso_code                   the iso code
     * @param continente                 the continente
     * @param location                   the location
     * @param population                 the population
     * @param aged_65_older              the aged 65 older
     * @param cardiovasc_death_rate      the cardiovasc death rate
     * @param diabetes_prevalance        the diabetes prevalance
     * @param female_smokers             the female smokers
     * @param male_smokers               the male smokers
     * @param hospital_beds_per_thousand the hospital beds per thousand
     * @param life_expectancy            the life expectancy
     */
    public Pais(String iso_code, String continente, String location, long population, float aged_65_older,
                float cardiovasc_death_rate, float diabetes_prevalance, float female_smokers, float male_smokers,
                float hospital_beds_per_thousand, float life_expectancy) {

        this.continente = continente;
        this.iso_code = iso_code;
        this.location = location;
        this.population = population;
        this.aged_65_older = aged_65_older;
        this.cardiovasc_death_rate = cardiovasc_death_rate;
        this.diabetes_prevalance = diabetes_prevalance;
        this.female_smokers = female_smokers;
        this.male_smokers = male_smokers;
        this.hospital_beds_per_thousand = hospital_beds_per_thousand;
        this.life_expectancy = life_expectancy;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "location='" + location + '\'' +
                ", population=" + population +
                ", aged_65_older=" + aged_65_older +
                ", cardiovasc_death_rate=" + cardiovasc_death_rate +
                ", diabetes_prevalance=" + diabetes_prevalance +
                ", female_smokers=" + female_smokers +
                ", male_smokers=" + male_smokers +
                ", hospital_beds_per_thousand=" + hospital_beds_per_thousand +
                ", life_expectancy=" + life_expectancy +
                '}';
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }

        if (obj == this){
            return true;
        }

        if (!(obj instanceof Pais)){
            return false;
        }

        return this.getIso_code().equals(((Pais) obj).getIso_code());
    }

    @Override
    public int hashCode() {
        return this.continente.hashCode();
    }

    /**
     * Gets continente.
     *
     * @return the continente
     */
    public String getContinente() {
        return continente;
    }

    /**
     * Sets continente.
     *
     * @param continente the continente
     */
    public void setContinente(String continente) {
        this.continente = continente;
    }

    /**
     * Gets iso code.
     *
     * @return the iso code
     */
    public String getIso_code() {
        return iso_code;
    }

    /**
     * Sets iso code.
     *
     * @param iso_code the iso code
     */
    public void setIso_code(String iso_code) {
        this.iso_code = iso_code;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets population.
     *
     * @return the population
     */
    public long getPopulation() {
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
     * Gets aged 65 older.
     *
     * @return the aged 65 older
     */
    public float getAged_65_older() {
        return aged_65_older;
    }

    /**
     * Sets aged 65 older.
     *
     * @param aged_65_older the aged 65 older
     */
    public void setAged_65_older(float aged_65_older) {
        this.aged_65_older = aged_65_older;
    }

    /**
     * Gets cardiovasc death rate.
     *
     * @return the cardiovasc death rate
     */
    public float getCardiovasc_death_rate() {
        return cardiovasc_death_rate;
    }

    /**
     * Sets cardiovasc death rate.
     *
     * @param cardiovasc_death_rate the cardiovasc death rate
     */
    public void setCardiovasc_death_rate(float cardiovasc_death_rate) {
        this.cardiovasc_death_rate = cardiovasc_death_rate;
    }

    /**
     * Gets diabetes prevalance.
     *
     * @return the diabetes prevalance
     */
    public float getDiabetes_prevalance() {
        return diabetes_prevalance;
    }

    /**
     * Sets diabetes prevalance.
     *
     * @param diabetes_prevalance the diabetes prevalance
     */
    public void setDiabetes_prevalance(float diabetes_prevalance) {
        this.diabetes_prevalance = diabetes_prevalance;
    }

    /**
     * Gets female smokers.
     *
     * @return the female smokers
     */
    public float getFemale_smokers() {
        return female_smokers;
    }

    /**
     * Sets female smokers.
     *
     * @param female_smokers the female smokers
     */
    public void setFemale_smokers(float female_smokers) {
        this.female_smokers = female_smokers;
    }

    /**
     * Gets male smokers.
     *
     * @return the male smokers
     */
    public float getMale_smokers() {
        return male_smokers;
    }

    /**
     * Sets male smokers.
     *
     * @param male_smokers the male smokers
     */
    public void setMale_smokers(float male_smokers) {
        this.male_smokers = male_smokers;
    }

    /**
     * Gets hospital beds per thousand.
     *
     * @return the hospital beds per thousand
     */
    public float getHospital_beds_per_thousand() {
        return hospital_beds_per_thousand;
    }

    /**
     * Sets hospital beds per thousand.
     *
     * @param hospital_beds_per_thousand the hospital beds per thousand
     */
    public void setHospital_beds_per_thousand(float hospital_beds_per_thousand) {
        this.hospital_beds_per_thousand = hospital_beds_per_thousand;
    }

    /**
     * Gets life expectancy.
     *
     * @return the life expectancy
     */
    public float getLife_expectancy() {
        return life_expectancy;
    }

    /**
     * Sets life expectancy.
     *
     * @param life_expectancy the life expectancy
     */
    public void setLife_expectancy(float life_expectancy) {
        this.life_expectancy = life_expectancy;
    }
}
