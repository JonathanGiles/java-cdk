package com.azure.provisioning;

import com.azure.provisioning.implementation.bicep.syntax.Expression;
import com.azure.provisioning.implementation.bicep.syntax.BicepSyntax;
import com.azure.provisioning.implementation.bicep.syntax.BicepTypeMapping;
import com.azure.provisioning.primitives.BicepValueReference;

/**
 * Represents the value of a property that could be a literal .NET value, a
 * Bicep expression, or it could be unset.
 */
public abstract class BicepValueBase {
    /**
     * The kind of this value (a literal value, an expression, or it's unset).
     */
    private BicepValueKind kind = BicepValueKind.UNSET;

    /**
     * The Bicep expression associated with this value.
     */
    private Expression expression = null;

    /**
     * Tracks who defined this property.
     */
    private final BicepValueReference self;

    /**
     * Tracks who set this property.
     */
    private BicepValueReference source = null;

    /**
     * Indicates whether this is an output-only property.
     */
    private boolean isOutput = false;

    /**
     * Indicates whether this property is required.
     */
    private boolean isRequired = false;

    /**
     * Indicates whether this property wraps a secure value.
     */
    private boolean isSecure = false;

    /**
     * Constructs a new BicepValueBase with the specified reference.
     *
     * @param self the reference to the Bicep value
     */
    protected BicepValueBase(BicepValueReference self) {
        this.self = self;
    }

    /**
     * Constructs a new BicepValueBase with the specified reference and literal value.
     *
     * @param self the reference to the Bicep value
     * @param literal the literal value
     */
    protected BicepValueBase(BicepValueReference self, Object literal) {
        this(self);
        this.kind = BicepValueKind.LITERAL;
    }

    /**
     * Constructs a new BicepValueBase with the specified reference and expression.
     *
     * @param self the reference to the Bicep value
     * @param expression the Bicep expression
     */
    protected BicepValueBase(BicepValueReference self, Expression expression) {
        this(self);
        this.kind = BicepValueKind.EXPRESSION;
        this.expression = expression;
    }

    /**
     * Gets the kind of this value.
     *
     * @return the kind of this value
     */
    public BicepValueKind getKind() {
        return kind;
    }

    /**
     * Sets the kind of this value.
     *
     * @param kind the kind to set
     */
    public void setKind(BicepValueKind kind) {
        this.kind = kind;
    }

    /**
     * Gets the Bicep expression associated with this value.
     *
     * @return the Bicep expression
     */
    public Expression getExpression() {
        return expression;
    }

    /**
     * Sets the Bicep expression associated with this value.
     *
     * @param expression the Bicep expression to set
     */
    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    /**
     * Gets the reference to the Bicep value.
     *
     * @return the reference to the Bicep value
     */
    public BicepValueReference getSelf() {
        return self;
    }

    /**
     * Gets the reference to the source Bicep value.
     *
     * @return the reference to the source Bicep value
     */
    public BicepValueReference getSource() {
        return source;
    }

    /**
     * Checks if this is an output-only property.
     *
     * @return true if this is an output-only property, false otherwise
     */
    public boolean isOutput() {
        return isOutput;
    }

    /**
     * Sets whether this is an output-only property.
     *
     * @param isOutput true to set as output-only, false otherwise
     */
    public void setOutput(boolean isOutput) {
        this.isOutput = isOutput;
    }

    /**
     * Checks if this property is required.
     *
     * @return true if this property is required, false otherwise
     */
    public boolean isRequired() {
        return isRequired;
    }

    /**
     * Sets whether this property is required.
     *
     * @param isRequired true to set as required, false otherwise
     */
    public void setRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }

    /**
     * Checks if this property wraps a secure value.
     *
     * @return true if this property wraps a secure value, false otherwise
     */
    public boolean isSecure() {
        return isSecure;
    }

    /**
     * Sets whether this property wraps a secure value.
     *
     * @param isSecure true to set as secure, false otherwise
     */
    public void setSecure(boolean isSecure) {
        this.isSecure = isSecure;
    }

    /**
     * Indicates whether this value is empty or should be included in output.
     *
     * @return true if this value is empty, false otherwise
     */
    public boolean isEmpty() {
        return kind == BicepValueKind.UNSET;
    }

    /**
     * Gets the naive Bicep type of the value.
     *
     * @return the Bicep type of the value
     */
    public Expression getBicepType() {
        return BicepSyntax.Types.OBJECT;
    }

    /**
     * Gets the literal value when the kind is literal.
     *
     * @return the literal value
     */
    public abstract Object getLiteralValue();

    /**
     * Assigns a value to this property.
     *
     * @param source the source Bicep value to assign
     */
    public void assign(BicepValueBase source) {
        if (isOutput) {
            throw new IllegalStateException("Cannot assign to output value " + (self != null ? self.getPropertyName() : ""));
        }

        this.source = source != null ? source.getSelf() : null;
        this.kind = source != null ? source.getKind() : BicepValueKind.UNSET;
        this.expression = source != null ? source.getExpression() : null;
        this.isSecure = source != null && source.isSecure();

        if (kind == BicepValueKind.UNSET && this.source != null) {
            this.kind = BicepValueKind.EXPRESSION;
            this.expression = this.source.getReference();
        }
    }

    /**
     * Returns a string representation of this Bicep value.
     *
     * @return a string representation of this Bicep value
     */
    @Override
    public String toString() {
        switch (kind) {
            case UNSET:
                return "<BicepValueBase: Unset>";
            case LITERAL:
                return "<BicepValueBase: " + getLiteralValue() + ">";
            default:
                return "<BicepValueBase: " + compile() + ">";
        }
    }

    /**
     * Compiles this Bicep value to an expression.
     *
     * @return the compiled Bicep expression
     */
    public Expression compile() {
        return BicepTypeMapping.toBicep(this);
    }
}