package winter.barrowshider;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("barrowshider")
public interface BarrowsHiderConfig extends Config
{
	@ConfigSection(
		name = "Barrows Brothers", 
		description = "Toggle specific barrows brothers", 
		position = 0, 
		closedByDefault = false
	)
	String barrowsBrothersCategory = "barrowsBrothersCategory";

	@ConfigItem(
		keyName = "hideAhrimBrother", 
		name = "Hide Ahrim the Blighted", 
		description = "Hide another players Ahrim", 
		position = 0, 
		section = barrowsBrothersCategory
	)
	default boolean hideAhrimBrother() {
		return true;
	}

	@ConfigItem(
		keyName = "hideDharokBrother", 
		name = "Hide Dharok the Wretched", 
		description = "Hide another players Dhakrok", 
		position = 1, 
		section = barrowsBrothersCategory
	)
	default boolean hideDharokBrother() {
		return true;
	}

	@ConfigItem(
		keyName = "hideGuthanBrother", 
		name = "Hide Guthan the Infested", 
		description = "Hide another players Guthan", 
		position = 2, 
		section = barrowsBrothersCategory
	)
	default boolean hideGuthanBrother() {
		return true;
	}

	@ConfigItem(
		keyName = "hideKarilBrother", 
		name = "Hide Karil the Tainted", 
		description = "Hide another players Karil", 
		position = 3, 
		section = barrowsBrothersCategory
	)
	default boolean hideKarilBrother() {
		return true;
	}

	@ConfigItem(
		keyName = "hideToragBrother", 
		name = "Hide Torag the Corrupted", 
		description = "Hide another players Torag", 
		position = 4, 
		section = barrowsBrothersCategory
	)
	default boolean hideToragBrother() {
		return true;
	}

	@ConfigItem(
		keyName = "hideVeracBrother", 
		name = "Hide Verac the Defiled", 
		description = "Hide another players Verac", 
		position = 5, 
		section = barrowsBrothersCategory
	)
	default boolean hideVeracBrother() {
		return true;
	}
}
