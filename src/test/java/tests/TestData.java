package tests;

import config.AuthConfig;
import org.aeonbits.owner.ConfigFactory;

public class TestData {
    AuthConfig authConfig = ConfigFactory.create(AuthConfig.class);
    String username = authConfig.userName(),
    password = authConfig.password();
}
