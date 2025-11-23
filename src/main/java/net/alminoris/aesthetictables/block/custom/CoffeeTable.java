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

import javax.swing.text.html.BlockView;

public class CoffeeTable extends Block implements SimpleWaterloggedBlock
{
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public static final BooleanProperty LEG1 = BooleanProperty.create("leg1"); // northeast
    public static final BooleanProperty LEG2 = BooleanProperty.create("leg2"); // southeast
    public static final BooleanProperty LEG3 = BooleanProperty.create("leg3"); // southwest
    public static final BooleanProperty LEG4 = BooleanProperty.create("leg4"); // northwest
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    protected static final VoxelShape TOP = Block.box(
            0.0D, 6.0D, 0.0D,
            16.0D, 8.0D, 16.0D
    );

    // Ніжка в NE (права передня)
    protected static final VoxelShape LEG_1 = Block.box(
            13.0D, 0.0D, 0.0D,
            16.0D, 6.0D, 3.0D
    );

    // Ніжка в SE (права задня)
    protected static final VoxelShape LEG_2 = Block.box(
            13.0D, 0.0D, 13.0D,
            16.0D, 6.0D, 16.0D
    );

    // Ніжка в SW (ліва задня)
    protected static final VoxelShape LEG_3 = Block.box(
            0.0D, 0.0D, 13.0D,
            3.0D, 6.0D, 16.0D
    );

    // Ніжка в NW (ліва передня)
    protected static final VoxelShape LEG_4 = Block.box(
            0.0D, 0.0D, 0.0D,
            3.0D, 6.0D, 3.0D
    );

    public CoffeeTable(BlockBehaviour.Properties settings)
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
        boolean waterlogged = ctx.getLevel().getFluidState(ctx.getClickedPos()).getType() == Fluids.WATER;
        return getUpdatedLegs(this.defaultBlockState()
                .setValue(FACING, ctx.getHorizontalDirection())
                .setValue(WATERLOGGED, waterlogged), ctx.getLevel(), ctx.getClickedPos());
    }

    @Override
    public BlockState updateShape(BlockState state, Direction dir, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos)
    {
        if (state.getValue(WATERLOGGED)) {
            world.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }
        return getUpdatedLegs(state, world, pos);
    }

    @Override
    public FluidState getFluidState(BlockState state)
    {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
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
        VoxelShape shape = TOP;
        if (state.getValue(LEG1)) shape = Shapes.or(shape, LEG_1);
        if (state.getValue(LEG2)) shape = Shapes.or(shape, LEG_2);
        if (state.getValue(LEG3)) shape = Shapes.or(shape, LEG_3);
        if (state.getValue(LEG4)) shape = Shapes.or(shape, LEG_4);
        return shape;
    }
}