package dk.sdu.mmmi.cbse.main;

import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
import org.springframework.context.annotation.Bean;

import java.lang.module.ModuleDescriptor;
import java.lang.module.ModuleReference;
import java.lang.module.ModuleFinder;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class ModuleConfig {

    private static ModuleLayer pluginLayer;

    public ModuleConfig() {
        setupPluginModuleLayer();
    }

    @Bean
    public Game game(){
        return new Game(gamePluginServices(), entityProcessingServices(),postEntityProcessingServices());
    }

    @Bean
    public List<IGamePluginService> gamePluginServices() {
        return ServiceLoader.load(pluginLayer, IGamePluginService.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }


    @Bean
    public List<IEntityProcessingService> entityProcessingServices() {
        return ServiceLoader.load(pluginLayer, IEntityProcessingService.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }


    @Bean
    public List<IPostEntityProcessingService> postEntityProcessingServices() {
        return ServiceLoader.load(pluginLayer, IPostEntityProcessingService.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }

    private static void setupPluginModuleLayer() {
        Path pluginsDir = Paths.get("plugins"); // Directory with plugins JARs

        // Search for plugins in the plugins directory
        ModuleFinder pluginsFinder = ModuleFinder.of(pluginsDir);

        // Get all plugins
        List<String> plugins = pluginsFinder
                .findAll()
                .stream()
                .map(ModuleReference::descriptor)
                .map(ModuleDescriptor::name)
                .collect(Collectors.toList());

        // Resolving plugins
        java.lang.module.Configuration pluginsConfiguration = ModuleLayer
                .boot()
                .configuration()
                .resolve(pluginsFinder, ModuleFinder.of(), plugins);

        // Creating module layer, for use in Services
        pluginLayer = ModuleLayer
                .boot()
                .defineModulesWithOneLoader(pluginsConfiguration, ClassLoader.getSystemClassLoader());
    }

}
