package com.nagas.backend.repository;

import com.nagas.backend.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    Optional<Application> findByUserId(Integer id);

   @Modifying
   @Transactional
   @Query(value = "UPDATE student_application SET sub_id=?1 WHERE id=?2",
           nativeQuery = true)
    void saveSubscribeId(int subId, Integer id);

    List<Application> findBySubId(Integer subId);
}
