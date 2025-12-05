package com.pattern.forge.shared.domain;

import java.util.Objects;

public class Entity<T extends ValueObject> implements DomainModel {

    private final T id;

    public Entity(T id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Entity<?> entity = (Entity<?>) o;
        return Objects.equals(id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
