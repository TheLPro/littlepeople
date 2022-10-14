package me.thelpro.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.*;

public class summonCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        if (!(Objects.equals(args[0], "help")) && !(Objects.equals(args[0], "p")) && !(Objects.equals(args[0], "person")) && args.length != 2)
            player.sendMessage(ChatColor.RED +  "Incorrect command usage. " + ChatColor.YELLOW + "/summonperson help" + ChatColor.RED + " for more.");
        if (Objects.equals(args[0], "help"))
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&lPossible Commands: \n&r&e1. &r /summonperson e &7(or elephant)&r <name> \n&r&e2. &r /summonperson d &7(or dwarf)&r <name> \n&r&e3. &r /summonperson p &7(or person)&r <player-name> <name>"));

        if (Objects.equals(args[0], "e") || Objects.equals(args[0], "elephant")) {

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

        }

        if (Objects.equals(args[0], "p") || Objects.equals(args[0], "person")) {

            Zombie minion = (Zombie) player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
            minion.setAI(false);
            minion.setInvulnerable(true);
            minion.setBaby();
            minion.setCustomNameVisible(true);
            minion.setCustomName(ChatColor.translateAlternateColorCodes('&', args[2].toString()));
            minion.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, (int) Double.POSITIVE_INFINITY, 1, true, false));

            ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1);
            SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
            skullMeta.setOwner(args[1].toString());
            skull.setItemMeta(skullMeta);

            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemMeta chestplateMeta = chestplate.getItemMeta();
            LeatherArmorMeta chestplateLeatherMeta = (LeatherArmorMeta) chestplateMeta;
            chestplateLeatherMeta.setColor(Color.WHITE);
            chestplate.setItemMeta(chestplateMeta);

            ItemStack legging = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemMeta leggingMeta = legging.getItemMeta();
            LeatherArmorMeta leggingLeatherMeta = (LeatherArmorMeta) leggingMeta;
            leggingLeatherMeta.setColor(Color.WHITE);
            legging.setItemMeta(leggingMeta);

            ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta bootMeta = boot.getItemMeta();
            LeatherArmorMeta bootLeatherMeta = (LeatherArmorMeta) bootMeta;
            bootLeatherMeta.setColor(Color.WHITE);
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

        }

        if (Objects.equals(args[0], "d") || Objects.equals(args[0], "dwarf")) {

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

        }

        return true;
    }
}