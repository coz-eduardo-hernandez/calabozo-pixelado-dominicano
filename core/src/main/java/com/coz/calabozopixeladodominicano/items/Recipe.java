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

package com.coz.calabozopixeladodominicano.items;

import com.coz.calabozopixeladodominicano.CalabozoPixeladoDominicano;
import com.coz.calabozopixeladodominicano.items.bombs.Bomb;
import com.coz.calabozopixeladodominicano.items.food.Blandfruit;
import com.coz.calabozopixeladodominicano.items.food.MeatPie;
import com.coz.calabozopixeladodominicano.items.food.StewedMeat;
import com.coz.calabozopixeladodominicano.items.potions.AlchemicalCatalyst;
import com.coz.calabozopixeladodominicano.items.potions.Potion;
import com.coz.calabozopixeladodominicano.items.potions.brews.BlizzardBrew;
import com.coz.calabozopixeladodominicano.items.potions.brews.CausticBrew;
import com.coz.calabozopixeladodominicano.items.potions.brews.InfernalBrew;
import com.coz.calabozopixeladodominicano.items.potions.brews.ShockingBrew;
import com.coz.calabozopixeladodominicano.items.potions.elixirs.ElixirOfAquaticRejuvenation;
import com.coz.calabozopixeladodominicano.items.potions.elixirs.ElixirOfArcaneArmor;
import com.coz.calabozopixeladodominicano.items.potions.elixirs.ElixirOfDragonsBlood;
import com.coz.calabozopixeladodominicano.items.potions.elixirs.ElixirOfHoneyedHealing;
import com.coz.calabozopixeladodominicano.items.potions.elixirs.ElixirOfIcyTouch;
import com.coz.calabozopixeladodominicano.items.potions.elixirs.ElixirOfMight;
import com.coz.calabozopixeladodominicano.items.potions.elixirs.ElixirOfToxicEssence;
import com.coz.calabozopixeladodominicano.items.potions.exotic.ExoticPotion;
import com.coz.calabozopixeladodominicano.items.scrolls.Scroll;
import com.coz.calabozopixeladodominicano.items.scrolls.exotic.ExoticScroll;
import com.coz.calabozopixeladodominicano.items.spells.Alchemize;
import com.coz.calabozopixeladodominicano.items.spells.AquaBlast;
import com.coz.calabozopixeladodominicano.items.spells.ArcaneCatalyst;
import com.coz.calabozopixeladodominicano.items.spells.BeaconOfReturning;
import com.coz.calabozopixeladodominicano.items.spells.CurseInfusion;
import com.coz.calabozopixeladodominicano.items.spells.FeatherFall;
import com.coz.calabozopixeladodominicano.items.spells.MagicalInfusion;
import com.coz.calabozopixeladodominicano.items.spells.PhaseShift;
import com.coz.calabozopixeladodominicano.items.spells.ReclaimTrap;
import com.coz.calabozopixeladodominicano.items.spells.Recycle;
import com.coz.calabozopixeladodominicano.items.spells.SummonElemental;
import com.coz.calabozopixeladodominicano.items.spells.TelekineticGrab;
import com.coz.calabozopixeladodominicano.items.spells.WildEnergy;
import com.coz.calabozopixeladodominicano.items.wands.Wand;
import com.coz.calabozopixeladodominicano.items.weapon.missiles.MissileWeapon;
import com.watabou.utils.CPDExceptionManager;
import com.watabou.utils.Reflection;

import java.util.ArrayList;

public abstract class Recipe {
	
	public abstract boolean testIngredients(ArrayList<Item> ingredients);
	
	public abstract int cost(ArrayList<Item> ingredients);
	
	public abstract Item brew(ArrayList<Item> ingredients);
	
	public abstract Item sampleOutput(ArrayList<Item> ingredients);
	
	//subclass for the common situation of a recipe with static inputs and outputs
	public static abstract class SimpleRecipe extends Recipe {
		
		//*** These elements must be filled in by subclasses
		protected Class<?extends Item>[] inputs; //each class should be unique
		protected int[] inQuantity;
		
		protected int cost;
		
		protected Class<?extends Item> output;
		protected int outQuantity;
		//***
		
		//gets a simple list of items based on inputs
		public ArrayList<Item> getIngredients() {
			ArrayList<Item> result = new ArrayList<>();
			for (int i = 0; i < inputs.length; i++) {
				Item ingredient = Reflection.newInstance(inputs[i]);
				ingredient.quantity(inQuantity[i]);
				result.add(ingredient);
			}
			return result;
		}
		
		@Override
		public final boolean testIngredients(ArrayList<Item> ingredients) {
			
			int[] needed = inQuantity.clone();
			
			for (Item ingredient : ingredients){
				if (!ingredient.isIdentified()) return false;
				for (int i = 0; i < inputs.length; i++){
					if (ingredient.getClass() == inputs[i]){
						needed[i] -= ingredient.quantity();
						break;
					}
				}
			}
			
			for (int i : needed){
				if (i > 0){
					return false;
				}
			}
			
			return true;
		}
		
		public final int cost(ArrayList<Item> ingredients){
			return cost;
		}
		
		@Override
		public final Item brew(ArrayList<Item> ingredients) {
			if (!testIngredients(ingredients)) return null;
			
			int[] needed = inQuantity.clone();
			
			for (Item ingredient : ingredients){
				for (int i = 0; i < inputs.length; i++) {
					if (ingredient.getClass() == inputs[i] && needed[i] > 0) {
						if (needed[i] <= ingredient.quantity()) {
							ingredient.quantity(ingredient.quantity() - needed[i]);
							needed[i] = 0;
						} else {
							needed[i] -= ingredient.quantity();
							ingredient.quantity(0);
						}
					}
				}
			}
			
			//sample output and real output are identical in this case.
			return sampleOutput(null);
		}
		
		//ingredients are ignored, as output doesn't vary
		public final Item sampleOutput(ArrayList<Item> ingredients){
			try {
				Item result = Reflection.newInstance(output);
				result.quantity(outQuantity);
				return result;
			} catch (Exception e) {
				CPDExceptionManager.report( e );
				return null;
			}
		}
	}
	
	
	//*******
	// Static members
	//*******

	private static Recipe[] variableRecipes = new Recipe[]{
			new LiquidMetal.Recipe()
	};
	
	private static Recipe[] oneIngredientRecipes = new Recipe[]{
		new Scroll.ScrollToStone(),
		new ExoticPotion.PotionToExotic(),
		new ExoticScroll.ScrollToExotic(),
		new ArcaneResin.Recipe(),
		new Alchemize.Recipe(),
		new StewedMeat.oneMeat()
	};
	
	private static Recipe[] twoIngredientRecipes = new Recipe[]{
		new Blandfruit.CookFruit(),
		new Bomb.EnhanceBomb(),
		new AlchemicalCatalyst.Recipe(),
		new ArcaneCatalyst.Recipe(),
		new ElixirOfArcaneArmor.Recipe(),
		new ElixirOfAquaticRejuvenation.Recipe(),
		new ElixirOfDragonsBlood.Recipe(),
		new ElixirOfIcyTouch.Recipe(),
		new ElixirOfMight.Recipe(),
		new ElixirOfHoneyedHealing.Recipe(),
		new ElixirOfToxicEssence.Recipe(),
		new BlizzardBrew.Recipe(),
		new InfernalBrew.Recipe(),
		new ShockingBrew.Recipe(),
		new CausticBrew.Recipe(),
		new AquaBlast.Recipe(),
		new BeaconOfReturning.Recipe(),
		new CurseInfusion.Recipe(),
		new FeatherFall.Recipe(),
		new MagicalInfusion.Recipe(),
		new PhaseShift.Recipe(),
		new ReclaimTrap.Recipe(),
		new Recycle.Recipe(),
		new WildEnergy.Recipe(),
		new TelekineticGrab.Recipe(),
		new SummonElemental.Recipe(),
		new StewedMeat.twoMeat()
	};
	
	private static Recipe[] threeIngredientRecipes = new Recipe[]{
		new Potion.SeedToPotion(),
		new StewedMeat.threeMeat(),
		new MeatPie.Recipe()
	};
	
	public static ArrayList<Recipe> findRecipes(ArrayList<Item> ingredients){

		ArrayList<Recipe> result = new ArrayList<>();

		for (Recipe recipe : variableRecipes){
			if (recipe.testIngredients(ingredients)){
				result.add(recipe);
			}
		}

		if (ingredients.size() == 1){
			for (Recipe recipe : oneIngredientRecipes){
				if (recipe.testIngredients(ingredients)){
					result.add(recipe);
				}
			}
			
		} else if (ingredients.size() == 2){
			for (Recipe recipe : twoIngredientRecipes){
				if (recipe.testIngredients(ingredients)){
					result.add(recipe);
				}
			}
			
		} else if (ingredients.size() == 3){
			for (Recipe recipe : threeIngredientRecipes){
				if (recipe.testIngredients(ingredients)){
					result.add(recipe);
				}
			}
		}
		
		return result;
	}
	
	public static boolean usableInRecipe(Item item){
		if (item instanceof EquipableItem){
			//only thrown weapons and wands allowed among equipment items
			return item.isIdentified() && !item.cursed && item instanceof MissileWeapon;
		} else if (item instanceof Wand) {
			return item.isIdentified() && !item.cursed;
		} else {
			//other items can be unidentified, but not cursed
			return !item.cursed;
		}
	}
}


