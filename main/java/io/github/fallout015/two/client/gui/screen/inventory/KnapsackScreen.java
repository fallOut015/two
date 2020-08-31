package io.github.fallout015.two.client.gui.screen.inventory;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import io.github.fallout015.two.inventory.container.KnapsackContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class KnapsackScreen extends ContainerScreen<KnapsackContainer> {
	private static final ResourceLocation KNAPSACK_GUI_TEXTURE = new ResourceLocation("minecraft", "textures/gui/container/generic_54.png");

	public KnapsackScreen(KnapsackContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
		
		this.ySize = 150;
	}

	@Override
	protected void func_230450_a_(MatrixStack p_230450_1_, float p_230450_2_, int p_230450_3_, int p_230450_4_) {
	    RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
	    this.field_230706_i_.getTextureManager().bindTexture(KNAPSACK_GUI_TEXTURE);
	    int i = (this.field_230708_k_ - this.xSize) / 2;
	    int j = (this.field_230709_l_ - this.ySize) / 2;
	    this.func_238474_b_(p_230450_1_, i, j, 0, 0, this.xSize, 53);
	    this.func_238474_b_(p_230450_1_, i, j + 53, 0, 126, this.xSize, 96);
	}
	
	@Override
	public void func_230430_a_(MatrixStack p_230430_1_, int p_230430_2_, int p_230430_3_, float p_230430_4_) {
		this.func_230446_a_(p_230430_1_);
		super.func_230430_a_(p_230430_1_, p_230430_2_, p_230430_3_, p_230430_4_);
		this.func_230459_a_(p_230430_1_, p_230430_2_, p_230430_3_);
	}
}