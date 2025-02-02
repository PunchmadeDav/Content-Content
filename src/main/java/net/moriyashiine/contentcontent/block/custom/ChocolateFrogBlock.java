package net.moriyashiine.contentcontent.block.custom;

import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
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
import org.jetbrains.annotations.Nullable;

public class ChocolateFrogBlock extends HorizontalFacingBlock {
   public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

   public ChocolateFrogBlock(AbstractBlock.Settings settings) {
      super(settings);
   }

   public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
      switch ((Direction)state.get(FACING)) {
         case EAST:
         default:
            VoxelShape SHAPEEAST = VoxelShapes.empty();
            SHAPEEAST = VoxelShapes.union(
                    SHAPEEAST, VoxelShapes.cuboid(0.3077424707819554, 0.1010822854771819, 0.34375, 0.9327424707819554, 0.2885822854771819, 0.65625)
            );
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.62021625, 0.19904875, 0.40625, 0.80771625, 0.26154875, 0.59375));
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.5625, 6.25E-4, 0.625, 0.625, 0.250625, 0.6875));
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.5625, 6.25E-4, 0.5625, 0.75, 6.25E-4, 0.8125));
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.5625, 6.25E-4, 0.3125, 0.625, 0.250625, 0.375));
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.5625, 6.25E-4, 0.1875, 0.75, 6.25E-4, 0.4375));
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.25, 6.25E-4, 0.625, 0.4375, 0.188125, 0.75));
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.25, 6.25E-4, 0.625, 0.5, 6.25E-4, 0.9375));
            SHAPEEAST = VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.25, 6.25E-4, 0.25, 0.4375, 0.188125, 0.375));
            return VoxelShapes.union(SHAPEEAST, VoxelShapes.cuboid(0.25, 6.25E-4, 0.0625, 0.5, 6.25E-4, 0.375));
         case WEST:
            VoxelShape SHAPEWEST = VoxelShapes.empty();
            SHAPEWEST = VoxelShapes.union(
                    SHAPEWEST, VoxelShapes.cuboid(0.06725752921804462, 0.1010822854771819, 0.34375, 0.6922575292180446, 0.2885822854771819, 0.65625)
            );
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.19228374999999998, 0.19904875, 0.40625, 0.37978375, 0.26154875, 0.59375));
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.375, 6.25E-4, 0.3125, 0.4375, 0.250625, 0.375));
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.25, 6.25E-4, 0.1875, 0.4375, 6.25E-4, 0.4375));
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.375, 6.25E-4, 0.625, 0.4375, 0.250625, 0.6875));
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.25, 6.25E-4, 0.5625, 0.4375, 6.25E-4, 0.8125));
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.5625, 6.25E-4, 0.25, 0.75, 0.188125, 0.375));
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.5, 6.25E-4, 0.0625, 0.75, 6.25E-4, 0.375));
            SHAPEWEST = VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.5625, 6.25E-4, 0.625, 0.75, 0.188125, 0.75));
            return VoxelShapes.union(SHAPEWEST, VoxelShapes.cuboid(0.5, 6.25E-4, 0.625, 0.75, 6.25E-4, 0.9375));
         case SOUTH:
            VoxelShape SHAPESOUTH = VoxelShapes.empty();
            SHAPESOUTH = VoxelShapes.union(
                    SHAPESOUTH, VoxelShapes.cuboid(0.34375, 0.1010822854771819, 0.3077424707819554, 0.65625, 0.2885822854771819, 0.9327424707819554)
            );
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.40625, 0.19904875, 0.62021625, 0.59375, 0.26154875, 0.80771625));
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.3125, 6.25E-4, 0.5625, 0.375, 0.250625, 0.625));
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.1875, 6.25E-4, 0.5625, 0.4375, 6.25E-4, 0.75));
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.625, 6.25E-4, 0.5625, 0.6875, 0.250625, 0.625));
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.5625, 6.25E-4, 0.5625, 0.8125, 6.25E-4, 0.75));
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.25, 6.25E-4, 0.25, 0.375, 0.188125, 0.4375));
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.0625, 6.25E-4, 0.25, 0.375, 6.25E-4, 0.5));
            SHAPESOUTH = VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.625, 6.25E-4, 0.25, 0.75, 0.188125, 0.4375));
            return VoxelShapes.union(SHAPESOUTH, VoxelShapes.cuboid(0.625, 6.25E-4, 0.25, 0.9375, 6.25E-4, 0.5));
         case NORTH:
            VoxelShape SHAPENORTH = VoxelShapes.empty();
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.34375, 0.125, 0.0625, 0.65625, 0.3125, 0.6875));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.40625, 0.19904875, 0.19228375, 0.59375, 0.26154875, 0.37978375));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.625, 6.25E-4, 0.375, 0.6875, 0.250625, 0.4375));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.5625, 6.25E-4, 0.25, 0.8125, 6.25E-4, 0.4375));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.3125, 6.25E-4, 0.375, 0.375, 0.250625, 0.4375));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.1875, 6.25E-4, 0.25, 0.4375, 6.25E-4, 0.4375));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.625, 6.25E-4, 0.5625, 0.75, 0.188125, 0.75));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.625, 6.25E-4, 0.5, 0.9375, 6.25E-4, 0.75));
            SHAPENORTH = VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.25, 6.25E-4, 0.5625, 0.375, 0.188125, 0.75));
            return VoxelShapes.union(SHAPENORTH, VoxelShapes.cuboid(0.0625, 6.25E-4, 0.5, 0.375, 6.25E-4, 0.75));
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
