package com.example.work;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
/***
 * Участник
 * id – идентификатор промоакции, натуральное число
 * name – название промоакции, строка
 * description – описание промоакции, строка
 * prizes – возможные призы в промоакции, список объектов типа “Приз”
 * participants – участники промоакции, список объектов типа “Участник”
 */
public class Participant {
    private @Id @GeneratedValue String id;
    private String name;


    Participant(String name){this.name=name;}

    public Participant() {

    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
