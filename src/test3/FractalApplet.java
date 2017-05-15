package test3;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class FractalApplet extends Applet {
	// 编写一个applet小程序 实现画图分形
	private Image dispaly;
	private Graphics drawingArea;

	@Override
	public void init() {
		// 重写init方法实现Image的初始化
		// TODO Auto-generated method stub
		int hight = getSize().height;
		int width = getSize().width;
		dispaly = createImage(width, hight);
		drawingArea = dispaly.getGraphics();
		System.out.println(hight + " " + width);
		// 调用递归
		// 初始值
		randomFractal(0, hight / 2, width, hight / 2, drawingArea);

	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		// 重写paint方法实现在display上画图
		// 从坐上角0，0点开始
		g.drawImage(dispaly, 0, 0, null);

	}

	public static void randomFractal(int leftX, int leftY, int rightX,
			int rightY, Graphics drawingArea) {
		final int stop = 4;// 横坐标之差小于4则停止
		int midX, midY;
		int delta;// 分形增量
		if ((rightX - leftX) <= stop) {
			drawingArea.drawLine(leftX, leftY, rightX, rightY);
		} else {
			midX = (leftX + rightX) / 2;
			midY = (leftY + rightY) / 2;
			delta = (int) ((Math.random() - 0.5) * (rightX - leftX));
			midY += delta;
			// 递归调用
			randomFractal(leftX, leftY, midX, midY, drawingArea);
			randomFractal(midX, midY, rightX, rightY, drawingArea);
		}

	}
}
