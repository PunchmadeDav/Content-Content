package net.moriyashiine.contentcontent.block.custom;

import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class ChocolateRatBlock extends HorizontalFacingBlock {
   public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

   public ChocolateRatBlock(AbstractBlock.Settings settings) {
      super(settings);
   }

   public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
      switch ((Direction)state.get(FACING)) {
         case EAST:
         default:
            VoxelShape SHAPEEAST = VoxelShapes.empty();
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.125, 0.0625, 0.3125, 0.625, 0.3125, 0.6875));
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(-0.1875, 0.0625, 0.46875, 0.125, 0.125, 0.53125));
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(-0.5, 0.0625, 0.46875, -0.1875, 0.125, 0.53125));
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.625, 0.0625, 0.375, 0.875, 0.25, 0.625));
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.686875, 0.1875, 0.625, 0.6875, 0.3125, 0.75));
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.686875, 0.1875, 0.25, 0.6875, 0.3125, 0.375));
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.5625, 0.0, 0.625, 0.6875, 0.0625, 0.6875));
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.5625, 0.0, 0.3125, 0.6875, 0.0625, 0.375));
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.1875, 0.0, 0.625, 0.375, 0.0625, 0.6875));
            return VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.1875, 0.0, 0.3125, 0.375, 0.0625, 0.375));
         case WEST:
            VoxelShape SHAPEWEST = VoxelShapes.empty();
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.375, 0.0625, 0.3125, 0.875, 0.3125, 0.6875));
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.875, 0.0625, 0.46875, 1.1875, 0.125, 0.53125));
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(1.1875, 0.0625, 0.46875, 1.5, 0.125, 0.53125));
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.125, 0.0625, 0.375, 0.375, 0.25, 0.625));
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.3125, 0.1875, 0.25, 0.313125, 0.3125, 0.375));
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.3125, 0.1875, 0.625, 0.313125, 0.3125, 0.75));
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.3125, 0.0, 0.3125, 0.4375, 0.0625, 0.375));
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.3125, 0.0, 0.625, 0.4375, 0.0625, 0.6875));
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.625, 0.0, 0.3125, 0.8125, 0.0625, 0.375));
            return VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.625, 0.0, 0.625, 0.8125, 0.0625, 0.6875));
         case SOUTH:
            VoxelShape SHAPESOUTH = VoxelShapes.empty();
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.3125, 0.0625, 0.125, 0.6875, 0.3125, 0.625));
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.46875, 0.0625, -0.1875, 0.53125, 0.125, 0.125));
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.46875, 0.0625, -0.5, 0.53125, 0.125, -0.1875));
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.375, 0.0625, 0.625, 0.625, 0.25, 0.875));
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.25, 0.1875, 0.686875, 0.375, 0.3125, 0.6875));
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.625, 0.1875, 0.686875, 0.75, 0.3125, 0.6875));
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.3125, 0.0, 0.5625, 0.375, 0.0625, 0.6875));
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.625, 0.0, 0.5625, 0.6875, 0.0625, 0.6875));
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.3125, 0.0, 0.1875, 0.375, 0.0625, 0.375));
            return VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.625, 0.0, 0.1875, 0.6875, 0.0625, 0.375));
         case NORTH:
            VoxelShape SHAPENORTH = VoxelShapes.empty();
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.3125, 0.0625, 0.375, 0.6875, 0.3125, 0.875));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.46875, 0.0625, 0.875, 0.53125, 0.125, 1.1875));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.46875, 0.0625, 1.1875, 0.53125, 0.125, 1.5));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.375, 0.0625, 0.125, 0.625, 0.25, 0.375));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.625, 0.1875, 0.3125, 0.75, 0.3125, 0.313125));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.25, 0.1875, 0.3125, 0.375, 0.3125, 0.313125));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.625, 0.0, 0.3125, 0.6875, 0.0625, 0.4375));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.3125, 0.0, 0.3125, 0.375, 0.0625, 0.4375));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.625, 0.0, 0.625, 0.6875, 0.0625, 0.8125));
            return VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.3125, 0.0, 0.625, 0.375, 0.0625, 0.8125));
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

   protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
      builder.add(new Property[]{FACING});
   }
}
