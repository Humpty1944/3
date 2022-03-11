package com.example.work;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/***
 * Приз
 *id – идентификатор приза, натуральное число
 * description – описание приза, строка
 */
@Entity
public class Prize {
    private @Id @GeneratedValue String id;
    private String description;

    Prize(String description){
        this.description =description;
    }

    public Prize() {

    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
