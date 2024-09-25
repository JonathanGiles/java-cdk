package com.azure.provisioning;

import com.azure.provisioning.expressions.Expression;
import com.azure.provisioning.expressions.BicepSyntax;
import com.azure.provisioning.expressions.BicepTypeMapping;
import com.azure.provisioning.primitives.BicepValueReference;

public abstract class BicepValueBase {
    private BicepValueKind kind = BicepValueKind.UNSET;
    private Expression expression = null;
    private final BicepValueReference self;
    private BicepValueReference source = null;
    private boolean isOutput = false;
    private boolean isRequired = false;
    private boolean isSecure = false;

    protected BicepValueBase(BicepValueReference self) {
        this.self = self;
    }

    protected BicepValueBase(BicepValueReference self, Object literal) {
        this(self);
        this.kind = BicepValueKind.LITERAL;
    }

    protected BicepValueBase(BicepValueReference self, Expression expression) {
        this(self);
        this.kind = BicepValueKind.EXPRESSION;
        this.expression = expression;
    }

    public BicepValueKind getKind() {
        return kind;
    }

    public void setKind(BicepValueKind kind) {
        this.kind = kind;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public BicepValueReference getSelf() {
        return self;
    }

    public BicepValueReference getSource() {
        return source;
    }

    public boolean isOutput() {
        return isOutput;
    }

    public void setOutput(boolean isOutput) {
        this.isOutput = isOutput;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }

    public boolean isSecure() {
        return isSecure;
    }

    public void setSecure(boolean isSecure) {
        this.isSecure = isSecure;
    }

    public boolean isEmpty() {
        return kind == BicepValueKind.UNSET;
    }

    protected Expression getBicepType() {
        return BicepSyntax.Types.OBJECT;
    }

    protected abstract Object getLiteralValue();

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

    @Override
    public String toString() {
        switch (kind) {
            case UNSET:
                return "<BicepValue: Unset>";
            case LITERAL:
                return "<BicepValue: " + getLiteralValue() + ">";
            default:
                return "<BicepValue: " + compile() + ">";
        }
    }

    public Expression compile() {
        return BicepTypeMapping.toBicep(this);
    }
}