package test2;

public class IntDataNodeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 创建一个链表 2，3，4，5
		// 定义头句柄head
		IntDataNode head;
		IntDataNode aNew = new IntDataNode(5, null);
		head = aNew;
		head.InsetBeforeHead(4);
		head.InsetBeforeHead(3);
		head.InsetBeforeHead(2);
		IntDataNode.PrintIntNode(head);
		System.out.println();

		head = head.DeleteInHead(head);
		IntDataNode.PrintIntNode(head);
		System.out.println();
		IntDataNode find = IntDataNode.SearchNode(head, -1);
		if (find != null) {
			System.out.println(find.getData());
		} else {
			System.out.println("Not find");
		}

		head.InsetBeforeHead(2);
		IntDataNode.PrintIntNode(head);
		System.out.println();
		head.InsetBeforeHead(6);
		IntDataNode.PrintIntNode(head);

		IntDataNode selection = IntDataNode.SearchNode(head, 3);
		selection.InsetAfterNode(77);
		System.out.println();
		IntDataNode.PrintIntNode(head);

		selection.DeleteAfterNode();
		System.out.println();
		IntDataNode.PrintIntNode(head);

		System.out.println();
		System.out.println(IntDataNode.listLengthAll(head));
		System.out.println(IntDataNode.listlength(head));
		// 2017.3.7
		System.out.println("2017/3/7");
		System.out.println(IntDataNode.SearchNode(head, 3).getData());
		System.out.println(IntDataNode.SearchNodeAll(head, 3).getData());
		System.out.println(IntDataNode.listPosition(head, 1).getData());
		System.out.println();
		IntDataNode.PrintIntNode(IntDataNode.listCopy(head));
		System.out.println();
		IntDataNode arrNode[] = IntDataNode.listCopyAll(head);
		System.out.println("listcopyall out:");

		IntDataNode copylist = arrNode[0];
		System.out.println();
		IntDataNode.PrintIntNode(copylist);
		System.out.println();
		IntDataNode.PrintIntNode(IntDataNode.deleteWithHead(copylist, 4));

		System.out.println();
		System.out.println("2017/3/8");
		IntDataNode copytest1 = IntDataNode.listCopy(copylist);
		IntDataNode.PrintIntNode(copytest1);
		System.out.println();
		IntDataNode.PrintIntNode(IntDataNode.addAll(copylist, copytest1));

	}
}
