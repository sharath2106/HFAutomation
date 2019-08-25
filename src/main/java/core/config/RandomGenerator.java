package core.config;

import org.apache.commons.lang3.RandomStringUtils;


public class RandomGenerator {

    public String getRandomString(int sizeOfString){
        return RandomStringUtils.randomAlphabetic(sizeOfString).toLowerCase();
    }

    public String getRandomNumber(int sizeOfNumber){
        return RandomStringUtils.randomNumeric(sizeOfNumber);
    }

    public String getRandomAlphanumeric(int sizeOfAlphanumerics){
        return RandomStringUtils.randomAlphanumeric(sizeOfAlphanumerics);
    }

}

