package maindope4;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class MainDope {
    
    public static BufferedReader jcb;
    public static Random rand;
    public static Player player;
    public static Enemy enemy;
    public static playerClass pclass = new playerClass();
    public static PlayerSkills pskills = new PlayerSkills();
    public static Equipment eqp = new Equipment();
     public static void main(String[] args)throws IOException {
         jcb = new BufferedReader(new InputStreamReader(System.in));
         System.out.println("\n___________________________________________________\n");
         LinkStart.menu();
         System.out.print("Enter your choice: ");
         int choice;
         try{
            choice = Integer.parseInt(jcb.readLine());
        }
        catch(Exception e){
            System.out.println("INVALID COMMAND!");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(jcb.readLine());
        }
         while(choice != 1 && choice != 2 && choice != 3){
             System.out.println("INVALID COMMAND!");
             System.out.print("Enter your choice: ");
             
             try{
                choice = Integer.parseInt(jcb.readLine());
            }
            catch(Exception e){
                System.out.println("INVALID INPUT!");
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(jcb.readLine());
                
            }
         }
         switch(choice){
             case 1:
                 newGame();
                 break;
             case 2:
                 continue_();
                 
                 break;
             case 3:
                 System.exit(0);
                 
                 break;
             default:
                 
                 break;
         }
         
    }
     public static void newGame()throws IOException {
         jcb = new BufferedReader(new InputStreamReader(System.in));
         pclass = new playerClass();
         player = new Player("", 0, 0, 0,0,0,0,0);
         // **********************************************PLAYER MAKING********************************************************************************
         System.out.println("___________________________________________________");
         System.out.println("\tChoose your profession: "
                 + "\n\t> [1] Knight"
                 + "\n\t> [2] Mage"
                 + "\n\t> [3] Archer");
         System.out.println("\tProfession: ");
         int prof;
         // try & catch***************************************
         try{
             prof = Integer.parseInt(jcb.readLine());
         }
         catch(Exception e){
             System.out.println("\t# INVALID COMMAND! #");
             System.out.println("\tProfession: ");
             prof = Integer.parseInt(jcb.readLine());
         }
         while(prof != 1 && prof != 2 && prof != 3){
             System.out.println("\t# INVALID COMMAND! #");
             System.out.println("\tProfession: ");
             prof = Integer.parseInt(jcb.readLine());
         }
         switch(prof){
             case 1:
                 player.title = 0;
                 player.weaponId = 0;
                 player.armorId = 0;
                 player.baseAtk = 80;
                 player.baseDef = 90;
                 player.defRate = 90;
                 player.hitRate = 80;
                 player.skillId1 = 0;
                 player.skillId2 = 1;
                 break;
             case 2:
                 player.title = 4;
                 player.weaponId = 10;
                 player.armorId = 0;
                 player.baseAtk = 100;
                 player.baseDef = 80;
                 player.defRate = 80;
                 player.hitRate = 90;
                 player.skillId1 = 6;
                 player.skillId2 = 7;
                 break;
             case 3:
                 player.title = 8;
                 player.weaponId = 20;
                 player.armorId = 0;
                 player.baseAtk = 90;
                 player.baseDef = 80;
                 player.defRate = 80;
                 player.hitRate = 90;
                 player.skillId1 = 12;
                 player.skillId2 = 13;
                 break;
         }
         
         System.out.println("\n\t Type your Player Name: ");
         System.out.print("\t> ");
         player.name = jcb.readLine();
         
         PlayerStatus.playerStatus1(player);
         System.out.println("\n\t [Press enter to start the game]");
         jcb.readLine();
         System.out.println("\n\n___________________________________________________");
         System.out.println("\t\t# STORY GAME #");
         System.out.println("\n");
         Story.Intro();
         jcb.readLine();        
         Story.NextKings();
         jcb.readLine();
         Welcome();
         jcb.readLine();
         battle();
         
     }
     
     public static void continue_(){
         
     }
     
     public static void Welcome() throws IOException{
        Story.Wars();
        jcb.readLine();
        Story.Escape();
        jcb.readLine();
        Story.Summon();
         
     }
     
     //**********************************************************************************BATTLE**************************************************************
     public static void battle()throws IOException{
         jcb = new BufferedReader(new InputStreamReader(System.in));
         BEGGINING:
         rand = new Random();
         int turn = 1;
         boolean gameEnd = true;
         
         while(gameEnd){
            System.out.println("\n");
            System.out.println("___________________________________________________");
            System.out.println("\t# You are now to enter the Dungeon! #");
             System.out.println("\t[Press Enter to Continue]");
            jcb.readLine();

            System.out.println("\n___________________________________________________");
            
            boolean floorOne = true;
            boolean floorTwo = true;
            boolean floorThree = true;
            boolean floorFour = true;
            boolean floorFive = true;
            boolean floorSix = true;
            boolean floorSeven = true;
            boolean floorEight = true;
            boolean floorNine = true;
            boolean floorTen = true;
            boolean running = true;
            
            FLOOR_1://**************************************************FIRST FLOOR************************************************************
            while(floorOne){// ***********************************MONSTER BATTLE*************************************************************
                String[] monstersOne = {"Slime","Zombie","Astral Ghost","Goblin"};// CHANGE PER FLOOR
                int maxMonsterHp = 120;// CHANGE PER FLOOR BY 100
                int monsterAtkDmg = 120;// CHANGE PER FLOOR BY 100
                int hpPotionAmount = 30;// CHANGE PER FLOOR BY 30
                int mpPotionAmount = 30;// CHANGE PER FLOOR BY 30
                int hpPotionDropChance = 50;//percentage
                int mpPotionDropChance = 50;
                
                for(int i = 0; i < monstersOne.length; i+= 1){
                    rand = new Random(i);
                    enemy = new Enemy("",0,0,"",0,0);
                    enemy.hp = rand.nextInt(maxMonsterHp);
                    enemy.name = monstersOne[rand.nextInt(monstersOne.length)];
                    enemy.baseAtk = rand.nextInt(monsterAtkDmg);
                    
                    
                    
                    while(enemy.hp > 0){
                        System.out.println("\n___________________________________________________");
                    System.out.println("\t# "+enemy.name+" has appeared! #\n");
                        
                        System.out.println("\t"+player.name+"'s HP: "+ player.hp);
                        System.out.println("\t"+player.name+"'s MP: "+player.mp);
                        System.out.println("\t"+enemy.name+"'s HP: "+ enemy.hp);
                        System.out.println("\n___________________________________________________");
                        System.out.println("\n\tWhat would you like to do?");
                        LinkStart.battleMenu();
                        System.out.print("\tYour choice: ");
                        int choicef1;
                        
                        try{
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        catch(Exception e){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        while(choicef1 != 1 && choicef1 != 2 && choicef1 != 3 && choicef1 != 4){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        switch(choicef1){
                            case 1:
                                Player.attack();
                                short choicef1_1 = 0;
                                try{
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_1 != 1 && choicef1_1 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
//**********************************************************PHYSICAL ATTACK*********************************************************************
                                if(choicef1_1 == 1){
                                    enemy.hp = player.pAttack(enemy, turn);
                                    player.hp = enemy.pAttack(player, turn);
                                }
//************************************************************SKILL ATTACK**************************************************************************
                                else if(choicef1_1 == 2){
                                    if(player.mp > 0){
                                        player.sAttackMenu1();// ***************************************CHANGE PER 2 FLOOR
                                        int choicef1_2 = 0;
                                        try{
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        catch(Exception e){
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu1();// *********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        while(choicef1_2 != 1 && choicef1_2 != 2){// ****************ADD ANOTHER CHOICE PER 2 FLOOR
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu1();// *********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        switch (choicef1_2) {// *************************************CHANGE PER 2 FLOOR
                                            case 1:
                                                if(player.mp > 30){
                                                    enemy.hp = player.sAttack1(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 30){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 2:
                                                if(player.mp > 50){
                                                    enemy.hp = player.sAttack2(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 50){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;// ******************************ADD ANOTHER CASE FOR THE NEW SKILL
                                            default:
                                                break;
                                        }
                                    }
                                    else if(player.mp <= 0){
                                        player.mp = 0;
                                        System.out.println("\t# You don't have any MP left! Drink an MP potion to restore! #");
                                        player.hp = enemy.pAttack(player, turn);
                                    }
                                }
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_3 = 0;
                                   try{
                                        choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_3 != 1 && choicef1_3 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_3 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_3 == 2){
                                       main(monstersOne);
                                   }
                                }
                                if(enemy.hp <= 0){
                                   System.out.println("\n\t# You defeated the "+enemy.name+"! #");
                                   System.out.println("\t> Remaining HP: " + player.hp);
                                   System.out.println("\t> Remaining MP: " + player.mp);
                                   if(rand.nextInt(100) < hpPotionDropChance){
                                       player.hpPotion++;
                                       System.out.println("\n\t# The enemy drop an HP potion! #");
                                       System.out.println("\t# You have "+ player.hpPotion +" HP potion/s. #");
                                   }
                                   if(rand.nextInt(100) < mpPotionDropChance){
                                       player.mpPotion++;
                                       System.out.println("\n\t# The enemy drop an MP potion! #");
                                       System.out.println("\t# You have "+ player.mpPotion +" MP potion/s. #");
                                   }
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t# PRESS [ENTER] TO PROCEEED. #");
                                   jcb.readLine();
                                   break;
                                }
                                break;
                            case 2:
                                player.hp = player.defend(enemy,turn);
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_4 = 0;
                                   try{
                                        choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_4 != 1 && choicef1_4 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_4 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_4 == 2){
                                       main(monstersOne);
                                   }
                                }//defend algorithm
                                break;
                            case 3:
                                player.itemOption();
                                short choicef1_5 = 0;
                                try{
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_5 != 1 && choicef1_5 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                if(choicef1_5 == 1){
                                    if(player.hpPotion > 0){
                                        if(player.hp < player.maxHp){
                                            player.hp += hpPotionAmount;
                                            if(player.hp > player.maxHp) player.hp = player.maxHp;
                                            player.hpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\n\t# You drink an HP potion, healing by "+hpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.hp+" HP. #");
                                             System.out.println("\t# You have "+ player.hpPotion+" HP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your HP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no HP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                else if(choicef1_5 == 2){
                                    if(player.mpPotion > 0){
                                        if(player.mp < player.maxMp){
                                            player.mp += mpPotionAmount;
                                            if(player.mp > player.maxMp)player.mp = player.maxMp;
                                            player.mpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\t# You drink an MP potion, healing by "+mpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.mp+" MP. #");
                                             System.out.println("\t# You have "+ player.mpPotion+" MP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your MP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no MP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                //item
                                break;
                            case 4:
                                System.out.println("----------------------------------------------------");
                                System.out.println("\n\t# You run away from "+enemy.name+"! #");
                                System.out.println("\t# YOU WEAKLING!!! #");
                                continue FLOOR_1;// ******************************************CHANGE PER FLOOR

                        }
                    }
                }
                
                while(running){//*************************************FIRST BOSS BATTLE************************************************************

                    enemy = new Enemy("Goblin King", 500, 100, "Flying Axe", 200, 50);// CHANGE PER FLOOR ("", +500, + 50, "", +50, +50)
                    System.out.println("\n___________________________________________________");
                    System.out.println("\t# The bossfloor, "+enemy.name+", has appeared! #\n");
                    
                    while(enemy.hp > 0){
                        System.out.println("\t"+player.name+"'s HP: "+ player.hp);
                        System.out.println("\t"+player.name+"'s MP: "+player.mp);
                        System.out.println("\t"+enemy.name+"'s HP: "+ enemy.hp);
                        System.out.println("\n___________________________________________________");
                        System.out.println("[Press Enter to Continue]");
                        jcb.readLine();
                        System.out.println("\n\tWhat would you like to do?");
                        LinkStart.battleMenu();
                        System.out.print("\tYour choice: ");
                        int choicef1;
                        
                        try{
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        catch(Exception e){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        while(choicef1 != 1 && choicef1 != 2 && choicef1 != 3 && choicef1 != 4){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        switch(choicef1){
                            case 1:
                                Player.attack();
                                short choicef1_1 = 0;
                                try{
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_1 != 1 && choicef1_1 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
//**********************************************************PHYSICAL ATTACK*********************************************************************
                                if(choicef1_1 == 1){
                                    enemy.hp = player.pAttack(enemy, turn);
                                    player.hp = enemy.pAttack(player, turn);
                                }
//************************************************************SKILL ATTACK**************************************************************************
                                else if(choicef1_1 == 2){
                                    if(player.mp > 0){
                                        player.sAttackMenu1();// **********************************CHANGE PER 2 FLOOR
                                        int choicef1_2 = 0;
                                        try{
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        catch(Exception e){
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu1();// ********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        while(choicef1_2 != 1 && choicef1_2 != 2){// ****************ADD ANOTHER CHOICE PER 2 FLOOR 
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu1();// ************************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        switch (choicef1_2) {// *******************************************CHANGE PER 2 FLOOR
                                            case 1:
                                                if(player.mp > 30){
                                                    enemy.hp = player.sAttack1(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.sAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 30){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 2:
                                                if(player.mp > 50){
                                                    enemy.hp = player.sAttack2(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.sAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 50){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.sAttack(player, turn);
                                                }
                                                break;//***********************ADD ANOTHER CASE FOR THE NEW SKILL
                                            default:
                                                break;
                                        }
                                    }
                                    else if(player.mp <= 0){
                                        player.mp = 0;
                                        System.out.println("\t# You don't have any MP left! Drink an MP potion to restore! #");
                                        player.hp = enemy.pAttack(player, turn);
                                    }
                                }
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_3 = 0;
                                   try{
                                        choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_3 != 1 && choicef1_3 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_3 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_3 == 2){
                                       main(monstersOne);
                                   }
                                }
                                if(enemy.hp <= 0){
                                   System.out.println("\t> "+enemy.name+" has been slayed! yata! yata! masoooo!\n"
                                   + "\tTHAT'S WICKED!!!!!");
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t> Remaining HP: " + player.hp);
                                   System.out.println("\t> Remaining MP: " + player.mp);
                                   if(rand.nextInt(100) < hpPotionDropChance){
                                       player.hpPotion++;
                                       System.out.println("\n\t# The enemy drop an HP potion! #");
                                       System.out.println("\t# You have "+ player.hpPotion +" HP potion/s. #");
                                   }
                                   if(rand.nextInt(100) < mpPotionDropChance){
                                       player.mpPotion++;
                                       System.out.println("\n\t# The enemy drop an MP potion! #");
                                       System.out.println("\t# You have "+ player.mpPotion +" MP potion/s. #");
                                   }
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t# PRESS [ENTER] TO PROCEEED. #");
                                   jcb.readLine();
                                   break;
                                }
                                break;
                            case 2:
                                player.hp = player.defend(enemy,turn);
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_4 = 0;
                                   try{
                                        choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_4 != 1 && choicef1_4 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_4 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_4 == 2){
                                       main(monstersOne);
                                   }
                                }//defend algorithm
                                break;
                            case 3:
                                player.itemOption();
                                short choicef1_5 = 0;
                                try{
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_5 != 1 && choicef1_5 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                if(choicef1_5 == 1){
                                    if(player.hpPotion > 0){
                                        if(player.hp < player.maxHp){
                                            player.hp += hpPotionAmount;
                                            if(player.hp > player.maxHp) player.hp = player.maxHp;
                                            player.hpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\n\t# You drink an HP potion, healing by "+hpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.hp+" HP. #");
                                             System.out.println("\t# You have "+ player.hpPotion+" HP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your HP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no HP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                else if(choicef1_5 == 2){
                                    if(player.mpPotion > 0){
                                        if(player.mp < player.maxMp){
                                            player.mp += mpPotionAmount;
                                            if(player.mp > player.maxMp)player.mp = player.maxMp;
                                            player.mpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\t# You drink an MP potion, healing by "+mpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.mp+" MP. #");
                                             System.out.println("\t# You have "+ player.mpPotion+" MP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your MP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no MP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                //item
                                break;
                            case 4:
                                System.out.println("----------------------------------------------------");
                                System.out.println("\n\t# You run away from "+enemy.name+"! #");
                                System.out.println("\t# YOU WEAKLING!!! #");
                                continue FLOOR_1;// ***************************************CHANGE PER FLOOR

                        }
                    }
                    break;
                }
                break;
            }
            
//***************************************************************PLAYER STATUS UPDATE**********************************************************************
            player.maxHp += 100;// CHANGE PER FLOOR
            player.hp = player.maxHp;
            player.maxMp += 50;// CHANGE PER FLOOR
            player.mp  = player.maxMp;
            player.baseAtk += 50;// CHANGE PER FLOOR
            player.baseDef += 50;// CHANGE PER FLOOR
            if(player.title == 0){// CHANGE PER FLOOR
                //player.title --- ADD IN FLOOR 4[1], 6[2], 8[3]
                //player.skillId --- ADD IN FLOOR 2[2], 4[3], 6[4], 8[5]
                player.weaponId = 1;// CHANGE PER FLOOR
            }
            else if(player.title == 5){// CHANGE PER FLOOR
                //player.title --- ADD IN FLOOR 4[5], 6[6], 8[7]
                //player.skillId --- ADD IN FLOOR 2[8], 4[9], 6[10], 8[11]
                player.weaponId = 11;// CHANGE PER FLOOR
            }
            else if(player.title == 9){// CHANGE PER FLOOR
                //player.title --- ADD IN FLOOR 4[9], 6[10], 8[11]
                //player.skillId --- ADD IN FLOOR 2[14], 4[15], 6[16], 8[17]
                player.weaponId = 21;// CHANGE PER FLOOR
            }
            player.armorId = 1;// CHANGE PER FLOOR
             System.out.println("\t# You acquired new equipments! #");
             System.out.println("\t> Weapon: "+eqp.getWeaponName(player.weaponId));
             System.out.println("\t> Armor: "+eqp.getArmorName(player.armorId));
             System.out.println("\n\t"+eqp.getWeaponName(player.weaponId)+" equiped.");
             System.out.println("\t"+eqp.getArmorName(player.armorId)+" equiped.");
             System.out.println("\t# PRESS [ENTER] TO PROCEED. #");
             jcb.readLine();
             System.out.println("\n___________________________________________________");
             System.out.println("\t#************PLAYER STATUS LEVEL UP!**************#");
             jcb.readLine();
             //System.out.println("\n\t# ***YOU ARE PROMOTED INTO ["+pclass.getplayerClass(player.title)+"]!*** #");
             //jcb.readLine();
             //System.out.println("\n\t# ***YOU ACQUIRED A NEW SKILL!!!*** #");
             //jcb.readLine();
             //System.out.println("\t\t> "+pskills.getPlayerSkillName(player.skillId(ADD THE NUMBER))+"!");
             //jcb.readLine();
             System.out.println("\n\t# HP increased by 100! #");
             System.out.println("\n\t# MP increased by 50! #");
             jcb.readLine();
             PlayerStatus.playerStatus1(player);// CHANGE PER 2 FLOOR
             System.out.println("\n___________________________________________________");
             System.out.println("\t# PRESS [ENTER] TO PROCEED. #");
             jcb.readLine();
            LinkStart.firstFloorClr();//CHANGE PER FLOOR
             System.out.print("\tYour choice: ");
             short choice = 0;
             
             try{
                 choice = Short.parseShort(jcb.readLine());
             }
             catch(Exception e){
                 System.out.println("\t# INVALID COMMAND! #");
                 System.out.print("\tYour choice: ");
                 choice = Short.parseShort(jcb.readLine());
             }
             while(choice != 1 && choice != 2 && choice != 3){
                 System.out.println("\t# INVALID COMMAND! #");
                 System.out.print("\tYour choice: ");
                 choice = Short.parseShort(jcb.readLine());
             }
             if(choice ==1){
                 System.out.println("\n\t# Great! #");
                 System.out.println("\t# Press [ENTER] to proceed to the next area! #");
                 jcb.readLine();
             }
             else if(choice == 2){
                 System.out.println("You took a short nap");
                 // ***************************************MAKE A SHORT SIMULATION IN CHOICE 2*****************************
                 jcb.readLine();
             }
             else if(choice == 3){
                 System.out.println("\tAhhhhhhhhhhh~~~ What a weakling.\n");
                 System.out.println("\t**************************");
                 System.out.println("\t**************************");
                 System.out.println("\t**THANK YOU FOR PLAYING!**");
                 System.out.println("\t**************************");
                 System.out.println("\t**************************");
                 System.out.println("\n\t> Press [ENTER] to exit.");
                 jcb.readLine();
                 System.exit(0);
             }
             
             //**************************************************FLOOR 2 DIALOGUE INPUT******************************************************
             floorDialogue.secondFloorDialogue(player);
             jcb.readLine();
             
            FLOOR_2://**************************************************SECOND FLOOR************************************************************
            while(floorTwo){// ***********************************MONSTER BATTLE*************************************************************
                String[] monstersOne = {"Mandrake","Ghoul","Poisonous Mushroom","Ogre"};// CHANGE PER FLOOR
                int maxMonsterHp = 200;// CHANGE PER FLOOR BY 100
                int monsterAtkDmg = 200;// CHANGE PER FLOOR BY 100
                int hpPotionAmount = 60;// CHANGE PER FLOOR BY 30
                int mpPotionAmount = 60;// CHANGE PER FLOOR BY 30
                int hpPotionDropChance = 50;//percentage
                int mpPotionDropChance = 50;
                
                for(int i = 0; i < 5; i+= 1){
                    rand = new Random(i);
                    enemy = new Enemy("",0,0,"",0,0);
                    enemy.hp = rand.nextInt(maxMonsterHp);
                    enemy.name = monstersOne[rand.nextInt(monstersOne.length)];
                    enemy.baseAtk = rand.nextInt(monsterAtkDmg);
                    
                    
                    while(enemy.hp > 0){
                        System.out.println("\n___________________________________________________");
                    System.out.println("\t# "+enemy.name+" has appeared! #\n");
                        System.out.println("\t"+player.name+"'s HP: "+ player.hp);
                        System.out.println("\t"+player.name+"'s MP: "+player.mp);
                        System.out.println("\t"+enemy.name+"'s HP: "+ enemy.hp);
                        System.out.println("\n___________________________________________________");
                        System.out.println("\n\tWhat would you like to do?");
                        LinkStart.battleMenu();
                        System.out.print("\tYour choice: ");
                        int choicef1;
                        
                        try{
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        catch(Exception e){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        while(choicef1 != 1 && choicef1 != 2 && choicef1 != 3 && choicef1 != 4){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        switch(choicef1){
                            case 1:
                                Player.attack();
                                short choicef1_1 = 0;
                                try{
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_1 != 1 && choicef1_1 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
//**********************************************************PHYSICAL ATTACK*********************************************************************
                                if(choicef1_1 == 1){
                                    enemy.hp = player.pAttack(enemy, turn);
                                    player.hp = enemy.pAttack(player, turn);
                                }
//************************************************************SKILL ATTACK**************************************************************************
                                else if(choicef1_1 == 2){
                                    if(player.mp > 0){
                                        player.sAttackMenu1();// ***************************************CHANGE PER 2 FLOOR
                                        int choicef1_2 = 0;
                                        try{
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        catch(Exception e){
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu1();// *********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        while(choicef1_2 != 1 && choicef1_2 != 2){// ****************ADD ANOTHER CHOICE PER 2 FLOOR
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu1();// *********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        switch (choicef1_2) {// *************************************CHANGE PER 2 FLOOR
                                            case 1:
                                                if(player.mp > 30){
                                                    enemy.hp = player.sAttack1(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 30){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 2:
                                                if(player.mp > 50){
                                                    enemy.hp = player.sAttack2(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 50){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;// ******************************ADD ANOTHER CASE FOR THE NEW SKILL
                                            default:
                                                break;
                                        }
                                    }
                                    else if(player.mp <= 0){
                                        player.mp = 0;
                                        System.out.println("\t# You don't have any MP left! Drink an MP potion to restore! #");
                                        player.hp = enemy.pAttack(player, turn);
                                    }
                                }
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_3 = 0;
                                   try{
                                        choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_3 != 1 && choicef1_3 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_3 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_3 == 2){
                                       main(monstersOne);
                                   }
                                }
                                if(enemy.hp <= 0){
                                   System.out.println("\n\t# You defeated the "+enemy.name+"! #");
                                   System.out.println("\t> Remaining HP: " + player.hp);
                                   System.out.println("\t> Remaining MP: " + player.mp);
                                   if(rand.nextInt(100) < hpPotionDropChance){
                                       player.hpPotion++;
                                       System.out.println("\n\t# The enemy drop an HP potion! #");
                                       System.out.println("\t# You have "+ player.hpPotion +" HP potion/s. #");
                                   }
                                   if(rand.nextInt(100) < mpPotionDropChance){
                                       player.mpPotion++;
                                       System.out.println("\n\t# The enemy drop an MP potion! #");
                                       System.out.println("\t# You have "+ player.mpPotion +" MP potion/s. #");
                                   }
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t# PRESS [ENTER] TO PROCEEED. #");
                                   jcb.readLine();
                                   break;
                                }
                                break;
                            case 2:
                                player.hp = player.defend(enemy,turn);
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_4 = 0;
                                   try{
                                        choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_4 != 1 && choicef1_4 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_4 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_4 == 2){
                                       main(monstersOne);
                                   }
                                }//defend algorithm
                                break;
                            case 3:
                                player.itemOption();
                                short choicef1_5 = 0;
                                try{
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_5 != 1 && choicef1_5 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                if(choicef1_5 == 1){
                                    if(player.hpPotion > 0){
                                        if(player.hp < player.maxHp){
                                            player.hp += hpPotionAmount;
                                            if(player.hp > player.maxHp) player.hp = player.maxHp;
                                            player.hpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\n\t# You drink an HP potion, healing by "+hpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.hp+" HP. #");
                                             System.out.println("\t# You have "+ player.hpPotion+" HP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your HP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no HP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                else if(choicef1_5 == 2){
                                    if(player.mpPotion > 0){
                                        if(player.mp < player.maxMp){
                                            player.mp += mpPotionAmount;
                                            if(player.mp > player.maxMp)player.mp = player.maxMp;
                                            player.mpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\t# You drink an MP potion, healing by "+mpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.mp+" MP. #");
                                             System.out.println("\t# You have "+ player.mpPotion+" MP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your MP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no MP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                //item
                                break;
                            case 4:
                                System.out.println("----------------------------------------------------");
                                System.out.println("\n\t# You run away from "+enemy.name+"! #");
                                System.out.println("\t# YOU WEAKLING!!! #");
                                continue FLOOR_2;// ******************************************CHANGE PER FLOOR

                        }
                    }
                }
                
                while(running){//*************************************SECOND BOSS BATTLE************************************************************

                    enemy = new Enemy("Oni Ou", 1000, 200, "Blue Blaze", 300, 100);// CHANGE PER FLOOR ("", +500, + 50, "", +50, +50)
                    System.out.println("\n___________________________________________________");
                    System.out.println("\t# The bossfloor, "+enemy.name+", has appeared! #\n");
                    
                    while(enemy.hp > 0){
                        System.out.println("\t"+player.name+"'s HP: "+ player.hp);
                        System.out.println("\t"+player.name+"'s MP: "+player.mp);
                        System.out.println("\t"+enemy.name+"'s HP: "+ enemy.hp);
                        System.out.println("\n___________________________________________________");
                        System.out.println("[Press Enter to Continue]");
                        jcb.readLine();
                        System.out.println("\n\tWhat would you like to do?");
                        LinkStart.battleMenu();
                        System.out.print("\tYour choice: ");
                        int choicef1;
                        
                        try{
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        catch(Exception e){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        while(choicef1 != 1 && choicef1 != 2 && choicef1 != 3 && choicef1 != 4){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        switch(choicef1){
                            case 1:
                                Player.attack();
                                short choicef1_1 = 0;
                                try{
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_1 != 1 && choicef1_1 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
//**********************************************************PHYSICAL ATTACK*********************************************************************
                                if(choicef1_1 == 1){
                                    enemy.hp = player.pAttack(enemy, turn);
                                    player.hp = enemy.pAttack(player, turn);
                                }
//************************************************************SKILL ATTACK**************************************************************************
                                else if(choicef1_1 == 2){
                                    if(player.mp > 0){
                                        player.sAttackMenu1();// **********************************CHANGE PER 2 FLOOR
                                        int choicef1_2 = 0;
                                        try{
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        catch(Exception e){
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu1();// ********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        while(choicef1_2 != 1 && choicef1_2 != 2){// ****************ADD ANOTHER CHOICE PER 2 FLOOR 
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu1();// ************************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        switch (choicef1_2) {// *******************************************CHANGE PER 2 FLOOR
                                            case 1:
                                                if(player.mp > 30){
                                                    enemy.hp = player.sAttack1(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.sAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 30){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 2:
                                                if(player.mp > 50){
                                                    enemy.hp = player.sAttack2(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.sAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 50){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.sAttack(player, turn);
                                                }
                                                break;//***********************ADD ANOTHER CASE FOR THE NEW SKILL
                                            default:
                                                break;
                                        }
                                    }
                                    else if(player.mp <= 0){
                                        player.mp = 0;
                                        System.out.println("\t# You don't have any MP left! Drink an MP potion to restore! #");
                                        player.hp = enemy.pAttack(player, turn);
                                    }
                                }
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_3 = 0;
                                   try{
                                        choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_3 != 1 && choicef1_3 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_3 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_3 == 2){
                                       main(monstersOne);
                                   }
                                }
                                if(enemy.hp <= 0){
                                   System.out.println("\t> "+enemy.name+" has been slayed! yata! yata! masoooo!\n"
                                   + "\tTHAT'S WICKED!!!!!");
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t> Remaining HP: " + player.hp);
                                   System.out.println("\t> Remaining MP: " + player.mp);
                                   if(rand.nextInt(100) < hpPotionDropChance){
                                       player.hpPotion++;
                                       System.out.println("\n\t# The enemy drop an HP potion! #");
                                       System.out.println("\t# You have "+ player.hpPotion +" HP potion/s. #");
                                   }
                                   if(rand.nextInt(100) < mpPotionDropChance){
                                       player.mpPotion++;
                                       System.out.println("\n\t# The enemy drop an MP potion! #");
                                       System.out.println("\t# You have "+ player.mpPotion +" MP potion/s. #");
                                   }
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t# PRESS [ENTER] TO PROCEEED. #");
                                   jcb.readLine();
                                   break;
                                }
                                break;
                            case 2:
                                player.hp = player.defend(enemy,turn);
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_4 = 0;
                                   try{
                                        choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_4 != 1 && choicef1_4 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_4 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_4 == 2){
                                       main(monstersOne);
                                   }
                                }//defend algorithm
                                break;
                            case 3:
                                player.itemOption();
                                short choicef1_5 = 0;
                                try{
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_5 != 1 && choicef1_5 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                if(choicef1_5 == 1){
                                    if(player.hpPotion > 0){
                                        if(player.hp < player.maxHp){
                                            player.hp += hpPotionAmount;
                                            if(player.hp > player.maxHp) player.hp = player.maxHp;
                                            player.hpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\n\t# You drink an HP potion, healing by "+hpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.hp+" HP. #");
                                             System.out.println("\t# You have "+ player.hpPotion+" HP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your HP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no HP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                else if(choicef1_5 == 2){
                                    if(player.mpPotion > 0){
                                        if(player.mp < player.maxMp){
                                            player.mp += mpPotionAmount;
                                            if(player.mp > player.maxMp)player.mp = player.maxMp;
                                            player.mpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\t# You drink an MP potion, healing by "+mpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.mp+" MP. #");
                                             System.out.println("\t# You have "+ player.mpPotion+" MP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your MP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no MP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                //item
                                break;
                            case 4:
                                System.out.println("----------------------------------------------------");
                                System.out.println("\n\t# You run away from "+enemy.name+"! #");
                                System.out.println("\t# YOU WEAKLING!!! #");
                                continue FLOOR_2;// ***************************************CHANGE PER FLOOR

                        }
                    }
                    break;
                }
                break;
            }
            
//***************************************************************PLAYER STATUS UPDATE**********************************************************************
            player.maxHp += 100;
            player.hp = player.maxHp;
            player.maxMp += 50;
            player.mp  = player.maxMp;
            player.baseAtk += 45;
            player.baseDef += 45;
            if(player.title == 0){// CHANGE PER FLOOR
                player.title = 1;//player.title --- ADD IN FLOOR 2[1], 4[2], 6[3]
                player.skillId3 = 2;//player.skillId --- ADD IN FLOOR 2[2], 4[3], 6[4], 8[5]
                player.weaponId = 2;// CHANGE PER FLOOR
            }
            else if(player.title == 4){// CHANGE PER FLOOR
                player.title = 5;//player.title --- ADD IN FLOOR 2[5], 4[6], 6[7]
                player.skillId3 = 8;//player.skillId --- ADD IN FLOOR 2[8], 4[9], 6[10], 8[11]
                player.weaponId = 12;// CHANGE PER FLOOR
            }
            else if(player.title == 8){// CHANGE PER FLOOR
                player.title = 9;//player.title --- ADD IN FLOOR 2[9], 4[10], 6[11]
                player.skillId3 = 14;//player.skillId --- ADD IN FLOOR 2[14], 4[15], 6[16], 8[17]
                player.weaponId = 22;// CHANGE PER FLOOR
            }
            player.armorId = 2;//******************************************* CHANGE PER FLOOR
            
             System.out.println("\t# You acquired new equipments! #");
             System.out.println("\t> Weapon: "+eqp.getWeaponName(player.weaponId));
             System.out.println("\t> Armor: "+eqp.getArmorName(player.armorId));
             System.out.println("\n\t"+eqp.getWeaponName(player.weaponId)+" equiped.");
             System.out.println("\t"+eqp.getArmorName(player.armorId)+" equiped.");
             System.out.println("\t# PRESS [ENTER] TO PROCEED. #");
             jcb.readLine();
             System.out.println("\n___________________________________________________");
             System.out.println("\t#************PLAYER STATUS LEVEL UP!**************#");
             jcb.readLine();
             System.out.println("\n\t# ***YOU ARE PROMOTED INTO ["+pclass.getplayerClass(player.title)+"]!*** #");
             jcb.readLine();
             System.out.println("\n\t# ***YOU ACQUIRED A NEW SKILL!!!*** #");
             jcb.readLine();
             System.out.println("\t\t> "+pskills.getPlayerSkillName(player.skillId3)+"!");
                //System.out.println("\t\t> "+pskills.getPlayerSkillName(player.skillId(ADD THE NUMBER))+"!");
             jcb.readLine();
             System.out.println("\n\t# HP increased by 100! #");
             System.out.println("\n\t# MP increased by 50! #");
             jcb.readLine();
             PlayerStatus.playerStatus2(player);// CHANGE PER 2 FLOOR
             System.out.println("\n___________________________________________________");
             System.out.println("\t# PRESS [ENTER] TO PROCEED. #");
             jcb.readLine();
            LinkStart.secondFloorClr();//CHANGE PER FLOOR
             System.out.print("\tYour choice: ");
             short choice2 = 0;
             
             try{
                 choice2 = Short.parseShort(jcb.readLine());
             }
             catch(Exception e){
                 System.out.println("\t# INVALID COMMAND! #");
                 System.out.print("\tYour choice: ");
                 choice2 = Short.parseShort(jcb.readLine());
             }
             while(choice2 != 1 && choice2 != 2 && choice2 != 3){
                 System.out.println("\t# INVALID COMMAND! #");
                 System.out.print("\tYour choice: ");
                 choice2 = Short.parseShort(jcb.readLine());
             }
             if(choice2 ==1){
                 System.out.println("\n\t# Great! #");
                 System.out.println("\t# Press [ENTER] to proceed to the next area! #");
                 jcb.readLine();
             }
             else if(choice2 == 2){
                 System.out.println("You took a short nap");
                 // ***************************************MAKE A SHORT SIMULATION IN CHOICE 2*****************************
                 jcb.readLine();
             }
             else if(choice2 == 3){
                 System.out.println("\tAhhhhhhhhhhh~~~ What a weakling.\n");
                 System.out.println("\t**************************");
                 System.out.println("\t**************************");
                 System.out.println("\t**THANK YOU FOR PLAYING!**");
                 System.out.println("\t**************************");
                 System.out.println("\t**************************");
                 System.out.println("\n\t> Press [ENTER] to exit.");
                 jcb.readLine();
                 System.exit(0);
             }
             
             //**************************************************FLOOR 3 DIALOGUE INPUT******************************************************
             floorDialogue.thirdFloorDialogue(player);
             jcb.readLine();
             
             FLOOR_3://**************************************************THIRD FLOOR************************************************************
            while(floorThree){// ***********************************MONSTER BATTLE*************************************************************
                String[] monstersOne = {"Wild Crab","Siren","Giant Toad","Sahuagin"};// CHANGE PER FLOOR
                int maxMonsterHp = 300;// CHANGE PER FLOOR BY 100
                int monsterAtkDmg = 300;// CHANGE PER FLOOR BY 100
                int hpPotionAmount = 90;// CHANGE PER FLOOR BY 30
                int mpPotionAmount = 90;// CHANGE PER FLOOR BY 30
                int hpPotionDropChance = 50;//percentage
                int mpPotionDropChance = 50;
                
                for(int i = 0; i < 5; i+= 1){
                    rand = new Random(i);
                    enemy = new Enemy("",0,0,"",0,0);
                    enemy.hp = rand.nextInt(maxMonsterHp);
                    enemy.name = monstersOne[rand.nextInt(monstersOne.length)];
                    enemy.baseAtk = rand.nextInt(monsterAtkDmg);
                    
                    System.out.println("\n___________________________________________________");
                    System.out.println("\t# "+enemy.name+" has appeared! #\n");
                    
                    while(enemy.hp > 0){
                        System.out.println("\t"+player.name+"'s HP: "+ player.hp);
                        System.out.println("\t"+player.name+"'s MP: "+player.mp);
                        System.out.println("\t"+enemy.name+"'s HP: "+ enemy.hp);
                        System.out.println("\n___________________________________________________");
                        System.out.println("\n\tWhat would you like to do?");
                        LinkStart.battleMenu();
                        System.out.print("\tYour choice: ");
                        int choicef1;
                        
                        try{
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        catch(Exception e){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        while(choicef1 != 1 && choicef1 != 2 && choicef1 != 3 && choicef1 != 4){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        switch(choicef1){
                            case 1:
                                Player.attack();
                                short choicef1_1 = 0;
                                try{
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_1 != 1 && choicef1_1 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
//**********************************************************PHYSICAL ATTACK*********************************************************************
                                if(choicef1_1 == 1){
                                    enemy.hp = player.pAttack(enemy, turn);
                                    player.hp = enemy.pAttack(player, turn);
                                }
//************************************************************SKILL ATTACK**************************************************************************
                                else if(choicef1_1 == 2){
                                    if(player.mp > 0){
                                        player.sAttackMenu2();// ***************************************CHANGE PER 2 FLOOR
                                        int choicef1_2 = 0;
                                        try{
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        catch(Exception e){
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu2();// *********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        while(choicef1_2 != 1 && choicef1_2 != 2 && choicef1_2 != 3){// ****************ADD ANOTHER CHOICE PER 2 FLOOR
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu2();// *********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        switch (choicef1_2) {
                                            case 1:
                                                if(player.mp > 30){
                                                    enemy.hp = player.sAttack1(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 30){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 2:
                                                if(player.mp > 50){
                                                    enemy.hp = player.sAttack2(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 50){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 3:
                                                if(player.mp > 75){
                                                    enemy.hp = player.sAttack3(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 75){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;// ******************************ADD ANOTHER CASE FOR THE NEW SKILL
                                            default:
                                                break;
                                        }
                                    }
                                    else if(player.mp <= 0){
                                        player.mp = 0;
                                        System.out.println("\t# You don't have any MP left! Drink an MP potion to restore! #");
                                        player.hp = enemy.pAttack(player, turn);
                                    }
                                }
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_3 = 0;
                                   try{
                                        choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_3 != 1 && choicef1_3 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_3 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_3 == 2){
                                       main(monstersOne);
                                   }
                                }
                                if(enemy.hp <= 0){
                                   System.out.println("\n\t# You defeated the "+enemy.name+"! #");
                                   System.out.println("\t> Remaining HP: " + player.hp);
                                   System.out.println("\t> Remaining MP: " + player.mp);
                                   if(rand.nextInt(100) < hpPotionDropChance){
                                       player.hpPotion++;
                                       System.out.println("\n\t# The enemy drop an HP potion! #");
                                       System.out.println("\t# You have "+ player.hpPotion +" HP potion/s. #");
                                   }
                                   if(rand.nextInt(100) < mpPotionDropChance){
                                       player.mpPotion++;
                                       System.out.println("\n\t# The enemy drop an MP potion! #");
                                       System.out.println("\t# You have "+ player.mpPotion +" MP potion/s. #");
                                   }
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t# PRESS [ENTER] TO PROCEEED. #");
                                   jcb.readLine();
                                   break;
                                }
                                break;
                            case 2:
                                player.hp = player.defend(enemy,turn);
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_4 = 0;
                                   try{
                                        choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_4 != 1 && choicef1_4 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_4 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_4 == 2){
                                       main(monstersOne);
                                   }
                                }//defend algorithm
                                break;
                            case 3:
                                player.itemOption();
                                short choicef1_5 = 0;
                                try{
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_5 != 1 && choicef1_5 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                if(choicef1_5 == 1){
                                    if(player.hpPotion > 0){
                                        if(player.hp < player.maxHp){
                                            player.hp += hpPotionAmount;
                                            if(player.hp > player.maxHp) player.hp = player.maxHp;
                                            player.hpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\n\t# You drink an HP potion, healing by "+hpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.hp+" HP. #");
                                             System.out.println("\t# You have "+ player.hpPotion+" HP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your HP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no HP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                else if(choicef1_5 == 2){
                                    if(player.mpPotion > 0){
                                        if(player.mp < player.maxMp){
                                            player.mp += mpPotionAmount;
                                            if(player.mp > player.maxMp)player.mp = player.maxMp;
                                            player.mpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\t# You drink an MP potion, healing by "+mpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.mp+" MP. #");
                                             System.out.println("\t# You have "+ player.mpPotion+" MP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your MP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no MP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                //item
                                break;
                            case 4:
                                System.out.println("----------------------------------------------------");
                                System.out.println("\n\t# You run away from "+enemy.name+"! #");
                                System.out.println("\t# YOU WEAKLING!!! #");
                                continue FLOOR_3;// ******************************************CHANGE PER FLOOR

                        }
                    }
                }
                
                while(running){//*************************************THIRD BOSS BATTLE************************************************************

                    enemy = new Enemy("Hydra", 1500, 300, "Acidic Saliva", 400, 150);// CHANGE PER FLOOR ("", +500, + 50, "", +50, +50)
                    System.out.println("\n___________________________________________________");
                    System.out.println("\t# The bossfloor, "+enemy.name+", has appeared! #\n");
                    
                    while(enemy.hp > 0){
                        System.out.println("\t"+player.name+"'s HP: "+ player.hp);
                        System.out.println("\t"+player.name+"'s MP: "+player.mp);
                        System.out.println("\t"+enemy.name+"'s HP: "+ enemy.hp);
                        System.out.println("\n___________________________________________________");
                        System.out.println("[Press Enter to Continue]");
                        jcb.readLine();
                        System.out.println("\n\tWhat would you like to do?");
                        LinkStart.battleMenu();
                        System.out.print("\tYour choice: ");
                        int choicef1;
                        
                        try{
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        catch(Exception e){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        while(choicef1 != 1 && choicef1 != 2 && choicef1 != 3 && choicef1 != 4){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        switch(choicef1){
                            case 1:
                                Player.attack();
                                short choicef1_1 = 0;
                                try{
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_1 != 1 && choicef1_1 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
//**********************************************************PHYSICAL ATTACK*********************************************************************
                                if(choicef1_1 == 1){
                                    enemy.hp = player.pAttack(enemy, turn);
                                    player.hp = enemy.pAttack(player, turn);
                                }
//************************************************************SKILL ATTACK**************************************************************************
                                else if(choicef1_1 == 2){
                                    if(player.mp > 0){
                                        player.sAttackMenu2();// **********************************CHANGE PER 2 FLOOR
                                        int choicef1_2 = 0;
                                        try{
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        catch(Exception e){
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu2();// ********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        while(choicef1_2 != 1 && choicef1_2 != 2 && choicef1_2 != 3){// ****************ADD ANOTHER CHOICE PER 2 FLOOR 
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu2();// ************************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        switch (choicef1_2) {
                                            case 1:
                                                if(player.mp > 30){
                                                    enemy.hp = player.sAttack1(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.sAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 30){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 2:
                                                if(player.mp > 50){
                                                    enemy.hp = player.sAttack2(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.sAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 50){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.sAttack(player, turn);
                                                }
                                                break;
                                            case 3:
                                                if(player.mp > 75){
                                                    enemy.hp = player.sAttack3(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.sAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 75){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.sAttack(player, turn);
                                                }
                                                break;//***********************ADD ANOTHER CASE FOR THE NEW SKILL
                                            default:
                                                break;
                                        }
                                    }
                                    else if(player.mp <= 0){
                                        player.mp = 0;
                                        System.out.println("\t# You don't have any MP left! Drink an MP potion to restore! #");
                                        player.hp = enemy.pAttack(player, turn);
                                    }
                                }
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_3 = 0;
                                   try{
                                        choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_3 != 1 && choicef1_3 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_3 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_3 == 2){
                                       main(monstersOne);
                                   }
                                }
                                if(enemy.hp <= 0){
                                   System.out.println("\t> "+enemy.name+" has been slayed! yata! yata! masoooo!\n"
                                   + "\tTHAT'S WICKED!!!!!");
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t> Remaining HP: " + player.hp);
                                   System.out.println("\t> Remaining MP: " + player.mp);
                                   if(rand.nextInt(100) < hpPotionDropChance){
                                       player.hpPotion++;
                                       System.out.println("\n\t# The enemy drop an HP potion! #");
                                       System.out.println("\t# You have "+ player.hpPotion +" HP potion/s. #");
                                   }
                                   if(rand.nextInt(100) < mpPotionDropChance){
                                       player.mpPotion++;
                                       System.out.println("\n\t# The enemy drop an MP potion! #");
                                       System.out.println("\t# You have "+ player.mpPotion +" MP potion/s. #");
                                   }
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t# PRESS [ENTER] TO PROCEEED. #");
                                   jcb.readLine();
                                   break;
                                }
                                break;
                            case 2:
                                player.hp = player.defend(enemy,turn);
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_4 = 0;
                                   try{
                                        choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_4 != 1 && choicef1_4 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_4 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_4 == 2){
                                       main(monstersOne);
                                   }
                                }//defend algorithm
                                break;
                            case 3:
                                player.itemOption();
                                short choicef1_5 = 0;
                                try{
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_5 != 1 && choicef1_5 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                if(choicef1_5 == 1){
                                    if(player.hpPotion > 0){
                                        if(player.hp < player.maxHp){
                                            player.hp += hpPotionAmount;
                                            if(player.hp > player.maxHp) player.hp = player.maxHp;
                                            player.hpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\n\t# You drink an HP potion, healing by "+hpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.hp+" HP. #");
                                             System.out.println("\t# You have "+ player.hpPotion+" HP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your HP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no HP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                else if(choicef1_5 == 2){
                                    if(player.mpPotion > 0){
                                        if(player.mp < player.maxMp){
                                            player.mp += mpPotionAmount;
                                            if(player.mp > player.maxMp)player.mp = player.maxMp;
                                            player.mpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\t# You drink an MP potion, healing by "+mpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.mp+" MP. #");
                                             System.out.println("\t# You have "+ player.mpPotion+" MP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your MP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no MP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                //item
                                break;
                            case 4:
                                System.out.println("----------------------------------------------------");
                                System.out.println("\n\t# You run away from "+enemy.name+"! #");
                                System.out.println("\t# YOU WEAKLING!!! #");
                                continue FLOOR_3;// ***************************************CHANGE PER FLOOR

                        }
                    }
                    break;
                }
                break;
            }
            
//***************************************************************PLAYER STATUS UPDATE**********************************************************************
            player.maxHp += 100;
            player.hp = player.maxHp;
            player.maxMp += 50;
            player.mp  = player.maxMp;
            player.baseAtk += 40;
            player.baseDef += 40;
            if(player.title == 1){// CHANGE PER FLOOR
                //player.title --- ADD IN FLOOR 2[1], 4[2], 6[3]
                //player.skillId --- ADD IN FLOOR 2[2], 4[3], 6[4], 8[5]
                player.weaponId = 3;// CHANGE PER FLOOR
            }
            else if(player.title == 5){// CHANGE PER FLOOR
                //player.title --- ADD IN FLOOR 2[5], 4[6], 6[7]
                //player.skillId --- ADD IN FLOOR 2[8], 4[9], 6[10], 8[11]
                player.weaponId = 13;// CHANGE PER FLOOR
            }
            else if(player.title == 9){// CHANGE PER FLOOR
                //player.title --- ADD IN FLOOR 2[9], 4[10], 6[11]
                //player.skillId --- ADD IN FLOOR 2[14], 4[15], 6[16], 8[17]
                player.weaponId = 23;// CHANGE PER FLOOR
            }
            player.armorId = 3;//******************************************* CHANGE PER FLOOR
            
             System.out.println("\t# You acquired new equipments! #");
             System.out.println("\t> Weapon: "+eqp.getWeaponName(player.weaponId));
             System.out.println("\t> Armor: "+eqp.getArmorName(player.armorId));
             System.out.println("\n\t"+eqp.getWeaponName(player.weaponId)+" equiped.");
             System.out.println("\t"+eqp.getArmorName(player.armorId)+" equiped.");
             System.out.println("\t# PRESS [ENTER] TO PROCEED. #");
             jcb.readLine();
             System.out.println("\n___________________________________________________");
             System.out.println("\t#************PLAYER STATUS LEVEL UP!**************#");
             jcb.readLine();
             //System.out.println("\n\t# ***YOU ARE PROMOTED INTO ["+pclass.getplayerClass(player.title)+"]!*** #");
             //jcb.readLine();
             //System.out.println("\n\t# ***YOU ACQUIRED A NEW SKILL!!!*** #");
             //jcb.readLine();
             //System.out.println("\t\t> "+pskills.getPlayerSkillName(player.skillId(ADD THE NUMBER))+"!");
             //jcb.readLine();
             System.out.println("\n\t# HP increased by 100! #");
             System.out.println("\n\t# MP increased by 50! #");
             jcb.readLine();
             PlayerStatus.playerStatus2(player);//**************** CHANGE PER 2 FLOOR
             System.out.println("\n___________________________________________________");
             System.out.println("\t# PRESS [ENTER] TO PROCEED. #");
             jcb.readLine();
            LinkStart.thirdFloorClr();//***************************CHANGE PER FLOOR
             System.out.print("\tYour choice: ");
             short choice3 = 0;
             
             try{
                 choice3 = Short.parseShort(jcb.readLine());
             }
             catch(Exception e){
                 System.out.println("\t# INVALID COMMAND! #");
                 System.out.print("\tYour choice: ");
                 choice3 = Short.parseShort(jcb.readLine());
             }
             while(choice3 != 1 && choice3 != 2 && choice3 != 3){
                 System.out.println("\t# INVALID COMMAND! #");
                 System.out.print("\tYour choice: ");
                 choice3 = Short.parseShort(jcb.readLine());
             }
             if(choice3 ==1){
                 System.out.println("\n\t# Great! #");
                 System.out.println("\t# Press [ENTER] to proceed to the next area! #");
                 jcb.readLine();
             }
             else if(choice3 == 2){
                 System.out.println("You took a short nap");
                 // ***************************************MAKE A SHORT SIMULATION IN CHOICE 2*****************************
                 jcb.readLine();
             }
             else if(choice3 == 3){
                 System.out.println("\tAhhhhhhhhhhh~~~ What a weakling.\n");
                 System.out.println("\t**************************");
                 System.out.println("\t**************************");
                 System.out.println("\t**THANK YOU FOR PLAYING!**");
                 System.out.println("\t**************************");
                 System.out.println("\t**************************");
                 System.out.println("\n\t> Press [ENTER] to exit.");
                 jcb.readLine();
                 System.exit(0);
             }


             //**************************************************FLOOR 4 DIALOGUE INPUT******************************************************
             floorDialogue.fourthFloorDialogue(player);
             jcb.readLine();
             
             FLOOR_4://**************************************************FOURTH FLOOR************************************************************
            while(floorFour){// ***********************************MONSTER BATTLE*************************************************************
                String[] monstersOne = {"Giant bat","Gale","Harpy","Wyvern"};// CHANGE PER FLOOR
                int maxMonsterHp = 400;// CHANGE PER FLOOR BY 100
                int monsterAtkDmg = 400;// CHANGE PER FLOOR BY 100
                int hpPotionAmount = 120;// CHANGE PER FLOOR BY 30
                int mpPotionAmount = 120;// CHANGE PER FLOOR BY 30
                int hpPotionDropChance = 50;//percentage
                int mpPotionDropChance = 50;
                
                for(int i = 0; i < 5; i+= 1){
                    rand = new Random(i);
                    enemy = new Enemy("",0,0,"",0,0);
                    enemy.hp = rand.nextInt(maxMonsterHp);
                    enemy.name = monstersOne[rand.nextInt(monstersOne.length)];
                    enemy.baseAtk = rand.nextInt(monsterAtkDmg);
                    
                    System.out.println("\n___________________________________________________");
                    System.out.println("\t# "+enemy.name+" has appeared! #\n");
                    
                    while(enemy.hp > 0){
                        System.out.println("\t"+player.name+"'s HP: "+ player.hp);
                        System.out.println("\t"+player.name+"'s MP: "+player.mp);
                        System.out.println("\t"+enemy.name+"'s HP: "+ enemy.hp);
                        System.out.println("\n___________________________________________________");
                        System.out.println("\n\tWhat would you like to do?");
                        LinkStart.battleMenu();
                        System.out.print("\tYour choice: ");
                        int choicef1;
                        
                        try{
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        catch(Exception e){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        while(choicef1 != 1 && choicef1 != 2 && choicef1 != 3 && choicef1 != 4){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        switch(choicef1){
                            case 1:
                                Player.attack();
                                short choicef1_1 = 0;
                                try{
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_1 != 1 && choicef1_1 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
//**********************************************************PHYSICAL ATTACK*********************************************************************
                                if(choicef1_1 == 1){
                                    enemy.hp = player.pAttack(enemy, turn);
                                    player.hp = enemy.pAttack(player, turn);
                                }
//************************************************************SKILL ATTACK**************************************************************************
                                else if(choicef1_1 == 2){
                                    if(player.mp > 0){
                                        player.sAttackMenu2();// ***************************************CHANGE PER 2 FLOOR
                                        int choicef1_2 = 0;
                                        try{
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        catch(Exception e){
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu2();// *********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        while(choicef1_2 != 1 && choicef1_2 != 2 && choicef1_2 != 3){// ****************ADD ANOTHER CHOICE PER 2 FLOOR
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu2();// *********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        switch (choicef1_2) {
                                            case 1:
                                                if(player.mp > 30){
                                                    enemy.hp = player.sAttack1(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 30){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 2:
                                                if(player.mp > 50){
                                                    enemy.hp = player.sAttack2(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 50){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 3:
                                                if(player.mp > 75){
                                                    enemy.hp = player.sAttack3(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 75){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;// ******************************ADD ANOTHER CASE FOR THE NEW SKILL
                                            default:
                                                break;
                                        }
                                    }
                                    else if(player.mp <= 0){
                                        player.mp = 0;
                                        System.out.println("\t# You don't have any MP left! Drink an MP potion to restore! #");
                                        player.hp = enemy.pAttack(player, turn);
                                    }
                                }
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_3 = 0;
                                   try{
                                        choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_3 != 1 && choicef1_3 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_3 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_3 == 2){
                                       main(monstersOne);
                                   }
                                }
                                if(enemy.hp <= 0){
                                   System.out.println("\n\t# You defeated the "+enemy.name+"! #");
                                   System.out.println("\t> Remaining HP: " + player.hp);
                                   System.out.println("\t> Remaining MP: " + player.mp);
                                   if(rand.nextInt(100) < hpPotionDropChance){
                                       player.hpPotion++;
                                       System.out.println("\n\t# The enemy drop an HP potion! #");
                                       System.out.println("\t# You have "+ player.hpPotion +" HP potion/s. #");
                                   }
                                   if(rand.nextInt(100) < mpPotionDropChance){
                                       player.mpPotion++;
                                       System.out.println("\n\t# The enemy drop an MP potion! #");
                                       System.out.println("\t# You have "+ player.mpPotion +" MP potion/s. #");
                                   }
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t# PRESS [ENTER] TO PROCEEED. #");
                                   jcb.readLine();
                                   break;
                                }
                                break;
                            case 2:
                                player.hp = player.defend(enemy,turn);
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_4 = 0;
                                   try{
                                        choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_4 != 1 && choicef1_4 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_4 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_4 == 2){
                                       main(monstersOne);
                                   }
                                }//defend algorithm
                                break;
                            case 3:
                                player.itemOption();
                                short choicef1_5 = 0;
                                try{
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_5 != 1 && choicef1_5 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                if(choicef1_5 == 1){
                                    if(player.hpPotion > 0){
                                        if(player.hp < player.maxHp){
                                            player.hp += hpPotionAmount;
                                            if(player.hp > player.maxHp) player.hp = player.maxHp;
                                            player.hpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\n\t# You drink an HP potion, healing by "+hpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.hp+" HP. #");
                                             System.out.println("\t# You have "+ player.hpPotion+" HP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your HP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no HP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                else if(choicef1_5 == 2){
                                    if(player.mpPotion > 0){
                                        if(player.mp < player.maxMp){
                                            player.mp += mpPotionAmount;
                                            if(player.mp > player.maxMp)player.mp = player.maxMp;
                                            player.mpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\t# You drink an MP potion, healing by "+mpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.mp+" MP. #");
                                             System.out.println("\t# You have "+ player.mpPotion+" MP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your MP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no MP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                //item
                                break;
                            case 4:
                                System.out.println("----------------------------------------------------");
                                System.out.println("\n\t# You run away from "+enemy.name+"! #");
                                System.out.println("\t# YOU WEAKLING!!! #");
                                continue FLOOR_4;// ******************************************CHANGE PER FLOOR

                        }
                    }
                }
                
                while(running){//*************************************FOURTH BOSS BATTLE************************************************************

                    enemy = new Enemy("Mantecore", 2000, 400, "Wind Slash", 500, 200);// CHANGE PER FLOOR ("", +500, + 50, "", +50, +50)
                    System.out.println("\n___________________________________________________");
                    System.out.println("\t# The bossfloor, "+enemy.name+", has appeared! #\n");
                    
                    while(enemy.hp > 0){
                        System.out.println("\t"+player.name+"'s HP: "+ player.hp);
                        System.out.println("\t"+player.name+"'s MP: "+player.mp);
                        System.out.println("\t"+enemy.name+"'s HP: "+ enemy.hp);
                        System.out.println("\n___________________________________________________");
                        System.out.println("[Press Enter to Continue]");
                        jcb.readLine();
                        System.out.println("\n\tWhat would you like to do?");
                        LinkStart.battleMenu();
                        System.out.print("\tYour choice: ");
                        int choicef1;
                        
                        try{
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        catch(Exception e){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        while(choicef1 != 1 && choicef1 != 2 && choicef1 != 3 && choicef1 != 4){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        switch(choicef1){
                            case 1:
                                Player.attack();
                                short choicef1_1 = 0;
                                try{
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_1 != 1 && choicef1_1 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
//**********************************************************PHYSICAL ATTACK*********************************************************************
                                if(choicef1_1 == 1){
                                    enemy.hp = player.pAttack(enemy, turn);
                                    player.hp = enemy.pAttack(player, turn);
                                }
//************************************************************SKILL ATTACK**************************************************************************
                                else if(choicef1_1 == 2){
                                    if(player.mp > 0){
                                        player.sAttackMenu2();// **********************************CHANGE PER 2 FLOOR
                                        int choicef1_2 = 0;
                                        try{
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        catch(Exception e){
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu2();// ********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        while(choicef1_2 != 1 && choicef1_2 != 2 && choicef1_2 != 3){// ****************ADD ANOTHER CHOICE PER 2 FLOOR 
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu2();// ************************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        switch (choicef1_2) {
                                            case 1:
                                                if(player.mp > 30){
                                                    enemy.hp = player.sAttack1(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.sAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 30){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 2:
                                                if(player.mp > 50){
                                                    enemy.hp = player.sAttack2(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.sAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 50){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.sAttack(player, turn);
                                                }
                                                break;
                                            case 3:
                                                if(player.mp > 75){
                                                    enemy.hp = player.sAttack3(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.sAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 75){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.sAttack(player, turn);
                                                }
                                                break;//***********************ADD ANOTHER CASE FOR THE NEW SKILL
                                            default:
                                                break;
                                        }
                                    }
                                    else if(player.mp <= 0){
                                        player.mp = 0;
                                        System.out.println("\t# You don't have any MP left! Drink an MP potion to restore! #");
                                        player.hp = enemy.pAttack(player, turn);
                                    }
                                }
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_3 = 0;
                                   try{
                                        choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_3 != 1 && choicef1_3 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_3 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_3 == 2){
                                       main(monstersOne);
                                   }
                                }
                                if(enemy.hp <= 0){
                                   System.out.println("\t> "+enemy.name+" has been slayed! yata! yata! masoooo!\n"
                                   + "\tTHAT'S WICKED!!!!!");
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t> Remaining HP: " + player.hp);
                                   System.out.println("\t> Remaining MP: " + player.mp);
                                   if(rand.nextInt(100) < hpPotionDropChance){
                                       player.hpPotion++;
                                       System.out.println("\n\t# The enemy drop an HP potion! #");
                                       System.out.println("\t# You have "+ player.hpPotion +" HP potion/s. #");
                                   }
                                   if(rand.nextInt(100) < mpPotionDropChance){
                                       player.mpPotion++;
                                       System.out.println("\n\t# The enemy drop an MP potion! #");
                                       System.out.println("\t# You have "+ player.mpPotion +" MP potion/s. #");
                                   }
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t# PRESS [ENTER] TO PROCEEED. #");
                                   jcb.readLine();
                                   break;
                                }
                                break;
                            case 2:
                                player.hp = player.defend(enemy,turn);
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_4 = 0;
                                   try{
                                        choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_4 != 1 && choicef1_4 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_4 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_4 == 2){
                                       main(monstersOne);
                                   }
                                }//defend algorithm
                                break;
                            case 3:
                                player.itemOption();
                                short choicef1_5 = 0;
                                try{
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_5 != 1 && choicef1_5 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                if(choicef1_5 == 1){
                                    if(player.hpPotion > 0){
                                        if(player.hp < player.maxHp){
                                            player.hp += hpPotionAmount;
                                            if(player.hp > player.maxHp) player.hp = player.maxHp;
                                            player.hpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\n\t# You drink an HP potion, healing by "+hpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.hp+" HP. #");
                                             System.out.println("\t# You have "+ player.hpPotion+" HP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your HP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no HP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                else if(choicef1_5 == 2){
                                    if(player.mpPotion > 0){
                                        if(player.mp < player.maxMp){
                                            player.mp += mpPotionAmount;
                                            if(player.mp > player.maxMp)player.mp = player.maxMp;
                                            player.mpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\t# You drink an MP potion, healing by "+mpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.mp+" MP. #");
                                             System.out.println("\t# You have "+ player.mpPotion+" MP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your MP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no MP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                //item
                                break;
                            case 4:
                                System.out.println("----------------------------------------------------");
                                System.out.println("\n\t# You run away from "+enemy.name+"! #");
                                System.out.println("\t# YOU WEAKLING!!! #");
                                continue FLOOR_4;// ***************************************CHANGE PER FLOOR

                        }
                    }
                    break;
                }
                break;
            }
            
//***************************************************************PLAYER STATUS UPDATE**********************************************************************
            player.maxHp += 100;
            player.hp = player.maxHp;
            player.maxMp += 50;
            player.mp  = player.maxMp;
            player.baseAtk += 35;
            player.baseDef += 35;
            if(player.title == 1){// CHANGE PER FLOOR
                player.title = 2;//player.title --- ADD IN FLOOR 2[1], 4[2], 6[3]
                player.skillId4 = 3;//player.skillId --- ADD IN FLOOR 2[2], 4[3], 6[4], 8[5]
                player.weaponId = 4;// CHANGE PER FLOOR
            }
            else if(player.title == 5){// CHANGE PER FLOOR
                player.title = 6;//player.title --- ADD IN FLOOR 2[5], 4[6], 6[7]
                player.skillId4 = 9;//player.skillId --- ADD IN FLOOR 2[8], 4[9], 6[10], 8[11]
                player.weaponId = 14;// CHANGE PER FLOOR
            }
            else if(player.title == 9){// CHANGE PER FLOOR
                player.title = 10;//player.title --- ADD IN FLOOR 2[9], 4[10], 6[11]
                player.skillId4 = 15;//player.skillId --- ADD IN FLOOR 2[14], 4[15], 6[16], 8[17]
                player.weaponId = 24;// CHANGE PER FLOOR
            }
            player.armorId = 4;//******************************************* CHANGE PER FLOOR
            
             System.out.println("\t# You acquired new equipments! #");
             System.out.println("\t> Weapon: "+eqp.getWeaponName(player.weaponId));
             System.out.println("\t> Armor: "+eqp.getArmorName(player.armorId));
             System.out.println("\n\t"+eqp.getWeaponName(player.weaponId)+" equiped.");
             System.out.println("\t"+eqp.getArmorName(player.armorId)+" equiped.");
             System.out.println("\t# PRESS [ENTER] TO PROCEED. #");
             jcb.readLine();
             System.out.println("\n___________________________________________________");
             System.out.println("\t#************PLAYER STATUS LEVEL UP!**************#");
             jcb.readLine();
             System.out.println("\n\t# ***YOU ARE PROMOTED INTO ["+pclass.getplayerClass(player.title)+"]!*** #");
             jcb.readLine();
             System.out.println("\n\t# ***YOU ACQUIRED A NEW SKILL!!!*** #");
             jcb.readLine();
             System.out.println("\t\t> "+pskills.getPlayerSkillName(player.skillId4)+"!");
             jcb.readLine();
             System.out.println("\n\t# HP increased by 100! #");
             System.out.println("\n\t# MP increased by 50! #");
             jcb.readLine();
             PlayerStatus.playerStatus3(player);//**************** CHANGE PER 2 FLOOR
             System.out.println("\n___________________________________________________");
             System.out.println("\t# PRESS [ENTER] TO PROCEED. #");
             jcb.readLine();
            LinkStart.fourthFloorClr();//***************************CHANGE PER FLOOR
             System.out.print("\tYour choice: ");
             short choice4 = 0;
             
             try{
                 choice4 = Short.parseShort(jcb.readLine());
             }
             catch(Exception e){
                 System.out.println("\t# INVALID COMMAND! #");
                 System.out.print("\tYour choice: ");
                 choice4 = Short.parseShort(jcb.readLine());
             }
             while(choice4 != 1 && choice4 != 2 && choice4 != 3){
                 System.out.println("\t# INVALID COMMAND! #");
                 System.out.print("\tYour choice: ");
                 choice4 = Short.parseShort(jcb.readLine());
             }
             if(choice4 ==1){
                 System.out.println("\n\t# Great! #");
                 System.out.println("\t# Press [ENTER] to proceed to the next area! #");
                 jcb.readLine();
             }
             else if(choice4 == 2){
                 System.out.println("You took a short nap");
                 // ***************************************MAKE A SHORT SIMULATION IN CHOICE 2*****************************
                 jcb.readLine();
             }
             else if(choice4 == 3){
                 System.out.println("\tAhhhhhhhhhhh~~~ What a weakling.\n");
                 System.out.println("\t**************************");
                 System.out.println("\t**************************");
                 System.out.println("\t**THANK YOU FOR PLAYING!**");
                 System.out.println("\t**************************");
                 System.out.println("\t**************************");
                 System.out.println("\n\t> Press [ENTER] to exit.");
                 jcb.readLine();
                 System.exit(0);
             }
             
             //**************************************************FLOOR 5 DIALOGUE INPUT******************************************************
             floorDialogue.fifthFloorDialogue(player);
             jcb.readLine();
             
             FLOOR_5://**************************************************FIFTH FLOOR************************************************************
            while(floorFive){// ***********************************MONSTER BATTLE*************************************************************
                String[] monstersOne = {"Fenrir","Dark Spirit","Demon","Nue"};// CHANGE PER FLOOR
                int maxMonsterHp = 500;// CHANGE PER FLOOR BY 100
                int monsterAtkDmg = 500;// CHANGE PER FLOOR BY 100
                int hpPotionAmount = 150;// CHANGE PER FLOOR BY 30
                int mpPotionAmount = 150;// CHANGE PER FLOOR BY 30
                int hpPotionDropChance = 50;//percentage
                int mpPotionDropChance = 50;
                
                for(int i = 0; i < 5; i+= 1){
                    rand = new Random(i);
                    enemy = new Enemy("",0,0,"",0,0);
                    enemy.hp = rand.nextInt(maxMonsterHp);
                    enemy.name = monstersOne[rand.nextInt(monstersOne.length)];
                    enemy.baseAtk = rand.nextInt(monsterAtkDmg);
                    
                    System.out.println("\n___________________________________________________");
                    System.out.println("\t# "+enemy.name+" has appeared! #\n");
                    
                    while(enemy.hp > 0){
                        System.out.println("\t"+player.name+"'s HP: "+ player.hp);
                        System.out.println("\t"+player.name+"'s MP: "+player.mp);
                        System.out.println("\t"+enemy.name+"'s HP: "+ enemy.hp);
                        System.out.println("\n___________________________________________________");
                        System.out.println("\n\tWhat would you like to do?");
                        LinkStart.battleMenu();
                        System.out.print("\tYour choice: ");
                        int choicef1;
                        
                        try{
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        catch(Exception e){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        while(choicef1 != 1 && choicef1 != 2 && choicef1 != 3 && choicef1 != 4){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        switch(choicef1){
                            case 1:
                                Player.attack();
                                short choicef1_1 = 0;
                                try{
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_1 != 1 && choicef1_1 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
//**********************************************************PHYSICAL ATTACK*********************************************************************
                                if(choicef1_1 == 1){
                                    enemy.hp = player.pAttack(enemy, turn);
                                    player.hp = enemy.pAttack(player, turn);
                                }
//************************************************************SKILL ATTACK**************************************************************************
                                else if(choicef1_1 == 2){
                                    if(player.mp > 0){
                                        player.sAttackMenu3();// ***************************************CHANGE PER 2 FLOOR
                                        int choicef1_2 = 0;
                                        try{
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        catch(Exception e){
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu3();// *********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        while(choicef1_2 != 1 && choicef1_2 != 2 && choicef1_2 != 3 && choicef1_2 != 4){// ****************ADD ANOTHER CHOICE PER 2 FLOOR
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu3();// *********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        switch (choicef1_2) {
                                            case 1:
                                                if(player.mp > 30){
                                                    enemy.hp = player.sAttack1(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 30){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 2:
                                                if(player.mp > 50){
                                                    enemy.hp = player.sAttack2(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 50){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 3:
                                                if(player.mp > 75){
                                                    enemy.hp = player.sAttack3(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 75){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 4:
                                                if(player.mp > 100){
                                                    enemy.hp = player.sAttack4(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 100){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;// ******************************ADD ANOTHER CASE FOR THE NEW SKILL
                                            default:
                                                break;
                                        }
                                    }
                                    else if(player.mp <= 0){
                                        player.mp = 0;
                                        System.out.println("\t# You don't have any MP left! Drink an MP potion to restore! #");
                                        player.hp = enemy.pAttack(player, turn);
                                    }
                                }
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_3 = 0;
                                   try{
                                        choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_3 != 1 && choicef1_3 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_3 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_3 == 2){
                                       main(monstersOne);
                                   }
                                }
                                if(enemy.hp <= 0){
                                   System.out.println("\n\t# You defeated the "+enemy.name+"! #");
                                   System.out.println("\t> Remaining HP: " + player.hp);
                                   System.out.println("\t> Remaining MP: " + player.mp);
                                   if(rand.nextInt(100) < hpPotionDropChance){
                                       player.hpPotion++;
                                       System.out.println("\n\t# The enemy drop an HP potion! #");
                                       System.out.println("\t# You have "+ player.hpPotion +" HP potion/s. #");
                                   }
                                   if(rand.nextInt(100) < mpPotionDropChance){
                                       player.mpPotion++;
                                       System.out.println("\n\t# The enemy drop an MP potion! #");
                                       System.out.println("\t# You have "+ player.mpPotion +" MP potion/s. #");
                                   }
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t# PRESS [ENTER] TO PROCEEED. #");
                                   jcb.readLine();
                                   break;
                                }
                                break;
                            case 2:
                                player.hp = player.defend(enemy,turn);
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_4 = 0;
                                   try{
                                        choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_4 != 1 && choicef1_4 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_4 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_4 == 2){
                                       main(monstersOne);
                                   }
                                }//defend algorithm
                                break;
                            case 3:
                                player.itemOption();
                                short choicef1_5 = 0;
                                try{
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_5 != 1 && choicef1_5 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                if(choicef1_5 == 1){
                                    if(player.hpPotion > 0){
                                        if(player.hp < player.maxHp){
                                            player.hp += hpPotionAmount;
                                            if(player.hp > player.maxHp) player.hp = player.maxHp;
                                            player.hpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\n\t# You drink an HP potion, healing by "+hpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.hp+" HP. #");
                                             System.out.println("\t# You have "+ player.hpPotion+" HP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your HP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no HP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                else if(choicef1_5 == 2){
                                    if(player.mpPotion > 0){
                                        if(player.mp < player.maxMp){
                                            player.mp += mpPotionAmount;
                                            if(player.mp > player.maxMp)player.mp = player.maxMp;
                                            player.mpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\t# You drink an MP potion, healing by "+mpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.mp+" MP. #");
                                             System.out.println("\t# You have "+ player.mpPotion+" MP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your MP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no MP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                //item
                                break;
                            case 4:
                                System.out.println("----------------------------------------------------");
                                System.out.println("\n\t# You run away from "+enemy.name+"! #");
                                System.out.println("\t# YOU WEAKLING!!! #");
                                continue FLOOR_5;// ******************************************CHANGE PER FLOOR

                        }
                    }
                }
                
                while(running){//*************************************FIFTH BOSS BATTLE************************************************************

                    enemy = new Enemy("Feral King", 2500, 500, "Dark Claw", 600, 250);// CHANGE PER FLOOR ("", +500, + 50, "", +50, +50)
                    System.out.println("\n___________________________________________________");
                    System.out.println("\t# The bossfloor, "+enemy.name+", has appeared! #\n");
                    
                    while(enemy.hp > 0){
                        System.out.println("\t"+player.name+"'s HP: "+ player.hp);
                        System.out.println("\t"+player.name+"'s MP: "+player.mp);
                        System.out.println("\t"+enemy.name+"'s HP: "+ enemy.hp);
                        System.out.println("\n___________________________________________________");
                        System.out.println("[Press Enter to Continue]");
                        jcb.readLine();
                        System.out.println("\n\tWhat would you like to do?");
                        LinkStart.battleMenu();
                        System.out.print("\tYour choice: ");
                        int choicef1;
                        
                        try{
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        catch(Exception e){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        while(choicef1 != 1 && choicef1 != 2 && choicef1 != 3 && choicef1 != 4){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        switch(choicef1){
                            case 1:
                                Player.attack();
                                short choicef1_1 = 0;
                                try{
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_1 != 1 && choicef1_1 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
//**********************************************************PHYSICAL ATTACK*********************************************************************
                                if(choicef1_1 == 1){
                                    enemy.hp = player.pAttack(enemy, turn);
                                    player.hp = enemy.pAttack(player, turn);
                                }
//************************************************************SKILL ATTACK**************************************************************************
                                else if(choicef1_1 == 2){
                                    if(player.mp > 0){
                                        player.sAttackMenu3();// **********************************CHANGE PER 2 FLOOR
                                        int choicef1_2 = 0;
                                        try{
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        catch(Exception e){
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu3();// ********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        while(choicef1_2 != 1 && choicef1_2 != 2 && choicef1_2 != 3 && choicef1_2 != 4){// ****************ADD ANOTHER CHOICE PER 2 FLOOR 
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu3();// ************************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        switch (choicef1_2) {
                                            case 1:
                                                if(player.mp > 30){
                                                    enemy.hp = player.sAttack1(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.sAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 30){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 2:
                                                if(player.mp > 50){
                                                    enemy.hp = player.sAttack2(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.sAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 50){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.sAttack(player, turn);
                                                }
                                                break;
                                            case 3:
                                                if(player.mp > 75){
                                                    enemy.hp = player.sAttack3(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.sAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 75){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.sAttack(player, turn);
                                                }
                                                break;
                                            case 4:
                                                if(player.mp > 100){
                                                    enemy.hp = player.sAttack4(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 100){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;//***********************ADD ANOTHER CASE FOR THE NEW SKILL
                                            default:
                                                break;
                                        }
                                    }
                                    else if(player.mp <= 0){
                                        player.mp = 0;
                                        System.out.println("\t# You don't have any MP left! Drink an MP potion to restore! #");
                                        player.hp = enemy.pAttack(player, turn);
                                    }
                                }
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_3 = 0;
                                   try{
                                        choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_3 != 1 && choicef1_3 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_3 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_3 == 2){
                                       main(monstersOne);
                                   }
                                }
                                if(enemy.hp <= 0){
                                   System.out.println("\t> "+enemy.name+" has been slayed! yata! yata! masoooo!\n"
                                   + "\tTHAT'S WICKED!!!!!");
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t> Remaining HP: " + player.hp);
                                   System.out.println("\t> Remaining MP: " + player.mp);
                                   if(rand.nextInt(100) < hpPotionDropChance){
                                       player.hpPotion++;
                                       System.out.println("\n\t# The enemy drop an HP potion! #");
                                       System.out.println("\t# You have "+ player.hpPotion +" HP potion/s. #");
                                   }
                                   if(rand.nextInt(100) < mpPotionDropChance){
                                       player.mpPotion++;
                                       System.out.println("\n\t# The enemy drop an MP potion! #");
                                       System.out.println("\t# You have "+ player.mpPotion +" MP potion/s. #");
                                   }
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t# PRESS [ENTER] TO PROCEEED. #");
                                   jcb.readLine();
                                   break;
                                }
                                break;
                            case 2:
                                player.hp = player.defend(enemy,turn);
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_4 = 0;
                                   try{
                                        choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_4 != 1 && choicef1_4 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_4 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_4 == 2){
                                       main(monstersOne);
                                   }
                                }//defend algorithm
                                break;
                            case 3:
                                player.itemOption();
                                short choicef1_5 = 0;
                                try{
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_5 != 1 && choicef1_5 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                if(choicef1_5 == 1){
                                    if(player.hpPotion > 0){
                                        if(player.hp < player.maxHp){
                                            player.hp += hpPotionAmount;
                                            if(player.hp > player.maxHp) player.hp = player.maxHp;
                                            player.hpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\n\t# You drink an HP potion, healing by "+hpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.hp+" HP. #");
                                             System.out.println("\t# You have "+ player.hpPotion+" HP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your HP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no HP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                else if(choicef1_5 == 2){
                                    if(player.mpPotion > 0){
                                        if(player.mp < player.maxMp){
                                            player.mp += mpPotionAmount;
                                            if(player.mp > player.maxMp)player.mp = player.maxMp;
                                            player.mpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\t# You drink an MP potion, healing by "+mpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.mp+" MP. #");
                                             System.out.println("\t# You have "+ player.mpPotion+" MP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your MP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no MP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                //item
                                break;
                            case 4:
                                System.out.println("----------------------------------------------------");
                                System.out.println("\n\t# You run away from "+enemy.name+"! #");
                                System.out.println("\t# YOU WEAKLING!!! #");
                                continue FLOOR_5;// ***************************************CHANGE PER FLOOR

                        }
                    }
                    break;
                }
                break;
            }
            
//***************************************************************PLAYER STATUS UPDATE**********************************************************************
            player.maxHp += 100;
            player.hp = player.maxHp;
            player.maxMp += 50;
            player.mp  = player.maxMp;
            player.baseAtk += 30;
            player.baseDef += 30;
            if(player.title == 2){// CHANGE PER FLOOR
                //player.title --- ADD IN FLOOR 2[1], 4[2], 6[3]
                //player.skillId --- ADD IN FLOOR 2[2], 4[3], 6[4], 8[5]
                player.weaponId = 5;// CHANGE PER FLOOR
            }
            else if(player.title == 6){// CHANGE PER FLOOR
                //player.title --- ADD IN FLOOR 2[5], 4[6], 6[7]
                //player.skillId --- ADD IN FLOOR 2[8], 4[9], 6[10], 8[11]
                player.weaponId = 15;// CHANGE PER FLOOR
            }
            else if(player.title == 10){// CHANGE PER FLOOR
                //player.title --- ADD IN FLOOR 2[9], 4[10], 6[11]
                //player.skillId --- ADD IN FLOOR 2[14], 4[15], 6[16], 8[17]
                player.weaponId = 25;// CHANGE PER FLOOR
            }
            player.armorId = 5;//******************************************* CHANGE PER FLOOR
            
             System.out.println("\t# You acquired new equipments! #");
             System.out.println("\t> Weapon: "+eqp.getWeaponName(player.weaponId));
             System.out.println("\t> Armor: "+eqp.getArmorName(player.armorId));
             System.out.println("\n\t"+eqp.getWeaponName(player.weaponId)+" equiped.");
             System.out.println("\t"+eqp.getArmorName(player.armorId)+" equiped.");
             System.out.println("\t# PRESS [ENTER] TO PROCEED. #");
             jcb.readLine();
             System.out.println("\n___________________________________________________");
             System.out.println("\t#************PLAYER STATUS LEVEL UP!**************#");
             jcb.readLine();
             //System.out.println("\n\t# ***YOU ARE PROMOTED INTO ["+pclass.getplayerClass(player.title)+"]!*** #");
             //jcb.readLine();
             //System.out.println("\n\t# ***YOU ACQUIRED A NEW SKILL!!!*** #");
             //jcb.readLine();
             //System.out.println("\t\t> "+pskills.getPlayerSkillName(player.skillId4)+"!");
             //jcb.readLine();
             System.out.println("\n\t# HP increased by 100! #");
             System.out.println("\n\t# MP increased by 50! #");
             jcb.readLine();
             PlayerStatus.playerStatus3(player);//**************** CHANGE PER 2 FLOOR
             System.out.println("\n___________________________________________________");
             System.out.println("\t# PRESS [ENTER] TO PROCEED. #");
             jcb.readLine();
            LinkStart.fifthFloorClr();//***************************CHANGE PER FLOOR
             System.out.print("\tYour choice: ");
             short choice5 = 0;
             
             try{
                 choice5 = Short.parseShort(jcb.readLine());
             }
             catch(Exception e){
                 System.out.println("\t# INVALID COMMAND! #");
                 System.out.print("\tYour choice: ");
                 choice5 = Short.parseShort(jcb.readLine());
             }
             while(choice5 != 1 && choice5 != 2 && choice5 != 3){
                 System.out.println("\t# INVALID COMMAND! #");
                 System.out.print("\tYour choice: ");
                 choice5 = Short.parseShort(jcb.readLine());
             }
             if(choice5 == 1){
                 System.out.println("\n\t# Great! #");
                 System.out.println("\t# Press [ENTER] to proceed to the next area! #");
                 jcb.readLine();
             }
             else if(choice5 == 2){
                 System.out.println("You took a short nap");
                 // ***************************************MAKE A SHORT SIMULATION IN CHOICE 2*****************************
                 jcb.readLine();
             }
             else if(choice5 == 3){
                 System.out.println("\tAhhhhhhhhhhh~~~ What a weakling.\n");
                 System.out.println("\t**************************");
                 System.out.println("\t**************************");
                 System.out.println("\t**THANK YOU FOR PLAYING!**");
                 System.out.println("\t**************************");
                 System.out.println("\t**************************");
                 System.out.println("\n\t> Press [ENTER] to exit.");
                 jcb.readLine();
                 System.exit(0);
             }
             
             //**************************************************FLOOR 6 DIALOGUE INPUT******************************************************
             floorDialogue.sixthFloorDialogue(player);
             jcb.readLine();
             
             FLOOR_6://**************************************************SIXTH FLOOR************************************************************
            while(floorSix){// ***********************************MONSTER BATTLE*************************************************************
                String[] monstersOne = {"Mummy","Possessed Skeleton","Silverback","Minotaur"};// CHANGE PER FLOOR
                int maxMonsterHp = 600;// CHANGE PER FLOOR BY 100
                int monsterAtkDmg = 600;// CHANGE PER FLOOR BY 100
                int hpPotionAmount = 180;// CHANGE PER FLOOR BY 30
                int mpPotionAmount = 180;// CHANGE PER FLOOR BY 30
                int hpPotionDropChance = 50;//percentage
                int mpPotionDropChance = 50;
                
                for(int i = 0; i < 5; i+= 1){
                    rand = new Random(i);
                    enemy = new Enemy("",0,0,"",0,0);
                    enemy.hp = rand.nextInt(maxMonsterHp);
                    enemy.name = monstersOne[rand.nextInt(monstersOne.length)];
                    enemy.baseAtk = rand.nextInt(monsterAtkDmg);
                    
                    System.out.println("\n___________________________________________________");
                    System.out.println("\t# "+enemy.name+" has appeared! #\n");
                    
                    while(enemy.hp > 0){
                        System.out.println("\t"+player.name+"'s HP: "+ player.hp);
                        System.out.println("\t"+player.name+"'s MP: "+player.mp);
                        System.out.println("\t"+enemy.name+"'s HP: "+ enemy.hp);
                        System.out.println("\n___________________________________________________");
                        System.out.println("\n\tWhat would you like to do?");
                        LinkStart.battleMenu();
                        System.out.print("\tYour choice: ");
                        int choicef1;
                        
                        try{
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        catch(Exception e){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        while(choicef1 != 1 && choicef1 != 2 && choicef1 != 3 && choicef1 != 4){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        switch(choicef1){
                            case 1:
                                Player.attack();
                                short choicef1_1 = 0;
                                try{
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_1 != 1 && choicef1_1 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
//**********************************************************PHYSICAL ATTACK*********************************************************************
                                if(choicef1_1 == 1){
                                    enemy.hp = player.pAttack(enemy, turn);
                                    player.hp = enemy.pAttack(player, turn);
                                }
//************************************************************SKILL ATTACK**************************************************************************
                                else if(choicef1_1 == 2){
                                    if(player.mp > 0){
                                        player.sAttackMenu3();// ***************************************CHANGE PER 2 FLOOR
                                        int choicef1_2 = 0;
                                        try{
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        catch(Exception e){
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu3();// *********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        while(choicef1_2 != 1 && choicef1_2 != 2 && choicef1_2 != 3 && choicef1_2 != 4){// ****************ADD ANOTHER CHOICE PER 2 FLOOR
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu3();// *********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        switch (choicef1_2) {
                                            case 1:
                                                if(player.mp > 30){
                                                    enemy.hp = player.sAttack1(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 30){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 2:
                                                if(player.mp > 50){
                                                    enemy.hp = player.sAttack2(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 50){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 3:
                                                if(player.mp > 75){
                                                    enemy.hp = player.sAttack3(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 75){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 4:
                                                if(player.mp > 100){
                                                    enemy.hp = player.sAttack4(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 100){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;// ******************************ADD ANOTHER CASE FOR THE NEW SKILL
                                            default:
                                                break;
                                        }
                                    }
                                    else if(player.mp <= 0){
                                        player.mp = 0;
                                        System.out.println("\t# You don't have any MP left! Drink an MP potion to restore! #");
                                        player.hp = enemy.pAttack(player, turn);
                                    }
                                }
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_3 = 0;
                                   try{
                                        choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_3 != 1 && choicef1_3 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_3 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_3 == 2){
                                       main(monstersOne);
                                   }
                                }
                                if(enemy.hp <= 0){
                                   System.out.println("\n\t# You defeated the "+enemy.name+"! #");
                                   System.out.println("\t> Remaining HP: " + player.hp);
                                   System.out.println("\t> Remaining MP: " + player.mp);
                                   if(rand.nextInt(100) < hpPotionDropChance){
                                       player.hpPotion++;
                                       System.out.println("\n\t# The enemy drop an HP potion! #");
                                       System.out.println("\t# You have "+ player.hpPotion +" HP potion/s. #");
                                   }
                                   if(rand.nextInt(100) < mpPotionDropChance){
                                       player.mpPotion++;
                                       System.out.println("\n\t# The enemy drop an MP potion! #");
                                       System.out.println("\t# You have "+ player.mpPotion +" MP potion/s. #");
                                   }
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t# PRESS [ENTER] TO PROCEEED. #");
                                   jcb.readLine();
                                   break;
                                }
                                break;
                            case 2:
                                player.hp = player.defend(enemy,turn);
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_4 = 0;
                                   try{
                                        choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_4 != 1 && choicef1_4 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_4 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_4 == 2){
                                       main(monstersOne);
                                   }
                                }//defend algorithm
                                break;
                            case 3:
                                player.itemOption();
                                short choicef1_5 = 0;
                                try{
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_5 != 1 && choicef1_5 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                if(choicef1_5 == 1){
                                    if(player.hpPotion > 0){
                                        if(player.hp < player.maxHp){
                                            player.hp += hpPotionAmount;
                                            if(player.hp > player.maxHp) player.hp = player.maxHp;
                                            player.hpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\n\t# You drink an HP potion, healing by "+hpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.hp+" HP. #");
                                             System.out.println("\t# You have "+ player.hpPotion+" HP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your HP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no HP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                else if(choicef1_5 == 2){
                                    if(player.mpPotion > 0){
                                        if(player.mp < player.maxMp){
                                            player.mp += mpPotionAmount;
                                            if(player.mp > player.maxMp)player.mp = player.maxMp;
                                            player.mpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\t# You drink an MP potion, healing by "+mpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.mp+" MP. #");
                                             System.out.println("\t# You have "+ player.mpPotion+" MP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your MP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no MP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                //item
                                break;
                            case 4:
                                System.out.println("----------------------------------------------------");
                                System.out.println("\n\t# You run away from "+enemy.name+"! #");
                                System.out.println("\t# YOU WEAKLING!!! #");
                                continue FLOOR_6;// ******************************************CHANGE PER FLOOR

                        }
                    }
                }
                
                while(running){//*************************************SIXTH BOSS BATTLE************************************************************

                    enemy = new Enemy("Black Bahamut", 3000, 600, "Dark Flame", 700, 400);// CHANGE PER FLOOR ("", +500, + 50, "", +50, +50)
                    System.out.println("\n___________________________________________________");
                    System.out.println("\t# The bossfloor, "+enemy.name+", has appeared! #\n");
                    
                    while(enemy.hp > 0){
                        System.out.println("\t"+player.name+"'s HP: "+ player.hp);
                        System.out.println("\t"+player.name+"'s MP: "+player.mp);
                        System.out.println("\t"+enemy.name+"'s HP: "+ enemy.hp);
                        System.out.println("\n___________________________________________________");
                        System.out.println("[Press Enter to Continue]");
                        jcb.readLine();
                        System.out.println("\n\tWhat would you like to do?");
                        LinkStart.battleMenu();
                        System.out.print("\tYour choice: ");
                        int choicef1;
                        
                        try{
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        catch(Exception e){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        while(choicef1 != 1 && choicef1 != 2 && choicef1 != 3 && choicef1 != 4){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        switch(choicef1){
                            case 1:
                                Player.attack();
                                short choicef1_1 = 0;
                                try{
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_1 != 1 && choicef1_1 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
//**********************************************************PHYSICAL ATTACK*********************************************************************
                                if(choicef1_1 == 1){
                                    enemy.hp = player.pAttack(enemy, turn);
                                    player.hp = enemy.pAttack(player, turn);
                                }
//************************************************************SKILL ATTACK**************************************************************************
                                else if(choicef1_1 == 2){
                                    if(player.mp > 0){
                                        player.sAttackMenu3();// **********************************CHANGE PER 2 FLOOR
                                        int choicef1_2 = 0;
                                        try{
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        catch(Exception e){
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu3();// ********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        while(choicef1_2 != 1 && choicef1_2 != 2 && choicef1_2 != 3 && choicef1_2 != 4){// ****************ADD ANOTHER CHOICE PER 2 FLOOR 
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu3();// ************************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        switch (choicef1_2) {
                                            case 1:
                                                if(player.mp > 30){
                                                    enemy.hp = player.sAttack1(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.sAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 30){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 2:
                                                if(player.mp > 50){
                                                    enemy.hp = player.sAttack2(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.sAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 50){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.sAttack(player, turn);
                                                }
                                                break;
                                            case 3:
                                                if(player.mp > 75){
                                                    enemy.hp = player.sAttack3(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.sAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 75){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.sAttack(player, turn);
                                                }
                                                break;
                                            case 4:
                                                if(player.mp > 100){
                                                    enemy.hp = player.sAttack4(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 100){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;//***********************ADD ANOTHER CASE FOR THE NEW SKILL
                                            default:
                                                break;
                                        }
                                    }
                                    else if(player.mp <= 0){
                                        player.mp = 0;
                                        System.out.println("\t# You don't have any MP left! Drink an MP potion to restore! #");
                                        player.hp = enemy.pAttack(player, turn);
                                    }
                                }
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_3 = 0;
                                   try{
                                        choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_3 != 1 && choicef1_3 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_3 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_3 == 2){
                                       main(monstersOne);
                                   }
                                }
                                if(enemy.hp <= 0){
                                   System.out.println("\t> "+enemy.name+" has been slayed! yata! yata! masoooo!\n"
                                   + "\tTHAT'S WICKED!!!!!");
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t> Remaining HP: " + player.hp);
                                   System.out.println("\t> Remaining MP: " + player.mp);
                                   if(rand.nextInt(100) < hpPotionDropChance){
                                       player.hpPotion++;
                                       System.out.println("\n\t# The enemy drop an HP potion! #");
                                       System.out.println("\t# You have "+ player.hpPotion +" HP potion/s. #");
                                   }
                                   if(rand.nextInt(100) < mpPotionDropChance){
                                       player.mpPotion++;
                                       System.out.println("\n\t# The enemy drop an MP potion! #");
                                       System.out.println("\t# You have "+ player.mpPotion +" MP potion/s. #");
                                   }
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t# PRESS [ENTER] TO PROCEEED. #");
                                   jcb.readLine();
                                   break;
                                }
                                break;
                            case 2:
                                player.hp = player.defend(enemy,turn);
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_4 = 0;
                                   try{
                                        choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_4 != 1 && choicef1_4 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_4 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_4 == 2){
                                       main(monstersOne);
                                   }
                                }//defend algorithm
                                break;
                            case 3:
                                player.itemOption();
                                short choicef1_5 = 0;
                                try{
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_5 != 1 && choicef1_5 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                if(choicef1_5 == 1){
                                    if(player.hpPotion > 0){
                                        if(player.hp < player.maxHp){
                                            player.hp += hpPotionAmount;
                                            if(player.hp > player.maxHp) player.hp = player.maxHp;
                                            player.hpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\n\t# You drink an HP potion, healing by "+hpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.hp+" HP. #");
                                             System.out.println("\t# You have "+ player.hpPotion+" HP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your HP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no HP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                else if(choicef1_5 == 2){
                                    if(player.mpPotion > 0){
                                        if(player.mp < player.maxMp){
                                            player.mp += mpPotionAmount;
                                            if(player.mp > player.maxMp)player.mp = player.maxMp;
                                            player.mpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\t# You drink an MP potion, healing by "+mpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.mp+" MP. #");
                                             System.out.println("\t# You have "+ player.mpPotion+" MP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your MP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no MP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                //item
                                break;
                            case 4:
                                System.out.println("----------------------------------------------------");
                                System.out.println("\n\t# You run away from "+enemy.name+"! #");
                                System.out.println("\t# YOU WEAKLING!!! #");
                                continue FLOOR_6;// ***************************************CHANGE PER FLOOR

                        }
                    }
                    break;
                }
                break;
            }
            
//***************************************************************PLAYER STATUS UPDATE**********************************************************************
            player.maxHp += 100;
            player.hp = player.maxHp;
            player.maxMp += 50;
            player.mp  = player.maxMp;
            player.baseAtk += 25;
            player.baseDef += 25;
            if(player.title == 2){// CHANGE PER FLOOR
                player.title = 3;//player.title --- ADD IN FLOOR 2[1], 4[2], 6[3]
                player.skillId5 = 4;//player.skillId --- ADD IN FLOOR 2[2], 4[3], 6[4], 8[5]
                player.weaponId = 6;// CHANGE PER FLOOR
            }
            else if(player.title == 6){// CHANGE PER FLOOR
                player.title = 7;//player.title --- ADD IN FLOOR 2[5], 4[6], 6[7]
                player.skillId5 = 10;//player.skillId --- ADD IN FLOOR 2[8], 4[9], 6[10], 8[11]
                player.weaponId = 16;// CHANGE PER FLOOR
            }
            else if(player.title == 10){// CHANGE PER FLOOR
                player.title = 11;//player.title --- ADD IN FLOOR 2[9], 4[10], 6[11]
                player.skillId5 = 16;//player.skillId --- ADD IN FLOOR 2[14], 4[15], 6[16], 8[17]
                player.weaponId = 26;// CHANGE PER FLOOR
            }
            player.armorId = 6;//******************************************* CHANGE PER FLOOR
            
             System.out.println("\t# You acquired new equipments! #");
             System.out.println("\t> Weapon: "+eqp.getWeaponName(player.weaponId));
             System.out.println("\t> Armor: "+eqp.getArmorName(player.armorId));
             System.out.println("\n\t"+eqp.getWeaponName(player.weaponId)+" equiped.");
             System.out.println("\t"+eqp.getArmorName(player.armorId)+" equiped.");
             System.out.println("\t# PRESS [ENTER] TO PROCEED. #");
             jcb.readLine();
             System.out.println("\n___________________________________________________");
             System.out.println("\t#************PLAYER STATUS LEVEL UP!**************#");
             jcb.readLine();
             System.out.println("\n\t# ***YOU ARE PROMOTED INTO ["+pclass.getplayerClass(player.title)+"]!*** #");
             jcb.readLine();
             System.out.println("\n\t# ***YOU ACQUIRED A NEW SKILL!!!*** #");
             jcb.readLine();
             System.out.println("\t\t> "+pskills.getPlayerSkillName(player.skillId5)+"!");
             jcb.readLine();
             System.out.println("\n\t# HP increased by 100! #");
             System.out.println("\n\t# MP increased by 50! #");
             jcb.readLine();
             PlayerStatus.playerStatus4(player);//**************** CHANGE PER 2 FLOOR
             System.out.println("\n___________________________________________________");
             System.out.println("\t# PRESS [ENTER] TO PROCEED. #");
             jcb.readLine();
            LinkStart.sixthFloorClr();//***************************CHANGE PER FLOOR
             System.out.print("\tYour choice: ");
             short choice6 = 0;
             
             try{
                 choice6 = Short.parseShort(jcb.readLine());
             }
             catch(Exception e){
                 System.out.println("\t# INVALID COMMAND! #");
                 System.out.print("\tYour choice: ");
                 choice6 = Short.parseShort(jcb.readLine());
             }
             while(choice6 != 1 && choice6 != 2 && choice6 != 3){
                 System.out.println("\t# INVALID COMMAND! #");
                 System.out.print("\tYour choice: ");
                 choice6 = Short.parseShort(jcb.readLine());
             }
             if(choice6 == 1){
                 System.out.println("\n\t# Great! #");
                 System.out.println("\t# Press [ENTER] to proceed to the next area! #");
                 jcb.readLine();
             }
             else if(choice6 == 2){
                 System.out.println("You took a short nap");
                 // ***************************************MAKE A SHORT SIMULATION IN CHOICE 2*****************************
                 jcb.readLine();
             }
             else if(choice6 == 3){
                 System.out.println("\tAhhhhhhhhhhh~~~ What a weakling.\n");
                 System.out.println("\t**************************");
                 System.out.println("\t**************************");
                 System.out.println("\t**THANK YOU FOR PLAYING!**");
                 System.out.println("\t**************************");
                 System.out.println("\t**************************");
                 System.out.println("\n\t> Press [ENTER] to exit.");
                 jcb.readLine();
                 System.exit(0);
             }
             
             //**************************************************FLOOR 7 DIALOGUE INPUT******************************************************
             floorDialogue.seventhFloorDialogue(player);
             jcb.readLine();
             
             FLOOR_7://**************************************************SEVENTH FLOOR************************************************************
            while(floorSeven){// ***********************************MONSTER BATTLE*************************************************************
                String[] monstersOne = {"Contaminated Slime","Subsutarian","Arc Demon","Chimera"};// CHANGE PER FLOOR
                int maxMonsterHp = 700;// CHANGE PER FLOOR BY 100
                int monsterAtkDmg = 700;// CHANGE PER FLOOR BY 100
                int hpPotionAmount = 210;// CHANGE PER FLOOR BY 30
                int mpPotionAmount = 210;// CHANGE PER FLOOR BY 30
                int hpPotionDropChance = 50;//percentage
                int mpPotionDropChance = 50;
                
                for(int i = 0; i < 5; i+= 1){
                    rand = new Random(i);
                    enemy = new Enemy("",0,0,"",0,0);
                    enemy.hp = rand.nextInt(maxMonsterHp);
                    enemy.name = monstersOne[rand.nextInt(monstersOne.length)];
                    enemy.baseAtk = rand.nextInt(monsterAtkDmg);
                    
                    System.out.println("\n___________________________________________________");
                    System.out.println("\t# "+enemy.name+" has appeared! #\n");
                    
                    while(enemy.hp > 0){
                        System.out.println("\t"+player.name+"'s HP: "+ player.hp);
                        System.out.println("\t"+player.name+"'s MP: "+player.mp);
                        System.out.println("\t"+enemy.name+"'s HP: "+ enemy.hp);
                        System.out.println("\n___________________________________________________");
                        System.out.println("\n\tWhat would you like to do?");
                        LinkStart.battleMenu();
                        System.out.print("\tYour choice: ");
                        int choicef1;
                        
                        try{
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        catch(Exception e){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        while(choicef1 != 1 && choicef1 != 2 && choicef1 != 3 && choicef1 != 4){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        switch(choicef1){
                            case 1:
                                Player.attack();
                                short choicef1_1 = 0;
                                try{
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_1 != 1 && choicef1_1 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
//**********************************************************PHYSICAL ATTACK*********************************************************************
                                if(choicef1_1 == 1){
                                    enemy.hp = player.pAttack(enemy, turn);
                                    player.hp = enemy.pAttack(player, turn);
                                }
//************************************************************SKILL ATTACK**************************************************************************
                                else if(choicef1_1 == 2){
                                    if(player.mp > 0){
                                        player.sAttackMenu4();// ***************************************CHANGE PER 2 FLOOR
                                        int choicef1_2 = 0;
                                        try{
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        catch(Exception e){
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu4();// *********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        while(choicef1_2 != 1 && choicef1_2 != 2 && choicef1_2 != 3 && choicef1_2 != 4 && choicef1_2 != 5){// ****************ADD ANOTHER CHOICE PER 2 FLOOR
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu4();// *********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        switch (choicef1_2) {
                                            case 1:
                                                if(player.mp > 30){
                                                    enemy.hp = player.sAttack1(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 30){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 2:
                                                if(player.mp > 50){
                                                    enemy.hp = player.sAttack2(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 50){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 3:
                                                if(player.mp > 75){
                                                    enemy.hp = player.sAttack3(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 75){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 4:
                                                if(player.mp > 100){
                                                    enemy.hp = player.sAttack4(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 100){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 5:
                                                if(player.mp > 150){
                                                    enemy.hp = player.sAttack5(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 150){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;// ******************************ADD ANOTHER CASE FOR THE NEW SKILL
                                            default:
                                                break;
                                        }
                                    }
                                    else if(player.mp <= 0){
                                        player.mp = 0;
                                        System.out.println("\t# You don't have any MP left! Drink an MP potion to restore! #");
                                        player.hp = enemy.pAttack(player, turn);
                                    }
                                }
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_3 = 0;
                                   try{
                                        choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_3 != 1 && choicef1_3 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_3 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_3 == 2){
                                       main(monstersOne);
                                   }
                                }
                                if(enemy.hp <= 0){
                                   System.out.println("\n\t# You defeated the "+enemy.name+"! #");
                                   System.out.println("\t> Remaining HP: " + player.hp);
                                   System.out.println("\t> Remaining MP: " + player.mp);
                                   if(rand.nextInt(100) < hpPotionDropChance){
                                       player.hpPotion++;
                                       System.out.println("\n\t# The enemy drop an HP potion! #");
                                       System.out.println("\t# You have "+ player.hpPotion +" HP potion/s. #");
                                   }
                                   if(rand.nextInt(100) < mpPotionDropChance){
                                       player.mpPotion++;
                                       System.out.println("\n\t# The enemy drop an MP potion! #");
                                       System.out.println("\t# You have "+ player.mpPotion +" MP potion/s. #");
                                   }
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t# PRESS [ENTER] TO PROCEEED. #");
                                   jcb.readLine();
                                   break;
                                }
                                break;
                            case 2:
                                player.hp = player.defend(enemy,turn);
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_4 = 0;
                                   try{
                                        choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_4 != 1 && choicef1_4 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_4 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_4 == 2){
                                       main(monstersOne);
                                   }
                                }//defend algorithm
                                break;
                            case 3:
                                player.itemOption();
                                short choicef1_5 = 0;
                                try{
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_5 != 1 && choicef1_5 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                if(choicef1_5 == 1){
                                    if(player.hpPotion > 0){
                                        if(player.hp < player.maxHp){
                                            player.hp += hpPotionAmount;
                                            if(player.hp > player.maxHp) player.hp = player.maxHp;
                                            player.hpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\n\t# You drink an HP potion, healing by "+hpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.hp+" HP. #");
                                             System.out.println("\t# You have "+ player.hpPotion+" HP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your HP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no HP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                else if(choicef1_5 == 2){
                                    if(player.mpPotion > 0){
                                        if(player.mp < player.maxMp){
                                            player.mp += mpPotionAmount;
                                            if(player.mp > player.maxMp)player.mp = player.maxMp;
                                            player.mpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\t# You drink an MP potion, healing by "+mpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.mp+" MP. #");
                                             System.out.println("\t# You have "+ player.mpPotion+" MP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your MP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no MP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                //item
                                break;
                            case 4:
                                System.out.println("----------------------------------------------------");
                                System.out.println("\n\t# You run away from "+enemy.name+"! #");
                                System.out.println("\t# YOU WEAKLING!!! #");
                                continue FLOOR_7;// ******************************************CHANGE PER FLOOR

                        }
                    }
                }
                
                while(running){//*************************************SEVENTH BOSS BATTLE************************************************************

                    enemy = new Enemy("Acnologia", 3500, 700, "Black Ablaze", 800, 450);// CHANGE PER FLOOR ("", +500, + 50, "", +50, +50)
                    System.out.println("\n___________________________________________________");
                    System.out.println("\t# The bossfloor, "+enemy.name+", has appeared! #\n");
                    
                    while(enemy.hp > 0){
                        System.out.println("\t"+player.name+"'s HP: "+ player.hp);
                        System.out.println("\t"+player.name+"'s MP: "+player.mp);
                        System.out.println("\t"+enemy.name+"'s HP: "+ enemy.hp);
                        System.out.println("\n___________________________________________________");
                        System.out.println("[Press Enter to Continue]");
                        jcb.readLine();
                        System.out.println("\n\tWhat would you like to do?");
                        LinkStart.battleMenu();
                        System.out.print("\tYour choice: ");
                        int choicef1;
                        
                        try{
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        catch(Exception e){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        while(choicef1 != 1 && choicef1 != 2 && choicef1 != 3 && choicef1 != 4){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        switch(choicef1){
                            case 1:
                                Player.attack();
                                short choicef1_1 = 0;
                                try{
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_1 != 1 && choicef1_1 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
//**********************************************************PHYSICAL ATTACK*********************************************************************
                                if(choicef1_1 == 1){
                                    enemy.hp = player.pAttack(enemy, turn);
                                    player.hp = enemy.pAttack(player, turn);
                                }
//************************************************************SKILL ATTACK**************************************************************************
                                else if(choicef1_1 == 2){
                                    if(player.mp > 0){
                                        player.sAttackMenu4();// **********************************CHANGE PER 2 FLOOR
                                        int choicef1_2 = 0;
                                        try{
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        catch(Exception e){
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu4();// ********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        while(choicef1_2 != 1 && choicef1_2 != 2 && choicef1_2 != 3 && choicef1_2 != 4 && choicef1_2 != 5){// ****************ADD ANOTHER CHOICE PER 2 FLOOR 
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu4();// ************************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        switch (choicef1_2) {
                                            case 1:
                                                if(player.mp > 30){
                                                    enemy.hp = player.sAttack1(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.sAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 30){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 2:
                                                if(player.mp > 50){
                                                    enemy.hp = player.sAttack2(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.sAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 50){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.sAttack(player, turn);
                                                }
                                                break;
                                            case 3:
                                                if(player.mp > 75){
                                                    enemy.hp = player.sAttack3(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.sAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 75){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.sAttack(player, turn);
                                                }
                                                break;
                                            case 4:
                                                if(player.mp > 100){
                                                    enemy.hp = player.sAttack4(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 100){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 5:
                                                if(player.mp > 150){
                                                    enemy.hp = player.sAttack5(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 150){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;//***********************ADD ANOTHER CASE FOR THE NEW SKILL
                                            default:
                                                break;
                                        }
                                    }
                                    else if(player.mp <= 0){
                                        player.mp = 0;
                                        System.out.println("\t# You don't have any MP left! Drink an MP potion to restore! #");
                                        player.hp = enemy.pAttack(player, turn);
                                    }
                                }
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_3 = 0;
                                   try{
                                        choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_3 != 1 && choicef1_3 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_3 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_3 == 2){
                                       main(monstersOne);
                                   }
                                }
                                if(enemy.hp <= 0){
                                   System.out.println("\t> "+enemy.name+" has been slayed! yata! yata! masoooo!\n"
                                   + "\tTHAT'S WICKED!!!!!");
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t> Remaining HP: " + player.hp);
                                   System.out.println("\t> Remaining MP: " + player.mp);
                                   if(rand.nextInt(100) < hpPotionDropChance){
                                       player.hpPotion++;
                                       System.out.println("\n\t# The enemy drop an HP potion! #");
                                       System.out.println("\t# You have "+ player.hpPotion +" HP potion/s. #");
                                   }
                                   if(rand.nextInt(100) < mpPotionDropChance){
                                       player.mpPotion++;
                                       System.out.println("\n\t# The enemy drop an MP potion! #");
                                       System.out.println("\t# You have "+ player.mpPotion +" MP potion/s. #");
                                   }
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t# PRESS [ENTER] TO PROCEEED. #");
                                   jcb.readLine();
                                   break;
                                }
                                break;
                            case 2:
                                player.hp = player.defend(enemy,turn);
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_4 = 0;
                                   try{
                                        choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_4 != 1 && choicef1_4 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_4 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_4 == 2){
                                       main(monstersOne);
                                   }
                                }//defend algorithm
                                break;
                            case 3:
                                player.itemOption();
                                short choicef1_5 = 0;
                                try{
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_5 != 1 && choicef1_5 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                if(choicef1_5 == 1){
                                    if(player.hpPotion > 0){
                                        if(player.hp < player.maxHp){
                                            player.hp += hpPotionAmount;
                                            if(player.hp > player.maxHp) player.hp = player.maxHp;
                                            player.hpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\n\t# You drink an HP potion, healing by "+hpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.hp+" HP. #");
                                             System.out.println("\t# You have "+ player.hpPotion+" HP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your HP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no HP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                else if(choicef1_5 == 2){
                                    if(player.mpPotion > 0){
                                        if(player.mp < player.maxMp){
                                            player.mp += mpPotionAmount;
                                            if(player.mp > player.maxMp)player.mp = player.maxMp;
                                            player.mpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\t# You drink an MP potion, healing by "+mpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.mp+" MP. #");
                                             System.out.println("\t# You have "+ player.mpPotion+" MP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your MP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no MP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                //item
                                break;
                            case 4:
                                System.out.println("----------------------------------------------------");
                                System.out.println("\n\t# You run away from "+enemy.name+"! #");
                                System.out.println("\t# YOU WEAKLING!!! #");
                                continue FLOOR_7;// ***************************************CHANGE PER FLOOR

                        }
                    }
                    break;
                }
                break;
            }
            
//***************************************************************PLAYER STATUS UPDATE**********************************************************************
            player.maxHp += 100;
            player.hp = player.maxHp;
            player.maxMp += 50;
            player.mp  = player.maxMp;
            player.baseAtk += 20;
            player.baseDef += 20;
            if(player.title == 3){// CHANGE PER FLOOR
                //player.skillId --- ADD IN FLOOR 2[2], 4[3], 6[4], 8[5]
                player.weaponId = 7;// CHANGE PER FLOOR
            }
            else if(player.title == 7){// CHANGE PER FLOOR
                //player.skillId --- ADD IN FLOOR 2[8], 4[9], 6[10], 8[11]
                player.weaponId = 17;// CHANGE PER FLOOR
            }
            else if(player.title == 11){// CHANGE PER FLOOR
                //player.skillId --- ADD IN FLOOR 2[14], 4[15], 6[16], 8[17]
                player.weaponId = 27;// CHANGE PER FLOOR
            }
            player.armorId = 7;//******************************************* CHANGE PER FLOOR
            
             System.out.println("\t# You acquired new equipments! #");
             System.out.println("\t> Weapon: "+eqp.getWeaponName(player.weaponId));
             System.out.println("\t> Armor: "+eqp.getArmorName(player.armorId));
             System.out.println("\n\t"+eqp.getWeaponName(player.weaponId)+" equiped.");
             System.out.println("\t"+eqp.getArmorName(player.armorId)+" equiped.");
             System.out.println("\t# PRESS [ENTER] TO PROCEED. #");
             jcb.readLine();
             System.out.println("\n___________________________________________________");
             System.out.println("\t#************PLAYER STATUS LEVEL UP!**************#");
             jcb.readLine();
             //System.out.println("\n\t# ***YOU ACQUIRED A NEW SKILL!!!*** #");
             //jcb.readLine();
             //System.out.println("\t\t> "+pskills.getPlayerSkillName(player.skillId5)+"!");
             //jcb.readLine();
             System.out.println("\n\t# HP increased by 100! #");
             System.out.println("\n\t# MP increased by 50! #");
             jcb.readLine();
             PlayerStatus.playerStatus4(player);//**************** CHANGE PER 2 FLOOR
             System.out.println("\n___________________________________________________");
             System.out.println("\t# PRESS [ENTER] TO PROCEED. #");
             jcb.readLine();
            LinkStart.seventhFloorClr();//***************************CHANGE PER FLOOR
             System.out.print("\tYour choice: ");
             short choice7 = 0;
             
             try{
                 choice7 = Short.parseShort(jcb.readLine());
             }
             catch(Exception e){
                 System.out.println("\t# INVALID COMMAND! #");
                 System.out.print("\tYour choice: ");
                 choice7 = Short.parseShort(jcb.readLine());
             }
             while(choice7 != 1 && choice7 != 2 && choice7 != 3){
                 System.out.println("\t# INVALID COMMAND! #");
                 System.out.print("\tYour choice: ");
                 choice7 = Short.parseShort(jcb.readLine());
             }
             if(choice7 == 1){
                 System.out.println("\n\t# Great! #");
                 System.out.println("\t# Press [ENTER] to proceed to the next area! #");
                 jcb.readLine();
             }
             else if(choice7 == 2){
                 System.out.println("You took a short nap");
                 // ***************************************MAKE A SHORT SIMULATION IN CHOICE 2*****************************
                 jcb.readLine();
             }
             else if(choice7 == 3){
                 System.out.println("\tAhhhhhhhhhhh~~~ What a weakling.\n");
                 System.out.println("\t**************************");
                 System.out.println("\t**************************");
                 System.out.println("\t**THANK YOU FOR PLAYING!**");
                 System.out.println("\t**************************");
                 System.out.println("\t**************************");
                 System.out.println("\n\t> Press [ENTER] to exit.");
                 jcb.readLine();
                 System.exit(0);
             }
             
             //**************************************************FLOOR 8 DIALOGUE INPUT******************************************************
             floorDialogue.eighthFloorDialogue(player);
             jcb.readLine();
             
             FLOOR_8://**************************************************EIGHTH FLOOR************************************************************
            while(floorEight){// ***********************************MONSTER BATTLE*************************************************************
                String[] monstersOne = {"Hobgoblin","Lizardman","Giant moth","Mimic"};// CHANGE PER FLOOR
                int maxMonsterHp = 800;// CHANGE PER FLOOR BY 100
                int monsterAtkDmg = 800;// CHANGE PER FLOOR BY 100
                int hpPotionAmount = 240;// CHANGE PER FLOOR BY 30
                int mpPotionAmount = 240;// CHANGE PER FLOOR BY 30
                int hpPotionDropChance = 50;//percentage
                int mpPotionDropChance = 50;
                
                for(int i = 0; i < 5; i+= 1){
                    rand = new Random(i);
                    enemy = new Enemy("",0,0,"",0,0);
                    enemy.hp = rand.nextInt(maxMonsterHp);
                    enemy.name = monstersOne[rand.nextInt(monstersOne.length)];
                    enemy.baseAtk = rand.nextInt(monsterAtkDmg);
                    
                    System.out.println("\n___________________________________________________");
                    System.out.println("\t# "+enemy.name+" has appeared! #\n");
                    
                    while(enemy.hp > 0){
                        System.out.println("\t"+player.name+"'s HP: "+ player.hp);
                        System.out.println("\t"+player.name+"'s MP: "+player.mp);
                        System.out.println("\t"+enemy.name+"'s HP: "+ enemy.hp);
                        System.out.println("\n___________________________________________________");
                        System.out.println("\n\tWhat would you like to do?");
                        LinkStart.battleMenu();
                        System.out.print("\tYour choice: ");
                        int choicef1;
                        
                        try{
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        catch(Exception e){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        while(choicef1 != 1 && choicef1 != 2 && choicef1 != 3 && choicef1 != 4){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        switch(choicef1){
                            case 1:
                                Player.attack();
                                short choicef1_1 = 0;
                                try{
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_1 != 1 && choicef1_1 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
//**********************************************************PHYSICAL ATTACK*********************************************************************
                                if(choicef1_1 == 1){
                                    enemy.hp = player.pAttack(enemy, turn);
                                    player.hp = enemy.pAttack(player, turn);
                                }
//************************************************************SKILL ATTACK**************************************************************************
                                else if(choicef1_1 == 2){
                                    if(player.mp > 0){
                                        player.sAttackMenu4();// ***************************************CHANGE PER 2 FLOOR
                                        int choicef1_2 = 0;
                                        try{
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        catch(Exception e){
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu4();// *********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        while(choicef1_2 != 1 && choicef1_2 != 2 && choicef1_2 != 3 && choicef1_2 != 4 && choicef1_2 != 5){// ****************ADD ANOTHER CHOICE PER 2 FLOOR
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu4();// *********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        switch (choicef1_2) {
                                            case 1:
                                                if(player.mp > 30){
                                                    enemy.hp = player.sAttack1(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 30){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 2:
                                                if(player.mp > 50){
                                                    enemy.hp = player.sAttack2(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 50){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 3:
                                                if(player.mp > 75){
                                                    enemy.hp = player.sAttack3(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 75){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 4:
                                                if(player.mp > 100){
                                                    enemy.hp = player.sAttack4(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 100){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 5:
                                                if(player.mp > 150){
                                                    enemy.hp = player.sAttack5(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 150){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;// ******************************ADD ANOTHER CASE FOR THE NEW SKILL
                                            default:
                                                break;
                                        }
                                    }
                                    else if(player.mp <= 0){
                                        player.mp = 0;
                                        System.out.println("\t# You don't have any MP left! Drink an MP potion to restore! #");
                                        player.hp = enemy.pAttack(player, turn);
                                    }
                                }
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_3 = 0;
                                   try{
                                        choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_3 != 1 && choicef1_3 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_3 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_3 == 2){
                                       main(monstersOne);
                                   }
                                }
                                if(enemy.hp <= 0){
                                   System.out.println("\n\t# You defeated the "+enemy.name+"! #");
                                   System.out.println("\t> Remaining HP: " + player.hp);
                                   System.out.println("\t> Remaining MP: " + player.mp);
                                   if(rand.nextInt(100) < hpPotionDropChance){
                                       player.hpPotion++;
                                       System.out.println("\n\t# The enemy drop an HP potion! #");
                                       System.out.println("\t# You have "+ player.hpPotion +" HP potion/s. #");
                                   }
                                   if(rand.nextInt(100) < mpPotionDropChance){
                                       player.mpPotion++;
                                       System.out.println("\n\t# The enemy drop an MP potion! #");
                                       System.out.println("\t# You have "+ player.mpPotion +" MP potion/s. #");
                                   }
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t# PRESS [ENTER] TO PROCEEED. #");
                                   jcb.readLine();
                                   break;
                                }
                                break;
                            case 2:
                                player.hp = player.defend(enemy,turn);
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_4 = 0;
                                   try{
                                        choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_4 != 1 && choicef1_4 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_4 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_4 == 2){
                                       main(monstersOne);
                                   }
                                }//defend algorithm
                                break;
                            case 3:
                                player.itemOption();
                                short choicef1_5 = 0;
                                try{
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_5 != 1 && choicef1_5 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                if(choicef1_5 == 1){
                                    if(player.hpPotion > 0){
                                        if(player.hp < player.maxHp){
                                            player.hp += hpPotionAmount;
                                            if(player.hp > player.maxHp) player.hp = player.maxHp;
                                            player.hpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\n\t# You drink an HP potion, healing by "+hpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.hp+" HP. #");
                                             System.out.println("\t# You have "+ player.hpPotion+" HP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your HP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no HP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                else if(choicef1_5 == 2){
                                    if(player.mpPotion > 0){
                                        if(player.mp < player.maxMp){
                                            player.mp += mpPotionAmount;
                                            if(player.mp > player.maxMp)player.mp = player.maxMp;
                                            player.mpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\t# You drink an MP potion, healing by "+mpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.mp+" MP. #");
                                             System.out.println("\t# You have "+ player.mpPotion+" MP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your MP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no MP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                //item
                                break;
                            case 4:
                                System.out.println("----------------------------------------------------");
                                System.out.println("\n\t# You run away from "+enemy.name+"! #");
                                System.out.println("\t# YOU WEAKLING!!! #");
                                continue FLOOR_8;// ******************************************CHANGE PER FLOOR

                        }
                    }
                }
                
                while(running){//*************************************EIGHT BOSS BATTLE************************************************************

                    enemy = new Enemy("Fafnir", 4000, 800, "Dark Gleam", 900, 500);// CHANGE PER FLOOR ("", +500, + 50, "", +50, +50)
                    System.out.println("\n___________________________________________________");
                    System.out.println("\t# The bossfloor, "+enemy.name+", has appeared! #\n");
                    
                    while(enemy.hp > 0){
                        System.out.println("\t"+player.name+"'s HP: "+ player.hp);
                        System.out.println("\t"+player.name+"'s MP: "+player.mp);
                        System.out.println("\t"+enemy.name+"'s HP: "+ enemy.hp);
                        System.out.println("\n___________________________________________________");
                        System.out.println("[Press Enter to Continue]");
                        jcb.readLine();
                        System.out.println("\n\tWhat would you like to do?");
                        LinkStart.battleMenu();
                        System.out.print("\tYour choice: ");
                        int choicef1;
                        
                        try{
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        catch(Exception e){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        while(choicef1 != 1 && choicef1 != 2 && choicef1 != 3 && choicef1 != 4){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        switch(choicef1){
                            case 1:
                                Player.attack();
                                short choicef1_1 = 0;
                                try{
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_1 != 1 && choicef1_1 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
//**********************************************************PHYSICAL ATTACK*********************************************************************
                                if(choicef1_1 == 1){
                                    enemy.hp = player.pAttack(enemy, turn);
                                    player.hp = enemy.pAttack(player, turn);
                                }
//************************************************************SKILL ATTACK**************************************************************************
                                else if(choicef1_1 == 2){
                                    if(player.mp > 0){
                                        player.sAttackMenu4();// **********************************CHANGE PER 2 FLOOR
                                        int choicef1_2 = 0;
                                        try{
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        catch(Exception e){
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu4();// ********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        while(choicef1_2 != 1 && choicef1_2 != 2 && choicef1_2 != 3 && choicef1_2 != 4 && choicef1_2 != 5){// ****************ADD ANOTHER CHOICE PER 2 FLOOR 
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu4();// ************************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        switch (choicef1_2) {
                                            case 1:
                                                if(player.mp > 30){
                                                    enemy.hp = player.sAttack1(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.sAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 30){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 2:
                                                if(player.mp > 50){
                                                    enemy.hp = player.sAttack2(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.sAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 50){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.sAttack(player, turn);
                                                }
                                                break;
                                            case 3:
                                                if(player.mp > 75){
                                                    enemy.hp = player.sAttack3(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.sAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 75){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.sAttack(player, turn);
                                                }
                                                break;
                                            case 4:
                                                if(player.mp > 100){
                                                    enemy.hp = player.sAttack4(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 100){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 5:
                                                if(player.mp > 150){
                                                    enemy.hp = player.sAttack5(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 150){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;//***********************ADD ANOTHER CASE FOR THE NEW SKILL
                                            default:
                                                break;
                                        }
                                    }
                                    else if(player.mp <= 0){
                                        player.mp = 0;
                                        System.out.println("\t# You don't have any MP left! Drink an MP potion to restore! #");
                                        player.hp = enemy.pAttack(player, turn);
                                    }
                                }
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_3 = 0;
                                   try{
                                        choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_3 != 1 && choicef1_3 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_3 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_3 == 2){
                                       main(monstersOne);
                                   }
                                }
                                if(enemy.hp <= 0){
                                   System.out.println("\t> "+enemy.name+" has been slayed! yata! yata! masoooo!\n"
                                   + "\tTHAT'S WICKED!!!!!");
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t> Remaining HP: " + player.hp);
                                   System.out.println("\t> Remaining MP: " + player.mp);
                                   if(rand.nextInt(100) < hpPotionDropChance){
                                       player.hpPotion++;
                                       System.out.println("\n\t# The enemy drop an HP potion! #");
                                       System.out.println("\t# You have "+ player.hpPotion +" HP potion/s. #");
                                   }
                                   if(rand.nextInt(100) < mpPotionDropChance){
                                       player.mpPotion++;
                                       System.out.println("\n\t# The enemy drop an MP potion! #");
                                       System.out.println("\t# You have "+ player.mpPotion +" MP potion/s. #");
                                   }
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t# PRESS [ENTER] TO PROCEEED. #");
                                   jcb.readLine();
                                   break;
                                }
                                break;
                            case 2:
                                player.hp = player.defend(enemy,turn);
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_4 = 0;
                                   try{
                                        choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_4 != 1 && choicef1_4 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_4 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_4 == 2){
                                       main(monstersOne);
                                   }
                                }//defend algorithm
                                break;
                            case 3:
                                player.itemOption();
                                short choicef1_5 = 0;
                                try{
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_5 != 1 && choicef1_5 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                if(choicef1_5 == 1){
                                    if(player.hpPotion > 0){
                                        if(player.hp < player.maxHp){
                                            player.hp += hpPotionAmount;
                                            if(player.hp > player.maxHp) player.hp = player.maxHp;
                                            player.hpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\n\t# You drink an HP potion, healing by "+hpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.hp+" HP. #");
                                             System.out.println("\t# You have "+ player.hpPotion+" HP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your HP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no HP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                else if(choicef1_5 == 2){
                                    if(player.mpPotion > 0){
                                        if(player.mp < player.maxMp){
                                            player.mp += mpPotionAmount;
                                            if(player.mp > player.maxMp)player.mp = player.maxMp;
                                            player.mpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\t# You drink an MP potion, healing by "+mpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.mp+" MP. #");
                                             System.out.println("\t# You have "+ player.mpPotion+" MP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your MP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no MP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                //item
                                break;
                            case 4:
                                System.out.println("----------------------------------------------------");
                                System.out.println("\n\t# You run away from "+enemy.name+"! #");
                                System.out.println("\t# YOU WEAKLING!!! #");
                                continue FLOOR_8;// ***************************************CHANGE PER FLOOR

                        }
                    }
                    break;
                }
                break;
            }
            
//***************************************************************PLAYER STATUS UPDATE**********************************************************************
            player.maxHp += 100;
            player.hp = player.maxHp;
            player.maxMp += 50;
            player.mp  = player.maxMp;
            player.baseAtk += 15;
            player.baseDef += 15;
            if(player.title == 3){// CHANGE PER FLOOR
                player.skillId6 = 5;
                player.weaponId = 8;// CHANGE PER FLOOR
            }
            else if(player.title == 7){// CHANGE PER FLOOR
                player.skillId6 = 11;
                player.weaponId = 18;// CHANGE PER FLOOR
            }
            else if(player.title == 11){// CHANGE PER FLOOR
                player.skillId6 = 17;
                player.weaponId = 28;// CHANGE PER FLOOR
            }
            player.armorId = 8;//******************************************* CHANGE PER FLOOR
            
             System.out.println("\t# You acquired new equipments! #");
             System.out.println("\t> Weapon: "+eqp.getWeaponName(player.weaponId));
             System.out.println("\t> Armor: "+eqp.getArmorName(player.armorId));
             System.out.println("\n\t"+eqp.getWeaponName(player.weaponId)+" equiped.");
             System.out.println("\t"+eqp.getArmorName(player.armorId)+" equiped.");
             System.out.println("\t# PRESS [ENTER] TO PROCEED. #");
             jcb.readLine();
             System.out.println("\n___________________________________________________");
             System.out.println("\t#************PLAYER STATUS LEVEL UP!**************#");
             jcb.readLine();
             System.out.println("\n\t# ***YOU ACQUIRED A NEW SKILL!!!*** #");
             jcb.readLine();
             System.out.println("\t\t> "+pskills.getPlayerSkillName(player.skillId6)+"!");
             jcb.readLine();
             System.out.println("\n\t# HP increased by 100! #");
             System.out.println("\n\t# MP increased by 50! #");
             jcb.readLine();
             PlayerStatus.playerStatus5(player);//**************** CHANGE PER 2 FLOOR
             System.out.println("\n___________________________________________________");
             System.out.println("\t# PRESS [ENTER] TO PROCEED. #");
             jcb.readLine();
            LinkStart.eighthFloorClr();//***************************CHANGE PER FLOOR
             System.out.print("\tYour choice: ");
             short choice8 = 0;
             
             try{
                 choice8 = Short.parseShort(jcb.readLine());
             }
             catch(Exception e){
                 System.out.println("\t# INVALID COMMAND! #");
                 System.out.print("\tYour choice: ");
                 choice8 = Short.parseShort(jcb.readLine());
             }
             while(choice8 != 1 && choice8 != 2 && choice8 != 3){
                 System.out.println("\t# INVALID COMMAND! #");
                 System.out.print("\tYour choice: ");
                 choice8 = Short.parseShort(jcb.readLine());
             }
             if(choice8 == 1){
                 System.out.println("\n\t# Great! #");
                 System.out.println("\t# Press [ENTER] to proceed to the next area! #");
                 jcb.readLine();
             }
             else if(choice8 == 2){
                 System.out.println("You took a short nap");
                 // ***************************************MAKE A SHORT SIMULATION IN CHOICE 2*****************************
                 jcb.readLine();
             }
             else if(choice8 == 3){
                 System.out.println("\tAhhhhhhhhhhh~~~ What a weakling.\n");
                 System.out.println("\t**************************");
                 System.out.println("\t**************************");
                 System.out.println("\t**THANK YOU FOR PLAYING!**");
                 System.out.println("\t**************************");
                 System.out.println("\t**************************");
                 System.out.println("\n\t> Press [ENTER] to exit.");
                 jcb.readLine();
                 System.exit(0);
             }
             
             //**************************************************FLOOR 9 DIALOGUE INPUT******************************************************
             floorDialogue.ninthFloorDialogue(player);
             jcb.readLine();
             
             FLOOR_9://**************************************************NINTH FLOOR************************************************************
            while(floorNine){// ***********************************MONSTER BATTLE*************************************************************
                String[] monstersOne = {"Golem","Dark Tent","Fire Elmo","Three-Eyed Mandrake"};// CHANGE PER FLOOR
                int maxMonsterHp = 900;// CHANGE PER FLOOR BY 100
                int monsterAtkDmg = 900;// CHANGE PER FLOOR BY 100
                int hpPotionAmount = 270;// CHANGE PER FLOOR BY 30
                int mpPotionAmount = 270;// CHANGE PER FLOOR BY 30
                int hpPotionDropChance = 50;//percentage
                int mpPotionDropChance = 50;
                
                for(int i = 0; i < 5; i+= 1){
                    rand = new Random(i);
                    enemy = new Enemy("",0,0,"",0,0);
                    enemy.hp = rand.nextInt(maxMonsterHp);
                    enemy.name = monstersOne[rand.nextInt(monstersOne.length)];
                    enemy.baseAtk = rand.nextInt(monsterAtkDmg);
                    
                    System.out.println("\n___________________________________________________");
                    System.out.println("\t# "+enemy.name+" has appeared! #\n");
                    
                    while(enemy.hp > 0){
                        System.out.println("\t"+player.name+"'s HP: "+ player.hp);
                        System.out.println("\t"+player.name+"'s MP: "+player.mp);
                        System.out.println("\t"+enemy.name+"'s HP: "+ enemy.hp);
                        System.out.println("\n___________________________________________________");
                        System.out.println("\n\tWhat would you like to do?");
                        LinkStart.battleMenu();
                        System.out.print("\tYour choice: ");
                        int choicef1;
                        
                        try{
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        catch(Exception e){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        while(choicef1 != 1 && choicef1 != 2 && choicef1 != 3 && choicef1 != 4){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        switch(choicef1){
                            case 1:
                                Player.attack();
                                short choicef1_1 = 0;
                                try{
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_1 != 1 && choicef1_1 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
//**********************************************************PHYSICAL ATTACK*********************************************************************
                                if(choicef1_1 == 1){
                                    enemy.hp = player.pAttack(enemy, turn);
                                    player.hp = enemy.pAttack(player, turn);
                                }
//************************************************************SKILL ATTACK**************************************************************************
                                else if(choicef1_1 == 2){
                                    if(player.mp > 0){
                                        player.sAttackMenu5();// ***************************************CHANGE PER 2 FLOOR
                                        int choicef1_2 = 0;
                                        try{
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        catch(Exception e){
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu5();// *********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        while(choicef1_2 != 1 && choicef1_2 != 2 && choicef1_2 != 3 && choicef1_2 != 4 && choicef1_2 != 5 && choicef1_2 != 6){// ****************ADD ANOTHER CHOICE PER 2 FLOOR
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu5();// *********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        switch (choicef1_2) {
                                            case 1:
                                                if(player.mp > 30){
                                                    enemy.hp = player.sAttack1(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 30){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 2:
                                                if(player.mp > 50){
                                                    enemy.hp = player.sAttack2(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 50){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 3:
                                                if(player.mp > 75){
                                                    enemy.hp = player.sAttack3(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 75){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 4:
                                                if(player.mp > 100){
                                                    enemy.hp = player.sAttack4(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 100){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 5:
                                                if(player.mp > 150){
                                                    enemy.hp = player.sAttack5(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 150){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 6:
                                                if(player.mp > 200){
                                                    enemy.hp = player.sAttack6(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 200){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;// ******************************ADD ANOTHER CASE FOR THE NEW SKILL
                                            default:
                                                break;
                                        }
                                    }
                                    else if(player.mp <= 0){
                                        player.mp = 0;
                                        System.out.println("\t# You don't have any MP left! Drink an MP potion to restore! #");
                                        player.hp = enemy.pAttack(player, turn);
                                    }
                                }
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_3 = 0;
                                   try{
                                        choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_3 != 1 && choicef1_3 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_3 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_3 == 2){
                                       main(monstersOne);
                                   }
                                }
                                if(enemy.hp <= 0){
                                   System.out.println("\n\t# You defeated the "+enemy.name+"! #");
                                   System.out.println("\t> Remaining HP: " + player.hp);
                                   System.out.println("\t> Remaining MP: " + player.mp);
                                   if(rand.nextInt(100) < hpPotionDropChance){
                                       player.hpPotion++;
                                       System.out.println("\n\t# The enemy drop an HP potion! #");
                                       System.out.println("\t# You have "+ player.hpPotion +" HP potion/s. #");
                                   }
                                   if(rand.nextInt(100) < mpPotionDropChance){
                                       player.mpPotion++;
                                       System.out.println("\n\t# The enemy drop an MP potion! #");
                                       System.out.println("\t# You have "+ player.mpPotion +" MP potion/s. #");
                                   }
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t# PRESS [ENTER] TO PROCEEED. #");
                                   jcb.readLine();
                                   break;
                                }
                                break;
                            case 2:
                                player.hp = player.defend(enemy,turn);
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_4 = 0;
                                   try{
                                        choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_4 != 1 && choicef1_4 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_4 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_4 == 2){
                                       main(monstersOne);
                                   }
                                }//defend algorithm
                                break;
                            case 3:
                                player.itemOption();
                                short choicef1_5 = 0;
                                try{
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_5 != 1 && choicef1_5 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                if(choicef1_5 == 1){
                                    if(player.hpPotion > 0){
                                        if(player.hp < player.maxHp){
                                            player.hp += hpPotionAmount;
                                            if(player.hp > player.maxHp) player.hp = player.maxHp;
                                            player.hpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\n\t# You drink an HP potion, healing by "+hpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.hp+" HP. #");
                                             System.out.println("\t# You have "+ player.hpPotion+" HP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your HP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no HP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                else if(choicef1_5 == 2){
                                    if(player.mpPotion > 0){
                                        if(player.mp < player.maxMp){
                                            player.mp += mpPotionAmount;
                                            if(player.mp > player.maxMp)player.mp = player.maxMp;
                                            player.mpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\t# You drink an MP potion, healing by "+mpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.mp+" MP. #");
                                             System.out.println("\t# You have "+ player.mpPotion+" MP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your MP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no MP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                //item
                                break;
                            case 4:
                                System.out.println("----------------------------------------------------");
                                System.out.println("\n\t# You run away from "+enemy.name+"! #");
                                System.out.println("\t# YOU WEAKLING!!! #");
                                continue FLOOR_9;// ******************************************CHANGE PER FLOOR

                        }
                    }
                }
                
                while(running){//*************************************NINTH BOSS BATTLE************************************************************

                    enemy = new Enemy("The Smog", 4500, 900, "Fire Breathe", 1000, 550);// CHANGE PER FLOOR ("", +500, + 50, "", +50, +50)
                    System.out.println("\n___________________________________________________");
                    System.out.println("\t# The bossfloor, "+enemy.name+", has appeared! #\n");
                    
                    while(enemy.hp > 0){
                        System.out.println("\t"+player.name+"'s HP: "+ player.hp);
                        System.out.println("\t"+player.name+"'s MP: "+player.mp);
                        System.out.println("\t"+enemy.name+"'s HP: "+ enemy.hp);
                        System.out.println("\n___________________________________________________");
                        System.out.println("[Press Enter to Continue]");
                        jcb.readLine();
                        System.out.println("\n\tWhat would you like to do?");
                        LinkStart.battleMenu();
                        System.out.print("\tYour choice: ");
                        int choicef1;
                        
                        try{
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        catch(Exception e){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        while(choicef1 != 1 && choicef1 != 2 && choicef1 != 3 && choicef1 != 4){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        switch(choicef1){
                            case 1:
                                Player.attack();
                                short choicef1_1 = 0;
                                try{
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_1 != 1 && choicef1_1 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
//**********************************************************PHYSICAL ATTACK*********************************************************************
                                if(choicef1_1 == 1){
                                    enemy.hp = player.pAttack(enemy, turn);
                                    player.hp = enemy.pAttack(player, turn);
                                }
//************************************************************SKILL ATTACK**************************************************************************
                                else if(choicef1_1 == 2){
                                    if(player.mp > 0){
                                        player.sAttackMenu5();// **********************************CHANGE PER 2 FLOOR
                                        int choicef1_2 = 0;
                                        try{
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        catch(Exception e){
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu5();// ********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        while(choicef1_2 != 1 && choicef1_2 != 2 && choicef1_2 != 3 && choicef1_2 != 4 && choicef1_2 != 5 && choicef1_2 != 6){// ****************ADD ANOTHER CHOICE PER 2 FLOOR 
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu5();// ************************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        switch (choicef1_2) {
                                            case 1:
                                                if(player.mp > 30){
                                                    enemy.hp = player.sAttack1(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.sAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 30){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 2:
                                                if(player.mp > 50){
                                                    enemy.hp = player.sAttack2(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.sAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 50){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.sAttack(player, turn);
                                                }
                                                break;
                                            case 3:
                                                if(player.mp > 75){
                                                    enemy.hp = player.sAttack3(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.sAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 75){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.sAttack(player, turn);
                                                }
                                                break;
                                            case 4:
                                                if(player.mp > 100){
                                                    enemy.hp = player.sAttack4(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 100){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 5:
                                                if(player.mp > 150){
                                                    enemy.hp = player.sAttack5(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 150){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 6:
                                                if(player.mp > 200){
                                                    enemy.hp = player.sAttack6(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 200){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;//***********************ADD ANOTHER CASE FOR THE NEW SKILL
                                            default:
                                                break;
                                        }
                                    }
                                    else if(player.mp <= 0){
                                        player.mp = 0;
                                        System.out.println("\t# You don't have any MP left! Drink an MP potion to restore! #");
                                        player.hp = enemy.pAttack(player, turn);
                                    }
                                }
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_3 = 0;
                                   try{
                                        choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_3 != 1 && choicef1_3 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_3 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_3 == 2){
                                       main(monstersOne);
                                   }
                                }
                                if(enemy.hp <= 0){
                                   System.out.println("\t> "+enemy.name+" has been slayed! yata! yata! masoooo!\n"
                                   + "\tTHAT'S WICKED!!!!!");
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t> Remaining HP: " + player.hp);
                                   System.out.println("\t> Remaining MP: " + player.mp);
                                   if(rand.nextInt(100) < hpPotionDropChance){
                                       player.hpPotion++;
                                       System.out.println("\n\t# The enemy drop an HP potion! #");
                                       System.out.println("\t# You have "+ player.hpPotion +" HP potion/s. #");
                                   }
                                   if(rand.nextInt(100) < mpPotionDropChance){
                                       player.mpPotion++;
                                       System.out.println("\n\t# The enemy drop an MP potion! #");
                                       System.out.println("\t# You have "+ player.mpPotion +" MP potion/s. #");
                                   }
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t# PRESS [ENTER] TO PROCEEED. #");
                                   jcb.readLine();
                                   break;
                                }
                                break;
                            case 2:
                                player.hp = player.defend(enemy,turn);
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_4 = 0;
                                   try{
                                        choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_4 != 1 && choicef1_4 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_4 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_4 == 2){
                                       main(monstersOne);
                                   }
                                }//defend algorithm
                                break;
                            case 3:
                                player.itemOption();
                                short choicef1_5 = 0;
                                try{
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_5 != 1 && choicef1_5 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                if(choicef1_5 == 1){
                                    if(player.hpPotion > 0){
                                        if(player.hp < player.maxHp){
                                            player.hp += hpPotionAmount;
                                            if(player.hp > player.maxHp) player.hp = player.maxHp;
                                            player.hpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\n\t# You drink an HP potion, healing by "+hpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.hp+" HP. #");
                                             System.out.println("\t# You have "+ player.hpPotion+" HP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your HP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no HP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                else if(choicef1_5 == 2){
                                    if(player.mpPotion > 0){
                                        if(player.mp < player.maxMp){
                                            player.mp += mpPotionAmount;
                                            if(player.mp > player.maxMp)player.mp = player.maxMp;
                                            player.mpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\t# You drink an MP potion, healing by "+mpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.mp+" MP. #");
                                             System.out.println("\t# You have "+ player.mpPotion+" MP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your MP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no MP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                //item
                                break;
                            case 4:
                                System.out.println("----------------------------------------------------");
                                System.out.println("\n\t# You run away from "+enemy.name+"! #");
                                System.out.println("\t# YOU WEAKLING!!! #");
                                continue FLOOR_9;// ***************************************CHANGE PER FLOOR

                        }
                    }
                    break;
                }
                break;
            }
            
//***************************************************************PLAYER STATUS UPDATE**********************************************************************
            player.maxHp += 100;
            player.hp = player.maxHp;
            player.maxMp += 50;
            player.mp  = player.maxMp;
            player.baseAtk += 10;
            player.baseDef += 10;
            if(player.title == 3){
                player.weaponId = 9;
            }
            else if(player.title == 7){
                player.weaponId = 19;
            }
            else if(player.title == 11){
                player.weaponId = 29;
            }
            player.armorId = 9;
            
             System.out.println("\t# You acquired new equipments! #");
             System.out.println("\t> Weapon: "+eqp.getWeaponName(player.weaponId));
             System.out.println("\t> Armor: "+eqp.getArmorName(player.armorId));
             System.out.println("\n\t"+eqp.getWeaponName(player.weaponId)+" equiped.");
             System.out.println("\t"+eqp.getArmorName(player.armorId)+" equiped.");
             System.out.println("\t# PRESS [ENTER] TO PROCEED. #");
             jcb.readLine();
             System.out.println("\n___________________________________________________");
             System.out.println("\t#************PLAYER STATUS LEVEL UP!**************#");
             jcb.readLine();
             System.out.println("\n\t# HP increased by 100! #");
             System.out.println("\n\t# MP increased by 50! #");
             jcb.readLine();
             PlayerStatus.playerStatus5(player);//**************** CHANGE PER 2 FLOOR
             System.out.println("\n___________________________________________________");
             System.out.println("\t# PRESS [ENTER] TO PROCEED. #");
             jcb.readLine();
            LinkStart.ninthFloorClr();//***************************CHANGE PER FLOOR
             System.out.print("\tYour choice: ");
             short choice9 = 0;
             
             try{
                 choice9 = Short.parseShort(jcb.readLine());
             }
             catch(Exception e){
                 System.out.println("\t# INVALID COMMAND! #");
                 System.out.print("\tYour choice: ");
                 choice9 = Short.parseShort(jcb.readLine());
             }
             while(choice9 != 1 && choice9 != 2 && choice9 != 3){
                 System.out.println("\t# INVALID COMMAND! #");
                 System.out.print("\tYour choice: ");
                 choice9 = Short.parseShort(jcb.readLine());
             }
             if(choice9 == 1){
                 System.out.println("\n\t# Great! #");
                 System.out.println("\t# Press [ENTER] to proceed to the next area! #");
                 jcb.readLine();
             }
             else if(choice9 == 2){
                 System.out.println("You took a short nap");
                 // ***************************************MAKE A SHORT SIMULATION IN CHOICE 2*****************************
                 jcb.readLine();
             }
             else if(choice9 == 3){
                 System.out.println("\tAhhhhhhhhhhh~~~ What a weakling.\n");
                 System.out.println("\t**************************");
                 System.out.println("\t**************************");
                 System.out.println("\t**THANK YOU FOR PLAYING!**");
                 System.out.println("\t**************************");
                 System.out.println("\t**************************");
                 System.out.println("\n\t> Press [ENTER] to exit.");
                 jcb.readLine();
                 System.exit(0);
             }
             
             //**************************************************FLOOR 10 DIALOGUE INPUT******************************************************
             floorDialogue.tenthFloorDialogue(player);
             jcb.readLine();
             
             FLOOR_10://**************************************************TENTH FLOOR************************************************************
            while(floorTen){// ***********************************MONSTER BATTLE*************************************************************
                String[] monstersOne = {"Fenris","Cerberos","Tsuchinoko","Earth Spider"};// CHANGE PER FLOOR
                int maxMonsterHp = 1000;// CHANGE PER FLOOR BY 100
                int monsterAtkDmg = 1000;// CHANGE PER FLOOR BY 100
                int hpPotionAmount = 300;// CHANGE PER FLOOR BY 30
                int mpPotionAmount = 300;// CHANGE PER FLOOR BY 30
                int hpPotionDropChance = 50;//percentage
                int mpPotionDropChance = 50;
                
                for(int i = 0; i < 5; i+= 1){
                    rand = new Random(i);
                    enemy = new Enemy("",0,0,"",0,0);
                    enemy.hp = rand.nextInt(maxMonsterHp);
                    enemy.name = monstersOne[rand.nextInt(monstersOne.length)];
                    enemy.baseAtk = rand.nextInt(monsterAtkDmg);
                    
                    System.out.println("\n___________________________________________________");
                    System.out.println("\t# "+enemy.name+" has appeared! #\n");
                    
                    while(enemy.hp > 0){
                        System.out.println("\t"+player.name+"'s HP: "+ player.hp);
                        System.out.println("\t"+player.name+"'s MP: "+player.mp);
                        System.out.println("\t"+enemy.name+"'s HP: "+ enemy.hp);
                        System.out.println("\n___________________________________________________");
                        System.out.println("\n\tWhat would you like to do?");
                        LinkStart.battleMenu();
                        System.out.print("\tYour choice: ");
                        int choicef1;
                        
                        try{
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        catch(Exception e){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        while(choicef1 != 1 && choicef1 != 2 && choicef1 != 3 && choicef1 != 4){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        switch(choicef1){
                            case 1:
                                Player.attack();
                                short choicef1_1 = 0;
                                try{
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_1 != 1 && choicef1_1 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
//**********************************************************PHYSICAL ATTACK*********************************************************************
                                if(choicef1_1 == 1){
                                    enemy.hp = player.pAttack(enemy, turn);
                                    player.hp = enemy.pAttack(player, turn);
                                }
//************************************************************SKILL ATTACK**************************************************************************
                                else if(choicef1_1 == 2){
                                    if(player.mp > 0){
                                        player.sAttackMenu5();// ***************************************CHANGE PER 2 FLOOR
                                        int choicef1_2 = 0;
                                        try{
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        catch(Exception e){
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu5();// *********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        while(choicef1_2 != 1 && choicef1_2 != 2 && choicef1_2 != 3 && choicef1_2 != 4 && choicef1_2 != 5 && choicef1_2 != 6){// ****************ADD ANOTHER CHOICE PER 2 FLOOR
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu5();// *********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        switch (choicef1_2) {
                                            case 1:
                                                if(player.mp > 30){
                                                    enemy.hp = player.sAttack1(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 30){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 2:
                                                if(player.mp > 50){
                                                    enemy.hp = player.sAttack2(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 50){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 3:
                                                if(player.mp > 75){
                                                    enemy.hp = player.sAttack3(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 75){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 4:
                                                if(player.mp > 100){
                                                    enemy.hp = player.sAttack4(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 100){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 5:
                                                if(player.mp > 150){
                                                    enemy.hp = player.sAttack5(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 150){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 6:
                                                if(player.mp > 200){
                                                    enemy.hp = player.sAttack6(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 200){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;// ******************************ADD ANOTHER CASE FOR THE NEW SKILL
                                            default:
                                                break;
                                        }
                                    }
                                    else if(player.mp <= 0){
                                        player.mp = 0;
                                        System.out.println("\t# You don't have any MP left! Drink an MP potion to restore! #");
                                        player.hp = enemy.pAttack(player, turn);
                                    }
                                }
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_3 = 0;
                                   try{
                                        choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_3 != 1 && choicef1_3 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_3 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_3 == 2){
                                       main(monstersOne);
                                   }
                                }
                                if(enemy.hp <= 0){
                                   System.out.println("\n\t# You defeated the "+enemy.name+"! #");
                                   System.out.println("\t> Remaining HP: " + player.hp);
                                   System.out.println("\t> Remaining MP: " + player.mp);
                                   if(rand.nextInt(100) < hpPotionDropChance){
                                       player.hpPotion++;
                                       System.out.println("\n\t# The enemy drop an HP potion! #");
                                       System.out.println("\t# You have "+ player.hpPotion +" HP potion/s. #");
                                   }
                                   if(rand.nextInt(100) < mpPotionDropChance){
                                       player.mpPotion++;
                                       System.out.println("\n\t# The enemy drop an MP potion! #");
                                       System.out.println("\t# You have "+ player.mpPotion +" MP potion/s. #");
                                   }
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t# PRESS [ENTER] TO PROCEEED. #");
                                   jcb.readLine();
                                   break;
                                }
                                break;
                            case 2:
                                player.hp = player.defend(enemy,turn);
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_4 = 0;
                                   try{
                                        choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_4 != 1 && choicef1_4 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_4 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_4 == 2){
                                       main(monstersOne);
                                   }
                                }//defend algorithm
                                break;
                            case 3:
                                player.itemOption();
                                short choicef1_5 = 0;
                                try{
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_5 != 1 && choicef1_5 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                if(choicef1_5 == 1){
                                    if(player.hpPotion > 0){
                                        if(player.hp < player.maxHp){
                                            player.hp += hpPotionAmount;
                                            if(player.hp > player.maxHp) player.hp = player.maxHp;
                                            player.hpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\n\t# You drink an HP potion, healing by "+hpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.hp+" HP. #");
                                             System.out.println("\t# You have "+ player.hpPotion+" HP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your HP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no HP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                else if(choicef1_5 == 2){
                                    if(player.mpPotion > 0){
                                        if(player.mp < player.maxMp){
                                            player.mp += mpPotionAmount;
                                            if(player.mp > player.maxMp)player.mp = player.maxMp;
                                            player.mpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\t# You drink an MP potion, healing by "+mpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.mp+" MP. #");
                                             System.out.println("\t# You have "+ player.mpPotion+" MP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your MP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no MP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                //item
                                break;
                            case 4:
                                System.out.println("----------------------------------------------------");
                                System.out.println("\n\t# You run away from "+enemy.name+"! #");
                                System.out.println("\t# YOU WEAKLING!!! #");
                                continue FLOOR_10;// ******************************************CHANGE PER FLOOR

                        }
                    }
                }
                
                while(running){//*************************************TENTH BOSS BATTLE************************************************************

                    enemy = new Enemy("Draco", 5000, 1000, "Dark Matter", 1100, 600);// CHANGE PER FLOOR ("", +500, + 50, "", +50, +50)
                    System.out.println("\n___________________________________________________");
                    System.out.println("\t# The bossfloor, "+enemy.name+", has appeared! #\n");
                    
                    while(enemy.hp > 0){
                        System.out.println("\t"+player.name+"'s HP: "+ player.hp);
                        System.out.println("\t"+player.name+"'s MP: "+player.mp);
                        System.out.println("\t"+enemy.name+"'s HP: "+ enemy.hp);
                        System.out.println("\n___________________________________________________");
                        System.out.println("[Press Enter to Continue]");
                        jcb.readLine();
                        System.out.println("\n\tWhat would you like to do?");
                        LinkStart.battleMenu();
                        System.out.print("\tYour choice: ");
                        int choicef1;
                        
                        try{
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        catch(Exception e){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        while(choicef1 != 1 && choicef1 != 2 && choicef1 != 3 && choicef1 != 4){
                            System.out.println("\t# INVALID COMMAND! #");
                            System.out.println("\n\tWhat would you like to do?");
                            LinkStart.battleMenu();
                            System.out.print("\tYour choice: ");
                            choicef1 = Integer.parseInt(jcb.readLine());
                        }
                        switch(choicef1){
                            case 1:
                                Player.attack();
                                short choicef1_1 = 0;
                                try{
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_1 != 1 && choicef1_1 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    Player.attack();
                                    choicef1_1 = Short.parseShort(jcb.readLine());
                                }
//**********************************************************PHYSICAL ATTACK*********************************************************************
                                if(choicef1_1 == 1){
                                    enemy.hp = player.pAttack(enemy, turn);
                                    player.hp = enemy.pAttack(player, turn);
                                }
//************************************************************SKILL ATTACK**************************************************************************
                                else if(choicef1_1 == 2){
                                    if(player.mp > 0){
                                        player.sAttackMenu5();// **********************************CHANGE PER 2 FLOOR
                                        int choicef1_2 = 0;
                                        try{
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        catch(Exception e){
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu5();// ********************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        while(choicef1_2 != 1 && choicef1_2 != 2 && choicef1_2 != 3 && choicef1_2 != 4 && choicef1_2 != 5 && choicef1_2 != 6){// ****************ADD ANOTHER CHOICE PER 2 FLOOR 
                                            System.out.println("\t# INVALID COMMAND! #");
                                            player.sAttackMenu5();// ************************************CHANGE PER 2 FLOOR
                                            choicef1_2 = Integer.parseInt(jcb.readLine());
                                        }
                                        switch (choicef1_2) {
                                            case 1:
                                                if(player.mp > 30){
                                                    enemy.hp = player.sAttack1(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.sAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 30){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 2:
                                                if(player.mp > 50){
                                                    enemy.hp = player.sAttack2(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.sAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 50){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.sAttack(player, turn);
                                                }
                                                break;
                                            case 3:
                                                if(player.mp > 75){
                                                    enemy.hp = player.sAttack3(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.sAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 75){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.sAttack(player, turn);
                                                }
                                                break;
                                            case 4:
                                                if(player.mp > 100){
                                                    enemy.hp = player.sAttack4(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 100){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 5:
                                                if(player.mp > 150){
                                                    enemy.hp = player.sAttack5(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 150){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;
                                            case 6:
                                                if(player.mp > 200){
                                                    enemy.hp = player.sAttack6(enemy, turn);
                                                    if(enemy.hp > 0){
                                                        player.hp = enemy.pAttack(player, turn);
                                                    }
                                                }
                                                else if(player.mp < 200){
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.println("\t# You don't have enough MP, Drink an MP potion to restore! #");
                                                    player.hp = enemy.pAttack(player, turn);
                                                }
                                                break;//***********************ADD ANOTHER CASE FOR THE NEW SKILL
                                            default:
                                                break;
                                        }
                                    }
                                    else if(player.mp <= 0){
                                        player.mp = 0;
                                        System.out.println("\t# You don't have any MP left! Drink an MP potion to restore! #");
                                        player.hp = enemy.pAttack(player, turn);
                                    }
                                }
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_3 = 0;
                                   try{
                                        choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_3 != 1 && choicef1_3 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_3 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_3 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_3 == 2){
                                       main(monstersOne);
                                   }
                                }
                                if(enemy.hp <= 0){
                                   System.out.println("\t> "+enemy.name+" has been slayed! yata! yata! masoooo!\n"
                                   + "\tTHAT'S WICKED!!!!!");
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t> Remaining HP: " + player.hp);
                                   System.out.println("\t> Remaining MP: " + player.mp);
                                   if(rand.nextInt(100) < hpPotionDropChance){
                                       player.hpPotion++;
                                       System.out.println("\n\t# The enemy drop an HP potion! #");
                                       System.out.println("\t# You have "+ player.hpPotion +" HP potion/s. #");
                                   }
                                   if(rand.nextInt(100) < mpPotionDropChance){
                                       player.mpPotion++;
                                       System.out.println("\n\t# The enemy drop an MP potion! #");
                                       System.out.println("\t# You have "+ player.mpPotion +" MP potion/s. #");
                                   }
                                   System.out.println("\n___________________________________________________");
                                   System.out.println("\t# PRESS [ENTER] TO PROCEEED. #");
                                   jcb.readLine();
                                   break;
                                }
                                break;
                            case 2:
                                player.hp = player.defend(enemy,turn);
                                if(player.hp <= 0){
                                   LinkStart.gameOverMenu();
                                   short choicef1_4 = 0;
                                   try{
                                        choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   catch(Exception e){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   while(choicef1_4 != 1 && choicef1_4 != 2){
                                       System.out.println("\t# INVALID COMMAND! #");
                                       LinkStart.gameOverMenu();
                                       choicef1_4 = Short.parseShort(jcb.readLine());
                                   }
                                   if(choicef1_4 == 1){
                                       player.hp = player.maxHp;
                                       player.mp = player.maxMp;
                                       player.hpPotion = 5;
                                       player.mpPotion = 5;
                                       battle();
                                   }
                                   else if(choicef1_4 == 2){
                                       main(monstersOne);
                                   }
                                }//defend algorithm
                                break;
                            case 3:
                                player.itemOption();
                                short choicef1_5 = 0;
                                try{
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                catch(Exception e){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                while(choicef1_5 != 1 && choicef1_5 != 2){
                                    System.out.println("\t# INVALID COMMAND! #");
                                    player.itemOption();
                                    choicef1_5 = Short.parseShort(jcb.readLine());
                                }
                                if(choicef1_5 == 1){
                                    if(player.hpPotion > 0){
                                        if(player.hp < player.maxHp){
                                            player.hp += hpPotionAmount;
                                            if(player.hp > player.maxHp) player.hp = player.maxHp;
                                            player.hpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\n\t# You drink an HP potion, healing by "+hpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.hp+" HP. #");
                                             System.out.println("\t# You have "+ player.hpPotion+" HP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your HP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no HP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                else if(choicef1_5 == 2){
                                    if(player.mpPotion > 0){
                                        if(player.mp < player.maxMp){
                                            player.mp += mpPotionAmount;
                                            if(player.mp > player.maxMp)player.mp = player.maxMp;
                                            player.mpPotion --;
                                            System.out.println("----------------------------------------------------");
                                            System.out.println("\t# You drink an MP potion, healing by "+mpPotionAmount+". #");
                                             System.out.println("\t# You now have "+player.mp+" MP. #");
                                             System.out.println("\t# You have "+ player.mpPotion+" MP potions left. #");
                                        }
                                        else{
                                            System.out.println("\n\t# Your MP is still full, you don't need to drink. #");
                                        }
                                    }
                                    else{
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("\t# You have no MP potions left! Defeat an enemy to get a chance on obtaining one! #");
                                    }
                                    player.hp = enemy.pAttack(player, turn);
                                    System.out.println("\n");
                                }
                                //item
                                break;
                            case 4:
                                System.out.println("----------------------------------------------------");
                                System.out.println("\n\t# You run away from "+enemy.name+"! #");
                                System.out.println("\t# YOU WEAKLING!!! #");
                                continue FLOOR_10;// ***************************************CHANGE PER FLOOR

                        }
                    }
                    break;
                }
                break;
            }
             
            //************************************************ENDING**************************************************************
             floorDialogue.Ending(player);
             jcb.readLine();
             floorDialogue.Credits();
             jcb.readLine();
             System.out.println("\t**************************");
                 System.out.println("\t**************************");
                 System.out.println("\t**THANK YOU FOR PLAYING!**");
                 System.out.println("\t**************************");
                 System.out.println("\t**************************");
                 System.out.println("\n\t> Press [ENTER] to exit.");
                 jcb.readLine();
                 System.exit(0);
        }
     }
}