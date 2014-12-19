package plugger.util;

import java.awt.*;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;
 
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
 
public class FontUtil
{
    private Font F;
    private Color C;
    private boolean AA;
 
    public FontUtil(Font F, Color C, boolean AA)
    {
        this.F = F;
        this.C = C;
        this.AA = AA;
    }
    public FontUtil(Font F)
    {
        this.F = F;
        this.C = Color.WHITE;
        this.AA = true;
    }
    public void setColor(Color C)
    {
        this.C = C;
    }
    public void setAA(boolean AA)
    {
        this.AA = AA;
    }
    public void drawString(String Str, int X, int Y)
    {
        BufferedImage DIM = new BufferedImage(521, 521, BufferedImage.TYPE_INT_ARGB);
        Graphics2D G2D = DIM.createGraphics();
        G2D.setFont(F);
        int Height, Width;
        TextLayout TL = new TextLayout(Str, F, G2D.getFontRenderContext());
        Rectangle2D R = TL.getBounds();
        Height = (int) R.getHeight();
        Width = G2D.getFontMetrics(F).stringWidth(Str);
        BufferedImage Img = new BufferedImage(Width, (int) (Height + TL.getDescent()), BufferedImage.TYPE_INT_ARGB);
        int IWidth = Img.getWidth();
        int IHeight = Img.getHeight();
        Graphics2D G = (Graphics2D) Img.getGraphics();
        G.setColor(this.C);
        G.setFont(this.F);
        if (this.AA)
        {
            G.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }
        G.drawString(Str, 0, ((IHeight) / 2) - ((TL.getAscent() + TL.getDescent()) / 2) + TL.getAscent() - TL.getLeading());
 
        int TID = LoadTexture(Img);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
 
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
 
        GL11.glPushMatrix();
        GL11.glTranslatef(X, Y, 0);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, TID);
        GL11.glBegin(GL11.GL_QUADS);
 
        GL11.glTexCoord2f(0, 1); //BOTTOM LEFT
        GL11.glVertex2f(0, IHeight);
 
        GL11.glTexCoord2f(1, 1); //BOTTOM RIGHT
        GL11.glVertex2f(IWidth, IHeight);
 
        GL11.glTexCoord2f(1, 0); //TOP RIGHT
        GL11.glVertex2f(IWidth, 0);
 
        GL11.glTexCoord2f(0, 0); //TOP LEFT
        GL11.glVertex2f(0, 0);
 
        GL11.glEnd();
        GL11.glPopMatrix();
        
        GL11.glDeleteTextures(TID);
    }
    private int LoadTexture(BufferedImage Img)
    {
        int BPP = 4;
        int[] Pixels = new int[Img.getWidth() * Img.getHeight()];
        Img.getRGB(0, 0, Img.getWidth(), Img.getHeight(), Pixels, 0, Img.getWidth());
        ByteBuffer Buffer = BufferUtils.createByteBuffer(Img.getWidth() * Img.getHeight() * BPP);
        for (int Y = 0; Y < Img.getHeight();  Y++)
        {
            for (int X = 0; X < Img.getWidth();  X++)
            {
                int Pixel = Pixels[Y * Img.getWidth() + X];
                Buffer.put((byte) ((Pixel >> 16) & 0xFF));
                Buffer.put((byte) ((Pixel >> 8) & 0xFF));
                Buffer.put((byte) (Pixel & 0xFF));
                Buffer.put((byte) ((Pixel >> 24) & 0xFF));
            }
        }
        Buffer.flip();
        int TID = GL11.glGenTextures();
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, TID);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_CLAMP);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
        GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA8, Img.getWidth(), Img.getHeight(), 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, Buffer);
 
        return TID;
    }
}