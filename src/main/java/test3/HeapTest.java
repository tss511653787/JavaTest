package test3;

/*
 * 堆ADT测试
 * */
public class HeapTest {
	public static void main(String[] args) {
		HeapElement e1 = new HeapElement(1, "abc");
		HeapElement e2 = new HeapElement(2, "vvv");
		HeapElement e3 = new HeapElement(7, "kkk");
		HeapElement e4 = new HeapElement(4, "fff");
		HeapElement e5 = new HeapElement(6, "ggg");
		HeapADT ad = new HeapADT();
		ad.insertInHeap(e1);
		ad.insertInHeap(e2);
		ad.insertInHeap(e3);
		ad.insertInHeap(e4);
		ad.insertInHeap(e5);
		HeapElement out = ad.outOfHeap();
		System.out.println(out.getPriority() + " " + out.getData());
		HeapElement out2 = ad.outOfHeap();
		System.out.println(out2.getPriority() + " " + out2.getData());
		HeapElement out3 = ad.outOfHeap();
		System.out.println(out3.getPriority() + " " + out3.getData());
		ad.insertInHeap(e4);
		ad.insertInHeap(e5);
		HeapElement out4 = ad.outOfHeap();
		System.out.println(out4.getPriority() + " " + out4.getData());
		HeapElement out5 = ad.outOfHeap();
		System.out.println(out5.getPriority() + " " + out5.getData());
	}
}
