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
import com.coz.calabozopixeladodominicano.actors.hero.abilities.duelist.Challenge;
import com.coz.calabozopixeladodominicano.actors.hero.abilities.duelist.ElementalStrike;
import com.coz.calabozopixeladodominicano.actors.hero.abilities.duelist.Feint;
import com.coz.calabozopixeladodominicano.actors.hero.abilities.huntress.NaturesPower;
import com.coz.calabozopixeladodominicano.actors.hero.abilities.huntress.SpectralBlades;
import com.coz.calabozopixeladodominicano.actors.hero.abilities.huntress.SpiritHawk;
import com.coz.calabozopixeladodominicano.actors.hero.abilities.mage.ElementalBlast;
import com.coz.calabozopixeladodominicano.actors.hero.abilities.mage.WarpBeacon;
import com.coz.calabozopixeladodominicano.actors.hero.abilities.mage.WildMagic;
import com.coz.calabozopixeladodominicano.actors.hero.abilities.rogue.DeathMark;
import com.coz.calabozopixeladodominicano.actors.hero.abilities.rogue.ShadowClone;
import com.coz.calabozopixeladodominicano.actors.hero.abilities.rogue.SmokeBomb;
import com.coz.calabozopixeladodominicano.actors.hero.abilities.warrior.Endure;
import com.coz.calabozopixeladodominicano.actors.hero.abilities.warrior.HeroicLeap;
import com.coz.calabozopixeladodominicano.actors.hero.abilities.warrior.Shockwave;
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
import com.watabou.utils.DeviceCompat;

public enum HeroClass {
	WARRIOR,
	MAGE,
	ROGUE,
	HUNTRESS,
	DUELIST;
/*
	WARRIOR( HeroSubClass.BERSERKER, HeroSubClass.GLADIATOR ),
	MAGE( HeroSubClass.BATTLEMAGE, HeroSubClass.WARLOCK ),
	ROGUE( HeroSubClass.ASSASSIN, HeroSubClass.FREERUNNER ),
	HUNTRESS( HeroSubClass.SNIPER, HeroSubClass.WARDEN ),
	DUELIST( HeroSubClass.CHAMPION, HeroSubClass.MONK );

	private HeroSubClass[] subClasses;

	HeroClass( HeroSubClass...subClasses ) {
		this.subClasses = subClasses;
	}
*/
	public void initHero( Hero hero ) {

		hero.heroClass = this;
		Talent.initClassTalents(hero);

		Item i = new ClothArmor().identify();
		if (!Challenges.isItemBlocked(i)) hero.belongings.armor = (ClothArmor)i;

		switch (this) {
			case WARRIOR:
				initWarrior( hero );
				break;

			case MAGE:
				initMage( hero );
				break;

			case ROGUE:
				initRogue( hero );
				break;

			case HUNTRESS:
				initHuntress( hero );
				break;

			case DUELIST:
				initDuelist( hero );
				break;
		}

		if (SPDSettings.quickslotWaterskin()) {
			for (int s = 0; s < QuickSlot.SIZE; s++) {
				if (Dungeon.quickslot.getItem(s) == null) {
					Dungeon.quickslot.setSlot(s, waterskin);
					break;
				}
			}
		}

	}
/*
	public Badges.Badge masteryBadge() {
		switch (this) {
			case WARRIOR:
				return Badges.Badge.MASTERY_WARRIOR;
			case MAGE:
				return Badges.Badge.MASTERY_MAGE;
			case ROGUE:
				return Badges.Badge.MASTERY_ROGUE;
			case HUNTRESS:
				return Badges.Badge.MASTERY_HUNTRESS;
			case DUELIST:
				return Badges.Badge.MASTERY_DUELIST;
		}
		return null;
	}*/

	private static void initWarrior( Hero hero ) {
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

		Waterskin waterskin = new Waterskin();
		waterskin.collect();
		Dungeon.quickslot.setSlot(1, waterskin);

		Dungeon.gold = 99;
		//hero.belongings.misc.
		//new Gold().quantity(99).collect();

		i = new ThrowingStone();
		i.quantity(3).collect();
		Dungeon.quickslot.setSlot(0, i);

		Waterskin waterskin = new Waterskin();
		waterskin.collect();
		Dungeon.quickslot.setSlot(1, waterskin);

		Dungeon.gold = 99;

		if (hero.belongings.armor != null){
			hero.belongings.armor.affixSeal(new BrokenSeal());
		}

		new PotionOfHealing().identify();
		new PotionOfStrength().identify();
		//new ScrollOfRage().identify();

		hero.upgradeTalent(Talent.HEARTY_MEAL);
		hero.upgradeTalent(Talent.HEARTY_MEAL);
		hero.upgradeTalent(Talent.VETERANS_INTUITION);
		//hero.upgradeTalent(Talent.IRON_WILL);
		//hero.upgradeTalent(Talent.IRON_WILL);
		hero.upgradeTalent(Talent.RUNIC_TRANSFERENCE);
		hero.upgradeTalent(Talent.RUNIC_TRANSFERENCE);
		hero.upgradeTalent(Talent.HOLD_FAST);
		//hero.upgradeTalent(Talent.PATIENT_STRIKE);
		//hero.upgradeTalent(Talent.PATIENT_STRIKE);
	}

	private static void initDuelist( Hero hero ) {
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

		hero.upgradeTalent(Talent.ADVENTURERS_INTUITION);
		hero.upgradeTalent(Talent.ADVENTURERS_INTUITION);
		//hero.upgradeTalent(Talent.PATIENT_STRIKE);
		hero.upgradeTalent(Talent.PRECISE_ASSAULT);
		//hero.upgradeTalent(Talent.LETHAL_MOMENTUM); //Warrior's
		//hero.upgradeTalent(Talent.LETHAL_MOMENTUM);
	}

	private static void initHuntress( Hero hero ) {
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

		hero.upgradeTalent(Talent.FOLLOWUP_STRIKE);
		//hero.upgradeTalent(Talent.FARSIGHT); T3 Sniper
	}

	private static void initRogue( Hero hero ) {
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

		hero.upgradeTalent(Talent.SUCKER_PUNCH);
		hero.upgradeTalent(Talent.SUCKER_PUNCH);
		hero.upgradeTalent(Talent.SILENT_STEPS);
		hero.upgradeTalent(Talent.SILENT_STEPS);
	}

	private static void initMage( Hero hero ) {
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
		hero.upgradeTalent(Talent.SCHOLARS_INTUITION);
		hero.upgradeTalent(Talent.SCHOLARS_INTUITION);
	}

	public String title() {
		return Messages.get(HeroClass.class, name());
	}

	public String desc(){
		return Messages.get(HeroClass.class, name()+"_desc");
	}

	public String shortDesc(){
		return Messages.get(HeroClass.class, name()+"_desc_short");
	}

	/*
	public ArmorAbility[] armorAbilities(){
		switch (this) {
			case WARRIOR: default:
				return new ArmorAbility[]{new HeroicLeap(), new Shockwave(), new Endure()};
			case MAGE:
				return new ArmorAbility[]{new ElementalBlast(), new WildMagic(), new WarpBeacon()};
			case ROGUE:
				return new ArmorAbility[]{new SmokeBomb(), new DeathMark(), new ShadowClone()};
			case HUNTRESS:
				return new ArmorAbility[]{new SpectralBlades(), new NaturesPower(), new SpiritHawk()};
			case DUELIST:
				return new ArmorAbility[]{new Challenge(), new ElementalStrike(), new Feint()};
		}
	}*/

	public String spritesheet() {
		switch (this) {
			case WARRIOR: default:
				return Assets.Sprites.WARRIOR;
			case MAGE:
				return Assets.Sprites.MAGE;
			case ROGUE:
				return Assets.Sprites.ROGUE;
			case HUNTRESS:
				return Assets.Sprites.HUNTRESS;
			case DUELIST:
				return Assets.Sprites.DUELIST;
		}
	}

	public String splashArt(){
		switch (this) {
			case WARRIOR: default:
				return Assets.Splashes.WARRIOR;
			case MAGE:
				return Assets.Splashes.MAGE;
			case ROGUE:
				return Assets.Splashes.ROGUE;
			case HUNTRESS:
				return Assets.Splashes.HUNTRESS;
			case DUELIST:
				return Assets.Splashes.DUELIST;
		}
	}

	public boolean isUnlocked(){
		//always unlock on debug builds
		if (DeviceCompat.isDebug()) return true;

		return true;
		/*
		switch (this){
			case WARRIOR: default:
				return true;
			case MAGE:
				return Badges.isUnlocked(Badges.Badge.UNLOCK_MAGE);
			case ROGUE:
				return Badges.isUnlocked(Badges.Badge.UNLOCK_ROGUE);
			case HUNTRESS:
				return Badges.isUnlocked(Badges.Badge.UNLOCK_HUNTRESS);
			case DUELIST:
				return Badges.isUnlocked(Badges.Badge.UNLOCK_DUELIST);
		}*/
	}
	
	public String unlockMsg() {
		return shortDesc() + "\n\n" + Messages.get(HeroClass.class, name()+"_unlock");
	}

}
