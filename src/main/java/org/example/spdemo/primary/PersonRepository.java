package org.example.spdemo.primary;

import org.example.spdemo.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {

    @Procedure(name = "get_person_count",procedureName = "public.get_person_count")
    Integer getPersonCount();

    @Procedure(name = "get_person_count_2",procedureName = "schema1.get_person_count")
    Integer getPersonCount2();

    @Procedure(name = "get_person_count_3",procedureName = "")
    Integer getPersonCount3();
}
