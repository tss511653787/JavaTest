package huawei;

public class Test {

    private static int pageNum = 0;
    private static String[] breakpoints = new String[20];
    private static int next = 0;
    private static int send = next;
    private static String sendTmpStr;


    //test
    public static void main(String[] args) {
        query(false, false, false);
        query(false, true, false);
        query(false, true, false);
        query(false, false, true);
        query(false, false, true);
        query(false, false, false);

    }

    public static void query(boolean isFirst, boolean isNext, boolean isPre) {
        if (isFirst || pageNum == 0) {
            //do on view
            cleanBreakpoints();
            sendTmpStr = "-";
        }
        if (isNext) {
            sendTmpStr = breakpoints[send];
        }
        if (isPre) {
            sendTmpStr = breakpoints[--send];
            next--;
            breakpoints[next] = "";
        }
        //send to gpath
        String backTmp = send2Gpath(sendTmpStr);
        if (!backTmp.isEmpty()) {
            pageNum++;
        }
        breakpoints[next] = backTmp;
        if (send == 0 && next == 0) {
            next++;
        } else {
            next++;
            send++;
        }
    }

    private static String send2Gpath(String sendTmpStr) {
        String rsp = (String) Gpath_send.newInstance().get(sendTmpStr);
        System.out.println(rsp);
        return rsp.split("-")[1];
    }

    public static void nextPage() {
        pageNum++;
        //do on Views
        query(false, true, false);
    }

    public static void prePage() {
        pageNum--;
        if (pageNum == 1) {
            //do on views
        }
        query(false, false, true);
    }

    public static void firstPage() {
        pageNum = 1;
        //do on view
        query(true, false, false);
    }

    public static void cleanBreakpoints() {
        for (int i = 0; i < breakpoints.length; i++) {
            breakpoints[i] = "";
        }
    }
}
