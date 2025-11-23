package net.alminoris.aesthetictables;

import com.mojang.logging.LogUtils;
import net.alminoris.aesthetictables.block.ModBlocks;
import net.alminoris.aesthetictables.item.ModItemGroups;
import net.alminoris.aesthetictables.item.ModItems;
import net.alminoris.aesthetictables.util.helper.BlockSetsHelper;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(AestheticTables.MOD_ID)
public class AestheticTables
{
    public static final String MOD_ID = "aesthetictables";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AestheticTables(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents entries)
    {
        if (entries.getTab() == ModItemGroups.ATBLS_TAB)
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
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            for (String name : BlockSetsHelper.getWoods())
            {
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.COFFEE_TABLES.get(name).get(), RenderType.translucent());
            }
        }
    }
}