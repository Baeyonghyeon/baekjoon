package java.javastudy.day9;

public class RunThread {
    public static void main(String[] args) {
        System.out.println("Hello! Main on " + Thread.currentThread().getName());
        new HelloThread().start();
        new Thread(new HelloRunner()).start();
    }
}

class HelloThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello! Thread on " + Thread.currentThread().getName());
        System.out.println("helloThread.id: " + Thread.currentThread().getId());
        System.out.println("helloThread.priority: " + Thread.currentThread().getPriority());
        System.out.println("helloThread.isDaemon: " + Thread.currentThread().isDaemon());
    }
}

class HelloRunner implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello! Runner on " + Thread.currentThread().getName());
        System.out.println("helloRunner.id: " + Thread.currentThread().getId());
        System.out.println("helloRunner.priority: " + Thread.currentThread().getPriority());
        System.out.println("helloRunner.isDaemon: " + Thread.currentThread().isDaemon());
    }
}
