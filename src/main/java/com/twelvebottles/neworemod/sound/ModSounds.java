package com.twelvebottles.neworemod.sound;

import com.twelvebottles.neworemod.NewOreMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, NewOreMod.MOD_ID);

    public static final RegistryObject<SoundEvent> CHISEL_USE = registerSoundEvent("chisel_use");

    public static final RegistryObject<SoundEvent> TRANSMUTATOR_BREAK = registerSoundEvent("transmutator_break");
    public static final RegistryObject<SoundEvent> TRANSMUTATOR_STEP = registerSoundEvent("transmutator_step");
    public static final RegistryObject<SoundEvent> TRANSMUTATOR_PLACE = registerSoundEvent("transmutator_place");
    public static final RegistryObject<SoundEvent> TRANSMUTATOR_HIT = registerSoundEvent("transmutator_hit");
    public static final RegistryObject<SoundEvent> TRANSMUTATOR_FALL = registerSoundEvent("transmutator_fall");

    public static final ForgeSoundType TRANSMUTATOR_SOUNDS = new ForgeSoundType(1f, 1f,
            ModSounds.TRANSMUTATOR_BREAK, ModSounds.TRANSMUTATOR_STEP, ModSounds.TRANSMUTATOR_PLACE,
            ModSounds.TRANSMUTATOR_HIT, ModSounds.TRANSMUTATOR_FALL);

    public static final RegistryObject<SoundEvent> BAR_BRAWL = registerSoundEvent("bar_brawl");
    public static final ResourceKey<JukeboxSong> BAR_BRAWL_KEY = ResourceKey.create(Registries.JUKEBOX_SONG,
            ResourceLocation.fromNamespaceAndPath(NewOreMod.MOD_ID, "bar_brawl"));





    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(NewOreMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}