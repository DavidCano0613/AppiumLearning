import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Getter
@AllArgsConstructor
public enum MobileConfigurationOptions {
    PLATFORM_NAME("platform.name"),
    PLATFORM_VERSION("platform.version"),
    DEVICE_NAME("device.name"),
    DEVICE_UDID("device.udid"),
    APP("app"),
    APP_ACTIVITY("app.activity"),
    NO_RESET("reset.no"),
    FULL_RESET("reset.full"),
    APPIUM_SERVER("appium.server"),
    XCODE_ORG_ID("xCodeOrgId");

    private final String option;
}