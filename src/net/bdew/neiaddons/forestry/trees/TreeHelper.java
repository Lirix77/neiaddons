package net.bdew.neiaddons.forestry.trees;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.bdew.neiaddons.forestry.AddonForestry;
import net.bdew.neiaddons.forestry.GeneticsUtils;
import net.minecraft.item.ItemStack;
import codechicken.nei.api.API;
import forestry.api.arboriculture.EnumGermlingType;
import forestry.api.arboriculture.IAlleleTreeSpecies;
import forestry.api.arboriculture.ITreeRoot;
import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.IAlleleSpecies;

public class TreeHelper {
    private static TreeBreedingHandler breedingRecipeHandler;
    private static TreeProduceHandler produceRecipeHandler;

    public static Collection<IAlleleTreeSpecies> allSpecies;
    public static Map<Integer, Collection<IAlleleSpecies>> productsCache;

    public static ITreeRoot root;

    private static void addProductToCache(int id, IAlleleTreeSpecies species) {
        if (!productsCache.containsKey(id)) {
            productsCache.put(id, new ArrayList<IAlleleSpecies>());
        }
        productsCache.get(id).add(species);
    }

    public static void setup() {
        root = (ITreeRoot) AlleleManager.alleleRegistry.getSpeciesRoot("rootTrees");
        allSpecies = GeneticsUtils.getAllTreeSpecies(AddonForestry.loadBlacklisted);

        breedingRecipeHandler = new TreeBreedingHandler();
        API.registerRecipeHandler(breedingRecipeHandler);
        API.registerUsageHandler(breedingRecipeHandler);
        AddonForestry.instance.registerWithNEIPlugins(breedingRecipeHandler.getRecipeName(), breedingRecipeHandler.getRecipeIdent());

        produceRecipeHandler = new TreeProduceHandler();
        API.registerRecipeHandler(produceRecipeHandler);
        API.registerUsageHandler(produceRecipeHandler);
        AddonForestry.instance.registerWithNEIPlugins(produceRecipeHandler.getRecipeName(), produceRecipeHandler.getRecipeIdent());
        
        productsCache = new HashMap<Integer, Collection<IAlleleSpecies>>();

        for (IAlleleTreeSpecies species : allSpecies) {
            if (AddonForestry.addSaplings) {
                API.addNBTItem(GeneticsUtils.stackFromSpecies(species, EnumGermlingType.SAPLING.ordinal()));
            }
            if (AddonForestry.addPollen) {
                API.addNBTItem(GeneticsUtils.stackFromSpecies(species, EnumGermlingType.POLLEN.ordinal()));
            }
            for (ItemStack prod : GeneticsUtils.getProduceFromSpecies(species).keySet()) {
                addProductToCache(prod.itemID, species);
            }
            for (ItemStack prod : GeneticsUtils.getSpecialtyFromSpecies(species).keySet()) {
                addProductToCache(prod.itemID, species);
            }
        };
        
    }}
