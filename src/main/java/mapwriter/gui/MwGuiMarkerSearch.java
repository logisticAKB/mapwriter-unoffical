package mapwriter.gui;

import mapwriter.Mw;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;

public class MwGuiMarkerSearch extends GuiScreen {

    private final Mw mw;
    private final GuiScreen parentScreen;
    private MwGuiTextField textField = null;
    private MwGuiMarkerSlot markerSlot = null;

    public MwGuiMarkerSearch(GuiScreen parentScreen, Mw mw) {
        this.mw = mw;
        this.parentScreen = parentScreen;
    }

    public void initGui() {
        this.markerSlot = new MwGuiMarkerSlot(this, this.mc, this.mw);

        this.textField = new MwGuiTextField(this.fontRendererObj, (this.width / 2) - 108, this.height - 28, 200, 20);
        this.textField.setMaxStringLength(20);
        this.textField.setFocused(true);
    }

    protected void keyTyped(char c, int k) {
        super.keyTyped(c, k);
        this.textField.textboxKeyTyped(c, k);
        this.markerSlot.updateMarkerList(this.textField.getText());
    }

    protected void mouseClicked(int x, int y, int btn) {
        super.mouseClicked(x, y, btn);
        this.textField.mouseClicked(x, y, btn);
    }

    public void updateScreen()
    {
        super.updateScreen();
        this.textField.updateCursorCounter();
    }

    public void drawScreen(int mouseX, int mouseY, float f) {
        this.drawDefaultBackground();
        this.markerSlot.drawScreen(mouseX, mouseY, f);
        this.drawCenteredString(this.fontRendererObj, I18n.format("mw.gui.mwgui.markers"), this.width / 2, 10, 0xffffff);
        this.textField.drawTextBox();
        super.drawScreen(mouseX, mouseY, f);
    }
}
