package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/capability.properties"
})

public interface CapabilityConfig extends Config {

    String project();

    String build();

    String name();
}