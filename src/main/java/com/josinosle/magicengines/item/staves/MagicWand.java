package com.josinosle.magicengines.item.staves;

/**
 * Abstract class for staves to follow
 *
 * @author josinosle
 */
public class MagicWand extends AbstractStave {

    /**
     * Mana efficiency when casting using a stave, represented as a decimal mana cost multiplier
     */
    private final float manaEfficiency = 0.1F;

    /**
     * Constructor for wands
     *
     * @param properties        Properties for the wand item
     */
    public MagicWand(Properties properties) {
        super(properties);
    }

}
