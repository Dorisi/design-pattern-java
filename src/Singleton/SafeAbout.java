package Singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 有些安全问题，通过反射会访问单列的私有构造方法
 * 就加了一个方法，防止反射的
 */
public class SafeAbout implements Serializable {
	private static class SingletonClassInstance{
        private static final SafeAbout safeAbout=new SafeAbout();
    }
	// 方法没有同步，调用效率高
    public static SafeAbout getInstance(){
        return SingletonClassInstance.safeAbout;
    }
    
    // 防止反射获取多个对象的漏洞
    // 这种抛异常的方法解决了反射入侵的问题
    private SafeAbout() {
		 if (null != SingletonClassInstance.safeAbout) {
			 throw new RuntimeException();
		 }
	}
    // 防止反序列化获取多个对象的漏洞。
    // 无论是实现Serializable接口，或是Externalizable接口，当从I/O流中读取对象时，readResolve()方法都会被调用到。
    // 实际上就是用readResolve()中返回的对象直接替换在反序列化过程中创建的对象。
    // 当你把对象存储到txt文件中，对象转换成字节码存储，当你在获取对象的数据的时候，字节码转换为该对象，但是这个对象已经不是
    // 之前的那个对象，所以用 readResolve可以替换成和之前一样的对象
    private Object readResolve() throws ObjectStreamException {
        return SingletonClassInstance.safeAbout;
    }
}
