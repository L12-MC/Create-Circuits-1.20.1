package net.l12.createcircuits.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.l12.createcircuits.CreateCircuits;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item SAND_PILE = registerItem("sand_pile", new Item(new FabricItemSettings()));
    public static final Item CIRCUIT = registerItem("circuit", new Item(new FabricItemSettings()));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(SAND_PILE);
        entries.add(CIRCUIT);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CreateCircuits.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CreateCircuits.LOGGER.info("Registering Mod Items for " + CreateCircuits.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}