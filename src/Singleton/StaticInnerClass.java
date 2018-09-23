package Singleton;

/**
 * 单例模式之静态内部类
 * 1.创建一个私有的静态的内部类
 * 2.构造器私有
 * 3.提供公共的访问方法
 *
 * 解决双重校验低性能问题，使用内部类来维护单例的实现，JVM内部的机制能够保证当一个类被加载的时候，
 * 这个类的加载过程是线程互斥的，这样当我们第一次调用getInstance的时候，JVM能够帮我们保证instance只被创建一次，
 * 并且会保证把赋值给instance的内存初始化完毕，这样我们就不用担心上面的问题，
 * 同时该方法也只会在第一次调用的时候使用互斥机制，这样就解决了低性能问题。
 */
public class StaticInnerClass {
    //创建一个私有的静态的内部类
    private static class StaticInnerClassHandler{
        //提供公共的方法创建对象
        public static StaticInnerClass getInstance(){
            return new StaticInnerClass();
        }
    }

    //构造器私有
    private StaticInnerClass(){}

    //提供公共的访问方法
    public static StaticInnerClass getInstance(){
        return StaticInnerClassHandler.getInstance();
    }
}
