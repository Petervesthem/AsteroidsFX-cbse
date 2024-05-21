import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
module Collision {
    requires Common;
    requires CommonCollision;
    requires commonAsteroid;
    requires java.net.http;
    requires Asteroid;

    provides IPostEntityProcessingService with dk.sdu.mmmi.collision.PythCollision;
}
