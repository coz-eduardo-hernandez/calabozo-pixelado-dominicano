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

package com.coz.calabozopixeladodominicano.items.spells;

import com.coz.calabozopixeladodominicano.Assets;
import com.coz.calabozopixeladodominicano.actors.buffs.Buff;
import com.coz.calabozopixeladodominicano.actors.buffs.FlavourBuff;
import com.coz.calabozopixeladodominicano.actors.buffs.Invisibility;
import com.coz.calabozopixeladodominicano.actors.hero.Hero;
import com.coz.calabozopixeladodominicano.effects.Speck;
import com.coz.calabozopixeladodominicano.items.potions.PotionOfLevitation;
import com.coz.calabozopixeladodominicano.messages.Messages;
import com.coz.calabozopixeladodominicano.sprites.ItemSpriteSheet;
import com.coz.calabozopixeladodominicano.ui.BuffIndicator;
import com.coz.calabozopixeladodominicano.utils.GLog;
import com.watabou.noosa.Image;
import com.watabou.noosa.audio.Sample;

public class FeatherFall extends Spell {
	
	{
		image = ItemSpriteSheet.FEATHER_FALL;
	}
	
	@Override
	protected void onCast(Hero hero) {
		Buff.append(hero, FeatherBuff.class, FeatherBuff.DURATION);
		hero.sprite.operate(hero.pos);
		Sample.INSTANCE.play(Assets.Sounds.READ );
		hero.sprite.emitter().burst( Speck.factory( Speck.JET ), 20);
		
		GLog.p(Messages.get(this, "light"));
		
		detach( curUser.belongings.backpack );
		updateQuickslot();
		Invisibility.dispel();
		hero.spendAndNext( 1f );
	}
	
	public static class FeatherBuff extends FlavourBuff {
		//does nothing, just waits to be triggered by chasm falling
		{
			type = buffType.POSITIVE;
		}

		public static final float DURATION	= 30f;

		@Override
		public int icon() {
			return BuffIndicator.LEVITATION;
		}

		@Override
		public void tintIcon(Image icon) {
			icon.hardlight(1f, 2f, 1.25f);
		}

		@Override
		public float iconFadePercent() {
			return Math.max(0, (DURATION - visualcooldown()) / DURATION);
		}
	}
	
	@Override
	public int value() {
		//prices of ingredients, divided by output quantity, rounds down
		return (int)((30 + 40) * (quantity/2f));
	}
	
	public static class Recipe extends com.coz.calabozopixeladodominicano.items.Recipe.SimpleRecipe {
		
		{
			inputs =  new Class[]{PotionOfLevitation.class, ArcaneCatalyst.class};
			inQuantity = new int[]{1, 1};
			
			cost = 8;
			
			output = FeatherFall.class;
			outQuantity = 2;
		}
		
	}
}
