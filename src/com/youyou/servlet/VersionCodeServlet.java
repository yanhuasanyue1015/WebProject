package com.youyou.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by 张磊 on 2017/2/28.
 */
@WebServlet(
        urlPatterns = "/version-code"
)
public class VersionCodeServlet extends HttpServlet {
    private final int height = 22;
    private final int width = 70;
    private final Random random = new Random();
    private final String code = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final int disturbDotNum = 50;
    private final StringBuilder tempBuilder = new StringBuilder();
    private final int Ovalradius = 2;
    private final int FontCount = 4;
    private final int FontSize=18;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ServletOutputStream outputStream = resp.getOutputStream();
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
        graphics.setColor(Color.decode("#DCDCDC"));
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(Color.black);
        graphics.drawRect(0, 0, width - 1, height - 1);
        for (int i = 0; i < disturbDotNum; i++) {
            int x = random.nextInt(width - Ovalradius);
            int y = random.nextInt(height - Ovalradius);
            tempBuilder.delete(0, tempBuilder.length());
            tempBuilder.append("#");
            tempBuilder.append(Integer.toHexString(random.nextInt(200)));
            tempBuilder.append(Integer.toHexString(random.nextInt(200)));
            tempBuilder.append(Integer.toHexString(random.nextInt(200)));
            graphics.setColor(Color.decode(tempBuilder.toString()));
            graphics.drawOval(x, y, Ovalradius, Ovalradius);
        }
        tempBuilder.delete(0, tempBuilder.length());
        for (int i = 0; i < FontCount; i++) {
            tempBuilder.append(code.charAt(random.nextInt(code.length())));
        }
        drawCenteredString(graphics,tempBuilder.toString(),new Rectangle(width,height),new Font("Candara", Font.BOLD, FontSize));
        ImageIO.write(bufferedImage, "jpg", outputStream);
    }
    /**
     * Draw a String centered in the middle of a Rectangle.
     *
     * @param g The Graphics instance.
     * @param text The String to draw.
     * @param rect The Rectangle to center the text in.
     */
    public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
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
