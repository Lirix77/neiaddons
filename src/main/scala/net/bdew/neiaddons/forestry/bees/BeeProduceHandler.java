/*
 * Copyright (c) bdew, 2013 - 2015 https://github.com/bdew/neiaddons This mod is distributed under the terms of the
 * Minecraft Mod Public License 1.0, or MMPL. Please check the contents of the license located in
 * http://bdew.net/minecraft-mod-public-license/
 */

package net.bdew.neiaddons.forestry.bees;

import java.util.Collection;
import java.util.Map;

import net.bdew.neiaddons.forestry.BaseProduceRecipeHandler;
import net.minecraft.item.Item;

import forestry.api.apiculture.IAlleleBeeSpecies;
import forestry.api.genetics.IAlleleSpecies;

public class BeeProduceHandler extends BaseProduceRecipeHandler {

    public BeeProduceHandler() {
        super(BeeHelper.root);
    }

    @Override
    public String getRecipeIdent() {
        return "beeproduce";
    }

    @Override
    public Collection<IAlleleBeeSpecies> getAllSpecies() {
        return BeeHelper.allSpecies;
    }

    @Override
    public Map<Item, Collection<IAlleleSpecies>> getProduceCache() {
        return BeeHelper.productsCache;
    }
}
