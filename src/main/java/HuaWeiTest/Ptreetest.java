package HuaWeiTest;

public class Ptreetest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PTree root = new PTree(0, 10, null, null);
		root.flag=true;
		root.leftchild = new PTree(1, 15, null, null);
		root.rightchild = new PTree(20, 20, null, null);
		root.leftchild.leftchild = new PTree(6, 6, null, null);
		root.leftchild.rightchild = new PTree(7, 7, null, null);
		System.out.println(MicroSoft.caculate(root));
	}
}
