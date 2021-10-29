package maindope4;

import java.io.*;
import java.util.Random;

public class Player {
    public static BufferedReader jcb;
    public static Random rand;
    public static PlayerSkills pskills = new PlayerSkills();
    public static playerClass pclass = new playerClass();
    public static Equipment eqp = new Equipment();
    public static SkillPhrase scp = new SkillPhrase();
    
    public String name;
    public int title;
    public int weaponId;
    public int armorId;
    public int hp;
    public int maxHp;
    public int mp;
    public int maxMp;
    public int baseAtk;
    public int skillId1;
    public int skillId2;
    public int skillId3;
    public int skillId4;
    public int skillId5;
    public int skillId6;
    public int baseDef;
    public int defRate;
    public int hitRate;
    public int hpPotion;
    public int mpPotion;
    
    public Player(String name, int title, int weaponId, int armorId,int baseAtk, int baseDef, int defRate, int hitRate){
        this.name = name;
        this.title = title;
        this.weaponId = weaponId;
        this.armorId = armorId;
        this.hp = 200;
        this.maxHp = this.hp;
        this.mp = 200;
        this.maxMp = this.mp;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.defRate = defRate;
        this.hitRate = hitRate;// percentage
        this.hpPotion = 5;
        this.mpPotion = 5;
        
    }
    
    //**************************************ATTACK OPTION**********************************************
    public static void attack(){
        System.out.println("\tHow would you like to attack?");
        System.out.println("\t> [1] Normal Attack"
                + "\t> [2] Special Attack");
    }
    
    //*************************************************PHYSICAL ATTACK**************************************
    public int pAttack(Enemy enemy, int turn){
        rand = new Random();
        int missRate = rand.nextInt(99)+1;
        System.out.println("----------------------------------------------------");
        if(hitRate > missRate){// hit
            int dmgDealt = rand.nextInt(this.baseAtk)+ eqp.getWeaponDamage(this.weaponId);
            int enemyDmgTaken = enemy.baseDef - dmgDealt;
            enemy.hp -= Math.abs(enemyDmgTaken);
            System.out.println("\t# You attack with your "+eqp.getWeaponName(this.weaponId)+". #");
            System.out.println("\t# You strike the "+enemy.name+" for "+ dmgDealt+" damage. #");
            
        }
        else{//miss
            System.out.println("\t# You attacked the enemy but it dodged the attack. #");
        }
        return enemy.hp;
    }
    
    //***********************************SPECIAL ATTACK MENU*******************************************************
    public void sAttackMenu1(){
        System.out.println("\tWhat Special attack would you like to use?");
        System.out.println("\t> [1]"+pskills.getPlayerSkillName(this.skillId1));
        System.out.println("\t> [2]"+pskills.getPlayerSkillName(this.skillId2));
    }
    
    public void sAttackMenu2(){
        System.out.println("\tWhat Special attack would you like to use?");
        System.out.println("\t> [1]"+pskills.getPlayerSkillName(this.skillId1));
        System.out.println("\t> [2]"+pskills.getPlayerSkillName(this.skillId2));
        System.out.println("\t> [3]"+pskills.getPlayerSkillName(this.skillId3));
    }
    
    public void sAttackMenu3(){
        System.out.println("\tWhat Special attack would you like to use?");
        System.out.println("\t> [1]"+pskills.getPlayerSkillName(this.skillId1));
        System.out.println("\t> [2]"+pskills.getPlayerSkillName(this.skillId2));
        System.out.println("\t> [3]"+pskills.getPlayerSkillName(this.skillId3));
        System.out.println("\t> [4]"+pskills.getPlayerSkillName(this.skillId4));
    }
    
    public void sAttackMenu4(){
        System.out.println("\tWhat Special attack would you like to use?");
        System.out.println("\t> [1]"+pskills.getPlayerSkillName(this.skillId1));
        System.out.println("\t> [2]"+pskills.getPlayerSkillName(this.skillId2));
        System.out.println("\t> [3]"+pskills.getPlayerSkillName(this.skillId3));
        System.out.println("\t> [4]"+pskills.getPlayerSkillName(this.skillId4));
        System.out.println("\t> [5]"+pskills.getPlayerSkillName(this.skillId5));
    }
    
    public void sAttackMenu5(){
        System.out.println("\tWhat Special attack would you like to use?");
        System.out.println("\t> [1]"+pskills.getPlayerSkillName(this.skillId1));
        System.out.println("\t> [2]"+pskills.getPlayerSkillName(this.skillId2));
        System.out.println("\t> [3]"+pskills.getPlayerSkillName(this.skillId3));
        System.out.println("\t> [4]"+pskills.getPlayerSkillName(this.skillId4));
        System.out.println("\t> [5]"+pskills.getPlayerSkillName(this.skillId5));
        System.out.println("\t> [6]"+pskills.getPlayerSkillName(this.skillId6));
    }
    
    //**************************************SA1**************************************************************
    public int sAttack1(Enemy enemy, int turn){
        rand = new Random();
        System.out.println("----------------------------------------------------");
        System.out.println("\t# You chose "+pskills.getPlayerSkillName(this.skillId1)+"! #");
        System.out.println("----------------------------------------------------");
        System.out.println("\t# "+scp.getSkillCatchPhrase(this.skillId1)+" #");
        System.out.println("\n\t# "+pskills.getPlayerSkillName(this.skillId1)+"!!! #");
        System.out.println("----------------------------------------------------");
        int missRate = rand.nextInt(99)+1;
        if(hitRate > missRate){// hit
            int dmgDealt = pskills.getPlayerSkillDmg(this.skillId1) + eqp.getWeaponDamage(this.weaponId);
            int enemyDmgTaken = enemy.baseDef - dmgDealt;
            enemy.hp -= Math.abs(enemyDmgTaken);
            this.mp -= Math.abs(25);
            System.out.println("\tYou used "+pskills.getPlayerSkillName(this.skillId1)+" on "+enemy.name+" for "+dmgDealt+" damage.");
            System.out.println("\tYou used "+Math.abs(30)+" MP.");
            
        }
        else{//miss
            System.out.println("\tYou attacked the enemy but it dodged the attack.");
        }
        return enemy.hp;
        
    }
    
    //*****************************************************SA2*********************************************
    public int sAttack2(Enemy enemy, int turn){
        rand = new Random();
        System.out.println("----------------------------------------------------");
        System.out.println("\t# You chose "+pskills.getPlayerSkillName(this.skillId2)+"! #");
        System.out.println("----------------------------------------------------");
        System.out.println("\t# "+scp.getSkillCatchPhrase(this.skillId2)+" #");
        System.out.println("\n\t# "+pskills.getPlayerSkillName(this.skillId2)+"!!! #");
        System.out.println("----------------------------------------------------");
        int missRate = rand.nextInt(99)+1;
        if(hitRate > missRate){// hit
            int dmgDealt = pskills.getPlayerSkillDmg(this.skillId2) + eqp.getWeaponDamage(this.weaponId);
            int enemyDmgTaken = enemy.baseDef - dmgDealt;
            enemy.hp -= Math.abs(enemyDmgTaken);
            this.mp -= Math.abs(50);
            System.out.println("You used "+pskills.getPlayerSkillName(this.skillId2)+" on "+enemy.name+" for "+dmgDealt+" damage.");
            System.out.println("\tYou used "+Math.abs(50)+" MP.");
        }
        else{//miss
            System.out.println("\tYou attacked the enemy but it dodged the attack.");
        }
        return enemy.hp;
        
    }
    
    //******************************************************SA3********************************************
    public int sAttack3(Enemy enemy, int turn){
        rand = new Random();
        System.out.println("----------------------------------------------------");
        System.out.println("\t# You chose "+pskills.getPlayerSkillName(this.skillId3)+"! #");
        System.out.println("----------------------------------------------------");
        System.out.println("\t# "+scp.getSkillCatchPhrase(this.skillId3)+" #");
        System.out.println("\n\t# "+pskills.getPlayerSkillName(this.skillId3)+"!!! #");
        System.out.println("----------------------------------------------------");
        int missRate = rand.nextInt(99)+1;
        if(hitRate > missRate){// hit
            int dmgDealt = pskills.getPlayerSkillDmg(this.skillId3) + eqp.getWeaponDamage(this.weaponId);
            int enemyDmgTaken = enemy.baseDef - dmgDealt;
            enemy.hp -= Math.abs(enemyDmgTaken);
            this.mp -= Math.abs(75);
            System.out.println("\tYou used "+pskills.getPlayerSkillName(this.skillId3)+" on "+enemy.name+" for "+dmgDealt+" damage.");
            System.out.println("\tYou used "+Math.abs(75)+" MP.");
        }
        else{//miss
            System.out.println("\tYou attacked the enemy but it dodged the attack.");
        }
        return enemy.hp;
        
    }
    
    //******************************************************SA4********************************************
    public int sAttack4(Enemy enemy, int turn){
        rand = new Random();
        System.out.println("----------------------------------------------------");
        System.out.println("\t# You chose "+pskills.getPlayerSkillName(this.skillId4)+"! #");
        System.out.println("----------------------------------------------------");
        System.out.println("\t# "+scp.getSkillCatchPhrase(this.skillId4)+" #");
        System.out.println("\n\t# "+pskills.getPlayerSkillName(this.skillId4)+"!!! #");
        System.out.println("----------------------------------------------------");
        int missRate = rand.nextInt(99)+1;
        if(hitRate > missRate){// hit
            int dmgDealt = pskills.getPlayerSkillDmg(this.skillId4) + eqp.getWeaponDamage(this.weaponId);
            int enemyDmgTaken = enemy.baseDef - dmgDealt;
            enemy.hp -= Math.abs(enemyDmgTaken);
            this.mp -= Math.abs(100);
            System.out.println("\tYou used "+pskills.getPlayerSkillName(this.skillId4)+" on "+enemy.name+" for "+dmgDealt+" damage.");
            System.out.println("\tYou used "+Math.abs(75)+" MP.");
        }
        else{//miss
            System.out.println("\tYou attacked the enemy but it dodged the attack.");
        }
        return enemy.hp;
        
    }
    
    //******************************************************SA5********************************************
    public int sAttack5(Enemy enemy, int turn){
        rand = new Random();
        System.out.println("----------------------------------------------------");
        System.out.println("\t# You chose "+pskills.getPlayerSkillName(this.skillId5)+"! #");
        System.out.println("----------------------------------------------------");
        System.out.println("\t# "+scp.getSkillCatchPhrase(this.skillId5)+" #");
        System.out.println("\n\t# "+pskills.getPlayerSkillName(this.skillId5)+"!!! #");
        System.out.println("----------------------------------------------------");
        int missRate = rand.nextInt(99)+1;
        if(hitRate > missRate){// hit
            int dmgDealt = pskills.getPlayerSkillDmg(this.skillId5) + eqp.getWeaponDamage(this.weaponId);
            int enemyDmgTaken = enemy.baseDef - dmgDealt;
            enemy.hp -= Math.abs(enemyDmgTaken);
            this.mp -= Math.abs(150);
            System.out.println("\tYou used "+pskills.getPlayerSkillName(this.skillId5)+" on "+enemy.name+" for "+dmgDealt+" damage.");
            System.out.println("\tYou used "+Math.abs(75)+" MP.");
        }
        else{//miss
            System.out.println("\tYou attacked the enemy but it dodged the attack.");
        }
        return enemy.hp;
        
    }
    
    //******************************************************SA6********************************************
    public int sAttack6(Enemy enemy, int turn){
        rand = new Random();
        System.out.println("----------------------------------------------------");
        System.out.println("\t# You chose "+pskills.getPlayerSkillName(this.skillId6)+"! #");
        System.out.println("----------------------------------------------------");
        System.out.println("\t# "+scp.getSkillCatchPhrase(this.skillId6)+" #");
        System.out.println("\n\t# "+pskills.getPlayerSkillName(this.skillId6)+"!!! #");
        System.out.println("----------------------------------------------------");
        int missRate = rand.nextInt(99)+1;
        if(hitRate > missRate){// hit
            int dmgDealt = pskills.getPlayerSkillDmg(this.skillId6) + eqp.getWeaponDamage(this.weaponId);
            int enemyDmgTaken = enemy.baseDef - dmgDealt;
            enemy.hp -= Math.abs(enemyDmgTaken);
            this.mp -= Math.abs(200);
            System.out.println("\tYou used "+pskills.getPlayerSkillName(this.skillId6)+" on "+enemy.name+" for "+dmgDealt+" damage.");
            System.out.println("\tYou used "+Math.abs(75)+" MP.");
        }
        else{//miss
            System.out.println("\tYou attacked the enemy but it dodged the attack.");
        }
        return enemy.hp;
        
    }
    
    //**********************************************************DEFEND*********************************************
    public int defend(Enemy enemy, int turn){
        rand = new Random();
        int undefRate = rand.nextInt(99)+1;
        if(defRate > undefRate){
            int enemyAtk = rand.nextInt(10)+1;
            this.hp-=Math.abs(enemyAtk);
            System.out.println("----------------------------------------------------");
            System.out.println("\n\tYou defended but still took "+Math.abs(enemyAtk)+" damage");
        }
        else{
            this.hp-= enemy.baseAtk;
            System.out.println("----------------------------------------------------");
            System.out.println("\n\tYou defended but you failed.");
            System.out.println("\tYou took "+enemy.baseAtk+" damage.");
        }
        return this.hp;
    }
    //******************************************************ITEM OPTION********************************************
    public void itemOption(){
        System.out.println("----------------------------------------------------");
        System.out.println("\n\tWhat potion do you want to drink?");
        System.out.println("\t> [1] HP potion");
        System.out.println("\t> [2] MP potion");
    }
}
