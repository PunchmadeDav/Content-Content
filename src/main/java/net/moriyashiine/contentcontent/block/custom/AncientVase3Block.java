package net.moriyashiine.contentcontent.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Equipment;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
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
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.moriyashiine.contentcontent.particle.ModParticles;
import org.jetbrains.annotations.Nullable;

public class AncientVase3Block extends HorizontalFacingBlock implements Equipment {
   public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
   public static final BooleanProperty GENERATED = Properties.ENABLED;

   public AncientVase3Block(AbstractBlock.Settings settings) {
      super(settings);
      this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(GENERATED, true));
   }

   public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
      VoxelShape shape = VoxelShapes.empty();
      shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.25, 2.375, 0.25, 0.75, 2.5625, 0.75));
      return VoxelShapes.union(shape, VoxelShapes.cuboid(0.1875, 0.0, 0.1875, 0.8125, 2.375, 0.8125));
   }

   @Nullable
   public BlockState getPlacementState(ItemPlacementContext ctx) {
      return (BlockState)this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
   }

   public BlockState rotate(BlockState state, BlockRotation rotation) {
      return (BlockState)state.with(FACING, rotation.rotate((Direction) state.get(FACING)));
   }

   public BlockState mirror(BlockState state, BlockMirror mirror) {
      return state.rotate(mirror.getRotation((Direction)state.get(FACING)));
   }

   public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
      player.incrementStat(Stats.MINED.getOrCreateStat(this));
      player.addExhaustion(0.005F);
      world.playSound(player, pos, SoundEvents.BLOCK_SCULK_SHRIEKER_SHRIEK, SoundCategory.BLOCKS, 1.0F, 1.0F);
      world.addImportantParticle(
              ModParticles.VASE_BREAK_PARTICLE, (double)pos.getX() + 0.5, (double)pos.getY() + 2.5, (double)pos.getZ() + 0.5, 0.0, 0.0, 0.0
      );
      super.onBreak(world, pos, state, player);
   }

   protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
      builder.add(new Property[]{GENERATED, FACING});
   }

   public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity player, ItemStack itemStack) {
      this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(GENERATED, false));
   }

   @Override
   public EquipmentSlot getSlotType() {
      return null;
   }
}
