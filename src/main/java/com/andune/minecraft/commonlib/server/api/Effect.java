/**
 * 
 */
package com.andune.minecraft.commonlib.server.api;


/**
 * A list of effects that the server is able to send to players.
 * 
 * @author andune
 *
 */
public enum Effect {
    SMOKE("smoke"),
    POTION_BREAK("potionBreak"),
    ENDER_SIGNAL("enderSignal"),
    MOBSPAWNER_FLAMES("fire"),
    LIGHTNING("lightning");
    
    private String name;
    private Effect(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
