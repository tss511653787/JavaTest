package Alibaba_NeiTui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.mysql.fabric.xmlrpc.base.Array;

public class FindMax {
	public static void main(String[] args) {

		ArrayList<Integer> _ids = new ArrayList<Integer>();
		ArrayList<Integer> _parents = new ArrayList<Integer>();
		ArrayList<Integer> _costs = new ArrayList<Integer>();

		Scanner in = new Scanner(System.in);
		String line = in.nextLine();

		while (line != null && !line.isEmpty()) {
			if (line.trim().equals("0"))
				break;
			String[] values = line.trim().split(" ");
			if (values.length != 3) {
				break;
			}
			_ids.add(Integer.parseInt(values[0]));
			_parents.add(Integer.parseInt(values[1]));
			_costs.add(Integer.parseInt(values[2]));
			line = in.nextLine();
		}
		int res = resolve(_ids, _parents, _costs);

		System.out.println(String.valueOf(res));
	}

	// write your code here
	public static int resolve(ArrayList<Integer> ids,
			ArrayList<Integer> parents, ArrayList<Integer> costs) {
		int res;
		int num = ids.size();
		int[][] matrix = new int[num][num];
		// 矩阵初始化全为0
		for (int i = 0; i < num; i++) {
			matrix[i][i] = costs.get(i);
		}
		for (int j = 0; j < num; j++) {
			int parent = parents.get(j);
			if (parent != 0) {
				int parentValue = costs.get(parent - 1);
				matrix[j][parent - 1] = parentValue;
			}
		}
		int[] matrixRow = new int[num];
		for (int n = 0; n < num; n++) {
			for (int m = 0; m < num; m++) {
				matrixRow[n] += matrix[n][m];
			}
		}
		// find max
		res = matrixRow[0];
		for (int i = 0; i < matrixRow.length; i++) {
			if (matrixRow[i] > res)
				res = matrixRow[i];
		}
		return res;

	}

}
