package com.huseyin.ToDoListApp.tasks.repository;


import com.huseyin.ToDoListApp.tasks.model.entity.Tasks;
import com.huseyin.ToDoListApp.tasks.model.enumeration.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Tasks,Long> {

    Iterable<Tasks> findByUserId(Long userid);

    @Query("SELECT t FROM Tasks t WHERE t.user.id=:userid AND t.status = :status")
    Iterable<Tasks> findByUserIdAndStatus(Long userid, TaskStatus status);

    Optional<Tasks> findByUserIdAndId(Long userid, Long id);

    @Query("SELECT t FROM Tasks t WHERE t.user.id=:userid AND t.id = :id AND t.status = :status")
    Optional<Tasks> findByUserIdAndIdAndStatus(Long userid, Long id,TaskStatus status);

    @Modifying
    @Query("DELETE FROM Tasks t WHERE t.user.id = :userid")
    int deleteAllByUserId(@Param(value = "userid") Long userid);

    @Modifying
    @Query("DELETE FROM Tasks t WHERE t.user.id =:userid AND t.id = :id")
    int deleteByUserIdAndId(@Param(value = "userid")Long userid,@Param(value = "id") Long id);


    @Modifying
    @Query("UPDATE Tasks t SET t.status =:status WHERE t.user.id = :userid AND  t.id = :id")
    int updateStatusById(@Param("userid") Long userid,@Param("id") Long id,@Param("status") TaskStatus tasksStatus);


}
