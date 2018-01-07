package eu.punkeel.particlesfix;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

import java.io.IOException;

@Mod(
        modid = "pk_particlesfix",
        clientSideOnly = true,
        acceptedMinecraftVersions = "",
        acceptableRemoteVersions = "*"
)
public class ParticlesFix extends DummyModContainer {
    private static boolean serverHatesThisMod = false;

    static void setDisabledByServer(boolean state) {
        serverHatesThisMod = state;
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) throws IOException {
        MinecraftForge.EVENT_BUS.register(this);
        SimpleNetworkWrapper network = NetworkRegistry.INSTANCE.newSimpleChannel("ParticlesFix");
        network.registerMessage(ToggleMessage.class, ToggleMessage.class, 0, Side.CLIENT);
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onAttack(AttackEntityEvent event) {
        if (Minecraft.getMinecraft().isSingleplayer())
            return;

        if (serverHatesThisMod)
            return;

        // This even is not useful client side, except to display particles on hit (the particles that may be wrong)
        event.setCanceled(true);
    }
}