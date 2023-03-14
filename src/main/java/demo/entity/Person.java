package demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Person")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String age;
    @Column(nullable = false)
    //I could use enums here, but I think they are risky and should be used very carefully
    private String gender;

    @Override
    public String toString() {
        return "Name: " + this.name + "/ Age:" + this.age + "/ Gender:" + this.gender;
    }
}
