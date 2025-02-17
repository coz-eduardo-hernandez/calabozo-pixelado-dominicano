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
import com.coz.calabozopixeladodominicano.scenes.GameScene;
import com.coz.calabozopixeladodominicano.ui.BuffIndicator;
import com.watabou.noosa.Image;

public class MagicalSight extends FlavourBuff {
	
	public static final float DURATION = 50f;
	
	public static final int DISTANCE = 12;
	
	{
		type = buffType.POSITIVE;
	}
	
	@Override
	public int icon() {
		return BuffIndicator.MIND_VISION;
	}

	@Override
	public void tintIcon(Image icon) {
		icon.hardlight(1f, 1.67f, 1f);
	}

	@Override
	public float iconFadePercent() {
		return Math.max(0, (DURATION - visualcooldown()) / DURATION);
	}

	@Override
	public boolean attachTo(Char target) {
		if (super.attachTo(target)){
			Buff.detach(target, Blindness.class);
			return true;
		}
		return false;
	}

	@Override
	public void detach() {
		super.detach();
		Dungeon.observe();
		GameScene.updateFog();
	}

	{
		immunities.add(Blindness.class);
	}
}
