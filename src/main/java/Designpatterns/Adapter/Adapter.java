package Designpatterns.Adapter;

//适配器模式的两种
//1 接口型适配器
/*2 继承一个类维持另一类引用的适配器
 * 通过是适配器类使得原本接口不匹配的两个类能在一起工作
 * eg：国内的电源和国外的电源
 * */
interface GermanyAdapterInterface {
	public void twoCharg();
}

abstract class GermanyAdapter {
	public abstract void twoCharg();
}

class ChinaAdapter {
	public static void threeCharg() {
		System.out.println("使用国产插头三向充电");
	}
}

// 现在有一个德国宾馆里面只提供了一个德国擦适配器可以充电
class GermanyHotel implements GermanyAdapterInterface {

	@Override
	public void twoCharg() {
		// TODO Auto-generated method stub
		System.out.println("使用德国2向插头充电");
	}

}

// 实现继承接口的适配器
class Adapter1 extends ChinaAdapter implements GermanyAdapterInterface {

	@Override
	public void twoCharg() {
		// TODO Auto-generated method stub
		this.threeCharg();
		System.out.println("开始适配");
		System.out.println("使用德国两向插头充电");
	}

}

class Adapter2 extends GermanyHotel {
	ChinaAdapter ad;

	public Adapter2(ChinaAdapter ad) {
		super();
		this.ad = ad;
	}

	@Override
	public void twoCharg() {
		// TODO Auto-generated method stub
		ad.threeCharg();
		System.out.println("开始适配");
		super.twoCharg();
	}
}

public class Adapter {
	// 测试类
	public static void main(String[] args) {
		Adapter1 ad1 = new Adapter1();
		ad1.twoCharg();
		Adapter2 ad2 = new Adapter2(new ChinaAdapter());
		ad2.twoCharg();
	}
}
