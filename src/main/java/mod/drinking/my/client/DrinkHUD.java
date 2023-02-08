package mod.drinking.my.client;

import com.mojang.blaze3d.systems.RenderSystem;
import mod.drinking.my.sipcount.PlayerSipsProvider;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import net.minecraft.resources.ResourceLocation;
import mod.drinking.my.DrinkingMod;
import net.minecraft.client.gui.GuiComponent;

public class DrinkHUD {
    private static final ResourceLocation FILLED_THIRST = new ResourceLocation(DrinkingMod.MODID,
            "textures/drinks/filled_thirst.png");
    private static final ResourceLocation EMPTY_THIRST = new ResourceLocation(DrinkingMod.MODID,
            "textures/drinks/empty_thirst.png");
    public static final IGuiOverlay HUD_DRINK = ((gui, poseStack, partialTick, width, height) -> {
        int x = width / 2;
        int y = height;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, EMPTY_THIRST);
        for(int i = 0; i < 10; i++) {
            GuiComponent.blit(poseStack,x - 94 + (i * 9), y - 54,0,0,12,12,
                    12,12);
        }

        int thirst = 3;

        RenderSystem.setShaderTexture(0, FILLED_THIRST);
        for(int i = 0; i < 10; i++) {
            if (ClientSipData.getPlayerSips() > i) {
                GuiComponent.blit(poseStack, x - 94 + (i * 9), y - 54, 0, 0, 12, 12,
                        12, 12);
            } else {
                break;
            }
        }
    });
}