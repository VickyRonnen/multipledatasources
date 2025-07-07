package org.example.spdemo.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository2 extends JpaRepository<Person, String> {

    @Procedure(name = "get_person_count", procedureName = "public.get_person_count")
    Integer getPersonCount();

    @Procedure(name = "get_person_count_2", procedureName = "schema1.get_person_count")
    Integer getPersonCount2();

}
