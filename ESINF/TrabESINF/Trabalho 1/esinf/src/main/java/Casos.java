import java.util.Calendar;
import java.util.Date;

/**
 * The type Casos.
 */
public class Casos{

    /**
     * The Date.
     */
    Date date;
    /**
     * The Total cases.
     */
    int total_cases;
    /**
     * The New cases.
     */
    int new_cases;
    /**
     * The Total deaths.
     */
    int total_deaths;
    /**
     * The New deaths.
     */
    int new_deaths;
    /**
     * The New tests.
     */
    int new_tests;
    /**
     * The Total tests.
     */
    int total_tests;

    /**
     * Instantiates a new Casos.
     *
     * @param date         the date
     * @param total_cases  the total cases
     * @param new_cases    the new cases
     * @param total_deaths the total deaths
     * @param new_deaths   the new deaths
     * @param new_tests    the new tests
     * @param total_tests  the total tests
     */
    public Casos(Date date, int total_cases, int new_cases, int total_deaths, int new_deaths, int new_tests, int total_tests) {
        this.date = date;
        this.total_cases = total_cases;
        this.new_cases = new_cases;
        this.total_deaths = total_deaths;
        this.new_deaths = new_deaths;
        this.new_tests = new_tests;
        this.total_tests = total_tests;
    }

    @Override
    public String toString() {
        return "Caso{" +
                "date=" + date +
                ", total_cases=" + total_cases +
                ", new_cases=" + new_cases +
                ", total_deaths=" + total_deaths +
                ", new_deaths=" + new_deaths +
                ", new_tests=" + new_tests +
                ", total_tests=" + total_tests +
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

        return this.getDate().equals(((Casos) obj).getDate());
    }

    @Override
    public int hashCode() {
        return this.date.hashCode();
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets total cases.
     *
     * @return the total cases
     */
    public int getTotal_cases() {
        return total_cases;
    }

    /**
     * Sets total cases.
     *
     * @param total_cases the total cases
     */
    public void setTotal_cases(int total_cases) {
        this.total_cases = total_cases;
    }

    /**
     * Gets new cases.
     *
     * @return the new cases
     */
    public int getNew_cases() {
        return new_cases;
    }

    /**
     * Sets new cases.
     *
     * @param new_cases the new cases
     */
    public void setNew_cases(int new_cases) {
        this.new_cases = new_cases;
    }

    /**
     * Gets total deaths.
     *
     * @return the total deaths
     */
    public int getTotal_deaths() {
        return total_deaths;
    }

    /**
     * Sets total deaths.
     *
     * @param total_deaths the total deaths
     */
    public void setTotal_deaths(int total_deaths) {
        this.total_deaths = total_deaths;
    }

    /**
     * Gets new deaths.
     *
     * @return the new deaths
     */
    public int getNew_deaths() {
        return new_deaths;
    }

    /**
     * Sets new deaths.
     *
     * @param new_deaths the new deaths
     */
    public void setNew_deaths(int new_deaths) {
        this.new_deaths = new_deaths;
    }

    /**
     * Gets new tests.
     *
     * @return the new tests
     */
    public int getNew_tests() {
        return new_tests;
    }

    /**
     * Sets new tests.
     *
     * @param new_tests the new tests
     */
    public void setNew_tests(int new_tests) {
        this.new_tests = new_tests;
    }

    /**
     * Gets total tests.
     *
     * @return the total tests
     */
    public int getTotal_tests() {
        return total_tests;
    }

    /**
     * Sets total tests.
     *
     * @param total_tests the total tests
     */
    public void setTotal_tests(int total_tests) {
        this.total_tests = total_tests;
    }
}
