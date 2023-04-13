package net.sirtage.sbw.vp;

import org.lwjgl.opengl.GL11;

public class VisualApi {
    public static void prepareGLL() {
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(GL11.GL_BLEND);
    }

    public static void endGLL() {
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        GL11.glDisable(GL11.GL_BLEND);
    }

    public static void drawLine(double x, double y, double z, double ex, double ey, double ez) {
        GL11.glVertex3d(x, y, z);
        GL11.glVertex3d(ex, ey, ez);
    }

    public static void setupLine(float width, MColor color) {
        GL11.glLineWidth(width);
        GL11.glColor4f(color.r, color.g, color.b, color.a);
    }
}
