package dk.sdu.mmmi.commoncollision;

import dk.sdu.mmmi.cbse.common.data.Entity;

public interface ICollide {
    boolean collide(Entity e1, Entity e2);
}
