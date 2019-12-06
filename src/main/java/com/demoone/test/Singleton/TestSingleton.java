package com.demoone.test.Singleton;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yatao.zhang
 * @version 1.0
 * @since 2019/07/12 13:45
 */
public class TestSingleton {

	boolean lock;

	public boolean isLock() {
		return lock;
	}

	public void setLock(boolean lock) {
		this.lock = lock;
	}

		public static void main(String[] args) throws InterruptedException{
		//synchronizedSet() 方法用于返回一个同步的(线程安全的)有序set由指定的有序set支持。
		final Set<String> instanceSet = Collections.synchronizedSet(new HashSet<String>());
		final  TestSingleton lock = new TestSingleton();
		lock.setLock(true);
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i=1;i<=30;i++){
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					while (true){
						if (!lock.isLock()){
							Singleton singleton = Singleton.getSingleton();
							instanceSet.add(singleton.toString());
							break;
						}
					}
				}
			});
		}

		Thread.sleep(5000);
		lock.setLock(false);
		Thread.sleep(5000);
		System.out.println("------并发情况下我们取到的实例------");
		for (String s: instanceSet) {
			System.out.println(s);
		}

		executorService.shutdown();
	}
}
