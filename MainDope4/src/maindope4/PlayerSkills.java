package maindope4;

public class PlayerSkills {
    
    public String []playerSkills = {
        //******************************************KNIGHT SKILLS**************************************
        "HEAVENLY STRIKE",//0 ---GIVEN
        "DIVINE SLASH",//1 ---GIVEN
        "THUNDER BLADE",//2
        "GATHERING LIGHTS OF THE LIGHTNING LORD",//3
        "ROAR OF THE BLACK BAHAMUT",//4
        "SERVERESTA",//5 SPECIAL ATTACK
        //*******************************************MAGE SKILLS****************************************
        "AMARYLLIS",//6
        "SUSANOO'S GREAT SEA",//7
        "YATO NO KAGAMI",//8
        "NARAKU",//9
        "VANISHMENT, THIS WORLD",//10
        "EXPLOSION",//11 SPECIAL ATTACK
        //********************************************ARCHER SKILLS***************************************
        "RAIN OF THE GOLDEN STRIKE",//12
        "LIGHTNING RUSH",//13
        "WHITE NOVA",//14
        "METEOR SHOT",//15
        "RAYS OF THE SUN GOD",//16
        "GATE OF THE INFINITE WEAPONS"//17 SPECIAL ATTACK
    };
    
    public int []playerSkillDmg = {
        300,
        500,
        700,
        900,
        1000,
        1200,
        
        
        300,
        500,
        700,
        900,
        1000,
        1200,
        
        
        300,
        500,
        700,
        900,
        1000,
        1200,
    };
    
    public String getPlayerSkillName(int skillId){
        return this.playerSkills[skillId];
    }
    
    public int getPlayerSkillDmg(int skillId){
        return this.playerSkillDmg[skillId];
    }
}
