package javastudy.day11.server;

class Slime extends Unit {

    public Slime() {
        super.setName("슬라임");
        super.setLevel(1);
        super.setHealth(30);
        super.setAttackPower(4);
    }

    @Override
    void attack(Unit user) {
        SleepThread t = new SleepThread(500);
        StringBuilder sb = new StringBuilder();
        //유저 공격 0.5초마다 1~4 뎀지
        autoAttack(user);
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

    void autoAttack(Unit user) {
        user.setHealth(user.getHealth() - damages());
    }
}
