package com.coz.calabozopixeladodominicano.actors.hero;

final public class HeroClassFactory {
    public HeroClass makeHeroClass(final PlayerClassType TYPE){
        switch(TYPE){
            case WARRIOR:
                return new WarriorClass();
            case DUELIST:
                return new DuelistClass();
            case HUNTRESS:
                return new HuntressClass();
            case ROGUE:
                return new RogueClass();
            case MAGE:
                return new MageClass();
            default:
                assert false;
                return null;
        }
    }
}
