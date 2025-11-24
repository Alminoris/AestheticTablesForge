package net.alminoris.aesthetictables.datagen;

import net.alminoris.aesthetictables.AestheticTables;
import net.alminoris.aesthetictables.block.ModBlocks;
import net.alminoris.aesthetictables.util.helper.BlockSetsHelper;
import net.alminoris.aesthetictables.util.helper.ModJsonHelper;
import net.alminoris.aesthetictables.util.helper.ModJsonTemplates;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;

public class ModBlockStateProvider extends BlockStateProvider
{
    public ModBlockStateProvider(DataGenerator output, ExistingFileHelper exFileHelper)
    {
        super(output, AestheticTables.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        for(String name : BlockSetsHelper.getWoods()) {
            if (Arrays.asList(BlockSetsHelper.WOODS).contains(name)) {
                registerTable(
                        ModJsonTemplates.TABLE, ModJsonTemplates.TABLE_TOP,
                        ModJsonTemplates.TABLE_LEG1, ModJsonTemplates.TABLE_LEG2, ModJsonTemplates.TABLE_LEG3,
                        ModJsonTemplates.TABLE_LEG4,
                        ModBlocks.TABLES.get(name), name, "minecraft");

                registerCoffeeTable(
                        ModJsonTemplates.COFFEE_TABLE, ModJsonTemplates.COFFEE_TABLE_TOP,
                        ModJsonTemplates.COFFEE_TABLE_LEG1, ModJsonTemplates.COFFEE_TABLE_LEG2, ModJsonTemplates.COFFEE_TABLE_LEG3,
                        ModJsonTemplates.COFFEE_TABLE_LEG4,
                        ModBlocks.COFFEE_TABLES.get(name), name, "minecraft");

                registerGardenTable(
                        ModJsonTemplates.GARDEN_TABLE, ModJsonTemplates.GARDEN_TABLE_CENTER,
                        ModJsonTemplates.GARDEN_TABLE_LEFT, ModJsonTemplates.GARDEN_TABLE_RIGHT,
                        ModBlocks.GARDEN_TABLES.get(name), name, "minecraft");

                registerGardenTable(
                        ModJsonTemplates.DESK_TABLE, ModJsonTemplates.DESK_TABLE_CENTER,
                        ModJsonTemplates.DESK_TABLE_LEFT, ModJsonTemplates.DESK_TABLE_RIGHT,
                        ModBlocks.DESK_TABLES.get(name), name, "minecraft");

                registerSimpleTable(ModJsonTemplates.OCTAGONAL_TABLE, ModBlocks.OCTAGONAL_TABLES.get(name), name, "minecraft");

                registerExtraTable(
                        ModJsonTemplates.DINING_TABLE_FULL, ModJsonTemplates.DINING_TABLE, ModJsonTemplates.DINING_TABLE_TOP,
                        ModJsonTemplates.DINING_TABLE_LEG1, ModJsonTemplates.DINING_TABLE_LEG2, ModJsonTemplates.DINING_TABLE_LEG3,
                        ModJsonTemplates.DINING_TABLE_LEG4,
                        ModBlocks.DINING_TABLES.get(name), name, "minecraft");

                registerTable(
                        ModJsonTemplates.KITCHEN_TABLE, ModJsonTemplates.KITCHEN_TABLE_TOP,
                        ModJsonTemplates.KITCHEN_TABLE_LEG1, ModJsonTemplates.KITCHEN_TABLE_LEG2, ModJsonTemplates.KITCHEN_TABLE_LEG3,
                        ModJsonTemplates.KITCHEN_TABLE_LEG4,
                        ModBlocks.KITCHEN_TABLES.get(name), name, "minecraft");
            } else {
                registerTable(
                        ModJsonTemplates.TABLE, ModJsonTemplates.TABLE_TOP,
                        ModJsonTemplates.TABLE_LEG1, ModJsonTemplates.TABLE_LEG2, ModJsonTemplates.TABLE_LEG3,
                        ModJsonTemplates.TABLE_LEG4,
                        ModBlocks.TABLES.get(name), name, "aesthetictables");

                registerExtraTable(
                        ModJsonTemplates.DINING_TABLE_FULL, ModJsonTemplates.DINING_TABLE, ModJsonTemplates.DINING_TABLE_TOP,
                        ModJsonTemplates.DINING_TABLE_LEG1, ModJsonTemplates.DINING_TABLE_LEG2, ModJsonTemplates.DINING_TABLE_LEG3,
                        ModJsonTemplates.DINING_TABLE_LEG4,
                        ModBlocks.DINING_TABLES.get(name), name, "aesthetictables");

                registerTable(
                        ModJsonTemplates.KITCHEN_TABLE, ModJsonTemplates.KITCHEN_TABLE_TOP,
                        ModJsonTemplates.KITCHEN_TABLE_LEG1, ModJsonTemplates.KITCHEN_TABLE_LEG2, ModJsonTemplates.KITCHEN_TABLE_LEG3,
                        ModJsonTemplates.KITCHEN_TABLE_LEG4,
                        ModBlocks.KITCHEN_TABLES.get(name), name, "aesthetictables");

                registerCoffeeTable(
                        ModJsonTemplates.COFFEE_TABLE, ModJsonTemplates.COFFEE_TABLE_TOP,
                        ModJsonTemplates.COFFEE_TABLE_LEG1, ModJsonTemplates.COFFEE_TABLE_LEG2, ModJsonTemplates.COFFEE_TABLE_LEG3,
                        ModJsonTemplates.COFFEE_TABLE_LEG4,
                        ModBlocks.COFFEE_TABLES.get(name), name, "aesthetictables");

                registerGardenTable(
                        ModJsonTemplates.GARDEN_TABLE, ModJsonTemplates.GARDEN_TABLE_CENTER,
                        ModJsonTemplates.GARDEN_TABLE_LEFT, ModJsonTemplates.GARDEN_TABLE_RIGHT,
                        ModBlocks.GARDEN_TABLES.get(name), name, "aesthetictables");

                registerGardenTable(
                        ModJsonTemplates.DESK_TABLE, ModJsonTemplates.DESK_TABLE_CENTER,
                        ModJsonTemplates.DESK_TABLE_LEFT, ModJsonTemplates.DESK_TABLE_RIGHT,
                        ModBlocks.DESK_TABLES.get(name), name, "aesthetictables");

                registerSimpleTable(ModJsonTemplates.OCTAGONAL_TABLE, ModBlocks.OCTAGONAL_TABLES.get(name), name, "aesthetictables");
            }
        }
    }

    public final void registerTable(String normal,
                                    String top, String leg1, String leg2, String leg3, String leg4,
                                    RegistryObject<Block> table, String name, String modId)
    {
        String logName = (name.equals("crimson") || name.equals("warped")) ? "stem" : (name.equals("bamboo") ? "block" : "log");

        ModJsonHelper.createTableBlockModel(normal, ForgeRegistries.BLOCKS.getKey(table.get()).getPath(),
                modId+":block/"+name+"_"+logName,
                modId+":block/"+name+"_planks",
                modId+":block/"+name+"_planks",
                "normal");
        ModJsonHelper.createTableBlockModel(leg1, ForgeRegistries.BLOCKS.getKey(table.get()).getPath(),
                modId+":block/"+name+"_"+logName,
                modId+":block/"+name+"_planks",
                modId+":block/"+name+"_planks",
                "leg1");
        ModJsonHelper.createTableBlockModel(leg2, ForgeRegistries.BLOCKS.getKey(table.get()).getPath(),
                modId+":block/"+name+"_"+logName,
                modId+":block/"+name+"_planks",
                modId+":block/"+name+"_planks",
                "leg2");
        ModJsonHelper.createTableBlockModel(leg3, ForgeRegistries.BLOCKS.getKey(table.get()).getPath(),
                modId+":block/"+name+"_"+logName,
                modId+":block/"+name+"_planks",
                modId+":block/"+name+"_planks",
                "leg3");
        ModJsonHelper.createTableBlockModel(leg4, ForgeRegistries.BLOCKS.getKey(table.get()).getPath(),
                modId+":block/"+name+"_"+logName,
                modId+":block/"+name+"_planks",
                modId+":block/"+name+"_planks",
                "leg4");
        ModJsonHelper.createTableBlockModel(top, ForgeRegistries.BLOCKS.getKey(table.get()).getPath(),
                modId+":block/"+name+"_"+logName,
                modId+":block/"+name+"_planks",
                modId+":block/"+name+"_planks",
                "top");

        ModJsonHelper.createBlockstate(ModJsonTemplates.TABLE_BLOCKSTATE_TEMPLATE, ForgeRegistries.BLOCKS.getKey(table.get()).getPath());
        blockItem(table, "block/"+ForgeRegistries.BLOCKS.getKey(table.get()).getPath());
    }

    public final void registerExtraTable(String full, String normal,
                                         String top, String leg1, String leg2, String leg3, String leg4,
                                         RegistryObject<Block> table, String name, String modId)
    {
        String logName = (name.equals("crimson") || name.equals("warped")) ? "stem" : (name.equals("bamboo") ? "block" : "log");

        ModJsonHelper.createTableBlockModel(full, ForgeRegistries.BLOCKS.getKey(table.get()).getPath(),
                modId+":block/"+name+"_"+logName,
                modId+":block/"+name+"_planks",
                modId+":block/"+name+"_planks",
                "full");
        ModJsonHelper.createTableBlockModel(normal, ForgeRegistries.BLOCKS.getKey(table.get()).getPath(),
                modId+":block/"+name+"_"+logName,
                modId+":block/"+name+"_planks",
                modId+":block/"+name+"_planks",
                "normal");
        ModJsonHelper.createTableBlockModel(leg1, ForgeRegistries.BLOCKS.getKey(table.get()).getPath(),
                modId+":block/"+name+"_"+logName,
                modId+":block/"+name+"_planks",
                modId+":block/"+name+"_planks",
                "leg1");
        ModJsonHelper.createTableBlockModel(leg2, ForgeRegistries.BLOCKS.getKey(table.get()).getPath(),
                modId+":block/"+name+"_"+logName,
                modId+":block/"+name+"_planks",
                modId+":block/"+name+"_planks",
                "leg2");
        ModJsonHelper.createTableBlockModel(leg3, ForgeRegistries.BLOCKS.getKey(table.get()).getPath(),
                modId+":block/"+name+"_"+logName,
                modId+":block/"+name+"_planks",
                modId+":block/"+name+"_planks",
                "leg3");
        ModJsonHelper.createTableBlockModel(leg4, ForgeRegistries.BLOCKS.getKey(table.get()).getPath(),
                modId+":block/"+name+"_"+logName,
                modId+":block/"+name+"_planks",
                modId+":block/"+name+"_planks",
                "leg4");
        ModJsonHelper.createTableBlockModel(top, ForgeRegistries.BLOCKS.getKey(table.get()).getPath(),
                modId+":block/"+name+"_"+logName,
                modId+":block/"+name+"_planks",
                modId+":block/"+name+"_planks",
                "top");

        ModJsonHelper.createBlockstate(ModJsonTemplates.EXTRA_TABLE_BLOCKSTATE_TEMPLATE, ForgeRegistries.BLOCKS.getKey(table.get()).getPath());
        blockItem(table, "block/"+ForgeRegistries.BLOCKS.getKey(table.get()).getPath()+"_full");
    }

    public final void registerCoffeeTable(String normal,
                                          String top, String leg1, String leg2, String leg3, String leg4,
                                          RegistryObject<Block> table, String name, String modId)
    {
        String logName = (name.equals("crimson") || name.equals("warped")) ? "stem" : (name.equals("bamboo") ? "block" : "log");

        ModJsonHelper.createTableBlockModel(normal, ForgeRegistries.BLOCKS.getKey(table.get()).getPath(),
                modId+":block/"+name+"_"+logName,
                modId+":block/glass",
                modId+":block/stripped_"+name+"_"+logName,
                "normal");
        ModJsonHelper.createTableBlockModel(leg1, ForgeRegistries.BLOCKS.getKey(table.get()).getPath(),
                modId+":block/"+name+"_"+logName,
                modId+":block/glass",
                modId+":block/stripped_"+name+"_"+logName,
                "leg1");
        ModJsonHelper.createTableBlockModel(leg2, ForgeRegistries.BLOCKS.getKey(table.get()).getPath(),
                modId+":block/"+name+"_"+logName,
                modId+":block/glass",
                modId+":block/stripped_"+name+"_"+logName,
                "leg2");
        ModJsonHelper.createTableBlockModel(leg3, ForgeRegistries.BLOCKS.getKey(table.get()).getPath(),
                modId+":block/"+name+"_"+logName,
                modId+":block/glass",
                modId+":block/stripped_"+name+"_"+logName,
                "leg3");
        ModJsonHelper.createTableBlockModel(leg4, ForgeRegistries.BLOCKS.getKey(table.get()).getPath(),
                modId+":block/"+name+"_"+logName,
                modId+":block/glass",
                modId+":block/stripped_"+name+"_"+logName,
                "leg4");
        ModJsonHelper.createTableBlockModel(top, ForgeRegistries.BLOCKS.getKey(table.get()).getPath(),
                modId+":block/"+name+"_"+logName,
                modId+":block/glass",
                modId+":block/stripped_"+name+"_"+logName,
                "top");

        ModJsonHelper.createBlockstate(ModJsonTemplates.TABLE_BLOCKSTATE_TEMPLATE, ForgeRegistries.BLOCKS.getKey(table.get()).getPath());
        blockItem(table, "block/"+ForgeRegistries.BLOCKS.getKey(table.get()).getPath());
    }

    public final void registerSimpleTable(String normal, RegistryObject<Block> table, String name, String modId)
    {
        String logName = (name.equals("crimson") || name.equals("warped")) ? "stem" : (name.equals("bamboo") ? "block" : "log");

        ModJsonHelper.createSimpleTableBlockModel(normal, ForgeRegistries.BLOCKS.getKey(table.get()).getPath(),
                modId+":block/"+name+"_"+logName,
                modId+":block/"+name+"_planks",
                modId+":block/stripped_"+name+"_"+logName);


        ModJsonHelper.createBlockstate(ModJsonTemplates.YAXIS_ROTATED_BLOCKSTATE_TEMPLATE, ForgeRegistries.BLOCKS.getKey(table.get()).getPath());
        blockItem(table, "block/"+ForgeRegistries.BLOCKS.getKey(table.get()).getPath());
    }

    public final void registerGardenTable(String normal,
                                          String center, String left, String right, RegistryObject<Block> table, String name, String modId)
    {
        String logName = (name.equals("crimson") || name.equals("warped")) ? "stem" : (name.equals("bamboo") ? "block" : "log");

        ModJsonHelper.createTableBlockModel(normal, ForgeRegistries.BLOCKS.getKey(table.get()).getPath(),
                modId+":block/stripped_"+name+"_"+logName,
                modId+":block/"+name+"_"+logName,
                modId+":block/stripped_"+name+"_"+logName,
                "normal");
        ModJsonHelper.createTableBlockModel(center, ForgeRegistries.BLOCKS.getKey(table.get()).getPath(),
                modId+":block/stripped_"+name+"_"+logName,
                modId+":block/"+name+"_"+logName,
                modId+":block/stripped_"+name+"_"+logName,
                "center");
        ModJsonHelper.createTableBlockModel(left, ForgeRegistries.BLOCKS.getKey(table.get()).getPath(),
                modId+":block/stripped_"+name+"_"+logName,
                modId+":block/"+name+"_"+logName,
                modId+":block/stripped_"+name+"_"+logName,
                "left");
        ModJsonHelper.createTableBlockModel(right, ForgeRegistries.BLOCKS.getKey(table.get()).getPath(),
                modId+":block/stripped_"+name+"_"+logName,
                modId+":block/"+name+"_"+logName,
                modId+":block/stripped_"+name+"_"+logName,
                "right");

        ModJsonHelper.createBlockstate(ModJsonTemplates.SIMPLE_TABLE_BLOCKSTATE_TEMPLATE, ForgeRegistries.BLOCKS.getKey(table.get()).getPath());
        blockItem(table, "block/"+ForgeRegistries.BLOCKS.getKey(table.get()).getPath());
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String name)
    {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("aesthetictables:" + name));
    }
}