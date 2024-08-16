package fr.maxlego08.essentials.api.worldedit;

import fr.maxlego08.essentials.api.economy.Economy;
import fr.maxlego08.essentials.api.user.User;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface WorldeditManager {

    Optional<WorldEditItem> getWorldeditItem(String name);

    void give(CommandSender sender, Player player, String itemName);

    List<String> getWorldeditItems();

    List<String> getAllowedMaterials(Player player);

    boolean isBlacklist(Material material);

    void setBlocks(User user, List<MaterialPercent> materialPercents);

    void fillBlocks(User user, List<MaterialPercent> materialPercents);

    void cutBlocks(User user);

    BigDecimal getMaterialPrice(Material material);

    void confirmAction(User user);

    int getBlocksPerSecond(Player player);

    int getMaxBlocks(Player player);

    int getMaxDistance(Player player);

    int getSphereRadius(Player player);

    int getCylinderRadius(Player player);

    int getSphereHeight(Player player);

    int getCylinderHeight(Player player);

    void sendFinishMessage(User user);

    int getBatchSize();

    void stopEdition(User user);

    void sendRefundMessage(Player player, Map<Material, Long> refundMaterials, BigDecimal refundPrice, Economy economy);

    void wallsBlocks(User user, List<MaterialPercent> materialPercents);

    void sphereBlocks(User user, List<MaterialPercent> materialPercents, int radius, boolean filled);

    void cylBlocks(User user, List<MaterialPercent> materialPercents, int radius, boolean filled, int height);

    void setPos1(Player player, Location location);

    void setPos2(Player player, Location location);

    void toggleOptionInventory(User user);

    void toggleOptionBossBar(User user);

    WorldeditBossBar getWorldeditBar();

    WorldeditBossBarConfiguration getWorldeditConfiguration();
}