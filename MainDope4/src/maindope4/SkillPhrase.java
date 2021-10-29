package maindope4;

public class SkillPhrase {
    
    public String []playerSkillCatchPhrase = {
        //******************************************KNIGHT SKILLS**************************************
        "Gods from the heaven above, Grant me thy power!!!",//"Heavenly Strike",
        "Divine Spirits of goodwill, lend me your presence!!!",//"Divine Slash",
        "Strike it down!!!",// THUNDER BLADE
        "Oh, omnipotent deity of the mighty clouds... Grant me thy power of the scattering lightning!!!",//"Gathering Lights of the Roaring Thunder",
        "Ancient dragon of the past destruction, Soar to the sky and reign once again!!!",//"Roar of the Black Bahamut",//SPECIAL ATTACK
        "With the sword inside me, I shall break out of this starry prison, and release my savage force!!!",//
        
        //*******************************************MAGE SKILLS****************************************
        "Burst into Bloom!!!",//"Amarilies",
        "Great sea God of the east, be my waves!!!",//"Susanoo's Great Sea",
        "God of calamity, return thy evil, back to the netherworld!!!",//"Yato no Kagami",
        "Return thy evil to the void!!!",//NARAKU
        "Be destroyed, Real! Blow up, Synapses!",// VANISHMENT THIS WORLD
        "Darkness, blacker than black and darker than black,\n"
            + "I beseech thee, combine with my deep crimson,\n"
            + "The time of awakening cometh!\n"
            + "Justice, fallen upon the infallible boundary,\n"
            + "Appear now as intangible destortion!\n"
            + "Return all to cinders, and come out from the abyss!\n"
            + "The ultimate attack magic!!!",//EXPLOSION
        
        //********************************************ARCHER SKILLS***************************************
        "Bring down!!!",//"Rain Of The Golden Strike",
        "Pierce through!!!",//"Lightning Rush",
        "Erase your way!!!",//WHITE NOVA
        "Annihilate the enemy!!!",//"Meteor Shot",
        "God Apollo, let your arrows fly!!!",//"Rays Of the Sun God",
        "As the contractor of the Tower of Babel, I command thee!!!"//"Gate Of The Infinite Weapons"//SPECIAL ATTACK
    };
    
    public String getSkillCatchPhrase(int phraseId){
        return this.playerSkillCatchPhrase[phraseId];
    }
}
