package Designpatterns.Adapter;

class Proxy implements Ishop {

	private Ishop ishop;

	public Proxy(Ishop ishop) {
		// TODO Auto-generated constructor stub
		this.ishop = ishop;
	}

	@Override
	public void buy() {
		// TODO Auto-generated method stub
		ishop.buy();
	}

	public static void main(String[] args) {
		Ishop tss = new Tss();
		Ishop proxy = new Proxy(tss);
		proxy.buy();
	}

}

class Tss implements Ishop {

	@Override
	public void buy() {
		// TODO Auto-generated method stub
		System.out.println("buy it");
	}

}

interface Ishop {
	void buy();
}
