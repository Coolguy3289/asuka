package me.asukabot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;

import javax.security.auth.login.LoginException;

public class Asuka {
    private static JDA jda;

    public static void main(String[] args) throws LoginException {
        jda = new JDABuilder(AccountType.BOT)
            .setToken("")
            .setGame(Game.playing("asukabot.com"))
            .build();
    }

    public static JDA getJDA() {
        return jda;
    }
}
