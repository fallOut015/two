package two.client.gui.screen.inventory;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import two.inventory.container.KnapsackContainer;

@OnlyIn(Dist.CLIENT)
public class KnapsackScreen extends ContainerScreen<KnapsackContainer> {
	private static final ResourceLocation GUI_TEXTURE = new ResourceLocation("minecraft", "textures/gui/container/generic_54.png");

	public KnapsackScreen(KnapsackContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
	    this.minecraft.getTextureManager().bindTexture(GUI_TEXTURE);
	    int i = (this.width - this.xSize) / 2;
	    int j = (this.height - this.ySize) / 2;
	    this.blit(i, j, 0, 0, this.xSize, this.ySize);
	}
	
	@Override
	public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
		this.renderBackground();
	    super.render(p_render_1_, p_render_2_, p_render_3_);
	    this.renderHoveredToolTip(p_render_1_, p_render_2_);
	}
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.font.drawString(this.title.getFormattedText(), 8.0F, 6.0F, 4210752);
	    this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, (float)(this.ySize - 96 + 2), 4210752);
	}
}