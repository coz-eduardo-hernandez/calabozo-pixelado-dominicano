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

package com.coz.calabozopixeladodominicano.items.weapon.melee;

import com.coz.calabozopixeladodominicano.Assets;
import com.coz.calabozopixeladodominicano.Dungeon;
import com.coz.calabozopixeladodominicano.actors.Actor;
import com.coz.calabozopixeladodominicano.actors.Char;
import com.coz.calabozopixeladodominicano.actors.buffs.Buff;
import com.coz.calabozopixeladodominicano.actors.buffs.FlavourBuff;
import com.coz.calabozopixeladodominicano.actors.buffs.Invisibility;
import com.coz.calabozopixeladodominicano.actors.hero.Hero;
import com.coz.calabozopixeladodominicano.messages.Messages;
import com.coz.calabozopixeladodominicano.sprites.ItemSpriteSheet;
import com.coz.calabozopixeladodominicano.ui.AttackIndicator;
import com.coz.calabozopixeladodominicano.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Callback;

public class Sickle extends MeleeWeapon {

	{
		image = ItemSpriteSheet.SICKLE;
		hitSound = Assets.Sounds.HIT_SLASH;
		hitSoundPitch = 1f;

		tier = 2;
		ACC = 0.68f; //32% penalty to accuracy
	}

	@Override
	public int max(int lvl) {
		return  Math.round(6.67f*(tier+1)) +    //20 base, up from 15
				lvl*(tier+1);                   //scaling unchanged
	}

	@Override
	protected int baseChargeUse(Hero hero, Char target){
		return 2;
	}

	@Override
	public String targetingPrompt() {
		return Messages.get(this, "prompt");
	}

	@Override
	protected void duelistAbility(Hero hero, Integer target) {
		harvestAbility(hero, target, 1f, this);
	}

	public static void harvestAbility(Hero hero, Integer target, float bleedFactor, MeleeWeapon wep){

		if (target == null) {
			return;
		}

		Char enemy = Actor.findChar(target);
		if (enemy == null || enemy == hero || hero.isCharmedBy(enemy) || !Dungeon.level.heroFOV[target]) {
			GLog.w(Messages.get(wep, "ability_no_target"));
			return;
		}

		hero.belongings.abilityWeapon = wep;
		if (!hero.canAttack(enemy)){
			GLog.w(Messages.get(wep, "ability_bad_position"));
			hero.belongings.abilityWeapon = null;
			return;
		}
		hero.belongings.abilityWeapon = null;

		hero.sprite.attack(enemy.pos, new Callback() {
			@Override
			public void call() {
				wep.beforeAbilityUsed(hero, enemy);
				AttackIndicator.target(enemy);

				Buff.affect(enemy, HarvestBleedTracker.class, 0).bleedFactor = bleedFactor;
				if (hero.attack(enemy, 1, 0, Char.INFINITE_ACCURACY)){
					Sample.INSTANCE.play(Assets.Sounds.HIT_STRONG);
				}

				Invisibility.dispel();
				hero.spendAndNext(hero.attackDelay());
				if (!enemy.isAlive()){
					wep.onAbilityKill(hero, enemy);
					Buff.prolong(hero, Sword.CleaveTracker.class, 5f);
				} else {
					if (hero.buff(Sword.CleaveTracker.class) != null) {
						hero.buff(Sword.CleaveTracker.class).detach();
					}
				}
				wep.afterAbilityUsed(hero);
			}
		});

	}

	public static class HarvestBleedTracker extends FlavourBuff{
		public float bleedFactor;
	};

}
