package root;
public class Configuration implements IConfiguration {

    private static IConfiguration configuration = null;

    public static IConfiguration getConfiguration() {
        if (configuration == null) {
            configuration = new Configuration();
        }
        return configuration;
    }

    @Override
    public String getUser() {
        return System.getenv("userMySQL");
    }

    @Override
    public String getPassword() {
        return System.getenv("passwordMySQL");
    }

    @Override
    public String getUrl() {
        return System.getenv("urlMySQL");

    }
}