package jp.ac.uryukyu.ie.e195746;

/**
 * LivingThingクラス。
 *
 *  String name;　   //名前
 *  int hitPoint;    //HP
 *  int attack;      //攻撃力
 *  boolean dead;    //生死状態（true＝死亡)
 *
 * @author kohamakaito
 * Created by e195746 on 2019/12/22.
 */

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     *コンストラクタ
     *
     * @param name 名前
     * @param maximumHP 最大HP
     * @param attack 攻撃力
     */
    public LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    public boolean isDead(){
        return dead;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getHitPoint(){
        return hitPoint;
    }

    public void setHitPoint(int hitPoint){
        this.hitPoint = hitPoint;
    }

    public int getAttack(){
        return attack;
    }

    public void setAttack(int attack){
        this.attack = attack;
    }

    public void setDead(boolean dead){
        this.dead = dead;
    }

    /**
     * 指定した相手に攻撃をするメソッド
     * 与えるダメージを乱数で指定してwoundedメソッドにダメージの数値を渡す。
     *
     * @param opponent 攻撃する相手
     */
    public void attack(LivingThing opponent){
        if(isDead() != true){
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}
