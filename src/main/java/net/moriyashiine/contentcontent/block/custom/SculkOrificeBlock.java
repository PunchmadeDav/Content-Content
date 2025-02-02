package net.moriyashiine.contentcontent.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.state.property.Property;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.SculkShriekerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class SculkOrificeBlock extends Block {
   public static final BooleanProperty HASTARGET = Properties.ENABLED;
   private ServerPlayerEntity TargettedPlayer;

   public SculkOrificeBlock(AbstractBlock.Settings settings) {
      super(settings);
      this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(HASTARGET, false));
   }

   public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
      VoxelShape shape = VoxelShapes.empty();
      shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0625, 0.0, 0.0625, 0.9375, 0.125, 0.9375));
      shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.9375, 0.0, 0.0625, 1.0, 1.0, 0.9375));
      shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0, 0.0625, 0.0625, 0.0625, 1.0, 0.9375));
      shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0, 0.0, 0.0, 1.0, 1.0, 0.0625));
      return VoxelShapes.union(shape, VoxelShapes.cuboid(0.0, 0.0, 0.9375, 1.0, 1.0, 1.0));
   }

   protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
      builder.add(new Property[]{HASTARGET});
   }

   public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
      if (world instanceof ServerWorld serverWorld) {
         ServerPlayerEntity serverPlayerEntity = SculkShriekerBlockEntity.findResponsiblePlayerFromEntity(entity);
         if (serverPlayerEntity != null) {
            this.TargettedPlayer = serverPlayerEntity;
         }
      }

      super.onSteppedOn(world, pos, state, entity);
   }

   public boolean hasRandomTicks(BlockState state) {
      return this.randomTicks;
   }

   public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
      this.TargettedPlayer = null;
      super.onBreak(world, pos, state, player);
   }

   public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
      if (this.TargettedPlayer != null && this.TargettedPlayer.isDead()) {
         this.TargettedPlayer = null;
      }
   }
}
