import com.google.common.base.Strings;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.android.options.app.SupportsAppActivityOption;
import io.appium.java_client.android.options.app.SupportsAppPackageOption;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.ios.options.wda.SupportsXcodeCertificateOptions;
import io.appium.java_client.ios.options.webview.*;
import io.appium.java_client.remote.options.*;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class DriverManager {
//    private static final ThreadLocal<RemoteWebDriver> localDriver = new ThreadLocal<>();
//    private static final ThreadLocal<Properties> props = new ThreadLocal<>();
//    private static final ThreadLocal<Integer> entity = new ThreadLocal<>();
//    static AppiumDriverLocalService appiumService;
//
//    public RemoteWebDriver initDriver(@NotNull String platform) throws MalformedURLException {
//        props.set(ConfigReader.instance().getProps());
//        startAppiumServerIfNeeded();
//
//        if (platform.equalsIgnoreCase("Android")) {
//            localDriver.set(new AndroidDriver(new URL(getProps().getProperty(MobileConfigurationOptions.APPIUM_SERVER.option())), getAndroidOptions()));
//        } else {
//            localDriver.set(new IOSDriver(new URL(getProps().getProperty(MobileConfigurationOptions.APPIUM_SERVER.option())), getIphoneOptions()));
//        }
//        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(getProps().getProperty(ConfigurationOptions.DEFAULT_TIMEOUT.option()))));
//
//        return getDriver();
//    }
//
//    private synchronized void startAppiumServerIfNeeded() {
//        if (appiumService == null || !appiumService.isRunning()) {
//            appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
//                    .withArgument(GeneralServerFlag.LOG_LEVEL, "error"));
//            appiumService.start();
//        }
//    }
//
//    public static synchronized RemoteWebDriver getDriver() {
//        return localDriver.get();
//    }
//
//    public static synchronized Properties getProps() {
//        return props.get();
//    }
//
//    public static synchronized void setEntity(int entityNo) {
//        entity.set(entityNo);
//    }
//
//    public static synchronized Integer getEntity() {
//        return entity.get();
//    }
//
//    public static synchronized void quitDriver() {
//        WebDriver driver = localDriver.get();
//        if (driver != null) {
//            driver.quit();
//            localDriver.remove();
//            props.remove();
//            SmartWait.unload();
//            if (appiumService != null && appiumService.isRunning()) {
//                appiumService.stop();
//            }
//        }
//    }
//
//    public UiAutomator2Options getAndroidOptions() {
//        UiAutomator2Options caps = new UiAutomator2Options();
//
//        caps.setCapability(SupportsPlatformVersionOption.PLATFORM_VERSION_OPTION, getProps().getProperty(MobileConfigurationOptions.PLATFORM_VERSION.option()));
//        caps.setCapability(SupportsDeviceNameOption.DEVICE_NAME_OPTION, getProps().getProperty(MobileConfigurationOptions.DEVICE_NAME.option()));
//        caps.setCapability(SupportsNativeWebTapOption.NATIVE_WEB_TAP_OPTION, true);
//        caps.setCapability("autoAcceptAlerts", true);
//
//        if (!getProps().getProperty(MobileConfigurationOptions.DEVICE_UDID.option()).trim().isEmpty()) {
//            caps.setCapability(SupportsUdidOption.UDID_OPTION, getProps().getProperty(MobileConfigurationOptions.DEVICE_UDID.option()));
//        }
//
//        if (!Strings.isNullOrEmpty(getProps().getProperty(MobileConfigurationOptions.APP.option()))) {
//            if (!getProps().getProperty(MobileConfigurationOptions.APP_ACTIVITY.option()).trim().isEmpty()) {
//                caps.setCapability(SupportsAppPackageOption.APP_PACKAGE_OPTION, getProps().getProperty(MobileConfigurationOptions.APP.option()));
//                caps.setCapability(SupportsAppActivityOption.APP_ACTIVITY_OPTION, getProps().getProperty(MobileConfigurationOptions.APP_ACTIVITY.option()));
//            } else {
//                caps.setCapability(SupportsAppOption.APP_OPTION, getProps().getProperty(MobileConfigurationOptions.APP.option()));
//            }
//
//            caps.setCapability(SupportsNoResetOption.NO_RESET_OPTION, Boolean.parseBoolean(getProps().getProperty(MobileConfigurationOptions.NO_RESET.option())));
//            caps.setCapability(SupportsFullResetOption.FULL_RESET_OPTION, Boolean.parseBoolean(getProps().getProperty(MobileConfigurationOptions.FULL_RESET.option())));
//        }
//
//        return caps;
//    }
//
//    public XCUITestOptions getIphoneOptions() {
//        XCUITestOptions caps = new XCUITestOptions();
//
//        caps.setCapability(SupportsPlatformVersionOption.PLATFORM_VERSION_OPTION, getProps().getProperty(MobileConfigurationOptions.PLATFORM_VERSION.option()));
//        caps.setCapability(SupportsDeviceNameOption.DEVICE_NAME_OPTION, getProps().getProperty(MobileConfigurationOptions.DEVICE_NAME.option()));
//        caps.setCapability("autoAcceptAlerts", true);
//        caps.setCapability("waitForQuiescence", false);
//        caps.setCapability("simpleIsVisibleCheck", true);
//
//        if (!getProps().getProperty(MobileConfigurationOptions.DEVICE_UDID.option()).trim().isEmpty()) {
//            caps.setCapability(SupportsUdidOption.UDID_OPTION, getProps().getProperty(MobileConfigurationOptions.DEVICE_UDID.option()));
//        }
//
//        if (!Strings.isNullOrEmpty(getProps().getProperty(MobileConfigurationOptions.APP.option()))) {
//            caps.setCapability(SupportsAppOption.APP_OPTION, getProps().getProperty(MobileConfigurationOptions.APP.option()));
//            caps.setCapability(SupportsNoResetOption.NO_RESET_OPTION, Boolean.parseBoolean(getProps().getProperty(MobileConfigurationOptions.NO_RESET.option())));
//            caps.setCapability(SupportsFullResetOption.FULL_RESET_OPTION, Boolean.parseBoolean(getProps().getProperty(MobileConfigurationOptions.FULL_RESET.option())));
//        }
//
//        if (!getProps().getProperty(MobileConfigurationOptions.DEVICE_UDID.option()).trim().isEmpty()) {
//            caps.setCapability(SupportsXcodeCertificateOptions.XCODE_ORG_ID_OPTION, getProps().getProperty(MobileConfigurationOptions.XCODE_ORG_ID.option()));
//            caps.setCapability(SupportsXcodeCertificateOptions.XCODE_SIGNING_ID_OPTION, "iPhone Developer");
//        }
//        caps.setCapability(SupportsSafariAllowPopupsOption.SAFARI_ALLOW_POPUPS_OPTION, true);
//        caps.setCapability(SupportsNativeWebTapOption.NATIVE_WEB_TAP_OPTION, true);
//        caps.setCapability(SupportsSafariIgnoreFraudWarningOption.SAFARI_IGNORE_FRAUD_WARNING_OPTION, true);
//        caps.setCapability(SupportsIncludeSafariInWebviewsOption.INCLUDE_SAFARI_IN_WEBVIEWS_OPTION, true);
//        caps.setCapability(SupportsWebkitResponseTimeoutOption.WEBKIT_RESPONSE_TIMEOUT_OPTION, 20000);
//
//        return caps;
//    }
}
