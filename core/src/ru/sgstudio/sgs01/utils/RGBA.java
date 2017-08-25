package ru.sgstudio.sgs01.utils;

import com.badlogic.gdx.graphics.Color;

public class RGBA {
	public static Color rgba(float r, float g, float  b, float a) {
		Color c = new Color();
		c.add(r/255, g/255, b/255, a);
		return c;
	}
}
