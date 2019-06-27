package me.asukabot.command;


import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.examples.doc.Author;

@Author("techied")
public class Setup extends Command {

    public Setup(){
        this.name="Setup";
        this.help="Sets up your server for use with Asuka.";
    }
    @Override
    protected void execute(CommandEvent event) {
        event.getTextChannel().sendMessage("Setting up your server... Please wait").complete();
    }
}
