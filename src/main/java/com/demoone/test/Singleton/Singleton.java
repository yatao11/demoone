package com.demoone.test.Singleton;

/**
 * @author yatao.zhang
 * @version 1.0
 * @since 2019/07/12 13:41
 */

/**
 * 普通单例模式
 */
public class Singleton  {

	private Singleton() {}

	public static Singleton getSingleton(){
		return IntancesSingleton.singleton;
	}

	private static class IntancesSingleton {
		static Singleton singleton = new Singleton();
	}
}
