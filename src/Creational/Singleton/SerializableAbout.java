package Creational.Singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 解决单例设计模式的序列化问题，使用静态内部类
 */
public class SerializableAbout implements Serializable {
    private static class SingletonClassInstance{
        private static final SerializableAbout serializableAbout=new SerializableAbout();
    }

    // 方法没有同步，调用效率高
    public static SerializableAbout getInstance(){
        return SingletonClassInstance.serializableAbout;
    }

    // 防止反序列化获取多个对象的漏洞。
    // 无论是实现Serializable接口，或是Externalizable接口，当从I/O流中读取对象时，readResolve()方法都会被调用到。
    // 实际上就是用readResolve()中返回的对象直接替换在反序列化过程中创建的对象。
    // 当你把对象存储到txt文件中，对象转换成字节码存储，当你在获取对象的数据的时候，字节码转换为该对象，但是这个对象已经不是
    // 之前的那个对象，所以用 readResolve可以替换成和之前一样的对象
    private Object readResolve() throws ObjectStreamException{
        return SingletonClassInstance.serializableAbout;
    }


}
