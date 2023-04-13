package net.sirtage.sbw.vp;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;


public class Esp {

    public static float lineW = 1f;

    public static void drawBox3D(double x, double y, double z, double width, double height, MColor color) {

        double posX = x - width / 2;
        double posY = y - height;
        double posZ = z - width / 2;

        GL11.glPushMatrix();
        VisualApi.prepareGLL();
        VisualApi.setupLine(lineW, color);

        GL11.glBegin(1);

        GL11.glVertex3d(posX, posY, posZ);
        GL11.glVertex3d(posX, posY + height, posZ);
        GL11.glVertex3d(posX, posY, posZ);
        GL11.glVertex3d(posX + width, posY, posZ);
        GL11.glVertex3d(posX, posY, posZ);
        GL11.glVertex3d(posX, posY, posZ + width);
        GL11.glVertex3d(posX + width, posY, posZ + width);
        GL11.glVertex3d(posX + width, posY, posZ);
        GL11.glVertex3d(posX + width, posY, posZ + width);
        GL11.glVertex3d(posX, posY, posZ + width);
        GL11.glVertex3d(posX + width, posY, posZ);
        GL11.glVertex3d(posX + width, posY + height, posZ);
        GL11.glVertex3d(posX, posY, posZ + width);
        GL11.glVertex3d(posX, posY + height, posZ + width);
        GL11.glVertex3d(posX + width, posY, posZ + width);
        GL11.glVertex3d(posX + width, posY + height, posZ + width);
        GL11.glVertex3d(posX, posY + height, posZ);
        GL11.glVertex3d(posX + width, posY + height, posZ);
        GL11.glVertex3d(posX, posY + height, posZ);
        GL11.glVertex3d(posX, posY + height, posZ + width);
        GL11.glVertex3d(posX + width, posY + height, posZ + width);
        GL11.glVertex3d(posX + width, posY + height, posZ);
        GL11.glVertex3d(posX + width, posY + height, posZ + width);
        GL11.glVertex3d(posX, posY + height, posZ + width);

        GL11.glEnd();
        VisualApi.endGLL();
        GL11.glPopMatrix();
    }
    
    public static void drawBox3D(double x, double y, double z, double width, double height, MColor color, float lineWidth) {

        double posX = x - width / 2;
        double posY = y - height;
        double posZ = z - width / 2;

        GL11.glPushMatrix();
        VisualApi.prepareGLL();
        VisualApi.setupLine(lineWidth, color);

        GL11.glBegin(1);

        GL11.glVertex3d(posX, posY, posZ);
        GL11.glVertex3d(posX, posY + height, posZ);
        GL11.glVertex3d(posX, posY, posZ);
        GL11.glVertex3d(posX + width, posY, posZ);
        GL11.glVertex3d(posX, posY, posZ);
        GL11.glVertex3d(posX, posY, posZ + width);
        GL11.glVertex3d(posX + width, posY, posZ + width);
        GL11.glVertex3d(posX + width, posY, posZ);
        GL11.glVertex3d(posX + width, posY, posZ + width);
        GL11.glVertex3d(posX, posY, posZ + width);
        GL11.glVertex3d(posX + width, posY, posZ);
        GL11.glVertex3d(posX + width, posY + height, posZ);
        GL11.glVertex3d(posX, posY, posZ + width);
        GL11.glVertex3d(posX, posY + height, posZ + width);
        GL11.glVertex3d(posX + width, posY, posZ + width);
        GL11.glVertex3d(posX + width, posY + height, posZ + width);
        GL11.glVertex3d(posX, posY + height, posZ);
        GL11.glVertex3d(posX + width, posY + height, posZ);
        GL11.glVertex3d(posX, posY + height, posZ);
        GL11.glVertex3d(posX, posY + height, posZ + width);
        GL11.glVertex3d(posX + width, posY + height, posZ + width);
        GL11.glVertex3d(posX + width, posY + height, posZ);
        GL11.glVertex3d(posX + width, posY + height, posZ + width);
        GL11.glVertex3d(posX, posY + height, posZ + width);

        GL11.glEnd();
        VisualApi.endGLL();
        GL11.glPopMatrix();
    }
    
    public static void autoBox3D(double x, double y, double z, double width, double height, MColor color) {
    	double renderPosX = Minecraft.getMinecraft().getRenderManager().viewerPosX;
        double renderPosY = Minecraft.getMinecraft().getRenderManager().viewerPosY;
        double renderPosZ = Minecraft.getMinecraft().getRenderManager().viewerPosZ;

        double xPos = x - renderPosX;
        double yPos = y - renderPosY;
        double zPos = z - renderPosZ;
        
        drawBox3D(xPos, yPos, zPos, width, height, color);
    }
    
    public static void autoBox3D(Entity ent, MColor color) {
    	double renderPosX = Minecraft.getMinecraft().getRenderManager().viewerPosX;
        double renderPosY = Minecraft.getMinecraft().getRenderManager().viewerPosY;
        double renderPosZ = Minecraft.getMinecraft().getRenderManager().viewerPosZ;

        double xPos = ent.lastTickPosX - renderPosX;
        double yPos = ent.lastTickPosY + ent.height - renderPosY;
        double zPos = ent.lastTickPosZ - renderPosZ;
        
        
        drawBox3D(xPos, yPos, zPos, ent.width, ent.height, color);
    }
    
    public static void drawTracer(double x, double y, double z, double ex, double ey, double ez, MColor color, float lineWidth) {

        GL11.glPushMatrix();
        VisualApi.prepareGLL();
        VisualApi.setupLine(lineWidth, color);

        GL11.glBegin(1);

        GL11.glVertex3d(x, y, z);
        GL11.glVertex3d(ex, ey, ez);

        GL11.glEnd();
        VisualApi.endGLL();
        GL11.glPopMatrix();
    }
    
    public static void autoTracer(double x, double y, double z, double ex, double ey, double ez, MColor color, float lineWidth) {
    	double renderPosX = Minecraft.getMinecraft().getRenderManager().viewerPosX;
        double renderPosY = Minecraft.getMinecraft().getRenderManager().viewerPosY;
        double renderPosZ = Minecraft.getMinecraft().getRenderManager().viewerPosZ;

        double xPos = x - renderPosX;
        double yPos = y - renderPosY;
        double zPos = z - renderPosZ;
        
        double exPos = ex - renderPosX;
        double eyPos = ey - renderPosY;
        double ezPos = ez - renderPosZ;
        drawTracer(xPos, yPos, zPos, exPos, eyPos, ezPos, color, lineWidth);
    }
    
    public static void drawText(String text, double x, double y, double z, double scale, MColor col,boolean shadow) {
    	
    	//VisualApi.prepareGLL();
    	
    	double renderPosX = Minecraft.getMinecraft().getRenderManager().viewerPosX;
        double renderPosY = Minecraft.getMinecraft().getRenderManager().viewerPosY;
        double renderPosZ = Minecraft.getMinecraft().getRenderManager().viewerPosZ;

        double xPos = x - renderPosX;
        double yPos = y - renderPosY;
        double zPos = z - renderPosZ;
        
        
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(false);
    	
    	GlStateManager.pushMatrix();

        GlStateManager.enableBlend();
        //GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.translate(xPos, yPos, zPos);
        GlStateManager.color(col.r, col.g, col.b, col.a);

        GlStateManager.rotate(-Minecraft.getMinecraft().getRenderManager().playerViewY, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(Minecraft.getMinecraft().getRenderManager().playerViewX, 1.0f, 0.0f, 0.0f);

        GlStateManager.scale(-scale/25, -scale/25, scale/25);
        if (shadow) {
            Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(text, -Minecraft.getMinecraft().fontRendererObj.getStringWidth(text)/2, 0,0);
        }else{
        	Minecraft.getMinecraft().fontRendererObj.drawString(text, -Minecraft.getMinecraft().fontRendererObj.getStringWidth(text)/2, 0,0);
        }

        GlStateManager.color(1,1,1);

        GlStateManager.disableBlend();

        GlStateManager.popMatrix();
        
        //VisualApi.endGLL();
        
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(true);
    }
}
