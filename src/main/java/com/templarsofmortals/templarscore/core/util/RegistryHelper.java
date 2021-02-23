package com.templarsofmortals.templarscore.core.util;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
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

    /**
     * Creates an item that has contains a name and supplier
     * @param name     - Name of the item (String, example: iron_ingot)
     * @param supplier - The supplier (Way to use: () -> Item(PROPERTIES)
     * @return Creates an item in the register.
     */
    public RegistryObject<Item> createItem(String name, Supplier<? extends Item> supplier) {
        return this.itemRegister.register(name, supplier);
    }

    /**
     * Creates a block that contains a name, supplier and a item that is in a itemGroup
     * @param name - Name of the block (String, example: cobblestone)
     * @param supplier - The supplier (Way to use: () -> new Block)
     * @param itemGroup - ItemGroup the BlockItem will be stored
     * @return Creates an block in the register
     */
    public RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, ItemGroup itemGroup) {
        RegistryObject<Block> block = this.blockRegister.register(name, supplier);
        this.itemRegister.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(itemGroup)));
        return block;
    }
}
