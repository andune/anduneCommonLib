package com.andune.minecraft.commonlib.server.api;

/**
 * Abstraction of block ID/material. I really wanted to avoid this but since
 * there is no universal abstract Minecraft way to represent this concept
 * between different API frameworks (Bukkit and Sponge), I must abstract it
 * here.
 *
 * Out of sheer laziness, I only define the BlockTypes that I use in my
 * plugins (HSP) to avoid having to keep an accurate list forever. So this
 * will only ever be a partial just-enough-implementation class to cover
 * my needs.
 *
 * @author andune
 */
public enum BlockTypes {
    AIR,
    YELLOW_FLOWER,
    RED_ROSE,
    BROWN_MUSHROOM,
    RED_MUSHROOM,
    LONG_GRASS,
    DEAD_BUSH,
    CROPS,
    TORCH,
    REDSTONE_WIRE,
    REDSTONE_TORCH_ON,
    REDSTONE_TORCH_OFF,
    REDSTONE_LAMP_OFF,
    REDSTONE_LAMP_ON,
    DIODE_BLOCK_ON,
    DIODE_BLOCK_OFF,
    POWERED_RAIL,
    DETECTOR_RAIL,
    RAILS,
    SIGN_POST,
    WALL_SIGN,

    CARPET,
    STONE_PLATE,
    WOOD_PLATE,
    GOLD_PLATE,
    IRON_PLATE,
    LADDER,
    SNOW,
    WEB,
    VINE,
    SAPLING,
    STONE_BUTTON,
    LEVER,
    SUGAR_CANE_BLOCK,
    CARROT,
    POTATO,
    WOOD_BUTTON,

    BED;
}
