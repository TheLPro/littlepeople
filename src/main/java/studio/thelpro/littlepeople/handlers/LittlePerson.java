package studio.thelpro.littlepeople.handlers;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class LittlePerson {

    String name;
    Color boots;
    Color leggings;
    Color chestplate;
    String head;
    Player spawner;

    public LittlePerson(String name, Color boots, Color leggings, Color chestplate, String head, Player spawner) {
        this.name = name;
        this.boots = boots;
        this.leggings = leggings;
        this.chestplate = chestplate;
        this.head = head;
        this.spawner = spawner;
    }

    public void summon() {

        Location spawnLocation = spawner.getLocation();

        Zombie minion = (Zombie) spawnLocation.getWorld().spawnEntity(spawnLocation, EntityType.ZOMBIE);
        minion.setAI(false);
        minion.setInvulnerable(true);
        minion.setBaby();
        minion.setCustomNameVisible(true);
        minion.setCustomName(ChatColor.translateAlternateColorCodes('&', name));
        minion.setInvisible(true);
        minion.setAgeLock(true);
        minion.setSilent(true);

        ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        skullMeta.setOwner(head);
        skull.setItemMeta(skullMeta);

        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemMeta chestplateMeta = chestplate.getItemMeta();
        LeatherArmorMeta chestplateLeatherMeta = (LeatherArmorMeta) chestplateMeta;
        chestplateLeatherMeta.setColor(this.chestplate);
        chestplate.setItemMeta(chestplateMeta);

        ItemStack legging = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemMeta leggingMeta = legging.getItemMeta();
        LeatherArmorMeta leggingLeatherMeta = (LeatherArmorMeta) leggingMeta;
        leggingLeatherMeta.setColor(this.leggings);
        legging.setItemMeta(leggingMeta);

        ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta bootMeta = boot.getItemMeta();
        LeatherArmorMeta bootLeatherMeta = (LeatherArmorMeta) bootMeta;
        bootLeatherMeta.setColor(this.boots);
        boot.setItemMeta(bootMeta);

        minion.getEquipment().setHelmet(skull);
        minion.getEquipment().setChestplate(chestplate);
        minion.getEquipment().setLeggings(legging);
        minion.getEquipment().setBoots(boot);

        minion.getEquipment().setHelmetDropChance(0);
        minion.getEquipment().setChestplateDropChance(0);
        minion.getEquipment().setLeggingsDropChance(0);
        minion.getEquipment().setBootsDropChance(0);

        spawner.sendMessage(minion.getName() + " was summoned.");
    }
}