public class Battle {
    public static void main(String[] args) {

        Brave brave = new Brave();
        Monster monster = new Monster();

        System.out.println("〜戦闘開始〜");

        while(brave.getHp() != 0 && monster.getHp() != 0) {
            brave.attack(monster);
            if (checkDead(monster.getHp())) {
                System.out.println(monster.getName() + "を倒した");
                break;
            }

            monster.attack(brave);
            if (checkDead(brave.getHp())) {
                System.out.println(brave.getName() + "は死にました");
                break;
            }
        }

        System.out.println("〜戦闘終了〜");
    }

    public static boolean checkDead(int hp) {
        return hp == 0;
    }

}