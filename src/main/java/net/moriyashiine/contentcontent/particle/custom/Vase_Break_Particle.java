package net.moriyashiine.contentcontent.particle.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import java.util.function.Consumer;

public class Vase_Break_Particle extends SpriteBillboardParticle {
   private final SpriteProvider spriteSet;
   private static final Vector3f ROTATION_VECTOR = Util.make(new Vector3f(0.5F, 0.5F, 0.5F), Vector3f::normalize);
   private static final Vector3f[] QUAD_VERTICES = new Vector3f[]{
           new Vector3f(-1.0F, -1.0F, 0.0F),
           new Vector3f(-1.0F, 1.0F, 0.0F),
           new Vector3f(1.0F, 1.0F, 0.0F),
           new Vector3f(1.0F, -1.0F, 0.0F)
   };

   protected Vase_Break_Particle(ClientWorld world, double x, double y, double z, SpriteProvider spriteSet, double velocityX, double velocityY, double velocityZ) {
      super(world, x, y, z, velocityX, velocityY, velocityZ);
      this.velocityMultiplier = 0.0F;
      this.velocityX = velocityX;
      this.velocityY = velocityY;
      this.velocityZ = velocityZ;
      this.scale *= 0.6F;
      this.maxAge = 30;
      this.setSpriteForAge(spriteSet);
      this.setPos(x, y, z);
      this.red = 1.0F;
      this.green = 1.0F;
      this.blue = 1.0F;
      this.spriteSet = spriteSet;
   }

   @Override
   public void tick() {
      super.tick();
      this.setSpriteForAge(this.spriteSet);
      this.fadeOut();
   }

   private void fadeOut() {
      this.scale = 6.0F / (float) this.maxAge * (float) this.age + 1.0F;
   }

   @Override
   public void buildGeometry(VertexConsumer vertexConsumer, Camera camera, float tickDelta) {
      this.buildGeometry(vertexConsumer, camera, tickDelta, quaternion -> {
         quaternion.mul(new Quaternionf().rotateY(0.0F));
         quaternion.mul(new Quaternionf().rotateX(-1.56F));
      });
      this.buildGeometry(vertexConsumer, camera, tickDelta, quaternion -> {
         quaternion.mul(new Quaternionf().rotateY((float) -Math.PI));
         quaternion.mul(new Quaternionf().rotateX(1.56F));
      });
   }

   private void buildGeometry(VertexConsumer vertexConsumer, Camera camera, float tickDelta, Consumer<Quaternionf> rotator) {
      Vec3d cameraPos = camera.getPos();
      float x = (float) (MathHelper.lerp(tickDelta, this.prevPosX, this.x) - cameraPos.getX());
      float y = (float) (MathHelper.lerp(tickDelta, this.prevPosY, this.y) - cameraPos.getY());
      float z = (float) (MathHelper.lerp(tickDelta, this.prevPosZ, this.z) - cameraPos.getZ());

      Quaternionf quaternion = new Quaternionf().setAngleAxis(0.0F, ROTATION_VECTOR.x(), ROTATION_VECTOR.y(), ROTATION_VECTOR.z());
      rotator.accept(quaternion);

      Vector3f[] vertices = new Vector3f[QUAD_VERTICES.length];
      for (int i = 0; i < QUAD_VERTICES.length; i++) {
         vertices[i] = new Vector3f(QUAD_VERTICES[i]).rotate(quaternion);
         vertices[i].mul(this.getSize(tickDelta));
         vertices[i].add(x, y, z);
      }

      int light = this.getBrightness(tickDelta);
      this.vertex(vertexConsumer, vertices[0], this.getMaxU(), this.getMaxV(), light);
      this.vertex(vertexConsumer, vertices[1], this.getMaxU(), this.getMinV(), light);
      this.vertex(vertexConsumer, vertices[2], this.getMinU(), this.getMinV(), light);
      this.vertex(vertexConsumer, vertices[3], this.getMinU(), this.getMaxV(), light);
   }

   private void vertex(VertexConsumer vertexConsumer, Vector3f pos, float u, float v, int light) {
      vertexConsumer.vertex(pos.x(), pos.y(), pos.z())
              .texture(u, v)
              .color(this.red, this.green, this.blue, this.alpha)
              .light(light)
              .next();
   }

   @Override
   public int getBrightness(float tint) {
      return 240;
   }

   @Override
   public ParticleTextureSheet getType() {
      return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
   }

   @Environment(EnvType.CLIENT)
   public static class Factory implements ParticleFactory<DefaultParticleType> {
      private final SpriteProvider spriteProvider;

      public Factory(SpriteProvider spriteProvider) {
         this.spriteProvider = spriteProvider;
      }

      @Override
      public Particle createParticle(DefaultParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
         return new Vase_Break_Particle(world, x, y, z, this.spriteProvider, velocityX, velocityY, velocityZ);
      }
   }
}