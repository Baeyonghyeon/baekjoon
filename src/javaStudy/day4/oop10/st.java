package javaStudy.day4.oop10;

public class st {
}

class Love{
    private static int POWER_OF_LOVE = Integer.MAX_VALUE;
    String fiance;

    Love(String fiance){
        this.fiance = fiance;   //한번 할당 가능
    }

    final int powerOfLove(){
        return Love.POWER_OF_LOVE;
    }

    void transfer(final String newFiance){
        this.fiance = newFiance;
        POWER_OF_LOVE = 0;
    }
}

class Jealousy extends Love{
    Jealousy(String fiance){
        super(fiance);
    }

    //powerOfLove()는 final이 써있기 때문에 override가 불가능함
}
