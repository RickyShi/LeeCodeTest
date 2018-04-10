package repo_2014.producerCustomer;

	import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

	/**
	 * 1个生产者 3个消费者 生产、消费10次
	 */

public class ProducerCustomer {
		Stack<Integer> items = new Stack<Integer>();
		final static int NO_ITEMS = 10;

		public static void main(String args[]) {
		ProducerCustomer pc = new ProducerCustomer();
		Thread t1 = new Thread(pc.new Producer());
		Consumer consumer = pc.new Consumer();
			Thread t2 = new Thread(consumer);
			Thread t3 = new Thread(consumer);
			Thread t4 = new Thread(consumer);
			t1.start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			t2.start();
			t3.start();
			t4.start();
			try {
				t2.join();
				t3.join();
				t4.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	class Producer implements Runnable {
		public void produce(int i) {
			System.out.println("Producing " + i);
			items.push(new Integer(i));
		}

		@Override
		public void run() {
			int i = 0;
			// 生产10次
			while (i++ < NO_ITEMS) {
				synchronized (items) {
					produce(i);
					items.notifyAll();
			}
				try {
					// 休眠一段时间
					Thread.sleep(10);
				} catch (InterruptedException e) {
			}
		}
		}
	}

	class Consumer implements Runnable {
		// consumed计数器允许线程停止
		AtomicInteger consumed = new AtomicInteger();

		public void consume() {
			if (!items.isEmpty()) {
				System.out.println("Consuming " + items.pop());
				consumed.incrementAndGet();
				// System.out.println("AtomicInteger " + consumed);
			}
		}

		private boolean theEnd() {
			return consumed.get() >= NO_ITEMS;
		}

		@Override
		public void run() {
			while (!theEnd()) {
				synchronized (items) {
					while (items.isEmpty() && (!theEnd())) {
						try {
							items.wait(10);
						} catch (InterruptedException e) {
							Thread.interrupted();
						}
					}
					consume();

				}
			}
		}
	}
	}
