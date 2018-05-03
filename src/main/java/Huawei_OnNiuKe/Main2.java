package Huawei_OnNiuKe;

import java.util.*;

/**
 * Created by tzy on 2017/8/3.
 */
public class Main2 {
    public static boolean isBrother(String string1,String string2){
        char[] strings1=string1.toCharArray();
        char[] strings2=string2.toCharArray();
        Arrays.sort(strings1);
        Arrays.sort(strings2);
        if (new String(strings1).equals(new String(strings2)))
            return true;
        else
            return false;
    }
    public static ArrayList<String> Brothers(String string,ArrayList<String> arrayList){
        ArrayList<String> broters=new ArrayList<>();
        for (String s:arrayList) {
            if (isBrother(string,s)&&!string.equals(s))
                broters.add(s);
        }
        //broters.sort(Comparator.naturalOrder());
        Collections.sort(broters);
        return broters;
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while (input.hasNext()){
            ArrayList<String> arrayList=new ArrayList<>();
            int n=input.nextInt();
            for (int i = 0; i <n ; i++) {
                String string=input.next();
                arrayList.add(string);
            }
            String string1=input.next();
            int index=input.nextInt();
            long start=System.nanoTime();

            ArrayList<String>brothers=Brothers(string1,arrayList);
            System.out.println(brothers.size());
            if (index<=brothers.size()&&index>0)
                System.out.println(brothers.get(index-1));
            long time=(System.nanoTime()-start);

            System.out.println(time+" ns");
            System.out.println(time/1_000_000+" ms");
        }
    }
}
