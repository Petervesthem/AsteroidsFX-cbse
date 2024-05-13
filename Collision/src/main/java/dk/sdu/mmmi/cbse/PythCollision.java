package dk.sdu.mmmi.cbse;

import dk.sdu.mmmi.cbse.common.data.Entity;

public class PythCollision implements ICollide{


    //TODO: Implement pythagoras to calculate colliosion between entities
    @Override
    public boolean collide(Entity e1, Entity e2) {
        if (e1.getX() == e2.getX() && e1.getY() == e2.getY()) {
            return true;
        }
        return false;
    }
}