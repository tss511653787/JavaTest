package huawei;

import java.util.HashMap;
import java.util.Map;

//发送分页信息
public class Gpath_send {
    private static Gpath_send g;
    private static Map<String, String> sendMap = null;

    private Gpath_send() {
    }

    public static Map newInstance() {
        if (g == null) {
            g = new Gpath_send();
        }
        if (sendMap == null) {
            sendMap = new HashMap<>();
            sendMap.put("-", "is-1");
            sendMap.put("1", "is-2");
            sendMap.put("2", "is-3");
            sendMap.put("3", "is-4");
            return g.getMap();
        } else {
            return g.getMap();
        }
    }

    public static String returnPage(String breakpoint) {
        if (sendMap.containsKey(breakpoint)) {
            return sendMap.get(breakpoint);
        } else {
            System.out.println("no match in sendMap!");
            return "";
        }
    }

    private Map getMap() {
        return sendMap;
    }
}
