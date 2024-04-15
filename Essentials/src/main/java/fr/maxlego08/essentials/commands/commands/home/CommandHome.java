package fr.maxlego08.essentials.commands.commands.home;

import fr.maxlego08.essentials.api.EssentialsPlugin;
import fr.maxlego08.essentials.api.commands.CommandResultType;
import fr.maxlego08.essentials.api.commands.Permission;
import fr.maxlego08.essentials.api.home.Home;
import fr.maxlego08.essentials.api.messages.Message;
import fr.maxlego08.essentials.api.user.User;
import fr.maxlego08.essentials.module.modules.HomeModule;
import fr.maxlego08.essentials.zutils.utils.commands.VCommand;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Optional;

public class CommandHome extends VCommand {

    public CommandHome(EssentialsPlugin plugin) {
        super(plugin);
        this.setModule(HomeModule.class);
        this.setPermission(Permission.ESSENTIALS_HOME);
        this.setDescription(Message.DESCRIPTION_HOME);
        this.addOptionalArg("name", (sender, args) -> {
            if (sender instanceof Player player) {
                User user = plugin.getUser(player.getUniqueId());
                return user.getHomes().stream().map(Home::getName).toList();
            }
            return new ArrayList<>();
        });
    }

    @Override
    protected CommandResultType perform(EssentialsPlugin plugin) {

        String homeName = this.argAsString(0, null);
        HomeModule homeModule = plugin.getModuleManager().getModule(HomeModule.class);

        if (homeName == null) {

            if (this.sender instanceof ConsoleCommandSender) return CommandResultType.SYNTAX_ERROR;

            homeModule.sendHomes(player, user);
            return CommandResultType.SUCCESS;
        }


        // For /sethome Maxlego08:<home name>
        if (homeName.contains(":") && hasPermission(sender, Permission.ESSENTIALS_HOME_OTHER)) {
            // ToDo
        }


        Optional<Home> optional = this.user.getHome(homeName);
        if (optional.isEmpty()) {
            message(sender, Message.COMMAND_HOME_DOESNT_EXIST, "%name%", homeName);
            return CommandResultType.DEFAULT;
        }

        Home home = optional.get();
        homeModule.teleport(user, home);

        return CommandResultType.SUCCESS;
    }
}
