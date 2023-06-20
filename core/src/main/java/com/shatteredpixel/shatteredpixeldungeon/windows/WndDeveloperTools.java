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

package com.shatteredpixel.shatteredpixeldungeon.windows;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.ShatteredPixelDungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Actor;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Belongings;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.HeroAction;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Acidic;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Albino;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.ArmoredBrute;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.ArmoredStatue;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Bandit;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Bat;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Bee;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Bestiary;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Brute;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.CausticSlime;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Crab;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.CrystalMimic;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.DM100;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.DM200;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.DM201;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.DM300;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.DemonSpawner;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.DwarfKing;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Elemental;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Eye;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.FetidRat;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Ghoul;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Gnoll;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.GnollTrickster;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.GoldenMimic;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Golem;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Goo;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.GreatCrab;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Guard;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Mimic;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Mob;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Monk;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Necromancer;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.PhantomPiranha;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Piranha;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Pylon;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Rat;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.RipperDemon;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.RotHeart;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.RotLasher;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Scorpio;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Senior;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Shaman;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Skeleton;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Slime;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Snake;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.SpectralNecromancer;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Spinner;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Statue;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Succubus;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Swarm;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Tengu;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Thief;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.TormentedSpirit;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Warlock;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Wraith;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.YogDzewa;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.YogFist;
import com.shatteredpixel.shatteredpixeldungeon.items.Ankh;
import com.shatteredpixel.shatteredpixeldungeon.items.ArcaneResin;
import com.shatteredpixel.shatteredpixeldungeon.items.BrokenSeal;
import com.shatteredpixel.shatteredpixeldungeon.items.Dewdrop;
import com.shatteredpixel.shatteredpixeldungeon.items.EnergyCrystal;
import com.shatteredpixel.shatteredpixeldungeon.items.Generator;
import com.shatteredpixel.shatteredpixeldungeon.items.Gold;
import com.shatteredpixel.shatteredpixeldungeon.items.Heap;
import com.shatteredpixel.shatteredpixeldungeon.items.Honeypot;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.TengusMask;
import com.shatteredpixel.shatteredpixeldungeon.items.KingsCrown;
import com.shatteredpixel.shatteredpixeldungeon.items.LiquidMetal;
import com.shatteredpixel.shatteredpixeldungeon.items.Stylus;
import com.shatteredpixel.shatteredpixeldungeon.items.Torch;
import com.shatteredpixel.shatteredpixeldungeon.items.Waterskin;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.ClothArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.LeatherArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.MailArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.PlateArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.ScaleArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.AlchemistsToolkit;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.CapeOfThorns;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.ChaliceOfBlood;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.CloakOfShadows;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.DriedRose;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.EtherealChains;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.HornOfPlenty;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.LloydsBeacon;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.MasterThievesArmband;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.SandalsOfNature;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.TalismanOfForesight;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.TimekeepersHourglass;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.UnstableSpellbook;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.MagicalHolster;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.PotionBandolier;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.ScrollHolder;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.VelvetPouch;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.ArcaneBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.Bomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.Firebomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.Flashbang;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.FrostBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.HolyBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.Noisemaker;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.RegrowthBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.ShockBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.ShrapnelBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.WoollyBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Berry;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Blandfruit;
import com.shatteredpixel.shatteredpixeldungeon.items.food.ChargrilledMeat;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Food;
import com.shatteredpixel.shatteredpixeldungeon.items.food.FrozenCarpaccio;
import com.shatteredpixel.shatteredpixeldungeon.items.food.MysteryMeat;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Pasty;
import com.shatteredpixel.shatteredpixeldungeon.items.food.PhantomMeat;
import com.shatteredpixel.shatteredpixeldungeon.items.food.SmallRation;
import com.shatteredpixel.shatteredpixeldungeon.items.food.StewedMeat;
import com.shatteredpixel.shatteredpixeldungeon.items.journal.AlchemyPage;
import com.shatteredpixel.shatteredpixeldungeon.items.journal.GuidePage;
import com.shatteredpixel.shatteredpixeldungeon.items.journal.Guidebook;
import com.shatteredpixel.shatteredpixeldungeon.items.journal.RegionLorePage;
import com.shatteredpixel.shatteredpixeldungeon.items.keys.CrystalKey;
import com.shatteredpixel.shatteredpixeldungeon.items.keys.GoldenKey;
import com.shatteredpixel.shatteredpixeldungeon.items.keys.IronKey;
import com.shatteredpixel.shatteredpixeldungeon.items.keys.SkeletonKey;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.AlchemicalCatalyst;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfExperience;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfFrost;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfHaste;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfHealing;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfInvisibility;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfLevitation;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfLiquidFlame;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfMindVision;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfParalyticGas;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfPurity;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfStrength;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfToxicGas;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.brews.BlizzardBrew;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.brews.CausticBrew;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.brews.InfernalBrew;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.brews.ShockingBrew;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfAquaticRejuvenation;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfArcaneArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfDragonsBlood;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfHoneyedHealing;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfIcyTouch;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfMight;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfToxicEssence;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfCleansing;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfCorrosiveGas;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfDivineInspiration;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfDragonsBreath;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfEarthenArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfMagicalSight;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfMastery;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfShielding;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfShroudingFog;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfSnapFreeze;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfStamina;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfStormClouds;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.CeremonialCandle;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.CorpseDust;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.DarkGold;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.DwarfToken;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.Embers;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.GooBlob;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.MetalShard;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.Pickaxe;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.RatSkull;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.RingOfAccuracy;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.RingOfArcana;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.RingOfElements;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.RingOfEnergy;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.RingOfEvasion;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.RingOfForce;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.RingOfFuror;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.RingOfHaste;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.RingOfMight;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.RingOfSharpshooting;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.RingOfTenacity;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.RingOfWealth;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfIdentify;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfLullaby;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfMagicMapping;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfMirrorImage;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfRage;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfRecharging;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfRemoveCurse;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfRetribution;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfTeleportation;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfTransmutation;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfUpgrade;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfAntiMagic;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfChallenge;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfDivination;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfDread;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfEnchantment;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfForesight;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfMetamorphosis;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfMysticalEnergy;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfPassage;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfPrismaticImage;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfPsionicBlast;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfSirensSong;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.Alchemize;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.AquaBlast;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.ArcaneCatalyst;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.BeaconOfReturning;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.CurseInfusion;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.FeatherFall;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.InventorySpell;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.MagicalInfusion;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.PhaseShift;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.ReclaimTrap;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.Recycle;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.SummonElemental;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.TelekineticGrab;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.WildEnergy;
import com.shatteredpixel.shatteredpixeldungeon.items.stones.StoneOfAggression;
import com.shatteredpixel.shatteredpixeldungeon.items.stones.StoneOfAugmentation;
import com.shatteredpixel.shatteredpixeldungeon.items.stones.StoneOfBlast;
import com.shatteredpixel.shatteredpixeldungeon.items.stones.StoneOfBlink;
import com.shatteredpixel.shatteredpixeldungeon.items.stones.StoneOfClairvoyance;
import com.shatteredpixel.shatteredpixeldungeon.items.stones.StoneOfDeepSleep;
import com.shatteredpixel.shatteredpixeldungeon.items.stones.StoneOfDisarming;
import com.shatteredpixel.shatteredpixeldungeon.items.stones.StoneOfEnchantment;
import com.shatteredpixel.shatteredpixeldungeon.items.stones.StoneOfFear;
import com.shatteredpixel.shatteredpixeldungeon.items.stones.StoneOfFlock;
import com.shatteredpixel.shatteredpixeldungeon.items.stones.StoneOfIntuition;
import com.shatteredpixel.shatteredpixeldungeon.items.stones.StoneOfShock;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.WandOfBlastWave;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.WandOfCorrosion;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.WandOfCorruption;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.WandOfDisintegration;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.WandOfFireblast;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.WandOfFrost;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.WandOfLightning;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.WandOfLivingEarth;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.WandOfMagicMissile;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.WandOfPrismaticLight;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.WandOfRegrowth;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.WandOfTransfusion;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.WandOfWarding;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.SpiritBow;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.AssassinsBlade;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.BattleAxe;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Crossbow;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Dagger;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Dirk;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Flail;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Gauntlet;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Glaive;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Gloves;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Greataxe;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Greatshield;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Greatsword;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.HandAxe;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Katana;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Longsword;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Mace;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.MagesStaff;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Quarterstaff;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Rapier;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.RoundShield;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.RunicBlade;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Sai;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Scimitar;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Shortsword;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Sickle;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Spear;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Sword;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.WarHammer;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.WarScythe;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Whip;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.WornShortsword;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.Bolas;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.FishingSpear;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.ForceCube;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.HeavyBoomerang;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.Javelin;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.Kunai;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.Shuriken;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.ThrowingClub;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.ThrowingHammer;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.ThrowingKnife;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.ThrowingSpear;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.ThrowingStone;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.Tomahawk;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.Trident;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.darts.AdrenalineDart;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.darts.BlindingDart;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.darts.ChillingDart;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.darts.CleansingDart;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.darts.Dart;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.darts.DisplacingDart;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.darts.HealingDart;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.darts.HolyDart;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.darts.IncendiaryDart;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.darts.ParalyticDart;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.darts.PoisonDart;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.darts.RotDart;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.darts.ShockingDart;
import com.shatteredpixel.shatteredpixeldungeon.levels.features.LevelTransition;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.plants.BlandfruitBush;
import com.shatteredpixel.shatteredpixeldungeon.plants.Blindweed;
import com.shatteredpixel.shatteredpixeldungeon.plants.Earthroot;
import com.shatteredpixel.shatteredpixeldungeon.plants.Fadeleaf;
import com.shatteredpixel.shatteredpixeldungeon.plants.Firebloom;
import com.shatteredpixel.shatteredpixeldungeon.plants.Icecap;
import com.shatteredpixel.shatteredpixeldungeon.plants.Mageroyal;
import com.shatteredpixel.shatteredpixeldungeon.plants.Rotberry;
import com.shatteredpixel.shatteredpixeldungeon.plants.Sorrowmoss;
import com.shatteredpixel.shatteredpixeldungeon.plants.Starflower;
import com.shatteredpixel.shatteredpixeldungeon.plants.Stormvine;
import com.shatteredpixel.shatteredpixeldungeon.plants.Sungrass;
import com.shatteredpixel.shatteredpixeldungeon.plants.Swiftthistle;
import com.shatteredpixel.shatteredpixeldungeon.scenes.CellSelector;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.scenes.InterlevelScene;
import com.shatteredpixel.shatteredpixeldungeon.scenes.PixelScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CharSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSprite;
import com.shatteredpixel.shatteredpixeldungeon.ui.AmountChooser;
import com.shatteredpixel.shatteredpixeldungeon.ui.Button;
import com.shatteredpixel.shatteredpixeldungeon.ui.Icons;
import com.shatteredpixel.shatteredpixeldungeon.ui.RenderedTextBlock;
import com.shatteredpixel.shatteredpixeldungeon.ui.ScrollPane;
import com.shatteredpixel.shatteredpixeldungeon.ui.ScrollingListPane;
import com.shatteredpixel.shatteredpixeldungeon.ui.Toolbar;
import com.watabou.input.PointerEvent;
import com.watabou.noosa.ColorBlock;
import com.watabou.noosa.Game;
import com.watabou.noosa.Gizmo;
import com.watabou.noosa.Group;
import com.watabou.noosa.Image;
import com.watabou.noosa.ui.Component;
import com.watabou.utils.Callback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WndDeveloperTools extends WndTabbed {
	private static final int SLOT_COLS = 6;
	private static final int SLOT_BOX = 28;
	private static final int SLOT_MARGIN = 1;
	private static final int SLOT_SIZE = SLOT_BOX + SLOT_MARGIN;
	private static final int SLIDER_MARGIN = 2;
	private static final int BOTTOM_SIZE = (SLOT_SIZE + SLOT_MARGIN) * 2;
	private static final int WIDTH		= SLOT_SIZE * SLOT_COLS + SLIDER_MARGIN + SLOT_SIZE;
	private static final int HEIGHT		= SLOT_SIZE * 7;

	private static final int SLOT_BTNCOLOR		= 0xFF666666;
	private static final int CONFIG_BTNCOLOR		= 0xFF2D2D2D;
	private static final int BOTTOM_PANELCOLOR		= 0xFF4D4D4D;
	private final MobTab mob_tab;
	private final ItemTab item_tab;
	private final StatTab stat_tab;
	private final LevelTab level_tab;

	public static int lastIdx = 0;

	public WndDeveloperTools() {
		super();
		
		resize( WIDTH, HEIGHT );

		mob_tab = new MobTab();
		add( mob_tab );
		mob_tab.setRect(0, 0, WIDTH, HEIGHT);
		mob_tab.populateMobs();

		item_tab = new ItemTab();
		add( item_tab );
		item_tab.setRect(0, 0, WIDTH, HEIGHT);
		item_tab.populateItems();
		item_tab.addBottomInput();
		item_tab.addSideButtons();

		stat_tab = new StatTab();
		add( stat_tab );
		stat_tab.setRect(0, 0, WIDTH, HEIGHT);

		level_tab = new LevelTab();
		add( level_tab );
		//level_tab.setRect(0, 0, WIDTH, HEIGHT);

/*		buffs.setRect(0, 0, WIDTH, HEIGHT);
		buffs.setupList();
*/

		add( new IconTab( Icons.get(Icons.SNAKE) ) {
			protected void select( boolean value ) {
				super.select( value );
				if (selected) {
					lastIdx = 0;
					/*if (!mob_tab.visible) {
						mob_tab.populateMobs();
					}*/
				}
				mob_tab.visible = mob_tab.active = selected;
			}
		} );

		add( new IconTab( Icons.get(Icons.BACKPACK_LRG) ) {
			protected void select( boolean value ) {
				super.select( value );
				if (selected) {
					lastIdx = 1;
					/*if (!item_tab.visible) {
						item_tab.initialize();
					}*/
				}
				item_tab.visible = item_tab.active = selected;
			}
		} );

		add( new IconTab( Icons.get(Icons.RANKINGS) ) {
			protected void select( boolean value ) {
				super.select( value );
				if (selected) {
					lastIdx = 2;
					/*if (!stat_tab.visible) {
						stat_tab.initialize();
					}*/
				}
				stat_tab.visible = stat_tab.active = selected;
			}
		} );

		add( new IconTab( Icons.get(Icons.STAIRS) ) {
			protected void select( boolean value ) {
				super.select( value );
				if (selected) {
					lastIdx = 3;
					/*if (!level_tab.visible) {
						level_tab.initialize();
					}*/
				}
				level_tab.visible = level_tab.active = selected;
			}
		} );

		layoutTabs();
		select( lastIdx );
	}

	@Override
	public void offset(int xOffset, int yOffset) {
		super.offset(xOffset, yOffset);
		mob_tab.layout();
		item_tab.layout();
		/*stat_tab.layout();
		level_tab.layout();*/
	}

	public class MobTab extends Component {

		private ScrollPane list;
		private Component side_buttons;
		private Component bottom_panel;
		private int col = 0;
		private int row = 0;

		// This list is organized per intended stage
		private static List<Class<? extends Mob>> all_mobs = new ArrayList<>(Arrays.asList(
				Statue.class, ArmoredStatue.class, Bee.class, Wraith.class, TormentedSpirit.class,

				Piranha.class, PhantomPiranha.class,

				Mimic.class, GoldenMimic.class, CrystalMimic.class,

				Rat.class, Albino.class, Snake.class, Gnoll.class, Swarm.class, Crab.class,
				Slime.class, CausticSlime.class,

				FetidRat.class, GnollTrickster.class, GreatCrab.class,

				Goo.class,

				Skeleton.class, Thief.class, Bandit.class, DM100.class, Guard.class, Necromancer.class,
				SpectralNecromancer.class,

				RotHeart.class, RotLasher.class,

				Tengu.class,

				Bat.class, Brute.class, ArmoredBrute.class, Shaman.BlueShaman.class,
				Shaman.RedShaman.class, Shaman.PurpleShaman.class, Spinner.class, DM200.class,
				DM201.class,

				DM300.class, Pylon.class,

				Ghoul.class, Elemental.FireElemental.class, Elemental.FrostElemental.class,
				Elemental.ShockElemental.class, Elemental.ChaosElemental.class, Warlock.class,
				Monk.class, Senior.class, Golem.class,

				DwarfKing.class,

				Succubus.class, Eye.class, Scorpio.class, Acidic.class, DemonSpawner.class,
				RipperDemon.class,

				YogDzewa.class, YogFist.DarkFist.class, YogFist.BrightFist.class,
				YogFist.BurningFist.class, YogFist.RottingFist.class, YogFist.RustedFist.class,
				YogFist.SoiledFist.class
		));

		private class MobSlot extends Button {
			private ColorBlock bg;
			private CharSprite sprite;
			protected Mob       mob;

			private CellSelector.Listener selector;

			public MobSlot(Class<? extends Mob> MobClass){
				super();

				try {
					mob = MobClass.getDeclaredConstructor().newInstance();
				} catch (Exception e)
				{
					Game.reportException(e);
					return;
				}

				sprite = mob.sprite();
				add(sprite);

				selector = new CellSelector.Listener() {
					@Override
					public void onSelect( Integer cell ) {
						if( cell != null ) {
							hide();
							Mob mob;
							try {
								mob = MobClass.getDeclaredConstructor().newInstance();
							} catch (Exception e) {
								Game.reportException(e);
								return;
							}

							mob.pos = cell;
							GameScene.add(mob);
						}
					}
					@Override
					public String prompt() {
						return Messages.get(mob_tab, "place_mob_prompt");
					}
				};
			}

			@Override
			protected String hoverText() {
				return Messages.titleCase(mob.name());
			}

			@Override
			protected void onClick() {
				super.onClick();
				hide();
				GameScene.selectCell(selector);
			}

			@Override
			protected void createChildren() {
				super.createChildren();

				bg = new ColorBlock(1,1, SLOT_BTNCOLOR);
				add(bg);
			}

			@Override
			protected void layout() {
				super.layout();

				bg.size(width, height);
				bg.y = y;
				bg.x = x;

				sprite.x = x + width / 2 - sprite.width() / 2;
				sprite.y = y + height / 2 - sprite.height() / 2;
				PixelScene.align(sprite);
			}
		}

		@Override
		protected void createChildren() {
			super.createChildren();

			list = new ScrollPane(new Component());
			add(list);

			side_buttons = new Component();
			add(side_buttons);

			bottom_panel = new Component(){
				private ColorBlock bg;

				@Override
				protected void createChildren() {
					super.createChildren();

					bg = new ColorBlock(1,1, BOTTOM_PANELCOLOR);
					add(bg);
				}

				@Override
				protected void layout() {
					super.layout();

					bg.size(width, height);
					bg.y = y;
					bg.x = x;
				}
			};
			add(bottom_panel);
		}

		@Override
		protected void layout() {
			super.layout();
			list.setRect(0, 0, SLOT_COLS*SLOT_SIZE+SLIDER_MARGIN, height-BOTTOM_SIZE);
			side_buttons.setRect(SLOT_COLS*SLOT_SIZE+SLIDER_MARGIN+SLOT_MARGIN, 0,SLOT_SIZE,height);
			bottom_panel.setRect(0, height-BOTTOM_SIZE,SLOT_COLS*SLOT_SIZE+SLIDER_MARGIN,BOTTOM_SIZE);
		}
		private void populateMobs() {
			for (Class<? extends Mob> MobClass: all_mobs) {
				addMobButton(MobClass);
			}
			// Content needs to be resized before the rect to show the slider
			list.content().setSize(SLOT_COLS*SLOT_SIZE,row*SLOT_SIZE);
			list.setRect(0, 0, SLOT_COLS*SLOT_SIZE+SLIDER_MARGIN, height-BOTTOM_SIZE);
		}

		private void addMobButton(final Class<? extends Mob> MobClass) {
			int x = col * SLOT_SIZE;
			int y = row * SLOT_SIZE;

			MobSlot slot = new MobSlot(MobClass);

			slot.setRect( x, y, SLOT_BOX, SLOT_BOX );
			list.content().add(slot);

			if (++col >= SLOT_COLS) {
				col = 0;
				row++;
			}
		}
	}

	public class ItemTab extends Component {

		private ScrollPane list;
		private Component side_buttons;
		private Component bottom_panel;
		private AmountChooser item_amount;
		private List<Item> items = new ArrayList<>();
		private int col = 0;
		private int row = 0;

		//TODO: probably should put these in a package
		// This list is organized per item type and tier
		private static List<Class<? extends Item>> all_items = new ArrayList<>(Arrays.asList(
				Belongings.Backpack.class, Waterskin.class, MagicalHolster.class, PotionBandolier.class, ScrollHolder.class,
				VelvetPouch.class,

				BrokenSeal.class, Rapier.class, SpiritBow.class, MagesStaff.class,

				WornShortsword.class, Dagger.class, Gloves.class,
				Shortsword.class, HandAxe.class, Spear.class, Dirk.class, Quarterstaff.class,
				Sickle.class,
				Sword.class, Mace.class, Scimitar.class, Sai.class, RoundShield.class, Whip.class,
				Longsword.class, BattleAxe.class, Flail.class, AssassinsBlade.class,
				RunicBlade.class, Crossbow.class, Katana.class,
				Greatsword.class, WarHammer.class, Glaive.class, Greataxe.class, Greatshield.class,
				Gauntlet.class, WarScythe.class,

				Dart.class, AdrenalineDart.class, BlindingDart.class, ChillingDart.class,
				CleansingDart.class, DisplacingDart.class, HealingDart.class, HolyDart.class,
				IncendiaryDart.class, ParalyticDart.class, PoisonDart.class, ShockingDart.class,
				RotDart.class,
				ThrowingKnife.class, ThrowingStone.class,
				FishingSpear.class, ThrowingClub.class, Shuriken.class,
				Bolas.class, ThrowingSpear.class, Kunai.class,
				Javelin.class, Tomahawk.class, HeavyBoomerang.class,
				Trident.class, ThrowingHammer.class, ForceCube.class,

				ClothArmor.class, LeatherArmor.class, MailArmor.class, ScaleArmor.class,
				PlateArmor.class,

				RingOfAccuracy.class, RingOfArcana.class, RingOfElements.class, RingOfEnergy.class,
				RingOfEvasion.class, RingOfForce.class, RingOfFuror.class, RingOfHaste.class,
				RingOfMight.class, RingOfSharpshooting.class, RingOfTenacity.class,
				RingOfWealth.class,

				AlchemistsToolkit.class, CapeOfThorns.class, ChaliceOfBlood.class,
				CloakOfShadows.class, DriedRose.class, EtherealChains.class, HornOfPlenty.class,
				LloydsBeacon.class, MasterThievesArmband.class, SandalsOfNature.class,
				TalismanOfForesight.class, TimekeepersHourglass.class, UnstableSpellbook.class,

				AlchemyPage.class, Guidebook.class, GuidePage.class, RegionLorePage.Sewers.class,
				RegionLorePage.Prison.class, RegionLorePage.Caves.class,
				RegionLorePage.City.class, RegionLorePage.Halls.class,

				Berry.class, MysteryMeat.class, ChargrilledMeat.class, FrozenCarpaccio.class,
				StewedMeat.class, SmallRation.class, Pasty.class, MysteryMeat.class,
				PhantomMeat.class, Food.class, Blandfruit.class,

				Blindweed.Seed.class, Earthroot.Seed.class, Fadeleaf.Seed.class,
				Firebloom.Seed.class, Icecap.Seed.class, Mageroyal.Seed.class,
				Sorrowmoss.Seed.class, Starflower.Seed.class, Stormvine.Seed.class,
				Sungrass.Seed.class, Swiftthistle.Seed.class, BlandfruitBush.Seed.class,
				Rotberry.Seed.class,

				Bomb.class, ArcaneBomb.class, Firebomb.class, Flashbang.class, FrostBomb.class,
				HolyBomb.class, Noisemaker.class, RegrowthBomb.class, ShockBomb.class,
				ShrapnelBomb.class, WoollyBomb.class,

				PotionOfExperience.class, PotionOfFrost.class, PotionOfHaste.class,
				PotionOfHealing.class, PotionOfInvisibility.class, PotionOfLevitation.class,
				PotionOfLiquidFlame.class, PotionOfMindVision.class, PotionOfParalyticGas.class,
				PotionOfPurity.class, PotionOfStrength.class, PotionOfToxicGas.class,
				AlchemicalCatalyst.class,
				PotionOfCleansing.class, PotionOfCorrosiveGas.class,
				PotionOfDivineInspiration.class, PotionOfDragonsBreath.class,
				PotionOfEarthenArmor.class, PotionOfMagicalSight.class, PotionOfMastery.class,
				PotionOfShielding.class, PotionOfShroudingFog.class, PotionOfSnapFreeze.class,
				PotionOfStamina.class, PotionOfStormClouds.class,
				ElixirOfAquaticRejuvenation.class, ElixirOfArcaneArmor.class,
				ElixirOfDragonsBlood.class, ElixirOfHoneyedHealing.class, ElixirOfIcyTouch.class,
				ElixirOfMight.class, ElixirOfToxicEssence.class,
				BlizzardBrew.class, CausticBrew.class, InfernalBrew.class, ShockingBrew.class,

				ScrollOfIdentify.class, ScrollOfLullaby.class, ScrollOfMagicMapping.class,
				ScrollOfMirrorImage.class, ScrollOfRage.class, ScrollOfRecharging.class,
				ScrollOfRemoveCurse.class, ScrollOfRetribution.class, ScrollOfTeleportation.class,
				ScrollOfTransmutation.class, ScrollOfUpgrade.class,
				ScrollOfAntiMagic.class, ScrollOfChallenge.class, ScrollOfDivination.class,
				ScrollOfDread.class, ScrollOfEnchantment.class, ScrollOfForesight.class,
				ScrollOfMetamorphosis.class, ScrollOfMysticalEnergy.class, ScrollOfPassage.class,
				ScrollOfPrismaticImage.class, ScrollOfPsionicBlast.class, ScrollOfSirensSong.class,

				Alchemize.class, AquaBlast.class, ArcaneCatalyst.class, BeaconOfReturning.class,
				CurseInfusion.class, FeatherFall.class, MagicalInfusion.class, PhaseShift.class,
				ReclaimTrap.class, Recycle.class, SummonElemental.class, TelekineticGrab.class,
				WildEnergy.class,

				StoneOfAggression.class, StoneOfAugmentation.class, StoneOfBlast.class,
				StoneOfBlink.class, StoneOfClairvoyance.class, StoneOfDeepSleep.class,
				StoneOfDisarming.class, StoneOfEnchantment.class, StoneOfFear.class,
				StoneOfFlock.class, StoneOfIntuition.class, StoneOfShock.class,

				WandOfBlastWave.class, WandOfCorrosion.class, WandOfCorruption.class,
				WandOfDisintegration.class, WandOfFireblast.class, WandOfFrost.class,
				WandOfLightning.class, WandOfLivingEarth.class, WandOfMagicMissile.class,
				WandOfPrismaticLight.class, WandOfRegrowth.class, WandOfTransfusion.class,
				WandOfWarding.class,

				Ankh.class, ArcaneResin.class, Dewdrop.class, EnergyCrystal.class,
				Gold.class, Honeypot.class, LiquidMetal.class, Stylus.class,
				Torch.class,

				IronKey.class, GoldenKey.class, CrystalKey.class, SkeletonKey.class,

				TengusMask.class, KingsCrown.class,

				CeremonialCandle.class, CorpseDust.class, DarkGold.class, DwarfToken.class,
				Embers.class, GooBlob.class, MetalShard.class, Pickaxe.class, RatSkull.class
				));

		private class DevItemSlot extends Button {
			private ColorBlock bg;
			private ItemSprite sprite;
			private Item item;

			private CellSelector.Listener selector;

			public DevItemSlot(Class<? extends Item> ItemClass){
				super();

				try {
					item = ItemClass.getDeclaredConstructor().newInstance();
				} catch (Exception e)
				{
					Game.reportException(e);
					return;
				}

				sprite = new ItemSprite();
				sprite.view(item);
				add(sprite);

				selector = new CellSelector.Listener() {
					@Override
					public void onSelect( Integer cell ) {
						if( cell != null ) {
							hide();
							Item item;
							try {
								item = ItemClass.getDeclaredConstructor().newInstance();
							} catch (Exception e) {
								Game.reportException(e);
								return;
							}

							Dungeon.level.drop(item.quantity(item_amount.get()), cell);
						}
					}
					@Override
					public String prompt() {
						return Messages.get(item_tab, "place_item_prompt");
					}
				};
			}

			public Item getItem() {
				return item;
			}

			@Override
			protected String hoverText() {
				return Messages.titleCase(item.name());
			}

			@Override
			protected void onClick() {
				super.onClick();
				hide();
				GameScene.selectCell(selector);
			}

			@Override
			protected void createChildren() {
				super.createChildren();

				bg = new ColorBlock(1,1, SLOT_BTNCOLOR);
				add(bg);
			}

			@Override
			protected void layout() {
				super.layout();

				bg.size(width, height);
				bg.y = y;
				bg.x = x;

				sprite.x = x + width / 2 - sprite.width() / 2;
				sprite.y = y + height / 2 - sprite.height() / 2;
				PixelScene.align(sprite);
			}
		}

		@Override
		protected void createChildren() {
			super.createChildren();

			list = new ScrollPane(new Component());
			add(list);

			side_buttons = new Component();
			add(side_buttons);

			bottom_panel = new Component(){
				private ColorBlock bg;

				@Override
				protected void createChildren() {
					super.createChildren();

					bg = new ColorBlock(1,1, BOTTOM_PANELCOLOR);
					add(bg);
				}

				@Override
				protected void layout() {
					super.layout();

					bg.size(width, height);
					bg.y = y;
					bg.x = x;
				}
			};
			add(bottom_panel);
		}

		@Override
		protected void layout() {
			super.layout();
			list.setRect(0, 0, SLOT_COLS*SLOT_SIZE+SLIDER_MARGIN, height-BOTTOM_SIZE);
			side_buttons.setRect(SLOT_COLS*SLOT_SIZE+SLIDER_MARGIN+SLOT_MARGIN, 0,SLOT_SIZE,height);
			bottom_panel.setRect(0, height-BOTTOM_SIZE,SLOT_COLS*SLOT_SIZE+SLIDER_MARGIN,BOTTOM_SIZE);
		}
		private void populateItems() {
			for (Class<? extends Item> ItemClass: all_items) {
				addItemButton(ItemClass);
			}
			list.content().setSize(SLOT_COLS*SLOT_SIZE,row*SLOT_SIZE);
			list.setRect(0, 0, SLOT_COLS*SLOT_SIZE+SLIDER_MARGIN, height-BOTTOM_SIZE);
		}
		private void addItemButton(final Class<? extends Item> ItemClass) {
			int x = col * SLOT_SIZE;
			int y = row * SLOT_SIZE;

			DevItemSlot slot = new DevItemSlot(ItemClass);

			slot.setRect( x, y, SLOT_BOX, SLOT_BOX );
			list.content().add(slot);
			items.add(slot.getItem());

			if (++col >= SLOT_COLS) {
				col = 0;
				row++;
			}
		}
		private void addSideButtons() {
			Button identify = new Button(){
				private ColorBlock bg;
				private Image icon;

				@Override
				protected String hoverText() {
					return Messages.titleCase(Messages.get(item_tab, "identify"));
				}

				@Override
				protected void onClick() {
					super.onClick();
					for (Item i: items) {
						i.identify(false);
					}
				}

				@Override
				protected void createChildren() {
					super.createChildren();

					bg = new ColorBlock(1,1, CONFIG_BTNCOLOR);
					add(bg);

					icon = Icons.get(Icons.MAGNIFY);
					add(icon);
				}

				@Override
				protected void layout() {
					super.layout();

					bg.size(width, height);
					bg.y = y;
					bg.x = x;

					icon.x = x + width / 2 - icon.width() / 2;
					icon.y = y + height / 2 - icon.height() / 2;
					PixelScene.align(icon);
				}
			};
			identify.setRect( side_buttons.left(), side_buttons.top(), SLOT_BOX, SLOT_BOX );
			side_buttons.add(identify);
		}

		private void addBottomInput(){
			item_amount = new AmountChooser("#",1,SLOT_SIZE/2);
			item_amount.setRect( bottom_panel.left(), bottom_panel.top(), SLOT_SIZE/2*3, SLOT_SIZE/2 );
			bottom_panel.add(item_amount);
		}
	}

	public class StatTab extends Component {

		private Button lvlup_btn;
		private AmountChooser maxhp_amount;
		private AmountChooser hp_amount;
		private AmountChooser strength_amount;
		private AmountChooser accuracy_amount;
		private AmountChooser evasion_amount;

		@Override
		protected void createChildren() {
			super.createChildren();

			lvlup_btn = new Button(){
				private ColorBlock bg;
				private Image icon;

				@Override
				protected String hoverText() {
					return Messages.titleCase(Messages.get(stat_tab, "level_up"));
				}

				@Override
				protected void onClick() {
					super.onClick();

					Dungeon.hero.earnExp( Dungeon.hero.maxExp(), getClass() );
					maxhp_amount.set(Dungeon.hero.HT);
					hp_amount.set(Dungeon.hero.HP);
					strength_amount.set(Dungeon.hero.STR);
					accuracy_amount.set(Dungeon.hero.attackSkill);
					evasion_amount.set(Dungeon.hero.defenseSkill);
				}

				@Override
				protected void createChildren() {
					super.createChildren();

					bg = new ColorBlock(1,1, CONFIG_BTNCOLOR);
					add(bg);

					icon = Icons.get(Icons.TALENT);
					add(icon);
				}

				@Override
				protected void layout() {
					super.layout();

					bg.size(width, height);
					bg.y = y;
					bg.x = x;

					icon.x = x + width / 2 - icon.width() / 2;
					icon.y = y + height / 2 - icon.height() / 2;
					PixelScene.align(icon);
				}
			};
			lvlup_btn.setRect( 0, 0, SLOT_SIZE, SLOT_SIZE);
			add(lvlup_btn);

			maxhp_amount = new AmountChooser("HT", Dungeon.hero.baseHT,SLOT_SIZE/2);
			maxhp_amount.setCallback( new Callback(){
				 @Override
				 public void call()
				 {
					 Dungeon.hero.HT = maxhp_amount.get();
					 if(Dungeon.hero.HT < Dungeon.hero.HP) {
						 Dungeon.hero.HP = Dungeon.hero.HT;
						 hp_amount.set(Dungeon.hero.HP);
					 }
				 }
			 });
			maxhp_amount.setRect( 0, SLOT_SIZE, SLOT_SIZE/2*3, SLOT_SIZE/2 );
			add(maxhp_amount);

			hp_amount = new AmountChooser("HP", Dungeon.hero.HP,SLOT_SIZE/2);
			hp_amount.setCallback( new Callback(){
				@Override
				public void call()
				{
					Dungeon.hero.HP = hp_amount.get();
					if(Dungeon.hero.HP > Dungeon.hero.HT)
					{
						Dungeon.hero.HT = Dungeon.hero.HP;
						maxhp_amount.set(Dungeon.hero.HT);
					}
				}
			});
			hp_amount.setRect( 0, SLOT_SIZE*2, SLOT_SIZE/2*3, SLOT_SIZE/2 );
			add(hp_amount);

			strength_amount = new AmountChooser("STR", Dungeon.hero.STR,SLOT_SIZE/2);
			strength_amount.setCallback( new Callback(){
				@Override
				public void call()
				{
					Dungeon.hero.STR = strength_amount.get();
				}
			});
			strength_amount.setRect( 0, SLOT_SIZE*3, SLOT_SIZE/2*3, SLOT_SIZE/2 );
			add(strength_amount);

			accuracy_amount = new AmountChooser("ACC",Dungeon.hero.attackSkill,SLOT_SIZE/2);
			accuracy_amount.setCallback( new Callback(){
				@Override
				public void call()
				{
					Dungeon.hero.attackSkill = accuracy_amount.get();
				}
			});
			accuracy_amount.setRect( 0, SLOT_SIZE*4, SLOT_SIZE/2*3, SLOT_SIZE/2 );
			add(accuracy_amount);

			evasion_amount = new AmountChooser("DEF",Dungeon.hero.defenseSkill,SLOT_SIZE/2);
			evasion_amount.setCallback( new Callback(){
				@Override
				public void call()
				{
					Dungeon.hero.defenseSkill = evasion_amount.get();
				}
			});
			evasion_amount.setRect( 0, SLOT_SIZE*5, SLOT_SIZE/2*3, SLOT_SIZE/2 );
			add(evasion_amount);
		}
	}
	public class LevelTab extends Component {

		private Button go_up;
		private Button go_down;

		@Override
		protected void createChildren() {
			super.createChildren();

			go_up = new Button(){
				private ColorBlock bg;
				RenderedTextBlock text;

				@Override
				protected String hoverText() {
					return Messages.titleCase(Messages.get(level_tab, "depth_up"));
				}

				@Override
				protected void onClick() {
					super.onClick();

					LevelTransition transition = null;
					for(LevelTransition t:Dungeon.level.transitions){
						if(t.type==LevelTransition.Type.REGULAR_ENTRANCE){
							transition = t;
							break;
						}
					}

					if(transition!=null) {
						InterlevelScene.curTransition = transition;
						InterlevelScene.mode = InterlevelScene.Mode.ASCEND;
						Game.switchScene(InterlevelScene.class);
					}
				}

				@Override
				protected void createChildren() {
					super.createChildren();

					bg = new ColorBlock(1,1, CONFIG_BTNCOLOR);
					add(bg);

					text = PixelScene.renderTextBlock("<",9);
					add(text);
				}

				@Override
				protected void layout() {
					super.layout();

					bg.size(width, height);
					bg.y = y;
					bg.x = x;

					text.setPos(x + width / 2 - text.width() / 2,
							y + height / 2 - text.height() / 2);
				}
			};
			go_up.setRect( 0, 0, SLOT_SIZE, SLOT_SIZE);
			add(go_up);

			go_down = new Button(){
				private ColorBlock bg;
				RenderedTextBlock text;

				@Override
				protected String hoverText() {
					return Messages.titleCase(Messages.get(level_tab, "depth_down"));
				}

				@Override
				protected void onClick() {
					super.onClick();

					LevelTransition transition = null;
					for(LevelTransition t:Dungeon.level.transitions){
						if(t.type==LevelTransition.Type.REGULAR_EXIT){
							transition = t;
							break;
						}
					}

					if(transition!=null) {
						InterlevelScene.curTransition = transition;
						InterlevelScene.mode = InterlevelScene.Mode.DESCEND;
						Game.switchScene(InterlevelScene.class);
					}
				}

				@Override
				protected void createChildren() {
					super.createChildren();

					bg = new ColorBlock(1,1, CONFIG_BTNCOLOR);
					add(bg);

					text = PixelScene.renderTextBlock(">",9);
					add(text);
				}

				@Override
				protected void layout() {
					super.layout();

					bg.size(width, height);
					bg.y = y;
					bg.x = x;

					text.setPos(x + width / 2 - text.width() / 2,
							y + height / 2 - text.height() / 2);
				}
			};
			go_down.setRect( SLOT_SIZE, 0, SLOT_SIZE, SLOT_SIZE);
			add(go_down);
		}
	}
}
