/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-09-04
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.common;

/**
 * @author wp
 */
public class Utils {

    private static String cutTokenFromUrl(String url, int authIndex) {
        return url.substring(0, authIndex + ApiData.TOKEN_PARAM_NAME.length() + 1).concat("[token]");
    }

    public static String cleanUrlFromToken(String url) {
        int authIndex = url.indexOf(ApiData.TOKEN_PARAM_NAME);
        int ampIndex = url.indexOf("&", authIndex);
        if (ampIndex == -1) {
            return cutTokenFromUrl(url, authIndex);
        } else {
            return cutTokenFromUrl(url, authIndex).concat(url.substring(ampIndex));
        }
    }

}
