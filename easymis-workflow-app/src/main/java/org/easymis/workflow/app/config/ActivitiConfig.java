package org.easymis.workflow.app.config;

import javax.sql.DataSource;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.history.HistoryLevel;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * 使用Java类完成配置文件
 *
 */

@Configuration
public class ActivitiConfig {
	@Autowired
	private DataSource dataSource;
    @Autowired
    private PlatformTransactionManager transactionManager;
	@Autowired
	private ResourcePatternResolver resourceLoader;

	/**
	 * 这里不阐述28张表每个的含义，主要有ACT_HI_*(历史信息表)、ACT_RU_*(运行时信息表)、ACT_ID_*(身份信息类)、ACT_RE_*(静态资源类)
	 * 
	 * @return
	 */
	@Bean
    public SpringProcessEngineConfiguration processEngineConfiguration() {
        SpringProcessEngineConfiguration configuration = new SpringProcessEngineConfiguration();
		// 执行工作流对应的数据源
		configuration.setDataSource(dataSource);
		// 是否自动创建流程引擎表
		configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
		configuration.setAsyncExecutorActivate(false);
        // 流程历史等级
        configuration.setHistoryLevel(HistoryLevel.FULL);
        // 流程图字体
        configuration.setActivityFontName("宋体");
        configuration.setAnnotationFontName("宋体");
        configuration.setLabelFontName("宋体");
        configuration.setTransactionManager(transactionManager);
		return configuration;
	}

	@Bean
	public ProcessEngine processEngine() {
		return processEngineConfiguration().buildProcessEngine();
	}

	@Bean
	public RepositoryService repositoryService() {
		return processEngine().getRepositoryService();
	}

	@Bean
	public RuntimeService runtimeService() {
		return processEngine().getRuntimeService();
	}
	@Bean
	public HistoryService historyService() {
		return processEngine().getHistoryService();
	}
	@Bean
	public TaskService taskService() {
		return processEngine().getTaskService();
	}
	@Bean
	public IdentityService identityService() {
		return processEngine().getIdentityService();
	}
	@Bean
	public FormService formService() {
		return processEngine().getFormService();
	}
}
