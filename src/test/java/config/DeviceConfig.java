package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/device.properties"
})

public interface DeviceConfig extends Config {
    @DefaultValue("Galaxy S21 Ultra")
    String device();

    @Key("os.version")
    @DefaultValue("11")
    String osVersion();
}

