package Alibaba_2018;

import java.util.Scanner;

public class ProGram1 {
    static final int CUSTOMS_LIMIT_MONEY_PER_BOX = 2000;
    static Model[] items;
    static int boxMinNum;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        BoxTemplate boxTemplate = new BoxTemplate();

        boxTemplate.price = CUSTOMS_LIMIT_MONEY_PER_BOX;

        while (scanner.hasNext()) {
            boxTemplate.length = scanner.nextInt();
            boxTemplate.width = scanner.nextInt();
            boxTemplate.height = scanner.nextInt();

            int itemNum = scanner.nextInt();


            items = new Model[itemNum];
            for (int i = 0; i < itemNum; i++) {
                Model item = new Model();
                item.price = scanner.nextInt();
                item.length = scanner.nextInt();
                item.width = scanner.nextInt();
                item.height = scanner.nextInt();
                items[i] = item;
            }
            long startTime = System.currentTimeMillis();
            boxMinNum = Integer.MAX_VALUE;
            System.out.println(process(itemNum, boxTemplate, items, boxMinNum));

        }
    }

    // process
    private static int process(int itemNum, BoxTemplate boxTemplate,
                               Model[] items, int boxMinNum) {
        int areaA = boxTemplate.width * boxTemplate.length;
        int areaB = boxTemplate.width * boxTemplate.height;
        int areaC = boxTemplate.length * boxTemplate.height;
        int boxNum = 1;
        int sumPrice = 0;
        int boxheight = boxTemplate.height;
        int boxwidth = boxTemplate.width;
        int boxlength = boxTemplate.width;
        int length;
        int width;
        int height;
        int areaA_model;
        int areaB_model;
        int areaC_model;
        for (Model model : items) {
            length = model.length;
            width = model.width;
            height = model.height;
            areaA_model = width * length;
            areaB_model = width * height;
            areaC_model = length * height;
            int A = -1;
            if (areaA > areaA_model) {
                A = areaA - areaA_model;
            }
            int B = -1;
            if (areaB > areaB_model) {
                B = areaB - areaB_model;
            }
            int C = -1;
            if (areaC > areaC_model) {
                C = areaC - areaC_model;
            }
            int max = findMax(A, B, C);
            if (max == A) {
                height = height - model.height;
                if (height <= 0) {
                    boxNum++;
                    boxheight = boxTemplate.height;
                }
            } else if (max == B) {
                length = length - model.length;
                if (length <= 0) {
                    boxNum++;
                    boxlength = boxTemplate.length;
                }
            } else {
                width = width - model.width;
                if (width <= 0) {
                    boxNum++;
                    boxwidth = boxTemplate.width;
                }
            }
        }

        for (Model m : items) {
            sumPrice += m.price;
        }
        if (sumPrice > boxTemplate.price) {
            // 必须至少2个箱子发货
            if (boxNum < 2) {
                boxNum = 2;
            }
        }
        return boxNum;
    }

    public static int findMax(int a, int b, int c) {
        // TODO Auto-generated method stub
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max)
            max = c;
        return max;
    }
}

// 物品大小
class Model {
    int length;
    int width;
    int height;
    int price;
}

// 箱子大小
class BoxTemplate {
    int length;
    int width;
    int height;
    int price;
}
