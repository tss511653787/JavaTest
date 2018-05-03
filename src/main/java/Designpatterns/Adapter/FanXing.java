package Designpatterns.Adapter;

import java.util.ArrayList;
import java.util.List;

//泛型的通配符?匹配是里尸转换原则的最好体现

public class FanXing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<? extends Fruit> list = new ArrayList<>();
		List<? super Apple> list2 = new ArrayList<>();
		
	}

}

class Fruit {

}

class Apple extends Fruit {
}

class ShenYangApple extends Apple {
}
