package net.alminoris.aesthetictables.datagen.loot;

import net.alminoris.aesthetictables.block.ModBlocks;
import net.alminoris.aesthetictables.util.helper.BlockSetsHelper;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider
{
    public ModBlockLootTables()
    {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
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