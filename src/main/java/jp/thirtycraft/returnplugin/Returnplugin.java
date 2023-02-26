package jp.thirtycraft.returnplugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public  class Returnplugin extends JavaPlugin implements Listener {
    private Player targetPlayer;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(this ,this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    // プレイヤーが動いたときに呼び出されるイベント
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (player.equals(targetPlayer)) { // 返されるべきプレイヤーの場合
            if (player.getLocation().distance(event.getFrom()) > 10) { // 10m以上移動した場合
                player.teleport(targetPlayer.getLocation()); // 返されるべきプレイヤーの場所に戻る
            }
        }
    }
    //コマンドで返されるべきプレイヤーを設定するメソッド
    public void setTargetPlayer(Player player) {
        this.targetPlayer = player;
    }
}
