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

package com.coz.calabozopixeladodominicano.actors.buffs;

import com.coz.calabozopixeladodominicano.Badges;
import com.coz.calabozopixeladodominicano.Statistics;
import com.coz.calabozopixeladodominicano.actors.Char;
import com.coz.calabozopixeladodominicano.actors.hero.Hero;
import com.coz.calabozopixeladodominicano.actors.mobs.Mob;
import com.coz.calabozopixeladodominicano.messages.Messages;
import com.coz.calabozopixeladodominicano.sprites.CharSprite;

//generic class for buffs which convert an enemy into an ally
// There is a decent amount of logic that ties into this, which is why it has its own abstract class
public abstract class AllyBuff extends Buff{

	@Override
	public boolean attachTo(Char target) {
		if (super.attachTo(target)){
			target.alignment = Char.Alignment.ALLY;
			if (target.buff(PinCushion.class) != null){
				target.buff(PinCushion.class).detach();
			}
			return true;
		} else {
			return false;
		}
	}

	//for when applying an ally buff should also cause that enemy to give exp/loot as if they had died
	//consider that chars with the ally alignment do not drop items or award exp on death
	public static void affectAndLoot(Mob enemy, Hero hero, Class<?extends AllyBuff> buffCls){
		boolean wasEnemy = enemy.alignment == Char.Alignment.ENEMY;
		Buff.affect(enemy, buffCls);

		if (enemy.buff(buffCls) != null && wasEnemy){
			enemy.rollToDropLoot();

			Statistics.enemiesSlain++;
			Badges.validateMonstersSlain();
			Statistics.qualifiedForNoKilling = false;

			AscensionChallenge.processEnemyKill(enemy);

			int exp = hero.lvl <= enemy.maxLvl ? enemy.EXP : 0;
			if (exp > 0) {
				hero.sprite.showStatus(CharSprite.POSITIVE, Messages.get(enemy, "exp", exp));
			}
			hero.earnExp(exp, enemy.getClass());

			/*if (hero.subClass == HeroSubClass.MONK){
				Buff.affect(hero, MonkEnergy.class).gainEnergy(enemy);
			}*/
		}
	}

}
