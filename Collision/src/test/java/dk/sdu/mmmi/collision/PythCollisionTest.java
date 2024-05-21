package dk.sdu.mmmi.collision;

import dk.sdu.mmmi.cbse.common.data.Entity;

import static org.junit.jupiter.api.Assertions.*;

class CollisionTest {

    @org.junit.jupiter.api.Test
    void collide() {
        PythCollision pythCollision = new PythCollision();
        Entity entity1 = new Entity();
        entity1.setRadius(3);
        Entity entity2 = new Entity();
        entity2.setRadius(5);
        boolean collision = pythCollision.collide(entity1, entity2);

        assertTrue(collision);
    }
}