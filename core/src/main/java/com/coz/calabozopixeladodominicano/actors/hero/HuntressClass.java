package com.coz.calabozopixeladodominicano.actors.hero;

import static com.coz.calabozopixeladodominicano.actors.hero.Talent.DURABLE_PROJECTILES;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.FOLLOWUP_STRIKE;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.HEIGHTENED_SENSES;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.INVIGORATING_MEAL;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.NATURES_AID;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.NATURES_BOUNTY;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.POINT_BLANK;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.REJUVENATING_STEPS;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.RESTORED_NATURE;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.SEER_SHOT;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.SURVIVALISTS_INTUITION;

import com.coz.calabozopixeladodominicano.Assets;
import com.coz.calabozopixeladodominicano.Challenges;
import com.coz.calabozopixeladodominicano.Dungeon;
import com.coz.calabozopixeladodominicano.items.Item;
import com.coz.calabozopixeladodominicano.items.Waterskin;
import com.coz.calabozopixeladodominicano.items.bags.MagicalHolster;
import com.coz.calabozopixeladodominicano.items.bags.VelvetPouch;
import com.coz.calabozopixeladodominicano.items.food.Food;
import com.coz.calabozopixeladodominicano.items.potions.PotionOfMindVision;
import com.coz.calabozopixeladodominicano.items.scrolls.ScrollOfMirrorImage;
import com.coz.calabozopixeladodominicano.items.weapon.SpiritBow;
import com.coz.calabozopixeladodominicano.items.weapon.melee.Gloves;
import com.coz.calabozopixeladodominicano.messages.Messages;
import com.coz.calabozopixeladodominicano.sprites.ItemSpriteSheet;
import com.coz.calabozopixeladodominicano.ui.Icons;
import com.watabou.noosa.Image;

import java.util.ArrayList;
import java.util.Arrays;

public final class HuntressClass extends HeroClass {

    @Override public void initHero(Hero hero) {
        super.initHero(hero);

        hero.HP = hero.baseHT = hero.HT = 20;
        hero.attackSkill++;
        hero.defenseSkill++;

        new VelvetPouch().collect();
        Dungeon.LimitedDrops.VELVET_POUCH.drop();

        new MagicalHolster().collect();
        Dungeon.LimitedDrops.MAGICAL_HOLSTER.drop();

        Item i = new Food();
        if (!Challenges.isItemBlocked(i)) i.quantity(2).collect();

        (hero.belongings.weapon = new Gloves()).identify();
        SpiritBow bow = new SpiritBow();
        bow.identify().collect();

        Dungeon.quickslot.setSlot(0, bow);

        Waterskin waterskin = new Waterskin();
        waterskin.collect();
        waterskin.fill();
        Dungeon.quickslot.setSlot(1, waterskin);

        new PotionOfMindVision().identify();
        new ScrollOfMirrorImage().identify();

        hero.upgradeTalent(FOLLOWUP_STRIKE);
        //hero.upgradeTalent(Talent.FARSIGHT); T3 Sniper
    }

    @Override
    public void levelUp(Hero hero) {
        hero.updateHT( 3, true );

        if (hero.lvl % 5 == 0) hero.STR++;

        hero.attackSkill++;

        if (hero.lvl % 4 != 0) hero.defenseSkill++;
    }

    @Override
    public Icons getIcon(){
        return Icons.DUELIST;
    }

    //TODO: actually better to replace this with an enum?
    @Override
    public String getName(){
        return "huntress";
    }

    @Override
    public int getAvatar(){
        return 4;
    }

    @Override
    public int getItemSprite(){
        return ItemSpriteSheet.SPIRIT_BOW;
    }

    @Override
    public ArrayList<Talent> getTier1Talents(){
        return new ArrayList<>(Arrays.asList(NATURES_BOUNTY, SURVIVALISTS_INTUITION, FOLLOWUP_STRIKE, NATURES_AID));
    }

    @Override
    public ArrayList<Talent> getTier2Talents(){
        return new ArrayList<>(Arrays.asList(INVIGORATING_MEAL, RESTORED_NATURE, REJUVENATING_STEPS, HEIGHTENED_SENSES,
                DURABLE_PROJECTILES));
    }

    @Override
    public ArrayList<Talent> getTier3Talents(){
        return new ArrayList<>(Arrays.asList(POINT_BLANK, SEER_SHOT));
    }

    @Override
    public ArrayList<Talent> getTier4Talents(){
        //TODO
        return null;
    }

    @Override
    public String title() {
        return Messages.get(HeroClass.class, "huntress");
    }

    @Override
    public String desc(){
        return Messages.get(HeroClass.class, "huntress_desc");
    }

    @Override
    public String shortDesc(){
        return Messages.get(HeroClass.class, "huntress_desc_short");
    }

    @Override
    public String spritesheet() {
        return Assets.Sprites.HUNTRESS;
    }

    @Override
    public String splashArt(){
        return Assets.Splashes.HUNTRESS;
    }

    @Override
    public boolean isUnlocked(){
        return true;
    }

    @Override
    public String unlockMsg() {
        return shortDesc() + "\n\n" + Messages.get(HeroClass.class, "huntress_unlock");
    }
}
