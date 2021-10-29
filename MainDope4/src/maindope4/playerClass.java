package maindope4;

public class playerClass {
    public String[] proffesion = {
        //*****************************KNIGHT CLASS******************************************
        "Knight",//[0]
        "Holy Knight",//[1]
        "Crusader",//[2]
        "Paladin",//[3]
        //*****************************MAGE CLASS********************************************
        "Mage",//[4]
        "Arc Wizard",//[5]
        "Magic Stigma",//[6]
        "Over Lord",//[7]
        //*****************************ARCHER CLASS******************************************
        "Archer",//[8]
        "Wind Striker",//[9]
        "Thousand Eyes",//[10]
        "Prophet of the sun god",//[11]
    };
    
    public String getplayerClass(int classId){
        return this.proffesion[classId];
    }//return statement*****************************************************************
}
