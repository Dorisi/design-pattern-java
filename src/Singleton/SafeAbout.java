package Singleton;

import java.io.Serializable;

/**
 * 有些安全问题，通过反射会访问单列的私有构造方法
 * 就加了一个方法，防止反射的
 */
public class SafeAbout implements Serializable {
}
