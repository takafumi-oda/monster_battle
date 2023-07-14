public class Monster {

    private String name;
    private int hp;
    private int maxHp;
    private int halfHp;
    private int atk;
    private int def;
    private boolean transform;

    Monster() {
        name = "スライム";
        maxHp = 800;
        hp = maxHp;
        halfHp = maxHp / 2;
        atk = 150;
        def = 50;
        transform = false;
    }

    Monster(String name, int maxHp, int atk, int def){
        this();
        this.name  = name;
        this.maxHp = maxHp;
        this.hp = this.maxHp;
        this.halfHp = maxHp / 2;
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

    public void attack(Brave brave) {

        String braveName = brave.getName();
        int braveHp = brave.getHp();

        if(hp <= halfHp && !transform){
            transfromIntoDragon();
        }

        System.out.println(name + "の攻撃");

        int damage = atk - brave.getDef();

        if(braveHp >= damage) {
            brave.setHp(braveHp - damage);
        } else {
            brave.setHp(0);
        }

        System.out.println(braveName + "は" + damage + "のダメージを受けた");
        System.out.println(braveName + "の残りHPは" + brave.getHp() + "だ");
    }

    private void transfromIntoDragon() {
        final double DORAGON_ATK_RATE = 1.5;
        final double DORAGON_DEF_RATE = 2.0;

        System.out.println(name + "は怒っている");
        String old_name = name;
        transform = true;
        atk = (int)(atk * DORAGON_ATK_RATE);
        def = (int)(def * DORAGON_DEF_RATE);
        name = "ドラゴン";
        System.out.println(old_name + "は" + name + "に変身した");
    }

}

