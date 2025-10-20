package com.caleb.system_event.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_block")
public class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "begin_time", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant begin;
    @Column(name = "end_time", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant end;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    public Block() {

    }

    public Block(Long id, Instant begin, Instant end) {
        this.id = id;
        this.begin = begin;
        this.end = end;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getBegin() {
        return begin;
    }

    public void setBegin(Instant begin) {
        this.begin = begin;
    }

    public Instant getEnd() {
        return end;
    }

    public void setEnd(Instant end) {
        this.end = end;
    }

    public Activity getActivity() {
        return activity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return Objects.equals(id, block.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
