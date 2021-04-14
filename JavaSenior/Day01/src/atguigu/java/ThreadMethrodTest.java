package atguigu.java;

/**
 * 1.start():启动当前线程；调用当前线程的run()
 * 2.run():通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3.currentThread():静态方法，返回执行当前代码的线程
 * 4.getName():获取当前线程的名字
 * 5.setName():设置当前线程的名字
 * 6.yield():释放当前CPU的执行权
 * 7.join():在线程a中调用线程b的join()，此时线程a就进入阻塞状态，直到线程b完全执行完以后，线程a才结束阻塞状态
 * 8.stop():已过时，强制结束当前线程
 * 9.sleep(long millitime)：让当前线程“睡眠”指定的millitime毫秒。在指定的millitime毫秒时间内，当前线程是阻塞状态。
 * 10.isAlive():判断当前线程是否存活
 * <p>
 * 线程优先级：
 *
 * @author chenglongsheng
 * @create 2021-04-02 11:18
 */
class HelloThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                try {
                    sleep(1000);//单位毫秒-》1s=1000ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + "" + i);
            }
            if (i % 20 == 0) {
                yield();
            }
        }
    }

    public HelloThread(String name) {
        super(name);

    }
}

public class ThreadMethrodTest {
    public static void main(String[] args) {
        HelloThread h1 = new HelloThread("Thread1");
//        h1.setName("线程一");
        h1.setPriority(Thread.MAX_PRIORITY);
        h1.start();
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            if (i == 20) {
                try {
                    h1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
//        System.out.println(h1.isAlive());
    }
}
