package Sina;

import java.util.LinkedList;
import java.util.Scanner;

public class TuiXiangSi {
	static Scanner sc = new Scanner(System.in);
	private static int sx, sy, ex, ey, bx, by;

	static class cur {
		public cur(int px, int py, int bx, int by) {
			this.px = px;
			this.py

			= py;
			this.bx = bx;
			this.by

			= by;
		}

		int px;
		int py;
		int bx;
		int by;
	}

	private static int bfs(char[][] data) {
		int N = data.length;
		int M = data[0].length;
		int[] moveX = { 1, -1, 0, 0 };
		int[] moveY = { 0, 0, 1, -1 };
		int[][][][] dfp = new int[50][50][50][50];
		LinkedList<cur> queue = new LinkedList<>();
		cur cur = new cur(sx, sy, bx, by);
		queue.add(cur);
		dfp[cur.px][cur.py

		][cur.bx][cur.by

		] = 1;
		while (queue.size() > 0) {
			cur ecur = queue.poll();
			if (ecur.bx == ex && ecur.by

			== ey)
				return dfp[ecur.px][ecur.py

				][ecur.bx][ecur.by

				] - 1;
			for (int i = 0; i < 4; i++) {
				int nx = ecur.px + moveX[i];
				int ny = ecur.py

				+ moveY[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M
						|| data[nx][ny] == '#')
					continue;
				if (nx == ecur.bx && ny == ecur.by

				) {
					int nbx = nx + moveX[i];
					int nby = ny + moveY[i];
					if (nbx < 0 || nbx >= N || nby < 0 || nby >= M
							|| data[nbx][nby] == '#'
							|| dfp[nx][ny][nbx][nby] != 0)
						continue;
					cur e = new cur(nx, ny, nbx, nby);
					dfp[nx][ny][nbx][nby] = dfp[ecur.px][ecur.py

					][ecur.bx][ecur.by

					] + 1;
					queue.add(e);
				} else {
					if (dfp[nx][ny][ecur.bx][ecur.by

					] != 0)
						continue;
					cur e = new cur(nx, ny, ecur.bx, ecur.by

					);
					dfp[nx][ny][ecur.bx][ecur.by

					] = dfp[ecur.px][ecur.py

					][ecur.bx][ecur.by

					] + 1;
					queue.add(e);
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		char[][] data = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			data[i] = str.toCharArray();
		}
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) {
				if (data[i][j] == 'S') {
					sx = i;
					sy = j;
				} else if (data[i][j] == '0') {
					bx = i;
					by = j;
				} else if (data[i][j] == 'E') {
					ex = i;
					ey = j;
				}
			}
		System.out.println(bfs(data));
	}

}
