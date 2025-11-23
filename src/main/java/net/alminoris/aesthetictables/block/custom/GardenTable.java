package net.alminoris.aesthetictables.block.custom;

import net.alminoris.aesthetictables.util.helper.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

public class GardenTable extends YAxisRotatedBlock
{
    protected static final VoxelShape TABLE_TOP = YAxisRotatedBlock.box(
            0.0D, 14.0D, 0.0D,
            16.0D, 16.0D, 16.0D
    );

    protected static final VoxelShape LEG_FRONT = YAxisRotatedBlock.box(
            1.0D, 0.0D, 0.0D,
            3.0D, 14.0D, 16.0D
    );

    protected static final VoxelShape LEG_BACK = YAxisRotatedBlock.box(
            13.0D, 0.0D, 0.0D,
            15.0D, 14.0D, 16.0D
    );

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public enum Variant implements StringRepresentable
    {
        NORMAL("normal"),
        CENTER("center"),
        LEFT("left"),
        RIGHT("right");

        private final String name;

        Variant(String name) { this.name = name; }

        @Override
        public String getSerializedName() { return this.name; }
    }

    public static final EnumProperty<Variant> VARIANT = EnumProperty.create("variant", Variant.class);

    public GardenTable(BlockBehaviour.Properties settings)
    {
        super(settings.noOcclusion());
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(VARIANT, Variant.NORMAL).setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(FACING, VARIANT, WATERLOGGED);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context)
    {
        return getRotatedShape(state);
    }

    private VoxelShape getRotatedShape(BlockState state)
    {
        Direction direction = state.getValue(FACING);
        Variant variant = state.getValue(VARIANT);

        List<AABB> boxes = new ArrayList<>();
        switch (variant)
        {
            case NORMAL:
                boxes.add(TABLE_TOP.bounds());
                boxes.add(LEG_FRONT.bounds());
                boxes.add(LEG_BACK.bounds());
                break;
            case CENTER:
                boxes.add(TABLE_TOP.bounds());
                break;
            case LEFT:
                boxes.add(TABLE_TOP.bounds());
                boxes.add(LEG_FRONT.bounds());
                break;
            case RIGHT:
                boxes.add(TABLE_TOP.bounds());
                boxes.add(LEG_BACK.bounds());
                break;
        }

        return VoxelShapeHelper.rotateShape(boxes, direction);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx)
    {
        boolean waterlogged = ctx.getLevel().getFluidState(ctx.getClickedPos()).getType() == Fluids.WATER;
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection()).setValue(WATERLOGGED, waterlogged);
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos)
    {
        if (state.getValue(WATERLOGGED))
        {
            world.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }
        return updateGardenTableVariant(state, world, pos);
    }

    @Override
    public FluidState getFluidState(BlockState state)
    {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean notify)
    {
        super.onPlace(state, world, pos, oldState, notify);
        updateSurroundingGardenTablees(world, pos);
    }

    private void updateSurroundingGardenTablees(Level world, BlockPos pos)
    {
        for (Direction direction : Direction.Plane.HORIZONTAL)
        {
            BlockPos neighborPos = pos.offset(direction.getNormal());
            BlockState neighborState = world.getBlockState(neighborPos);

            if (neighborState.getBlock() == this)
                world.setBlock(neighborPos, updateGardenTableVariant(neighborState, world, neighborPos), 3);
        }
    }

    private BlockState updateGardenTableVariant(BlockState state, LevelAccessor world, BlockPos pos)
    {
        Direction facing = state.getValue(FACING);

        BlockPos leftPos = pos.offset(facing.getCounterClockWise(Direction.Axis.Y).getNormal());
        BlockPos rightPos = pos.offset(facing.getClockWise(Direction.Axis.Y).getNormal());

        boolean leftConnected = isGardenTable(world, leftPos, facing);
        boolean rightConnected = isGardenTable(world, rightPos, facing);

        if (leftConnected && rightConnected)
            return state.setValue(VARIANT, Variant.CENTER);
        else if (leftConnected)
            return state.setValue(VARIANT, Variant.RIGHT);
        else if (rightConnected)
            return state.setValue(VARIANT, Variant.LEFT);
        else
            return state.setValue(VARIANT, Variant.NORMAL);
    }

    private boolean isGardenTable(LevelAccessor world, BlockPos pos, Direction facing)
    {
        BlockState state = world.getBlockState(pos);
        return state.getBlock() == this && state.getValue(FACING) == facing;
    }
}