package com.parzivail.pswg.container;

import com.parzivail.pswg.Resources;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class SwgSpecies
{
	public static final ArrayList<Identifier> SPECIES = new ArrayList<>();

	public static final Identifier SPECIES_HUMAN = register(Resources.identifier("human"));
	public static final Identifier SPECIES_TOGRUTA_M = register(Resources.identifier("togruta_m"));

	private static Identifier register(Identifier species)
	{
		SPECIES.add(species);
		return species;
	}
}
