package javastudy.day11.server;

class Battlefield {
    private static final int SLIME = 1;
    private static final int OAK = 2;
    private static final int DRAGON = 3;

    private User user;
    private Unit monster;
    private int bossStage;

    public Battlefield(User user) {
        this.user = user;
        this.bossStage = user.getBossStage();
        openDungeon(); // this.monster
    }

    public void userVictory() {
        user.setBossStage(user.getBossStage() + 1);
    }

    public StringBuilder fight() {
        StringBuilder sb = new StringBuilder();

        boolean bl = true;
        while (bl) {

            user.attack(monster);
            if (monster.getHealth() <= 0) {
                sb.append(user.getName()).append("님이 ").append(monster.getName())
                    .append("을 물리치고 승리했습니다!\n");
                sb.append(bossClearReward());

                bl = false;
            }

            monster.attack(user);
            if (user.getHealth() <= 0 || bl) {
                sb.append(user.getName()).append("님이 졌습니다.\n").append("(게임을 종료합니다)");
                bl = false;
            }
        }
        return sb;
    }

    String bossClearReward() {
        if (bossStage == OAK) {
            user.levelUp();
            return "레벨2로 상승했습니다";
        }
        return "";
    }

    void openDungeon() {
        if (bossStage == SLIME) {
            this.monster = new Slime();
        } else if (bossStage == OAK) {
            this.monster = new Oak();
        } else if (bossStage == DRAGON) {
            this.monster = new Dragon();
        } else {
            //추후 추가될 몬스터..(?)
        }
    }


}
