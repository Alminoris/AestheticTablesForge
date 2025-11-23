package net.alminoris.aesthetictables.datagen;

import net.alminoris.aesthetictables.block.ModBlocks;
import net.alminoris.aesthetictables.util.helper.BlockSetsHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider
{
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries)
    {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate()
    {
        for(String name : BlockSetsHelper.getWoods())
        {
            dropSelf(ModBlocks.TABLES.get(name).get());
            dropSelf(ModBlocks.DINING_TABLES.get(name).get());
            dropSelf(ModBlocks.DESK_TABLES.get(name).get());
            dropSelf(ModBlocks.COFFEE_TABLES.get(name).get());
            dropSelf(ModBlocks.GARDEN_TABLES.get(name).get());
            dropSelf(ModBlocks.KITCHEN_TABLES.get(name).get());
            dropSelf(ModBlocks.OCTAGONAL_TABLES.get(name).get());
        }
    }

    @Override
    protected Iterable<Block> getKnownBlocks()
    {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}