package javaStudy.day9;

public class Dual {
    public static void main(String[] args) {
        Dual dual = new Dual();
        dual.humanVsOrc();
    }

    private StringBuilder sb = new StringBuilder();
    void attack(String weapon) {
        synchronized(this) {
            sb.append(weapon);
        }
    }

    public void humanVsOrc() {
        Thread human = new Thread(new Worrier("🗡️️", this));
        Thread orc = new Thread(new Worrier("🪓", this));

        orc.start();
        human.start();

        try {
            orc.join();     // 스레드가 종료될 때까지 대기
            human.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sb.toString());
    }

    static class Worrier implements Runnable {
        private String weapon;
        private Dual dual;

        public Worrier(String weapon, Dual dual) {
            this.weapon = weapon;
            this.dual = dual;
        }

        @Override
        public void run() {
            for (int i = 0; i < 400; i++) {
                attack();
            }
        }

        public void attack() {
            dual.attack(this.weapon);
        }
    }
}
