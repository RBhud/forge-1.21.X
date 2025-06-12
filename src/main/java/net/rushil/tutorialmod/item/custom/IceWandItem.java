package net.rushil.tutorialmod.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;

import java.util.Map;

public class IceWandItem extends Item {

    public IceWandItem(Item.Properties pProperties) { super(pProperties); }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

        if (clickedBlock != Blocks.ICE && !(clickedBlock instanceof BushBlock)) {

            if (!level.isClientSide()) {

                level.setBlockAndUpdate(pContext.getClickedPos(), Blocks.ICE.defaultBlockState());

                pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                        item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, pContext.getClickedPos(), SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS);

            }
        }

        return super.useOn(pContext);
    }

}
