package supercoder79.ecotones.client;

import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.registry.Registry;
import supercoder79.ecotones.Ecotones;

public final class ClientPacketHandler {
    public static void init() {
        ClientSidePacketRegistry.INSTANCE.register(Ecotones.WORLD_TYPE, (packetContext, data) -> {
            ClientSidedServerData.isInEcotonesWorld = data.readBoolean();
            ClientRegistrySyncState.state = ClientRegistrySyncState.State.NONE;

            long hashedSeed = data.readLong();
            if (ClientSidedServerData.isInEcotonesWorld) {
                FogHandler.init(hashedSeed);
            }

            boolean isDedicated = data.readBoolean();

            if (isDedicated) {
                ClientWorld world = MinecraftClient.getInstance().world;

                if (world != null) {
                    Ecotones.REGISTRY = world.getRegistryManager().get(Registry.BIOME_KEY);
                    ClientRegistrySyncState.state = ClientRegistrySyncState.State.SYNCED;
                } else {
                    ClientRegistrySyncState.state = ClientRegistrySyncState.State.WAITING;
                }
            }
        });
    }
}
