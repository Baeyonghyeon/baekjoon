package javastudy.day11.server;

class Dragon extends Unit {
    public Dragon() {
        super.setName("드래곤");
        super.setLevel(3);
        super.setHealth(100);
        super.setAttackPower(10);
    }

    @Override
    void attack(Unit user) {
        // 드래곤은 0.5초에 한 번 대상을 1 ~ 10(공격력) 사이로 랜덤한 데미지로 공격
        SleepThread t = new SleepThread(500);
        // (특수공격)
        // 드래곤은 공격 시 10%의 확률로 브레스를 뿜는다.
        // 브레스는 무조건 15의 데미지가 들어간다..

        StringBuilder sb = new StringBuilder();

        if (percentage() == 1) {
            specialAttack(user);
            sb.append("드래곤의 특수 공격!!(15고정 피해)\n");
        } else {
            autoAttack(user);
        }

        t.start();
        sb = currentHealthConsole(sb, user);
        System.out.println(sb);
    }

    StringBuilder currentHealthConsole(StringBuilder sb, Unit monster) {
        sb.append(this.getName())
            .append("의 공격으로 '")
            .append(monster.getName())
            .append(" 는(은) 체력이 ")
            .append(monster.getHealth())
            .append(" 남았습니다.");
        return sb;
    }

    void specialAttack(Unit user) {
        user.setHealth(user.getHealth() - 15);
    }

    int percentage() {
        return random.nextInt(10) + 1;
    } // 1~10

    void autoAttack(Unit user) {
        user.setHealth(user.getHealth() - damages());
    }
}
