package me.thelpro.commands;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.*;

public class summonCommand implements CommandExecutor {

    public static Color stringToColor(String string) {

        string.toLowerCase();
        Color color = null;

        if (Objects.equals(string, "red"))
            color = Color.RED;
        if (Objects.equals(string, "maroon"))
            color = Color.MAROON;
        if (Objects.equals(string, "orange"))
            color = Color.ORANGE;
        if (Objects.equals(string, "yellow"))
            color = Color.YELLOW;
        if (Objects.equals(string, "green"))
            color = Color.GREEN;
        if (Objects.equals(string, "navy"))
            color = Color.NAVY;
        if (Objects.equals(string, "olive"))
            color = Color.OLIVE;
        if (Objects.equals(string, "lime"))
            color = Color.LIME;
        if (Objects.equals(string, "blue"))
            color = Color.BLUE;
        if (Objects.equals(string, "teal"))
            color = Color.TEAL;
        if (Objects.equals(string, "aqua"))
            color = Color.AQUA;
        if (Objects.equals(string, "purple"))
            color = Color.PURPLE;
        if (Objects.equals(string, "pink"))
            color = Color.FUCHSIA;
        if (Objects.equals(string, "black"))
            color = Color.BLACK;
        if (Objects.equals(string, "gray"))
            color = Color.GRAY;
        if (Objects.equals(string, "silver"))
            color = Color.SILVER;
        if (Objects.equals(string, "white"))
            color = Color.WHITE;
        if (color == null)
            color = Color.WHITE;

        return color;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        if (args.length == 0)
            player.sendMessage(ChatColor.RED +  "Incorrect command usage. " + ChatColor.YELLOW + "/summonperson help" + ChatColor.RED + " for more.");

        if (args.length == 1 &&  Objects.equals(args[0], "help"))
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&ke&r&lPossible Commands&r&ke&r \n&e1. &r /summonperson e &7(or elephant)&r <name> \n&r&e2. &r /summonperson d &7(or dwarf)&r <name> \n&r&e4. &r /summonperson c &7 (or custom)&r <player-name> <chestplate-color> <leggings-color> <boots-color> <name> \n\n &e/summonperson help colors &rfor help in the colors."));
        if (Objects.equals(args[0], "help") && Objects.equals(args[1], "colors"))
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&ke&r&l&4C&6o&el&2o&1r&5s&r&ke&r \n&4Maroon&r, &cRed&r, &6Orange&r, &eYellow&r, &2Green&r, &2Olive&7 (there is no olive in chat)&r, &aLime&r, &3Teal&r, &3Navy&7 (same as with Olive)&r, &1Blue&r, &bAqua&r, &5Purple&r, &dPink&r, &fWhite&r, &7Silver&r, &8Gray&r, &0Black&r."));

        if (Objects.equals(args[0], "e") || Objects.equals(args[0], "elephant")) {

            if (args.length != 2)
                player.sendMessage(ChatColor.RED +  "Incorrect command usage. " + ChatColor.YELLOW + "/summonperson help" + ChatColor.RED + " for more.");

            Zombie minion = (Zombie) player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
            minion.setAI(false);
            minion.setInvulnerable(true);
            minion.setBaby();
            minion.setCustomNameVisible(true);
            minion.setCustomName(ChatColor.translateAlternateColorCodes('&', args[1].toString()));
            minion.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, (int) Double.POSITIVE_INFINITY, 1, true, false));

            ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1);
            SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
            skullMeta.setOwner("elephant");
            skull.setItemMeta(skullMeta);

            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemMeta chestplateMeta = chestplate.getItemMeta();
            LeatherArmorMeta chestplateLeatherMeta = (LeatherArmorMeta) chestplateMeta;
            chestplateLeatherMeta.setColor(Color.GRAY);
            chestplate.setItemMeta(chestplateMeta);

            ItemStack legging = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemMeta leggingMeta = legging.getItemMeta();
            LeatherArmorMeta leggingLeatherMeta = (LeatherArmorMeta) leggingMeta;
            leggingLeatherMeta.setColor(Color.GRAY);
            legging.setItemMeta(leggingMeta);

            ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta bootMeta = boot.getItemMeta();
            LeatherArmorMeta bootLeatherMeta = (LeatherArmorMeta) bootMeta;
            bootLeatherMeta.setColor(Color.GRAY);
            boot.setItemMeta(bootMeta);

            minion.getEquipment().setHelmet(skull);
            minion.getEquipment().setChestplate(chestplate);
            minion.getEquipment().setLeggings(legging);
            minion.getEquipment().setBoots(boot);

            minion.getEquipment().setHelmetDropChance(0);
            minion.getEquipment().setChestplateDropChance(0);
            minion.getEquipment().setLeggingsDropChance(0);
            minion.getEquipment().setBootsDropChance(0);

            player.sendMessage(minion.getName() + " was summoned.");

            return true;

        }

        if (Objects.equals(args[0], "d") || Objects.equals(args[0], "dwarf")) {

            if (args.length != 2)
                player.sendMessage(ChatColor.RED + "Incorrect command usage. " + ChatColor.YELLOW + "/summonperson help" + ChatColor.RED + " for more.");

            Zombie minion = (Zombie) player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
            minion.setAI(false);
            minion.setInvulnerable(true);
            minion.setBaby();
            minion.setCustomNameVisible(true);
            minion.setCustomName(ChatColor.translateAlternateColorCodes('&', args[1].toString()));
            minion.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, (int) Double.POSITIVE_INFINITY, 1, true, false));

            ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1);
            SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
            skullMeta.setOwner("_Gfe");
            skull.setItemMeta(skullMeta);

            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemMeta chestplateMeta = chestplate.getItemMeta();
            LeatherArmorMeta chestplateLeatherMeta = (LeatherArmorMeta) chestplateMeta;
            chestplateLeatherMeta.setColor(Color.LIME);
            chestplate.setItemMeta(chestplateMeta);

            ItemStack legging = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemMeta leggingMeta = legging.getItemMeta();
            LeatherArmorMeta leggingLeatherMeta = (LeatherArmorMeta) leggingMeta;
            leggingLeatherMeta.setColor(Color.BLUE);
            legging.setItemMeta(leggingMeta);

            ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);

            minion.getEquipment().setHelmet(skull);
            minion.getEquipment().setChestplate(chestplate);
            minion.getEquipment().setLeggings(legging);
            minion.getEquipment().setBoots(boot);

            minion.getEquipment().setHelmetDropChance(0);
            minion.getEquipment().setChestplateDropChance(0);
            minion.getEquipment().setLeggingsDropChance(0);
            minion.getEquipment().setBootsDropChance(0);

            player.sendMessage(minion.getName() + " was summoned.");

            return true;

        }

        if (Objects.equals(args[0], "c") || Objects.equals(args[0], "custom")) {

            if (args.length != 6)
                player.sendMessage(ChatColor.RED + "Incorrect command usage. " + ChatColor.YELLOW + "/summonperson help" + ChatColor.RED + " for more.");

            Zombie minion = (Zombie) player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
            minion.setAI(false);
            minion.setInvulnerable(true);
            minion.setBaby();
            minion.setCustomNameVisible(true);
            minion.setCustomName(ChatColor.translateAlternateColorCodes('&', args[5].toString()));
            minion.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, (int) Double.POSITIVE_INFINITY, 1, true, false));

            ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1);
            SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
            skullMeta.setOwner(args[1].toString());
            skull.setItemMeta(skullMeta);

            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemMeta chestplateMeta = chestplate.getItemMeta();
            LeatherArmorMeta chestplateLeatherMeta = (LeatherArmorMeta) chestplateMeta;
            chestplateLeatherMeta.setColor(stringToColor(args[2].toString()));
            chestplate.setItemMeta(chestplateMeta);

            ItemStack legging = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemMeta leggingMeta = legging.getItemMeta();
            LeatherArmorMeta leggingLeatherMeta = (LeatherArmorMeta) leggingMeta;
            leggingLeatherMeta.setColor(stringToColor(args[3].toString()));
            legging.setItemMeta(leggingMeta);

            ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta bootMeta = boot.getItemMeta();
            LeatherArmorMeta bootLeatherMeta = (LeatherArmorMeta) bootMeta;
            bootLeatherMeta.setColor(stringToColor(args[4].toString()));
            boot.setItemMeta(bootMeta);

            minion.getEquipment().setHelmet(skull);
            minion.getEquipment().setChestplate(chestplate);
            minion.getEquipment().setLeggings(legging);
            minion.getEquipment().setBoots(boot);

            minion.getEquipment().setHelmetDropChance(0);
            minion.getEquipment().setChestplateDropChance(0);
            minion.getEquipment().setLeggingsDropChance(0);
            minion.getEquipment().setBootsDropChance(0);

            player.sendMessage(minion.getName() + " was summoned.");

            return true;

        }

        return true;
    }

}