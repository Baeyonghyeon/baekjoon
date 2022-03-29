package javastudy.day11.server;

class User extends Unit {

    MyChatServer myChatServer;
    private int bossStage = 1;

    public User(String id) {
        super.setName(id);
        super.setLevel(1);
        super.setHealth(100);
        super.setAttackPower(10);
        System.out.println(id + "계정이 생성되었습니다.");
    }

    @Override
    void attack(Unit monster) {
        SleepThread t = new SleepThread(500);
        // 몬스터한테 attackPower 만큼 데미지를 줌.
        StringBuilder sb = new StringBuilder();

        monster.setHealth(monster.getHealth() - damages());
        t.start();

        sb = currentHealthConsole(sb, monster);
        System.out.println(sb);
    }

    StringBuilder currentHealthConsole(StringBuilder sb, Unit monster) {
        sb.append(this.getName())
            .append("님의 공격으로 '")
            .append(monster.getName())
            .append(" 는(은) 체력이 ")
            .append(monster.getHealth())
            .append(" 남았습니다.");
        return sb;
    }

    StringBuilder getCurrentStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("-----------------------------")
            .append("\n")
            .append(super.getName() + "님의 현재 상태는")
            .append("\n")
            .append("레벨 : " + super.getLevel())
            .append("\n")
            .append("체력 : " + super.getHealth())
            .append("\n")
            .append("공격력 : " + super.getAttackPower())
            .append("\n")
            .append("-----------------------------");
        return sb;
    }

    void levelUp() {
        super.setLevel(getLevel() + 1);
        super.setHealth(150);
        super.setAttackPower(20);
    }

    public int getBossStage() {
        return bossStage;
    }

    public void setBossStage(int bossStage) {
        this.bossStage = bossStage;
    }
}
