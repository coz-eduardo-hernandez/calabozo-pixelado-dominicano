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

import com.coz.calabozopixeladodominicano.Dungeon;
import com.coz.calabozopixeladodominicano.actors.Char;
import com.coz.calabozopixeladodominicano.actors.hero.Hero;
import com.coz.calabozopixeladodominicano.actors.hero.Talent;
import com.coz.calabozopixeladodominicano.items.artifacts.CloakOfShadows;
import com.coz.calabozopixeladodominicano.items.artifacts.TimekeepersHourglass;
import com.coz.calabozopixeladodominicano.plants.Swiftthistle;
import com.coz.calabozopixeladodominicano.sprites.CharSprite;
import com.coz.calabozopixeladodominicano.ui.BuffIndicator;

public class Invisibility extends FlavourBuff {

	public static final float DURATION	= 20f;

	{
		type = buffType.POSITIVE;
		announced = true;
	}
	
	@Override
	public boolean attachTo( Char target ) {
		if (super.attachTo( target )) {
			target.invisible++;
			/*if (target instanceof Hero && ((Hero) target).subClass == HeroSubClass.ASSASSIN){
				Buff.affect(target, Preparation.class);
			}*/
			if (target instanceof Hero && ((Hero) target).hasTalent(Talent.PROTECTIVE_SHADOWS)){
				Buff.affect(target, Talent.ProtectiveShadowsTracker.class);
			}
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void detach() {
		if (target.invisible > 0)
			target.invisible--;
		super.detach();
	}
	
	@Override
	public int icon() {
		return BuffIndicator.INVISIBLE;
	}

	@Override
	public float iconFadePercent() {
		return Math.max(0, (DURATION - visualcooldown()) / DURATION);
	}

	@Override
	public void fx(boolean on) {
		if (on) target.sprite.add( CharSprite.State.INVISIBLE );
		else if (target.invisible == 0) target.sprite.remove( CharSprite.State.INVISIBLE );
	}

	public static void dispel() {
		if (Dungeon.hero == null) return;

		dispel(Dungeon.hero);
	}

	public static void dispel(Char ch){

		for ( Buff invis : ch.buffs( Invisibility.class )){
			invis.detach();
		}
		CloakOfShadows.cloakStealth cloakBuff = ch.buff( CloakOfShadows.cloakStealth.class );
		if (cloakBuff != null) {
			cloakBuff.dispel();
		}

		//these aren't forms of invisibility, but do dispel at the same time as it.
		TimekeepersHourglass.timeFreeze timeFreeze = ch.buff( TimekeepersHourglass.timeFreeze.class );
		if (timeFreeze != null) {
			timeFreeze.detach();
		}

		Preparation prep = ch.buff( Preparation.class );
		if (prep != null){
			prep.detach();
		}

		Swiftthistle.TimeBubble bubble =  ch.buff( Swiftthistle.TimeBubble.class );
		if (bubble != null){
			bubble.detach();
		}
	}
}
