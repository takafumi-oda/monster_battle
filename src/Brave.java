public class Brave {

    private String name;
    private int maxHp;
    private int hp;
    private int atk;
    private int def;

    Brave() {
        name = "ゆうしゃ";
        maxHp = 800;
        hp = maxHp;
        atk = 150;
        def = 100;
    }

    Brave(String name, int maxHp, int atk, int def){
        this();
        this.name = name;
        this.maxHp = maxHp;
        this.hp = this.maxHp;
        this.atk = atk;
        this.def = def;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDef() {
        return def;
    }

    public void attack(Monster monster) {
        final double CRITICAL_ATK_RATE = 1.5;

        String monsterName = monster.getName();
        int monsterHp = monster.getHp();

        int damage = 0;
        int atk_num = (int)(3 * Math.random());

        System.out.println(name + "の攻撃");

        if(atk_num == 0){
            System.out.println("会心の一撃！");
            damage = (int)(atk * CRITICAL_ATK_RATE) - monster.getDef();
        } else {
            damage = atk - monster.getDef();
        }

        if(monsterHp >= damage) {
            monster.setHp(monsterHp - damage);
        } else {
            monster.setHp(0);
        }

        System.out.println(monsterName+ "は" + damage + "のダメージを受けた");
        System.out.println(monsterName+ "の残りHPは" + monster.getHp() + "だ");
    }

}

