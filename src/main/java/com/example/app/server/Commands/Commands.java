package com.example.app.server.Commands;

import com.example.app.server.BroadCaster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class Commands {
    public static HashMap<String ,Command> commands = new HashMap<>();
    private static BroadCaster broadCaster;

    public static Optional<BroadCaster> getBroadCaster(){
        if (broadCaster != null){
            return Optional.of(broadCaster);
        }
        System.out.println("Commands does not have a broadCaster");
        return Optional.empty();
    }

    public static void addBroadCaster(BroadCaster broadCaster){
        Commands.broadCaster = broadCaster;
    }

    public static void setup(){
        ArrayList<Command> commandsList = new ArrayList<>();
        commandsList.add(new List());
        commandsList.add(new LennyCommand());
        commandsList.add(new WisperCommand());
        for (Command command : commandsList){
            if (Commands.commands != null && command.getFlag() != null) {
                Commands.commands.put(command.getFlag(), command);
            }
        }
    }
    public static Command execute(String flag){
        if (Commands.commands.containsKey(flag)){
            return Commands.commands.get(flag);
        }
        return new ErrorCommand();
    }
}
