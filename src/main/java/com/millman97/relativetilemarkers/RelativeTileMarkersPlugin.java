package com.millman97.relativetilemarkers;

import com.google.inject.Provides;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;

@PluginDescriptor(
        name = "Relative Tile Markers",
        description = "Marks relative tiles based on the player's position"
)
public class RelativeTileMarkersPlugin extends Plugin
{
    @Inject private OverlayManager overlayManager;
    @Inject private RelativeTileOverlay overlay;

    @Override
    protected void startUp()
    {
        overlayManager.add(overlay);
    }

    @Override
    protected void shutDown()
    {
        overlayManager.remove(overlay);
    }

    @Provides
    RelativeTileConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(RelativeTileConfig.class);
    }
}
