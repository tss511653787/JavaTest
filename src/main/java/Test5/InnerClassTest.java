package Test5;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class InnerClassTest {

	public static void main(String[] args) {
		InnerClassTest begin = new InnerClassTest();
		TalkingClock clock = begin.new TalkingClock(1000, true);
		clock.start();
		JOptionPane.showMessageDialog(null, "quit program?");
		System.exit(0);

	}

	// 内部类实例
	class TalkingClock {
		private int interval;
		private boolean beep;

		public TalkingClock(int interval, boolean beep) {
			this.interval = interval;
			this.beep = beep;
		}

		private void start() {
			ActionListener listener = new TimePinter();
			Timer t = new Timer(interval, listener);
			t.start();
		}

		// 内部类
		public class TimePinter implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("at the tone , the time is " + new Date());
				if (beep) {
					Toolkit.getDefaultToolkit().beep();
				}
			}

		}

	}

}

// 静态内部类
class StaticInnerClass {
	public static void main(String[] args) {
		double[] d = new double[20];
		for (int i = 0; i < d.length; i++) {
			d[i] = 100 * Math.random();
		}
		ArrayAlg.Pair p = ArrayAlg.Pair.minmax(d);
		System.err.println("min=" + p.getFirst());
	}

}

class ArrayAlg {
	public static class Pair {
		private double first;
		private double second;

		public Pair(double first, double second) {
			this.first = first;
			this.second = second;
		}

		public double getFirst() {
			return first;
		}

		public void setFirst(double first) {
			this.first = first;
		}

		public double getSecond() {
			return second;
		}

		public void setSecond(double second) {
			this.second = second;
		}

		public static Pair minmax(double[] values) {
			double min = Double.POSITIVE_INFINITY;
			double max = Double.NEGATIVE_INFINITY;
			for (double d : values) {
				if (d > max)
					max = d;
				if (d < min)
					min = d;
			}
			return new Pair(min, max);
		}
	}
}
