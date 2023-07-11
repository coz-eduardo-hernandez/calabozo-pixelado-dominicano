package com.coz.calabozopixeladodominicano.actors.hero;

import static com.coz.calabozopixeladodominicano.actors.hero.Talent.ADVENTURERS_INTUITION;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.AGGRESSIVE_BARRIER;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.DEADLY_FOLLOWUP;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.FOCUSED_MEAL;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.LETHAL_HASTE;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.PATIENT_STRIKE;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.PRECISE_ASSAULT;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.RESTORED_AGILITY;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.STRENGTHENING_MEAL;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.SWIFT_EQUIP;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.WEAPON_RECHARGING;

import com.coz.calabozopixeladodominicano.Assets;
import com.coz.calabozopixeladodominicano.Challenges;
import com.coz.calabozopixeladodominicano.Dungeon;
import com.coz.calabozopixeladodominicano.items.Item;
import com.coz.calabozopixeladodominicano.items.Waterskin;
import com.coz.calabozopixeladodominicano.items.food.Food;
import com.coz.calabozopixeladodominicano.items.potions.PotionOfStrength;
import com.coz.calabozopixeladodominicano.items.rings.RingOfAccuracy;
import com.coz.calabozopixeladodominicano.items.rings.RingOfArcana;
import com.coz.calabozopixeladodominicano.items.rings.RingOfFuror;
import com.coz.calabozopixeladodominicano.items.rings.RingOfHaste;
import com.coz.calabozopixeladodominicano.items.rings.RingOfMight;
import com.coz.calabozopixeladodominicano.items.scrolls.ScrollOfMirrorImage;
import com.coz.calabozopixeladodominicano.items.weapon.melee.Rapier;
import com.coz.calabozopixeladodominicano.messages.Messages;
import com.coz.calabozopixeladodominicano.sprites.ItemSpriteSheet;
import com.coz.calabozopixeladodominicano.ui.Icons;
import com.watabou.noosa.Image;
import com.watabou.utils.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

final class DuelistClass extends HeroClass {

    @Override
    public void initHero (Hero hero) {
        super.initHero(hero);

        hero.HP = hero.baseHT = hero.HT = 20;
        hero.attackSkill++;
        hero.defenseSkill++;


        Item i = new Food();
        if (!Challenges.isItemBlocked(i)) i.collect();

        (hero.belongings.weapon = new Rapier()).identify();
        hero.belongings.weapon.activate(hero);
        Dungeon.quickslot.setSlot(0, hero.belongings.weapon);
/*
		ThrowingSpike spikes = new ThrowingSpike();
		spikes.quantity(2).collect();


		Dungeon.quickslot.setSlot(0, spikes);
*/
        Waterskin waterskin = new Waterskin();
        waterskin.collect();
        Dungeon.quickslot.setSlot(1, waterskin);

        new PotionOfStrength().identify();
        new ScrollOfMirrorImage().identify();

        new RingOfAccuracy().identify();
        new RingOfMight().identify();
        new RingOfHaste().identify();
        new RingOfFuror().identify();
        new RingOfArcana().identify();

        hero.upgradeTalent(ADVENTURERS_INTUITION);
        hero.upgradeTalent(ADVENTURERS_INTUITION);
        //hero.upgradeTalent(Talent.PATIENT_STRIKE);
        hero.upgradeTalent(Talent.PRECISE_ASSAULT);
        //hero.upgradeTalent(Talent.LETHAL_MOMENTUM); //Warrior's
        //hero.upgradeTalent(Talent.LETHAL_MOMENTUM);
    }

    @Override
    public PlayerClassType getType(){
        return PlayerClassType.DUELIST;
    }

    @Override
    public void levelUp (Hero hero) {
        if ((hero.lvl - 1) % 3 == 0) {
            hero.updateHT(4, true);
        } else hero.updateHT(3, true);

        if (hero.lvl % 4 == 0) hero.STR++;

        switch (hero.lvl - 1 % 4) {
            case 4:
                hero.attackSkill++;
            case 1:
            case 2:
            case 3:
                hero.attackSkill++;
                break;
        }

        hero.defenseSkill++;
    }

    @Override
    public Icons getIcon () {
        return Icons.DUELIST;
    }

    @Override
    public String getName(){
        return "duelist";
    }

    @Override
    public int getAvatar(){
        return 5;
    }

    @Override
    public int getItemSprite(){
        return ItemSpriteSheet.RAPIER;
    }

    @Override
    public ArrayList<Talent> getTier1Talents(){
        return new ArrayList<>(Arrays.asList(STRENGTHENING_MEAL, ADVENTURERS_INTUITION,
                PATIENT_STRIKE, AGGRESSIVE_BARRIER));
    }

    @Override
    public ArrayList<Talent> getTier2Talents(){
        return new ArrayList<Talent>(Arrays.asList(FOCUSED_MEAL, RESTORED_AGILITY, WEAPON_RECHARGING, LETHAL_HASTE,
                SWIFT_EQUIP));
    }

    @Override
    public ArrayList<Talent> getTier3Talents(){
        return new ArrayList<Talent>(Arrays.asList(PRECISE_ASSAULT, DEADLY_FOLLOWUP));
    }

    @Override
    public ArrayList<Talent> getTier4Talents(){
        //TODO
        return null;
    }

    @Override
    public String title() {
        return Messages.get(HeroClass.class, "duelist");
    }

    @Override
    public String desc(){
        return Messages.get(HeroClass.class, "duelist_desc");
    }

    @Override
    public String shortDesc(){
        return Messages.get(HeroClass.class, "duelist_desc_short");
    }

    @Override
    public String spritesheet() {
        return Assets.Sprites.DUELIST;
    }

    @Override
    public String splashArt(){
        return Assets.Splashes.DUELIST;
    }

    @Override
    public boolean isUnlocked(){
        return true;
    }

    @Override
    public String unlockMsg() {
        return shortDesc() + "\n\n" + Messages.get(HeroClass.class, "duelist_unlock");
    }
}
