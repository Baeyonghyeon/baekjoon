package javaStudy.day11.server;

public class GameConsole {
    User user;

    public GameConsole(User user) {
        this.user = user;
    }

    public String gameStartConsole(){
        String str = ("                 ___====-_  _-====___\n" +
                "           _--^^^#####//      \\\\#####^^^--_\n" +
                "        _-^##########// (    ) \\\\##########^-_\n" +
                "       -############//  |\\^^/|  \\\\############-\n" +
                "     _/############//   (@::@)   \\\\############\\_\n" +
                "    /#############((     \\\\//     ))#############\\\n" +
                "   -###############\\\\    (oo)    //###############-\n" +
                "  -#################\\\\  / VV \\  //#################-\n" +
                " -###################\\\\/      \\//###################-\n" +
                "_#/|##########/\\######(   /\\   )######/\\##########|\\#_\n" +
                "|/ |#/\\#/\\#/\\/  \\#/\\##\\  |  |  /##/\\#/  \\/\\#/\\#/\\#| \\|\n" +
                "`  |/  V  V  `   V  \\#\\| |  | |/#/  V   '  V  V  \\|  '\n" +
                "   `   `  `      `   / | |  | | \\   '      '  '   '\n" +
                "                    (  | |  | |  )\n" +
                "                   __\\ | |  | | /__\n" +
                "                  (vvv(VVV)(VVV)vvv)\n" +
                "                  게임을 바로 시작합니다!!\n"+
                "-----------------------------------------------------------------");

        return str;
    }

    public String gameMainConsole(){
        String str = ("용사 "+ user.getName()+"님 던전에 있는 드래곤을 물리쳐주세요!!!\n" +
                "1. 던전으로 들어간다.\n" +
                "2. 도망간다. (게임 종료)");

        return str;
    }

    public String bossLevel(){
        String boss = "";
        if(user.getBossStage() == 1) boss = "슬라임";
        else if(user.getBossStage() == 2) boss = "오크";
        else if(user.getBossStage() == 3) boss = "드래곤";

        return boss;
    }

    public String selectTryConsole(){
        String str = ("야생의"+bossLevel()+"이 나타났다.\n" +
                "1. 공격\n" +
                "2. 도망간다. (게임 종료)");

        return str;
    }
}
