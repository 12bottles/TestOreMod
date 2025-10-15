package com.twelvebottles.neworemod.event;

import com.twelvebottles.neworemod.NewOreMod;
import com.twelvebottles.neworemod.block.ModBlocks;
import com.twelvebottles.neworemod.item.ModItems;
import com.twelvebottles.neworemod.item.custom.HammerItem;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.horse.Donkey;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.packets.SpawnEntity;
import org.checkerframework.checker.units.qual.A;
import org.jetbrains.annotations.Nullable;

import java.util.*;

@Mod.EventBusSubscriber(modid = NewOreMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();
    public static final List<Animal> wabbaTransformList = new ArrayList<Animal>();

    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    // Don't be a jerk License
    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if(mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer) {

            int breakRange = 1;
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }


            for(BlockPos pos : HammerItem.getBlocksToBeDestroyed(breakRange, initialBlockPos, serverPlayer)) {
                if(pos == initialBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        if(event.getEntity() instanceof Animal animal && event.getSource().getDirectEntity() instanceof Player player) {
            if(player.getMainHandItem().getItem() == Items.STICK) {
                player.sendSystemMessage(Component.literal("You're a wizard, " + player.getName().getString()));
                animal.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 9));
                animal.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 40, 10));
                animal.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 1000, 10));
                player.addItem(ModItems.RAW_SABLONIUM.get().getDefaultInstance());
            }
        }
    }

    @SubscribeEvent
    public static void interactWithEndermite(PlayerInteractEvent.EntityInteract event) {
        if(event.getTarget() instanceof Endermite endermite && event.getEntity() instanceof Player player) {
            if(player.getMainHandItem().getItem() == Items.STICK) {
                if(!player.getCooldowns().isOnCooldown(player.getMainHandItem().getItem())) {
                    player.getCooldowns().addCooldown(player.getMainHandItem().getItem(), 60);
                    player.sendSystemMessage(Component.literal(player.getName().getString() + " loves useless mobs"));
                    endermite.setAggressive(false);
                    endermite.setNoGravity(true);
                    endermite.setCustomName(player.getName());
                }
            }
        }
    }



    @SubscribeEvent
    public static void wabbaSab(PlayerInteractEvent.EntityInteract event) {
        if(event.getTarget() instanceof Animal animal && event.getEntity() instanceof Player player)
        {
            // player.sendSystemMessage(Component.literal("Found " + player.getName().getString()));
            if(player.getMainHandItem().getItem() == Items.STICK) {
                // player.sendSystemMessage(Component.literal(player.getName().getString() + " is trying something..."));
            // Change out for new item when made
                if(!player.getCooldowns().isOnCooldown(player.getMainHandItem().getItem())) {
                    player.getCooldowns().addCooldown(player.getMainHandItem().getItem(), 100);
                    player.sendSystemMessage(Component.literal("It's working..."));
                    Vec3 currentPos = animal.getPosition(1);
                    Animal newAnimal = wabbaRandomMob(animal);

                    animal.remove(Entity.RemovalReason.KILLED);
                }
            }
        }
    }

    public static Animal wabbaRandomMob(Animal animal) {
        Random random = new Random();

        if (wabbaTransformList.isEmpty()) {
            wabbaTransformList.add(new Cow(EntityType.COW, animal.level()));
            wabbaTransformList.add(new Pig(EntityType.PIG, animal.level()));
            wabbaTransformList.add(new Sheep(EntityType.SHEEP, animal.level()));
            wabbaTransformList.add(new Wolf(EntityType.WOLF, animal.level()));
            wabbaTransformList.add(new Horse(EntityType.HORSE, animal.level()));
            wabbaTransformList.add(new Donkey(EntityType.DONKEY, animal.level()));
        }

        return wabbaTransformList.get(random.nextInt(wabbaTransformList.size()));
    }

    public void spawnAnimal(Animal animal) {

    }
}