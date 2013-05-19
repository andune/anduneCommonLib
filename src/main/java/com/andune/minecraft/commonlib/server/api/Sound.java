/**
 * 
 */
package com.andune.minecraft.commonlib.server.api;

/**
 * An Enum of Sounds we support that the server can send to the client.
 * 
 * @author andune
 *
 */
public enum Sound {
    THUNDER("thunder"),
    ENDERMAN_TELEPORT("endermanTeleport"),
    FIRE("fire"),
    EXPLODE("explode"),
    FIZZ("fizz"),
    PORTAL_TRIGGER("portalTrigger"),
    ENDERDRAGON_GROWL("enderdragonGrowl");
    
    private String name;
    private Sound(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
