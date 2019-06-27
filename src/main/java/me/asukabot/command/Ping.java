package me.asukabot.command;


import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.examples.doc.Author;

import java.time.Instant;

@Author("techied")
public class Ping extends Command {
    public Ping() {
        this.name = "Ping";
        this.help = "Checks the latency from Discord to Asuka servers.";
    }

    @Override
    protected void execute(CommandEvent event) {

        long latency = Instant.now().toEpochMilli() - (event.getMessage().getCreationTime().toEpochSecond() * 1000);
        event.getTextChannel().sendMessage("Latency: `" + latency + "ms`").complete();
    }
}
