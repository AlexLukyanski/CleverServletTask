package by.clever.servlet.controller;

import by.clever.servlet.controller.impl.CreateMusicBand;
import by.clever.servlet.controller.impl.DeleteMusicBand;
import by.clever.servlet.controller.impl.ReadAllMusicBands;
import by.clever.servlet.controller.impl.ReadMusicBandByID;
import by.clever.servlet.controller.impl.ReadReceiptByID;
import by.clever.servlet.controller.impl.UpdateMusicBand;

import java.util.HashMap;
import java.util.Map;

public final class CommandFactory {

    private final Map<CommandName, Command> commands = new HashMap<>();

    public CommandFactory() {
        commands.put(CommandName.ADD_MUSIC_BAND, new CreateMusicBand());
        commands.put(CommandName.READ_ONE_MUSIC_BAND, new ReadMusicBandByID());
        commands.put(CommandName.READ_ALL_MUSIC_BAND, new ReadAllMusicBands());
        commands.put(CommandName.UPDATE_MUSIC_BAND, new UpdateMusicBand());
        commands.put(CommandName.DELETE_MUSIC_BAND, new DeleteMusicBand());
        commands.put(CommandName.READ_RECEIPT_BY_ID, new ReadReceiptByID());
    }

    public Command getCommand(String name) {

        CommandName commandName = CommandName.valueOf(name);
        return commands.get(commandName);
    }
}
