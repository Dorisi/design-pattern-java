package Creational.Singleton;

/**
 * 单例模式之双重校验
 * 1.定义一个私有的静态的本类对象
 * 2.构造器私有
 * 3.提供公共的访问方法
 */
public class DubbleCheck {
    //定义一个私有的静态的本类对象
    private static DubbleCheck dubbleCheck=null;
    //构造器私有
    public DubbleCheck() { }
    //提供公共的访问方法
    /**
     * 将synchronized关键字加在了内部，调用的时候是不需要加锁的，
     * 只有在instance为null，并创建对象的时候才需要加锁，性能有一定的提升，但也没什么用！
     * @return
     */
    public static DubbleCheck getDubbleCheck() {
        if (dubbleCheck==null){
            synchronized (dubbleCheck){
                if (dubbleCheck==null){
                    dubbleCheck=new DubbleCheck();
                }
            }
        }
        return dubbleCheck;
    }
}
