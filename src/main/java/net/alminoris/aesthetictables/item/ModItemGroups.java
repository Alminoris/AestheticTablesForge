package net.alminoris.aesthetictables.item;

import net.alminoris.aesthetictables.AestheticTables;
import net.alminoris.aesthetictables.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AestheticTables.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItemGroups
{
    public static CreativeModeTab ATBLS_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event)
    {
        ATBLS_TAB = event.registerCreativeModeTab(ResourceLocation.fromNamespaceAndPath(AestheticTables.MOD_ID, "atblstab"),
                builder -> builder.icon(() -> new ItemStack(ModBlocks.TABLES.get("oak").get().asItem()))
                        .title(Component.translatable("itemgroup.atblstab")));
    }
}