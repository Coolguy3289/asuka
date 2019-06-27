package me.asukabot;

import me.asukabot.config.Config;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Asuka {
    private static JDA jda;
    private static final Logger LOGGER = LoggerFactory.getLogger(Asuka.class);


    public static void main(String[] args) throws LoginException, IOException {
        Config config = new Config(new File("config.json"));
        jda = new JDABuilder(AccountType.BOT)
            .setToken(config.getString("token"))
            .setGame(Game.playing("asukabot.com"))
            .build();
    }

    public static JDA getJDA() {
        return jda;
    }
}
