package net.ys.util;


import lombok.extern.slf4j.Slf4j;

/**
 * User: NMY
 * Date: 18-4-26
 */

@Slf4j
public class LogUtil {

    public static void error(Exception e) {
        log.error(e.getMessage(), e);
    }

    public static void error(String msg, Exception e) {
        log.error(msg, e);
    }

    public static void info(Object msg) {
        log.info(String.valueOf(msg));
    }

    public static void debug(Object... messages) {
        for (Object msg : messages) {
            log.debug(String.valueOf(msg));
        }
    }
}
