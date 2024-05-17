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
        newAsteroid.setPolygonCoordinates(5,-5,-5,-5,-5,5,5,5);
        newAsteroid.setRotation(asteroid.getRotation() + 108);
        newAsteroid.setHp(1);

        newAsteroid.setX(asteroid.getX() + Math.cos(Math.toRadians(asteroid.getRotation())));
        newAsteroid.setY(asteroid.getY() + Math.sin(Math.toRadians(asteroid.getRotation())));


        Asteroid newAsteroid2 = new Asteroid();
        newAsteroid2.setRadius(newRadius);
        newAsteroid2.setPolygonCoordinates(5,-5,-5,-5,-5,5,5,5);
        newAsteroid2.setRotation(asteroid.getRotation() - 210);
        newAsteroid2.setHp(1);

        newAsteroid2.setX(asteroid.getX() + Math.cos(Math.toRadians(asteroid.getRotation())));
        newAsteroid2.setY(asteroid.getY() + Math.sin(Math.toRadians(asteroid.getRotation())));

//        newAsteroid.setX(100);
//        newAsteroid.setY(100);
//        newAsteroid2.setX(300);
//        newAsteroid2.setY(300);

        world.addEntity(newAsteroid);
        world.addEntity(newAsteroid2);

    }
}
