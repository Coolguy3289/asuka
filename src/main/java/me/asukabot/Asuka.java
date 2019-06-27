package me.asukabot;


import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import io.github.cdimascio.dotenv.Dotenv;
import me.asukabot.command.Ping;
import me.asukabot.command.Setup;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;
import java.io.IOException;

public class Asuka {
    private static JDA jda;
    private static final Logger LOGGER = LoggerFactory.getLogger(Asuka.class);


    public static void main(String[] args) throws LoginException, IOException, InterruptedException {
        EventWaiter waiter = new EventWaiter();
        CommandClientBuilder client = new CommandClientBuilder();
        client.setEmojis("\uD83D\uDE03", "\uD83D\uDE2E", "\uD83D\uDE26");
        client.setOwnerId("135923847147945985");
        client.setCoOwnerIds("270737906644156416", "156497366130622464");
        client.setPrefix(">");
        client.setGame(Game.playing("asukabot.com"));
        client.addCommands(new Setup(), new Ping());
        Dotenv dotenv = Dotenv.load();
        jda = new JDABuilder(AccountType.BOT)
                .setToken(dotenv.get("DISCORD_TOKEN"))
                .addEventListener(waiter)
                .addEventListener(client.build())
                .build().awaitReady();
    }

    public static JDA getJDA() {
        return jda;
    }
}
