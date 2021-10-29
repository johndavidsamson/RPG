package maindope4;

public class PlayerStatus {
    public static PlayerSkills pskills = new PlayerSkills();
    public static playerClass pclass = new playerClass();
    public static Equipment eqp = new Equipment();
    public static SkillPhrase scp = new SkillPhrase();
    public static Player player;
    
    //***************************************PLAYER STATUS**********************************************************************
    
    //****************************************FLOOR 1***************************************************************
    public static void playerStatus1(Player player){
         System.out.println("\n");
         System.out.println("\t# PLAYER STATUS #");
         System.out.println("\t ]==}>  "+ pclass.getplayerClass(player.title) +"  <{==[");
         System.out.println("\t> Player name: "+ player.name);
         System.out.println("\t> HP: "+player.hp);
         System.out.println("\t> MP: "+player.mp);
         System.out.println("\t> Base Attack: "+player.baseAtk);
         System.out.println("\t> base Def: "+player.baseDef);
         System.out.println("\t> Skills: ");
         System.out.println("\t>    [1] "+pskills.getPlayerSkillName(player.skillId1));
         System.out.println("\t>    [2] "+pskills.getPlayerSkillName(player.skillId2));
         System.out.println("\t> HP potion: "+player.hpPotion);
         System.out.println("\t> MP potion: "+player.mpPotion);
         System.out.println("\t> Weapon: "+eqp.getWeaponName(player.weaponId)+"["+eqp.getWeaponDamage(player.weaponId)+"]");
         System.out.println("\t> Armor: "+eqp.getArmorName(player.armorId)+"["+eqp.getArmorDef(player.armorId)+"]");
    }
    
    //***********************************************FLOOR 2-3*************************************************************************
    public static void playerStatus2(Player player){
         System.out.println("\n");
         System.out.println("\t# PLAYER STATUS #");
         System.out.println("\t ]==}>  "+ pclass.getplayerClass(player.title) +"  <{==[");
         System.out.println("\t> Player name: "+ player.name);
         System.out.println("\t> HP: "+player.hp);
         System.out.println("\t> MP: "+player.mp);
         System.out.println("\t> Base Attack: "+player.baseAtk);
         System.out.println("\t> base Def: "+player.baseDef);
         System.out.println("\t> Skills: ");
         System.out.println("\t>    [1] "+pskills.getPlayerSkillName(player.skillId1));
         System.out.println("\t>    [2] "+pskills.getPlayerSkillName(player.skillId2));
         System.out.println("\t>    [3] "+pskills.getPlayerSkillName(player.skillId3));
         System.out.println("\t> HP potion: "+player.hpPotion);
         System.out.println("\t> MP potion: "+player.mpPotion);
         System.out.println("\t> Weapon: "+eqp.getWeaponName(player.weaponId)+"["+eqp.getWeaponDamage(player.weaponId)+"]");
         System.out.println("\t> Armor: "+eqp.getArmorName(player.armorId)+"["+eqp.getArmorDef(player.armorId)+"]");
    }
    
    //*****************************************************FLOOR 4-5*************************************************************************
    public static void playerStatus3(Player player){
         System.out.println("\n");
         System.out.println("\t# PLAYER STATUS #");
         System.out.println("\t ]==}>  "+ pclass.getplayerClass(player.title) +"  <{==[");
         System.out.println("\t> Player name: "+ player.name);
         System.out.println("\t> HP: "+player.hp);
         System.out.println("\t> MP: "+player.mp);
         System.out.println("\t> Base Attack: "+player.baseAtk);
         System.out.println("\t> base Def: "+player.baseDef);
         System.out.println("\t> Skills: ");
         System.out.println("\t>    [1] "+pskills.getPlayerSkillName(player.skillId1));
         System.out.println("\t>    [2] "+pskills.getPlayerSkillName(player.skillId2));
         System.out.println("\t>    [3] "+pskills.getPlayerSkillName(player.skillId3));
         System.out.println("\t>    [4] "+pskills.getPlayerSkillName(player.skillId4));
         System.out.println("\t> HP potion: "+player.hpPotion);
         System.out.println("\t> MP potion: "+player.mpPotion);
         System.out.println("\t> Weapon: "+eqp.getWeaponName(player.weaponId)+"["+eqp.getWeaponDamage(player.weaponId)+"]");
         System.out.println("\t> Armor: "+eqp.getArmorName(player.armorId)+"["+eqp.getArmorDef(player.armorId)+"]");
    }
    
    //************************************FLOOR 6-7***********************************************************************************************
    public static void playerStatus4(Player player){
         System.out.println("\n");
         System.out.println("\t# PLAYER STATUS #");
         System.out.println("\t ]==}>  "+ pclass.getplayerClass(player.title) +"  <{==[");
         System.out.println("\t> Player name: "+ player.name);
         System.out.println("\t> HP: "+player.hp);
         System.out.println("\t> MP: "+player.mp);
         System.out.println("\t> Base Attack: "+player.baseAtk);
         System.out.println("\t> base Def: "+player.baseDef);
         System.out.println("\t> Skills: ");
         System.out.println("\t>    [1] "+pskills.getPlayerSkillName(player.skillId1));
         System.out.println("\t>    [2] "+pskills.getPlayerSkillName(player.skillId2));
         System.out.println("\t>    [3] "+pskills.getPlayerSkillName(player.skillId3));
         System.out.println("\t>    [4] "+pskills.getPlayerSkillName(player.skillId4));
         System.out.println("\t>    [5] "+pskills.getPlayerSkillName(player.skillId5));
         System.out.println("\t> HP potion: "+player.hpPotion);
         System.out.println("\t> MP potion: "+player.mpPotion);
         System.out.println("\t> Weapon: "+eqp.getWeaponName(player.weaponId)+"["+eqp.getWeaponDamage(player.weaponId)+"]");
         System.out.println("\t> Armor: "+eqp.getArmorName(player.armorId)+"["+eqp.getArmorDef(player.armorId)+"]");
    }
    
    //************************************FLOOR 8-10***********************************************************************************************
    public static void playerStatus5(Player player){
         System.out.println("\n");
         System.out.println("\t# PLAYER STATUS #");
         System.out.println("\t ]==}>  "+ pclass.getplayerClass(player.title) +"  <{==[");
         System.out.println("\t> Player name: "+ player.name);
         System.out.println("\t> HP: "+player.hp);
         System.out.println("\t> MP: "+player.mp);
         System.out.println("\t> Base Attack: "+player.baseAtk);
         System.out.println("\t> base Def: "+player.baseDef);
         System.out.println("\t> Skills: ");
         System.out.println("\t>    [1] "+pskills.getPlayerSkillName(player.skillId1));
         System.out.println("\t>    [2] "+pskills.getPlayerSkillName(player.skillId2));
         System.out.println("\t>    [3] "+pskills.getPlayerSkillName(player.skillId3));
         System.out.println("\t>    [4] "+pskills.getPlayerSkillName(player.skillId4));
         System.out.println("\t>    [5] "+pskills.getPlayerSkillName(player.skillId5));
         System.out.println("\t>    [6] "+pskills.getPlayerSkillName(player.skillId6));
         System.out.println("\t> HP potion: "+player.hpPotion);
         System.out.println("\t> MP potion: "+player.mpPotion);
         System.out.println("\t> Weapon: "+eqp.getWeaponName(player.weaponId)+"["+eqp.getWeaponDamage(player.weaponId)+"]");
         System.out.println("\t> Armor: "+eqp.getArmorName(player.armorId)+"["+eqp.getArmorDef(player.armorId)+"]");
    }
}
