package Creational.SimpleFactory.SimpleFactory02;
/**
 * 抽象类
 * @author Cherry
 *
 */
public abstract class User {
	public void sameOperation() {
		System.out.println("修改个人资料！");
	}
	public abstract void diffOperation();
}
