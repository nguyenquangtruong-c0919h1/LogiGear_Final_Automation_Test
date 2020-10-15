package helper;

import com.github.javafaker.Faker;

public class DataHelper {
    static Faker faker = new Faker();

    /***
     * get Text random
     * @return
     */
    public static String getTextRandom() {
        return faker.name().title();
    }

    /***
     * get Name random
     * @return
     */
    public static String getNameRandom() {
        return faker.name().fullName();
    }

    /***
     * get Email random
     * @return
     */
    public static String getEmailRandom() {
        return faker.internet().emailAddress();
    }

    /***
     * get Url
     * @return random
     */
    public static String getUrlRandom(){
        return faker.internet().url();
    }
}
