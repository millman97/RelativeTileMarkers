package com.millman97.relativetilemarkers;

import net.runelite.api.Client;
import net.runelite.api.CollisionData;
import net.runelite.api.CollisionDataFlag;
import net.runelite.api.WorldView;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.Perspective;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

import javax.inject.Inject;
import java.awt.*;
import java.util.List;

public class RelativeTileOverlay extends Overlay
{
    private static final int BLOCKED = CollisionDataFlag.BLOCK_MOVEMENT_FULL
            | CollisionDataFlag.BLOCK_MOVEMENT_FLOOR
            | CollisionDataFlag.BLOCK_MOVEMENT_FLOOR_DECORATION;

    private final Client client;
    private final RelativeTileConfig config;

    @Inject
    public RelativeTileOverlay(Client client, RelativeTileConfig config)
    {
        this.client = client;
        this.config = config;
        setPosition(OverlayPosition.DYNAMIC);
        setPriority(OverlayPriority.MED);
        setLayer(OverlayLayer.ABOVE_SCENE);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        drawRelativeTiles(graphics, config.tilesA(), config.fillColorA(), config.fillAlphaA(), config.borderColorA(), config.borderAlphaA(), config.borderWidthA(), config.drawOutlineA(), config.useTrueTileA(), config.hideBlockedA());
        drawRelativeTiles(graphics, config.tilesB(), config.fillColorB(), config.fillAlphaB(), config.borderColorB(), config.borderAlphaB(), config.borderWidthB(), config.drawOutlineB(), config.useTrueTileB(), config.hideBlockedB());
        drawRelativeTiles(graphics, config.tilesC(), config.fillColorC(), config.fillAlphaC(), config.borderColorC(), config.borderAlphaC(), config.borderWidthC(), config.drawOutlineC(), config.useTrueTileC(), config.hideBlockedC());

        return null;
    }

    private void drawRelativeTiles(Graphics2D graphics, String input, Color fill, int fillAlpha, Color border, int borderAlpha, double borderWidth, boolean drawOutline, boolean useTrueTile, boolean hideBlocked)
    {
        if (input == null || input.isEmpty())
        {
            return;
        }

        WorldPoint base = useTrueTile
                ? client.getLocalPlayer().getWorldLocation()
                : WorldPoint.fromLocal(client, client.getLocalPlayer().getLocalLocation());

        List<WorldPoint> points = RelativeTileParser.parse(input, base);

        for (WorldPoint worldPoint : points)
        {
            LocalPoint lp = LocalPoint.fromWorld(client, worldPoint);
            if (lp == null)
            {
                continue;
            }

            if (hideBlocked && isBlocked(worldPoint, lp))
            {
                continue;
            }

            Polygon poly = Perspective.getCanvasTilePoly(client, lp);
            if (poly == null)
            {
                continue;
            }

            if (fill != null && fillAlpha > 0)
            {
                Color alphaFill = new Color(fill.getRed(), fill.getGreen(), fill.getBlue(), fillAlpha);
                graphics.setColor(alphaFill);
                graphics.fill(poly);
            }

            if (drawOutline && border != null && borderAlpha > 0)
            {
                Color alphaBorder = new Color(border.getRed(), border.getGreen(), border.getBlue(), borderAlpha);
                graphics.setColor(alphaBorder);
                graphics.setStroke(new BasicStroke((float) borderWidth));
                graphics.draw(poly);
            }
        }
    }

    private boolean isBlocked(WorldPoint worldPoint, LocalPoint lp)
    {
        // Same world view LocalPoint.fromWorld(client, ...) resolves against
        WorldView wv = client.findWorldViewFromWorldPoint(worldPoint);
        CollisionData[] maps = wv.getCollisionMaps();
        if (maps == null)
        {
            return false;
        }

        return (maps[wv.getPlane()].getFlags()[lp.getSceneX()][lp.getSceneY()] & BLOCKED) != 0;
    }

}
