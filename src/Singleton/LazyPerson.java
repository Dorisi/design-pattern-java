package Singleton;

/**
 * 单例模式之懒汉模式
 * 1.定义一个私有静态的本类对象
 * 2.构造器私有
 * 3.对外提供公共的访问方法
 *
 * 特点：
 * 1.线程不安全（异步）
 * 2.可以加锁（synchronized）实现同步，但是影响效率
 */
public class LazyPerson {
    //定义一个私有的静态的本类对象
    private static LazyPerson lazyPerson=null;
    //构造器私有
    private LazyPerson(){ }
    //对外提高公共的访问方法
    //如果对象为空则创建对象
    public static LazyPerson getLazyPerson() {
        if (lazyPerson==null){
            lazyPerson=new LazyPerson();
        }
        return lazyPerson;
    }
}
