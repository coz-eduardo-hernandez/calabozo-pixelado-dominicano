package com.coz.calabozopixeladodominicano.actors.hero;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HeroClassFactoryUTests {
    HeroClassFactory factory;

    @BeforeEach
    void setUp () {
         factory = new HeroClassFactory();
    }

    @AfterEach
    void tearDown () {
    }

    @Test
    void make_warrior_class () {
        HeroClass hero_class = factory.makeHeroClass(PlayerClassType.WARRIOR);
        assertInstanceOf(WarriorClass.class, hero_class);
    }

    @Test
    void make_duelist_class () {
        HeroClass hero_class = factory.makeHeroClass(PlayerClassType.DUELIST);
        assertInstanceOf(DuelistClass.class, hero_class);
    }

    @Test
    void make_huntress_class () {
        HeroClass hero_class = factory.makeHeroClass(PlayerClassType.HUNTRESS);
        assertInstanceOf(HuntressClass.class, hero_class);
    }

    @Test
    void make_rogue_class () {
        HeroClass hero_class = factory.makeHeroClass(PlayerClassType.ROGUE);
        assertInstanceOf(RogueClass.class, hero_class);
    }

    @Test
    void make_mage_class () {
        HeroClass hero_class = factory.makeHeroClass(PlayerClassType.MAGE);
        assertInstanceOf(MageClass.class, hero_class);
    }
}
