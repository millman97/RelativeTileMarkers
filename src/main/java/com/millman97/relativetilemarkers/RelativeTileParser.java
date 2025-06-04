package com.millman97.relativetilemarkers;

import net.runelite.api.coords.WorldPoint;

import java.util.ArrayList;
import java.util.List;

public class RelativeTileParser
{
    public static List<WorldPoint> parse(String input, WorldPoint base)
    {
        List<WorldPoint> tiles = new ArrayList<>();
        if (input == null || base == null)
        {
            return tiles;
        }

        String[] parts = input.split("[,\\s]+");
        for (String part : parts)
        {
            int dx = 0, dy = 0;
            part = part.trim().toUpperCase();

            for (int i = 0; i < part.length(); )
            {
                char dir = part.charAt(i++);
                StringBuilder num = new StringBuilder();
                while (i < part.length() && Character.isDigit(part.charAt(i)))
                {
                    num.append(part.charAt(i++));
                }

                int val = num.length() > 0 ? Integer.parseInt(num.toString()) : 1;

                switch (dir) {
                    case 'N': dy += val; break;
                    case 'S': dy -= val; break;
                    case 'E': dx += val; break;
                    case 'W': dx -= val; break;
                }
            }

            tiles.add(new WorldPoint(base.getX() + dx, base.getY() + dy, base.getPlane()));
        }

        return tiles;
    }
}
