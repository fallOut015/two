package two.state;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import net.minecraft.state.Property;

public class StringProperty extends Property<String> {
	private static final Set<String> values = Set.of();
	
	protected StringProperty(String name, Class<String> valueClass) {
		super(name, valueClass);
	}

	@Override
	public Collection<String> getAllowedValues() {
		return values;
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
		values.add(name);
		return new StringProperty(name, String.class);
	}
}