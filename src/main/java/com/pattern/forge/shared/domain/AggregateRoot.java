package com.pattern.forge.shared.domain;

import lombok.Getter;

@Getter
public class AggregateRoot<T extends ValueObject> extends Entity<T> {

    public AggregateRoot(T id) {
        super(id);
    }
}
