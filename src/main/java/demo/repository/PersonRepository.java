package demo.repository;

import demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT p FROM Person p WHERE (:name is null or p.name = :name) and (:age is null"
            + " or p.age = :age) and (:gender is null or p.gender = :gender)")
    List<Person> findByNameOrAgeOrGender(
            @Param("name") String name,
            @Param("age") String age,
            @Param("gender") String gender
    );
}
