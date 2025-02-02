package net.moriyashiine.contentcontent.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Equipment;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.util.shape.VoxelShape;
import net.moriyashiine.contentcontent.particle.ModParticles;
import org.jetbrains.annotations.Nullable;

public class AncientVase4Block extends HorizontalFacingBlock implements Equipment {
   public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
   public static final BooleanProperty GENERATED = Properties.ENABLED;

   public AncientVase4Block(AbstractBlock.Settings settings) {
      super(settings);
      this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(GENERATED, true));
   }

   public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
      switch ((Direction)state.get(FACING)) {
         case EAST:
         default:
            VoxelShape SHAPEEAST = VoxelShapes.empty();
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.25, 0.1875, 0.125, 1.0, 0.9375, 0.875));
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.375, 0.9375, 0.25, 0.875, 1.1875, 0.75));
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.5, 0.0, 0.5625, 0.75, 0.1875, 0.8125));
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.5, 0.0, 0.1875, 0.75, 0.1875, 0.4375));
            return VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.0, 0.25, 0.1875, 0.25, 0.875, 0.8125));
         case WEST:
            VoxelShape SHAPEWEST = VoxelShapes.empty();
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.0, 0.1875, 0.125, 0.75, 0.9375, 0.875));
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.125, 0.9375, 0.25, 0.625, 1.1875, 0.75));
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.25, 0.0, 0.1875, 0.5, 0.1875, 0.4375));
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.25, 0.0, 0.5625, 0.5, 0.1875, 0.8125));
            return VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.75, 0.25, 0.1875, 1.0, 0.875, 0.8125));
         case SOUTH:
            VoxelShape SHAPESOUTH = VoxelShapes.empty();
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.125, 0.1875, 0.25, 0.875, 0.9375, 1.0));
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.25, 0.9375, 0.375, 0.75, 1.1875, 0.875));
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.1875, 0.0, 0.5, 0.4375, 0.1875, 0.75));
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.5625, 0.0, 0.5, 0.8125, 0.1875, 0.75));
            return VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.1875, 0.25, 0.0, 0.8125, 0.875, 0.25));
         case NORTH:
            VoxelShape SHAPENORTH = VoxelShapes.empty();
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.125, 0.1875, 0.0, 0.875, 0.9375, 0.75));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.25, 0.9375, 0.125, 0.75, 1.1875, 0.625));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.5625, 0.0, 0.25, 0.8125, 0.1875, 0.5));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.1875, 0.0, 0.25, 0.4375, 0.1875, 0.5));
            return VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.1875, 0.25, 0.75, 0.8125, 0.875, 1.0));
      }
   }

   @Nullable
   public BlockState getPlacementState(ItemPlacementContext ctx) {
      return (BlockState)this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
   }

   public BlockState rotate(BlockState state, BlockRotation rotation) {
      return (BlockState)state.with(FACING, rotation.rotate((Direction)state.get(FACING)));
   }

   public BlockState mirror(BlockState state, BlockMirror mirror) {
      return state.rotate(mirror.getRotation((Direction)state.get(FACING)));
   }

   public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
      player.incrementStat(Stats.MINED.getOrCreateStat(this));
      player.addExhaustion(0.005F);
      world.playSound(player, pos, SoundEvents.BLOCK_SCULK_SHRIEKER_SHRIEK, SoundCategory.BLOCKS, 1.0F, 1.0F);
      world.addImportantParticle(
              ModParticles.VASE_BREAK_PARTICLE, (double)pos.getX() + 0.5, (double)pos.getY() + 0.75, (double)pos.getZ() + 0.5, 0.0, 0.0, 0.0
      );
      super.onBreak(world, pos, state, player);
   }

   protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
      builder.add(new Property[]{FACING});
      builder.add(new Property[]{GENERATED});
   }

   public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity player, ItemStack itemStack) {
      this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(GENERATED, false));
   }

   @Override
   public EquipmentSlot getSlotType() {
      return null;
   }
}
