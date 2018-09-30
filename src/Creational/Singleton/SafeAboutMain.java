package Creational.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SafeAboutMain {
	public static void main(String[] args) {
		/**
	     * 通过反射的方式直接调用私有构造器（通过在构造器里抛出异常可以解决此漏洞）
	     */
	    try {
			Class<SafeAbout> clazz = SafeAbout.class;
			Constructor<SafeAbout> c = clazz.getDeclaredConstructor(null);
			c.setAccessible(true); // 跳过权限检查
			SafeAbout sc3 = c.newInstance();
			SafeAbout sc4 = c.newInstance();
			System.out.println(sc3==sc4);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
