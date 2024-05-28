package com.api.epacontrol.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "TAB_NOTIFICACAO")
public class Notificacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String content;

    @ManyToOne
    private UsersModel recipient;

    public Notificacao() {}

    public Notificacao(String content, UsersModel recipient) {
        this.content = content;
        this.recipient = recipient;
    }

    // Getters and Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UsersModel getRecipient() {
        return recipient;
    }

    public void setRecipient(UsersModel recipient) {
        this.recipient = recipient;
    }
}
