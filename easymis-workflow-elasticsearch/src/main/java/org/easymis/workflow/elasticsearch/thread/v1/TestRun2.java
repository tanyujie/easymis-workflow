package org.easymis.workflow.elasticsearch.thread.v1;
/**
实现Runnable接口创建线程类
 */
public class TestRun2 {

	public static void main(String[] args) {
		Runnable oneRunnable = new SomeRunnable();
		Thread oneThread = new Thread(oneRunnable);
		oneThread.start();
	}

}
