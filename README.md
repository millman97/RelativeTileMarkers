# Relative Tile Markers

**Relative Tile Markers** is a RuneLite plugin that allows you to highlight tiles based on your character’s current position, using directional offsets (e.g. `E2N1` for "2 east, 1 north").

![Demo of Relative Tile Markers plugin](demo.gif)

Tiles are comma separated within sets, so in the example, the red tiles are defined as W2,E2. The blue tiles are W3S3,N3E3.

All tile positions are user-defined and not dynamically placed or adjusted by the plugin based on game state.

![Screenshot of the config sidebar](img.png)

---

## Features

- Mark tiles relative to the player (e.g. `E3`, `N2W1`)
- Supports three independent marker sets (A, B, C)
- Custom settings for each set:
    - Tile inputs
    - Fill color and transparency
    - Outline color and thickness

---

## Use Cases
This plugin is useful for encounters where consistent positioning is important, and where players already use tile markers to guide movement. Relative tiles allow you to maintain the same layout every time, without needing to manually mark positions in advance.

A common use is with "L" movement patterns — where players step in an "L" shape to avoid damage or position correctly. Using relative markers, you can visualize where to move based on your current location, rather than relying on fixed tiles. For example:
- [Sol Heredit L method](https://www.youtube.com/watch?v=DUfBewpVk1s)
- [Whisperer](https://www.youtube.com/watch?v=TE8Szz5I_xs)
