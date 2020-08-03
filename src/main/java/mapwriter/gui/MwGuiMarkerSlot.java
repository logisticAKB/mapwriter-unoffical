package mapwriter.gui;

import mapwriter.Mw;
import mapwriter.map.Marker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.Sys;

import java.util.ArrayList;
import java.util.List;

public class MwGuiMarkerSlot extends GuiSlot {

    private Minecraft mc;
    private Mw mw;

    private int mouseX = 0;
    private int mouseY = 0;

    private final GuiScreen parentScreen;

    public List<Marker> markerList;
    public List<GuiButton> buttons = new ArrayList<GuiButton>();
    public List<Integer> buttonId = new ArrayList<Integer>();

    public MwGuiMarkerSlot(GuiScreen parentScreen, Minecraft mc, Mw mw) {
        super(mc, parentScreen.width, parentScreen.height, 16, parentScreen.height - 32, 25);

        this.parentScreen = parentScreen;

        this.mw = mw;
        this.mc = mc;
        this.markerList = mw.markerManager.visibleMarkerList;

        updateMarkerList("");
    }

    public void updateMarkerList(String text) {
        this.buttons.clear();
        this.buttonId.clear();
        for (int i = 0; i < this.markerList.size(); i++) {
            Marker marker = this.markerList.get(i);
            if ((text.equals("") || marker.name.toLowerCase().contains(text.toLowerCase())) && marker.dimension == this.mw.playerDimension) {
                this.buttons.add(new GuiButton(400 + i, 0, 0, this.markerList.get(i).name));
                this.buttonId.add(i);
            }
        }
    }

    @Override
    protected int getSize() {
        return this.buttons.size();
    }

    @Override
    protected void elementClicked(int i, boolean doubleClicked, int x, int y) {
        this.mw.markerManager.selectedMarker = this.markerList.get(this.buttonId.get(i));

        this.mw.mwGui.mapView.setViewCentreScaled(
                this.mw.markerManager.selectedMarker.x,
                this.mw.markerManager.selectedMarker.z,
                0
        );

        this.mw.mwGui.backFromMarkerSearch = true;
        this.mw.setTextureSize();
        this.mc.displayGuiScreen(this.mw.mwGui);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float f) {
        this.mouseX = mouseX;
        this.mouseY = mouseY;
        super.drawScreen(mouseX, mouseY, f);
    }

    @Override
    protected boolean isSelected(int p_148131_1_) {
        return false;
    }

    @Override
    protected void drawBackground() {

    }

    @Override
    protected void drawSlot(int i, int x, int y, int i4, Tessellator tessellator, int i5, int i6) {
        GuiButton button = buttons.get(i);
        button.xPosition = x;
        button.yPosition = y;
        button.drawButton(this.mc, this.mouseX, this.mouseY);
    }
}
