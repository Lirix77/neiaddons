/*
 * Copyright (c) bdew, 2013 - 2015 https://github.com/bdew/neiaddons This mod is distributed under the terms of the
 * Minecraft Mod Public License 1.0, or MMPL. Please check the contents of the license located in
 * http://bdew.net/minecraft-mod-public-license/
 */

package net.bdew.neiaddons.forestry.trees;

import java.util.Collection;
import java.util.Map;

import net.bdew.neiaddons.forestry.BaseProduceRecipeHandler;
import net.minecraft.item.Item;

import forestry.api.arboriculture.IAlleleTreeSpecies;
import forestry.api.genetics.IAlleleSpecies;

public class TreeProduceHandler extends BaseProduceRecipeHandler {

    public TreeProduceHandler() {
        super(TreeHelper.root);
    }

    @Override
    public String getRecipeIdent() {
        return "treeproduce";
    }

    @Override
    public Collection<IAlleleTreeSpecies> getAllSpecies() {
        return TreeHelper.allSpecies;
    }

    @Override
    public Map<Item, Collection<IAlleleSpecies>> getProduceCache() {
        return TreeHelper.productsCache;
    }
}
