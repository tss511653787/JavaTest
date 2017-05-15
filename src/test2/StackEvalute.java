package test2;

import java.util.LinkedList;
import java.util.Stack;
//计算完全括号中缀表达式
//问题:没有实现超过1位的读取（只能个位数运算）

public class StackEvalute {
	public static double readAndEvalute(String input) {
		if (input == null) {
			return 0.0;
		} else {
			double answer = 0.0;
			// 假设每一个计算值为int类型
			// 定义一些操作符常量
			final String small_left = "(";
			final String small_right = ")";
			final String jia = "+";
			final String jian = "-";
			final String cheng = "*";
			final String chu = "/";
			Stack<String> cacu = new Stack<String>();
			Stack<Double> num = new Stack<Double>();
			int len_input = input.length();
			// 把输入先放入到一个数组里面
			String[] inputArr = ConverStr.convert(input);
			// 遍历
			for (String str : inputArr) {

				if (str.equals(small_left))
					continue;

				else if (str.equals(jia) || str.equals(jian)
						|| str.equals(cheng) || str.equals(chu)) {
					// 运算符入栈
					cacu.push(str);
				} else if (str.equals(small_right)) {
					// 遇到右括号开始计算
					Double[] out = new Double[2];
					String caculate = null;
					if (!num.isEmpty() && num.peek() != null) {
						out[1] = num.pop();
						out[0] = num.pop();
					}
					if (!cacu.isEmpty() && cacu.peek() != null) {
						caculate = cacu.pop();
					}
					switch (caculate) {
					case jia:
						double jiatemp = out[0] + out[1];
						num.push(jiatemp);
						break;
					case jian:
						double jiantemp = out[0] - out[1];
						num.push(jiantemp);
						break;
					case cheng:
						double chengtemp = out[0] * out[1];
						num.push(chengtemp);
						break;
					case chu:
						double chutemp = out[0] / out[1];
						num.push(chutemp);
						break;
					}

				} else {
					// 是double数字
					double in = Double.parseDouble(str);
					num.push(in);
				}
			}
			if (!num.isEmpty()) {
				answer = num.pop();
			}
			return answer;
		}
	}

	enum OperartorEnum {
		additive("+"), // 加号
		subtraction("-"), // 减号
		multiplication("*"), // 乘号
		division("/"), // 除号
		leftbracket("("), // 左括号
		rightbracket(")");// 右括号
		private String va;

		public String getVal() {
			return va;
		}

		OperartorEnum(String s) {
			va = s;
		}
	}

	public double CalculatePoix(String[] poArr) {
		double result = 0;
		double op1 = 0;
		double op2 = 0;
		LinkedList<String> list = new LinkedList<String>();// 构造一个运算符栈

		for (String ch : poArr) {
			// 如果遇到'+','-','*','/'，则计算
			if (ch.equals(OperartorEnum.additive.getVal())
					|| ch.equals(OperartorEnum.subtraction.getVal())
					|| ch.equals(OperartorEnum.multiplication.getVal())
					|| ch.equals(OperartorEnum.division.getVal())) {
				op2 = Double.valueOf(list.pop());// 先弹出的是第二个操作数，并删除
				op1 = Double.valueOf(list.pop());// 先弹出的是第二个操作数,并删除
				list.push(String.valueOf(CalculateExpression(op1, op2, ch)));// 计算值，再入栈
			} else {
				list.push(ch);// 否则为数字，直接进栈
			}
		}

		// 循环后，栈只剩下一个数字，即为最终的表达式的值
		result = Double.valueOf(list.pop());
		return result;
	}

	// 计算一个最简单的二元运算表达式
	public double CalculateExpression(double op1, double op2, String op) {
		double result = 0;
		if (op.equals(OperartorEnum.additive.getVal())) {
			result = op1 + op2;
		} else if (op.equals(OperartorEnum.subtraction.getVal())) {
			result = op1 - op2;
		} else if (op.equals(OperartorEnum.multiplication.getVal())) {
			result = op1 * op2;
		} else if (op.equals(OperartorEnum.division.getVal())) {
			result = op1 / op2;
		}
		return result;
	}

	// 将中缀表达式转化为后缀表达式
	public String[] ConvertIntoPofix(String[] inArr) {
		LinkedList<String> list = new LinkedList<String>();

		int index = 0;
		String poArr[] = new String[13];
		for (String s : inArr) {
			if (s != null) {
				// 如果是加号或者减号,将栈中操作符弹出，直到"("
				if (s.equals(OperartorEnum.additive.getVal())
						|| s.equals(OperartorEnum.subtraction.getVal())) {
					while (!list.isEmpty()) {
						String temp = list.getFirst();
						if (!temp.equals(OperartorEnum.leftbracket.getVal())) {
							poArr[index++] = list.pop();
						} else {
							break;
						}

					}
					list.push(s);
				}
				// 如果为乘号或者除号，则弹出栈顶的除号和乘号，直到"("
				else if (s.equals(OperartorEnum.multiplication.getVal())
						|| s.equals(OperartorEnum.division.getVal())) {
					while (!list.isEmpty()) {
						String temp = list.getFirst();
						// 如果为乘号，或者除号，并且不等于"("
						if ((temp.equals(OperartorEnum.multiplication.getVal()) || temp
								.equals(OperartorEnum.division.getVal()))
								&& (!temp.equals(OperartorEnum.leftbracket
										.getVal()))) {
							poArr[index++] = list.pop();
						} else {
							break;
						}
					}
					list.push(s);
				}
				// 遇到"(",直接进栈
				else if (s.equals(OperartorEnum.leftbracket.getVal())) {
					list.push(s);
				}
				// 如果遇到右括号，则将栈顶的操作符弹出，直到"(",再删除"("
				else if (s.equals(OperartorEnum.rightbracket.getVal())) {
					while (!list.isEmpty()) {
						String temp = list.getFirst();
						if (!temp.equals(OperartorEnum.leftbracket.getVal())) {
							poArr[index++] = list.pop();
						} else {
							break;
						}
					}
					list.pop();
				} else {
					poArr[index++] = s;
				}

				// System.out.println("后缀为:"+Arrays.toString(poArr)+",栈为:"+list
				// );
			}
		}

		while (!list.isEmpty()) {
			poArr[index++] = list.pop();
			// System.out.println("后缀为:"+Arrays.toString(poArr)+",栈为:"+list );
		}

		return poArr;
	}

	// 将一个字符串表达式转换为一个数组
	public String[] ConvertStringToArr(String s) {

		String arr[] = new String[s.length()];

		int index = 0;
		for (int i = 0; i < s.length();) {
			String ch = String.valueOf(s.charAt(i));
			if (ch.equals(OperartorEnum.additive.getVal())
					|| ch.equals(OperartorEnum.subtraction.getVal())
					|| ch.equals(OperartorEnum.multiplication.getVal())
					|| ch.equals(OperartorEnum.division.getVal())
					|| ch.equals(OperartorEnum.leftbracket.getVal())
					|| ch.equals(OperartorEnum.rightbracket.getVal())) {
				arr[index++] = ch;
				i++;
			} else {
				int end = SearchEnd(s, i);
				arr[index++] = s.substring(i, end);
				i = end;
			}
		}

		return arr;
	}

	private int SearchEnd(String s, int index) {
		int result = index;
		int i = 0;
		for (i = index; i < s.length(); i++) {
			String ch = String.valueOf(s.charAt(i));
			if (ch.equals(OperartorEnum.additive.getVal())
					|| ch.equals(OperartorEnum.subtraction.getVal())
					|| ch.equals(OperartorEnum.multiplication.getVal())
					|| ch.equals(OperartorEnum.division.getVal())
					|| ch.equals(OperartorEnum.leftbracket.getVal())
					|| ch.equals(OperartorEnum.rightbracket.getVal())) {

				result = i;
				break;
			}
		}
		if (i == s.length()) {
			result = s.length();
		}
		return result;
	}

	// 打印一个数组
	private void showArr(String[] arr) {

		for (String ss : arr) {
			System.out.println(ss != null ? ss : "");

		}

	}

	public static void main(String[] args) {
		String in = "(((6.0+90)/3)*(6.0-4))";
		System.out.println(readAndEvalute(in));
	}
}
