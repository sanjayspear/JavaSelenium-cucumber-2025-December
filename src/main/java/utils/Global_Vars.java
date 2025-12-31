
// src/main/java/utils/Global_Vars.java
package utils;

/**
 * Enum used purely as a namespace for framework-wide constants.
 * No instances are meant to be used; only static constants are referenced.
 */
public enum Global_Vars {
    ; // no enum constants; acts as a static holder
    public static final String WEBDRIVER_UNIVERSITY_HOMEPAGE_URL = "https://www.webdriveruniversity.com";

    // Default explicit wait timeout (seconds)
    public static final long DEFAULT_EXPLICIT_TIMEOUT = 10L;

    // (Optional) other constants
    public static final long PAGE_LOAD_TIMEOUT = 60L;
    public static final long DEFAULT_IMPLICIT_TIMEOUT = 0L;
}
