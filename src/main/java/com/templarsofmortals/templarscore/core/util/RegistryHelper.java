package com.templarsofmortals.templarscore.core.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class RegistryHelper {
    public final String modId;
    public final DeferredRegister<Item> itemRegister;
    public final DeferredRegister<Block> blockRegister;

    public RegistryHelper(String modId) {
        this.modId = modId;
        this.itemRegister = DeferredRegister.create(ForgeRegistries.ITEMS, modId);
        this.blockRegister = DeferredRegister.create(ForgeRegistries.BLOCKS, modId);
    }

    public DeferredRegister<Item> getDeferredItemRegister() {
        return this.itemRegister;
    }

    public DeferredRegister<Block> getDeferredBlockRegister() {
        return this.blockRegister;
    }

    public RegistryObject<Item> createItem(String name, Supplier<? extends Item> supplier) {
        return this.itemRegister.register(name, supplier);
    }

    public static Item createSimpleItem(ItemGroup itemGroup) {
        return new Item(new Item.Properties().group(itemGroup));
    }

}
