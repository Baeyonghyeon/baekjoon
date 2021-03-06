package java.javastudy.day11.server;

class SleepThread extends Thread {
    long millis;

    public SleepThread(long millis) {
        this.millis = millis;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(millis);   // 특정 시간 동안 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
