package com.sp.command.client;

import com.mojang.brigadier.CommandDispatcher;
import com.sp.compat.modmenu.ConfigStuff;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.text.Text;

public class TesterCommand {
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher, CommandRegistryAccess registryAccess) {
        dispatcher.register(
                ClientCommandManager.literal("tester")
                        .then(ClientCommandManager.literal("rays")
                                .executes(context -> {
                                    ConfigStuff.enableVolumetricLight = !ConfigStuff.enableVolumetricLight;
                                    ConfigStuff.write("spb-revamped");
                                    context.getSource().sendFeedback(Text.literal("Volumetric Lights (Rays) set to: " + ConfigStuff.enableVolumetricLight));
                                    return 1;
                                })
                        )
                        .then(ClientCommandManager.literal("lights")
                                .executes(context -> {
                                    ConfigStuff.enableShadows = !ConfigStuff.enableShadows;
                                    ConfigStuff.write("spb-revamped");
                                    context.getSource().sendFeedback(Text.literal("Shadows (Lights) set to: " + ConfigStuff.enableShadows));
                                    return 1;
                                })
                        )
                        .then(ClientCommandManager.literal("vhs")
                                .executes(context -> {
                                    ConfigStuff.enableVhsEffect = !ConfigStuff.enableVhsEffect;
                                    ConfigStuff.enableVhsEffectInTheBackrooms = ConfigStuff.enableVhsEffect;
                                    ConfigStuff.write("spb-revamped");
                                    context.getSource().sendFeedback(Text.literal("VHS Effect set to: " + ConfigStuff.enableVhsEffect));
                                    return 1;
                                })
                        )
                        .then(ClientCommandManager.literal("fog")
                                .executes(context -> {
                                    ConfigStuff.enableLevel1Fog = !ConfigStuff.enableLevel1Fog;
                                    ConfigStuff.write("spb-revamped");
                                    context.getSource().sendFeedback(Text.literal("Level 1 Fog set to: " + ConfigStuff.enableLevel1Fog));
                                    return 1;
                                })
                        )
        );
    }
}
