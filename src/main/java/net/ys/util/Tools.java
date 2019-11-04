package net.ys.util;

import net.ys.constant.X;

import java.security.MessageDigest;

/**
 * User: NMY
 * Date: 16-9-8
 */
public class Tools {

    /**
     * MD5加密
     *
     * @param str
     * @return
     */
    public static String genMD5(String str) {
        try {
            if (str == null || "".equals(str.trim())) {
                return "";
            }
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest((str).getBytes(X.Code.U));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bs.length; i++) {
                sb.append(Character.forDigit((bs[i] >>> 4) & 0x0F, 16)).append(Character.forDigit(bs[i] & 0x0F, 16));
            }
            return sb.toString();
        } catch (Exception e) {
        }
        return "";
    }

    /**
     * 佛祖保佑
     */
    public static void godBless() {
        System.out.println("" +
                "                    _ooOoo_\n" +
                "                   o8888888o\n" +
                "                   88\" . \"88\n" +
                "                   (| -_- |)\n" +
                "                   O\\  =  /O\n" +
                "                ____/`---'\\____\n" +
                "              .'  \\\\|     |//  `.\n" +
                "             /  \\\\|||  :  |||//  \\\n" +
                "            /  _||||| -:- |||||-  \\\n" +
                "            |   | \\\\\\  -  /// |   |\n" +
                "            | \\_|  ''\\---/''  |   |\n" +
                "            \\  .-\\__  `-`  ___/-. /\n" +
                "          ___`. .'  /--.--\\  `. . __\n" +
                "       .\"\" '<  `.___\\_<|>_/___.'  >'\"\".\n" +
                "      | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |\n" +
                "      \\  \\ `-.   \\_ __\\ /__ _/   .-` /  /\n" +
                " ======`-.____`-.___\\_____/___.-`____.-'======\n" +
                "                    `=---='\n" +
                "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" +
                "              Buddha Bless, No Bug !");
    }
}
