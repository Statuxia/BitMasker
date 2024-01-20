package me.statuxia.example;

import lombok.Getter;
import me.statuxia.mask.MaskMaster;

/**
 * Represents the state of a tutorial, extending the MaskMaster class and implementing the Masked<Long> interface.
 */
@Getter
final class TutorialState extends MaskMaster {

    private long join;
    private long menu;
    private long profile;
    private long statistics;
    private Long settings;

    /**
     * Default constructor for TutorialState. Initializes fields without specifying a mask.
     *
     * @throws IllegalAccessException if field initialization encounters an issue.
     */
    public TutorialState() throws IllegalAccessException {
    }

    /**
     * Constructor for TutorialState allowing customization of onlyPrimitive.
     *
     * @param onlyPrimitive a boolean indicating whether only primitive types should be masked.
     * @throws IllegalAccessException if field initialization encounters an issue.
     */
    public TutorialState(boolean onlyPrimitive) throws IllegalAccessException {
        super(onlyPrimitive);
    }

    /**
     * Constructor for TutorialState allowing customization of the initial mask value.
     *
     * @param mask the initial mask value.
     * @throws IllegalAccessException if field initialization encounters an issue.
     */
    public TutorialState(long mask) throws IllegalAccessException {
        super(mask);
    }

    /**
     * Constructor for TutorialState allowing customization of the initial mask value and onlyPrimitive.
     *
     * @param mask          the initial mask value.
     * @param onlyPrimitive a boolean indicating whether only primitive types should be masked.
     * @throws IllegalAccessException if field initialization encounters an issue.
     */
    public TutorialState(long mask, boolean onlyPrimitive) throws IllegalAccessException {
        super(mask, onlyPrimitive);
    }
}

