package com.coz.calabozopixeladodominicano.actors.hero;

import static com.coz.calabozopixeladodominicano.actors.hero.Talent.ALLY_WARP;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.ARCANE_VISION;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.BACKUP_BARRIER;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.EMPOWERING_MEAL;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.EMPOWERING_SCROLLS;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.ENERGIZING_MEAL;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.ENERGIZING_UPGRADE;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.SCHOLARS_INTUITION;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.SHIELD_BATTERY;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.TESTED_HYPOTHESIS;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.WAND_PRESERVATION;

import com.coz.calabozopixeladodominicano.Assets;
import com.coz.calabozopixeladodominicano.Challenges;
import com.coz.calabozopixeladodominicano.Dungeon;
import com.coz.calabozopixeladodominicano.items.Item;
import com.coz.calabozopixeladodominicano.items.Waterskin;
import com.coz.calabozopixeladodominicano.items.bags.PotionBandolier;
import com.coz.calabozopixeladodominicano.items.bags.ScrollHolder;
import com.coz.calabozopixeladodominicano.items.food.Food;
import com.coz.calabozopixeladodominicano.items.potions.PotionOfHealing;
import com.coz.calabozopixeladodominicano.items.potions.PotionOfLiquidFlame;
import com.coz.calabozopixeladodominicano.items.scrolls.ScrollOfIdentify;
import com.coz.calabozopixeladodominicano.items.wands.WandOfMagicMissile;
import com.coz.calabozopixeladodominicano.items.weapon.melee.MagesStaff;
import com.coz.calabozopixeladodominicano.messages.Messages;
import com.coz.calabozopixeladodominicano.sprites.ItemSpriteSheet;
import com.coz.calabozopixeladodominicano.ui.Icons;
import com.watabou.noosa.Image;
import com.watabou.utils.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

final class MageClass extends HeroClass{

    @Override public void initHero(Hero hero) {
        super.initHero(hero);

        hero.HP = hero.baseHT = hero.HT = 15;
        hero.STR--;
        hero.attackSkill--;
        hero.defenseSkill--;

        new ScrollHolder().collect();
        Dungeon.LimitedDrops.SCROLL_HOLDER.drop();
        new PotionBandolier().collect();
        Dungeon.LimitedDrops.POTION_BANDOLIER.drop();

        Item i = new Food();
        if (!Challenges.isItemBlocked(i)) i.collect();

        MagesStaff staff;
        staff = new MagesStaff(new WandOfMagicMissile());

        (hero.belongings.weapon = staff).identify();
        hero.belongings.weapon.activate(hero);

        Dungeon.quickslot.setSlot(0, staff);

        Waterskin waterskin = new Waterskin();
        waterskin.collect();
        Dungeon.quickslot.setSlot(1, waterskin);

        i = new ScrollOfIdentify();
        i.identify();
        i.collect();

        i = new PotionOfHealing();
        i.identify();
        i.collect();

        i = new PotionOfLiquidFlame();
        i.identify();
        i.collect();

        //new ScrollOfUpgrade().identify();
        //new PotionOfLiquidFlame().identify();
        hero.upgradeTalent(SCHOLARS_INTUITION);
        hero.upgradeTalent(SCHOLARS_INTUITION);

    }

    @Override
    public PlayerClassType getType(){
        return PlayerClassType.MAGE;
    }

    @Override
    public void levelUp(Hero hero) {
        if ((hero.lvl - 1) % 2 == 0){
            hero.updateHT( 3, true );
        }
        else hero.updateHT( 2, true );

        if (hero.lvl % 7 == 0) hero.STR++;

        if (hero.lvl - 1 % 2 == 0) hero.attackSkill++;

        if (hero.lvl % 2 == 0) hero.defenseSkill++;
    }

    @Override
    public Icons getIcon(){
        return Icons.MAGE;
    }

    @Override
    public String getName(){
        return "mage";
    }

    @Override
    public int getAvatar(){
        return 2;
    }

    @Override
    public int getItemSprite(){
        return ItemSpriteSheet.MAGES_STAFF;
    }

    @Override
    public ArrayList<Talent> getTier1Talents(){
        return new ArrayList<>(Arrays.asList(EMPOWERING_MEAL, SCHOLARS_INTUITION, TESTED_HYPOTHESIS, BACKUP_BARRIER));
    }

    @Override
    public ArrayList<Talent> getTier2Talents(){
        return new ArrayList<>(Arrays.asList(ENERGIZING_MEAL, ENERGIZING_UPGRADE, WAND_PRESERVATION, ARCANE_VISION,
                SHIELD_BATTERY));
    }

    @Override
    public ArrayList<Talent> getTier3Talents(){
        return new ArrayList<>(Arrays.asList(EMPOWERING_SCROLLS, ALLY_WARP));
    }

    @Override
    public ArrayList<Talent> getTier4Talents(){
        //TODO
        return null;
    }

    @Override
    public String title() {
        return Messages.get(HeroClass.class, "mage");
    }

    @Override
    public String desc(){
        return Messages.get(HeroClass.class, "mage_desc");
    }

    @Override
    public String shortDesc(){
        return Messages.get(HeroClass.class, "mage_desc_short");
    }

    @Override
    public String spritesheet() {
        return Assets.Sprites.MAGE;
    }

    @Override
    public String splashArt(){
        return Assets.Splashes.MAGE;
    }

    @Override
    public boolean isUnlocked(){
        return true;
    }

    @Override
    public String unlockMsg() {
        return shortDesc() + "\n\n" + Messages.get(HeroClass.class, "mage_unlock");
    }
}
