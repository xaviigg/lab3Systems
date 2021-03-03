package upf.edu.util;

import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.ConfigurationBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {

    /**
     * Get a Twitter {@link OAuthAuthorization} from a Java {@link Properties} file.
     * Properties have to be specified as:
     *
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public static OAuthAuthorization getAuthorizationFromFileProperties(String fileName) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader(fileName));

        ConfigurationBuilder cb = new ConfigurationBuilder()
                .setOAuthConsumerKey(properties.getProperty("consumer.key"))
                .setOAuthConsumerSecret(properties.getProperty("consumer.secret"))
                .setOAuthAccessToken(properties.getProperty("access.token"))
                .setOAuthAccessTokenSecret(properties.getProperty("access.secret"));

        return new OAuthAuthorization(cb.build());
    }
}
