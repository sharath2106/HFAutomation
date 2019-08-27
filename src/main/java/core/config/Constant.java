package core.config;

public class Constant {

    private static final String homeDirectory = System.getProperty("user.dir");

    static final String pathToFailedScreenshotsReport = homeDirectory + "/target/failed-tests-screenshots/";

    public static final String pathToLoginDataYaml = homeDirectory + "/src/main/resources/login.yaml";

    public static final String pathToConfigurationProperties = homeDirectory+"/src/main/resources/configuration.properties";

}
