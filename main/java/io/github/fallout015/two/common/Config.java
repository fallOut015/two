package io.github.fallout015.two.common;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;

public class Config {
	public static final ClientConfig CLIENT;
	public static final ForgeConfigSpec CLIENT_SPEC;
	
	static {
		final Pair<ClientConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ClientConfig::new);
		CLIENT_SPEC = specPair.getRight();
		CLIENT = specPair.getLeft();
	}
	
	public static boolean pamTextureBloodBlade = true;
	public static boolean disableStainedWoodenCrafting = false;
	public static boolean disableGlazedBricksCrafting = false;
	public static boolean disableAdditionalCaves = false;
	public static boolean disableModifiedCaves = false;
	public static boolean disableNewNetherOres = false;
	public static boolean disableNewOverworldOres = false;
	public static boolean disableNewEndOres = false;
	public static boolean renameVanillaItems = true;
	public static boolean disableDreamcatchersInVillages = false;
	public static boolean enableThrowingArrows = false;
	public static boolean disableDaggerSneakAttack = false;
	public static boolean bombArrowsObeyMobGriefing = false;
	public static boolean disableInspectionSpectacleDescriptions = false;
	public static boolean enablePickaxeTips = false;
	public static boolean disableTeleporterCrafting = false;
	public static boolean disableUndergroundRegions = false;
	public static boolean disableUndergroundBiomes = false;
	public static boolean disableAdobeFreezing = false;
	
	public static void bakeConfig() {
		pamTextureBloodBlade = CLIENT.PAM_TEXTURE_BLOOD_BLADE.get();
		disableInspectionSpectacleDescriptions = CLIENT.DISABLE_INSPECTION_SPECTACLES_DESCRIPTIONS.get();
		enablePickaxeTips = CLIENT.ENABLE_PICKAXE_TIPS.get();
		
		disableStainedWoodenCrafting = CLIENT.DISABLE_STAINED_WOODEN_CRAFTING.get();
		disableGlazedBricksCrafting = CLIENT.DISABLE_GLAZED_BRICK_CRAFTING.get();
		
		enableThrowingArrows = CLIENT.ENABLE_THROWING_ARROWS.get();
	}
	
	public static class ClientConfig {
		// Cosmetic
		public final BooleanValue PAM_TEXTURE_BLOOD_BLADE;
		public final BooleanValue DISABLE_INSPECTION_SPECTACLES_DESCRIPTIONS;
		public final BooleanValue ENABLE_PICKAXE_TIPS;
		// Crafting
		public final BooleanValue DISABLE_STAINED_WOODEN_CRAFTING;
		public final BooleanValue DISABLE_GLAZED_BRICK_CRAFTING;
//		public final BooleanValue disableTeleporterCrafting;
		// World Gen
//		public final BooleanValue disableAdditionalCaves;
//		public final BooleanValue disableModifiedCaves;
//		public final BooleanValue disableNewNetherOres;
//		public final BooleanValue disableNewOverworldOres;
//		public final BooleanValue disableNewEndOres;
//		public final BooleanValue disableUndergroundRegions;
//		public final BooleanValue disableUndergroundBiomes;
		// Vanilla Alterations
//		public final BooleanValue renameVanillaItems;
		// Structures
//		public final BooleanValue disableDreamcatchersInVillages;
		// Misc
		public final BooleanValue ENABLE_THROWING_ARROWS;
//		public final BooleanValue disableDaggerSneakAttack;
//		public final BooleanValue bombArrowsObeyMobGriefing;
//		public final BooleanValue disableAdobeFreezing;
		
		public ClientConfig(ForgeConfigSpec.Builder builder) {
			builder.push("Cosmetic");
			this.PAM_TEXTURE_BLOOD_BLADE = builder.comment("Use Pam's texture for the Blood Venom Blade.").translation("two.config.pamTextureBloodBlade").define("PAM_TEXTURE_BLOOD_BLADE", true);
			this.DISABLE_INSPECTION_SPECTACLES_DESCRIPTIONS = builder.comment("Disable the paragraph descriptions for items when wearing the Inspection Spectacles.").translation("two.config.disableInspectionSpectaclesDescriptions").define("DISABLE_INSPECTION_SPECTACLES_DESCRIPTIONS", false);
			this.ENABLE_PICKAXE_TIPS = builder.comment("Enable pickaxe tooltips for what ores you can mine.").translation("two.config.enablePickaxeTips").define("ENABLE_PICKAXE_TIPS", false);
			builder.pop();
			builder.push("Crafting");
			this.DISABLE_STAINED_WOODEN_CRAFTING = builder.comment("Disable the crafting recipes for everything related to Stained Wooden Planks. In case you have another mod that uses it.").translation("two.config.disableStainedWoodenCrafting").define("DISABLE_STAINED_WOODEN_CRAFTING", false);
			this.DISABLE_GLAZED_BRICK_CRAFTING = builder.comment("Disable the crafting recipes for everything related to Glazed Bricks. In case you have another mod that uses it.").translation("two.config.disableGlazedBricksCrafting").define("DISABLE_GLAZED_BRICKS_CRAFTING", false);
			builder.pop();
			builder.push("Misc");
			this.ENABLE_THROWING_ARROWS = builder.comment("Enable pressing Q to throw arrows like darts.").translation("two.config.enableThrowingArrows").define("ENABLE_THROWING_ARROWS", false);
			builder.pop();
//			builder.push("category");
//			this.anInt = builder.comment("anInt usage description").translation(Two.class.getAnnotation(Mod.class).value() + ".config." + "anInt").defineInRange("anInt", 10, 0, 100);
//			builder.pop();
		}
	}
}