package lt.vilniustech.YHev.first.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
/**
 * Configuration class that loads properties starting with 'test-config'.
 * Used to store values received from the Config Server.
 */
@Configuration
@ConfigurationProperties("test-config")
public class TestConfig {
    private String foo;

    /**
     * Set the value of foo.
     */
    public void setFoo(String foo) {
        this.foo = foo;
    }
/**
 * Gets the value of foo.
 */
    public String getFoo() {
        return foo;
    }
}
