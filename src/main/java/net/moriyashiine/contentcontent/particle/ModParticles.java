package net.moriyashiine.contentcontent.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
   public static final DefaultParticleType VASE_BREAK_PARTICLE = FabricParticleTypes.simple();

   public static void registerParticles() {
      Registry.register(Registries.PARTICLE_TYPE, new Identifier("contentcontent", "vase_break_particle"), VASE_BREAK_PARTICLE);
   }
}
