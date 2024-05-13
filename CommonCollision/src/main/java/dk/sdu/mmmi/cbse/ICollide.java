package dk.sdu.mmmi.cbse;

import dk.sdu.mmmi.cbse.common.data.Entity;

public interface ICollide {
    boolean collide(Entity e1, Entity e2);
}
