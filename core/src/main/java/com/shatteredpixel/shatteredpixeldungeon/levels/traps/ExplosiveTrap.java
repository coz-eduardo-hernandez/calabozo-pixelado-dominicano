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

package com.shatteredpixel.shatteredpixeldungeon.levels.traps;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Badges;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Actor;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Blindness;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Cripple;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Vertigo;
import com.shatteredpixel.shatteredpixeldungeon.effects.CellEmitter;
import com.shatteredpixel.shatteredpixeldungeon.effects.particles.BlastParticle;
import com.shatteredpixel.shatteredpixeldungeon.effects.particles.SmokeParticle;
import com.shatteredpixel.shatteredpixeldungeon.items.Heap;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.Bomb;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;

import java.util.ArrayList;

public class ExplosiveTrap extends Trap {

	{
		color = ORANGE;
		shape = DIAMOND;
	}

	@Override
	public void activate() {

		Sample.INSTANCE.play( Assets.Sounds.BLAST );

		ArrayList<Char> affected = new ArrayList<>();

		if (Dungeon.level.heroFOV[pos]) {
			CellEmitter.center(pos).burst(BlastParticle.FACTORY, 30);
		}

		boolean terrainAffected = false;
		for (int n : PathFinder.NEIGHBOURS9) {
			int c = pos + n;
			if (c >= 0 && c < Dungeon.level.length()) {
				if (Dungeon.level.heroFOV[c]) {
					CellEmitter.get(c).burst(SmokeParticle.FACTORY, 4);
				}

				if (Dungeon.level.flamable[c]) {
					Dungeon.level.destroy(c);
					GameScene.updateMap(c);
					terrainAffected = true;
				}

				//destroys items / triggers bombs caught in the blast.
				Heap heap = Dungeon.level.heaps.get(c);
				if (heap != null)
					heap.explode();

				Char ch = Actor.findChar(c);
				if (ch != null) {
					affected.add(ch);
				}
			}
		}

		for (Char ch : affected){

			//if they have already been killed by another bomb
			if(!ch.isAlive()){
				continue;
			}

			int dmg = Random.NormalIntRange(5 + Dungeon.scalingDepth(), 10 + Dungeon.scalingDepth()*2);

			//those not at the center of the blast take less damage
			if (ch.pos != pos){
				dmg = Math.round(dmg*0.67f);
			}

			dmg -= ch.drRoll();

			if (dmg > 0) {
				ch.damage(dmg, this);
			}

			Buff.affect(ch, Vertigo.class, 2);
			Buff.affect(ch, Blindness.class, 2);
			Buff.affect(ch, Cripple.class, 2);

			if (ch == Dungeon.hero && !ch.isAlive()) {
				GLog.n(Messages.get(this, "ondeath"));
				Dungeon.fail(this);
			}
		}

		if (terrainAffected) {
			Dungeon.observe();
		}
	}

}
