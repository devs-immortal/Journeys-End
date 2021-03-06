package azzy.fabric.journeysend.biome;

import azzy.fabric.journeysend.carver.JourneysEndCarvers;
import azzy.fabric.journeysend.feature.JourneysEndFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilders;

public class CinderPipesBiome {

    public static final Biome CINDER_PIPES = createBiome();

    private static Biome createBiome() {
        Biome.Builder biome = new Biome.Builder();
        GenerationSettings.Builder generation = new GenerationSettings.Builder();
        SpawnSettings.Builder spawns = new SpawnSettings.Builder();
        BiomeEffects.Builder effects = new BiomeEffects.Builder();

        generation.surfaceBuilder(ConfiguredSurfaceBuilders.BADLANDS);
        generation.structureFeature(ConfiguredStructureFeatures.RUINED_PORTAL);
        //DefaultBiomeFeatures.addLandCarvers(generation);

        generation.carver(GenerationStep.Carver.AIR, JourneysEndCarvers.ASH_TROUGH_CARVER);
        generation.feature(GenerationStep.Feature.UNDERGROUND_ORES, JourneysEndFeatures.DARK_ASH_FLOOR.getFeature());

        DefaultBiomeFeatures.addBatsAndMonsters(spawns);

        effects.fogColor(0xe26028);
        effects.foliageColor(0xa4f25c);
        effects.waterColor(0x91e2ff);
        effects.waterFogColor(0x91e2ff);
        effects.skyColor(0x79c4fb);

        biome.spawnSettings(spawns.build());
        biome.generationSettings(generation.build());
        biome.precipitation(Biome.Precipitation.RAIN);
        biome.category(Biome.Category.UNDERGROUND);
        biome.downfall(1.0F);
        biome.temperature(4.0F);
        biome.scale(0.1F);
        biome.depth(0.2F);
        biome.effects(effects.build());
        return biome.build();
    }
}
