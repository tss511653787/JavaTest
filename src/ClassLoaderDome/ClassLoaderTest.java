package ClassLoaderDome;

import java.io.InputStream;

public class ClassLoaderTest {
	// 自定义一个类加载器加载一个一个类(这里用作本类)
	// 和已经加在的本列比较观察结果
	// 结论：不同类加载器加载的类不同

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		// TODO Auto-generated method stub
		// 自定义一个类加载器
		ClassLoader myloader = new ClassLoader() {
			// 并不提倡用户重载loadclass方法 因为会破坏双亲委派模型
			@Override
			public Class<?> loadClass(String name)
					throws ClassNotFoundException {
				// TODO Auto-generated method stub
				try {
					String filename = name + ".class";
					InputStream is = getClass().getResourceAsStream(filename);
					if (is == null) {
						return super.loadClass(name);
					}
					byte[] b = new byte[is.available()];
					is.read(b);
					String packageName = getClass().getPackage().getName();
					return defineClass(packageName + "." + name, b, 0, b.length);

				} catch (Exception e) {
					// TODO: handle exception
				}
				return null;
			}

			@Override
			protected Class<?> findClass(String name)
					throws ClassNotFoundException {
				// TODO Auto-generated method stub
				return super.findClass(name);
			}
		};
		Object obj = myloader.loadClass("ClassLoaderTest").newInstance();
		System.out.println(obj.getClass());
		System.out.println(obj instanceof ClassLoaderDome.ClassLoaderTest);

	}

}
