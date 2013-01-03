/**
 * 
 */
package org.morganm.mBukkitLib;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/** General routines that have some Bukkit dependency. This is opposed to
 * the General class which is guaranteed to not have any Bukkit dependencies.
 * 
 * @author morganm
 *
 */
public class GeneralBukkit {
    
    public String shortLocationString(final Location l) {
        if( l == null )
            return "null";
        else {
            World w = l.getWorld();
            String worldName = null;
            if( w != null )
                worldName = w.getName();
            else
                worldName = "(world deleted)";
            return worldName+","+l.getBlockX()+","+l.getBlockY()+","+l.getBlockZ();
        }
    }
    
    /** Read a string that was written by "shortLocationString" and turn it into
     * a location object (if possible). Can return null.
     * 
     * @param locatinString
     * @return
     */
    public Location readShortLocationString(final String locationString) {
        Location location = null;
        if( locationString != null ) {
            String[] pieces = locationString.split(",");
            
            // make sure all the elements are there and it's not a deleted world 
            if( pieces.length == 4 && !pieces[0].equals("(world deleted)") ) {
                World w = Bukkit.getWorld(pieces[0]);
                int x = 0; int y = 0; int z = 0;
                try {
                    x = Integer.parseInt(pieces[1]);
                    y = Integer.parseInt(pieces[2]);
                    z = Integer.parseInt(pieces[3]);
                } catch(NumberFormatException e) {}
                
                location = new Location(w, x, y, z);
            }
        }
        
        return location;
    }
    
    /** Return whether or not Player p is a new player (first time logged in).
     * 
     * Bukkit method seems wonky at times, so this is coded to check for player.dat
     * on the default world.
     * 
     * @param p
     * @return
     */
    public boolean isNewPlayer(Player p) {
        // Bukkit method is wonky, doesn't seem to work consistently
//      return !p.hasPlayedBefore();
        
        File worldContainer = Bukkit.getWorldContainer();
        
        final List<World> worlds = Bukkit.getWorlds();
        final String worldName = worlds.get(0).getName();
        final String playerDat = p.getName() + ".dat";
        
        File file = new File(worldContainer, worldName+"/players/"+playerDat);
        if( file.exists() )
            return false;

        // if we didn't find a player.dat file, they must be new
        return true;
    }

    /** Code borrowed from @Diddiz's LogBlock
     * 
     * @param items1
     * @param items2
     * @return
     */
    public ItemStack[] compareInventories(ItemStack[] items1, ItemStack[] items2) {
        final ItemStackComparator comperator = new ItemStackComparator();
        final ArrayList<ItemStack> diff = new ArrayList<ItemStack>();
        final int l1 = items1.length, l2 = items2.length;
        int c1 = 0, c2 = 0;
        while (c1 < l1 || c2 < l2) {
            if (c1 >= l1) {
                diff.add(items2[c2]);
                c2++;
                continue;
            }
            if (c2 >= l2) {
                items1[c1].setAmount(items1[c1].getAmount() * -1);
                diff.add(items1[c1]);
                c1++;
                continue;
            }
            final int comp = comperator.compare(items1[c1], items2[c2]);
            if (comp < 0) {
                items1[c1].setAmount(items1[c1].getAmount() * -1);
                diff.add(items1[c1]);
                c1++;
            } else if (comp > 0) {
                diff.add(items2[c2]);
                c2++;
            } else {
                final int amount = items2[c2].getAmount() - items1[c1].getAmount();
                if (amount != 0) {
                    items1[c1].setAmount(amount);
                    diff.add(items1[c1]);
                }
                c1++;
                c2++;
            }
        }
        return diff.toArray(new ItemStack[diff.size()]);
    }

    /** Code borrowed from @Diddiz's LogBlock
     * 
     * @param items
     * @return
     */
    public ItemStack[] compressInventory(ItemStack[] items) {
        final ArrayList<ItemStack> compressed = new ArrayList<ItemStack>();
        for (final ItemStack item : items)
            if (item != null) {
                final int type = item.getTypeId();
                final byte data = rawData(item);
                boolean found = false;
                for (final ItemStack item2 : compressed)
                    if (type == item2.getTypeId() && data == rawData(item2)) {
                        item2.setAmount(item2.getAmount() + item.getAmount());
                        found = true;
                        break;
                    }
                if (!found)
                    compressed.add(new ItemStack(type, item.getAmount(), (short)0, data));
            }
        Collections.sort(compressed, new ItemStackComparator());
        return compressed.toArray(new ItemStack[compressed.size()]);
    }

    /** Code borrowed from @Diddiz's LogBlock 
     * 
     * @param item
     * @return
     */
    public byte rawData(ItemStack item) {
        return item.getType() != null ? item.getData() != null ? item.getData().getData() : 0 : 0;
    }
    
    /** Code borrowed from @Diddiz's LogBlock 
     * 
     * @param item
     * @return
     */
    public class ItemStackComparator implements Comparator<ItemStack>
    {
        @Override
        public int compare(ItemStack a, ItemStack b) {
            final int aType = a.getTypeId(), bType = b.getTypeId();
            if (aType < bType)
                return -1;
            if (aType > bType)
                return 1;
            final byte aData = rawData(a), bData = rawData(b);
            if (aData < bData)
                return -1;
            if (aData > bData)
                return 1;
            return 0;
        }
    }
}
