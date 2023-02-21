package com.example.rabbitmq.jpa;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 健康计划--也就是方案执行的结果
 * @author chenger
 */
@Entity
@Getter
@Setter
public class HealthPlan {

    /**
     *
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 疾病项目id
     */
    private Long projectId;
    /**
     * 患者号
     */
    private String xlPatientId;
    /**
     * 管理组的id
     */
    private Long nurseGroupId;
    /**
     * 　疾病id
     *   ps:多病种改造后此属性不一定有值，慎用
     */
    private Long diseaseId;
    /**
     * 患者与管理组方案组的关联表，此字段废弃
     */
    private Long relationId;
    /**
     * 终端类型 TerminalType
     */
    private Integer terminalType;
    /**
     * 执行类型 HealthPlanExecutorType
     */
    private Integer exeType;
    /**
     * 版本号
     */
    private String version;
    /**
     * 计划名称
     */
    private String name;
    /**
     * 患者方案
     */
    private String patientSchemeVersion;
    /**
     * 类型名称 1随访 2用药 3运动 4饮食 + 模板名称
     * 改为
     */
    private String type;
    /**
     * 类型 1随访 2用药 3运动 4饮食 + 模板id
     */
    private String typeNum;
    /**
     * 模板id
     */
    private Long templateId;
    /**
     * 状态  HealthPlanStatus
     */
    private String status;
    /**
     * 状态英文
     */
    private String statusCode;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 计划开始执行时间
     */
    private String viewableTime;
    /**
     * 计划执行时间
     */
    private String executeTime;
    /**
     * 计划过期时间
     */
    private String overdueTime;
    /**
     * 执行人名
     */
    private String exeUser;
    /**
     * 执行人
     */
    private Long userId;
    /**
     * 执行时间
     */
    private String finishTime;
    /**
     * 最后更新时间
     */
    private String updateTime;
    /**
     * 随访结果HealthPlanResultType
     */
    private String result;
    /**
     * 随访结果类型
     */
    private String resultType;
    /**
     * 依据
     */
    private String evidence;
    /**
     * 建议
     */
    private String propose;
    /**
     * 调整方案后产生的方案版本
     */
    private String planVersion;
    /**
     * 方案调整id
     */
    private Long schemeComfirmId;
    //v2版本用
    /**
     * 计划所属于的方案的id
     */
    private Long schemeId;
    /**
     * 患者的病例号
     */
    private String pid;

    /**
     * 遵循状态
     */
    private boolean obeyStatus;

    private String fileIds;
    /**
     * 访问类型
     */
    private String accessType;
    /**
     * 计划执行内容
     */
    private String planContent;
    /**
     * 多病种id
     */
    private String diseaseIds;
    /**
     * 上报渠道 1、D端 2、C端
     */
    private Integer reportChannel;

    private String subType;

}
