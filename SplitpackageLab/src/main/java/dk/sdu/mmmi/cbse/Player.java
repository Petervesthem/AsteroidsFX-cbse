package dk.sdu.mmmi.cbse;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

public class Player implements IGamePluginService {
    @Override
    public void start(GameData gameData, World world) {
        System.out.println("Hello! from the split package side");
    }

    @Override
    public void stop(GameData gameData, World world) {

    }
}
