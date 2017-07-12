package Huawei_OnNiuKe;

import java.lang.annotation.Repeatable;

public class RepeatAnnotations {
	public @interface Filters {
		Filter value();
	}

	public @interface Filter {
		String value();
	}

	// @Repeatable
	// public static void fun1() {
	//
	// }

}
