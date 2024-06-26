module Core {
    requires Common;
    requires CommonBullet;
    requires javafx.graphics;

    requires spring.core;
    requires spring.context;
    requires spring.beans;
    requires java.net.http;

    exports dk.sdu.mmmi.cbse.main;

    opens dk.sdu.mmmi.cbse.main to javafx.graphics, spring.core, spring.beans, spring.context;

    uses dk.sdu.mmmi.cbse.common.services.IGamePluginService;
    uses dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
    uses dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
}