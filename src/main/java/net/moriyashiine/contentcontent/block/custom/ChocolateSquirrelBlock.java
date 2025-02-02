package net.moriyashiine.contentcontent.block.custom;

import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.state.property.Property;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class ChocolateSquirrelBlock extends HorizontalFacingBlock {
   public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

   public ChocolateSquirrelBlock(AbstractBlock.Settings settings) {
      super(settings);
   }

   public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
      switch ((Direction)state.get(FACING)) {
         case EAST:
         default:
            VoxelShape SHAPEEAST = VoxelShapes.empty();
            SHAPEEAST = VoxelShapes.union(
                    SHAPEEAST, VoxelShapes.cuboid(0.41919417382415924, 0.10669417382415922, 0.375, 0.6691941738241592, 0.6066941738241592, 0.625)
            );
            SHAPEEAST = VoxelShapes.union(
                    SHAPEEAST, VoxelShapes.cuboid(0.21331661269068314, 0.3126486523493602, 0.40625, 0.400816612690683, 0.7501486523493601, 0.59375)
            );
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.375, 0.0625, 0.3125, 0.5625, 0.25, 0.4375));
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.4375, 0.0, 0.3125, 0.625, 0.0625, 0.4375));
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.375, 0.0625, 0.5625, 0.5625, 0.25, 0.6875));
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.4375, 0.0, 0.5625, 0.625, 0.0625, 0.6875));
            SHAPEEAST = VoxelShapes.union(
                    SHAPEEAST, VoxelShapes.cuboid(0.6107274123458662, 0.234375, 0.6655031435684543, 0.8607274123458662, 0.359375, 0.7280031435684543)
            );
            SHAPEEAST = VoxelShapes.union(
                    SHAPEEAST, VoxelShapes.cuboid(0.6107274123458662, 0.234375, 0.2719968564315457, 0.8607274123458662, 0.359375, 0.3344968564315457)
            );
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.65625, 0.6875, 0.53125, 0.78125, 0.75, 0.59375));
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.65625, 0.5, 0.40625, 0.90625, 0.6875, 0.59375));
            return VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.65625, 0.6875, 0.40625, 0.78125, 0.75, 0.46875));
         case WEST:
            VoxelShape SHAPEWEST = VoxelShapes.empty();
            SHAPEWEST = VoxelShapes.union(
                    SHAPEWEST, VoxelShapes.cuboid(0.33080582617584076, 0.10669417382415922, 0.375, 0.5808058261758408, 0.6066941738241592, 0.625)
            );
            SHAPEWEST = VoxelShapes.union(
                    SHAPEWEST, VoxelShapes.cuboid(0.599183387309317, 0.3126486523493602, 0.40625, 0.7866833873093169, 0.7501486523493601, 0.59375)
            );
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.4375, 0.0625, 0.5625, 0.625, 0.25, 0.6875));
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.375, 0.0, 0.5625, 0.5625, 0.0625, 0.6875));
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.4375, 0.0625, 0.3125, 0.625, 0.25, 0.4375));
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.375, 0.0, 0.3125, 0.5625, 0.0625, 0.4375));
            SHAPEWEST = VoxelShapes.union(
                    SHAPEWEST, VoxelShapes.cuboid(0.13927258765413375, 0.234375, 0.2719968564315457, 0.38927258765413375, 0.359375, 0.3344968564315457)
            );
            SHAPEWEST = VoxelShapes.union(
                    SHAPEWEST, VoxelShapes.cuboid(0.13927258765413375, 0.234375, 0.6655031435684543, 0.38927258765413375, 0.359375, 0.7280031435684543)
            );
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.21875, 0.6875, 0.40625, 0.34375, 0.75, 0.46875));
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.09375, 0.5, 0.40625, 0.34375, 0.6875, 0.59375));
            return VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.21875, 0.6875, 0.53125, 0.34375, 0.75, 0.59375));
         case SOUTH:
            VoxelShape SHAPESOUTH = VoxelShapes.empty();
            SHAPESOUTH = VoxelShapes.union(
                    SHAPESOUTH, VoxelShapes.cuboid(0.375, 0.10669417382415922, 0.41919417382415924, 0.625, 0.6066941738241592, 0.6691941738241592)
            );
            SHAPESOUTH = VoxelShapes.union(
                    SHAPESOUTH, VoxelShapes.cuboid(0.40625, 0.3126486523493602, 0.21331661269068314, 0.59375, 0.7501486523493601, 0.400816612690683)
            );
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.5625, 0.0625, 0.375, 0.6875, 0.25, 0.5625));
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.5625, 0.0, 0.4375, 0.6875, 0.0625, 0.625));
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.3125, 0.0625, 0.375, 0.4375, 0.25, 0.5625));
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.3125, 0.0, 0.4375, 0.4375, 0.0625, 0.625));
            SHAPESOUTH = VoxelShapes.union(
                    SHAPESOUTH, VoxelShapes.cuboid(0.2719968564315457, 0.234375, 0.6107274123458662, 0.3344968564315457, 0.359375, 0.8607274123458662)
            );
            SHAPESOUTH = VoxelShapes.union(
                    SHAPESOUTH, VoxelShapes.cuboid(0.6655031435684543, 0.234375, 0.6107274123458662, 0.7280031435684543, 0.359375, 0.8607274123458662)
            );
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.40625, 0.6875, 0.65625, 0.46875, 0.75, 0.78125));
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.40625, 0.5, 0.65625, 0.59375, 0.6875, 0.90625));
            return VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.53125, 0.6875, 0.65625, 0.59375, 0.75, 0.78125));
         case NORTH:
            VoxelShape SHAPENORTH = VoxelShapes.empty();
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.375, 0.0625, 0.3125, 0.625, 0.5625, 0.5625));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.40625, 0.31753625, 0.498755, 0.59375, 0.75503625, 0.686255));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.3125, 0.0625, 0.4375, 0.4375, 0.25, 0.625));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.3125, 0.0, 0.375, 0.4375, 0.0625, 0.5625));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.5625, 0.0625, 0.4375, 0.6875, 0.25, 0.625));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.5625, 0.0, 0.375, 0.6875, 0.0625, 0.5625));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.59375, 0.234375, 0.125, 0.65625, 0.359375, 0.375));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.34375, 0.234375, 0.125, 0.40625, 0.359375, 0.375));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.53125, 0.6875, 0.21875, 0.59375, 0.75, 0.34375));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.40625, 0.5, 0.09375, 0.59375, 0.6875, 0.34375));
            return VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.40625, 0.6875, 0.21875, 0.46875, 0.75, 0.34375));
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
