package net.alminoris.aesthetictables.item;

import net.alminoris.aesthetictables.AestheticTables;
import net.alminoris.aesthetictables.block.ModBlocks;
import net.alminoris.aesthetictables.util.helper.BlockSetsHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static net.alminoris.aesthetictables.util.helper.BlockSetsHelper.*;
import static net.alminoris.aesthetictables.util.helper.BlockSetsHelper.NSS_WOOD_NAMES;

@Mod.EventBusSubscriber(modid = AestheticTables.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItemGroups
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AestheticTables.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ATBLS_TAB = CREATIVE_MODE_TABS.register("atblstab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(ModBlocks.TABLES.get("oak").get().asItem()::getDefaultInstance)
            .title(Component.translatable("itemgroup.atblstab"))
            .displayItems((parameters, entries) ->
            {
                for(String name : BlockSetsHelper.WOODS)
                {
                    entries.accept(ModBlocks.TABLES.get(name).get());
                    entries.accept(ModBlocks.COFFEE_TABLES.get(name).get());
                    entries.accept(ModBlocks.GARDEN_TABLES.get(name).get());
                    entries.accept(ModBlocks.OCTAGONAL_TABLES.get(name).get());
                    entries.accept(ModBlocks.DINING_TABLES.get(name).get());
                    entries.accept(ModBlocks.DESK_TABLES.get(name).get());
                    entries.accept(ModBlocks.KITCHEN_TABLES.get(name).get());
                }

                if (ModList.get().isLoaded("arborealnature"))
                {
                    for(String name : BlockSetsHelper.EXTRA_WOODS_AN)
                    {
                        entries.accept(ModBlocks.TABLES.get(name).get());
                        entries.accept(ModBlocks.COFFEE_TABLES.get(name).get());
                        entries.accept(ModBlocks.GARDEN_TABLES.get(name).get());
                        entries.accept(ModBlocks.OCTAGONAL_TABLES.get(name).get());
                        entries.accept(ModBlocks.DINING_TABLES.get(name).get());
                        entries.accept(ModBlocks.DESK_TABLES.get(name).get());
                        entries.accept(ModBlocks.KITCHEN_TABLES.get(name).get());
                    }
                }

                if (ModList.get().isLoaded("wildfields"))
                {
                    for(String name : BlockSetsHelper.EXTRA_WOODS_WF)
                    {
                        entries.accept(ModBlocks.TABLES.get(name).get());
                        entries.accept(ModBlocks.COFFEE_TABLES.get(name).get());
                        entries.accept(ModBlocks.GARDEN_TABLES.get(name).get());
                        entries.accept(ModBlocks.OCTAGONAL_TABLES.get(name).get());
                        entries.accept(ModBlocks.DINING_TABLES.get(name).get());
                        entries.accept(ModBlocks.DESK_TABLES.get(name).get());
                        entries.accept(ModBlocks.KITCHEN_TABLES.get(name).get());
                    }
                }

                if (ModList.get().isLoaded("whisperleaftrees"))
                {
                    for(String name : BlockSetsHelper.WT_WOOD_NAMES)
                    {
                        entries.accept(ModBlocks.TABLES.get(name).get());
                        entries.accept(ModBlocks.COFFEE_TABLES.get(name).get());
                        entries.accept(ModBlocks.GARDEN_TABLES.get(name).get());
                        entries.accept(ModBlocks.OCTAGONAL_TABLES.get(name).get());
                        entries.accept(ModBlocks.DINING_TABLES.get(name).get());
                        entries.accept(ModBlocks.DESK_TABLES.get(name).get());
                        entries.accept(ModBlocks.KITCHEN_TABLES.get(name).get());
                    }
                }

                if (ModList.get().isLoaded("silverwoodtrees"))
                {
                    for(String name : BlockSetsHelper.ST_WOOD_NAMES)
                    {
                        entries.accept(ModBlocks.TABLES.get(name).get());
                        entries.accept(ModBlocks.COFFEE_TABLES.get(name).get());
                        entries.accept(ModBlocks.GARDEN_TABLES.get(name).get());
                        entries.accept(ModBlocks.OCTAGONAL_TABLES.get(name).get());
                        entries.accept(ModBlocks.DINING_TABLES.get(name).get());
                        entries.accept(ModBlocks.DESK_TABLES.get(name).get());
                        entries.accept(ModBlocks.KITCHEN_TABLES.get(name).get());
                    }
                }

                if (ModList.get().isLoaded("missingtrees"))
                {
                    for(String name : BlockSetsHelper.MT_WOOD_NAMES)
                    {
                        entries.accept(ModBlocks.TABLES.get(name).get());
                        entries.accept(ModBlocks.COFFEE_TABLES.get(name).get());
                        entries.accept(ModBlocks.GARDEN_TABLES.get(name).get());
                        entries.accept(ModBlocks.OCTAGONAL_TABLES.get(name).get());
                        entries.accept(ModBlocks.DINING_TABLES.get(name).get());
                        entries.accept(ModBlocks.DESK_TABLES.get(name).get());
                        entries.accept(ModBlocks.KITCHEN_TABLES.get(name).get());
                    }
                }

                if (ModList.get().isLoaded("natures_spirit"))
                {
                    for(String name : BlockSetsHelper.NSS_WOOD_NAMES)
                    {
                        entries.accept(ModBlocks.TABLES.get(name).get());
                        entries.accept(ModBlocks.COFFEE_TABLES.get(name).get());
                        entries.accept(ModBlocks.GARDEN_TABLES.get(name).get());
                        entries.accept(ModBlocks.OCTAGONAL_TABLES.get(name).get());
                        entries.accept(ModBlocks.DINING_TABLES.get(name).get());
                        entries.accept(ModBlocks.DESK_TABLES.get(name).get());
                        entries.accept(ModBlocks.KITCHEN_TABLES.get(name).get());
                    }
                }
            }).build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}