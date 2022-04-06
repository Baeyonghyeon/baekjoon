package java.javastudy.day11.server;

import java.security.SecureRandom;

abstract class Unit {
    SecureRandom random = new SecureRandom();

    private String name;
    private int level;
    private int health;
    private int attackPower;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int damages() {
        return random.nextInt(this.attackPower) + 1;  // 1 ~ attackPower 데미지를 입힌다.
    }

    abstract void attack(Unit unit);

    //모든 몬스터가 경험치를 준다면 그말이 맞음
}
