package dk.sdu.mmmi.asteroid;

import dk.sdu.mmmi.cbse.common.asteroid.Asteroid;
import dk.sdu.mmmi.cbse.common.asteroid.ISplitAsteroid;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.World;


public class SplitAsteroid implements ISplitAsteroid{
    @Override
    public void createSplitAsteroid(World world, Asteroid asteroid) {
        asteroid.setHit(true);

        float newRadius = asteroid.getRadius()/2;

        Asteroid newAsteroid = new Asteroid();
        newAsteroid.setRadius(newRadius);
        Asteroid newAsteroid2 = new Asteroid();
        newAsteroid2.setRadius(newRadius);

        world.addEntity(newAsteroid);
        world.addEntity(newAsteroid2);
    }
}
