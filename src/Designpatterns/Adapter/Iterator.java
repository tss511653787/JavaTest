package Designpatterns.Adapter;

import java.util.ArrayList;

/*
 * 迭代器模式
 * 继承java.util.iterator迭代器接口
 * 实现对类的遍历 添加和删除
 * 注意：java中的迭代器模式已经非常完善了  所以很少需要自己写迭代器实现
 * */

public interface Iterator<E> extends java.util.Iterator<E> {

}

class PersonInIt implements Iterator<PersonInIt> {
	private static ArrayList<PersonInIt> list = new ArrayList<>();
	private int currentItem;

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		boolean falg = true;
		if (this.currentItem > list.size()
				|| this.list.get(this.currentItem) == null)
			falg = false;
		return falg;
	}

	@Override
	public PersonInIt next() {
		// TODO Auto-generated method stub
		return list.get(currentItem + 1);
	}

}
