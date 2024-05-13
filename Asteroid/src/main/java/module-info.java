import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module Asteroid {
    requires Common;
    requires commonAsteroid;
    provides IGamePluginService with dk.sdu.mmmi.asteroid.AsteroidPlugin;
    provides IEntityProcessingService with dk.sdu.mmmi.asteroid.AsteroidControlSystem;
}