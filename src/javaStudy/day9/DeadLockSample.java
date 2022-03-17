package javaStudy.day9;

public class DeadLockSample {
    public static Object memoryA = new Object();
    public static Object memoryB = new Object();

    public static void main(String args[]) {
        Thread2 t2 = new Thread2();
        Thread3 t3 = new Thread3();
        t2.start();
        t3.start();
    }

    private static class Thread2 extends Thread {
        public void run() {
            synchronized (memoryA) {
                System.out.println("Thread2는 공유 자원(A) 점유(사용)하고 있습니다.");

                try { Thread.sleep(100); }
                catch (InterruptedException e) {}

                System.out.println("Thread2는 공유자원(B) 사용 대기중입니다. : " + this.getState());

                synchronized (memoryB) {
                    System.out.println("작업을 못해요");
                }
            }
        }
    }

    private static class Thread3 extends Thread {
        public void run() {
            synchronized (memoryB) {
                System.out.println("Thread3는 공유 자원(B) 점유(사용)하고 있습니다.");

                try { Thread.sleep(100); }
                catch (InterruptedException e) {}

                System.out.println("Thread3는 공유자원(A) 사용 대기중입니다. : "+ this.getState());

                synchronized (memoryA) {
                    System.out.println("작업을 못해요");
                }
            }
        }
    }
}