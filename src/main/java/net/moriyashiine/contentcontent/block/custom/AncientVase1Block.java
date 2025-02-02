package net.moriyashiine.contentcontent.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Equipment;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
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
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.*;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.moriyashiine.contentcontent.particle.ModParticles;
import org.jetbrains.annotations.Nullable;

public class AncientVase1Block extends HorizontalFacingBlock implements Equipment {
   public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
   public static final BooleanProperty GENERATED = Properties.ENABLED;
   public static final Integer Face = null;
   private static VoxelShape SHAPE = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0);
   private static VoxelShape SHAPE2 = Block.createCuboidShape(4.0, 12.0, 4.0, 12.0, 16.0, 12.0);
   Boolean Going = true;
   Integer BlocksLeft = -1;

   public AncientVase1Block(AbstractBlock.Settings settings) {
      super(settings);
      this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(GENERATED, true));
   }

   public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
      return VoxelShapes.union(SHAPE, SHAPE2);
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

   protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
      builder.add(new Property[]{FACING});
      builder.add(new Property[]{GENERATED});
   }

   public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity player, ItemStack itemStack) {
      this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(GENERATED, false));
   }

   private void GridGen(BlockPos Low, BlockPos High, PlayerEntity player, World world, BlockPos Center) {
      BlockPos NewBlock = Center.add(0, 0, 0);
      if (world instanceof ServerWorld serverWorld) {
         ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)player;
         if (serverPlayerEntity != null) {
            serverWorld.getBlockEntity(Low, BlockEntityType.SCULK_SHRIEKER).ifPresent(blockEntity -> {
               blockEntity.shriek(serverWorld, serverPlayerEntity);
               this.Going = true;
            });
         }
      }
   }

   public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
      player.incrementStat(Stats.MINED.getOrCreateStat(this));
      player.addExhaustion(0.005F);
      world.addImportantParticle(
              ModParticles.VASE_BREAK_PARTICLE, (double)pos.getX() + 0.5, (double)pos.getY() + 0.75, (double)pos.getZ() + 0.5, 0.0, 0.0, 0.0
      );
      world.playSound(player, pos, SoundEvents.BLOCK_SCULK_SHRIEKER_SHRIEK, SoundCategory.BLOCKS, 1.0F, 1.0F);
      this.GridGen(pos.add(-1, 0, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(-2, 0, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(-3, 0, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(-4, 0, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(-5, 0, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(-6, 0, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(-7, 0, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(-8, 0, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(-9, 0, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(-10, 0, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(1, 0, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(2, 0, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(3, 0, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(4, 0, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(5, 0, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(6, 0, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(7, 0, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(8, 0, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(9, 0, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(10, 0, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 0, -1), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 0, -2), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 0, -3), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 0, -4), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 0, -5), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 0, -6), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 0, -7), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 0, -8), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 0, -9), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 0, -10), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 0, 1), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 0, 2), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 0, 3), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 0, 4), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 0, 5), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 0, 6), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 0, 7), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 0, 8), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 0, 9), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 0, 10), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, -1, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, -2, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, -3, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, -4, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, -5, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, -6, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, -7, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, -8, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, -9, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, -10, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 1, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 2, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 3, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 4, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 5, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 6, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 7, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 8, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 9, 0), pos.add(8, 0, 0), player, world, pos);
      this.GridGen(pos.add(0, 10, 0), pos.add(8, 0, 0), player, world, pos);
      super.onBreak(world, pos, state, player);
   }

   @Override
   public EquipmentSlot getSlotType() {
      return null;
   }
}