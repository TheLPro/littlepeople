package studio.thelpro.littlepeople.commands;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import studio.thelpro.littlepeople.handlers.LittlePerson;

import javax.annotation.Nullable;
import java.util.*;

public class SummonCommand implements TabExecutor {

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

        if (sender.hasPermission("lip.spawn")) {

            Player player = (Player) sender;

            if (args.length == 0) {
                sender.sendMessage("Plugin made by " + ChatColor.GOLD + ChatColor.BOLD + "TheLPro" + ChatColor.RESET + ".");
                sender.sendMessage(ChatColor.YELLOW + "/summonperson help" + ChatColor.RED + " for more.");
                return true;
            }

            if (args.length == 1 && args[0].equalsIgnoreCase("help")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "\n&ke&r&lPossible Commands&r&ke&r \n&e1. &r /summonperson e &7(or elephant)&r <name> \n&r&e2. &r /summonperson d &7(or dwarf)&r <name> \n&r&e4. &r /summonperson c &7 (or custom)&r <name> <chestplate-color> <leggings-color> <boots-color> <player-name> (<-for the head) \n\n &e/summonperson help colors &rfor help in the colors.\n"));
                return true;
            }
            if (args[0].equalsIgnoreCase("help") && args[1].equalsIgnoreCase("colors")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "\n&ke&r&l&4C&6o&el&2o&1r&5s&r&ke&r \n&4Maroon&r, &cRed&r, &6Orange&r, &eYellow&r, &2Green&r, &2Olive&7 (there is no olive in chat)&r, &aLime&r, &3Teal&r, &3Navy&7 (same as with Olive)&r, &1Blue&r, &bAqua&r, &5Purple&r, &dPink&r, &fWhite&r, &7Silver&r, &8Gray&r, &0Black&r.\n"));
                return true;
            }
            if (args[0].equalsIgnoreCase("help") && args[1].equalsIgnoreCase("spigotmc")) {

                TextComponent message = new TextComponent("Spigot page of this plugin.");
                message.setColor(net.md_5.bungee.api.ChatColor.YELLOW);
                message.setUnderlined(true);
                message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.spigotmc.org/resources/littlepeople.105765/"));
                message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click to visit")));

                player.spigot().sendMessage(message);

                return true;
            }

            if (args[0].equalsIgnoreCase("e") || args[0].equalsIgnoreCase("elephant")) {

                if (args.length != 2) {
                    player.sendMessage(ChatColor.RED + "Incorrect command usage. " + ChatColor.YELLOW + "/summonperson help" + ChatColor.RED + " for more.");
                    return true;
                }

                LittlePerson person = new LittlePerson(args[1], Color.GRAY, Color.GRAY, Color.GRAY, "elephant", player);
                person.summon();

                return true;

            }

            if (Objects.equals(args[0], "d") || Objects.equals(args[0], "dwarf")) {

                if (args.length != 2) {
                    player.sendMessage(ChatColor.RED + "Incorrect command usage. " + ChatColor.YELLOW + "/summonperson help" + ChatColor.RED + " for more.");
                    return true;
                }

                LittlePerson person = new LittlePerson(args[1], Color.WHITE, Color.LIME, Color.GRAY, "_Gfe", player);
                person.summon();

                return true;

            }

            if (Objects.equals(args[0], "c") || Objects.equals(args[0], "custom")) {

                if (args.length != 6) {
                    player.sendMessage(ChatColor.RED + "Incorrect command usage. " + ChatColor.YELLOW + "/summonperson help" + ChatColor.RED + " for more.");
                    return true;
                }

                LittlePerson person = new LittlePerson(args[1], stringToColor(args[2]), stringToColor(args[3]), stringToColor(args[4]), args[5], player);
                person.summon();

                return true;

            }
        } else {
            sender.sendMessage("Plugin made by " + ChatColor.GOLD + ChatColor.BOLD + "TheLPro" + ChatColor.RESET + ".");
            sender.sendMessage(ChatColor.RED + "You don't have permission to do this.");
        }

        return true;
    }

    List<String> arguments = new ArrayList<String>();
    List<String> name = new ArrayList<String>();
    List<String> colors = new ArrayList<String>();
    List<String> help2 = new ArrayList<String>();

    @Override
    public @Nullable List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

            if (arguments.isEmpty()) {
                arguments.add("elephant");
                arguments.add("dwarf");
                arguments.add("custom");
                arguments.add("help");
            }
            if (name.isEmpty()) {
                name.add("name");
            }
            if (colors.isEmpty()) {
                colors.add("red");
                colors.add("maroon");
                colors.add("orange");
                colors.add("yellow");
                colors.add("green");
                colors.add("navy");
                colors.add("olive");
                colors.add("lime");
                colors.add("blue");
                colors.add("teal");
                colors.add("aqua");
                colors.add("purple");
                colors.add("pink");
                colors.add("black");
                colors.add("gray");
                colors.add("silver");
                colors.add("white");
            }
            if (help2.isEmpty()) {
                help2.add("colors");
                help2.add("spigotmc");
            }

            List<String> result = new ArrayList<String>();
            if (args.length == 1) {
                for (String a : arguments) {
                    if (a.toLowerCase().startsWith(args[0].toLowerCase()))
                        result.add(a);
                }
                return result;
            }

        if (args[0].equalsIgnoreCase("help") && args.length == 2) {
            for (String a : help2) {
                if (a.toLowerCase().startsWith(args[1].toLowerCase()))
                    result.add(a);
            }
            return result;
        }

            if (args.length == 2) {
                for (String a : name) {
                    if (a.toLowerCase().startsWith(args[1].toLowerCase()))
                        result.add(a);
                }
                return result;
            }

             if (args.length == 6) {
                for (String a : name) {
                    if (a.toLowerCase().startsWith(args[5].toLowerCase()))
                        result.add(a);
                    }
                return result;
             }

            if ((args.length == 3 || args.length == 4 || args.length == 5) && (args[0].equalsIgnoreCase("custom") || args[0].equalsIgnoreCase("c"))) {
                for (String a : colors) {
                    if (a.toLowerCase().startsWith(args[2].toLowerCase()) || a.toLowerCase().startsWith(args[3].toLowerCase()) || a.toLowerCase().startsWith(args[4].toLowerCase()))
                        result.add(a);
                }
                return result;
            }
        return null;
    }
}