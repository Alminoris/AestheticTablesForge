package net.alminoris.aesthetictables.datagen;

import net.alminoris.aesthetictables.AestheticTables;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AestheticTables.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        DataGenerator packOutput = generator.getDataGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput));
        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));

        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));

        generator.addProvider(event.includeClient(), new ModLanguageProviderEnUs(packOutput));
        generator.addProvider(event.includeClient(), new ModLanguageProviderDeDe(packOutput));
        generator.addProvider(event.includeClient(), new ModLanguageProviderEsEs(packOutput));
        generator.addProvider(event.includeClient(), new ModLanguageProviderFrFr(packOutput));
        generator.addProvider(event.includeClient(), new ModLanguageProviderRuRu(packOutput));
        generator.addProvider(event.includeClient(), new ModLanguageProviderUkUa(packOutput));
    }
}