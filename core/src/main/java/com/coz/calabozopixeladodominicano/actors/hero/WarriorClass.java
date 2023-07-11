package com.coz.calabozopixeladodominicano.actors.hero;

import static com.coz.calabozopixeladodominicano.actors.hero.Talent.HEARTY_MEAL;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.HOLD_FAST;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.IMPROVISED_PROJECTILES;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.IRON_STOMACH;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.IRON_WILL;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.LETHAL_MOMENTUM;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.RESTORED_WILLPOWER;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.RUNIC_TRANSFERENCE;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.STRONGMAN;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.TEST_SUBJECT;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.VETERANS_INTUITION;

import com.coz.calabozopixeladodominicano.Assets;
import com.coz.calabozopixeladodominicano.Challenges;
import com.coz.calabozopixeladodominicano.Dungeon;
import com.coz.calabozopixeladodominicano.items.BrokenSeal;
import com.coz.calabozopixeladodominicano.items.Item;
import com.coz.calabozopixeladodominicano.items.Waterskin;
import com.coz.calabozopixeladodominicano.items.bags.PotionBandolier;
import com.coz.calabozopixeladodominicano.items.food.SmallRation;
import com.coz.calabozopixeladodominicano.items.potions.PotionOfHealing;
import com.coz.calabozopixeladodominicano.items.potions.PotionOfStrength;
import com.coz.calabozopixeladodominicano.items.weapon.melee.WornShortsword;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.ThrowingStone;
import com.coz.calabozopixeladodominicano.messages.Messages;
import com.coz.calabozopixeladodominicano.sprites.ItemSpriteSheet;
import com.coz.calabozopixeladodominicano.ui.Icons;
import com.watabou.noosa.Image;
import com.watabou.utils.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

final class WarriorClass extends HeroClass {

    @Override
    public void initHero (Hero hero) {
        super.initHero(hero);

        hero.HP = hero.baseHT = hero.HT = 25;
        hero.STR++;

        new PotionBandolier().collect();
        Dungeon.LimitedDrops.POTION_BANDOLIER.drop();

        Item i = new SmallRation();
        if (!Challenges.isItemBlocked(i)) i.quantity(3).collect();

        (hero.belongings.weapon = new WornShortsword()).identify();

        i = new ThrowingStone();
        i.quantity(3).collect();
        Dungeon.quickslot.setSlot(0, i);

        Dungeon.gold = 99;

        i = new ThrowingStone();
        i.quantity(3).collect();
        Dungeon.quickslot.setSlot(0, i);

        Waterskin waterskin = new Waterskin();
        waterskin.collect();
        Dungeon.quickslot.setSlot(1, waterskin);

        if (hero.belongings.armor != null) {
            hero.belongings.armor.affixSeal(new BrokenSeal());
        }

        new PotionOfHealing().identify();
        new PotionOfStrength().identify();
        //new ScrollOfRage().identify();

        hero.upgradeTalent(HEARTY_MEAL);
        hero.upgradeTalent(HEARTY_MEAL);
        hero.upgradeTalent(VETERANS_INTUITION);
        //hero.upgradeTalent(Talent.IRON_WILL);
        //hero.upgradeTalent(Talent.IRON_WILL);
        hero.upgradeTalent(RUNIC_TRANSFERENCE);
        hero.upgradeTalent(RUNIC_TRANSFERENCE);
        hero.upgradeTalent(HOLD_FAST);
        //hero.upgradeTalent(Talent.PATIENT_STRIKE);
        //hero.upgradeTalent(Talent.PATIENT_STRIKE);
    }

    @Override
    public PlayerClassType getType(){
        return PlayerClassType.WARRIOR;
    }

    @Override
    public void levelUp(Hero hero) {
        hero.updateHT( 5, true );

        if (hero.lvl % 3 == 0) hero.STR++;

        switch(hero.lvl - 1 % 4){
            case 1:
                hero.attackSkill++;
                break;
            case 2:
                hero.defenseSkill++;
                break;
            case 3:
            case 4:
                hero.attackSkill++;
                hero.defenseSkill++;
                break;
        }
    }

    @Override
    public Icons getIcon(){
        return Icons.WARRIOR;
    }

    @Override
    public String getName(){
        return "warrior";
    }

    @Override
    public int getAvatar(){
        return 1;
    }

    @Override
    public int getItemSprite(){
       return ItemSpriteSheet.SEAL;
    }
    @Override
    public ArrayList<Talent> getTier1Talents(){
        return new ArrayList<>(Arrays.asList(HEARTY_MEAL, VETERANS_INTUITION, TEST_SUBJECT, IRON_WILL));
    }

    @Override
    public ArrayList<Talent> getTier2Talents(){
        return new ArrayList<>(Arrays.asList(IRON_STOMACH, RESTORED_WILLPOWER, RUNIC_TRANSFERENCE, LETHAL_MOMENTUM,
                IMPROVISED_PROJECTILES));
    }

    @Override
    public ArrayList<Talent> getTier3Talents(){
        return new ArrayList<>(Arrays.asList(HOLD_FAST, STRONGMAN));
    }

    @Override
    public ArrayList<Talent> getTier4Talents(){
        //TODO
        return null;
    }

    @Override
    public String title () {
        return Messages.get(HeroClass.class, "warrior");
    }

    @Override
    public String desc () {
        return Messages.get(HeroClass.class, "warrior_desc");
    }

    @Override
    public String shortDesc () {
        return Messages.get(HeroClass.class, "warrior_desc_short");
    }

    @Override
    public String spritesheet () {
        return Assets.Sprites.WARRIOR;
    }

    @Override
    public String splashArt () {
        return Assets.Splashes.WARRIOR;
    }

    @Override
    public boolean isUnlocked () {
        return true;
    }

    @Override
    public String unlockMsg () {
        return shortDesc() + "\n\n" + Messages.get(HeroClass.class, "warrior_unlock");
    }
}
