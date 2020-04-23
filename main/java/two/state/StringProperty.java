package two.state;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import net.minecraft.state.Property;

public class StringProperty extends Property<String> {
	private static final Set<String> VALUES = Set.of("oak_planks", "white_wool");
	
	protected StringProperty(String name, Class<String> valueClass) {
		super(name, valueClass);
	}

	@Override
	public Collection<String> getAllowedValues() {
		return VALUES;
	}
	@Override
	public Optional<String> parseValue(String value) {
		return Optional.of(value);
	}
	@Override
	public String getName(String value) {
		return value;
	}
	
	public static StringProperty create(String name) {
		return new StringProperty(name, String.class);
	}
}