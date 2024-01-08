package dev.rodrigomuller.DTO;

import java.util.Objects;

public class Metadata {
    private int total;
    private int limit;
    private int offset;

    public Metadata(int total, int limit, int offset) {
        this.total = total;
        this.limit = limit;
        this.offset = offset;
    }

    public int getTotal() {
        return total;
    }

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Metadata metadata)) return false;
        return getTotal() == metadata.getTotal() && getLimit() == metadata.getLimit() && getOffset() == metadata.getOffset();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTotal(), getLimit(), getOffset());
    }

    @Override
    public String toString() {
        return "Metadata{" +
                "total=" + total +
                ", limit=" + limit +
                ", offset=" + offset +
                '}';
    }
}
