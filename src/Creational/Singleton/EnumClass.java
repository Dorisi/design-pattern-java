package Creational.Singleton;

/**
 * 单例模式之枚举类
 *
 * 虽然这种方法还没有广泛采用，但是单元素的枚举类型已经成为实现Singleton的最佳方法。
 */
class Person{}

public enum EnumClass {
    INSTANCE;
    //定义私有的想要的单例对象
    private Person person=null;
    //构造器私有
    private EnumClass() {
        person=new Person();
    }
    //提供公共的访问方法
    public Person getPerson() {
        return person;
    }
}
