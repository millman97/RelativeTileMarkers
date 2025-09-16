package com.millman97.relativetilemarkers;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class RelativeTileMarkersPluginTest
{
    public static void main(String[] args) throws Exception
    {
        // Load your plugin so RuneLite knows about it
        ExternalPluginManager.loadBuiltin(RelativeTileMarkersPlugin.class);
        RuneLite.main(args);
    }
}
