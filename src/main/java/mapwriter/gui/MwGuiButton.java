package mapwriter.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import org.lwjgl.opengl.GL11;

public class MwGuiButton extends GuiButton {

    public MwGuiButton(int id, int xPosition, int yPosition) {
        super(id, xPosition, yPosition, 20, 20, "");
    }

    public void drawButton(Minecraft mc, int mouseX, int mouseY)
    {
        if (this.visible)
        {
            mc.getTextureManager().bindTexture(GuiButton.buttonTextures);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            boolean flag = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
            int k = 106;
            if (flag)
            {
                k += this.height;
            }

            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, k, this.width, this.height);
        }
    }
}
