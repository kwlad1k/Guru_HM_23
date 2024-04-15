package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AuthConfig;
import config.CapabilityConfig;
import config.DriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackDriver implements WebDriverProvider {

    DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class);
    AuthConfig authConfig = ConfigFactory.create(AuthConfig.class);
    CapabilityConfig capabilityConfig = ConfigFactory.create(CapabilityConfig.class);

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("browserstack.user", authConfig.userName());
        caps.setCapability("browserstack.key", authConfig.userKey());

        caps.setCapability("app", driverConfig.appUrl());

        caps.setCapability("device", driverConfig.device());
        caps.setCapability("os_version", driverConfig.osVersion());

        caps.setCapability("project", capabilityConfig.project());
        caps.setCapability("build", capabilityConfig.build());
        caps.setCapability("name", capabilityConfig.name());

        try {
            return new RemoteWebDriver(
                    new URL(driverConfig.remoteUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
