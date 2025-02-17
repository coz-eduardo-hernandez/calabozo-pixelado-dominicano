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

import com.coz.calabozopixeladodominicano.items.Item;
import com.coz.calabozopixeladodominicano.messages.Messages;
import com.coz.calabozopixeladodominicano.scenes.ChangesScene;
import com.coz.calabozopixeladodominicano.scenes.PixelScene;
import com.coz.calabozopixeladodominicano.sprites.ItemSprite;
import com.watabou.noosa.Image;
import com.watabou.noosa.ui.Component;

//not actually a button, but functions as one.
public class ChangeButton extends Component {
	
	protected Image icon;
	protected String title;
	protected String[] messages;
	
	public ChangeButton( Image icon, String title, String... messages){
		super();
		
		this.icon = icon;
		add(this.icon);
		
		this.title = Messages.titleCase(title);
		this.messages = messages;
		
		layout();
	}

	protected void onClick() {
		ChangesScene.showChangeInfo(new Image(icon), title, messages);
	}
	
	@Override
	protected void layout() {
		super.layout();

		icon.x = x + (width - icon.width()) / 2f;
		icon.y = y + (height - icon.height()) / 2f;
		PixelScene.align(icon);
	}
}
