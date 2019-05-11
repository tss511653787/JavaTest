package test;

/**
 * @author tss2019
 * @version 1.0
 * @date 2019/5/11
 */
public class AboutList {
    /**
     * main test
     */
    public static void main(String[] args) {
    }

    public static Mylist insertInList(Mylist head, int data, int index) {
        if (index == 0) {
            return new Mylist(data, head);
        }
        Mylist parent = findParent(head, index);
        Mylist in = new Mylist(data, parent.getNext());
        parent.setNext(in);
        return head;
    }

    public static Mylist deleteInList(Mylist head, int index) {
        if (0 == index) {
            return head.getNext();
        }
        Mylist parent = findParent(head, index);
        parent.setNext(parent.getNext().getNext());
        return head;
    }

    /**
     * revert list
     */
    public static Mylist[] revertList(Mylist head) {
        if (null == head.getNext()) {
            return null;
        }
        Mylist[] res = new Mylist[2];
        //insert head
        Mylist p = head;
        Mylist q = p.getNext();
        while (q != null) {
            Mylist node = new Mylist(q.getValue(), p);
            p = node;
            q = q.getNext();
        }
        head.setNext(null);
        res[0] = p;
        //revert
        Mylist k = head;
        Mylist l = k.getNext();
        Mylist r = l.getNext();
        while (r != null) {
            l.setNext(k);
            k = l;
            l = r;
            r = r.getNext();
        }
        l.setNext(k);
        head.setNext(null);
        res[1] = l;

        return res;
    }

    private static Mylist initailList() {
        return new Mylist(1, new Mylist(2, new Mylist(3, new Mylist(4, null))));
    }

    public static Mylist findParent(Mylist head, int index) {
        Mylist res = head;
        for (int i = 0; i < index - 1; i++) {
            res = res.getNext();
        }
        return res;
    }

}

class Mylist {
    private int value;
    private Mylist next;
    private int size;

    public Mylist(int value, Mylist next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Mylist getNext() {
        return next;
    }

    public void setNext(Mylist next) {
        this.next = next;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void print() {
        System.out.print(value + " ");
        if (null != next) {
            next.print();
        }
    }

    @Override
    public String toString() {
        return "Mylist{" +
                "value=" + value +
                ", next=" + next +
                ", size=" + size +
                '}';
    }
}
