package maindope4;

import java.io.*;
import java.util.Random;

public class Enemy {
    public static Random rand;
    public static Equipment eqp = new Equipment();
    
    public String name;
    public int hp;
    public int baseAtk;
    public String sname;// special attack name
    public int sAtk;//special attack
    public int baseDef;
    public int hitRate;
    
    public Enemy(String name, int hp, int baseAtk, String sname, int sAtk, int baseDef){
        this.name = name;
        this.hp = hp;
        this.baseAtk = baseAtk;
        this.sname = sname;
        this.sAtk = sAtk;
        this.baseDef = baseDef;
        this.hitRate = 80;
    }
    
    //*****************************************PHYSICAL ATTACK*****************************************************
    public int pAttack(Player player, int turn){
        rand = new Random();
        int missRate = rand.nextInt(99)+1;
        if(hitRate > missRate){// hit
            int enemyDmgDealt = rand.nextInt(this.baseAtk) + 50 - (player.baseDef + eqp.getArmorDef(player.armorId));
            if(enemyDmgDealt <= 0) enemyDmgDealt = 0;
            player.hp -= Math.abs(enemyDmgDealt);
            System.out.println("\t# You took "+Math.abs(enemyDmgDealt)+" damage. #");
        }
        else{//miss
            System.out.println("\t# "+this.name+" attacked but you luckily dodge it! #");
        }
        return player.hp;
    }
    
    //***********************************************SPECIAL ATTACK*************************************************
    public int sAttack(Player player, int turn){
        rand = new Random();
        System.out.println("\t# "+this.name+" is going to use "+ this.sname+"! #");
        int missRate = rand.nextInt(99)+1;
        if(hitRate > missRate){
            int enemyDmgDealt = this.sAtk - (player.baseDef + eqp.getArmorDef(player.armorId));
            if(enemyDmgDealt <= 0) enemyDmgDealt = 0;
            player.hp -= Math.abs(enemyDmgDealt);
            System.out.println("\t "+this.name+" attacked with its special attack!");
            System.out.println("\tYou took "+Math.abs(enemyDmgDealt)+" damage.");
        }
        else{//miss
            System.out.println("\t "+this.name+" attacked "+this.sname+" but you luckily dodge it!");
        }
        return player.hp;
    }
}