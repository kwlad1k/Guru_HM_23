package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/driver.properties"
})

public interface DriverConfig extends Config {

    @Key("device.name")
    @DefaultValue("Google Pixel 3")
    String device();

    @Key("device.version")
    @DefaultValue("9.0")
    String osVersion();

    @Key("remote.url")
    String remoteUrl();

    @Key("app.url")
    String appUrl();

    @Key("search.value")
    String searchValue();
}

