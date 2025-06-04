package com.millman97.relativetilemarkers;

import net.runelite.client.config.*;
import java.awt.*;

@ConfigGroup("relativetilemarkers")
public interface RelativeTileConfig extends Config
{
    // --- Section A ---
    @ConfigSection(
            name = "Tile Marker Set A",
            description = "Settings for tile marker set A",
            position = 0,
            closedByDefault = false
    )
    String sectionA = "sectionA";

    @ConfigItem(
            keyName = "tilesA",
            name = "Tiles A",
            description = "Relative tiles for set A",
            section = sectionA,
            position = 0
    )
    default String tilesA() { return ""; }

    @ConfigItem(
            keyName = "fillColorA",
            name = "Fill Color A",
            description = "Fill color for set A",
            section = sectionA,
            position = 1
    )
    default Color fillColorA() { return new Color(0, 255, 0, 100); }

    @ConfigItem(
            keyName = "borderColorA",
            name = "Border Color A",
            description = "Border color for set A",
            section = sectionA,
            position = 2
    )
    default Color borderColorA() { return Color.GREEN; }

    @ConfigItem(
            keyName = "borderWidthA",
            name = "Border Width A",
            description = "Thickness of border for set A",
            section = sectionA,
            position = 3
    )
    default double borderWidthA() { return 2.0; }

    @ConfigItem(
            keyName = "drawOutlineA",
            name = "Draw Outline A",
            description = "Enable outline for set A",
            section = sectionA,
            position = 4
    )
    default boolean drawOutlineA() { return true; }

    @Range(max = 255)
    @Alpha
    @ConfigItem(
            keyName = "fillAlphaA",
            name = "Fill Transparency A",
            description = "Transparency of the tile fill color for Set A (0 = fully transparent, 255 = fully opaque)",
            position = 5,
            section = sectionA
    )
    default int fillAlphaA() { return 100; }

    // --- Section B ---
    @ConfigSection(
            name = "Tile Marker Set B",
            description = "Settings for tile marker set B",
            position = 1,
            closedByDefault = true
    )
    String sectionB = "sectionB";

    @ConfigItem(
            keyName = "tilesB",
            name = "Tiles B",
            description = "Relative tiles for set B",
            section = sectionB,
            position = 0
    )
    default String tilesB() { return ""; }

    @ConfigItem(
            keyName = "fillColorB",
            name = "Fill Color B",
            description = "Fill color for set B",
            section = sectionB,
            position = 1
    )
    default Color fillColorB() { return new Color(255, 0, 0, 100); }

    @ConfigItem(
            keyName = "borderColorB",
            name = "Border Color B",
            description = "Border color for set B",
            section = sectionB,
            position = 2
    )
    default Color borderColorB() { return Color.RED; }

    @ConfigItem(
            keyName = "borderWidthB",
            name = "Border Width B",
            description = "Thickness of border for set B",
            section = sectionB,
            position = 3
    )
    default double borderWidthB() { return 2.0; }

    @ConfigItem(
            keyName = "drawOutlineB",
            name = "Draw Outline B",
            description = "Enable outline for set B",
            section = sectionB,
            position = 4
    )
    default boolean drawOutlineB() { return true; }

    @Range(max = 255)
    @Alpha
    @ConfigItem(
            keyName = "fillAlphaB",
            name = "Fill Transparency B",
            description = "Transparency of the tile fill color for Set B (0 = fully transparent, 255 = fully opaque)",
            position = 5,
            section = sectionB
    )
    default int fillAlphaB() { return 100; }

    // --- Section C ---
    @ConfigSection(
            name = "Tile Marker Set C",
            description = "Settings for tile marker set C",
            position = 2,
            closedByDefault = true
    )
    String sectionC = "sectionC";

    @ConfigItem(
            keyName = "tilesC",
            name = "Tiles C",
            description = "Relative tiles for set C",
            section = sectionC,
            position = 0
    )
    default String tilesC() { return ""; }

    @ConfigItem(
            keyName = "fillColorC",
            name = "Fill Color C",
            description = "Fill color for set C",
            section = sectionC,
            position = 1
    )
    default Color fillColorC() { return new Color(0, 0, 255, 100); }

    @ConfigItem(
            keyName = "borderColorC",
            name = "Border Color C",
            description = "Border color for set C",
            section = sectionC,
            position = 2
    )
    default Color borderColorC() { return Color.BLUE; }

    @ConfigItem(
            keyName = "borderWidthC",
            name = "Border Width C",
            description = "Thickness of border for set C",
            section = sectionC,
            position = 3
    )
    default double borderWidthC() { return 2.0; }

    @ConfigItem(
            keyName = "drawOutlineC",
            name = "Draw Outline C",
            description = "Enable outline for set C",
            section = sectionC,
            position = 4
    )
    default boolean drawOutlineC() { return true; }

    @Range(max = 255)
    @Alpha
    @ConfigItem(
            keyName = "fillAlphaC",
            name = "Fill Transparency C",
            description = "Transparency of the tile fill color for Set C (0 = fully transparent, 255 = fully opaque)",
            position = 5,
            section = sectionC
    )
    default int fillAlphaC() { return 100; }
}
