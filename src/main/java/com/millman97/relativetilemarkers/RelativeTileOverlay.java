package com.millman97.relativetilemarkers;

import net.runelite.api.Client;
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
        drawRelativeTiles(graphics, config.tilesA(), config.fillColorA(), config.fillAlphaA(), config.borderColorA(), config.borderWidthA(), config.drawOutlineA());
        drawRelativeTiles(graphics, config.tilesB(), config.fillColorB(), config.fillAlphaB(), config.borderColorB(), config.borderWidthB(), config.drawOutlineB());
        drawRelativeTiles(graphics, config.tilesC(), config.fillColorC(), config.fillAlphaC(), config.borderColorC(), config.borderWidthC(), config.drawOutlineC());

        return null;
    }

    private void drawRelativeTiles(Graphics2D graphics, String input, Color fill, int fillAlpha, Color border, double borderWidth, boolean drawOutline)
    {
        if (input == null || input.isEmpty())
        {
            return;
        }

        LocalPoint playerLocation = client.getLocalPlayer().getLocalLocation();
        WorldPoint base = WorldPoint.fromLocal(client, playerLocation);
        List<WorldPoint> points = RelativeTileParser.parse(input, base);

        for (WorldPoint worldPoint : points)
        {
            LocalPoint lp = LocalPoint.fromWorld(client, worldPoint);
            if (lp == null)
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

            if (drawOutline && border != null)
            {
                graphics.setColor(border);
                graphics.setStroke(new BasicStroke((float) borderWidth));
                graphics.draw(poly);
            }
        }
    }
}
