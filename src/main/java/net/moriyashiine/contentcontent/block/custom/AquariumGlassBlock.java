package net.moriyashiine.contentcontent.block.custom;

import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class AquariumGlassBlock extends HorizontalFacingBlock implements Waterloggable {
   public static final DirectionProperty FACING = Properties.FACING;
   public static BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

   public AquariumGlassBlock(AbstractBlock.Settings settings) {
      super(settings);
      this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(FACING, Direction.UP));
   }

   @Nullable
   public BlockState getPlacementState(ItemPlacementContext ctx) {
      Direction direction = ctx.getSide();
      BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos().offset(direction.getOpposite()));
      BlockPos blockPos = ctx.getBlockPos();
      World world = ctx.getWorld();
      return blockState.isOf(this) && blockState.get(FACING) == direction
              ? (BlockState)this.getDefaultState().with(FACING, direction.getOpposite())
              : (BlockState)((BlockState)((BlockState)this.getDefaultState().with(FACING, direction))
              .with(WATERLOGGED, world.getFluidState(blockPos).getFluid() == Fluids.WATER))
              .with(WATERLOGGED, world.getFluidState(blockPos).getFluid() == Fluids.WATER);
   }

   public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
      switch ((Direction)state.get(FACING)) {
         case EAST:
         default:
            VoxelShape SHAPEEAST = VoxelShapes.empty();
            return VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.0, 0.0, 0.0, 0.0625, 1.0, 1.0));
         case WEST:
            VoxelShape SHAPEWEST = VoxelShapes.empty();
            return VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.9375, 0.0, 0.0, 1.0, 1.0, 1.0));
         case SOUTH:
            VoxelShape SHAPESOUTH = VoxelShapes.empty();
            return VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.0, 0.0, 0.0, 1.0, 1.0, 0.0625));
         case NORTH:
            VoxelShape SHAPENORTH = VoxelShapes.empty();
            return VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.0, 0.0, 0.9375, 1.0, 1.0, 1.0));
         case UP:
            VoxelShape SHAPEUP = VoxelShapes.empty();
            return VoxelShapes.union(SHAPEUP, VoxelShapes.cuboid(0.0, 0.0, 0.0, 1.0, 0.0625, 1.0));
         case DOWN:
            VoxelShape SHAPEDOWN = VoxelShapes.empty();
            return VoxelShapes.union(SHAPEDOWN, VoxelShapes.cuboid(0.0, 0.9375, 0.0, 1.0, 1.0, 1.0));
      }
   }

   @Nullable
   public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
      if ((Boolean)state.get(WATERLOGGED)) {
         world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
      }

      if (!world.isClient()) {
         world.scheduleBlockTick(pos, this, 1);
      }

      return state;
   }

   @Nullable
   public FluidState getFluidState(BlockState state) {
      return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
   }

   public BlockState rotate(BlockState state, BlockRotation rotation) {
      return (BlockState)state.with(FACING, rotation.rotate((Direction)state.get(FACING)));
   }

   public BlockState mirror(BlockState state, BlockMirror mirror) {
      return state.rotate(mirror.getRotation((Direction)state.get(FACING)));
   }

   protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
      builder.add(new Property[]{FACING, WATERLOGGED});
   }
}
