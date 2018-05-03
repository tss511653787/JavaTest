package Huawei_OnNiuKe;

import java.util.Optional;

public class TuiCe<T> {
	public static <T> T defaultValue() {
		return null;
	}

	public T getOrDefault(T value, T defaultValue) {
		return (value != null) ? value : defaultValue;
	}

	public static void main(String[] args) {
		// java8中更好的推测机制
		final TuiCe<String> value = new TuiCe<>();
		System.out.println(value.getOrDefault("22", TuiCe.defaultValue()));

		// 空置检测 很值得借鉴
		Optional<String> fullName = Optional.ofNullable("tom");
		// isPresent方法会返回这个对象是否是一个空对象 返回true/false
		System.out.println("Full Name is set? " + fullName.isPresent());
		System.out.println("Full Name: " + fullName.orElseGet(() -> "[none]"));
		System.out.println(fullName.map(s -> "Hey " + s + "!").orElse(
				"Hey Stranger!"));
	}
}
