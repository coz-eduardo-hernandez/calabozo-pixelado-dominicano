/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2023 Evan Debenham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.coz.calabozopixeladodominicano.actors.hero;

import com.coz.calabozopixeladodominicano.Assets;
import com.coz.calabozopixeladodominicano.Badges;
import com.coz.calabozopixeladodominicano.Challenges;
import com.coz.calabozopixeladodominicano.Dungeon;
import com.coz.calabozopixeladodominicano.QuickSlot;
import com.coz.calabozopixeladodominicano.SPDSettings;
import com.coz.calabozopixeladodominicano.actors.hero.abilities.ArmorAbility;
import com.coz.calabozopixeladodominicano.actors.hero.abilities.duelist.ElementalStrike;
import com.coz.calabozopixeladodominicano.actors.hero.abilities.huntress.NaturesPower;
import com.coz.calabozopixeladodominicano.actors.hero.abilities.huntress.SpectralBlades;
import com.coz.calabozopixeladodominicano.actors.hero.abilities.huntress.SpiritHawk;
import com.coz.calabozopixeladodominicano.actors.hero.abilities.mage.ElementalBlast;
import com.coz.calabozopixeladodominicano.actors.hero.abilities.mage.WarpBeacon;
import com.coz.calabozopixeladodominicano.actors.hero.abilities.mage.WildMagic;
import com.coz.calabozopixeladodominicano.actors.hero.abilities.rogue.DeathMark;
import com.coz.calabozopixeladodominicano.actors.hero.abilities.rogue.ShadowClone;
import com.coz.calabozopixeladodominicano.actors.hero.abilities.warrior.Endure;
import com.coz.calabozopixeladodominicano.items.BrokenSeal;
import com.coz.calabozopixeladodominicano.items.Gold;
import com.coz.calabozopixeladodominicano.items.Item;
import com.coz.calabozopixeladodominicano.items.Waterskin;
import com.coz.calabozopixeladodominicano.items.armor.ClothArmor;
import com.coz.calabozopixeladodominicano.items.artifacts.CloakOfShadows;
import com.coz.calabozopixeladodominicano.items.bags.ScrollHolder;
import com.coz.calabozopixeladodominicano.items.bags.VelvetPouch;
import com.coz.calabozopixeladodominicano.items.bags.PotionBandolier;
import com.coz.calabozopixeladodominicano.items.bags.MagicalHolster;
//import com.coz.calabozopixeladodominicano.items.bags.ScrollHolder;
import com.coz.calabozopixeladodominicano.items.bombs.Bomb;
import com.coz.calabozopixeladodominicano.items.food.SmallRation;
import com.coz.calabozopixeladodominicano.items.food.Food;
import com.coz.calabozopixeladodominicano.items.potions.PotionOfHaste;
import com.coz.calabozopixeladodominicano.items.potions.PotionOfHealing;
import com.coz.calabozopixeladodominicano.items.potions.PotionOfInvisibility;
import com.coz.calabozopixeladodominicano.items.potions.PotionOfLiquidFlame;
import com.coz.calabozopixeladodominicano.items.potions.PotionOfMindVision;
import com.coz.calabozopixeladodominicano.items.potions.PotionOfStrength;
import com.coz.calabozopixeladodominicano.items.potions.PotionOfToxicGas;
import com.coz.calabozopixeladodominicano.items.potions.exotic.PotionOfShroudingFog;
import com.coz.calabozopixeladodominicano.items.rings.RingOfAccuracy;
import com.coz.calabozopixeladodominicano.items.rings.RingOfArcana;
import com.coz.calabozopixeladodominicano.items.rings.RingOfFuror;
import com.coz.calabozopixeladodominicano.items.rings.RingOfHaste;
import com.coz.calabozopixeladodominicano.items.rings.RingOfMight;
import com.coz.calabozopixeladodominicano.items.scrolls.ScrollOfIdentify;
import com.coz.calabozopixeladodominicano.items.scrolls.ScrollOfLullaby;
import com.coz.calabozopixeladodominicano.items.scrolls.ScrollOfMagicMapping;
import com.coz.calabozopixeladodominicano.items.scrolls.ScrollOfMirrorImage;
//import com.coz.calabozopixeladodominicano.items.scrolls.ScrollOfRage;
import com.coz.calabozopixeladodominicano.items.scrolls.ScrollOfUpgrade;
import com.coz.calabozopixeladodominicano.items.wands.WandOfMagicMissile;
import com.coz.calabozopixeladodominicano.items.weapon.SpiritBow;
import com.coz.calabozopixeladodominicano.items.weapon.melee.Dagger;
import com.coz.calabozopixeladodominicano.items.weapon.melee.Gloves;
import com.coz.calabozopixeladodominicano.items.weapon.melee.MagesStaff;
import com.coz.calabozopixeladodominicano.items.weapon.melee.Rapier;
import com.coz.calabozopixeladodominicano.items.weapon.melee.WornShortsword;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.ThrowingKnife;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.ThrowingSpike;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.ThrowingStone;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.darts.Dart;
import com.coz.calabozopixeladodominicano.messages.Messages;
import com.coz.calabozopixeladodominicano.ui.Icons;
import com.watabou.noosa.Image;
import com.watabou.utils.Bundle;
import com.watabou.utils.DeviceCompat;
import com.watabou.utils.Bundlable;

import java.util.ArrayList;

public abstract class HeroClass implements Bundlable{
	public final static HeroClass WARRIOR = new WarriorClass();
	public final static HeroClass DUELIST = new DuelistClass();
	public final static HeroClass HUNTRESS = new HuntressClass();
	public final static HeroClass ROGUE = new RogueClass();
	public final static HeroClass MAGE = new MageClass();

	private final static HeroClass[] classes = new HeroClass[]{HeroClass.WARRIOR,HeroClass.DUELIST,HeroClass.HUNTRESS,
			HeroClass.ROGUE, HeroClass.MAGE};

	public final static HeroClass[] getClasses(){
		return classes;
	}

	public void initHero(Hero hero) {
		hero.heroClass = this;
		Talent.initClassTalents(hero);

		Item i = new ClothArmor().identify();
		if (!Challenges.isItemBlocked(i)) hero.belongings.armor = (ClothArmor) i;
	}

	public abstract void levelUp(Hero hero);

	public abstract Icons getIcon();

	public abstract String getName();

	public abstract int getAvatar();

	public abstract int getItemSprite();

	public abstract ArrayList<Talent> getTier1Talents();
	public abstract ArrayList<Talent> getTier2Talents();
	public abstract ArrayList<Talent> getTier3Talents();
	public abstract ArrayList<Talent> getTier4Talents();

	public abstract String title();

	public abstract String desc();

	public abstract String shortDesc();

	public abstract String spritesheet();

	public abstract String splashArt();

	public abstract boolean isUnlocked();
	/*{
		//always unlock on debug builds
		if (DeviceCompat.isDebug()) return true;

		return false;
	}*/

	public abstract String unlockMsg();

	@Override
	public final void storeInBundle (Bundle bundle){
	}

	@Override
	public final void restoreFromBundle( Bundle bundle ) {
/*		String class = bundle.getString( CLASS );
		switch(class)
		{
			case "warrior":

		}*/
	}
}
