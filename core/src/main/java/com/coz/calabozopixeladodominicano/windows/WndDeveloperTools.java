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

package com.coz.calabozopixeladodominicano.windows;

import com.coz.calabozopixeladodominicano.Dungeon;
import com.coz.calabozopixeladodominicano.actors.Char;
import com.coz.calabozopixeladodominicano.actors.hero.Belongings;
import com.coz.calabozopixeladodominicano.actors.mobs.Acidic;
import com.coz.calabozopixeladodominicano.actors.mobs.Albino;
import com.coz.calabozopixeladodominicano.actors.mobs.ArmoredBrute;
import com.coz.calabozopixeladodominicano.actors.mobs.ArmoredStatue;
import com.coz.calabozopixeladodominicano.actors.mobs.Bandit;
import com.coz.calabozopixeladodominicano.actors.mobs.Bat;
import com.coz.calabozopixeladodominicano.actors.mobs.Bee;
import com.coz.calabozopixeladodominicano.actors.mobs.Brute;
import com.coz.calabozopixeladodominicano.actors.mobs.CausticSlime;
import com.coz.calabozopixeladodominicano.actors.mobs.Crab;
import com.coz.calabozopixeladodominicano.actors.mobs.CrystalMimic;
import com.coz.calabozopixeladodominicano.actors.mobs.DM100;
import com.coz.calabozopixeladodominicano.actors.mobs.DM200;
import com.coz.calabozopixeladodominicano.actors.mobs.DM201;
import com.coz.calabozopixeladodominicano.actors.mobs.DM300;
import com.coz.calabozopixeladodominicano.actors.mobs.DemonSpawner;
import com.coz.calabozopixeladodominicano.actors.mobs.DwarfKing;
import com.coz.calabozopixeladodominicano.actors.mobs.Elemental;
import com.coz.calabozopixeladodominicano.actors.mobs.Eye;
import com.coz.calabozopixeladodominicano.actors.mobs.FetidRat;
import com.coz.calabozopixeladodominicano.actors.mobs.Ghoul;
import com.coz.calabozopixeladodominicano.actors.mobs.Gnoll;
import com.coz.calabozopixeladodominicano.actors.mobs.GnollTrickster;
import com.coz.calabozopixeladodominicano.actors.mobs.GoldenMimic;
import com.coz.calabozopixeladodominicano.actors.mobs.Golem;
import com.coz.calabozopixeladodominicano.actors.mobs.Goo;
import com.coz.calabozopixeladodominicano.actors.mobs.GreatCrab;
import com.coz.calabozopixeladodominicano.actors.mobs.Guard;
import com.coz.calabozopixeladodominicano.actors.mobs.Mimic;
import com.coz.calabozopixeladodominicano.actors.mobs.Mob;
import com.coz.calabozopixeladodominicano.actors.mobs.Monk;
import com.coz.calabozopixeladodominicano.actors.mobs.Necromancer;
import com.coz.calabozopixeladodominicano.actors.mobs.PhantomPiranha;
import com.coz.calabozopixeladodominicano.actors.mobs.Piranha;
import com.coz.calabozopixeladodominicano.actors.mobs.Pylon;
import com.coz.calabozopixeladodominicano.actors.mobs.Rat;
import com.coz.calabozopixeladodominicano.actors.mobs.RipperDemon;
import com.coz.calabozopixeladodominicano.actors.mobs.RotHeart;
import com.coz.calabozopixeladodominicano.actors.mobs.RotLasher;
import com.coz.calabozopixeladodominicano.actors.mobs.Scorpio;
import com.coz.calabozopixeladodominicano.actors.mobs.Senior;
import com.coz.calabozopixeladodominicano.actors.mobs.Shaman;
import com.coz.calabozopixeladodominicano.actors.mobs.Skeleton;
import com.coz.calabozopixeladodominicano.actors.mobs.Slime;
import com.coz.calabozopixeladodominicano.actors.mobs.Snake;
import com.coz.calabozopixeladodominicano.actors.mobs.SpectralNecromancer;
import com.coz.calabozopixeladodominicano.actors.mobs.Spinner;
import com.coz.calabozopixeladodominicano.actors.mobs.Statue;
import com.coz.calabozopixeladodominicano.actors.mobs.Succubus;
import com.coz.calabozopixeladodominicano.actors.mobs.Swarm;
import com.coz.calabozopixeladodominicano.actors.mobs.Tengu;
import com.coz.calabozopixeladodominicano.actors.mobs.Thief;
import com.coz.calabozopixeladodominicano.actors.mobs.TormentedSpirit;
import com.coz.calabozopixeladodominicano.actors.mobs.Warlock;
import com.coz.calabozopixeladodominicano.actors.mobs.Wraith;
import com.coz.calabozopixeladodominicano.actors.mobs.YogDzewa;
import com.coz.calabozopixeladodominicano.actors.mobs.YogFist;
import com.coz.calabozopixeladodominicano.items.Ankh;
import com.coz.calabozopixeladodominicano.items.ArcaneResin;
import com.coz.calabozopixeladodominicano.items.BrokenSeal;
import com.coz.calabozopixeladodominicano.items.Dewdrop;
import com.coz.calabozopixeladodominicano.items.EnergyCrystal;
import com.coz.calabozopixeladodominicano.items.Gold;
import com.coz.calabozopixeladodominicano.items.Honeypot;
import com.coz.calabozopixeladodominicano.items.Item;
import com.coz.calabozopixeladodominicano.items.TengusMask;
import com.coz.calabozopixeladodominicano.items.KingsCrown;
import com.coz.calabozopixeladodominicano.items.LiquidMetal;
import com.coz.calabozopixeladodominicano.items.Stylus;
import com.coz.calabozopixeladodominicano.items.Torch;
import com.coz.calabozopixeladodominicano.items.Waterskin;
import com.coz.calabozopixeladodominicano.items.armor.ClothArmor;
import com.coz.calabozopixeladodominicano.items.armor.LeatherArmor;
import com.coz.calabozopixeladodominicano.items.armor.MailArmor;
import com.coz.calabozopixeladodominicano.items.armor.PlateArmor;
import com.coz.calabozopixeladodominicano.items.armor.ScaleArmor;
import com.coz.calabozopixeladodominicano.items.artifacts.AlchemistsToolkit;
import com.coz.calabozopixeladodominicano.items.artifacts.CapeOfThorns;
import com.coz.calabozopixeladodominicano.items.artifacts.ChaliceOfBlood;
import com.coz.calabozopixeladodominicano.items.artifacts.CloakOfShadows;
import com.coz.calabozopixeladodominicano.items.artifacts.DriedRose;
import com.coz.calabozopixeladodominicano.items.artifacts.EtherealChains;
import com.coz.calabozopixeladodominicano.items.artifacts.HornOfPlenty;
import com.coz.calabozopixeladodominicano.items.artifacts.LloydsBeacon;
import com.coz.calabozopixeladodominicano.items.artifacts.MasterThievesArmband;
import com.coz.calabozopixeladodominicano.items.artifacts.SandalsOfNature;
import com.coz.calabozopixeladodominicano.items.artifacts.TalismanOfForesight;
import com.coz.calabozopixeladodominicano.items.artifacts.TimekeepersHourglass;
import com.coz.calabozopixeladodominicano.items.artifacts.UnstableSpellbook;
import com.coz.calabozopixeladodominicano.items.bags.MagicalHolster;
import com.coz.calabozopixeladodominicano.items.bags.PotionBandolier;
import com.coz.calabozopixeladodominicano.items.bags.ScrollHolder;
import com.coz.calabozopixeladodominicano.items.bags.VelvetPouch;
import com.coz.calabozopixeladodominicano.items.bombs.ArcaneBomb;
import com.coz.calabozopixeladodominicano.items.bombs.Bomb;
import com.coz.calabozopixeladodominicano.items.bombs.Firebomb;
import com.coz.calabozopixeladodominicano.items.bombs.Flashbang;
import com.coz.calabozopixeladodominicano.items.bombs.FrostBomb;
import com.coz.calabozopixeladodominicano.items.bombs.HolyBomb;
import com.coz.calabozopixeladodominicano.items.bombs.Noisemaker;
import com.coz.calabozopixeladodominicano.items.bombs.RegrowthBomb;
import com.coz.calabozopixeladodominicano.items.bombs.ShockBomb;
import com.coz.calabozopixeladodominicano.items.bombs.ShrapnelBomb;
import com.coz.calabozopixeladodominicano.items.bombs.WoollyBomb;
import com.coz.calabozopixeladodominicano.items.food.Berry;
import com.coz.calabozopixeladodominicano.items.food.Blandfruit;
import com.coz.calabozopixeladodominicano.items.food.ChargrilledMeat;
import com.coz.calabozopixeladodominicano.items.food.Food;
import com.coz.calabozopixeladodominicano.items.food.FrozenCarpaccio;
import com.coz.calabozopixeladodominicano.items.food.MysteryMeat;
import com.coz.calabozopixeladodominicano.items.food.Pasty;
import com.coz.calabozopixeladodominicano.items.food.PhantomMeat;
import com.coz.calabozopixeladodominicano.items.food.SmallRation;
import com.coz.calabozopixeladodominicano.items.food.StewedMeat;
import com.coz.calabozopixeladodominicano.items.journal.AlchemyPage;
import com.coz.calabozopixeladodominicano.items.journal.GuidePage;
import com.coz.calabozopixeladodominicano.items.journal.Guidebook;
import com.coz.calabozopixeladodominicano.items.journal.RegionLorePage;
import com.coz.calabozopixeladodominicano.items.keys.CrystalKey;
import com.coz.calabozopixeladodominicano.items.keys.GoldenKey;
import com.coz.calabozopixeladodominicano.items.keys.IronKey;
import com.coz.calabozopixeladodominicano.items.keys.SkeletonKey;
import com.coz.calabozopixeladodominicano.items.potions.AlchemicalCatalyst;
import com.coz.calabozopixeladodominicano.items.potions.PotionOfExperience;
import com.coz.calabozopixeladodominicano.items.potions.PotionOfFrost;
import com.coz.calabozopixeladodominicano.items.potions.PotionOfHaste;
import com.coz.calabozopixeladodominicano.items.potions.PotionOfHealing;
import com.coz.calabozopixeladodominicano.items.potions.PotionOfInvisibility;
import com.coz.calabozopixeladodominicano.items.potions.PotionOfLevitation;
import com.coz.calabozopixeladodominicano.items.potions.PotionOfLiquidFlame;
import com.coz.calabozopixeladodominicano.items.potions.PotionOfMindVision;
import com.coz.calabozopixeladodominicano.items.potions.PotionOfParalyticGas;
import com.coz.calabozopixeladodominicano.items.potions.PotionOfPurity;
import com.coz.calabozopixeladodominicano.items.potions.PotionOfStrength;
import com.coz.calabozopixeladodominicano.items.potions.PotionOfToxicGas;
import com.coz.calabozopixeladodominicano.items.potions.brews.BlizzardBrew;
import com.coz.calabozopixeladodominicano.items.potions.brews.CausticBrew;
import com.coz.calabozopixeladodominicano.items.potions.brews.InfernalBrew;
import com.coz.calabozopixeladodominicano.items.potions.brews.ShockingBrew;
import com.coz.calabozopixeladodominicano.items.potions.elixirs.ElixirOfAquaticRejuvenation;
import com.coz.calabozopixeladodominicano.items.potions.elixirs.ElixirOfArcaneArmor;
import com.coz.calabozopixeladodominicano.items.potions.elixirs.ElixirOfDragonsBlood;
import com.coz.calabozopixeladodominicano.items.potions.elixirs.ElixirOfHoneyedHealing;
import com.coz.calabozopixeladodominicano.items.potions.elixirs.ElixirOfIcyTouch;
import com.coz.calabozopixeladodominicano.items.potions.elixirs.ElixirOfMight;
import com.coz.calabozopixeladodominicano.items.potions.elixirs.ElixirOfToxicEssence;
import com.coz.calabozopixeladodominicano.items.potions.exotic.PotionOfCleansing;
import com.coz.calabozopixeladodominicano.items.potions.exotic.PotionOfCorrosiveGas;
import com.coz.calabozopixeladodominicano.items.potions.exotic.PotionOfDivineInspiration;
import com.coz.calabozopixeladodominicano.items.potions.exotic.PotionOfDragonsBreath;
import com.coz.calabozopixeladodominicano.items.potions.exotic.PotionOfEarthenArmor;
import com.coz.calabozopixeladodominicano.items.potions.exotic.PotionOfMagicalSight;
import com.coz.calabozopixeladodominicano.items.potions.exotic.PotionOfMastery;
import com.coz.calabozopixeladodominicano.items.potions.exotic.PotionOfShielding;
import com.coz.calabozopixeladodominicano.items.potions.exotic.PotionOfShroudingFog;
import com.coz.calabozopixeladodominicano.items.potions.exotic.PotionOfSnapFreeze;
import com.coz.calabozopixeladodominicano.items.potions.exotic.PotionOfStamina;
import com.coz.calabozopixeladodominicano.items.potions.exotic.PotionOfStormClouds;
import com.coz.calabozopixeladodominicano.items.quest.CeremonialCandle;
import com.coz.calabozopixeladodominicano.items.quest.CorpseDust;
import com.coz.calabozopixeladodominicano.items.quest.DarkGold;
import com.coz.calabozopixeladodominicano.items.quest.DwarfToken;
import com.coz.calabozopixeladodominicano.items.quest.Embers;
import com.coz.calabozopixeladodominicano.items.quest.GooBlob;
import com.coz.calabozopixeladodominicano.items.quest.MetalShard;
import com.coz.calabozopixeladodominicano.items.quest.Pickaxe;
import com.coz.calabozopixeladodominicano.items.quest.RatSkull;
import com.coz.calabozopixeladodominicano.items.rings.RingOfAccuracy;
import com.coz.calabozopixeladodominicano.items.rings.RingOfArcana;
import com.coz.calabozopixeladodominicano.items.rings.RingOfElements;
import com.coz.calabozopixeladodominicano.items.rings.RingOfEnergy;
import com.coz.calabozopixeladodominicano.items.rings.RingOfEvasion;
import com.coz.calabozopixeladodominicano.items.rings.RingOfForce;
import com.coz.calabozopixeladodominicano.items.rings.RingOfFuror;
import com.coz.calabozopixeladodominicano.items.rings.RingOfHaste;
import com.coz.calabozopixeladodominicano.items.rings.RingOfMight;
import com.coz.calabozopixeladodominicano.items.rings.RingOfSharpshooting;
import com.coz.calabozopixeladodominicano.items.rings.RingOfTenacity;
import com.coz.calabozopixeladodominicano.items.rings.RingOfWealth;
import com.coz.calabozopixeladodominicano.items.scrolls.ScrollOfIdentify;
import com.coz.calabozopixeladodominicano.items.scrolls.ScrollOfLullaby;
import com.coz.calabozopixeladodominicano.items.scrolls.ScrollOfMagicMapping;
import com.coz.calabozopixeladodominicano.items.scrolls.ScrollOfMirrorImage;
import com.coz.calabozopixeladodominicano.items.scrolls.ScrollOfRage;
import com.coz.calabozopixeladodominicano.items.scrolls.ScrollOfRecharging;
import com.coz.calabozopixeladodominicano.items.scrolls.ScrollOfRemoveCurse;
import com.coz.calabozopixeladodominicano.items.scrolls.ScrollOfRetribution;
import com.coz.calabozopixeladodominicano.items.scrolls.ScrollOfTeleportation;
import com.coz.calabozopixeladodominicano.items.scrolls.ScrollOfTransmutation;
import com.coz.calabozopixeladodominicano.items.scrolls.ScrollOfUpgrade;
import com.coz.calabozopixeladodominicano.items.scrolls.exotic.ScrollOfAntiMagic;
import com.coz.calabozopixeladodominicano.items.scrolls.exotic.ScrollOfChallenge;
import com.coz.calabozopixeladodominicano.items.scrolls.exotic.ScrollOfDivination;
import com.coz.calabozopixeladodominicano.items.scrolls.exotic.ScrollOfDread;
import com.coz.calabozopixeladodominicano.items.scrolls.exotic.ScrollOfEnchantment;
import com.coz.calabozopixeladodominicano.items.scrolls.exotic.ScrollOfForesight;
import com.coz.calabozopixeladodominicano.items.scrolls.exotic.ScrollOfMetamorphosis;
import com.coz.calabozopixeladodominicano.items.scrolls.exotic.ScrollOfMysticalEnergy;
import com.coz.calabozopixeladodominicano.items.scrolls.exotic.ScrollOfPassage;
import com.coz.calabozopixeladodominicano.items.scrolls.exotic.ScrollOfPrismaticImage;
import com.coz.calabozopixeladodominicano.items.scrolls.exotic.ScrollOfPsionicBlast;
import com.coz.calabozopixeladodominicano.items.scrolls.exotic.ScrollOfSirensSong;
import com.coz.calabozopixeladodominicano.items.spells.Alchemize;
import com.coz.calabozopixeladodominicano.items.spells.AquaBlast;
import com.coz.calabozopixeladodominicano.items.spells.ArcaneCatalyst;
import com.coz.calabozopixeladodominicano.items.spells.BeaconOfReturning;
import com.coz.calabozopixeladodominicano.items.spells.CurseInfusion;
import com.coz.calabozopixeladodominicano.items.spells.FeatherFall;
import com.coz.calabozopixeladodominicano.items.spells.MagicalInfusion;
import com.coz.calabozopixeladodominicano.items.spells.PhaseShift;
import com.coz.calabozopixeladodominicano.items.spells.ReclaimTrap;
import com.coz.calabozopixeladodominicano.items.spells.Recycle;
import com.coz.calabozopixeladodominicano.items.spells.SummonElemental;
import com.coz.calabozopixeladodominicano.items.spells.TelekineticGrab;
import com.coz.calabozopixeladodominicano.items.spells.WildEnergy;
import com.coz.calabozopixeladodominicano.items.stones.StoneOfAggression;
import com.coz.calabozopixeladodominicano.items.stones.StoneOfAugmentation;
import com.coz.calabozopixeladodominicano.items.stones.StoneOfBlast;
import com.coz.calabozopixeladodominicano.items.stones.StoneOfBlink;
import com.coz.calabozopixeladodominicano.items.stones.StoneOfClairvoyance;
import com.coz.calabozopixeladodominicano.items.stones.StoneOfDeepSleep;
import com.coz.calabozopixeladodominicano.items.stones.StoneOfDisarming;
import com.coz.calabozopixeladodominicano.items.stones.StoneOfEnchantment;
import com.coz.calabozopixeladodominicano.items.stones.StoneOfFear;
import com.coz.calabozopixeladodominicano.items.stones.StoneOfFlock;
import com.coz.calabozopixeladodominicano.items.stones.StoneOfIntuition;
import com.coz.calabozopixeladodominicano.items.stones.StoneOfShock;
import com.coz.calabozopixeladodominicano.items.wands.WandOfBlastWave;
import com.coz.calabozopixeladodominicano.items.wands.WandOfCorrosion;
import com.coz.calabozopixeladodominicano.items.wands.WandOfCorruption;
import com.coz.calabozopixeladodominicano.items.wands.WandOfDisintegration;
import com.coz.calabozopixeladodominicano.items.wands.WandOfFireblast;
import com.coz.calabozopixeladodominicano.items.wands.WandOfFrost;
import com.coz.calabozopixeladodominicano.items.wands.WandOfLightning;
import com.coz.calabozopixeladodominicano.items.wands.WandOfLivingEarth;
import com.coz.calabozopixeladodominicano.items.wands.WandOfMagicMissile;
import com.coz.calabozopixeladodominicano.items.wands.WandOfPrismaticLight;
import com.coz.calabozopixeladodominicano.items.wands.WandOfRegrowth;
import com.coz.calabozopixeladodominicano.items.wands.WandOfTransfusion;
import com.coz.calabozopixeladodominicano.items.wands.WandOfWarding;
import com.coz.calabozopixeladodominicano.items.weapon.SpiritBow;
import com.coz.calabozopixeladodominicano.items.weapon.melee.AssassinsBlade;
import com.coz.calabozopixeladodominicano.items.weapon.melee.BattleAxe;
import com.coz.calabozopixeladodominicano.items.weapon.melee.Crossbow;
import com.coz.calabozopixeladodominicano.items.weapon.melee.Dagger;
import com.coz.calabozopixeladodominicano.items.weapon.melee.Dirk;
import com.coz.calabozopixeladodominicano.items.weapon.melee.Flail;
import com.coz.calabozopixeladodominicano.items.weapon.melee.Gauntlet;
import com.coz.calabozopixeladodominicano.items.weapon.melee.Glaive;
import com.coz.calabozopixeladodominicano.items.weapon.melee.Gloves;
import com.coz.calabozopixeladodominicano.items.weapon.melee.Greataxe;
import com.coz.calabozopixeladodominicano.items.weapon.melee.Greatshield;
import com.coz.calabozopixeladodominicano.items.weapon.melee.Greatsword;
import com.coz.calabozopixeladodominicano.items.weapon.melee.HandAxe;
import com.coz.calabozopixeladodominicano.items.weapon.melee.Katana;
import com.coz.calabozopixeladodominicano.items.weapon.melee.Longsword;
import com.coz.calabozopixeladodominicano.items.weapon.melee.Mace;
import com.coz.calabozopixeladodominicano.items.weapon.melee.MagesStaff;
import com.coz.calabozopixeladodominicano.items.weapon.melee.Quarterstaff;
import com.coz.calabozopixeladodominicano.items.weapon.melee.Rapier;
import com.coz.calabozopixeladodominicano.items.weapon.melee.RoundShield;
import com.coz.calabozopixeladodominicano.items.weapon.melee.RunicBlade;
import com.coz.calabozopixeladodominicano.items.weapon.melee.Sai;
import com.coz.calabozopixeladodominicano.items.weapon.melee.Scimitar;
import com.coz.calabozopixeladodominicano.items.weapon.melee.Shortsword;
import com.coz.calabozopixeladodominicano.items.weapon.melee.Sickle;
import com.coz.calabozopixeladodominicano.items.weapon.melee.Spear;
import com.coz.calabozopixeladodominicano.items.weapon.melee.Sword;
import com.coz.calabozopixeladodominicano.items.weapon.melee.WarHammer;
import com.coz.calabozopixeladodominicano.items.weapon.melee.WarScythe;
import com.coz.calabozopixeladodominicano.items.weapon.melee.Whip;
import com.coz.calabozopixeladodominicano.items.weapon.melee.WornShortsword;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.Bolas;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.FishingSpear;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.ForceCube;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.HeavyBoomerang;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.Javelin;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.Kunai;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.Shuriken;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.ThrowingClub;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.ThrowingHammer;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.ThrowingKnife;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.ThrowingSpear;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.ThrowingStone;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.Tomahawk;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.Trident;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.darts.AdrenalineDart;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.darts.BlindingDart;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.darts.ChillingDart;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.darts.CleansingDart;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.darts.Dart;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.darts.DisplacingDart;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.darts.HealingDart;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.darts.HolyDart;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.darts.IncendiaryDart;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.darts.ParalyticDart;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.darts.PoisonDart;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.darts.RotDart;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.darts.ShockingDart;
import com.coz.calabozopixeladodominicano.levels.features.LevelTransition;
import com.coz.calabozopixeladodominicano.messages.Messages;
import com.coz.calabozopixeladodominicano.plants.BlandfruitBush;
import com.coz.calabozopixeladodominicano.plants.Blindweed;
import com.coz.calabozopixeladodominicano.plants.Earthroot;
import com.coz.calabozopixeladodominicano.plants.Fadeleaf;
import com.coz.calabozopixeladodominicano.plants.Firebloom;
import com.coz.calabozopixeladodominicano.plants.Icecap;
import com.coz.calabozopixeladodominicano.plants.Mageroyal;
import com.coz.calabozopixeladodominicano.plants.Rotberry;
import com.coz.calabozopixeladodominicano.plants.Sorrowmoss;
import com.coz.calabozopixeladodominicano.plants.Starflower;
import com.coz.calabozopixeladodominicano.plants.Stormvine;
import com.coz.calabozopixeladodominicano.plants.Sungrass;
import com.coz.calabozopixeladodominicano.plants.Swiftthistle;
import com.coz.calabozopixeladodominicano.scenes.CellSelector;
import com.coz.calabozopixeladodominicano.scenes.GameScene;
import com.coz.calabozopixeladodominicano.scenes.InterlevelScene;
import com.coz.calabozopixeladodominicano.scenes.PixelScene;
import com.coz.calabozopixeladodominicano.sprites.CharSprite;
import com.coz.calabozopixeladodominicano.sprites.ItemSprite;
import com.coz.calabozopixeladodominicano.ui.AmountChooser;
import com.coz.calabozopixeladodominicano.ui.Button;
import com.coz.calabozopixeladodominicano.ui.Icons;
import com.coz.calabozopixeladodominicano.ui.RenderedTextBlock;
import com.coz.calabozopixeladodominicano.ui.ScrollPane;
import com.watabou.noosa.ColorBlock;
import com.watabou.noosa.Game;
import com.watabou.noosa.Image;
import com.watabou.noosa.ui.Component;
import com.watabou.utils.Callback;

import java.text.DecimalFormat;
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


				mob.state = mob.HUNTING;
				mob.enemySeen = true;
				//mob.enemy = Dungeon.hero;
				//mob.state.act(true,false);
				/*mob.enemySeen = true;
				mob.target = Dungeon.hero.pos;
				mob.enemy = Dungeon.hero.pos;
*/
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
				return Messages.titleCase(mob.name()) + mobStatText();
			}

			private String mobStatText(){
				final int TESTS = 500; // I've found with less than 10000, results easily vary by 1 turn
										// however 10000 induces slowdown against powerful enemies
				final int MAX_TURNS = 50000;
				final float INCREMENT = 1f; //This is only useful
				final float PLAYER_ATTACK_DELAY = Dungeon.hero.attackDelay();
				final float MOB_ATTACK_DELAY = mob.attackDelay();


				float pc_win_turns = 0f;
				float pc_win_nomiss_turns = 0f;
				float mob_win_turns = 0f;
				float mob_win_nomiss_turns = 0f;

				float time;
				int hp;

				for(int i = 0; i < TESTS; i++) {
					time = 0f;
					hp = mob.HP;

					while (hp >= 0 && pc_win_turns < MAX_TURNS && time < 60f) {
						if (time > PLAYER_ATTACK_DELAY) {
							pc_win_turns++;

							time -= PLAYER_ATTACK_DELAY;
							boolean hit = Char.hit(Dungeon.hero, mob, false);
							if (hit) {
								hp -= Dungeon.hero.damageRoll();
							}
						}
						time += INCREMENT;
					}
				}
				if(!(pc_win_turns < MAX_TURNS)){
					pc_win_turns = Float.POSITIVE_INFINITY;
				}
				else {
					pc_win_turns /= TESTS;
				}

				for(int i = 0; i < TESTS; i++) {
					time = 0f;
					hp = mob.HP;

					while (hp >= 0 && pc_win_nomiss_turns < MAX_TURNS && time < 60f) {
						if (time > PLAYER_ATTACK_DELAY) {
							pc_win_nomiss_turns++;
							time -= PLAYER_ATTACK_DELAY;
							hp -= Dungeon.hero.damageRoll();
						}
						time += INCREMENT;
					}
				}
				if(!(pc_win_nomiss_turns < MAX_TURNS)){
					pc_win_nomiss_turns = Float.POSITIVE_INFINITY;
				}
				else {
					pc_win_nomiss_turns /= TESTS;
				}

				for(int i = 0; i < TESTS; i++) {
					time = 0f;
					hp = Dungeon.hero.HP;

					while (hp >= 0 && mob_win_turns < MAX_TURNS && time < 60f) {
						if (time > MOB_ATTACK_DELAY) {
							mob_win_turns++;
							time -= MOB_ATTACK_DELAY;
							boolean hit = Char.hit(mob, Dungeon.hero, false);
							if (hit) {
								hp -= mob.damageRoll();
							}
						}
						time += INCREMENT;
					}
				}
				if(!(mob_win_turns < MAX_TURNS)){
					mob_win_turns = Float.POSITIVE_INFINITY;
				}
				else {
					mob_win_turns /= TESTS;
				}

				for(int i = 0; i < TESTS; i++) {
					time = 0f;
					hp = Dungeon.hero.HP;

					while (hp >= 0 && mob_win_nomiss_turns < MAX_TURNS && time < 60f) {
						if (time > MOB_ATTACK_DELAY) {
							mob_win_nomiss_turns++;
							time -= MOB_ATTACK_DELAY;
							hp -= mob.damageRoll();
						}
						time += INCREMENT;
					}
				}
				if(!(mob_win_nomiss_turns < MAX_TURNS)){
					mob_win_nomiss_turns = Float.POSITIVE_INFINITY;
				}
				else {
					mob_win_nomiss_turns /= TESTS;
				}

				DecimalFormat format = new DecimalFormat("#.0");

				return "\nPC wins in " + format.format(pc_win_turns) + " turns"
					+ "\nWith no misses " + format.format(pc_win_nomiss_turns) + " turns"
					+ "\nMob wins in " + format.format(mob_win_turns) + " turns"
					+ "\nWith no misses " + format.format(mob_win_nomiss_turns) + " turns";
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
