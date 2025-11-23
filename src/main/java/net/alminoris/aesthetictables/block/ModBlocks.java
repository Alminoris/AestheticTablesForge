package net.alminoris.aesthetictables.block;

import net.alminoris.aesthetictables.AestheticTables;
import net.alminoris.aesthetictables.block.custom.*;
import net.alminoris.aesthetictables.item.ModItems;
import net.alminoris.aesthetictables.util.helper.BlockSetsHelper;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AestheticTables.MOD_ID);

    public static final Dictionary<String, RegistryObject<Block>> TABLES = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.getWoods())
        {
            put(name, registerBlock("table_"+name,
                    () -> new Table(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion())));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> COFFEE_TABLES = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.getWoods())
        {
            put(name, registerBlock("coffee_table_"+name,
                    () -> new CoffeeTable(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion())));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> GARDEN_TABLES = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.getWoods())
        {
            put(name, registerBlock("garden_table_"+name, () -> new GardenTable(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS))));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> DESK_TABLES = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.getWoods())
        {
            put(name, registerBlock("desk_table_"+name, () -> new GardenTable(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS))));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> OCTAGONAL_TABLES = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.getWoods())
        {
            put(name, registerBlock("octagonal_table_"+name, () -> new SingleTable(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS))));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> DINING_TABLES = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.getWoods())
        {
            put(name, registerBlock("dining_table_"+name, () -> new ExtraTable(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS))));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> KITCHEN_TABLES = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.getWoods())
        {
            put(name, registerBlock("kitchen_table_"+name, () -> new Table(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS))));
        }
    }};

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block)
    {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}