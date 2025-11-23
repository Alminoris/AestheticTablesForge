package net.alminoris.aesthetictables.block.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SingleTable extends YAxisRotatedBlock
{
    protected static final VoxelShape BASE = YAxisRotatedBlock.box(4.25D, 14.0D, 0.0D, 11.75D, 16.0D, 16.0D);
    protected static final VoxelShape BASE1 = YAxisRotatedBlock.box(0.0D, 14.0D, 4.25D, 16.0D, 16.0D, 11.75D);
    protected static final VoxelShape LEG = YAxisRotatedBlock.box(6.0D, 0.0D, 6.0D, 10.0D, 14.0D, 10.0D);

    public SingleTable(BlockBehaviour.Properties settings)
    {
        super(settings);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context)
    {
        VoxelShape shape = BASE;
        shape = Shapes.or(shape, BASE1);
        shape = Shapes.or(shape, LEG);
        return shape;
    }
}