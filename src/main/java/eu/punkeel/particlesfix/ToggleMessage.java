package eu.punkeel.particlesfix;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ToggleMessage implements IMessage, IMessageHandler<ToggleMessage, IMessage> {
    private boolean allowed;

    @Override
    public void toBytes(ByteBuf byteBuf) {
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        allowed = buf.readBoolean();
    }

    @Override
    public IMessage onMessage(ToggleMessage packet, MessageContext ctx) {
        ParticlesFix.setDisabledByServer(packet.allowed);

        System.out.println("Particles Fix was toggled " + (packet.allowed ? "ON" : "OFF") + " by the remote server.");
        return null;
    }
}