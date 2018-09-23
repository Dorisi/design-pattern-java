package Singleton;

/**
 * 单例模式之饿汉模式
 * 1.创建一个私有的静态的本类对象
 * 2.构造器私有
 * 3.提供公共的访问方法
 *
 * 特点：线程安全
 */
public class HungryPerson {
    //创建一个私有的静态的本类对象
    private static HungryPerson hungryPerson=new HungryPerson();
    //构造器私有
    private HungryPerson(){}
    //提供公共的访问方法
    public static HungryPerson getHungryPerson() {
        return hungryPerson;
    }
}
