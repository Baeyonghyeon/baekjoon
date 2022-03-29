package javastudy.day11.server;

class Oak extends Unit {
    public Oak() {
        super.setName("오크");
        super.setLevel(2);
        super.setHealth(40);
        super.setAttackPower(6);
    }

    @Override
    void attack(Unit user) {
        SleepThread t = new SleepThread(500);
        StringBuilder sb = new StringBuilder();

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
