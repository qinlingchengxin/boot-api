package net.ys.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * 系统配置类
 * User: NMY
 * Date: 16-8-28
 */
@Component
@ConfigurationProperties(prefix = "config")
public class SysConfig {

    public static String appName;

    public static String testPath;

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public void setTestPath(String testPath) {
        File file = new File(testPath);
        if (!file.exists()) {
            if (!file.mkdirs()) {
                throw new RuntimeException("testPath is invalid");
            }
        }
        this.testPath = file.getAbsolutePath().replace('\\', '/') + "/";
    }
}
