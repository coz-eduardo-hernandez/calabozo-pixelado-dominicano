package com.coz.calabozopixeladodominicano.actors.hero;

/**
 * Fábrica para las clases del jugador que retorna la clase base
 */
final public class HeroClassFactory {

    /**
     * Crea la clase del jugador especificada
     * @param TYPE  la clase del jugador solicitada
     * @return  instancia del tipo solicitado, pero con tipo de la clase base
     */
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
