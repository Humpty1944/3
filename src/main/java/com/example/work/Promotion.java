package com.example.work;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
/***
 *Промоакция
 *id – идентификатор промоакции, натуральное число
 * name – название промоакции, строка
 * description – описание промоакции, строка
 * prizes – возможные призы в промоакции, список объектов типа “Приз”
 * participants – участники промоакции, список объектов типа “Участник”
 *
 */

@Entity
public class Promotion {
    private @Id @GeneratedValue Long id;
    private String name;
    private String description ;

    @ManyToMany
    @CollectionTable(name="listOfPrizes")
    private List<Prize> prizes  ;

    @ManyToMany
    @CollectionTable(name="listOfParticipants")
    private List<Participant> participants   ;

    Promotion(String name, String description, List<Prize> prizes, List<Participant> participants ){
       this.name = name;
       this.description = description;
       this.prizes=prizes;
       this.participants = participants;

    }

    public Promotion() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Prize> getPrizes() {
        return prizes;
    }

    public void setPrizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }
    public void setParticipantsOne(Participant participants) {
        this.participants.add(participants);
    }
    public void setPrizesOne(Prize prizes) {
        this.prizes.add(prizes);
    }
}
