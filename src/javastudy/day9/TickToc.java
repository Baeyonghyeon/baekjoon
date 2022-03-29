package javastudy.day9;

public class TickToc {
    public static void main(String[] args) throws InterruptedException {
        Thread tick = new Thread(new Tick());
        Thread tock = new Thread(new Tock());
        tick.start();
        tock.sleep(1000);
        tock.start();
//        single();
    }

    private static void single(){
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.print("Tick ");
            } else {
                System.out.print("Tock ");
            }
            try {
                Thread.sleep(1000);     // 1초 동안 잠들어요
            } catch (InterruptedException e) {
            }
        }
    }
}

class Tick implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.print("Tick ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
        }
    }
}

class Tock implements Runnable {
    @Override
    public void run() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        // TODO 직접 구현해주세요.
        for (int i = 0; i < 5; i++) {
            System.out.print("Tock ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
    }
}
