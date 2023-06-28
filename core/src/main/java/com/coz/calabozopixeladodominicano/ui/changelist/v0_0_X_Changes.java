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

package com.coz.calabozopixeladodominicano.ui.changelist;

import com.coz.calabozopixeladodominicano.scenes.PixelScene;
import com.coz.calabozopixeladodominicano.ui.Icons;
import com.coz.calabozopixeladodominicano.ui.RenderedTextBlock;
import com.coz.calabozopixeladodominicano.ui.Window;

import java.util.ArrayList;

public class v0_0_X_Changes {

	public static void addAllChanges( ArrayList<ChangeInfo> changeInfos ){

		ChangeInfo changes = new ChangeInfo( "v0.0.X", true, "");
		changes.hardlight( Window.TITLE_COLOR);
		changeInfos.add(changes);

		add_v0_0_1_Changes(changeInfos);
	}

	public static void add_v0_0_1_Changes( ArrayList<ChangeInfo> changeInfos ){

		ChangeInfo changes = new ChangeInfo("v0.0.1", false, "");
		changes.hardlight(Window.TITLE_COLOR);
		changeInfos.add(changes);

		changes.addButton( new ChangeButton(Icons.get(Icons.SHPX), "Developer Commentary",
				"_-_ New title image\n" +
				"1.\n"
		));
	}

}
