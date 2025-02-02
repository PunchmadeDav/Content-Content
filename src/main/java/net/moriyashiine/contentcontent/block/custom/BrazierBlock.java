package net.moriyashiine.contentcontent.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.CampfireBlockEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class BrazierBlock extends Block {
   public static final BooleanProperty LIT = Properties.LIT;
   public static final BooleanProperty HANGING = Properties.HANGING;
   public static final BooleanProperty SIGNAL_FIRE = Properties.SIGNAL_FIRE;
   private final boolean emitsParticles = true;
   private final int fireDamage = 2;
   private BlockPos pos2;

   public BrazierBlock(AbstractBlock.Settings settings) {
      super(settings);
      this.setDefaultState(
              (BlockState)((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(LIT, true)).with(HANGING, false))
                      .with(SIGNAL_FIRE, false)
      );
   }

   public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
      return false;
   }

   public static boolean canBeLit(BlockState state) {
      return state.isIn(BlockTags.CAMPFIRES, statex -> statex.contains(LIT)) && !(Boolean)state.get(LIT);
   }

   public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
      if ((Boolean)state.get(LIT)) {
         if (random.nextInt(10) == 0) {
            world.playSound(
                    (double)pos.getX() + 0.5,
                    (double)pos.getY() + 0.5,
                    (double)pos.getZ() + 0.5,
                    SoundEvents.BLOCK_CAMPFIRE_CRACKLE,
                    SoundCategory.BLOCKS,
                    0.5F + random.nextFloat(),
                    random.nextFloat() * 0.7F + 0.6F,
                    false
            );
         }

         if (this.emitsParticles && random.nextInt(5) == 0) {
            for (int i = 0; i < random.nextInt(1) + 1; i++) {
               spawnSmokeParticle(world, pos, false, true);
               world.addParticle(
                       ParticleTypes.LAVA,
                       (double)pos.getX() + 0.5,
                       (double)pos.getY() + 0.5,
                       (double)pos.getZ() + 0.5,
                       (double)(random.nextFloat() / 2.0F),
                       5.0E-5,
                       (double)(random.nextFloat() / 2.0F)
               );
            }
         }
      }
   }

   public static void spawnSmokeParticle(World world, BlockPos pos, boolean isSignal, boolean lotsOfSmoke) {
      Random random = world.getRandom();
      DefaultParticleType defaultParticleType = isSignal ? ParticleTypes.CAMPFIRE_SIGNAL_SMOKE : ParticleTypes.CAMPFIRE_COSY_SMOKE;
      world.addImportantParticle(
              defaultParticleType,
              true,
              (double)pos.getX() + 0.5 + random.nextDouble() / 3.0 * (double)(random.nextBoolean() ? 1 : -1),
              (double)pos.getY() + random.nextDouble() + random.nextDouble(),
              (double)pos.getZ() + 0.5 + random.nextDouble() / 3.0 * (double)(random.nextBoolean() ? 1 : -1),
              0.0,
              0.07,
              0.0
      );
      if (lotsOfSmoke) {
         world.addParticle(
                 ParticleTypes.SMOKE,
                 (double)pos.getX() + 0.5 + random.nextDouble() / 4.0 * (double)(random.nextBoolean() ? 1 : -1),
                 (double)pos.getY() + 0.4,
                 (double)pos.getZ() + 0.5 + random.nextDouble() / 4.0 * (double)(random.nextBoolean() ? 1 : -1),
                 0.0,
                 0.005,
                 0.0
         );
      }
   }

   public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
      BlockPos blockPos = hit.getBlockPos();
      if (!world.isClient && projectile.isOnFire() && projectile.canModifyAt(world, blockPos) && !(Boolean)state.get(LIT)) {
         world.setBlockState(blockPos, (BlockState)state.with(Properties.LIT, true), 11);
      }
   }

   public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
      if (state.get(LIT) && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity) entity)) {
         entity.damage(world.getDamageSources().inFire(), this.fireDamage);
      }

      super.onEntityCollision(state, world, pos, entity);
   }

   public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
      VoxelShape shape = VoxelShapes.empty();
      shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0625, 0.25, 0.0625, 0.9375, 0.5, 0.1875));
      shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0625, 0.25, 0.8125, 0.9375, 0.5, 0.9375));
      shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.8125, 0.25, 0.1875, 0.9375, 0.5, 0.8125));
      shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0625, 0.25, 0.1875, 0.1875, 0.5, 0.8125));
      shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.5, 0.0, 0.0625, 0.5, 0.25, 0.9375));
      shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.5, 0.0, 0.0625, 0.5, 0.25, 0.9375));
      return VoxelShapes.union(shape, VoxelShapes.cuboid(0.1875, 0.25, 0.1875, 0.8125, 0.3125, 0.8125));
   }

   public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
      if (player.isSneaking()) {
         if ((Boolean)state.get(HANGING)) {
            world.setBlockState(pos, (BlockState)state.with(Properties.HANGING, false));
         }

         if (!(Boolean)state.get(HANGING)) {
            world.setBlockState(pos, (BlockState)state.with(Properties.HANGING, true));
         }

         return ActionResult.SUCCESS;
      } else {
         if (!player.isSneaking()) {
            if ((Boolean)state.get(LIT)) {
               world.setBlockState(pos, (BlockState)state.with(Properties.LIT, false));
            }

            if (!(Boolean)state.get(LIT)) {
               world.setBlockState(pos, (BlockState)state.with(Properties.LIT, true));
            }
         }

         return ActionResult.SUCCESS;
      }
   }

   public static void extinguish(@Nullable Entity entity, WorldAccess world, BlockPos pos, BlockState state) {
      if (world.isClient()) {
         for (int i = 0; i < 20; i++) {
            spawnSmokeParticle((World)world, pos, (Boolean)state.get(SIGNAL_FIRE), true);
         }
      }

      BlockEntity blockEntity = world.getBlockEntity(pos);
      if (blockEntity instanceof CampfireBlockEntity) {
         ((CampfireBlockEntity)blockEntity).spawnItemsBeingCooked();
      }

      world.emitGameEvent(entity, GameEvent.BLOCK_CHANGE, pos);
   }

   protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
      builder.add(new Property[]{LIT, HANGING, SIGNAL_FIRE});
   }

   public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity player, ItemStack itemStack) {
      this.pos2 = pos;
   }
}