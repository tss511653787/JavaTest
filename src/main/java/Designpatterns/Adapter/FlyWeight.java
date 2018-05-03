package Designpatterns.Adapter;

import java.util.HashMap;
import java.util.Map;

//享元模式：
/*
 * 适用于存在大量很相似的对象
 * 池的重要实现手段
 * 细粒度对象都非常接近外部状态 而且每个对象没有特定的身份
 * */

public abstract class FlyWeight {
	public abstract void showPrice(String version);

	// test
	public static void main(String[] args) {
		Goods g1 = GoodsFactory.getGoods("iphone7");
		g1.showPrice("32G");
		Goods g2 = GoodsFactory.getGoods("iphone7");
		g2.showPrice("128G");
		Goods g3 = GoodsFactory.getGoods("iphone7");
		g3.showPrice("");
	}
}

class Goods extends FlyWeight {
	private String name;
	private int price;
	private String version;

	public Goods(String name) {
		super();
		this.name = name;
	}

	@Override
	public void showPrice(String version) {
		// TODO Auto-generated method stub
		// 通过不用的version实现不同价格
		if (version == "32G") {
			System.out.println("the price is 5199");
		} else if (version == "128G") {
			System.out.println("the price is 5999");
		} else {
			System.out.println("the price is 4199");
		}
	}
}

class GoodsFactory {
	private static Map<String, Goods> map = new HashMap<>();

	public static Goods getGoods(String name) {
		// 如果不包含这样的商品才加入
		if (map.containsKey(name)) {
			System.out.println("使用缓存:");
			return map.get(name);
		} else {
			Goods goods = new Goods(name);
			map.put(name, goods);
			System.out.println("创建新商品:");
			return goods;
		}
	}
}