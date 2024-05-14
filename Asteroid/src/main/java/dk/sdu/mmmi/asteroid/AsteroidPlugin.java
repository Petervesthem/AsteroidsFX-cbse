package dk.sdu.mmmi.asteroid;

import dk.sdu.mmmi.cbse.common.asteroid.Asteroid;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.util.Random;

public class AsteroidPlugin implements IGamePluginService {
    @Override
    public void start(GameData gameData, World world) {
        for (int i = 0; i < 15; i++) {
            Entity asteroid = createAsteroid(gameData);
            world.addEntity(asteroid);
        }
    }

    @Override
    public void stop(GameData gameData, World world) {
    for (Entity asteroid : world.getEntities(Asteroid.class)) {
        //world.removeEntity(asteroid);
        asteroid.setRotation(180);
        }
    }

    Entity createAsteroid(GameData gameData) {
            Random random = new Random();
            Entity asteroid = new Asteroid();
            int size = random.nextInt(20) + 5;

            asteroid.setPolygonCoordinates(size, -size, -size, -size, -size, size, size, size);
            asteroid.setRadius(size);
            asteroid.setRotation(random.nextInt(360));
            asteroid.setX(random.nextInt(1000));
            asteroid.setY(random.nextInt(1000));
            //asteroid.setX(500);
            //asteroid.setY(500);
        return asteroid;
    }


}
