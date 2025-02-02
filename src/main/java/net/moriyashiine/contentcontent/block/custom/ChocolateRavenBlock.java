package net.moriyashiine.contentcontent.block.custom;

import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class ChocolateRavenBlock extends HorizontalFacingBlock {
   public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
   private static VoxelShape SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 7.0, 5.0, 10.0);

   public ChocolateRavenBlock(AbstractBlock.Settings settings) {
      super(settings);
   }

   public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
      switch ((Direction)state.get(FACING)) {
         case EAST:
         default:
            VoxelShape SHAPEEAST = VoxelShapes.empty();
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.25, 0.0, 0.34375, 0.75, 0.3125, 0.65625));
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.75, 0.0625, 0.40625, 0.875, 0.1875, 0.59375));
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.125, 0.03125, 0.65625, 0.5625, 0.28125, 0.71875));
            return VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.125, 0.03125, 0.28125, 0.5625, 0.28125, 0.34375));
         case WEST:
            VoxelShape SHAPEWEST = VoxelShapes.empty();
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.25, 0.0, 0.34375, 0.75, 0.3125, 0.65625));
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.125, 0.0625, 0.40625, 0.25, 0.1875, 0.59375));
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.4375, 0.03125, 0.28125, 0.875, 0.28125, 0.34375));
            return VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.4375, 0.03125, 0.65625, 0.875, 0.28125, 0.71875));
         case SOUTH:
            VoxelShape SHAPESOUTH = VoxelShapes.empty();
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.34375, 0.0, 0.25, 0.65625, 0.3125, 0.75));
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.40625, 0.0625, 0.75, 0.59375, 0.1875, 0.875));
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.28125, 0.03125, 0.125, 0.34375, 0.28125, 0.5625));
            return VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.65625, 0.03125, 0.125, 0.71875, 0.28125, 0.5625));
         case NORTH:
            VoxelShape SHAPENORTH = VoxelShapes.empty();
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.34375, 0.0, 0.25, 0.65625, 0.3125, 0.75));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.40625, 0.0625, 0.125, 0.59375, 0.1875, 0.25));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.65625, 0.03125, 0.4375, 0.71875, 0.28125, 0.875));
            return VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.28125, 0.03125, 0.4375, 0.34375, 0.28125, 0.875));
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
