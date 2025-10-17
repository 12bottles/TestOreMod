package com.twelvebottles.neworemod.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

public record FireballEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<FireballEnchantmentEffect> CODEC = MapCodec.unit(FireballEnchantmentEffect::new);


    @Override
    public void apply(ServerLevel pLevel, int pEnchantmentLevel, EnchantedItemInUse pItem, Entity pEntity, Vec3 pOrigin) {

        // There's definitely a better way of doing this. I'm sure I'll come back to it later.
        if(pEnchantmentLevel == 1) {
            spawnFireball(pLevel, pEntity, 0, 0, 0, 0.2F);
        }

        if(pEnchantmentLevel == 2) {
            spawnFireball(pLevel, pEntity, 0, 0, 0, 0.2F);
            spawnFireball(pLevel, pEntity, 0, 5, 0, 0.2F);
        }

        if(pEnchantmentLevel == 3) {
            spawnFireball(pLevel, pEntity, 0, 0, 0, 0.1F);
            spawnFireball(pLevel, pEntity, 0, 5, 2, 0.1F);
            spawnFireball(pLevel, pEntity, 0, 5, -2, 0.1F);
            spawnFireball(pLevel, pEntity, 2, 5, 0, 0.1F);
            spawnFireball(pLevel, pEntity, 2, 10, 2, 0.1F);
            spawnFireball(pLevel, pEntity, 2, 10, -2, 0.1F);
            spawnFireball(pLevel, pEntity, -2, 5, 0, 0.1F);
            spawnFireball(pLevel, pEntity, -2, 10, 2, 0.1F);
            spawnFireball(pLevel, pEntity, -2, 10, -2, 0.1F);
        }
    }

    public void spawnFireball(ServerLevel pLevel, Entity pEntity, int offsetX, int offsetY, int offsetZ, float ballVelocity) {
        BlockPos ballPos = pEntity.getOnPos();

        ballPos = new BlockPos(ballPos.getX() + offsetX, ballPos.getY() + 5 + offsetY, ballPos.getZ() + offsetZ);

        LargeFireball fireball = EntityType.FIREBALL.spawn(pLevel, ballPos, MobSpawnType.TRIGGERED);
        fireball.shoot(0, -1, 0, ballVelocity, 1);
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}