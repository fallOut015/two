package two.client.gui.screen.inventory;

import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.Tags;
import two.Two;
import two.inventory.container.UpholsteryTableContainer;
import two.item.ItemsTwo;
import two.util.SoundEventsTwo;

@OnlyIn(Dist.CLIENT)
public class UpholsteryTableScreen extends ContainerScreen<UpholsteryTableContainer> {
	private static final ResourceLocation GUI_TEXTURE = new ResourceLocation("two", "textures/gui/container/upholstery_table.png");
	
//	private ItemStack stacktop = ItemStack.EMPTY;
//	private ItemStack stackmiddle = ItemStack.EMPTY;
//	private ItemStack stackbottom = ItemStack.EMPTY;
//	private ItemStack stackoutput = ItemStack.EMPTY;
	
	private boolean showUsableIcons = true;
	private float field_214126_x;
	private int field_214128_z = 1;
	
	public static final Predicate<Item> PLANKS = item -> item.getTags().contains(ItemTags.PLANKS.getId());
	public static final Predicate<Item> WOOL = item -> item.getTags().contains(ItemTags.WOOL.getId());
	public static final Predicate<Item> GLASS = item -> item.getTags().contains(Tags.Items.GLASS.getId());
	public static final Predicate<Item> INGOTS = item -> item.getTags().contains(Tags.Items.INGOTS.getId());
	public static final Predicate<Item> STORAGE_BLOCKS = item -> item.getTags().contains(Tags.Items.STORAGE_BLOCKS.getId());
	
	public static final Predicate<Item> PLANKS_STORAGE_BLOCKS = item -> PLANKS.or(STORAGE_BLOCKS).test(item);
	public static final Predicate<Item> PLANKS_WOOL_STORAGE_BLOCKS = item -> PLANKS_STORAGE_BLOCKS.or(WOOL).test(item);

	public static enum Furniture {
		CHAIR       (ItemsTwo.CHAIR      , PLANKS_WOOL_STORAGE_BLOCKS, PLANKS_WOOL_STORAGE_BLOCKS, PLANKS_STORAGE_BLOCKS),
		EDGE_STOOL  (ItemsTwo.EDGE_STOOL , PLANKS_WOOL_STORAGE_BLOCKS, PLANKS_STORAGE_BLOCKS,      PLANKS_STORAGE_BLOCKS),
		ROUND_STOOL (ItemsTwo.ROUND_STOOL, PLANKS_WOOL_STORAGE_BLOCKS, PLANKS_STORAGE_BLOCKS,      PLANKS_STORAGE_BLOCKS),
		EDGE_TABLE  (ItemsTwo.EDGE_TABLE , PLANKS_STORAGE_BLOCKS     , PLANKS_STORAGE_BLOCKS,      PLANKS_STORAGE_BLOCKS),
		ROUND_TABLE (ItemsTwo.ROUND_TABLE, PLANKS_STORAGE_BLOCKS     , PLANKS_STORAGE_BLOCKS,      PLANKS_STORAGE_BLOCKS),
		CUPBOARD    (ItemsTwo.CUPBOARD   , PLANKS_STORAGE_BLOCKS     , INGOTS,                     PLANKS_STORAGE_BLOCKS),
		LAMP        (ItemsTwo.LAMP       , WOOL                      , GLASS     ,                 PLANKS_STORAGE_BLOCKS),
		BED         (ItemsTwo.BED        , WOOL                      , WOOL      ,                 PLANKS_STORAGE_BLOCKS),
		COUCH       (ItemsTwo.COUCH      , WOOL                      , WOOL      ,                 PLANKS_STORAGE_BLOCKS),
		SHELF       (ItemsTwo.SHELF      , PLANKS_STORAGE_BLOCKS     , PLANKS_STORAGE_BLOCKS,      PLANKS_STORAGE_BLOCKS);
		
		private Integer id;
		private Item item;
		private Predicate<Item> toppredicate;
		private Predicate<Item> middlepredicate;
		private Predicate<Item> bottompredicate;
		
		Furniture(Item item, Predicate<Item> toppredicate, Predicate<Item> middlepredicate, Predicate<Item> bottompredicate) {
			this.id = this.ordinal() + 1;
			this.item = item;
			this.toppredicate = toppredicate;
			this.middlepredicate = middlepredicate;
			this.bottompredicate = bottompredicate;
		}
		
		public Integer getID() {
			return this.id;
		}
		public Item getItem() {
			return this.item;
		}
		public Predicate<Item> getTopPredicate() {
			return this.toppredicate;
		}
		public Predicate<Item> getMiddlePredicate() {
			return this.middlepredicate;
		}
		public Predicate<Item> getBottomPredicate() {
			return this.bottompredicate;
		}
	}
	@Nullable
	private Furniture selectedFurniture = null;
	
	public UpholsteryTableScreen(UpholsteryTableContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
		screenContainer.setUpdate(this::update);
	}

	public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
		super.render(p_render_1_, p_render_2_, p_render_3_);
		this.renderHoveredToolTip(p_render_1_, p_render_2_);
	}
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.font.drawString(this.title.getFormattedText(), 8.0F, 4.0F, 4210752);
		this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, (float)(this.ySize - 96 + 2), 4210752);
	}
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		this.renderBackground();
		this.minecraft.getTextureManager().bindTexture(GUI_TEXTURE);
		int i = this.guiLeft;
		int j = this.guiTop;
		this.blit(i, j, 0, 0, this.xSize, this.ySize);
		Slot top = this.container.top();
		Slot middle = this.container.middle();
		Slot bottom = this.container.bottom();
		//Slot slot3 = this.container.output();
		if(selectedFurniture != null && !top.getHasStack())
			this.blit(i + top.xPos, j + top.yPos, this.xSize, (selectedFurniture.ordinal()) * 16, 16, 16);
		if(selectedFurniture != null && !middle.getHasStack())
			this.blit(i + middle.xPos, j + middle.yPos, this.xSize + 16, (selectedFurniture.ordinal()) * 16, 16, 16);
		if(selectedFurniture != null && !bottom.getHasStack())
			this.blit(i + bottom.xPos, j + bottom.yPos, this.xSize + 32, (selectedFurniture.ordinal()) * 16, 16, 16);

		int k = (int)(41.0F * this.field_214126_x);
		this.blit(i + 119, j + 13 + k, 232 + (this.showUsableIcons ? 0 : 12), 0, 12, 15);
		RenderHelper.func_227783_c_();
		IRenderTypeBuffer.Impl irendertypebuffer$impl = this.minecraft.func_228019_au_().func_228487_b_();
		MatrixStack matrixstack = new MatrixStack();
		matrixstack.func_227861_a_((double)(i + 139), (double)(j + 52), 0.0D);
		matrixstack.func_227862_a_(24.0F, -24.0F, 1.0F);
		matrixstack.func_227861_a_(0.5D, 0.5D, 0.5D);
		matrixstack.func_227862_a_(0.6666667F, -0.6666667F, -0.6666667F);
		irendertypebuffer$impl.func_228461_a_();
		if(this.showUsableIcons) {
			int i2 = i + 60;
			int k2 = j + 13;
			int i3 = this.field_214128_z + 10;

			for(int l = this.field_214128_z; l < i3; ++l) {
				int i1 = l - this.field_214128_z;
	            int j1 = i2 + i1 % 4 * 14;
	            int k1 = k2 + i1 / 4 * 14;
	            this.minecraft.getTextureManager().bindTexture(GUI_TEXTURE);
	            int yblittingstart = this.ySize;

	            this.blit(j1, k1, 14 * (l - 1), yblittingstart + (this.selectedFurniture != null && l == this.selectedFurniture.getID() ? 14 : 0), 14, 14);
	            this.renderMatrix(l, j1, k1);
			}
		}

		RenderHelper.func_227784_d_();
	}
	private void renderMatrix(int p_228190_1_, int p_228190_2_, int p_228190_3_) {
		MatrixStack matrixstack = new MatrixStack();
		matrixstack.func_227860_a_();
		matrixstack.func_227861_a_((double)((float)p_228190_2_ + 0.5F), (double)(p_228190_3_ + 16), 0.0D);
		matrixstack.func_227862_a_(6.0F, -6.0F, 1.0F);
		matrixstack.func_227861_a_(0.5D, 0.5D, 0.0D);
		matrixstack.func_227861_a_(0.5D, 0.5D, 0.5D);
		matrixstack.func_227862_a_(0.6666667F, -0.6666667F, -0.6666667F);
		IRenderTypeBuffer.Impl irendertypebuffer$impl = this.minecraft.func_228019_au_().func_228487_b_();
		matrixstack.func_227865_b_();
		irendertypebuffer$impl.func_228461_a_();
	}
	public boolean mouseClicked(double mousex, double mousey, int mousez) {
		if (this.showUsableIcons) {
			int i = this.guiLeft + 60;
			int j = this.guiTop + 13;
			int k = this.field_214128_z + 10;

			for(int l = this.field_214128_z; l < k; ++l) {
				int i1 = l - this.field_214128_z;
	            double d0 = mousex - (double)(i + i1 % 4 * 14);
	            double d1 = mousey - (double)(j + i1 / 4 * 14);
	            if (d0 >= 0.0D && d1 >= 0.0D && d0 < 14.0D && d1 < 14.0D) {
	            	switch(l) {
	            		case 1:
	            			this.selectedFurniture = Furniture.CHAIR;
	            			break;
	            		case 2:
	            			this.selectedFurniture = Furniture.EDGE_STOOL;
	            			break;
	            		case 3:
	            			this.selectedFurniture = Furniture.ROUND_STOOL;
	            			break;
	            		case 4:
	            			this.selectedFurniture = Furniture.EDGE_TABLE;
	            			break;
	            		case 5:
	            			this.selectedFurniture = Furniture.ROUND_TABLE;
	            			break;
	            		case 6:
	            			this.selectedFurniture = Furniture.CUPBOARD;
	            			break;
	            		case 7:
	            			this.selectedFurniture = Furniture.LAMP;
	            			break;
	            		case 8:
	            			this.selectedFurniture = Furniture.BED;
	            			break;
	            		case 9:
	            			this.selectedFurniture = Furniture.COUCH;
	            			break;
	            		case 10:
	            			this.selectedFurniture = Furniture.SHELF;
	            			break;
	            		default:
	            			this.selectedFurniture = null;
	            	}
	            	Minecraft.getInstance().getSoundHandler().play(SimpleSound.master(SoundEventsTwo.GUI_UPHOLSTERY_TABLE_SELECT_TEMPLATE, 1.0F));
	            	return true;
	            }
			}

			i = this.guiLeft + 119;
			j = this.guiTop + 9;
		}
		return super.mouseClicked(mousex, mousey, mousez);
	}
	protected boolean hasClickedOutside(double p1, double p3, int p5, int p6, int p7) {
		return p1 < (double) p5 || p3 < (double) p6 || p1 >= (double) (p5 + this.xSize) || p3 >= (double) (p6 + this.ySize);
	}
	private void update() {
		Two.LOGGER.info("update()");
		
		if(this.container.enchantItem(this.minecraft.player, this.selectedFurniture)) {
        	this.minecraft.playerController.sendEnchantPacket((this.container).windowId, this.selectedFurniture == null ? 0 : this.selectedFurniture.getID());
		}
		
//		this.stacktop = this.container.top().getStack();
//		this.stackmiddle = this.container.middle().getStack();
//		this.stackbottom = this.container.bottom().getStack();
//		this.stackoutput = this.container.output().getStack();
	}
}