package me.asukabot;


import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.github.cdimascio.dotenv.Dotenv;

public class Asuka {
    private static JDA jda;
    private static final Logger LOGGER = LoggerFactory.getLogger(Asuka.class);


    public static void main(String[] args) throws LoginException, IOException {
        Dotenv dotenv = Dotenv.load();
        jda = new JDABuilder(AccountType.BOT)
            .setToken(dotenv.get("DISCORD_TOKEN"))
            .setGame(Game.playing("asukabot.com"))
            .build();
    }

    public static JDA getJDA() {
        return jda;
    }
}
