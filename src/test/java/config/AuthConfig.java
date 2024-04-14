package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/auth.properties"
})

public interface AuthConfig extends Config {

    @Key("browserstack.user.name")
    String userName();

    @Key("browserstack.key")
    String userKey();
}
