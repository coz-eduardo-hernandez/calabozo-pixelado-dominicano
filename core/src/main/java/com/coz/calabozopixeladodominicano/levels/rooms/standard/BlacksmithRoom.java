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

package com.coz.calabozopixeladodominicano.levels.rooms.standard;

import com.coz.calabozopixeladodominicano.Assets;
import com.coz.calabozopixeladodominicano.Dungeon;
import com.coz.calabozopixeladodominicano.actors.mobs.npcs.Blacksmith;
import com.coz.calabozopixeladodominicano.items.Generator;
import com.coz.calabozopixeladodominicano.levels.Level;
import com.coz.calabozopixeladodominicano.levels.Terrain;
import com.coz.calabozopixeladodominicano.levels.features.LevelTransition;
import com.coz.calabozopixeladodominicano.levels.painters.Painter;
import com.coz.calabozopixeladodominicano.levels.traps.BurningTrap;
import com.coz.calabozopixeladodominicano.tiles.CustomTilemap;

import com.watabou.noosa.Tilemap;
import com.watabou.utils.Point;
import com.watabou.utils.Random;

public class BlacksmithRoom extends StandardRoom {
	
	@Override
	public int minWidth() {
		return Math.max(super.minWidth(), 6);
	}
	
	@Override
	public int minHeight() {
		return Math.max(super.minHeight(), 6);
	}
	
	public void paint(Level level ) {

		Painter.fill( level, this, Terrain.WALL );
		Painter.fill( level, this, 1, Terrain.TRAP );
		Painter.fill( level, this, 2, Terrain.EMPTY_SP );
		
		for (int i=0; i < 2; i++) {
			int pos;
			do {
				pos = level.pointToCell(random());
			} while (level.map[pos] != Terrain.EMPTY_SP);
			level.drop(
				Generator.random( Random.oneOf(
					Generator.Category.ARMOR,
					Generator.Category.WEAPON,
					Generator.Category.MISSILE
				) ), pos );
		}
		
		for (Door door : connected.values()) {
			door.set( Door.Type.REGULAR );
			Painter.drawInside( level, this, door, 1, Terrain.EMPTY );
		}
		
		Blacksmith npc = new Blacksmith();
		do {
			npc.pos = level.pointToCell(random( 2 ));
		} while (level.heaps.get( npc.pos ) != null);
		level.mobs.add( npc );

		// TODO need to add some better visuals here (even just a simple custom asset)
		Random.pushGenerator(Dungeon.seedCurDepth()+1);
			int entrancePos;
			do {
				entrancePos = level.pointToCell(random( 2 ));
			} while (level.heaps.get( npc.pos ) != null || entrancePos == npc.pos);
		Random.popGenerator();

		QuestEntrance vis = new QuestEntrance();
		vis.pos(entrancePos, level);
		level.customTiles.add(vis);

		level.transitions.add(new LevelTransition(level,
				entrancePos,
				LevelTransition.Type.BRANCH_EXIT,
				Dungeon.depth,
				Dungeon.branch+1,
				LevelTransition.Type.BRANCH_ENTRANCE));
		Painter.set(level, entrancePos, Terrain.EXIT);

		for(Point p : getPoints()) {
			int cell = level.pointToCell(p);
			if (level.map[cell] == Terrain.TRAP){
				level.setTrap(new BurningTrap().reveal(), cell);
			}
		}
	}

	public static class QuestEntrance extends CustomTilemap {

		{
			texture = Assets.Environment.CAVES_QUEST;

			tileW = tileH = 1;
		}

		@Override
		public Tilemap create() {
			Tilemap v = super.create();
			v.map( new int[]{0}, 1 );
			return v;
		}

		//TODO add some text here in v2.2.0
	}
}
