package helper;

import com.github.javafaker.Faker;

public class DataHelper {
    static Faker faker = new Faker();

    /***
     * get Text
     * @return
     */
    public static String getTextRandom() {
        return faker.name().title();
    }

    /***
     * get Name
     * @return
     */
    public static String getNameRandom() {
        return faker.name().fullName();
    }

    /***
     * get Email
     * @return
     */
    public static String getEmailRandom() {
        return faker.internet().emailAddress();
    }
}
