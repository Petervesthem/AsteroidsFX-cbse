package dk.sdu.mmmi.collision;

import dk.sdu.mmmi.cbse.ICollide;
import dk.sdu.mmmi.cbse.common.asteroid.Asteroid;
import dk.sdu.mmmi.cbse.common.asteroid.ISplitAsteroid;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

import java.util.Collection;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;


public class PythCollision implements ICollide, IPostEntityProcessingService {


    @Override
    public void process(GameData gameData, World world) {

        for (Entity entity : world.getEntities()) {
            for (Entity otherEntity : world.getEntities()) {
                if (entity.equals(otherEntity)) {
                    continue;
                }

                if (this.collide(entity, otherEntity)) {
                    world.removeEntity(entity);
                    world.removeEntity(otherEntity);
                }
            }
        }
    }


    @Override
    public boolean collide(Entity e1, Entity e2) {
        double distanceSquared = (e1.getX() - e2.getX()) * (e1.getX() - e2.getX()) + (e1.getY() - e2.getY()) * (e1.getY() - e2.getY());
        double minDistanceSquared = (e1.getRadius() + e2.getRadius()) * (e1.getRadius() + e2.getRadius());
        if(distanceSquared <= minDistanceSquared){
            return true;
        } else {
            return false;
        }
    }

}
