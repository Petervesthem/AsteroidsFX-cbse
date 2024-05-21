import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module SplitpackageLab {
    requires Common;
    exports dk.sdu.mmmi.cbse;
    provides IGamePluginService with dk.sdu.mmmi.cbse.Player;

}