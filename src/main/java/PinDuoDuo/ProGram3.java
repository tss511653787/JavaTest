package PinDuoDuo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

;

public class ProGram3 {
	static Scanner scanner = new Scanner(System.in);
	static List<Good> goods = new ArrayList<Good>();
	static List<Good> GoodsActiviys = new ArrayList<>();
	static int timeStamp = 0;

	// test
	public static void main(String[] args) {
		String[] in1 = scanner.nextLine().split("\\s+");
		int N = Integer.parseInt(in1[0]);
		int M = Integer.parseInt(in1[1]);
		// inital
		for (int i = 0; i < N; i++) {
			String[] in = scanner.nextLine().split("\\s+");
			int id = Integer.parseInt(in[0]);
			int hot = Integer.parseInt(in[1]);
			int count = Integer.parseInt(in[2]);
			Good good = new Good(id, hot, count);
			goods.add(good);
		}
		// request
		for (int j = 0; j < M; j++) {
			String[] request = scanner.nextLine().split("\\s+");
			int nowtime = Integer.parseInt(request[0]);
			timeStamp = nowtime;
			String dispather = request[1];
			if (dispather.equals("add")) {
				int startTime = Integer.parseInt(request[2]);
				int endTime = Integer.parseInt(request[3]);
				int goodsId = Integer.parseInt(request[4]);
				int LimitQuantity = Integer.parseInt(request[5]);
				System.out.println(addActivity(startTime, endTime, goodsId,
						LimitQuantity));
			} else if (dispather.equals("buy")) {
				int activityId = Integer.parseInt(request[2]);
				int quality = Integer.parseInt(request[3]);
				System.out.println(buyGoods(activityId, quality));
			} else if (dispather.equals("list")) {
				getActivityList();
			}
		}
	}

	public static Good serachGoodIn(int goodsId, List<Good> list) {
		for (Good g : list) {
			if (g.id == goodsId) {
				return g;
			}
		}
		return null;
	}

	public static int addActivity(int startTime, int endTime, int goodsId,
			int LimitQuantity) {
		if (!(startTime < endTime) || startTime <= timeStamp) {
			return -1;
		}
		// 已经添加
		if ((serachGoodIn(goodsId, GoodsActiviys)) != null) {
			return -1;
		}
		Good good = serachGoodIn(goodsId, goods);
		if (LimitQuantity > good.count || LimitQuantity <= 0) {
			return -1;
		}
		// add
		good.startTime = startTime;
		good.endTime = endTime;
		GoodsActiviys.add(good);
		good.location = GoodsActiviys.size() - 1;
		return GoodsActiviys.size() - 1;
	}

	public static int buyGoods(int activityId, int quality) {
		Good good = GoodsActiviys.get(activityId);
		// 不存在
		if (good == null) {
			return -1;
		}
		int count = good.count;
		if (quality > count) {
			return -1;
		}
		// 秒杀未开始或已经结束
		if (timeStamp < good.startTime || timeStamp >= good.endTime) {
			return -1;
		}
		// 购买成功
		good.count = good.count - quality;
		good.outTime = timeStamp;
		return 0;
	}

	public static void getActivityList() {
		Collections.sort(GoodsActiviys, new Comparator<Good>() {

			@Override
			public int compare(Good o1, Good o2) {
				// TODO Auto-generated method stub
				if (o1.count == 0 && o2.count != 0) {
					return 1;
				} else if (o1.count != 0 && o2.count == 0) {
					return -1;
				} else {
					// dou mei shou qing
					if (o1.count != 0 && o2.count != 0) {
						if (o1.hot > o2.hot) {
							return -1;
						} else if (o1.hot < o2.hot) {
							return 1;
						} else {
							if (o1.id < o2.id) {
								return -1;
							} else {
								return 1;
							}
						}
					} else if (o1.count == 0 && o2.count == 0) {
						if (o1.outTime < o2.outTime) {
							return -1;
						} else if (o1.outTime > o2.outTime) {
							return 1;
						} else {
							if (o1.hot > o2.hot) {
								return -1;
							} else if (o1.hot < o2.hot) {
								return 1;
							} else {
								if (o1.id < o2.id) {
									return -1;
								} else {
									return 1;
								}
							}
						}
					} else {
						// wei kai shi
						if (o1.startTime < o2.startTime) {
							return -1;
						} else if (o1.startTime > o2.startTime) {
							return 1;
						} else {
							if (o1.hot > o2.hot) {
								return -1;
							} else if (o1.hot < o2.hot) {
								return 1;
							} else {
								if (o1.id < o2.id) {
									return -1;
								} else {
									return 1;
								}
							}
						}
					}
				}
			}

		});
		for (int i = 0; i < GoodsActiviys.size(); i++) {
			if (i == GoodsActiviys.size() - 1) {
				System.out.print(GoodsActiviys.get(i).location);
			} else {
				System.out.print(GoodsActiviys.get(i).location + " ");
			}
		}
		System.out.println();
	}
}

// product class
class Good {
	int id;
	int hot;
	int count;
	int outTime;
	int startTime;
	int endTime;
	int location;

	public Good(int id, int hot, int count) {
		super();
		this.id = id;
		this.hot = hot;
		this.count = count;
	}

}
