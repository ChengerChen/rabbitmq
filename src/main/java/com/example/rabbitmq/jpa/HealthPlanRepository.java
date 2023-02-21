package com.example.rabbitmq.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Chenger
 * @description
 * @date 2021/7/14 上午10:27
 */
@Repository
public interface HealthPlanRepository extends JpaRepository<HealthPlan, Long> {

    /**
     * 根据version查询
     * @param version
     * @return
     */
    List<HealthPlan> findByVersion(String version);
}
