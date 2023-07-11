package com.coz.calabozopixeladodominicano.actors.hero;

import static com.coz.calabozopixeladodominicano.actors.hero.Talent.CACHED_RATIONS;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.ENHANCED_RINGS;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.LIGHT_CLOAK;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.MYSTICAL_MEAL;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.MYSTICAL_UPGRADE;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.PROTECTIVE_SHADOWS;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.ROGUES_FORESIGHT;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.SILENT_STEPS;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.SUCKER_PUNCH;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.THIEFS_INTUITION;
import static com.coz.calabozopixeladodominicano.actors.hero.Talent.WIDE_SEARCH;

import com.coz.calabozopixeladodominicano.Assets;
import com.coz.calabozopixeladodominicano.Challenges;
import com.coz.calabozopixeladodominicano.Dungeon;
import com.coz.calabozopixeladodominicano.items.Item;
import com.coz.calabozopixeladodominicano.items.bombs.Bomb;
import com.coz.calabozopixeladodominicano.items.food.Food;
import com.coz.calabozopixeladodominicano.items.potions.PotionOfHaste;
import com.coz.calabozopixeladodominicano.items.potions.PotionOfInvisibility;
import com.coz.calabozopixeladodominicano.items.potions.exotic.PotionOfShroudingFog;
import com.coz.calabozopixeladodominicano.items.scrolls.ScrollOfMagicMapping;
import com.coz.calabozopixeladodominicano.items.weapon.melee.Dagger;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.darts.Dart;
import com.coz.calabozopixeladodominicano.messages.Messages;
import com.coz.calabozopixeladodominicano.sprites.ItemSpriteSheet;
import com.coz.calabozopixeladodominicano.ui.Icons;
import com.watabou.noosa.Image;
import com.watabou.utils.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

final class RogueClass extends HeroClass {

    @Override public void initHero(Hero hero) {
        super.initHero(hero);

        hero.HP = hero.baseHT = hero.HT = 20;
        hero.attackSkill++;
        hero.defenseSkill++;
        (hero.belongings.weapon = new Dagger()).identify();

        hero.belongings.backpack.capacity = 15;

        Item i = new Food();
        if (!Challenges.isItemBlocked(i)) i.collect();

/*		CloakOfShadows cloak = new CloakOfShadows();
		(hero.belongings.artifact = cloak).identify();
		hero.belongings.artifact.activate( hero );
		Dungeon.quickslot.setSlot(0, cloak);

		ThrowingKnife knives = new ThrowingKnife();
		knives.quantity(3).collect();
*/
        i = new Dart();
        i.quantity(5).collect();
        Dungeon.quickslot.setSlot(0, i);

        i = new ScrollOfMagicMapping();
        i.identify();
        i.collect();

        new Bomb().collect();

        new PotionOfInvisibility().identify();
        new PotionOfHaste().identify();

        i = new PotionOfShroudingFog();
        i.collect();

        hero.upgradeTalent(SUCKER_PUNCH);
        hero.upgradeTalent(SUCKER_PUNCH);
        hero.upgradeTalent(SILENT_STEPS);
        hero.upgradeTalent(SILENT_STEPS);
    }

    @Override
    public PlayerClassType getType(){
        return PlayerClassType.ROGUE;
    }

    @Override
    public void levelUp(Hero hero) {
        if ((hero.lvl - 1) % 3 == 1){
            hero.updateHT( 3, true );
        }
        else hero.updateHT( 4, true );

        if (hero.lvl % 4 == 0) hero.STR++;

        hero.attackSkill++;

        switch(hero.lvl - 1 % 4){
            case 4:
                hero.defenseSkill++;
            case 1:
            case 2:
            case 3:
                hero.defenseSkill++;
                break;
        }
    }

    @Override
    public Icons getIcon(){
        return Icons.ROGUE;
    }

    @Override
    public String getName(){
        return "rogue";
    }

    @Override
    public int getAvatar(){
        return 3;
    }

    @Override
    public int getItemSprite(){
        return ItemSpriteSheet.ARTIFACT_CLOAK;
    }

    @Override
    public ArrayList<Talent> getTier1Talents(){
        return new ArrayList<>(Arrays.asList(CACHED_RATIONS, THIEFS_INTUITION, SUCKER_PUNCH, PROTECTIVE_SHADOWS));
    }

    @Override
    public ArrayList<Talent> getTier2Talents(){
        return new ArrayList<>(Arrays.asList(MYSTICAL_MEAL, MYSTICAL_UPGRADE, WIDE_SEARCH, SILENT_STEPS,
                ROGUES_FORESIGHT));
    }

    @Override
    public ArrayList<Talent> getTier3Talents(){
        return new ArrayList<>(Arrays.asList(ENHANCED_RINGS, LIGHT_CLOAK));
    }

    @Override
    public ArrayList<Talent> getTier4Talents(){
        //TODO
        return null;
    }

    @Override
    public String title() {
        return Messages.get(HeroClass.class, "rogue");
    }

    @Override
    public String desc(){
        return Messages.get(HeroClass.class, "rogue_desc");
    }

    @Override
    public String shortDesc(){
        return Messages.get(HeroClass.class, "rogue_desc_short");
    }

    @Override
    public String spritesheet() {
        return Assets.Sprites.ROGUE;
    }

    @Override
    public String splashArt(){
        return Assets.Splashes.ROGUE;
    }

    @Override
    public boolean isUnlocked(){
        return true;
    }

    @Override
    public String unlockMsg() {
        return shortDesc() + "\n\n" + Messages.get(HeroClass.class, "rogue_unlock");
    }
}
