package com.youyou.utils;

import java.awt.*;

/**
 * Created by 张磊 on 2017/2/28.
 */
public class GraphicsUtil {
    /**
     * 参考:
     *@see <a href="https://docs.oracle.com/javase/tutorial/2d/text/fontconcepts.html">Font Concepts</a>
     *@see <a href="https://docs.oracle.com/javase/tutorial/2d/text/measuringtext.html">Measuring Text</a>
     * Draw a String centered in the middle of a Rectangle.
     * @param g The Graphics instance.
     * @param text The String to draw.
     * @param rect The Rectangle to center the text in.
     */
    public static void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        // Get the FontMetrics
        FontMetrics metrics = g.getFontMetrics(font);
        // Determine the X coordinate for the text
        int x = (rect.width - metrics.stringWidth(text)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        // Set the font
        g.setFont(font);
        // Draw the String
        g.drawString(text, x, y);
    }
}