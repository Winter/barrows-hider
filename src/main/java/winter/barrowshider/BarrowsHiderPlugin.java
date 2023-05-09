package winter.barrowshider;

import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.Renderable;
import net.runelite.client.callback.Hooks;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Barrows Hider", 
	description = "Hide some or all of another players barrows brothers", 
	tags = {"hider,barrows,barrows hider" }
)
public class BarrowsHiderPlugin extends Plugin {
	@Inject
	private Client client;

	@Inject
	private BarrowsHiderConfig config;

	@Inject
	private Hooks hooks;

	@Override
	protected void startUp() throws Exception {
		hooks.registerRenderableDrawListener(this::RenderListener);
	}

	@Override
	protected void shutDown() throws Exception {
		hooks.unregisterRenderableDrawListener(this::RenderListener);
	}

	boolean RenderListener(Renderable renderable, boolean drawingUI) {
		// Check if our renderable is an NPC
		if (renderable instanceof NPC) {
			NPC npc = (NPC) renderable;
			int npcId = npc.getId();

			// If they aren't interacting, then they can render
			if (!npc.isInteracting()) {
				return true;
			}

			// Check if they are something we should consider 
			if (!ShouldRenderNpc(npcId)) {
				Actor actor = npc.getInteracting();

				if (actor == null) {
					return true;
				}

				if (actor != client.getLocalPlayer()) {
					return false;
				}
			}
		}

		return true;
	}

	boolean ShouldRenderNpc(int npcId) {
		if (npcId == NpcID.AHRIM_THE_BLIGHTED && config.hideAhrimBrother()) {
			return false;
		} else if (npcId == NpcID.DHAROK_THE_WRETCHED && config.hideDharokBrother()) {
			return false;
		} else if (npcId == NpcID.GUTHAN_THE_INFESTED && config.hideGuthanBrother()) {
			return false;
		} else if (npcId == NpcID.KARIL_THE_TAINTED && config.hideKarilBrother()) {
			return false;
		} else if (npcId == NpcID.TORAG_THE_CORRUPTED && config.hideToragBrother()) {
			return false;
		} else if (npcId == NpcID.VERAC_THE_DEFILED && config.hideVeracBrother()) {
			return false;
		}

		return true;
	}

	@Provides
	BarrowsHiderConfig provideConfig(ConfigManager configManager) {
		return configManager.getConfig(BarrowsHiderConfig.class);
	}
}
