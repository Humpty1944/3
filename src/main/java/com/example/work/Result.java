package com.example.work;
import javax.persistence.*;

/***
 *Результат проведения розыгрыша
 *
 *winner – объект типа “Участник”
 * prize – объект типа “Приз”
 */
@Entity
public class Result {
    private @Id @GeneratedValue String id;
    @OneToOne
    private Participant winner;
    @OneToOne
    private Prize prize;

    Result(Participant winner, Prize prize){
        this.winner=winner;
        this.prize=prize;
    }

    public Result() {

    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }

    public Participant getWinner() {
        return winner;
    }

    public void setWinner(Participant winner) {
        this.winner = winner;
    }

    public Prize getPrize() {
        return prize;
    }
}
