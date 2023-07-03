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

public class v0_1_X_Changes {

	public static void addAllChanges( ArrayList<ChangeInfo> changeInfos ){

		ChangeInfo changes = new ChangeInfo( "v0.1.X", true, "");
		changes.hardlight( Window.TITLE_COLOR);
		changeInfos.add(changes);

		add_v0_0_1_Changes(changeInfos);
	}

	public static void add_v0_0_1_Changes( ArrayList<ChangeInfo> changeInfos ){

		ChangeInfo changes = new ChangeInfo("v0.1.0", false, "");
		changes.hardlight(Window.TITLE_COLOR);
		changeInfos.add(changes);

		changes.addButton( new ChangeButton(Icons.get(Icons.SHPX), "Developer Commentary",
				"\n" +
						"_== Clases ==_\n\n" +
						"- Cada clase empieza con un inventario diferente\n\n" +
						"- Cada clase empieza con diferentes attributos (puntos de salud, fuerza, exactitud y evasión)" +
						"\n\n" +
						"- Cada clase gana diferentes attributos al subir de nivel\n\n" +
						"- Los objetos identificado al principio por cada clase han cambiado\n\n" +
						"- Removidos los talentos\n\n" +
						"- Removidas algunas medallas\n\n" +
						"- Removidas las subclases y las abilidades de armadura\n\n" +
						"- Tengu y el Rey enano no sueltan sus objetos (temporalmente)\n\n\n" +
						"_== Creaturas ==_\n\n" +
						"- Las creaturas dormidas despiertan si otra creatura cercana es atacada\n\n" +
						"- Las mímicas y mímicas doradas son más fuertes pero más lentas\n\n\n" +
						"_== Objetos ==_\n\n" +
						"- El sello roto tiene un aumento del escudo máximo según el nivel del personaje del " +
						"jugador\n\n" +
						"- El bastón del mago tiene una reducción de su requisito de fuerza a 9, la tasa de carga " +
						"aumentó, el número de cargas iniciales es 7 con un límite máximo de 20, el daño físico se ha " +
						"reducido de 6 a 4\n\n" +
						"- Las pociones de fuerza y los pergaminos de mejora no están garantizados, pero pueden " +
						"generarse raramente\n\n" +
						"- Armadura de tela tiene requisito de fuerza reducido a 9\n\n" +
						"- La capacidad de almacenamiento de los contenedores ha sido reducida\n\n" +
						"- Las bombas siempre hacen 25 a 60 daño (similar a su daño a profundidad 25 en SPD) y causan " +
						"vertigo, ceguera y cojera por dos turnos\n\n" +
						"- El pícaro no empieza con la capa de sombras, pero puede ser encontrada como cualquier otro " +
						"artefacto; además, las cargas iniciales de la capa de sombras se han reducido a 1\n\n" +
						"- Los dardos requieren sólo 8 de fuerza, y los dardos reforzados requieren 10 de fuerza\n\n\n" +
						"_== Calabozo ==_\n\n" +
						"- Las trampas explosivas ahora causan vertigo, ceguera y cojera por tres turnos"
		));
	}

}
