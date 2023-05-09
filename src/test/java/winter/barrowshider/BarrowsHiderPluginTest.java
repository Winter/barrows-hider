
package winter.barrowshider;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

@SuppressWarnings("unchecked")
public class BarrowsHiderPluginTest {
	public static void main(String... args) throws Exception {
		ExternalPluginManager.loadBuiltin(BarrowsHiderPlugin.class);
		RuneLite.main(args);
	}
}