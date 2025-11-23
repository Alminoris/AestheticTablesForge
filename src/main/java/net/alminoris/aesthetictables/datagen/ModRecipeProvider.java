package net.alminoris.aesthetictables.datagen;

import net.alminoris.aesthetictables.block.ModBlocks;
import net.alminoris.aesthetictables.util.helper.BlockSetsHelper;
import net.alminoris.aesthetictables.util.helper.ModJsonHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries)
    {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeExporter)
    {
        for(String name : BlockSetsHelper.WOODS)
        {
            Block block = ForgeRegistries.BLOCKS.getValue(ResourceLocation.withDefaultNamespace(name+"_planks"));

            stonecutterResultFromBase(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.TABLES.get(name).get(), block, 1);
            stonecutterResultFromBase(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.COFFEE_TABLES.get(name).get(), block, 1);
            stonecutterResultFromBase(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GARDEN_TABLES.get(name).get(), block, 1);
            stonecutterResultFromBase(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCTAGONAL_TABLES.get(name).get(), block, 1);
            stonecutterResultFromBase(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DINING_TABLES.get(name).get(), block, 1);
            stonecutterResultFromBase(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DESK_TABLES.get(name).get(), block, 1);
            stonecutterResultFromBase(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.KITCHEN_TABLES.get(name).get(), block, 1);
        }

        for(String name : BlockSetsHelper.EXTRA_WOODS_AN)
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

        for(String name : BlockSetsHelper.EXTRA_WOODS_WF)
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

        for(String name : BlockSetsHelper.WT_WOOD_NAMES)
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

        for(String name : BlockSetsHelper.ST_WOOD_NAMES)
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

        for(String name : BlockSetsHelper.MT_WOOD_NAMES)
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

        for(String name : BlockSetsHelper.NSS_WOOD_NAMES)
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