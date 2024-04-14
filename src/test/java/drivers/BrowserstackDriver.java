package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AuthConfig;
import config.CapabilityConfig;
import config.DeviceConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    DeviceConfig deviceConfig = ConfigFactory.create(DeviceConfig.class);
    AuthConfig authConfig = ConfigFactory.create(AuthConfig.class);
    CapabilityConfig capabilityConfig = ConfigFactory.create(CapabilityConfig.class);

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", authConfig.authUser());
        caps.setCapability("browserstack.key", authConfig.authKey());

        // Set URL of the application under test
        caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

        // Specify device and os_version for testing
        caps.setCapability("device", deviceConfig.device());
        caps.setCapability("os_version", deviceConfig.osVersion());

        // Set other BrowserStack capabilities
        caps.setCapability("project", capabilityConfig.project());
        caps.setCapability("build", capabilityConfig.build());
        caps.setCapability("name", capabilityConfig.name());

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL("https://hub.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
