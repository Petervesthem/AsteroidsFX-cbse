package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.Collection;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;

public class EnemyControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {
    for (Entity enemy: world.getEntities(Enemy.class)) {
        if (Math.random() < 0.2) {
            if (Math.random() < 0.5) {
                enemy.setRotation(enemy.getRotation() + 10);
            } else {
                enemy.setRotation(enemy.getRotation() - 10);
            }
        }


        //The enemy keep moving forward
        double changeX = Math.cos(Math.toRadians(enemy.getRotation()));
        double changeY = Math.sin(Math.toRadians(enemy.getRotation()));
        enemy.setX(enemy.getX() + changeX);
        enemy.setY(enemy.getY() + changeY);

        if (Math.random() < 0.1) {
            getBulletSPIs().stream().findFirst().ifPresent(
                    spi -> {world.addEntity(spi.createBullet(enemy, gameData));

        });}
        if (enemy.getX() < 0) {
            enemy.setX(1);
        }

        if (enemy.getX() > gameData.getDisplayWidth()) {
            enemy.setX(gameData.getDisplayWidth() - 100);
        }

        if (enemy.getY() < 0) {
            enemy.setY(1);
        }

        if (enemy.getY() > gameData.getDisplayHeight()) {
            enemy.setY(gameData.getDisplayHeight() - 100);
        }

        //Checking collision of the game borders for enemy
        if (enemy.getX() > gameData.getDisplayWidth() || enemy.getX() + gameData.getDisplayWidth() < gameData.getDisplayWidth()) {
            enemy.setRotation(enemy.getRotation() + 180);
        }
        if (enemy.getY() > gameData.getDisplayHeight() || enemy.getY() + gameData.getDisplayHeight() < gameData.getDisplayHeight()) {
            enemy.setRotation(enemy.getRotation() + 180);
        }
    }




    }
    private Collection<? extends BulletSPI> getBulletSPIs() {
        return ServiceLoader.load(BulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }

}
