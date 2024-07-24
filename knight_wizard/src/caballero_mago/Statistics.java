package caballero_mago;

public abstract class Statistics{
    protected String name;
    protected int lvl_attack;
    protected int lvl_defense;
    protected int lvl_heal;

    public Statistics(String nam, int lvl_att, int lvl_def, int lvl_h) {
        this.name = nam;
        this.lvl_attack = lvl_att;
        this.lvl_defense = lvl_def;
        this.lvl_heal = lvl_h;
    }
    public abstract int Special(); 
}
//////////////////////////////////////////
class Knight extends Statistics {

    public Knight(String nam, int lvl_att, int lvl_def, int lvl_h) {
        super(nam, lvl_att, lvl_def, lvl_h);
    }

    public int Special() {
        int dam = (int) (Math.random()*4+1);
        return dam * 2;
    }
}
//////////////////////////////////////////
class Wizard extends Statistics {

    public Wizard(String nam, int lvl_att, int lvl_def, int lvl_h) {
        super(nam, lvl_att, lvl_def, lvl_h);
    }

    public int Special() {
        int dam = (int) (Math.random()*4+1);
        return dam * 2;
    }

    public void heal() {
        lvl_heal = lvl_heal + 1;
    }
}