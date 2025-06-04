package com.millman97.relativetilemarkers;

import org.junit.jupiter.api.Test;

import net.runelite.api.coords.WorldPoint;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RelativeTileParserTest
{
    private static final WorldPoint BASE_POINT = new WorldPoint(3200, 3200, 0);

    @Test
    public void testParse_E2N3()
    {
        List<WorldPoint> result = RelativeTileParser.parse("E2N3", BASE_POINT);
        WorldPoint expected = new WorldPoint(3202, 3203, 0);
        assertEquals(1, result.size());
        assertEquals(expected, result.get(0));
    }

    @Test
    public void testParse_W5S2()
    {
        List<WorldPoint> result = RelativeTileParser.parse("W5S2", BASE_POINT);
        WorldPoint expected = new WorldPoint(3195, 3198, 0);
        assertEquals(1, result.size());
        assertEquals(expected, result.get(0));
    }

    @Test
    public void testParse_Invalid()
    {
        List<WorldPoint> result = RelativeTileParser.parse("XX9", BASE_POINT);
        assertEquals(1, result.size());
        assertEquals(BASE_POINT, result.get(0)); // Invalid input, should return base point
    }
}
