package net.alminoris.aesthetictables.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class Table extends Block implements SimpleWaterloggedBlock
{
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public static final BooleanProperty LEG1 = BooleanProperty.create("leg1"); // northeast
    public static final BooleanProperty LEG2 = BooleanProperty.create("leg2"); // southeast
    public static final BooleanProperty LEG3 = BooleanProperty.create("leg3"); // southwest
    public static final BooleanProperty LEG4 = BooleanProperty.create("leg4"); // northwest
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    protected static final VoxelShape TOP = Block.box(0.0D, 13.5D, 0.0D, 16.0D, 16.0D, 16.0D);

    protected static final VoxelShape LEG_1 = Block.box(13.0D, 0.0D, 1.0D, 15.0D, 13.5D, 3.0D);  // NE
    protected static final VoxelShape LEG_2 = Block.box(13.0D, 0.0D, 13.0D, 15.0D, 13.5D, 15.0D); // SE
    protected static final VoxelShape LEG_3 = Block.box(1.0D, 0.0D, 13.0D, 3.0D, 13.5D, 15.0D);   // SW
    protected static final VoxelShape LEG_4 = Block.box(1.0D, 0.0D, 1.0D, 3.0D, 13.5D, 3.0D);     // NW

    public Table(BlockBehaviour.Properties settings)
    {
        super(settings.noOcclusion());
        registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(LEG1, true)
                .setValue(LEG2, true)
                .setValue(LEG3, true)
                .setValue(LEG4, true)
                .setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(FACING, LEG1, LEG2, LEG3, LEG4, WATERLOGGED);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext ctx)
    {
        boolean waterlogged = ctx.getLevel().getFluidState(ctx.getClickedPos()).getType() == net.minecraft.world.level.material.Fluids.WATER;
        return getUpdatedLegs(this.defaultBlockState()
                .setValue(FACING, ctx.getHorizontalDirection())
                .setValue(WATERLOGGED, waterlogged), ctx.getLevel(), ctx.getClickedPos());
    }

    @Override
    public BlockState updateShape(BlockState state, Direction dir, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos)
    {
        if (state.getValue(WATERLOGGED)) {
            world.scheduleTick(pos, net.minecraft.world.level.material.Fluids.WATER, net.minecraft.world.level.material.Fluids.WATER.getTickDelay(world));
        }
        return getUpdatedLegs(state, world, pos);
    }

    @Override
    public net.minecraft.world.level.material.FluidState getFluidState(BlockState state)
    {
        return state.getValue(WATERLOGGED) ? net.minecraft.world.level.material.Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    private BlockState getUpdatedLegs(BlockState state, LevelAccessor world, BlockPos pos)
    {
        boolean north = connectsTo(world, pos.north());
        boolean east = connectsTo(world, pos.east());
        boolean south = connectsTo(world, pos.south());
        boolean west = connectsTo(world, pos.west());

        boolean ne = connectsTo(world, pos.north().east());
        boolean se = connectsTo(world, pos.south().east());
        boolean sw = connectsTo(world, pos.south().west());
        boolean nw = connectsTo(world, pos.north().west());

        boolean leg1 = (!north && !east) || (north && east && !ne);
        boolean leg2 = (!east && !south) || (east && south && !se);
        boolean leg3 = (!south && !west) || (south && west && !sw);
        boolean leg4 = (!north && !west) || (north && west && !nw);

        return state.setValue(LEG1, leg1).setValue(LEG2, leg2).setValue(LEG3, leg3).setValue(LEG4, leg4);
    }

    private boolean connectsTo(LevelAccessor world, BlockPos pos)
    {
        BlockState neighbor = world.getBlockState(pos);
        return neighbor.getBlock() == this;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext ctx)
    {
        net.minecraft.world.phys.shapes.VoxelShape shape = TOP;
        if (state.getValue(LEG1)) shape = Shapes.or(shape, LEG_1);
        if (state.getValue(LEG2)) shape = Shapes.or(shape, LEG_2);
        if (state.getValue(LEG3)) shape = Shapes.or(shape, LEG_3);
        if (state.getValue(LEG4)) shape = Shapes.or(shape, LEG_4);
        return shape;
    }
}