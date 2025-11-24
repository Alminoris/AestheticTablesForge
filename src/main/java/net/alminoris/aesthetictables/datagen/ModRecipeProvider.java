package net.alminoris.aesthetictables.datagen;

import net.alminoris.aesthetictables.block.ModBlocks;
import net.alminoris.aesthetictables.item.ModItemGroups;
import net.alminoris.aesthetictables.util.helper.BlockSetsHelper;
import net.alminoris.aesthetictables.util.helper.ModJsonHelper;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;


import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    public ModRecipeProvider(DataGenerator pOutput)
    {
        super(pOutput);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> recipeExporter)
    {
        for(String name : BlockSetsHelper.WOODS)
        {
            Block block = ForgeRegistries.BLOCKS.getValue(ResourceLocation.withDefaultNamespace(name+"_planks"));

            stonecutterResultFromBase(recipeExporter, ModBlocks.TABLES.get(name).get(), block, 1);
            stonecutterResultFromBase(recipeExporter, ModBlocks.COFFEE_TABLES.get(name).get(), block, 1);
            stonecutterResultFromBase(recipeExporter, ModBlocks.GARDEN_TABLES.get(name).get(), block, 1);
            stonecutterResultFromBase(recipeExporter, ModBlocks.OCTAGONAL_TABLES.get(name).get(), block, 1);
            stonecutterResultFromBase(recipeExporter, ModBlocks.DINING_TABLES.get(name).get(), block, 1);
            stonecutterResultFromBase(recipeExporter, ModBlocks.DESK_TABLES.get(name).get(), block, 1);
            stonecutterResultFromBase(recipeExporter, ModBlocks.KITCHEN_TABLES.get(name).get(), block, 1);
        }

        for(String name : ModItemGroups.AN_WOOD_NAMES)
        {
            ModJsonHelper.createStonecuttingRecipe("arborealnature:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("arborealnature:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.COFFEE_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("arborealnature:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.GARDEN_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("arborealnature:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.OCTAGONAL_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("arborealnature:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.DINING_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("arborealnature:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.DESK_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("arborealnature:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.KITCHEN_TABLES.get(name).get()).getPath(), "1");
        }

        for(String name : ModItemGroups.WF_WOOD_NAMES)
        {
            ModJsonHelper.createStonecuttingRecipe("wildfields:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("wildfields:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.COFFEE_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("wildfields:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.GARDEN_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("wildfields:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.OCTAGONAL_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("wildfields:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.DINING_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("wildfields:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.DESK_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("wildfields:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.KITCHEN_TABLES.get(name).get()).getPath(), "1");
        }

        for(String name : ModItemGroups.WT_WOOD_NAMES)
        {
            ModJsonHelper.createStonecuttingRecipe("whisperleaftrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("whisperleaftrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.COFFEE_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("whisperleaftrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.GARDEN_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("whisperleaftrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.OCTAGONAL_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("whisperleaftrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.DINING_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("whisperleaftrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.DESK_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("whisperleaftrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.KITCHEN_TABLES.get(name).get()).getPath(), "1");
        }

        for(String name : ModItemGroups.ST_WOOD_NAMES)
        {
            ModJsonHelper.createStonecuttingRecipe("silverwoodtrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("silverwoodtrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.COFFEE_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("silverwoodtrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.GARDEN_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("silverwoodtrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.OCTAGONAL_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("silverwoodtrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.DINING_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("silverwoodtrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.DESK_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("silverwoodtrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.KITCHEN_TABLES.get(name).get()).getPath(), "1");
        }

        for(String name : ModItemGroups.MT_WOOD_NAMES)
        {
            ModJsonHelper.createStonecuttingRecipe("missingtrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("missingtrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.COFFEE_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("missingtrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.GARDEN_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("missingtrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.OCTAGONAL_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("missingtrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.DINING_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("missingtrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.DESK_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("missingtrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.KITCHEN_TABLES.get(name).get()).getPath(), "1");
        }

        for(String name : ModItemGroups.NSS_WOOD_NAMES)
        {
            ModJsonHelper.createStonecuttingRecipe("natures_spirit:"+name.replace("_nss", "")+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("natures_spirit:"+name.replace("_nss", "")+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.COFFEE_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("natures_spirit:"+name.replace("_nss", "")+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.GARDEN_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("natures_spirit:"+name.replace("_nss", "")+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.OCTAGONAL_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("natures_spirit:"+name.replace("_nss", "")+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.DINING_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("natures_spirit:"+name.replace("_nss", "")+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.DESK_TABLES.get(name).get()).getPath(), "1");
            ModJsonHelper.createStonecuttingRecipe("natures_spirit:"+name.replace("_nss", "")+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.KITCHEN_TABLES.get(name).get()).getPath(), "1");
        }
    }
}