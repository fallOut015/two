package two.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TopHatModel<T extends LivingEntity> extends AgeableModel<T> {
	public ModelRenderer brim;
    public ModelRenderer top;

    public TopHatModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.top = new ModelRenderer(this, 0, 13);
        this.top.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.top.func_228301_a_(-4.0F, -6.0F, -4.0F, 8, 6, 8, 0.0F);
        this.brim = new ModelRenderer(this, 0, 0);
        this.brim.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.brim.func_228301_a_(-6.0F, 0.0F, -6.0F, 12, 1, 12, 0.0F);
        this.brim.addChild(this.top);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

	@Override
	protected Iterable<ModelRenderer> func_225602_a_() {
		return ImmutableList.of();
	}

	@Override
	protected Iterable<ModelRenderer> func_225600_b_() {
		return ImmutableList.of(this.brim);
	}

	@Override
	public void func_225597_a_(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
		// void stuff for updating model rotations and whatnot.
	}
}
