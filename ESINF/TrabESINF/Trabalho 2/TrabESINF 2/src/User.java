/**
 * The type User.
 */
public class User {
    /**
     * The User name.
     */
    String user;
    /**
     * The Age.
     */
    int age;
    /**
     * The City.
     */
    String city;

    /**
     * Instantiates a new User.
     *
     * @param user the user
     * @param age  the age
     * @param city the city
     */
    public User(String user, int age, String city) {
        this.user = user;
        this.age = age;
        this.city = city;
    }

    @Override
    public String toString() {
        return user;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }


}
